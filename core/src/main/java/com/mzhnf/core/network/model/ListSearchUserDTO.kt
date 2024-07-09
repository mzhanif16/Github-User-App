package com.mzhnf.core.network.model
import com.google.gson.annotations.SerializedName
import com.mzhnf.core.model.SearchUserModel


data class ListSearchUserDTO(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean, // false
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int // 3
)

data class Item(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/10069913?v=4
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/mzhanif/events{/privacy}
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/mzhanif/followers
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/mzhanif/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/mzhanif/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/mzhanif
    @SerializedName("id")
    val id: Int, // 10069913
    @SerializedName("login")
    val login: String, // mzhanif
    @SerializedName("node_id")
    val nodeId: String, // MDQ6VXNlcjEwMDY5OTEz
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/mzhanif/orgs
    @SerializedName("received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/mzhanif/received_events
    @SerializedName("repos_url")
    val reposUrl: String, // https://api.github.com/users/mzhanif/repos
    @SerializedName("score")
    val score: Double, // 1.0
    @SerializedName("site_admin")
    val siteAdmin: Boolean, // false
    @SerializedName("starred_url")
    val starredUrl: String, // https://api.github.com/users/mzhanif/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/mzhanif/subscriptions
    @SerializedName("type")
    val type: String, // User
    @SerializedName("url")
    val url: String // https://api.github.com/users/mzhanif
)

fun ListSearchUserDTO.toSearchUserModel(): SearchUserModel {
    return SearchUserModel(
        data = items
    )
}