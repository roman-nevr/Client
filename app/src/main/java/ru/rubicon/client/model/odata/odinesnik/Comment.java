package ru.rubicon.client.model.odata.odinesnik;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 12.01.2017.
 */

public class Comment {
    @SerializedName("LineNumber")
    private int number;
    @SerializedName("Комментарий")
    private String comment;
}
/*
"LineNumber": "1",
"Комментарий": "комментарий1"
 */
