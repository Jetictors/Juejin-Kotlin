//package com.jetictors.futures.mime.di
//
//import com.jetictors.futures.common.base.BaseApplication
//import com.jetictors.futures.common.di.module.ActivityModule
//import com.jetictors.futures.common.di.module.FragmentModule
//import com.jetictors.futures.home.di.component.DaggerHomeActivityComponent
//import com.jetictors.futures.home.di.component.DaggerHomeFragmentComponent
//import com.jetictors.futures.home.di.component.HomeActivityComponent
//import com.jetictors.futures.home.di.component.HomeFragmentComponent
//
///**
// * 创建者：郑小才
// * 时间 ：2017/10/9 15:07
// * 描述	      ${TODO}
// */
//object HomeDiHelper {
//
//    fun getActivityComponent(activityModule: ActivityModule): HomeActivityComponent {
//        return DaggerHomeActivityComponent.builder()
//                .appComponent(BaseApplication.appComponent)
//                .activityModule(activityModule)
//                .build()
//    }
//
//    fun getFragmentComponent(fragmentModule: FragmentModule): HomeFragmentComponent {
//        return DaggerHomeFragmentComponent.builder()
//                .appComponent(BaseApplication.appComponent)
//                .fragmentModule(fragmentModule)
//                .build()
//    }
//
//}
