package com.jetictors.futures.common.base.mvp

import java.lang.NullPointerException

/**
 * 描述    : mvp中presenter层接口实现类
 * author  : Jetictors
 * time    :  2018/1/25 11:23
 * version : v1.0.1
 */

open class BasePresenter<V : IBaseView> : IBasePresenter<V>{

    private var mView : V? = null

    override fun attach(view: V) {
        this.mView = view
    }

    override fun detach() {
        this.mView = null
    }

    protected fun getV() : V? {
        if (null == mView){
            NullPointerException("mvp v can not be null !")
        }

        return mView
    }

}