package com.servioticy.datamodel.sensorupdate;

/**
 * Created by alvaro on 15/12/15.
 */
public class ProvenanceUnit {
    public ProvenanceUnit(){};
    public ProvenanceUnit(String soId, String streamId,Long timestamp){

    }
    String soId;
    String streamId;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
