package com.jetictors.futures.home.home.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.home.R

/**
 * @描述    :    首页fragment
 * @author  :   Jetictors
 * @time    :   2018/2/1 11:13
 * @version :   v1.0.1
 */
class HomeFragment : BaseFragment(){

    companion object {
        fun newInstance() : HomeFragment{
            val homeFragment = HomeFragment()
            return homeFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_home
    }

    override fun initEventAndData(view: View?) {

    }

    override fun initInject(savedInstanceState: Bundle?) {

    }
}