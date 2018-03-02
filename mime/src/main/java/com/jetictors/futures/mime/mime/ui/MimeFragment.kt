package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * 描述    : 个人中心页面
 * author  : Jetictors
 * time    :  2018/1/29 17:16
 * version : v1.0.1
 */
class MimeFragment : BaseFragment(){

    companion object {
        fun newInstance() : MimeFragment{
            val mimeFragment = MimeFragment()
            return mimeFragment
        }
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_mime
    }

    override fun initEventAndData(view: View?) {
        initTitle()
    }

    private fun initTitle() {

    }
}
