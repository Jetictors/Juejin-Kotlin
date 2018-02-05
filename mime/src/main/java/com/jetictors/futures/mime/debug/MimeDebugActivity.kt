package com.jetictors.futures.mime.debug

import android.os.Bundle

import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.mime.R
import com.jetictors.futures.mime.mime.ui.MimeFragment

/**
 * 创建者     邓浩宸
 * 创建时间   2016/12/9 14:17
 * 描述	  TODO
 */

class MimeDebugActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_debug
    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.content, MimeFragment.newInstance())
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

}
