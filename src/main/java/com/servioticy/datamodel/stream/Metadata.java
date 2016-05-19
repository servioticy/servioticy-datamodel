package com.servioticy.datamodel.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
public class Metadata extends Channel {
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @JsonIgnore
    public Number getValueNumber(){
        return (Number) this.value;
    }

    @JsonIgnore
    public boolean getValueBoolean(){
        return (Boolean) this.value;
    }

    @JsonIgnore
    public String getValueString(){
        return (String) this.value;
    }

    // TODO
//    @JsonIgnore
//    public GeoJSON getValueString(){
//        return (GeoJSON) this.value;
//    }
}
