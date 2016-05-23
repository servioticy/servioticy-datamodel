package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 23/05/16.
 */
public class NumberValue extends Value {
    @JsonProperty(Value.TYPE_NUMBER)
    private Number value;

    @Override
    @JsonGetter(Value.TYPE_NUMBER)
    public Object getValue() {
        return value;
    }

    @Override
    @JsonSetter(Value.TYPE_NUMBER)
    public void setValue(Object value) {
        this.value = (Number)value;
    }
}
