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
public class SOSubscription extends Subscription{
	private class SOSCustomFields{
		private String groupId;
		
		public SOSCustomFields() {
		}

		public String getGroupId() {
			return groupId;
		}

		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}
	}
	private SOSCustomFields customFields;

	public SOSCustomFields getCustomFields() {
		return customFields;
	}
	public void setCustomFields(SOSCustomFields customFields) {
		this.customFields = customFields;
	}
	
	public String getGroupId() {
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getGroupId();
	}

	public void setGroupId(String groupId) {
		if(this.getCustomFields() == null){
			this.setCustomFields(new SOSCustomFields());
		}
		this.getCustomFields().setGroupId(groupId);
	}
}
