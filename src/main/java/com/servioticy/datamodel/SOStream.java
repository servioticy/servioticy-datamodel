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

import java.util.LinkedHashMap;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SOStream {
	private LinkedHashMap<String, SOChannel> channels;
	private String description;
	@JsonProperty("pre-filter")
	private String preFilter;
	@JsonProperty("post-filter")
	private String postFilter;
	
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
	public String getPreFilter() {
		return preFilter;
	}
	public void setPreFilter(String preFilter) {
		this.preFilter = preFilter;
	}
	public String getPostFilter() {
		return postFilter;
	}
	public void setPostFilter(String postFilter) {
		this.postFilter = postFilter;
	}
}
