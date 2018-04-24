package com.jetictors.futures.home.home.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.home.R
import com.jetictors.futures.home.home.model.entity.TabManager
import com.jetictors.futures.home.home.ui.adapter.TabManagerAdapter

/**
 * @描述    :    标签管理页面
 * @author  :   Jetictors
 * @time    :   2018/3/23 10:51
 * @version :   v1.0.1
 */
class HomeTabManagerFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeTabManagerFragment()
    }

    private lateinit var mRvTabManager : RecyclerView
    private lateinit var mAdapter : TabManagerAdapter
    private lateinit var mDataList : MutableList<TabManager>

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId() = R.layout.frag_home_tab_manager

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initView()
    }

    private fun initData() {
        mDataList = mutableListOf(TabManager("Android",false))
        mDataList.add(TabManager("Android",false))
        mDataList.add(TabManager("后端",true))
        mDataList.add(TabManager("Android",false))
        mDataList.add(TabManager("IOS",true))
        mDataList.add(TabManager("Android",false))
        mDataList.add(TabManager("Android",false))
    }

    private fun initView() {
        mRvTabManager = activity.findViewById(R.id.common_rv)
        mRvTabManager.layoutManager = LinearLayoutManager(mContext)
        mAdapter = TabManagerAdapter(R.layout.item_home_tab_manager,mDataList)
        mRvTabManager.adapter = mAdapter
    }

    private fun initTitle() {

    }
}