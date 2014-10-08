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
package com.servioticy.datamodel.Reputation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=ReputationSOPubSub.class, name=Reputation.STREAM_SO_PUBSUB ),
        @JsonSubTypes.Type(value=ReputationSOService.class, name=Reputation.STREAM_SO_SERVICE),
        @JsonSubTypes.Type(value=ReputationSOSO.class, name=Reputation.STREAM_SO_SO),
        @JsonSubTypes.Type(value=ReputationSOUser.class, name=Reputation.STREAM_SO_USER),
        @JsonSubTypes.Type(value=ReputationWOSO.class, name=Reputation.STREAM_WO_SO)
})
public class Reputation {
    public static final String STREAM_WO_SO = "wo-so";
    public static final String STREAM_SO_SO = "so-so";
    public static final String STREAM_SO_PUBSUB = "so-pubsub";
    public static final String STREAM_SO_USER = "so-user";
    public static final String STREAM_SO_SERVICE = "so-service";

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
