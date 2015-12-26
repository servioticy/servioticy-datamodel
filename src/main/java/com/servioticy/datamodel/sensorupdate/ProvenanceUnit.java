package com.servioticy.datamodel.sensorupdate;

/**
 * Created by alvaro on 15/12/15.
 */
public class ProvenanceUnit {
    public ProvenanceUnit(){};
    public ProvenanceUnit(String soId, String streamId, String suId, Long timestamp){
        this.setSoId(soId);
        this.setStreamId(streamId);
        this.setSuId(suId);
        this.setTimestamp(timestamp);
    }
    String soId;
    String streamId;
    String suId;
    long timestamp;

    public String getSoId() {
        return soId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getSuId() {
        return suId;
    }

    public void setSuId(String suId) {
        this.suId = suId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
