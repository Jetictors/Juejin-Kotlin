package com.jetictors.futures.mime.di

import com.jetictors.futures.common.base.BaseApplication
import com.jetictors.futures.common.di.module.ActivityModule
import com.jetictors.futures.common.di.module.FragmentModule
import com.jetictors.futures.mime.di.component.MimeActivityComponent
import com.jetictors.futures.mime.di.component.MimeFragmentComponent

/**
 * 创建者：郑小才
 * 时间 ：2017/10/9 15:07
 * 描述	      ${TODO}
 */
object MimeDiHelper {

    fun getActivityComponent(activityModule: ActivityModule): MimeActivityComponent {
        return DaggerMimeActivityComponent.builder()
                .appComponent(BaseApplication.appComponent)
                .activityModule(activityModule)
                .build()
    }

    fun getFragmentComponent(fragmentModule: FragmentModule): MimeFragmentComponent {
        return DaggerMimeFragmentComponent.builder()
                .appComponent(BaseApplication.appComponent)
                .fragmentModule(fragmentModule)
                .build()
    }

}
