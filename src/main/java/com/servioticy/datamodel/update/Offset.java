package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offset implements Comparable<Offset>{
    private Long sourceTimestampMS;
    private int sourcePartId;
    private Long sourcePartOffset;
    private Long streamTimestampMS;
    private int streamPartId;
    private Long streamPartOffset;

    public Long getSourceTimestampMS() {
        return sourceTimestampMS;
    }

    public void setSourceTimestampMS(Long sourceTimestampMS) {
        this.sourceTimestampMS = sourceTimestampMS;
    }

    public int getSourcePartId() {
        return sourcePartId;
    }

    public void setSourcePartId(int sourcePartId) {
        this.sourcePartId = sourcePartId;
    }

    public Long getSourcePartOffset() {
        return sourcePartOffset;
    }

    public void setSourcePartOffset(Long sourcePartOffset) {
        this.sourcePartOffset = sourcePartOffset;
    }

    public Long getStreamTimestampMS() {
        return streamTimestampMS;
    }

    public void setStreamTimestampMS(Long streamTimestampMS) {
        this.streamTimestampMS = streamTimestampMS;
    }

    public int getStreamPartId() {
        return streamPartId;
    }

    public void setStreamPartId(int streamPartId) {
        this.streamPartId = streamPartId;
    }

    public Long getStreamPartOffset() {
        return streamPartOffset;
    }

    public void setStreamPartOffset(Long streamPartOffset) {
        this.streamPartOffset = streamPartOffset;
    }

    @JsonIgnore
    @Override
    public int compareTo(Offset offset) {
        int result = this.getSourceTimestampMS().compareTo(offset.getSourceTimestampMS());
        if (result != 0){
            return result;
        }

        if (this.getSourcePartId() == offset.getSourcePartId()){
            result = this.getStreamPartOffset().compareTo(offset.getStreamPartOffset());
            if (result != 0){
                return result;
            }
        }
        result = this.getStreamTimestampMS().compareTo(offset.getStreamTimestampMS());
        if (result != 0){
            return result;
        }

        if (this.getSourcePartId() == offset.getSourcePartId()){
            result = this.getStreamPartOffset().compareTo(offset.getStreamPartOffset());
            if (result != 0){
                return result;
            }
        }
        return result;
    }
}
