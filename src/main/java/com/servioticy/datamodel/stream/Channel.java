package com.servioticy.datamodel.stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.servioticy.datamodel.update.Value;

import java.util.List;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Channel {
    private String type;
    private List<String> units;
    private List<String> tags;

    public String getType() {
        switch (type){
            case Value.TYPE_NUMBER:
            case Value.TYPE_BOOLEAN:
            case Value.TYPE_STRING:
            case Value.TYPE_GEOJSON:
            case Value.TYPE_NUMBER_ARRAY:
            case Value.TYPE_BOOLEAN_ARRAY:
            case Value.TYPE_STRING_ARRAY:
            case Value.TYPE_GEOJSON_ARRAY:
                return type;
            default:
                return null;
        }
    }

    public void setType(String type) {
        switch (type){
            case Value.TYPE_NUMBER:
            case Value.TYPE_BOOLEAN:
            case Value.TYPE_STRING:
            case Value.TYPE_GEOJSON:
            case Value.TYPE_NUMBER_ARRAY:
            case Value.TYPE_BOOLEAN_ARRAY:
            case Value.TYPE_STRING_ARRAY:
            case Value.TYPE_GEOJSON_ARRAY:
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
