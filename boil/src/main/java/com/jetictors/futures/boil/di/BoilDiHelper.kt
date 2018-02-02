package com.jetictors.futures.mime.di

import com.jetictors.futures.boil.di.component.BoilActivityComponent
import com.jetictors.futures.boil.di.component.BoilFragmentComponent
import com.jetictors.futures.common.base.BaseApplication
import com.jetictors.futures.common.di.module.ActivityModule
import com.jetictors.futures.common.di.module.FragmentModule

/**
 * 创建者：郑小才
 * 时间 ：2017/10/9 15:07
 * 描述	      ${TODO}
 */
object BoilDiHelper {

    fun getActivityComponent(activityModule: ActivityModule): BoilActivityComponent {
        return DaggerBoilActivityComponent.builder()
                .appComponent(BaseApplication.appComponent)
                .activityModule(activityModule)
                .build()
    }

    fun getFragmentComponent(fragmentModule: FragmentModule): BoilFragmentComponent {
        return DaggerBoilFragmentComponent.builder()
                .appComponent(BaseApplication.appComponent)
                .fragmentModule(fragmentModule)
                .build()
    }

}
