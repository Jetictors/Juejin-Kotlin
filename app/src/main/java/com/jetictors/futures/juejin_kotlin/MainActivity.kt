package com.jetictors.futures.juejin_kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.Window
import com.jetictors.futures.common.base.BaseActivity


class MainActivity : BaseActivity() {

    override fun initInject(savedInstanceState: Bundle?) {
        // 用于dagger2的依赖注入的
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setTheme(R.style.AppTheme)
    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initListener()
        getPermissions()
    }

    /**
     * 权限申请
     */
    private fun getPermissions(){

    }

    private fun initListener() {

        // 可以监听该Activity下的所有Fragment的18个 生命周期方法
        supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
                super.onFragmentCreated(fm, f, savedInstanceState)
            }

            override fun onFragmentStopped(fm: FragmentManager?, f: Fragment?) {
                super.onFragmentStopped(fm, f)
            }
        },true)
    }

    private fun initView(savedInstanceState: Bundle?) {
         if (savedInstanceState == null){
             // 检测是否为第一次安装
         }else{

         }
    }

    override fun recreate() {
        super.recreate()
    }

    override fun onBackPressedSupport() {
        super.onBackPressedSupport()
    }


}