package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * 描述    : 手机找回密码页面
 * author  : Jetictors
 * time    :  2018/1/29 17:22
 * version : v1.0.1
 */
class PhoneFindPwdFragment : BaseFragment(){

    companion object {
        fun newInstance() = PhoneFindPwdFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_forget_pwd_by_phone
    }

    override fun initEventAndData(view: View?) {
    }
}