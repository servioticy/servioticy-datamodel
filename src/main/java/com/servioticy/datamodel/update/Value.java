package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 23/05/16.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="")
@JsonSubTypes({
        @JsonSubTypes.Type(value=BooleanValue.class, name= Value.TYPE_BOOLEAN),
        @JsonSubTypes.Type(value=BooleanArrayValue.class, name= Value.TYPE_BOOLEAN_ARRAY),
        @JsonSubTypes.Type(value=NumberValue.class, name= Value.TYPE_NUMBER),
        @JsonSubTypes.Type(value=NumberArrayValue.class, name= Value.TYPE_NUMBER_ARRAY),
        @JsonSubTypes.Type(value=StringValue.class, name= Value.TYPE_STRING),
        @JsonSubTypes.Type(value=StringArrayValue.class, name= Value.TYPE_STRING_ARRAY),
        @JsonSubTypes.Type(value=GeoJsonValue.class, name= Value.TYPE_GEOJSON),
        @JsonSubTypes.Type(value=GeoJsonValue.class, name= Value.TYPE_GEOJSON_ARRAY)
})
public abstract class Value {
    @JsonIgnore
    public static final String TYPE_NUMBER = "number";
    @JsonIgnore
    public static final String TYPE_BOOLEAN = "boolean";
    @JsonIgnore
    public static final String TYPE_STRING = "string";
    @JsonIgnore
    public static final String TYPE_GEOJSON = "geojson";
    @JsonIgnore
    public static final String TYPE_NUMBER_ARRAY = "number_array";
    @JsonIgnore
    public static final String TYPE_BOOLEAN_ARRAY = "boolean_array";
    @JsonIgnore
    public static final String TYPE_STRING_ARRAY = "string_array";
    @JsonIgnore
    public static final String TYPE_GEOJSON_ARRAY = "geojson_array";

    private String type;

    public abstract Object getValue();
    public abstract void setValue(Object value);

    public String getType() {
        switch (type){
            case TYPE_NUMBER:
            case TYPE_BOOLEAN:
            case TYPE_STRING:
            case TYPE_GEOJSON:
            case TYPE_NUMBER_ARRAY:
            case TYPE_BOOLEAN_ARRAY:
            case TYPE_STRING_ARRAY:
            case TYPE_GEOJSON_ARRAY:
                return type;
            default:
                return null;
        }
    }

    public void setType(String type) {
        switch (type){
            case TYPE_NUMBER:
            case TYPE_BOOLEAN:
            case TYPE_STRING:
            case TYPE_GEOJSON:
            case TYPE_NUMBER_ARRAY:
            case TYPE_BOOLEAN_ARRAY:
            case TYPE_STRING_ARRAY:
            case TYPE_GEOJSON_ARRAY:
                this.type = type;
                break;
            default:
                this.type = null;
        }
    }
}
