package com.servioticy.datamodel.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Section {
    @JsonIgnore
    public static final String TYPE_COMPOSE = "compose";
    @JsonIgnore
    public static final String TYPE_SW_AGGREGATOR = "swaggregate";
    private List<String> args;
    private String type;
    private String func;

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public String getType() {
        switch (type){
            case TYPE_COMPOSE:
            case TYPE_SW_AGGREGATOR:
                return type;
            default:
                return null;
        }
    }

    public void setType(String type) {
        switch (type){
            case TYPE_COMPOSE:
            case TYPE_SW_AGGREGATOR:
                this.type = type;
                break;
            default:
                this.type = null;
        }
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
