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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initEventAndData(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}