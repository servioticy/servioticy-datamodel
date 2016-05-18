package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Álvaro Villalba <alvaro.villalba@bsc.es> on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offset {
    private long timestampMS;
    private Long partitionOffset;

    public long getTimestampMS() {
        return timestampMS;
    }

    public void setTimestampMS(long timestampMS) {
        this.timestampMS = timestampMS;
    }

    public Long getPartitionOffset() {
        return partitionOffset;
    }

    public void setPartitionOffset(Long partitionOffset) {
        this.partitionOffset = partitionOffset;
    }
}
