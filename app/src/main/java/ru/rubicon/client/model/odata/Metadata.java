package ru.rubicon.client.model.odata;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("value")
    @Expose
    private List<MetadataValue> value = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Metadata() {
    }

    /**
     *
     * @param value
     * @param odataMetadata
     */
    public Metadata(String odataMetadata, List<MetadataValue> value) {
        super();
        this.odataMetadata = odataMetadata;
        this.value = value;
    }

    public String getOdataMetadata() {
        return odataMetadata;
    }

    public void setOdataMetadata(String odataMetadata) {
        this.odataMetadata = odataMetadata;
    }

    public List<MetadataValue> getValue() {
        return value;
    }

    public void setValue(List<MetadataValue> value) {
        this.value = value;
    }

}