package com.jetictors.futures.juejin_kotlin.ui

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.Window
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.utils.logger.KLog
import com.jetictors.futures.juejin_kotlin.R

class MainActivity : BaseActivity() {

    override fun initInject(@Nullable savedInstanceState: Bundle?) {

    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 去除标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
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
             loadRootFragment(R.id.fl_container,MainFragment.newInstance())
             // 检测是否为第一次安装
//             if (false){
//                 loadRootFragment(R.id.fl_container,SplashFragment.newInstance())
//             }else{
//                 loadRootFragment(R.id.fl_container,MainFragment.newInstance())
//             }

         }else{
             loadRootFragment(R.id.fl_container,findFragment(MainFragment::class.java))
//             if (SPHelper.get(this, Constants.AppVersion.APP_VERSION,"",SPHelper.VERSION_FILE_NAME)
//                     .equals("")){
//                 loadRootFragment(R.id.fl_container,findFragment(SplashFragment::class.java))
//             }else{
//                 loadRootFragment(R.id.fl_container,findFragment(MainFragment::class.java))
//             }

         }
    }

    override fun recreate() {
        super.recreate()
    }

    override fun onBackPressedSupport() {
        super.onBackPressedSupport()
    }

}