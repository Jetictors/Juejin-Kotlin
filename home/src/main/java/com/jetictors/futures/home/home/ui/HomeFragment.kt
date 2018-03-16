package com.jetictors.futures.home.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.common.utils.AppManager
import com.jetictors.futures.home.R

/**
 * @描述    :    首页fragment
 * @author  :   Jetictors
 * @time    :   2018/2/1 11:13
 * @version :   v1.0.1
 */
class HomeFragment : BaseFragment(){

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var currentTime : Long = 0L

    override fun getLayoutId(): Int {
        return R.layout.frag_home
    }

    override fun initEventAndData(view: View?) {

    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun onBackPressedSupport(): Boolean {

        if (childFragmentManager.backStackEntryCount > 1){
            popChild()
        }else{

            if (System.currentTimeMillis().minus(currentTime) > 2000){
                currentTime = System.currentTimeMillis()
                Toast.makeText(_mActivity,"再次点击退出应用",Toast.LENGTH_SHORT).show()
            }else{
                android.os.Process.killProcess(android.os.Process.myPid())
                System.exit(0)
            }
        }

        return true
    }
}