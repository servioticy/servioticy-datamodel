package com.servioticy.datamodel.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectReader;
import com.servioticy.datamodel.Mapper;
import com.servioticy.datamodel.stream.Stream;

import java.util.Map;

/**
 * Created by Álvaro Villalba (alvaro.villalba@bsc.es) on 24/05/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionUpdate extends Mapper {
    @JsonIgnore
    public static final ObjectReader jsonReader = jsonMapper.readerFor(com.servioticy.datamodel.update.StoreUpdate.class);
    @JsonIgnore
    public static final ObjectReader binReader = binMapper.readerFor(Stream.class);
    private Object values;
    private Offset offset;

    public Object getValues() {
        return values;
    }

    public void setValues(Object values) {
        this.values = values;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    @JsonIgnore
    public boolean isFromOutside(){
        Offset offset = getOffset();
        return offset.getSourcePartId() == offset.getStreamPartId() && offset.getSourcePartOffset() == offset.getStreamPartOffset();
    }

    @JsonIgnore
    public StreamUpdate toStreamUpdate(){
        StreamUpdate update = new StreamUpdate();
        update.setValues((Map<String, Object>)getValues());
        update.setOffset(getOffset());
        return update;
    }
}

