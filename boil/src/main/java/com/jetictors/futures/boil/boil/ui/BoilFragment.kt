package com.jetictors.futures.boil.boil.ui

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.jetictors.futures.boil.R
import com.jetictors.futures.boil.boil.presenter.BoilPresenter
import com.jetictors.futures.boil.boil.presenter.contract.IBoilContract
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.common.base.XDaggerFragment
import com.jetictors.futures.common.fmarework.OnBackToFirstListener

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

    internal lateinit var mListener : OnBackToFirstListener

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_boil
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
        activity.findViewById<TextView>(R.id.tv_title).text = getString(R.string.boil_title)
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