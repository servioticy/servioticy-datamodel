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

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.LinkedHashMap;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 *
 */
@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.PROPERTY,
        property="version",
        defaultImpl = SO010.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value=SO010.class, name=SO.V_0_1_0),
        @JsonSubTypes.Type(value=SO020.class, name=SO.V_0_2_0)
})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SO{
    @JsonIgnore static final public String V_0_1_0 = "0.1.0";
    @JsonIgnore static final public String V_0_2_0 = "0.2.0";

    String version;
    String id;
    String name;
    String description;
    LinkedHashMap<String, SOGroup> groups;
    LinkedHashMap<String, SOStream> streams;

    //	LinkedHashMap<String, Object> queries;
    //	ArrayList<SOAction> actions;
    //	LinkedHashMap<String, String> properties;
    //	LinkedHashMap<String, String> links;
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedHashMap<String, SOGroup> getGroups() {
        return groups;
    }

    public void setGroups(LinkedHashMap<String, SOGroup> groups) {
        this.groups = groups;
    }

    public LinkedHashMap<String, SOStream> getStreams() {
        return streams;
    }

    public void setStreams(LinkedHashMap<String, SOStream> streams) {
        this.streams = streams;
    }

    @JsonGetter("streams")
    public LinkedHashMap<String, SOStream> getNotNullOrEmptyStreams() throws JsonGenerationException {
        if(streams == null || streams.size() < 1){
            throw new JsonGenerationException("At least one stream is required");
        }
        return getStreams();
    }
    @JsonSetter("streams")
    public void setNotNullOrEmptyStreams(LinkedHashMap<String, SOStream> streams) throws JsonMappingException {
        if(streams == null || streams.size() < 1){
            throw new JsonMappingException("At least one stream is required");
        }
        setStreams(streams);
    }

    //	/**
//	 * @return the queries
//	 */
//	public LinkedHashMap<String, Object> getQueries() {
//		return queries;
//	}
//	/**
//	 * @param queries the queries to set
//	 */
//	public void setQueries(LinkedHashMap<String, Object> queries) {
//		this.queries = queries;
//	}
//	/**
//	 * @return the actions
//	 */
//	public ArrayList<SOAction> getActions() {
//		return actions;
//	}
//	/**
//	 * @param actions the actions to set
//	 */
//	public void setActions(ArrayList<SOAction> actions) {
//		this.actions = actions;
//	}
//	/**
//	 * @return the properties
//	 */
//	public LinkedHashMap<String, String> getProperties() {
//		return properties;
//	}
//	/**
//	 * @param properties the properties to set
//	 */
//	public void setProperties(LinkedHashMap<String, String> properties) {
//		this.properties = properties;
//	}
//	/**
//	 * @return the links
//	 */
//	public LinkedHashMap<String, String> getLinks() {
//		return links;
//	}
//	/**
//	 * @param links the links to set
//	 */
//	public void setLinks(LinkedHashMap<String, String> links) {
//		this.links = links;
//	}
}
