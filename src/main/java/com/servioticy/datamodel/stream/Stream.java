package com.servioticy.datamodel.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.update.Value;

import java.util.*;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 18/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stream extends Mapper{
    @JsonIgnore
    public static final ObjectReader jsonReader = jsonMapper.readerFor(Stream.class);
    @JsonIgnore
    public static final ObjectReader binReader = binMapper.readerFor(Stream.class);
    @JsonIgnore
    private String id;
    private String version;
    private History history;
    private Map<String, Channel> channels;
    private Map<String, Metadata> metadata;
    private Map<String, Section> sections;
    private Constructor constructor;

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Map<String, Channel> getChannels() {
        return channels;
    }

    public void setChannels(Map<String, Channel> channels) {
        this.channels = channels;
    }

    public Map<String, Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Metadata> metadata) {
        this.metadata = metadata;
    }

    public Map<String, Section> getSections() {
        return sections;
    }

    public void setSections(Map<String, Section> sections) {
        this.sections = sections;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    @JsonIgnore
    public List<String> findSubscribedSections(String arg){
        List<String> sections = new ArrayList<>();
        for (Map.Entry<String,Section> sectionEntry: getSections().entrySet()){
            if (sectionEntry.getValue().getArgs().indexOf(arg) != -1){
                sections.add(sectionEntry.getKey());
            }
        }
        return sections;
    }

    @JsonIgnore
    public Map<String, Object> getSimpleMetadata() {
        Map<String, Object> values = new HashMap<>();
        for (Map.Entry<String, Metadata> metadataEntry: getMetadata().entrySet()){
            values.put(metadataEntry.getKey(), metadataEntry.getValue().getValue().getValue());
        }
        return values;
    }
}
