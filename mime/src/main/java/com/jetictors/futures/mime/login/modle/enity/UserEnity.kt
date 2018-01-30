package com.jetictors.futures.mime.login.modle.enity

/**
 * 描述    : 用户实体对象
 * author  : Jetictors
 * time    :  2018/1/29 15:46
 * version : v1.0.1
 */

data class UserEnity(
    val editor : String,
    val username : String,
    val selfDescription : String,
    val email : String,
    val mobilePhoneNumber : String,
    val jobTitle : String,
    val company : String,
    val avatarHd : String,
    val avatarLarge : String,
    val blogAddress : String,
    val deviceType : String,
    val editorType : String,
    val allowNotification : Boolean,
    val emailVerified : Boolean,
    val mobilePhoneVerified : Boolean,
    val isAuthor : Boolean,
    val isUnitedAuthor : Boolean,
    val blacklist : Boolean,
    val followeesCount : Int,
    val followersCount : Int,
    val postedPostsCount : Int,
    val postedEntriesCount : Int,
    val collectedEntriesCount : Int,
    val viewedEntriesCount : Int,
    val subscribedTagsCount : Int,
    val totalCollectionsCount : Int,
    val totalViewsCount : Int,
    val totalCommentsCount : Int,
    val latestLoginedInAt : String,
    val createdAt : String,
    val updatedAt : String,
    val collectionSetCount : Int,
    val useLeancloudPwd : Boolean,
    val objectId : String,
    val uid : String
) {
    /*
         role : editor
         username : Jetictors
         selfDescription : 热爱编程、技术...
         email :
         mobilePhoneNumber : 18818276018
         jobTitle : Android
         company : 上海
         avatarHd : https://avatars.githubusercontent.com/u/15076541?v=3
         avatarLarge : https://avatars.githubusercontent.com/u/15076541?v=3
         blogAddress : http://blog.csdn.net/a153614131
         deviceType : android
         editorType : markdown
         allowNotification : false
         emailVerified : false
         mobilePhoneVerified : false
         isAuthor : true
         isUnitedAuthor : false
         blacklist : false
         followeesCount : 116
         followersCount : 39
         postedPostsCount : 5
         postedEntriesCount : 5
         collectedEntriesCount : 238
         viewedEntriesCount : 1832
         subscribedTagsCount : 18
         totalCollectionsCount : 1349
         totalViewsCount : 35326
         totalCommentsCount : 73
         latestLoginedInAt : 2017-09-12T10:55:48.674Z
         createdAt : 2016-08-24T04:43:32.001Z
         updatedAt : 2017-09-12T12:10:05.860Z
         collectionSetCount : 28
         useLeancloudPwd : false
         objectId : 57bd25f4a34131005b211b84
         uid : 57bd25f4a34131005b211b84
     */
}