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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Álvaro Villalba Navarro <alvaro.villalba@bsc.es>
 *
 */
@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.PROPERTY,
        property="version",
        defaultImpl = SO010.class)
@JsonSubTypes( value = {
        @JsonSubTypes.Type(value=SO010.class, name=SO.V_0_1_0),
        @JsonSubTypes.Type(value=SO020.class, name=SO.V_0_2_0)
})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SO{
    @JsonIgnore static final public String V_0_1_0 = "0.1.0";
    @JsonIgnore static final public String V_0_2_0 = "0.2.0";

    @JsonIgnore private String version;
    String id;
    String name;
    String description;
    LinkedHashMap<String, SOGroup> groups;
    private LinkedHashMap<String, Object> streamsRaw;
    private LinkedHashMap<String, SOStream> streams;

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

    public LinkedHashMap<String, SOStream> getStreams(ObjectMapper mapper) {
        if (this.streams != null){
            return this.streams;
        }
        if(this.getVersion().equals(SO.V_0_1_0)){
            this.streams = mapper.convertValue(this.streamsRaw, new TypeReference<Map<String, SOStream010>>() {});
            return this.streams;
        }
        else if(this.getVersion().equals(SO.V_0_2_0)){
            this.streams = mapper.convertValue(this.streamsRaw, new TypeReference<Map<String, SOStream020>>() {});
            return this.streams;
        }
        return mapper.convertValue(this.streamsRaw, new TypeReference<Map<String, SOStream010>>() {});
    }

    public void setStreams(LinkedHashMap<String, SOStream> streams, ObjectMapper mapper) {
        this.streams = streams;
        this.streamsRaw =
                (LinkedHashMap<String, Object>)
                        mapper.convertValue(streams, new TypeReference<Map<String, Object>>() {});
    }

    @JsonGetter("streams")
    protected LinkedHashMap<String, Object> getCheckStreams() throws JsonGenerationException {
        if(this.streamsRaw == null || this.streamsRaw.size() < 1){
            throw new JsonGenerationException("At least one stream is required");
        }
        return this.streamsRaw;
    }
    @JsonSetter("streams")
    protected void setCheckStreams(LinkedHashMap<String, Object> streams) throws IOException {
        if(streams == null || streams.size() < 1){
            throw new JsonMappingException("At least one stream is required");
        }
        this.streamsRaw = streams;
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
