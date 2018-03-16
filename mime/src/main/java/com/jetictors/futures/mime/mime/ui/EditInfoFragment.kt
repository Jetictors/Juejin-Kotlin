package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.Constants
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_edit_info.*

/**
 * @描述    :    修改个人资料页面
 * @author  :   Jetictors
 * @time    :   2018/3/7 18:29
 * @version :   v1.0.1
 */
class EditInfoFragment : BaseFragment() {

    /**
     * 判断是哪一个类型
     */
    private lateinit var mimeInfoType: String

    private lateinit var mimeInfoValue: String

    companion object {
        fun newInstance(mimeInfoType: String, mimeInfoValue: String): EditInfoFragment {
            val mBundle = Bundle()
            val mEditInfoFragment = EditInfoFragment()

            mBundle.putString(Constants.MimeInfo.MIME_INFO_TYPE, mimeInfoType)
            mBundle.putString(Constants.MimeInfo.MIME_INFO_VALUE, mimeInfoValue)
            mEditInfoFragment.arguments = mBundle
            return mEditInfoFragment
        }
    }

    override fun initInject(savedInstanceState: Bundle?) {
        arguments?.let {
            mimeInfoType = arguments.getString(Constants.MimeInfo.MIME_INFO_TYPE)
            mimeInfoValue = arguments.getString(Constants.MimeInfo.MIME_INFO_VALUE)
        }
    }

    override fun getLayoutId() = R.layout.frag_edit_info

    override fun initEventAndData(view: View?) {
        initTitle()
        initView()
        initData()
    }

    private fun initData() {
        this.et_info.setText(mimeInfoValue)
    }

    private fun initView() {

        // 修改输入框的高度
        if (mimeInfoType == Constants.MimeInfo.MIME_INFO_INFO || mimeInfoType == Constants.MimeInfo.MIME_INFO_BLOG_ADDRESS) {
            this.et_info.minHeight = mContext?.resources?.getDimension(R.dimen.dp_96)?.toInt() ?: 300
        }
    }

    private fun initTitle() {

    }
}