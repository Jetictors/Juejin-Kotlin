package com.jetictors.futures.find.debug

import android.os.Bundle

import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.find.R
import com.jetictors.futures.find.find.ui.FindFragment

/**
 * 创建者     邓浩宸
 * 创建时间   2016/12/9 14:17
 * 描述	  TODO
 */

class FindDebugActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_debug
    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.content, FindFragment.newInstance())
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

}
