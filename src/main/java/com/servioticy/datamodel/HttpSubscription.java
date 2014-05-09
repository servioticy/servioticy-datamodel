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

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
public class HttpSubscription extends PubSubSubscription {
	private class HSCustomFields extends PubSubSubscription.PSCustomFields{
		private LinkedHashMap <String, String> headers;
		private String method;
		
		public HSCustomFields(){
			
		}
		
		public LinkedHashMap<String, String> getHeaders() {
			return headers;
		}
		public void setHeaders(LinkedHashMap<String, String> headers) {
			this.headers = headers;
		}
		public String getMethod() {
			return method;
		}
		public void setMethod(String method) {
			this.method = method;
		}
	}
	private HSCustomFields customFields;

	public HttpSubscription(){
		
	}
	
	public HSCustomFields getCustomFields() {
		return customFields;
	}
	public void setCustomFields(HSCustomFields customFields) {
		this.customFields = customFields;
	}
	public LinkedHashMap<String, String> getHeaders() {
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getHeaders();
	}
	public void setHeaders(LinkedHashMap<String, String> headers) {
		if(this.getCustomFields() == null){
			this.setCustomFields(new HSCustomFields());
		}
		this.getCustomFields().setHeaders(headers);
	}
	public String getMethod(){
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getMethod();
	}
	public void setMethod(String method){
		if(this.getCustomFields() == null){
			this.setCustomFields(new HSCustomFields());
		}
		this.getCustomFields().setMethod(method);
	}
}
