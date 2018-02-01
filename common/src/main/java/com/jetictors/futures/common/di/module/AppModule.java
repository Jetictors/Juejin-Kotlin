package com.jetictors.futures.common.di.module;

import com.jetictors.futures.common.base.BaseApplication;
import com.jetictors.futures.common.di.ContextLife;
import com.jetictors.futures.common.net.HttpHelper;
import com.jetictors.futures.common.net.IDataHelper;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;

/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:52
 * 描述 ：提供一些框架必须的实例的 {@link Module}
 */
@Module
public class AppModule {

    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    BaseApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper() {
        HttpHelper httpHelper=  new HttpHelper(application);
        IDataHelper.NetConfig netConfig= new IDataHelper.NetConfig();
        httpHelper .initConfig(netConfig);

        return httpHelper;
    }

//    @Provides
//    @Singleton
//    DatabaseHelper provideDatabaseHelper() {
//        return new DatabaseHelper(application);
//    }

//    @Provides @NonNull
//    @Singleton
//    public Random random() {
//        return new Random();
//    }

    /**
     * 提供 {@link RxCache}
     *
     * @param cacheDirectory RxCache缓存路径
     * @return
     */
//    @Singleton
//    @Provides
//    RxCache provideRxCache(@Named("RxCacheDirectory") File cacheDirectory) {
//        RxCache.Builder builder = new RxCache.Builder();
//        return builder
//                .persistence(cacheDirectory, new GsonSpeaker());
//    }

}
