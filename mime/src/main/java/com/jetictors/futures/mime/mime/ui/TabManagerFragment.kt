package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * 描述    : 标签管理页面
 * author  : Jetictors
 * time    :  2018/1/29 17:20
 * version : v1.0.1
 */
class TabManagerFragment : BaseFragment(){

    companion object {
        fun newInstance() = TabManagerFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_tab_manager
    }

    override fun initEventAndData(view: View?) {

    }
}