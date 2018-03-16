package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.Constants
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_edit_mime_info.*


/**
 * @描述    :    修改个人资料页
 * @author  :   Jetictors
 * @time    :   2018/3/5 11:27
 * @version :   v1.0.1
 */
class EditMimeInfoFragment : BaseFragment() {

    companion object {
        fun newInstance() = EditMimeInfoFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_edit_mime_info
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initListener()
    }

    private fun initData() {

    }

    private fun initListener() {

        // 头像
        ll_edit_tab_header.setOnClickListener {  }

        // 昵称
        ll_edit_tab_nickname.setOnClickListener {
            (_mActivity as BaseActivity).start(EditInfoFragment.newInstance(Constants.MimeInfo.MIME_INFO_NAME
                    ,"昵称"))
        }

        // 职位
        ll_edit_tab_job.setOnClickListener {
            (_mActivity as BaseActivity).start(EditInfoFragment.newInstance(Constants.MimeInfo.MIME_INFO_JOB
                    ,"职位"))
        }

        // 公司
        ll_edit_tab_firm.setOnClickListener {
            (_mActivity as BaseActivity).start(EditInfoFragment.newInstance(Constants.MimeInfo.MIME_INFO_FIRM
                    ,"公司"))
        }

        // 简介
        ll_edit_tab_info.setOnClickListener {
            (_mActivity as BaseActivity).start(EditInfoFragment.newInstance(Constants.MimeInfo.MIME_INFO_INFO
                    ,"佳节"))
        }

        // 博客地址
        ll_edit_tab_blog_address.setOnClickListener {
            (_mActivity as BaseActivity).start(EditInfoFragment.newInstance(Constants.MimeInfo.MIME_INFO_BLOG_ADDRESS
                    ,"地址"))
        }

    }

    private fun initTitle() {

    }
}