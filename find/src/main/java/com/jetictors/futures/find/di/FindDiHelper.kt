//package com.jetictors.futures.mime.di
//
//import com.jetictors.futures.common.base.BaseApplication
//import com.jetictors.futures.common.di.module.ActivityModule
//import com.jetictors.futures.common.di.module.FragmentModule
//import com.jetictors.futures.find.di.component.DaggerFindActivityComponent
//import com.jetictors.futures.find.di.component.DaggerFindFragmentComponent
//import com.jetictors.futures.find.di.component.FindActivityComponent
//import com.jetictors.futures.find.di.component.FindFragmentComponent
//
///**
// * 创建者：郑小才
// * 时间 ：2017/10/9 15:07
// * 描述	      ${TODO}
// */
//object FindDiHelper {
//
//    fun getActivityComponent(activityModule: ActivityModule): FindActivityComponent {
//        return DaggerFindActivityComponent.builder()
//                .appComponent(BaseApplication.appComponent)
//                .activityModule(activityModule)
//                .build()
//    }
//
//    fun getFragmentComponent(fragmentModule: FragmentModule): FindFragmentComponent {
//        return DaggerFindFragmentComponent.builder()
//                .appComponent(BaseApplication.appComponent)
//                .fragmentModule(fragmentModule)
//                .build()
//    }
//
//}
