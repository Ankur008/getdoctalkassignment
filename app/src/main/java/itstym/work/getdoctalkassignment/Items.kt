package itstym.work.getdoctalkassignment

import android.content.Context
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by itstym on 29/9/17.
 */

 data class Items(val context: Context){

    @SerializedName("login")
    @Expose
    public val login: String? = null
    @SerializedName("id")
    @Expose
    public val id: Int? = null
    @SerializedName("avatar_url")
    @Expose
    public val avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    public val gravatarId: String? = null
    @SerializedName("url")
    @Expose
    public val url: String? = null
    @SerializedName("html_url")
    @Expose
    public val htmlUrl: String? = null
    @SerializedName("followers_url")
    @Expose
    public val followersUrl: String? = null
    @SerializedName("following_url")
    @Expose
    public val followingUrl: String? = null
    @SerializedName("gists_url")
    @Expose
    public val gistsUrl: String? = null
    @SerializedName("starred_url")
    @Expose
    public val starredUrl: String? = null
    @SerializedName("subscriptions_url")
    @Expose
    public val subscriptionsUrl: String? = null
    @SerializedName("organizations_url")
    @Expose
    public val organizationsUrl: String? = null
    @SerializedName("repos_url")
    @Expose
    public val reposUrl: String? = null
    @SerializedName("events_url")
    @Expose
    public val eventsUrl: String? = null
    @SerializedName("received_events_url")
    @Expose
    public val receivedEventsUrl: String? = null
    @SerializedName("type")
    @Expose
    public val type: String? = null
    @SerializedName("site_admin")
    @Expose
    public val siteAdmin: Boolean? = null
    @SerializedName("score")
    @Expose
    public val score: Double? = null
}