/*******************************************************************************
 * Copyright 2014 Barcelona Supercomputing Center (BSC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.servioticy.datamodel.reputation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 */
public class Reputation {
    public static final String STREAM_WO_SO = "wo-so";
    public static final String STREAM_SO_SO = "so-so";
    public static final String STREAM_SO_PUBSUB = "so-pubsub";
    public static final String STREAM_SO_USER = "so-user";
    public static final String STREAM_SO_SERVICE = "so-service";

    public static final String DISCARD_NONE = "none";
    public static final String DISCARD_ERROR = "error";
    public static final String DISCARD_TIMESTAMP = "timestamp";
    public static final String DISCARD_FILTER = "filter";
    public static final String DISCARD_SECURITY = "security";

    private ReputationAddress src;
    private ReputationAddress dest;
    private Boolean event;
    private Boolean internalPublisher;
    private Long date;
    @JsonProperty("user_timestamp")
    private Long userTimestamp;
    private String discard;

//    private Boolean fresh;

    public ReputationAddress getSrc() {
        return src;
    }

    public void setSrc(ReputationAddress src) {
        this.src = src;
    }

    public ReputationAddress getDest() {
        return dest;
    }

    public void setDest(ReputationAddress dest) {
        this.dest = dest;
    }

    public Boolean getEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    public Boolean getInternalPublisher() {
        return internalPublisher;
    }

    public void setInternalPublisher(Boolean internalPublisher) {
        this.internalPublisher = internalPublisher;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Long getUserTimestamp() {
        return userTimestamp;
    }

    public void setUserTimestamp(Long userTimestamp) {
        this.userTimestamp = userTimestamp;
    }

    public String getDiscard() {
        return discard;
    }

    public void setDiscard(String discard) {
        this.discard = discard;
    }

//    public Boolean getFresh() {
//        return fresh;
//    }
//
//    public void setFresh(boolean fresh) {
//        this.fresh = fresh;
//    }
}
