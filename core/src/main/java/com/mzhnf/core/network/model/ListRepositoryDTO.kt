package com.mzhnf.core.network.model
import com.google.gson.annotations.SerializedName
import com.mzhnf.core.model.ListRepositoryModel


class ListRepositoryDTO : ArrayList<ListRepositoryDTOItem>()

data class ListRepositoryDTOItem(
    @SerializedName("allow_forking")
    val allowForking: Boolean, // true
    @SerializedName("archive_url")
    val archiveUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/{archive_format}{/ref}
    @SerializedName("archived")
    val archived: Boolean, // false
    @SerializedName("assignees_url")
    val assigneesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/assignees{/user}
    @SerializedName("blobs_url")
    val blobsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/git/blobs{/sha}
    @SerializedName("branches_url")
    val branchesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/branches{/branch}
    @SerializedName("clone_url")
    val cloneUrl: String, // https://github.com/mzhanif16/app_hanif.git
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/collaborators{/collaborator}
    @SerializedName("comments_url")
    val commentsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/comments{/number}
    @SerializedName("commits_url")
    val commitsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/commits{/sha}
    @SerializedName("compare_url")
    val compareUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/compare/{base}...{head}
    @SerializedName("contents_url")
    val contentsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/contents/{+path}
    @SerializedName("contributors_url")
    val contributorsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/contributors
    @SerializedName("created_at")
    val createdAt: String, // 2022-07-25T23:52:12Z
    @SerializedName("default_branch")
    val defaultBranch: String, // master
    @SerializedName("deployments_url")
    val deploymentsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/deployments
    @SerializedName("description")
    val description: String?, // main
    @SerializedName("disabled")
    val disabled: Boolean, // false
    @SerializedName("downloads_url")
    val downloadsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/downloads
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/events
    @SerializedName("fork")
    val fork: Boolean, // false
    @SerializedName("forks")
    val forks: Int, // 0
    @SerializedName("forks_count")
    val forksCount: Int, // 0
    @SerializedName("forks_url")
    val forksUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/forks
    @SerializedName("full_name")
    val fullName: String, // mzhanif16/app_hanif
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/git/commits{/sha}
    @SerializedName("git_refs_url")
    val gitRefsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/git/refs{/sha}
    @SerializedName("git_tags_url")
    val gitTagsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/git/tags{/sha}
    @SerializedName("git_url")
    val gitUrl: String, // git://github.com/mzhanif16/app_hanif.git
    @SerializedName("has_discussions")
    val hasDiscussions: Boolean, // false
    @SerializedName("has_downloads")
    val hasDownloads: Boolean, // true
    @SerializedName("has_issues")
    val hasIssues: Boolean, // true
    @SerializedName("has_pages")
    val hasPages: Boolean, // false
    @SerializedName("has_projects")
    val hasProjects: Boolean, // true
    @SerializedName("has_wiki")
    val hasWiki: Boolean, // true
    @SerializedName("homepage")
    val homepage: Any?, // null
    @SerializedName("hooks_url")
    val hooksUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/hooks
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/mzhanif16/app_hanif
    @SerializedName("id")
    val id: Int, // 517854048
    @SerializedName("is_template")
    val isTemplate: Boolean, // false
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/issues/comments{/number}
    @SerializedName("issue_events_url")
    val issueEventsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/issues/events{/number}
    @SerializedName("issues_url")
    val issuesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/issues{/number}
    @SerializedName("keys_url")
    val keysUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/keys{/key_id}
    @SerializedName("labels_url")
    val labelsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/labels{/name}
    @SerializedName("language")
    val language: String, // Dart
    @SerializedName("languages_url")
    val languagesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/languages
    @SerializedName("license")
    val license: Any?, // null
    @SerializedName("merges_url")
    val mergesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/merges
    @SerializedName("milestones_url")
    val milestonesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/milestones{/number}
    @SerializedName("mirror_url")
    val mirrorUrl: Any?, // null
    @SerializedName("name")
    val name: String, // app_hanif
    @SerializedName("node_id")
    val nodeId: String, // R_kgDOHt3TYA
    @SerializedName("notifications_url")
    val notificationsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/notifications{?since,all,participating}
    @SerializedName("open_issues")
    val openIssues: Int, // 0
    @SerializedName("open_issues_count")
    val openIssuesCount: Int, // 0
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("permissions")
    val permissions: Permissions,
    @SerializedName("private")
    val `private`: Boolean, // false
    @SerializedName("pulls_url")
    val pullsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/pulls{/number}
    @SerializedName("pushed_at")
    val pushedAt: String, // 2022-07-25T23:52:19Z
    @SerializedName("releases_url")
    val releasesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/releases{/id}
    @SerializedName("size")
    val size: Int, // 112
    @SerializedName("ssh_url")
    val sshUrl: String, // git@github.com:mzhanif16/app_hanif.git
    @SerializedName("stargazers_count")
    val stargazersCount: Int, // 0
    @SerializedName("stargazers_url")
    val stargazersUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/stargazers
    @SerializedName("statuses_url")
    val statusesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/statuses/{sha}
    @SerializedName("subscribers_url")
    val subscribersUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/subscribers
    @SerializedName("subscription_url")
    val subscriptionUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/subscription
    @SerializedName("svn_url")
    val svnUrl: String, // https://github.com/mzhanif16/app_hanif
    @SerializedName("tags_url")
    val tagsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/tags
    @SerializedName("teams_url")
    val teamsUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/teams
    @SerializedName("topics")
    val topics: List<Any>,
    @SerializedName("trees_url")
    val treesUrl: String, // https://api.github.com/repos/mzhanif16/app_hanif/git/trees{/sha}
    @SerializedName("updated_at")
    val updatedAt: String, // 2022-07-25T23:52:23Z
    @SerializedName("url")
    val url: String, // https://api.github.com/repos/mzhanif16/app_hanif
    @SerializedName("visibility")
    val visibility: String, // public
    @SerializedName("watchers")
    val watchers: Int, // 0
    @SerializedName("watchers_count")
    val watchersCount: Int, // 0
    @SerializedName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean // false
)

data class Owner(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/92038188?v=4
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/mzhanif16/events{/privacy}
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/mzhanif16/followers
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/mzhanif16/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/mzhanif16/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/mzhanif16
    @SerializedName("id")
    val id: Int, // 92038188
    @SerializedName("login")
    val login: String, // mzhanif16
    @SerializedName("node_id")
    val nodeId: String, // U_kgDOBXxkLA
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/mzhanif16/orgs
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
    @SerializedName("type")
    val type: String, // User
    @SerializedName("url")
    val url: String // https://api.github.com/users/mzhanif16
)

data class Permissions(
    @SerializedName("admin")
    val admin: Boolean, // true
    @SerializedName("maintain")
    val maintain: Boolean, // true
    @SerializedName("pull")
    val pull: Boolean, // true
    @SerializedName("push")
    val push: Boolean, // true
    @SerializedName("triage")
    val triage: Boolean // true
)

fun ListRepositoryDTO.toListRepositoryModel(): ListRepositoryModel{
    return ListRepositoryModel(
        data = this
    )
}