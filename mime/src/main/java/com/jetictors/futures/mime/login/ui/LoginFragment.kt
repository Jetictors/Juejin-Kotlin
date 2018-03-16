package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.text.InputType
import android.view.View
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import com.jetictors.futures.yake.utils.isEmail
import com.jetictors.futures.yake.utils.isPhoneNum
import kotlinx.android.synthetic.main.frag_login.*

/**
 * 描述    : 登录页
 * author  : Jetictors
 * time    :  2018/1/29 13:42
 * version : v1.0.1
 */
class LoginFragment : BaseFragment(){

    companion object {
        fun newInstance() = LoginFragment()
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
            if (checkLogin()){

            }
        }

        // 忘记密码
        this.btn_forget_pwd.setOnClickListener {
            (_mActivity as BaseActivity).start(ForgetPwdFragment.newInstance())
        }

        // 注册账号
        this.btn_register.setOnClickListener {
            (_mActivity as BaseActivity).start(RegisterFragment.newInstance())
        }

        // 密码是否可见
        this.btn_show_pwd.setOnClickListener {
            if(pwdIsShow){
                pwdIsShow = false
                this.btn_show_pwd.setImageResource(R.drawable.abc_ic_star_black_16dp)
                this.et_login_pwd.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }else{
                pwdIsShow = true
                this.btn_show_pwd.setImageResource(R.drawable.abc_ic_star_black_16dp)
                this.et_login_pwd.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            }
        }

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
    private fun checkLogin() : Boolean{
        if (this.et_login_user.text.toString().isEmpty()){
            activity.shortToast(getString(R.string.hint_user_null))
            return false
        }

        if (!this.et_login_user.text.toString().isPhoneNum() || !this.et_login_user.text.toString().isEmail()){
            activity.shortToast(getString(R.string.hint_user_error))
            return false
        }

        if (this.et_login_pwd.text.toString().isEmpty()){
            activity.shortToast(getString(R.string.hint_pwd_null))
            return false
        }

        return true
    }

}