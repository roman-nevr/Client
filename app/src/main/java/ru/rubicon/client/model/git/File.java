package ru.rubicon.client.model.git;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class File {

    public File(){};

    public File(String filename, String type, Object language, String rawUrl, Integer size) {
        this.filename = filename;
        this.type = type;
        this.language = language;
        this.rawUrl = rawUrl;
        this.size = size;
    }

    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("raw_url")
    @Expose
    private String rawUrl;
    @SerializedName("size")
    @Expose
    private Integer size;

    /**
     *
     * @return
     * The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     *
     * @param filename
     * The filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The language
     */
    public Object getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The language
     */
    public void setLanguage(Object language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The rawUrl
     */
    public String getRawUrl() {
        return rawUrl;
    }

    /**
     *
     * @param rawUrl
     * The raw_url
     */
    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    /**
     *
     * @return
     * The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

}