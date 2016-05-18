package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.UpdateDescriptor;

import java.util.Map;

/**
 * Created by Álvaro Villalba <alvaro.villalba@bsc.es> on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Update extends Mapper {
    @JsonIgnore
    public static final ObjectReader reader = mapper.reader(Update.class);
    private String streamId;
    private Map<String, Object> channels;
//    private Map<String, Object> metadata;
    private Offset offset;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public Map<String, Object> getChannels() {
        return channels;
    }

    public void setChannels(Map<String, Object> channels) {
        this.channels = channels;
    }

//    public Map<String, Object> getMetadata() {
//        return metadata;
//    }
//
//    public void setMetadata(Map<String, Object> metadata) {
//        this.metadata = metadata;
//    }


    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }
}
