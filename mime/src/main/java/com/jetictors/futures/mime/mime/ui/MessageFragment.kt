package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import com.jetictors.futures.mime.mime.ui.adapter.MessageAdapter

/**
 * 描述    : 消息中心页面
 * author  : Jetictors
 * time    :  2018/1/29 17:19
 * version : v1.0.1
 */
class MessageFragment : BaseFragment(){

    companion object {
        fun newInstance() = MessageFragment()
    }

    private lateinit var mAdapter : MessageAdapter

    override fun initInject(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId() = R.layout.frag_msg_center

    override fun initEventAndData(view: View?) {
        initView()
        initData()
    }

    private fun initData() {
    }

    private fun initView() {
//        common_rv.layoutManager = LinearLayoutManager(activity)
        mAdapter = MessageAdapter(R.layout.item_msg_center, mutableListOf())
//        common_rv.adapter = mAdapter
    }
}