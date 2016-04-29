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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.sensorupdate.SensorUpdate;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateDescriptor extends Mapper {
	@JsonIgnore
	public static final ObjectReader reader = mapper.reader(UpdateDescriptor.class);
	String soid;
	String streamid;
	SensorUpdate su;
	
	public UpdateDescriptor(){
		
	}
	/**
	 * @return the soid
	 */
	public String getSoid() {
		return soid;
	}
	/**
	 * @param soid the soid to set
	 */
	public void setSoid(String soid) {
		this.soid = soid;
	}
	/**
	 * @return the streamid
	 */
	public String getStreamid() {
		return streamid;
	}
	/**
	 * @param streamid the streamid to set
	 */
	public void setStreamid(String streamid) {
		this.streamid = streamid;
	}
	/**
	 * @return the su
	 */
	public SensorUpdate getSu() {
		return su;
	}
	/**
	 * @param su the su to set
	 */
	public void setSu(SensorUpdate su) {
		this.su = su;
	}
	
	
}
