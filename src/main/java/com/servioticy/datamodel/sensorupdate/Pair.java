package com.servioticy.datamodel.sensorupdate;

public class Pair{
    private SensorUpdate l;
    private SensorUpdate r;

    public Pair(){

    }

    public Pair(SensorUpdate l, SensorUpdate r) {
        this.l = l;
        this.r = r;
    }

    public SensorUpdate getL() {
        return l;
    }

    public void setL(SensorUpdate l) {
        this.l = l;
    }

    public SensorUpdate getR() {
        return r;
    }

    public void setR(SensorUpdate r) {
        this.r = r;
    }

}