package com.jetictors.futures.common.base.mvp

/**
 * 描述    : mvp中presenter层接口类
 * author  : Jetictors
 * time    :  2018/1/25 11:14
 * version : v1.0.1
 */

interface IBasePresenter<in V : IBaseView?>{

    fun attach(view: V)

    fun detach()
}