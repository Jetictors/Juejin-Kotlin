package com.jetictors.futures.common.di.module

import android.app.Activity
import android.support.v4.app.Fragment

import com.jetictors.futures.common.di.FragmentScope

import dagger.Module
import dagger.Provides


/**
 * 创建者：邓浩宸
 * 时间 ：2017/3/21 10:53
 * 描述 ：TODO 请描述该类职责
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideActivity(): Activity {
        return fragment.activity
    }
}
