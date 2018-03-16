package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_forget_pwd_by_phone.*

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
        initData()
        initListener()
    }

    private fun initData() {

    }

    private fun initListener() {
        // 获取验证码
        btn_msg_verify_code.setOnClickListener {

        }

        // 确定
        btn_commit_phone.setOnClickListener {
            if (check()){

            }
        }
    }

    private fun check() : Boolean{



        return true
    }

}