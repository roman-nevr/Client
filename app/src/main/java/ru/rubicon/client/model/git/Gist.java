package ru.rubicon.client.model.git;


import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Generated("org.jsonschema2pojo")
public class Gist {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("forks_url")
    @Expose
    private String forksUrl;
    @SerializedName("commits_url")
    @Expose
    private String commitsUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("git_pull_url")
    @Expose
    private String gitPullUrl;
    @SerializedName("git_push_url")
    @Expose
    private String gitPushUrl;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("files")
    @Expose
    private Files files;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("user")
    @Expose
    private Object user;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("gitUser")
    @Expose
    private GitUser gitUser;
    @SerializedName("truncated")
    @Expose
    private Boolean truncated;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The forksUrl
     */
    public String getForksUrl() {
        return forksUrl;
    }

    /**
     *
     * @param forksUrl
     * The forks_url
     */
    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    /**
     *
     * @return
     * The commitsUrl
     */
    public String getCommitsUrl() {
        return commitsUrl;
    }

    /**
     *
     * @param commitsUrl
     * The commits_url
     */
    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

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
     * The gitPullUrl
     */
    public String getGitPullUrl() {
        return gitPullUrl;
    }

    /**
     *
     * @param gitPullUrl
     * The git_pull_url
     */
    public void setGitPullUrl(String gitPullUrl) {
        this.gitPullUrl = gitPullUrl;
    }

    /**
     *
     * @return
     * The gitPushUrl
     */
    public String getGitPushUrl() {
        return gitPushUrl;
    }

    /**
     *
     * @param gitPushUrl
     * The git_push_url
     */
    public void setGitPushUrl(String gitPushUrl) {
        this.gitPushUrl = gitPushUrl;
    }

    /**
     *
     * @return
     * The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * @param htmlUrl
     * The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     *
     * @return
     * The files
     */
    public Files getFiles() {
        return files;
    }

    /**
     *
     * @param files
     * The files
     */
    public void setFiles(Files files) {
        this.files = files;
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

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The comments
     */
    public Integer getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     * The comments
     */
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     * The user
     */
    public Object getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(Object user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The commentsUrl
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     *
     * @param commentsUrl
     * The comments_url
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     *
     * @return
     * The gitUser
     */
    public GitUser getGitUser() {
        return gitUser;
    }

    /**
     *
     * @param owner
     * The gitUser
     */
    public void setGitUser(GitUser gitUser) {
        this.gitUser = this.gitUser;
    }

    /**
     *
     * @return
     * The truncated
     */
    public Boolean getTruncated() {
        return truncated;
    }

    /**
     *
     * @param truncated
     * The truncated
     */
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

}