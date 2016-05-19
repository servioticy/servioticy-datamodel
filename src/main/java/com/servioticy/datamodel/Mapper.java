package com.servioticy.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 29/04/16.
 */
public class Mapper {
    @JsonIgnore
    public static final ObjectMapper jsonMapper = new ObjectMapper();
    @JsonIgnore
    public static final ObjectMapper binMapper = new ProtobufMapper();
    @JsonIgnore
    public static final ObjectWriter jsonWriter = jsonMapper.writer();
    @JsonIgnore
    public static final ObjectWriter binWriter = binMapper.writer();
    @JsonIgnore
    public String writeValueAsString() throws JsonProcessingException {
        return jsonWriter.writeValueAsString(this);
    }
    @JsonIgnore
    public byte[] writeValueAsBytes() throws JsonProcessingException {
        return binWriter.writeValueAsBytes(this);
    }
}
