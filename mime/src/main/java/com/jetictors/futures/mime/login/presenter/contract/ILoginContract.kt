package com.jetictors.futures.mime.login.presenter.contract

import com.jetictors.futures.common.base.mvp.IBaseModel
import com.jetictors.futures.common.base.mvp.IBasePresenter
import com.jetictors.futures.common.base.mvp.IBaseView

/**
 * 描述    : 登录页mvp接口契约类
 * author  : Jetictors
 * time    :  2018/1/29 13:44
 * version : v1.0.1
 */
interface ILoginContract{

    interface ILoginView : IBaseView{

        fun loginSuccess()

        fun loginFailed()
    }

    interface ILoginPresenter : IBasePresenter<ILoginView>{

        fun login()
    }

    interface ILoginModel : IBaseModel{

    }
}