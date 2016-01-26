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
package com.servioticy.datamodel.sensorupdate;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorUpdate {
//	Stream location of the SO
//	{
//		"channels":{
//			"latitude": {
//				"current-value": 3.14159,
//				"unit": "degrees"
//			},
//			"longitude": {
//				"current-value": 2.11159,
//				"unit": "degrees"
//			}
//		},
//		"lastUpdate": 1199192939
//	}

    private LinkedHashMap<String, SUChannel> channels;

    private long lastUpdate;

    private Long originId;


    private ArrayList<ArrayList<ProvenanceUnit>> provenance;

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public LinkedHashMap<String, SUChannel> getChannels() {
        return channels;
    }

    @JsonGetter("channels")
    public LinkedHashMap<String, SUChannel> getNotNullOrEmptyChannels() throws JsonGenerationException {
        if(channels == null || channels.size() < 1){
            throw new JsonGenerationException("At least one channel is required");
        }
        return getChannels();
    }
    @JsonSetter("channels")
    public void setNotNullOrEmptyChannels(LinkedHashMap<String, SUChannel> channels) throws JsonMappingException {
        if(channels == null || channels.size() < 1){
            throw new JsonMappingException("At least one channel is required");
        }
        setChannels(channels);
    }
    public void setChannels(LinkedHashMap<String, SUChannel> channels) {
        this.channels = channels;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ArrayList<ArrayList<ProvenanceUnit>> getProvenance() {
        return provenance;
    }

    public void setProvenance(ArrayList<ArrayList<ProvenanceUnit>> provenance) {
        this.provenance = provenance;
    }

    @JsonIgnore
    public String getSoId(){
        return this.getProvenance().get(0).get(0).getSoId();
    }
    @JsonIgnore
    public String getStreamId(){
        return this.getProvenance().get(0).get(0).getStreamId();
    }

    // TODO The suId generation should be a shared method with the API
    @JsonIgnore
    public String getId(){
        return getSoId() + "-" + getStreamId() + "-" + getLastUpdate();
    }
}
