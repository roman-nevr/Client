package ru.rubicon.client.model.odata.moon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 30.12.2016.
 */

public class Nomenclature {
    @SerializedName("Ref_Key") private String ref;
    @SerializedName("DeletionMark") private boolean deletionMark;

    @SerializedName("Description") private String name;
    @SerializedName("Артикул") private String vendorCode;
    @SerializedName("IsFolder") private boolean isFolder;
}
