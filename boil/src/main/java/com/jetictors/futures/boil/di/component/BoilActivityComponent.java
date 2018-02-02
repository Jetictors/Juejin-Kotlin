package com.jetictors.futures.boil.di.component;

import com.jetictors.futures.common.di.ActivityScope;
import com.jetictors.futures.common.di.component.AppComponent;
import com.jetictors.futures.common.di.module.ActivityModule;

import dagger.Component;

/**
 * 创建者：郑小才
 * 时间 ：2017/10/9 15:07
 * 描述 ：activity的注解使用,限定Context的范围,以及依赖注入的范围
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface BoilActivityComponent {
}
