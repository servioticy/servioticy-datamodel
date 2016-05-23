package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 23/05/16.
 */
public class NumberArrayValue extends Value {
    @JsonProperty(Value.TYPE_NUMBER_ARRAY)
    private List<Number> value;

    @Override
    @JsonGetter(Value.TYPE_NUMBER_ARRAY)
    public Object getValue() {
        return value;
    }

    @Override
    @JsonSetter(Value.TYPE_NUMBER_ARRAY)
    public void setValue(Object value) {
        this.value = (List<Number>)value;
    }
}
