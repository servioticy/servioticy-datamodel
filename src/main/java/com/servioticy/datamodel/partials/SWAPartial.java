package com.servioticy.datamodel.partials;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.sensorupdate.SensorUpdate;

/**
 * Created by Álvaro Villalba <alvaro.villalba@bsc.es> on 15/04/16.
 */
public class SWAPartial extends Mapper {
    @JsonIgnore
    public static final ObjectReader reader = mapper.reader(SWAPartial.class);
    @JsonProperty("u")
    private SensorUpdate sensorUpdate;
    @JsonProperty("m")
    private Long minTimestamp;
    @JsonProperty("c")
    private int count;
    @JsonProperty("ckv")
    private double countKalmanValue;
    @JsonProperty("cke")
    private double countKalmanError;

    public SWAPartial(){

    }

    public SWAPartial(SensorUpdate sensorUpdate, Long minTimestamp, int count, double countKalmanValue,
                      double countKalmanError){
        this.sensorUpdate = sensorUpdate;
        this.minTimestamp = minTimestamp;
        this.count = count;
        this.countKalmanValue = countKalmanValue;
        this.countKalmanError = countKalmanError;
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

    public static ObjectReader getReader() {
        return reader;
    }

    @JsonGetter("ckv")
    public Double getCountKalmanValue() {
        return countKalmanValue;
    }

    @JsonSetter("ckv")
    public void setCountKalmanValue(double countKalmanValue) {
        this.countKalmanValue = countKalmanValue;
    }

    @JsonGetter("cke")
    public Double getCountKalmanError() {
        return countKalmanError;
    }

    @JsonSetter("cke")
    public void setCountKalmanError(Double countKalmanError) {
        this.countKalmanError = countKalmanError;
    }
}
