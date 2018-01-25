package com.jetictors.futures.common.di.module

import android.app.Activity

import com.jetictors.futures.common.di.ActivityScope

import dagger.Module
import dagger.Provides

/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:52
 * 描述 ：TODO 请描述该类职责
 */
@Module
class ActivityModule(private val mActivity: Activity) {
    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return mActivity
    }
}
