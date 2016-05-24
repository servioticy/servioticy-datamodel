package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.stream.Channel;
import com.servioticy.datamodel.stream.Stream;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreUpdate extends Mapper {
    @JsonIgnore
    public static final ObjectReader jsonReader = jsonMapper.readerFor(StoreUpdate.class);
    @JsonIgnore
    public static final ObjectReader binReader = binMapper.readerFor(Stream.class);
    private Map<String, Value> values;
    private Offset offset;

    public Map<String, Value> getValues() {
        return values;
    }

    public void setValues(Map<String, Value> values) {
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
        Map<String, Value> values = getValues();
        Boolean compatible = Observable.from(values.entrySet())
                .map(valueEntry -> {
                    String channelId = valueEntry.getKey();
                    if (!channels.containsKey(channelId)){
                        return false;
                    }
                    Channel channel = channels.get(channelId);
                    String updateType = valueEntry.getValue().getType();
                    if (!(updateType.equals(channel.getType()) )){
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
    public Map<String, Object> getSimpleValues(){
        Map<String, Object> values = new HashMap<>();
        for (Map.Entry<String, Value> valueEntry: getValues().entrySet()){
            values.put(valueEntry.getKey(), valueEntry.getValue().getValue());
        }
        return values;
    }

    @JsonIgnore
    public StreamUpdate toStreamUpdate(){
        StreamUpdate update = new StreamUpdate();
        update.setValues(getSimpleValues());
        update.setOffset(getOffset());
        return update;
    }
}
