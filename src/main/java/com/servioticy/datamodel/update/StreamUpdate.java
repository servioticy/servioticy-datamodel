package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.stream.Channel;
import com.servioticy.datamodel.stream.Stream;
import rx.Observable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alvaro Villalba (alvaro.villalba@bsc.es) on 23/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StreamUpdate extends Mapper{
    @JsonIgnore
    public static final ObjectReader jsonReader = jsonMapper.readerFor(StreamUpdate.class);
    @JsonIgnore
    public static final ObjectReader binReader = binMapper.readerFor(StreamUpdate.class);

    private Map<String, Object> values;
    private Offset offset;

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    @JsonIgnore
    public boolean isCompatible(Stream stream){
        Map<String, Channel> channels = stream.getChannels();
        Map<String, Object> values = getValues();
        Boolean compatible = Observable.from(values.entrySet())
                .map(valueEntry -> {
                    String channelId = valueEntry.getKey();
                    if (!channels.containsKey(channelId)){
                        return false;
                    }

                    switch (channels.get(channelId).getType()){
                        case Value.TYPE_BOOLEAN:
                            if (!(valueEntry.getValue() instanceof Boolean)){
                                return false;
                            }
                            break;
                        case Value.TYPE_NUMBER:
                            if (!(valueEntry.getValue() instanceof Number)){
                                return false;
                            }
                            break;
                        case Value.TYPE_STRING:
                            if (!(valueEntry.getValue() instanceof String)){
                                return false;
                            }
                            break;
                        case Value.TYPE_BOOLEAN_ARRAY:
                            if (!(valueEntry.getValue() instanceof List)){
                                return false;
                            }
                            List<Object> boolList = (List<Object>) valueEntry.getValue();
                            Boolean isBoolArray = Observable.from(boolList)
                                    .map(bool -> bool instanceof Boolean)
                                    .filter(isBool -> !isBool)
                                    .toBlocking()
                                    .firstOrDefault(true);
                            if (!isBoolArray){
                                return false;
                            }
                            break;
                        case Value.TYPE_NUMBER_ARRAY:
                            if (!(valueEntry.getValue() instanceof List)){
                                return false;
                            }
                            List<Object> numList = (List<Object>) valueEntry.getValue();
                            Boolean isNumArray = Observable.from(numList)
                                    .map(num -> num instanceof Number)
                                    .filter(isNum -> !isNum)
                                    .toBlocking()
                                    .firstOrDefault(true);
                            if (!isNumArray){
                                return false;
                            }
                            break;
                        case Value.TYPE_STRING_ARRAY:
                            if (!(valueEntry.getValue() instanceof List)){
                                return false;
                            }
                            List<Object> stringList = (List<Object>) valueEntry.getValue();
                            Boolean isStringArray = Observable.from(stringList)
                                    .map(strg -> strg instanceof String)
                                    .filter(isString -> !isString)
                                    .toBlocking()
                                    .firstOrDefault(true);
                            if (!isStringArray){
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                    return true;
                })
                .filter(_compatible -> !_compatible)
                .toBlocking()
                .firstOrDefault(true);
        return compatible;
    }

    @JsonIgnore
    public boolean isFromOutside(){
        Offset offset = getOffset();
        return offset.getSourcePartId() == offset.getStreamPartId() && offset.getSourcePartOffset() == offset.getStreamPartOffset();
    }

    @JsonIgnore
    public StoreUpdate toStoreUpdate(Stream stream) {
        StoreUpdate storeUpdate = new StoreUpdate();
        Map<String, Value> storeValues = new HashMap<>();

        for (Map.Entry<String, Channel> channelEntry: stream.getChannels().entrySet()){
            Value value = null;
            switch (channelEntry.getValue().getType()){
                case Value.TYPE_BOOLEAN:
                    value = new BooleanValue();
                    break;
                case Value.TYPE_NUMBER:
                    value = new NumberValue();
                    break;
                case Value.TYPE_STRING:
                    value = new StringValue();
                    break;
                case Value.TYPE_BOOLEAN_ARRAY:
                    value = new BooleanArrayValue();
                    break;
                case Value.TYPE_NUMBER_ARRAY:
                    value = new NumberArrayValue();
                    break;
                case Value.TYPE_STRING_ARRAY:
                    value = new StringArrayValue();
                    break;
                default:
                    return null;
            }
            value.setValue(getValues().get(channelEntry.getKey()));
            storeValues.put(channelEntry.getKey(), value);
        }
        storeUpdate.setOffset(getOffset());
        storeUpdate.setValues(storeValues);

        return storeUpdate;
    }
}
