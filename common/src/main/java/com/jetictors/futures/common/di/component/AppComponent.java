package com.jetictors.futures.common.di.component;

import com.jetictors.futures.common.base.BaseApplication;
import com.jetictors.futures.common.di.ContextLife;
import com.jetictors.futures.common.di.module.AppModule;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Component;
import io.rx_cache2.internal.RxCache;


/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:53
 * 描述 ：App的注解使用,限定Context的范围,以及依赖BaseDataRepository注入的范围
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    BaseApplication getContext();  // 提供App的Context

    HttpHelper httpHelper();  //提供http的帮助类

//    DatabaseHelper dtabaseHelper();  //提供http的帮助类
    /**
     * {@link Random} instance from {@link AppModule}
     * which now can be injected to children
     * that depend on {@link AppComponent}.
     */
//    Random random();

    RxCache getRxCache();
}
