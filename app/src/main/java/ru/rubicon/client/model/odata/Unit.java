package ru.rubicon.client.model.odata;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 30.12.2016.
 */

public class Unit {
    @SerializedName("Ref_Key") private String ref;
    @SerializedName("DeletionMark") private boolean deletionMark;
    @SerializedName("Description") private String name;
}
