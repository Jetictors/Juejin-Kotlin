package com.jetictors.futures.common.base

import android.content.Context
import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.mvp.BasePresenter

import com.jetictors.futures.common.base.mvp.IBasePresenter
import com.jetictors.futures.common.base.mvp.IBaseView
import com.jetictors.futures.common.di.module.FragmentModule
import com.trello.rxlifecycle2.LifecycleTransformer

import javax.inject.Inject

/**
 * 创建者：邓浩宸
 * 时间 ：2016/11/15 16:07
 * 描述 ：MVP Fragment基类
 */
abstract class XDaggerFragment<P : IBasePresenter<IBaseView>> : BaseFragment(), IBaseView {

    @Inject
    protected var mPresenter: P? = null
    var isShowView = false

    protected val fragmentModule: FragmentModule
        get() = FragmentModule(this)

    override fun <E> bindLifecycle(): LifecycleTransformer<E> = this.bindToLifecycle()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        isShowView = true
        mPresenter?.attach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getAContext(): Context = _mActivity

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
    }
}