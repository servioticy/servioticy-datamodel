package com.servioticy.datamodel.reputation;

/**
 * Created by alvaro on 26/12/15.
 */
public class Reputation {
    public static final String ACTION_READ = "read";
    public static final String ACTION_WRITE = "write";

    String ownerId;
    String soId;
    String streamId;
    String suId;
    String action;
    long timestamp;
    OnBehalf onBehalf;
    Discard discard;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public OnBehalf getOnBehalf() {
        return onBehalf;
    }

    public void setOnBehalf(OnBehalf onBehalf) {
        this.onBehalf = onBehalf;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Discard getDiscard() {
        return discard;
    }

    public void setDiscard(Discard discard) {
        this.discard = discard;
    }
}
