package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.stream.Channel;
import com.servioticy.datamodel.stream.Stream;

import java.util.Map;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Update extends Mapper {
    @JsonIgnore
    public static final ObjectReader jsonReader = jsonMapper.readerFor(Update.class);
    @JsonIgnore
    public static final ObjectReader binReader = binMapper.readerFor(Stream.class);
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
        for (Map.Entry<String, Object> valueEntry: values.entrySet()){
            String channelId = valueEntry.getKey();
            if (!channels.containsKey(channelId)){
                return false;
            }
            Channel channel = channels.get(channelId);
            Object value = valueEntry.getValue();
            switch (channel.getType()){
                case Channel.TYPE_BOOLEAN:
                    if (!(value instanceof Boolean)){
                        return false;
                    }
                    break;
                case Channel.TYPE_NUMBER:
                    if (!(value instanceof Number)){
                        return false;
                    }
                    break;
                case Channel.TYPE_STRING:
                    if (!(value instanceof String)){
                        return false;
                    }
                    break;
                // TODO GeoJSON
                default:
                    return false;
            }
        }
        for (Map.Entry<String, Channel> channelEntry: channels.entrySet()){
            String channelId = channelEntry.getKey();
            if (!values.containsKey(channelId)){
                return false;
            }
        }
        return true;
    }
}
