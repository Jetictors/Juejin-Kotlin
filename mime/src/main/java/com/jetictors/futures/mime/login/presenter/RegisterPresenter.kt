package com.jetictors.futures.mime.login.presenter

import com.jetictors.futures.common.base.mvp.BasePresenter
import com.jetictors.futures.mime.login.presenter.contract.IRegisterContract

/**
 * 描述    : 注册页的presenter
 * author  : Jetictors
 * time    :  2018/1/29 13:43
 * version : v1.0.1
 */

class RegisterPresenter : BasePresenter<IRegisterContract.IRegisterView>(),IRegisterContract.IRegisterPresenter {

    override fun register() {
    }

}