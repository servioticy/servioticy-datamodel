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
package com.servioticy.datamodel.serviceobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.LinkedHashMap;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 *
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXTERNAL_PROPERTY, defaultImpl = SOStream010.class, property="version")
@JsonSubTypes({
        @JsonSubTypes.Type(value=SOStream010.class, name=SO.V_0_1_0),
        @JsonSubTypes.Type(value=SOStream020.class, name=SO.V_0_2_0),
        // Default version of SO
        @JsonSubTypes.Type(value=SOStream010.class)
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class SOStream{
    private LinkedHashMap<String, SOChannel> channels;
    private String description;

    public LinkedHashMap<String, SOChannel> getChannels() {
        return channels;
    }
    public void setChannels(LinkedHashMap<String, SOChannel> channels) {
        this.channels = channels;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
