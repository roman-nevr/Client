package ru.rubicon.client.model.odata.odinesnik;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 12.01.2017.
 */

public class Document {
    @SerializedName("Ref_Key")
    private String refKey;
    @SerializedName("DeletionMark")
    private boolean deletionMark;
    @SerializedName("Number")
    private int number;
    @SerializedName("Date")
    private String date;
    @SerializedName("Posted")
    private boolean posted;
    @SerializedName("СчетДт_Key")
    private String debitAccountKey;
    @SerializedName("СчетКт_Key")
    private String creditAccountKey;
    @SerializedName("Субконто1")
    private String subconto1;
    @SerializedName("Субконто1_Type")
    private String subconto1Type;

    public Document(String refKey, boolean deletionMark, int number, String date, boolean posted, String debitAccountKey, String creditAccountKey, String subconto1, String subconto1Type) {
        this.refKey = refKey;
        this.deletionMark = deletionMark;
        this.number = number;
        this.date = date;
        this.posted = posted;
        this.debitAccountKey = debitAccountKey;
        this.creditAccountKey = creditAccountKey;
        this.subconto1 = subconto1;
        this.subconto1Type = subconto1Type;
    }

    public String getRefKey() {
        return refKey;
    }

    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }

    public boolean isDeletionMark() {
        return deletionMark;
    }

    public void setDeletionMark(boolean deletionMark) {
        this.deletionMark = deletionMark;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    public String getDebitAccountKey() {
        return debitAccountKey;
    }

    public void setDebitAccountKey(String debitAccountKey) {
        this.debitAccountKey = debitAccountKey;
    }

    public String getCreditAccountKey() {
        return creditAccountKey;
    }

    public void setCreditAccountKey(String creditAccountKey) {
        this.creditAccountKey = creditAccountKey;
    }

    public String getSubconto1() {
        return subconto1;
    }

    public void setSubconto1(String subconto1) {
        this.subconto1 = subconto1;
    }

    public String getSubconto1Type() {
        return subconto1Type;
    }

    public void setSubconto1Type(String subconto1Type) {
        this.subconto1Type = subconto1Type;
    }
}
/*
{
"Ref_Key": "f9122abf-45dc-11e5-82f7-bcee7be0a11a",
"DataVersion": "AAAAAAACedA=",
"DeletionMark": false,
"Number": "000000001",
"Date": "2015-01-01T22:11:57",
"Posted": true,
"СчетДт_Key": "c02113eb-45dc-11e5-82f7-bcee7be0a11a",
"СчетКт_Key": "c02113ec-45dc-11e5-82f7-bcee7be0a11a",
"Субконто1": "090afc3f-8922-11e4-82e0-d43d7eed38ac",
"Субконто1_Type": "StandardODATA.Catalog_Города",
"СчетДт@navigationLinkUrl": "Document_Док(guid'f9122abf-45dc-11e5-82f7-bcee7be0a11a')/СчетДт",
"СчетКт@navigationLinkUrl": "Document_Док(guid'f9122abf-45dc-11e5-82f7-bcee7be0a11a')/СчетКт"
}
 */