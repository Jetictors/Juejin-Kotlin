package com.jetictors.futures.juejin_kotlin.app

import android.content.Context
import android.content.res.Configuration
import android.support.v7.app.AppCompatDelegate

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.jetictors.futures.common.base.BaseApplication
import com.jetictors.futures.common.utils.ApplicationLike
import com.jetictors.futures.common.utils.AsLibUtil

/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:51
 * 描述 ：app 初始化
 */
class App : BaseApplication() {

    @Autowired(name = "/home/application1")
    internal var mApplicationLikeMoudle1: ApplicationLike? = null
    @Autowired(name = "/my/application2")
    internal var mApplicationLikeMoudle2: ApplicationLike? = null

    override fun onCreate() {
        super.onCreate()

        ARouter.getInstance().inject(this)
        if (mApplicationLikeMoudle1 != null) {
            AsLibUtil.addAsLIbChild(mApplicationLikeMoudle1)
        }

        if (mApplicationLikeMoudle2 != null) {
            AsLibUtil.addAsLIbChild(mApplicationLikeMoudle2)
        }

        AsLibUtil.doCreateAsLibrary(this)
    }


    override fun onLowMemory() {
        super.onLowMemory()
        AsLibUtil.onLowMemoryAsLibrary(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        AsLibUtil.onTrimMemoryAsLibrary(this, level)
    }

    override fun onTerminate() {
        super.onTerminate()
        AsLibUtil.onTerminate(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        AsLibUtil.onConfigurationChanged(this, newConfig)
    }

    companion object {

        val instance: BaseApplication
            @Synchronized get() = instance

        init {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO)
        }

        fun app(context: Context): App {
            return context.applicationContext as App
        }
    }

}
