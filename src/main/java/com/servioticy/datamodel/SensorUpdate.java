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
package com.servioticy.datamodel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 */
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

    private Long lastUpdate;

    private ArrayList<ArrayList<String>> streamsChain;
    private ArrayList<Long> timestampChain;

    private Long originId;

<<<<<<< HEAD
=======
    private Object provenance;

>>>>>>> alvaro
    public ArrayList<ArrayList<String>> getStreamsChain() {
        return streamsChain;
    }

    public void setStreamsChain(ArrayList<ArrayList<String>> streamsChain) {
        this.streamsChain = streamsChain;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public ArrayList<Long> getTimestampChain() {
        return timestampChain;
    }

    public void setTimestampChain(ArrayList<Long> timestampChain) {
        this.timestampChain = timestampChain;
    }

    public LinkedHashMap<String, SUChannel> getChannels() {
        return channels;
    }

    public void setChannels(LinkedHashMap<String, SUChannel> channels) {
        this.channels = channels;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

<<<<<<< HEAD
=======
    public Object getProvenance() {
        return provenance;
    }

    public void setProvenance(Object provenance) {
        this.provenance = provenance;
    }
>>>>>>> alvaro
}
