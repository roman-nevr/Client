package ru.rubicon.client.model.git;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Files {

    public Files(){};

    public Files(List<File> files) {
        this.files = files;
    }

    @SerializedName("files")
    @Expose
    private List<File> files = new ArrayList<File>();

    /**
     *
     * @return
     * The files
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     *
     * @param files
     * The files
     */
    public List<File> setFiles(List<File> files) {
        this.files = files;
        return files;
    }

}