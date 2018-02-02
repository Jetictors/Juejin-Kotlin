package com.jetictors.futures.juejin_kotlin.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment

/**
 * 描述    : 引导页
 * author  : Jetictors
 * time    :  2018/2/1 10:00
 * version : v1.0.1
 */
class SplashFragment : BaseFragment(){

    companion object {
        fun newInstance() : SplashFragment{
            val splashFragment = SplashFragment()
            return splashFragment
        }
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return 0
    }

    override fun initEventAndData(view: View?) {
    }
}