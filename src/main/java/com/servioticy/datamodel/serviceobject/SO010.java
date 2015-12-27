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

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SO010 extends SO {
	public SO010(){
		this.setVersion(V_0_1_0);
	}
	ArrayList<LinkedHashMap<String, String>> aliases;
	/**
	 * @return the aliases
	 */
	public ArrayList<LinkedHashMap<String, String>> getAliases() {
		return aliases;
	}
	/**
	 * @param aliases the aliases to set
	 */
	public void setAliases(ArrayList<LinkedHashMap<String, String>> aliases) {
		this.aliases = aliases;
	}

}
