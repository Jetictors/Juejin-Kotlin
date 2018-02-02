package com.jetictors.futures.common.base

import android.app.IntentService
import android.content.Context
import android.content.Intent

import com.alibaba.android.arouter.launcher.ARouter
import com.jetictors.futures.common.utils.AppUtil
import com.jetictors.futures.common.utils.logger.KLog

/**
 * 创建者：邓浩宸
 * 时间 ：2017/5/23 12:52
 * 描述 ：初始化的服务
 */
class InitializeService : IntentService("InitializeService") {

    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val action = intent.action
            if (ACTION_INIT_WHEN_APP_CREATE == action) {
                performInit()
            }
        }
    }

    private fun performInit() {
        //log日志
        KLog.init("dhc").hideThreadInfo().methodCount(1)

        if (AppUtil.isDebug()) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this.application) // 尽可能早，推荐在Application中初始化

        //初始化过度绘制检测
        //BlockCanary.install(this, new AppBlockCanaryContext()).start();

    }

    companion object {

        private val ACTION_INIT_WHEN_APP_CREATE = "com.kairu.library.base.action.INIT"

        fun start(context: Context) {
            val intent = Intent(context, InitializeService::class.java)
            intent.action = ACTION_INIT_WHEN_APP_CREATE
            context.startService(intent)
        }
    }
}