package com.jetictors.futures.mime.login.presenter.contract

import com.jetictors.futures.common.base.mvp.IBaseModel
import com.jetictors.futures.common.base.mvp.IBasePresenter
import com.jetictors.futures.common.base.mvp.IBaseView

/**
 * 描述    :  注册页mvp接口契约类
 * author  : Jetictors
 * time    :  2018/1/29 13:52
 * version : v1.0.1
 */

interface IRegisterContract{

    interface IRegisterView : IBaseView{

        fun registerSuccess()

        fun registerFailed()
    }

    interface IRegisterPresenter : IBasePresenter<IRegisterView> {

        fun register()

    }

    interface IRegisterModel : IBaseModel{

    }
}