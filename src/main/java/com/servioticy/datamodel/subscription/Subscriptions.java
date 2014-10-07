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

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 * 
 */
public class Subscriptions {
	/*
	 * Subscriptions will have the form:
	 * 
	 *  {
	 *     "subscriptions":
	 *     [
	 *         {
	 *             "callback": "internal",
	 *             "destination": "1372948414674add2a075fff14435814f74ad26855d43",
	 *             "url": "avg",
	 *             "auth-header": "API-KEY=XXX",
	 *             "delay": 10,
	 *             "expire": 3600
	 *         }
	 *     ]
	 *  }
	 */
	
	public Subscriptions(){
		
	}
	
	ArrayList<Subscription> subscriptions;
	public ArrayList<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

}
