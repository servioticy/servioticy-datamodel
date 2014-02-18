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

public class SOGroup {
	ArrayList<String> soids;
	ArrayList<String> dynsets;
	String stream;
	
	public ArrayList<String> getDynsets() {
		return dynsets;
	}
	public void setDynsets(ArrayList<String> dynsets) {
		this.dynsets = dynsets;
	}
	public ArrayList<String> getSoids() {
		return soids;
	}
	public void setSoids(ArrayList<String> soids) {
		this.soids = soids;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
}
