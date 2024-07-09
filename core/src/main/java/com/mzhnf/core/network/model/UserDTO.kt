package com.mzhnf.core.network.model

import com.google.gson.annotations.SerializedName
import com.mzhnf.core.model.UserModel
import com.mzhnf.core.model.UserPref


data class UserDTO(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/92038188?v=4
    @SerializedName("bio")
    val bio: String, // mobile developer
    @SerializedName("blog")
    val blog: String,
    @SerializedName("collaborators")
    val collaborators: Int, // 2
    @SerializedName("company")
    val company: Any?, // null
    @SerializedName("created_at")
    val createdAt: String, // 2021-10-06T14:01:14Z
    @SerializedName("disk_usage")
    val diskUsage: Int, // 30109
    @SerializedName("email")
    val email: Any?, // null
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/mzhanif16/events{/privacy}
    @SerializedName("followers")
    val followers: Int, // 1
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/mzhanif16/followers
    @SerializedName("following")
    val following: Int, // 2
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/mzhanif16/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/mzhanif16/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("hireable")
    val hireable: Any?, // null
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/mzhanif16
    @SerializedName("id")
    val id: Int, // 92038188
    @SerializedName("location")
    val location: Any?, // null
    @SerializedName("login")
    val login: String, // mzhanif16
    @SerializedName("name")
    val name: String, // Muhammad Zaki Hanif
    @SerializedName("node_id")
    val nodeId: String, // U_kgDOBXxkLA
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/mzhanif16/orgs
    @SerializedName("owned_private_repos")
    val ownedPrivateRepos: Int, // 4
    @SerializedName("plan")
    val plan: Plan,
    @SerializedName("private_gists")
    val privateGists: Int, // 0
    @SerializedName("public_gists")
    val publicGists: Int, // 0
    @SerializedName("public_repos")
    val publicRepos: Int, // 16
    @SerializedName("received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/mzhanif16/received_events
    @SerializedName("repos_url")
    val reposUrl: String, // https://api.github.com/users/mzhanif16/repos
    @SerializedName("site_admin")
    val siteAdmin: Boolean, // false
    @SerializedName("starred_url")
    val starredUrl: String, // https://api.github.com/users/mzhanif16/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/mzhanif16/subscriptions
    @SerializedName("total_private_repos")
    val totalPrivateRepos: Int, // 4
    @SerializedName("twitter_username")
    val twitterUsername: Any?, // null
    @SerializedName("two_factor_authentication")
    val twoFactorAuthentication: Boolean, // true
    @SerializedName("type")
    val type: String, // User
    @SerializedName("updated_at")
    val updatedAt: String, // 2024-07-03T13:47:34Z
    @SerializedName("url")
    val url: String // https://api.github.com/users/mzhanif16
)

data class Plan(
    @SerializedName("collaborators")
    val collaborators: Int, // 0
    @SerializedName("name")
    val name: String, // free
    @SerializedName("private_repos")
    val privateRepos: Int, // 10000
    @SerializedName("space")
    val space: Int // 976562499
)

fun UserDTO.toUserPref(token: String) = UserPref(
    login = login,
    id = id,
    nodeId = nodeId,
    avatarUrl = avatarUrl,
    gravatarId = gravatarId,
    url = url,
    htmlUrl = htmlUrl,
    followersUrl = followersUrl,
    followingUrl = followingUrl,
    gistsUrl = gistsUrl,
    starredUrl = starredUrl,
    subscriptionsUrl = subscriptionsUrl,
    organizationsUrl = organizationsUrl,
    reposUrl = reposUrl,
    eventsUrl = eventsUrl,
    receivedEventsUrl = receivedEventsUrl,
    type = type,
    siteAdmin = siteAdmin,
    name = name,
    company = company.toString(),
    blog = blog,
    location = location.toString(),
    email = email.toString(),
    hireable = hireable.toString(),
    bio = bio,
    twitterUsername = twitterUsername.toString(),
    publicRepos = publicRepos,
    publicGists = publicGists,
    followers = followers,
    following = following,
    createdAt = createdAt,
    updatedAt = updatedAt,
    privateGists = privateGists,
    totalPrivateRepos = totalPrivateRepos,
    ownedPrivateRepos = ownedPrivateRepos,
    diskUsage = diskUsage,
    collaborators = collaborators,
    twoFactorAuthentication = twoFactorAuthentication,
    tokenAuth = token
)

fun UserDTO.toUserModel(): UserModel {
    return UserModel(
        data = this
    )
}