package com.jetictors.futures.find.find.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.find.R

/**
 * @描述    :    发现
 * @author  :   Jetictors
 * @time    :   2018/2/1 15:28
 * @version :   v1.0.1
 */
class FindFragment : BaseFragment() {

    companion object {
        fun newInstance() : FindFragment{
            val findFragment = FindFragment()
            return findFragment
        }
    }

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_find
    }

    override fun initEventAndData(view: View?) {
    }
}