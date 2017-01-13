package ru.rubicon.client.model.odata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 12.01.2017.
 */

public class OdataMetadata <T> {
    @SerializedName("odata.metadata")
    private String odataMetadata;
    @SerializedName("value")
    private List<T> values;

    public OdataMetadata(String odataMetadata, List<T> values) {
        this.odataMetadata = odataMetadata;
        this.values = values;
    }

    public String getOdataMetadata() {
        return odataMetadata;
    }

    public void setOdataMetadata(String odataMetadata) {
        this.odataMetadata = odataMetadata;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
