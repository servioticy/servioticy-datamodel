package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 23/05/16.
 */
public class StringValue extends Value {
    @JsonProperty(Value.TYPE_STRING)
    private String value;

    @Override
    @JsonGetter(Value.TYPE_STRING)
    public Object getValue() {
        return value;
    }

    @Override
    @JsonSetter(Value.TYPE_STRING)
    public void setValue(Object value) {
        this.value = (String)value;
    }
}
