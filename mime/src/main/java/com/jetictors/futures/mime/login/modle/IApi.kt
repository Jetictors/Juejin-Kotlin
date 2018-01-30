package com.jetictors.futures.mime.login.modle

import com.jetictors.futures.common.net.data.JuejinResponse
import com.jetictors.futures.mime.login.modle.enity.UserEnity
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 描述    : 登录模块Api
 * author  : Jetictors
 * time    :  2018/1/29 14:08
 * version : v1.0.1
 */

@ApiFactory.BaseUrl("https://auth-center-ms.juejin.im/")
interface IApi{

    @FormUrlEncoded
    @POST("v1/login")
    fun login(
            @Field("login_type") login_type: String,
            @Field("user") user: String = "tel",
            @Field("psd") psd: String = "tel",
            @Field("client_id") client_id: String,
            @Field("state") state: String = "nOOKnTFSCE",
            @Field("src") src: String = "android") : Flowable<JuejinResponse<UserEnity>>



}