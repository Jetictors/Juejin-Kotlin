package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R

/**
 * @描述    :    创建收藏集页面
 * @author  :   Jetictors
 * @time    :   2018/3/8 10:36
 * @version :   v1.0.1
 */
class CreateCollectFragment : BaseFragment() {

    companion object {
        fun newInstance() = CreateCollectFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId() = R.layout.frag_create_collect

    override fun initEventAndData(view: View?) {
    }
}