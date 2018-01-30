package com.jetictors.futures.mime.login.presenter

import com.jetictors.futures.common.base.mvp.BasePresenter
import com.jetictors.futures.mime.login.presenter.contract.IForgetPwdContract

/**
 * 描述    : 忘记密码页的presenter
 * author  : Jetictors
 * time    :  2018/1/29 13:43
 * version : v1.0.1
 */

class ForgetPwdPresenter : BasePresenter<IForgetPwdContract.IForgetPwdView>(), IForgetPwdContract.IForgetPwdPresenter {

    override fun forgetPwd(email: String) {
    }

    override fun forgetPwd(phone: String, verify: String) {
    }

}