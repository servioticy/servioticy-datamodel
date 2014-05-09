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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonSubTypes;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="callback")
@JsonSubTypes({
	@JsonSubTypes.Type(value=SOSubscription.class, name=Subscription.SUBS_INTERNAL),
    @JsonSubTypes.Type(value=HttpSubscription.class, name=Subscription.SUBS_HTTP),
    @JsonSubTypes.Type(value=PubSubSubscription.class, name=Subscription.SUBS_PUBSUB)
})
public class Subscription{
	@JsonIgnore static final public String SUBS_INTERNAL = "internal";
	@JsonIgnore static final public String SUBS_HTTP = "http";
	@JsonIgnore static final public String SUBS_PUBSUB = "pubsub";
	
	private String callback; // Kind of subscription
	private String id;
//	private Long delay; // Not used (I believe)
//	private Long expire; // Not used (I believe)
	private String destination;
	private Object customFields;

	public Subscription(){
		
	}
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	
//	public Long getDelay() {
//		return delay;
//	}
//	public void setDelay(Long delay) {
//		this.delay = delay;
//	}
//	public Long getExpire() {
//		return expire;
//	}
//	public void setExpire(Long expire) {
//		this.expire = expire;
//	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Object getCustomFields() {
		return customFields;
	}

	public void setCustomFields(Object customFields) {
		this.customFields = customFields;
	}
	


}