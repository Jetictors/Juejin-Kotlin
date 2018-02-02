package com.jetictors.futures.common.di.module

import com.jetictors.futures.common.base.BaseApplication
import com.jetictors.futures.common.di.ContextLife
import com.jetictors.futures.common.net.HttpHelper
import com.jetictors.futures.common.net.IDataHelper
import com.jetictors.futures.common.utils.file.FileUtil
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.rx_cache2.internal.RxCache
import io.victoralbertos.jolyglot.GsonSpeaker
import java.io.File
import javax.inject.Named

/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:52
 * 描述 ：提供一些框架必须的实例的 [Module]
 */
@Module
class AppModule(private val application: BaseApplication) {

    @Provides
    @Singleton
    @ContextLife("Application")
    internal fun provideApplicationContext() = application

    @Provides
    @Singleton
    internal fun provideHttpHelper(): HttpHelper {
        val httpHelper = HttpHelper(application)
        val netConfig = IDataHelper.NetConfig()
        httpHelper.initConfig(netConfig)

        return httpHelper
    }

    /**
     * 提供 [RxCache]
     *
     * @param cacheDirectory RxCache缓存路径
     * @return
     */
    @Singleton
    @Provides
    internal fun provideRxCache(cacheDirectory: File): RxCache {
        val builder = RxCache.Builder()
        return builder
                .persistence(cacheDirectory, GsonSpeaker())
    }

    /**
     * 需要单独给 [RxCache] 提供缓存路径
     *
     * @return
     */
    @Singleton
    @Provides
    internal fun provideRxCacheDirectory(): File {
        val cacheDirectory = File(FileUtil.getCacheDirectory(application), "RxCache")
        return FileUtil.makeDirs(cacheDirectory)
    }
}
