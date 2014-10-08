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
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXTERNAL_PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=SourceSOPubSub.class, name=Reputation.STREAM_SO_PUBSUB ),
        @JsonSubTypes.Type(value=SourceSOService.class, name=Reputation.STREAM_SO_SERVICE),
        @JsonSubTypes.Type(value=SourceSOSO.class, name=Reputation.STREAM_SO_SO),
        @JsonSubTypes.Type(value=SourceSOUser.class, name=Reputation.STREAM_SO_USER),
        @JsonSubTypes.Type(value=SourceWOSO.class, name=Reputation.STREAM_WO_SO)
})
public class ReputationAddress {
}
