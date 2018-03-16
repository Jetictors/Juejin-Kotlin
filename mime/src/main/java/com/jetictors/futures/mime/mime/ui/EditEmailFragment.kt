package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_edit_email.*

/**
 * @描述    :    修改邮箱页面
 * @author  :   Jetictors
 * @time    :   2018/3/7 11:13
 * @version :   v1.0.1
 */
class EditEmailFragment : BaseFragment(){

    companion object {
        fun newInstance() = EditEmailFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_edit_email
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initListener()
    }

    private fun initData() {
        this.tv_bind_email.text = ""
    }

    private fun initListener() {
        btn_save_email.setOnClickListener {
            if (checkEmail()){

            }
        }
    }

    /**
     * 验证email是否合法
     * @return
     */
    private fun checkEmail(): Boolean {
        if (this.et_new_email.text.toString().isEmpty()){
            return false
        }

        return true
    }

    private fun initTitle() {

    }
}