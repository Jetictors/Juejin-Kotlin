package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_login.*

/**
 * 描述    : 登录页
 * author  : Jetictors
 * time    :  2018/1/29 13:42
 * version : v1.0.1
 */
class LoginFragment : BaseFragment(){

    companion object {
        fun newInstanc() = LoginFragment()
    }

    /**
     * 密码是否可见
     */
    private var pwdIsShow = false

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
       return R.layout.frag_login
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initListener()
    }

    private fun initTitle() {

    }

    private fun initListener(){

        // 登陆
        this.btn_login.setOnClickListener {
            checkLogin()
        }

        // 忘记密码
        this.btn_forget_pwd.setOnClickListener {
            // 跳转到重置密码页面

        }

        // 注册账号
        this.btn_register.setOnClickListener {
            // 跳转到注册页面
        }

        // 密码是否可见


        // 微博登陆
        this.btn_login_weibo.setOnClickListener{

        }

        // 微信登陆
        this.btn_login_wechat.setOnClickListener {

        }

        // github登陆
        this.btn_login_github.setOnClickListener {

        }

        // 是否同意软件协议
        this.cbox_protocol.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked){

            }else{

            }
        }
    }

    /**
     * 检测是否满足登陆条件
     */
    private fun checkLogin() {
        if (this.et_login_user.text.toString().isEmpty()){
            return
        }

        if (this.et_login_pwd.text.toString().isEmpty()){
            return
        }
    }

}