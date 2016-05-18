package com.servioticy.datamodel.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Álvaro Villalba <alvaro.villalba@bsc.es> on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Channel {
    @JsonIgnore
    public static final String TYPE_NUMBER = "number";
    @JsonIgnore
    public static final String TYPE_BOOLEAN = "boolean";
    @JsonIgnore
    public static final String TYPE_STRING = "string";
    @JsonIgnore
    public static final String TYPE_GEOJSON = "geojson";
    private String type;
    private List<String> units;
    private List<String> tags;

    public String getType() {
        switch (type){
            case TYPE_NUMBER:
            case TYPE_BOOLEAN:
            case TYPE_STRING:
            case TYPE_GEOJSON:
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
                this.type = type;
                break;
            default:
                this.type = null;
        }
    }

    public List<String> getUnits() {
        return units;
    }

    public void setUnits(List<String> units) {
        this.units = units;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
