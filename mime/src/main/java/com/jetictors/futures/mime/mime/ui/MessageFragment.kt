package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import com.jetictors.futures.mime.mime.ui.adapter.TestAdapter
import kotlinx.android.synthetic.main.frag_msg_center.*

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

    private lateinit var mAdapter : TestAdapter

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

         this.msg_rv.layoutManager = GridLayoutManager(activity,3)
         this.msg_rv.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))

        val data = arrayOf("1","2","3","4","5","6","7","8")

        mAdapter = TestAdapter(activity,data)
        this.msg_rv.adapter = mAdapter

        mAdapter.setOnItemClickListener { position, data ->
            Toast.makeText(_mActivity,"position : ${position} \t data : ${data}",Toast.LENGTH_SHORT).show()
        }
    }
}