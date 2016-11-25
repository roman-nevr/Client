package ru.rubicon.client.model.git;

/**
 * Created by Admin on 25.11.2016.
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GitEmail {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("primary")
    @Expose
    private boolean primary;
    @SerializedName("verified")
    @Expose
    private boolean verified;

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The primary
     */
    public boolean isPrimary() {
        return primary;
    }

    /**
     *
     * @param primary
     * The primary
     */
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    /**
     *
     * @return
     * The verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     *
     * @param verified
     * The verified
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}