package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * @描述    :    关注/被关注页面
 * @author  :   Jetictors
 * @time    :   2018/3/8 17:30
 * @version :   v1.0.1
 */
class FollowFragment : BaseFragment() {

    companion object {
        fun newInstance() = FollowFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId() = R.layout.frag_msg_center

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initView()
    }

    private fun initView() {

    }

    private fun initData() {

    }

    private fun initTitle() {

    }
}