package com.jetictors.futures.boil.boil.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.boil.R
import com.jetictors.futures.common.base.BaseFragment

/**
 * @描述    :    沸点
 * @author  :   Jetictors
 * @time    :   2018/2/1 15:30
 * @version :   v1.0.1
 */
class BoilFragment : BaseFragment() {

    companion object {
        fun newInstance() : BoilFragment{
            val boilFragment = BoilFragment()
            return boilFragment
        }
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_boil
    }

    override fun initEventAndData(view: View?) {

    }
}