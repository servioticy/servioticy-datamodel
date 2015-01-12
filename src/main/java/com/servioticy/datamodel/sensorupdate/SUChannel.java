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

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SUChannel{
	@JsonProperty("current-value")
	private Object currentValue;
	private String unit;

	@JsonGetter("current-value")
	public Object getNotNullCurrentValue() throws JsonGenerationException {
		if(currentValue == null){
			throw new JsonGenerationException("'current-value' must be different from 'null'");
		}
		return currentValue;
	}
	public Object getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Object currentValue) {
		this.currentValue = currentValue;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}