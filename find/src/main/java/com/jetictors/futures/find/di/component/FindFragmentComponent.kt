package com.jetictors.futures.find.di.component

import com.jetictors.futures.common.di.FragmentScope
import com.jetictors.futures.common.di.component.AppComponent
import com.jetictors.futures.common.di.module.FragmentModule

import dagger.Component

/**
 * 创建者：郑小才
 * 时间 ：2017/10/9 15:07
 * 描述 ：Fragment里的注解,限定Activity的范围,以及依赖注入的范围为Fragment
 */
@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FindFragmentComponent
