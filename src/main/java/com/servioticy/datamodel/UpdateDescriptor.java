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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.stream.Stream;
import com.servioticy.datamodel.subscription.Subscription;
import com.servioticy.datamodel.update.Update;

/**
 * @author Álvaro Villalba Navarro (alvaro.villalba@bsc.es)
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateDescriptor extends Mapper {
	@JsonIgnore
	public static final ObjectReader jsonReader = jsonMapper.readerFor(UpdateDescriptor.class);
	@JsonIgnore
	public static final ObjectReader binReader = binMapper.readerFor(Stream.class);
	private Update update;
	private Subscription subscription;

	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}
