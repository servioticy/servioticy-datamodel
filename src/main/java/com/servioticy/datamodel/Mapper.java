package com.servioticy.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Created by alvaro on 29/04/16.
 */
public class Mapper {
    @JsonIgnore
    public static final ObjectMapper mapper = new ObjectMapper();
    @JsonIgnore
    public static final ObjectWriter writer = mapper.writer();
}
