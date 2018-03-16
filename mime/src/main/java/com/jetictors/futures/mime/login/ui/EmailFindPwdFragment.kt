package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_forget_pwd_by_email.*

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
        initData()
        initListener()
    }

    private fun initData() {

    }

    private fun initListener() {
        // 发送邮件
        btn_commit_email.setOnClickListener {

        }

        // 回到登陆页
        btn_back_login_page.setOnClickListener {

        }
    }
}
