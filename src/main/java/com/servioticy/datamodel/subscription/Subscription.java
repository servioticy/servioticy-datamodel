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
package com.servioticy.datamodel.subscription;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.stream.Stream;
import com.servioticy.datamodel.update.Update;

/**
 * @author Álvaro Villalba Navarro (alvaro.villalba@bsc.es)
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription extends Mapper {
	@JsonIgnore
	public static final ObjectReader jsonReader = jsonMapper.readerFor(Update.class);
	@JsonIgnore
	public static final ObjectReader binReader = binMapper.readerFor(Stream.class);
	private String origin;
	private String destination;
	private String sectionId;
	private String arg;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getArg() {
		return arg;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}
}