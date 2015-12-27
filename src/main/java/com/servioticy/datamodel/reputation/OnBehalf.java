package com.servioticy.datamodel.reputation;

/**
 * Created by alvaro on 26/12/15.
 */
public class OnBehalf {
    public static final String TYPE_STREAM = "stream";
    public static final String TYPE_USER = "user";
    public static final String TYPE_PUBSUB_INTERNAL = "pubsub_internal";
    public static final String TYPE_PUBSUB_EXTERNAL = "pubsub_external";

    String type;
    String userid;
    String suId;
    String soId;
    String streamId;
    // TODO Add subscription id (needs to be retrieved from the API)
//    String subscriptionId;
    String topic;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSuId() {
        return suId;
    }

    public void setSuId(String suId) {
        this.suId = suId;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
