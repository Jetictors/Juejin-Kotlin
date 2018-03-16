package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * @描述    :    动态页
 * @author  :   Jetictors
 * @time    :   2018/3/5 18:20
 * @version :   v1.0.1
 */
class TrendsFragment : BaseFragment() {

    companion object {
        fun newInstance() = TrendsFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_trends
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initView()
        initListener()
    }

    private fun initListener() {

    }

    private fun initView() {
    }

    private fun initData() {

    }

    private fun initTitle() {

    }
}