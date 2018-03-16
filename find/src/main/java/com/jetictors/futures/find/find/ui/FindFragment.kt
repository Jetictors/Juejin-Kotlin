package com.jetictors.futures.find.find.ui

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.common.fmarework.OnBackToFirstListener
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

    internal lateinit var mListener : OnBackToFirstListener

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_find
    }

    override fun initEventAndData(view: View?) {
        val baseFragment : BaseFragment = parentFragment as BaseFragment
        if (baseFragment is OnBackToFirstListener){
            mListener = baseFragment
        }

        initTitle()
    }

    private fun initTitle() {
        activity.findViewById<LinearLayout>(R.id.ll_back).visibility = View.GONE
        activity.findViewById<TextView>(R.id.tv_title).text = getString(R.string.app_name)
    }

    override fun onBackPressedSupport(): Boolean {
        if(childFragmentManager.backStackEntryCount > 1){
            pop()
        }else{
            mListener.backToFirstFragment()
        }

        return true
    }
}