package com.jetictors.futures.home.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initEventAndData(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initInject(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}