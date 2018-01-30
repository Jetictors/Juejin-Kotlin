package com.jetictors.futures.common.net.data

/**
 * 描述    : 接口返回数据
 * author  : Jetictors
 * time    :  2018/1/29 15:07
 * version : v1.0.1
 */

data class JuejinResponse<T>(
        val s : Int,
        val m : Message,
        val d : T?
)

data class Message(
        val missing : String,
        val illegal : String
)