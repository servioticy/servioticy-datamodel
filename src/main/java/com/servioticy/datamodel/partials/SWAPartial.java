package com.servioticy.datamodel.partials;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.servioticy.datamodel.sensorupdate.SensorUpdate;

/**
 * Created by alvaro on 15/04/16.
 */
public class SWAPartial {
    @JsonIgnore
    public static final ObjectReader reader = new ObjectMapper().reader(SWAPartial.class);
    @JsonIgnore
    public static final ObjectWriter writer = new ObjectMapper().writer();
    @JsonProperty("u")
    private SensorUpdate sensorUpdate;
    @JsonProperty("m")
    private Long minTimestamp;
    @JsonProperty("c")
    private int count;

    public SWAPartial(){

    }

    public SWAPartial(SensorUpdate sensorUpdate, Long minTimestamp, int count){
        this.sensorUpdate = sensorUpdate;
        this.minTimestamp = minTimestamp;
        this.count = count;
    }

    @JsonGetter("u")
    public SensorUpdate getSensorUpdate() {
        return sensorUpdate;
    }

    @JsonSetter("u")
    public void setSensorUpdate(SensorUpdate sensorUpdate) {
        this.sensorUpdate = sensorUpdate;
    }

    @JsonGetter("m")
    public Long getMinTimestamp() {
        return minTimestamp;
    }

    @JsonSetter("m")
    public void setMinTimestamp(Long minTimestamp) {
        this.minTimestamp = minTimestamp;
    }

    @JsonGetter("c")
    public int getCount() {
        return count;
    }

    @JsonSetter("c")
    public void setCount(int count) {
        this.count = count;
    }
}
