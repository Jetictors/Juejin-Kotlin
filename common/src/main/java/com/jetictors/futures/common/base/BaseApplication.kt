package com.jetictors.futures.common.base

import android.app.Activity
import android.app.Application
import android.os.Bundle

import com.alibaba.android.arouter.launcher.ARouter
import com.jetictors.futures.common.di.component.AppComponent
import com.jetictors.futures.common.di.component.DaggerAppComponent
import com.jetictors.futures.common.di.module.AppModule
import com.jetictors.futures.common.utils.AppContext
import com.jetictors.futures.common.utils.AppManager
import com.jetictors.futures.common.utils.AppUtil
import com.jetictors.futures.common.utils.ScreenUtil


import me.yokeyword.fragmentation.Fragmentation

/**
 * 描述    : 基类 app
 * author  : Jetictors
 * time    :  2018/1/29 17:19
 * version : v1.0.1
 */
open class BaseApplication : Application(){

//    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()

        // 保存appContext的实例
        AppContext.init(this)

//        appComponent = DaggerAppComponent.builder()
//                .appModule(AppModule(this))
//                .build()

        ScreenUtil.init(this)

        if (AppUtil.isDebug()) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }

//        ARouter.init(this) // 尽可能早，推荐在Application中初始化

        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.NONE)
                // ture时，遇到异常："Can not perform this action after onSaveInstanceState!"时，会抛出
                // false时，不会抛出，会捕获，可以在handleException()里监听到
                .debug(AppUtil.isDebug())
                // 线上环境时，可能会遇到上述异常，此时debug=false，不会抛出该异常（避免crash），会捕获
                // 建议在回调处上传至我们的Crash检测服务器
                .handleException {
                    // 以Bugtags为例子: 手动把捕获到的 Exception 传到 Bugtags 后台。
                    // Bugtags.sendException(e);
                }
                .install()

        //添加一个intentsetvice服务来初始化一些服务
        InitializeService.start(this)

        registerActivityLifecycleCallbacks(SwitchBackgroundCallbacks())
    }

    private inner class SwitchBackgroundCallbacks : Application.ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, bundle: Bundle) {
            AppManager.getInstance().addActivity(activity)
        }

        override fun onActivityStarted(activity: Activity) {

        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            AppManager.getInstance().removeActivity(activity)
        }
    }
}
