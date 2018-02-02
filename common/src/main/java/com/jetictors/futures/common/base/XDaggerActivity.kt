//package com.jetictors.futures.common.base
//
//import android.content.Context
//import android.os.Bundle
//
//import com.jetictors.futures.common.base.mvp.IBasePresenter
//import com.jetictors.futures.common.base.mvp.IBaseView
//import com.jetictors.futures.common.di.module.ActivityModule
//import com.trello.rxlifecycle2.LifecycleTransformer
//
//import javax.inject.Inject
//
//
///**
// * 创建者：邓浩宸
// * 时间 ：2016/11/15 16:06
// * 描述 ：MVP activity基类
// */
//abstract class XDaggerActivity<P : IBasePresenter<IBaseView>> : BaseActivity(), IBaseView {
//
//    @Inject
//    protected var mPresenter: P? = null
//
//
//    protected val activityModule: ActivityModule
//        get() = ActivityModule(this)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        mPresenter?.attach(this)
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//
//
//    override fun <E> bindLifecycle(): LifecycleTransformer<E> {
//        return this.bindToLifecycle()
//    }
//
//
//    override fun getAContext(): Context {
//        return this
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter?.detach()
//    }
//
//}