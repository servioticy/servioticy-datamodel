package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 23/05/16.
 */
public class BooleanArrayValue extends Value {
    @JsonProperty(Value.TYPE_BOOLEAN_ARRAY)
    private List<Boolean> value;

    @Override
    @JsonGetter(Value.TYPE_BOOLEAN_ARRAY)
    public Object getValue() {
        return value;
    }

    @Override
    @JsonSetter(Value.TYPE_BOOLEAN_ARRAY)
    public void setValue(Object value) {
        this.value = (List<Boolean>) value;
    }
}
