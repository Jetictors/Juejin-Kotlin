package com.jetictors.futures.common.base.mvp

import android.content.Context
import com.trello.rxlifecycle2.LifecycleTransformer

/**
 * 描述    : mvp中view层接口类
 * author  : Jetictors
 * time    :  2018/1/25 11:07
 * version : v1.0.1
 */
interface IBaseView{

    fun <T> bindLifecycle(): LifecycleTransformer<T>

    fun getAContext(): Context

}