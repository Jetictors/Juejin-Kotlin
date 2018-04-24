package com.jetictors.futures.home.home.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.home.R

/**
 * @描述    :    分享文章页
 * @author  :   Jetictors
 * @time    :   2018/3/23 13:04
 * @version :   v1.0.1
 */
class ShareArticleFragment : BaseFragment() {

    companion object {
        fun newInstance() = ShareArticleFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId() = R.layout.frag_share_article

    override fun initEventAndData(view: View?) {
        initTitle()
        initView()
    }

    private fun initView() {

    }

    private fun initTitle() {

    }
}