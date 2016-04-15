package com.servioticy.datamodel.partials;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class SWAPartialPair {
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

    public Long minTimestamp(){
        return this.left == null ? this.right.getMinTimestamp() : this.left.getMinTimestamp();
    }

    public Long maxTimestamp(){
        return this.right == null ?
                this.left.getSensorUpdate().getLastUpdate() :
                this.right.getSensorUpdate().getLastUpdate();
    }
}