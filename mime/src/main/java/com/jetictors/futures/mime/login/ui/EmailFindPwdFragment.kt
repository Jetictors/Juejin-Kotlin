package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * 描述    : 邮箱找回密码页面
 * author  : Jetictors
 * time    :  2018/1/29 17:22
 * version : v1.0.1
 */
class EmailFindPwdFragment : BaseFragment(){

    companion object {
        fun newInstance() = EmailFindPwdFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_forget_pwd_by_email
    }

    override fun initEventAndData(view: View?) {
        initListener()
    }

    private fun initListener() {

    }
}
