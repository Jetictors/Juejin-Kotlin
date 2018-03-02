//package com.jetictors.futures.juejin_kotlin.di
//
//import com.jetictors.futures.common.base.BaseApplication
//import com.jetictors.futures.common.di.module.ActivityModule
//import com.jetictors.futures.common.di.module.FragmentModule
//import com.jetictors.futures.juejin_kotlin.di.component.DaggerXActivityComponent
//import com.jetictors.futures.juejin_kotlin.di.component.DaggerXFragmentComponent
//import com.jetictors.futures.juejin_kotlin.di.component.XActivityComponent
//import com.jetictors.futures.juejin_kotlin.di.component.XFragmentComponent
//
///**
// * 创建者     邓浩宸
// * 创建时间   2017/3/24 8:54
// * 描述	      ${TODO}
// */
//object XDiHelper {
//
//    fun getActivityComponent(activityModule: ActivityModule): XActivityComponent {
//        return DaggerXActivityComponent.builder()
//                .appComponent(BaseApplication.appComponent)
//                .activityModule(activityModule)
//                .build()
//    }
//
//
//    fun getFragmentComponent(fragmentModule: FragmentModule): XFragmentComponent {
//        return DaggerXFragmentComponent.builder()
//                .appComponent(BaseApplication.appComponent)
//                .fragmentModule(fragmentModule)
//                .build()
//    }
//
//
//}
