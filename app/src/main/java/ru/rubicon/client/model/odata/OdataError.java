package ru.rubicon.client.model.odata;

import com.google.gson.annotations.SerializedName;

import ru.rubicon.client.model.odata.odinesnik.Message;

/**
 * Created by Admin on 12.01.2017.
 */
public class OdataError {
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private Message message;

    public OdataError(String code, Message message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}