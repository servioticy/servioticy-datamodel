package com.servioticy.datamodel.partials;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class SWAPartialPair {
    @JsonIgnore
    private String id;
    @JsonIgnore
    public static final ObjectReader reader = new ObjectMapper().reader(SWAPartialPair.class);
    @JsonIgnore
    public static final ObjectWriter writer = new ObjectMapper().writer();
    @JsonProperty("l")
    private SWAPartial left;
    @JsonProperty("r")
    private SWAPartial right;

    public SWAPartialPair(){

    }

    public SWAPartialPair(SWAPartial left, SWAPartial right) {
        this.left = left;
        this.right = right;
    }

    @JsonGetter("l")
    public SWAPartial getLeft() {
        return left;
    }
    @JsonSetter("l")
    public void setLeft(SWAPartial left) {
        this.left = left;
    }

    @JsonGetter("r")
    public SWAPartial getRight() {
        return right;
    }

    @JsonSetter("r")
    public void setRight(SWAPartial right) {
        this.right = right;
    }

    @JsonIgnore
    public Long minTimestamp(){
        return this.left == null ? this.right.getMinTimestamp() : this.left.getMinTimestamp();
    }

    @JsonIgnore
    public Long maxTimestamp(){
        return this.right == null ?
                this.left.getSensorUpdate().getLastUpdate() :
                this.right.getSensorUpdate().getLastUpdate();
    }

    @JsonIgnore
    public String getId(){
        return this.id;
    }

    @JsonIgnore
    public void setId(String id){
        this.id = id;
    }

    @JsonIgnore
    public long getIndex(){
        return Long.decode("#" + this.id.split("::")[2]);
    }
}