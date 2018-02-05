package com.jetictors.futures.common.base

import android.app.Application
import android.content.Context
import android.content.res.Configuration

import com.jetictors.futures.common.utils.ApplicationLike
import com.jetictors.futures.common.utils.logger.KLog

/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/23 18:04
 * 描述 ：该Application只能放在子moudle中使用,用于moudle隔离
 */

open class BaseChildApplication : BaseApplication(), ApplicationLike {

    override fun onCreate() {
        super.onCreate()
        onCreateAsLibrary(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        onLowMemoryAsLibrary(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        onTrimMemoryAsLibrary(this, level)
    }

    override fun onTerminate() {
        super.onTerminate()
        onTerminate(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        onConfigurationChanged(this, newConfig)
    }

    override fun onTerminate(application: Application) {
        KLog.d(this.javaClass.name + "onTerminate")
    }

    override fun onCreateAsLibrary(application: Application) {
        KLog.d(this.javaClass.name + "onCreateAsLibrary")
    }

    override fun onLowMemoryAsLibrary(application: Application) {
        KLog.d(this.javaClass.name + "onLowMemoryAsLibrary")
    }

    override fun onTrimMemoryAsLibrary(application: Application, level: Int) {
        KLog.d(this.javaClass.name + "onTrimMemoryAsLibrary")
    }

    override fun onConfigurationChanged(application: Application, configuration: Configuration) {
        KLog.d(this.javaClass.name + "onConfigurationChanged")
    }

    /**
     * arouter定义的启动之前的初始化(可以忽略)
     */
    override fun init(context: Context) {

    }


}
