package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_mime_info.*

/**
 * 描述    : 个人信息页面
 * author  : Jetictors
 * time    :  2018/1/29 17:16
 * version : v1.0.1
 */
class MimeInfoFragment : BaseFragment(){

    companion object {
        fun newInstance() = MimeInfoFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_mime_info
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initListener()
    }

    private fun initData() {
        this.tx_nickname.text = "xxxx"
        this.tx_job.text = "xxxx"
        this.tx_info.text = "xxx"
        this.tx_mime_follow_count.text = "5"
        this.tx_other_follow_count.text = "20"
        this.tx_info_boil_count.text = "0"
        this.tx_info_original_count.text = "0"
        this.tx_info_share_count.text = "0"
        this.tx_info_collect_count.text = "0"
        this.tx_info_like_count.text = "0"
    }

    private fun initListener() {

        // 关注
        this.ll_mime_follow.setOnClickListener { (_mActivity as BaseActivity).start(FollowFragment.newInstance()) }

        // 关注者
        this.ll_other_follow.setOnClickListener { (_mActivity as BaseActivity).start(FollowFragment.newInstance()) }

        // 编辑
        this.btn_edit_mime_info.setOnClickListener { (_mActivity as BaseActivity).start(EditMimeInfoFragment.newInstance()) }

        // 动态
        this.btn_info_tab_trends.setOnClickListener { (_mActivity as BaseActivity).start(TrendsFragment.newInstance()) }

        // 沸点
        this.ll_info_tab_boil.setOnClickListener {  }

        // 原创文章
        this.ll_info_tab_original.setOnClickListener {  }

        // 分享文章
        this.ll_info_tab_share.setOnClickListener {  }

        // 收藏集
        this.ll_info_tab_collect.setOnClickListener { (_mActivity as BaseActivity).start(CollectFragment.newInstance())  }

        // 喜欢的文章
        this.ll_info_tab_like.setOnClickListener {  }

        // 关注的标签
        this.btn_info_tab_manager.setOnClickListener {  }

        // 个人博客地址
        this.btn_info_tab_blog_address.setOnClickListener {  }
    }

    private fun initTitle() {

    }
}