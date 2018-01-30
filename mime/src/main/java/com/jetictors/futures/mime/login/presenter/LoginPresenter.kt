package com.jetictors.futures.mime.login.presenter

import com.jetictors.futures.common.base.mvp.BasePresenter
import com.jetictors.futures.mime.login.presenter.contract.ILoginContract

/**
 * 描述    : 登录页的presenter
 * author  : Jetictors
 * time    :  2018/1/29 13:43
 * version : v1.0.1
 */

class LoginPresenter : BasePresenter<ILoginContract.ILoginView>(),ILoginContract.ILoginPresenter {

    override fun login() {

    }

}