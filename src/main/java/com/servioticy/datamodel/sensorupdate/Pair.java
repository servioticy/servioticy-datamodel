package com.servioticy.datamodel.sensorupdate;

public class Pair{
    private SensorUpdate l;
    private SensorUpdate r;
    private Long lm;
    private Long rm;

    public Pair(){

    }

    public Pair(SensorUpdate left, SensorUpdate right, Long leftMinTS, Long rightMinTS) {
        this.l = left;
        this.r = right;
        this.lm = leftMinTS;
        this.rm = rightMinTS;
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

    public Long getLm() {
        return lm;
    }

    public void setLm(Long lm) {
        this.lm = lm;
    }

    public Long getRm() {
        return rm;
    }

    public void setRm(Long rm) {
        this.rm = rm;
    }

    public Long getMinTS(){
        return lm == null ? rm : lm;
    }
}