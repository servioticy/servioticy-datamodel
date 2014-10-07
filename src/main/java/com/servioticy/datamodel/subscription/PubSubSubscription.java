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

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
public class PubSubSubscription extends Subscription{
	public class PSCustomFields{
		private ArrayList <LinkedHashMap<String, String>> aliases;
		private String body; // Both the body of the http message and the PubSub message
		
		public PSCustomFields(){
		}
		
		public ArrayList<LinkedHashMap<String, String>> getAliases() {
			return aliases;
		}
		public void setAliases(ArrayList<LinkedHashMap<String, String>> aliases) {
			this.aliases = aliases;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
	}
	
	public PubSubSubscription(){
	}
	
	private PSCustomFields customFields;

	public PSCustomFields getCustomFields() {
		return customFields;
	}
	public void setCustomFields(PSCustomFields customFields) {
		this.customFields = customFields;
	}
	public ArrayList<LinkedHashMap<String, String>> getAliases() {
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getAliases();
	}
	public void setAliases(ArrayList<LinkedHashMap<String, String>> aliases) {
		if(this.getCustomFields() == null){
			this.setCustomFields(new PSCustomFields());
		}
		this.getCustomFields().setAliases(aliases);
	}
	public String getBody() {
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getBody();
	}
	public void setBody(String body) {
		if(this.getCustomFields() == null){
			this.setCustomFields(new PSCustomFields());
		}
		this.getCustomFields().setBody(body);
	}
	
}
