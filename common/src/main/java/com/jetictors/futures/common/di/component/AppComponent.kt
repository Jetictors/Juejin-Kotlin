package com.jetictors.futures.common.di.component

import com.jetictors.futures.common.base.BaseApplication
import com.jetictors.futures.common.di.ContextLife
import com.jetictors.futures.common.di.module.AppModule
import com.jetictors.futures.common.net.HttpHelper

import javax.inject.Singleton

import dagger.Component
import io.rx_cache2.internal.RxCache

/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:53
 * 描述 ：App的注解使用,限定Context的范围,以及依赖BaseDataRepository注入的范围
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @get:ContextLife("Application")
    val context: BaseApplication  // 提供App的Context

    val rxCache: RxCache           // 缓存

    fun httpHelper(): HttpHelper   //提供http的帮助类
}
