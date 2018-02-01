package com.jetictors.futures.mime.login.presenter.contract

import com.jetictors.futures.common.base.mvp.IBaseModel
import com.jetictors.futures.common.base.mvp.IBasePresenter
import com.jetictors.futures.common.base.mvp.IBaseView

/**
 * 描述    : 忘记密码页mvp接口契约类
 * author  : Jetictors
 * time    :  2018/1/29 13:44
 * version : v1.0.1
 */
interface IForgetPwdContract {

    interface IForgetPwdView : IBaseView {

        fun forgetPwdSuccess()

        fun forgetPwdFailed()
    }

    interface IForgetPwdPresenter : IBasePresenter<IForgetPwdView> {

        fun forgetPwd(email : String)

        fun forgetPwd(phone : String, verify : String)
    }

    interface IForgetPwdModel : IBaseModel {
    }
}