package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * @描述    :    修改密码页面
 * @author  :   Jetictors
 * @time    :   2018/3/7 11:13
 * @version :   v1.0.1
 */
class EditPwdFragment : BaseFragment(){

    companion object {
        fun newInstance() = EditPwdFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_edit_pwd
    }

    override fun initEventAndData(view: View?) {

    }
}