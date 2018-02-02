package com.jetictors.futures.juejin_kotlin.di.component;

import com.jetictors.futures.common.di.FragmentScope;
import com.jetictors.futures.common.di.component.AppComponent;
import com.jetictors.futures.common.di.module.FragmentModule;

import dagger.Component;


/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:54
 * 描述 ：Fragment里的注解,限定Activity的范围,以及依赖注入的范围为Fragment
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface XFragmentComponent {
}
