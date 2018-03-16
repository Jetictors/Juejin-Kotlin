package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_edit_phone.*

/**
 * @描述    :    修改手机号码页面
 * @author  :   Jetictors
 * @time    :   2018/3/7 11:13
 * @version :   v1.0.1
 */
class EditPhoneFragment : BaseFragment(){

    companion object {
        fun newInstance() = EditPhoneFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_edit_phone
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initListener()
    }

    private fun initListener() {
        btn_save_phone.setOnClickListener {

        }
    }

    private fun initData() {

    }

    private fun initTitle() {

    }
}