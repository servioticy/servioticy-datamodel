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
    private Long timestampMS;
    private Long partitionOffset;

    public Long getTimestampMS() {
        return timestampMS;
    }

    public void setTimestampMS(Long timestampMS) {
        this.timestampMS = timestampMS;
    }

    public Long getPartitionOffset() {
        return partitionOffset;
    }

    public void setPartitionOffset(Long partitionOffset) {
        this.partitionOffset = partitionOffset;
    }

    @JsonIgnore
    @Override
    public int compareTo(Offset offset) {
        int result = this.getTimestampMS().compareTo(offset.getTimestampMS());
        return result == 0 ? this.getPartitionOffset().compareTo(offset.getPartitionOffset()) : result;
    }
}
