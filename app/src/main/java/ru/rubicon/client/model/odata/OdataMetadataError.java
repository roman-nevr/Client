package ru.rubicon.client.model.odata;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 12.01.2017.
 */

public class OdataMetadataError {
    @SerializedName("odata.error")
    private OdataError error;

    public OdataMetadataError(OdataError error) {
        this.error = error;
    }

    public OdataError getError() {
        return error;
    }

    public void setError(OdataError error) {
        this.error = error;
    }
}
