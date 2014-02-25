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

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SOGroup {
	ArrayList<String> members;
	String stream;
	
	/**
	 * @return the members
	 */
	public ArrayList<String> getMembers() {
		return members;
	}
	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
}
