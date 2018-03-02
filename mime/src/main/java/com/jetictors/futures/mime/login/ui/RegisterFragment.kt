package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_register.*

/**
 * 描述    : 注册页
 * author  : Jetictors
 * time    :  2018/1/29 13:42
 * version : v1.0.1
 */
class RegisterFragment : BaseFragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    /**
     * 密码是否可见
     */
    private var pwdIsShow = false

    override fun getLayoutId(): Int {
        return R.layout.frag_register
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initListener()
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    private fun initListener() {

        // 密码是否可见
        this.btn_show_pwd.setOnClickListener {
            if (pwdIsShow){
                pwdIsShow = false
                this.btn_show_pwd.setImageResource(0)
                this.et_register_pwd.inputType
            }else{
                pwdIsShow = true
                this.btn_show_pwd.setImageResource(0)
                this.et_register_pwd.inputType
            }
        }

        // 注册
        this.btn_register.setOnClickListener{
            if (checkRegister()){

            }
        }
    }

    /**
     * 检测是否满足注册条件
     */
    private fun checkRegister() : Boolean{
        if (this.et_register_user.text.toString().isEmpty()){
            return false
        }

        if (this.et_register_pwd.text.toString().isEmpty()){
            return false
        }

        if (this.et_register_nickname.text.toString().isEmpty()){
            return false
        }



        return true
    }

    private fun initTitle() {

    }



}