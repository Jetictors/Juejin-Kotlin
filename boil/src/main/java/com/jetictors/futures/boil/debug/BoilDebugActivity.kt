package com.jetictors.futures.boil.debug

import android.os.Bundle
import com.jetictors.futures.boil.R
import com.jetictors.futures.boil.boil.ui.BoilFragment

import com.jetictors.futures.common.base.BaseActivity

/**
 * 创建者     邓浩宸
 * 创建时间   2016/12/9 14:17
 * 描述	  TODO
 */

class BoilDebugActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_debug
    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.content, BoilFragment.newInstance())
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

}
