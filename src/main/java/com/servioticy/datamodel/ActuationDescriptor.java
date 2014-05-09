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

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuationDescriptor {
	
//	{
//	    "soid": "1398115616876579c012faaa646c4ab5b2ab039653270",
//	    "id": "1121213214aaccbc88a81111398115616876579c012f",
//	    "name": "reboot",
//	    "action": {
//	        "description": {
//	            "name": "reboot",
//	            "description": "Reboots the device"
//	        },
//	    	"parameters": {
//				"param1": "foo",
//				"param2": "more foo"
//	   	 	}
//		}
//	}
	
	
	String soid;
	String id;
	String name;
	Actuation action;
	
	public ActuationDescriptor(){
		
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the action
	 */
	public Actuation getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(Actuation action) {
		this.action = action;
	}
	
	
}
