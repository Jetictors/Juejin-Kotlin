package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * 描述    : 文章统计页面
 * author  : Jetictors
 * time    :  2018/1/29 17:16
 * version : v1.0.1
 */
class AritcleCountFragment : BaseFragment(){

    companion object {
        fun newInstance() = AritcleCountFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_article_count
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
    }

    private fun initData() {

    }

    private fun initTitle() {

    }
}