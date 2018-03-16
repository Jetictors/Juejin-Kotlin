package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.common.fmarework.OnBackToFirstListener
import com.jetictors.futures.mime.R
import com.jetictors.futures.mime.login.ui.LoginFragment
import kotlinx.android.synthetic.main.frag_mime.*

/**
 * 描述    : 个人中心页面
 * author  : Jetictors
 * time    :  2018/1/29 17:16
 * version : v1.0.1
 */
class MimeFragment : BaseFragment() {

    companion object {
        fun newInstance() = MimeFragment()
    }

    internal lateinit var mListener : OnBackToFirstListener

    override fun initInject(savedInstanceState: Bundle?) {
        val baseFragment : BaseFragment = parentFragment as BaseFragment
        if (baseFragment is OnBackToFirstListener){
            mListener = baseFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_mime
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initListener()
    }

    private fun initListener() {

        // 跳转到个人中心页
        ll_mime_info.setOnClickListener { (_mActivity as BaseActivity).start(LoginFragment.newInstance()) }

        // 消息中心
        btn_tab_msg.setOnClickListener { (_mActivity as BaseActivity).start(MessageFragment.newInstance()) }

        // 我喜欢的
        ll_tab_like.setOnClickListener { (_mActivity as BaseActivity).start(EditMimeInfoFragment.newInstance()) }

        // 收藏集
        ll_tab_collect.setOnClickListener { (_mActivity as BaseActivity).start(CollectFragment.newInstance()) }

        // 已购
        ll_tab_buy.setOnClickListener {}

        // 赞过的沸点
        ll_tab_boil.setOnClickListener {}

        // 阅读过的文章
        ll_tab_read.setOnClickListener {  }

        // 标签管理
        ll_tab_manager.setOnClickListener { (_mActivity as BaseActivity).start(TabManagerFragment.newInstance()) }

        // 意见反馈
        btn_tab_feedback.setOnClickListener {}

        // 设置
        btn_tab_set.setOnClickListener { (_mActivity as BaseActivity).start(SetFragment.newInstance()) }
    }

    private fun initData() {
        tx_value_like_count.text = getString(R.string.tx_tab_value_count_3, 0)
        tx_value_collect_count.text = getString(R.string.tx_tab_value_count_2, 0)
        tx_value_buy_count.text = getString(R.string.tx_tab_value_count_1, 0)
        tx_value_boil_count.text = getString(R.string.tx_tab_value_count_3, 0)
        tx_value_read_count.text = getString(R.string.tx_tab_value_count_3, 0)
        tx_value_manager_count.text = getString(R.string.tx_tab_value_count_1, 0)
    }

    private fun initTitle() {
        activity.findViewById<LinearLayout>(R.id.ll_back).visibility = View.GONE
        activity.findViewById<TextView>(R.id.tv_title).text = getString(R.string.mime_title)
    }

    override fun onBackPressedSupport(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            pop()
        } else {
            mListener.backToFirstFragment()
        }

        return true
    }
}
