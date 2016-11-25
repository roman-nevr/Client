package ru.rubicon.client.model.git.event;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Event {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("actor")
    @Expose
    private Actor actor;
    @SerializedName("repo")
    @Expose
    private Repo repo;
    @SerializedName("payload")
    @Expose
    private Payload payload;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
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
     * The actor
     */
    public Actor getActor() {
        return actor;
    }

    /**
     *
     * @param actor
     * The actor
     */
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    /**
     *
     * @return
     * The repo
     */
    public Repo getRepo() {
        return repo;
    }

    /**
     *
     * @param repo
     * The repo
     */
    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    /**
     *
     * @return
     * The payload
     */
    public Payload getPayload() {
        return payload;
    }

    /**
     *
     * @param payload
     * The payload
     */
    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    /**
     *
     * @return
     * The _public
     */
    public Boolean getPublic() {
        return _public;
    }

    /**
     *
     * @param _public
     * The public
     */
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}