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

    private Object src;
    private ReputationAddress dest;
    private boolean event;
    private long date;
    @JsonProperty("user_timestamp")
    private String userTimestamp;
    @JsonProperty("newer_than_latest")
    private boolean newerThanLatest;
    private String suid;

    public Object getSrc() {
        return src;
    }

    public void setSrc(Object src) {
        this.src = src;
    }

    public ReputationAddress getDest() {
        return dest;
    }

    public void setDest(ReputationAddress dest) {
        this.dest = dest;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getUserTimestamp() {
        return userTimestamp;
    }

    public void setUserTimestamp(String userTimestamp) {
        this.userTimestamp = userTimestamp;
    }

    public boolean isNewerThanLatest() {
        return newerThanLatest;
    }

    public void setNewerThanLatest(boolean newerThanLatest) {
        this.newerThanLatest = newerThanLatest;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }
}
