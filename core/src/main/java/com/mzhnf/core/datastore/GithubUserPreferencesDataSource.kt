package com.mzhnf.core.datastore

import androidx.datastore.core.DataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mzhnf.core.model.UserPref
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GithubUserPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
) {
    suspend fun saveUserData(userPref: UserPref){
        this.userPreferences.updateData {
            it.copy {
                login = userPref.login
                id = userPref.id
                nodeId = userPref.nodeId
                avatarUrl = userPref.avatarUrl
                gravatarId = userPref.gravatarId
                url = userPref.url
                htmlUrl = userPref.htmlUrl
                followersUrl = userPref.followersUrl
                followingUrl = userPref.followingUrl
                gistsUrl = userPref.gistsUrl
                starredUrl = userPref.starredUrl
                subscriptionsUrl = userPref.subscriptionsUrl
                organizationsUrl = userPref.organizationsUrl
                reposUrl = userPref.reposUrl
                eventsUrl = userPref.eventsUrl
                receivedEventsUrl = userPref.receivedEventsUrl
                type = userPref.type
                siteAdmin = userPref.siteAdmin
                name = userPref.name.toString()
                company = userPref.company.toString()
                blog = userPref.blog
                location = userPref.location.toString()
                email = userPref.email.toString()
                hireable = userPref.hireable.toString()
                bio = userPref.bio
                twitterUsername = userPref.twitterUsername.toString()
                publicRepos = userPref.publicRepos
                publicGists = userPref.publicGists
                followers = userPref.followers
                following = userPref.following
                createdAt = userPref.createdAt
                updatedAt = userPref.updatedAt
                privateGists = userPref.privateGists
                totalPrivateRepos = userPref.totalPrivateRepos
                ownedPrivateRepos = userPref.ownedPrivateRepos
                diskUsage = userPref.diskUsage
                collaborators = userPref.collaborators
                twoFactorAuthentication = userPref.twoFactorAuthentication
                tokenAuth = userPref.tokenAuth
            }
        }
    }
    suspend fun getToken() : String {
        return this.userPreferences.data.first().tokenAuth
    }

    suspend fun getIsLogin(): Boolean{
        return userPreferences.data.first().login != null
    }

    suspend fun getUserData(): LiveData<UserPref> {
        val userPref: MutableLiveData<UserPref> = MutableLiveData()
        val preferences = userPreferences.data.first()
        userPref.value = UserPref(
            login = preferences.login,
            id = preferences.id,
            nodeId = preferences.nodeId,
            avatarUrl = preferences.avatarUrl,
            gravatarId = preferences.gravatarId,
            url = preferences.url,
            htmlUrl = preferences.htmlUrl,
            followersUrl = preferences.followersUrl,
            followingUrl = preferences.followingUrl,
            gistsUrl = preferences.gistsUrl,
            starredUrl = preferences.starredUrl,
            subscriptionsUrl = preferences.subscriptionsUrl,
            organizationsUrl = preferences.organizationsUrl,
            reposUrl = preferences.reposUrl,
            eventsUrl = preferences.eventsUrl,
            receivedEventsUrl = preferences.receivedEventsUrl,
            type = preferences.type,
            siteAdmin = preferences.siteAdmin,
            name = preferences.name,
            company = preferences.company,
            blog = preferences.blog,
            location = preferences.location,
            email = preferences.email,
            hireable = preferences.hireable,
            bio = preferences.bio,
            twitterUsername = preferences.twitterUsername,
            publicRepos = preferences.publicRepos,
            publicGists = preferences.publicGists,
            followers = preferences.followers,
            following = preferences.following,
            createdAt = preferences.createdAt,
            updatedAt = preferences.updatedAt,
            privateGists = preferences.privateGists,
            totalPrivateRepos = preferences.totalPrivateRepos,
            ownedPrivateRepos = preferences.ownedPrivateRepos,
            diskUsage = preferences.diskUsage,
            collaborators = preferences.collaborators,
            twoFactorAuthentication = preferences.twoFactorAuthentication,
            tokenAuth = preferences.tokenAuth
        )
        return userPref
    }
}