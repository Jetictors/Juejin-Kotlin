package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseActivity
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_set.*

/**
 * @描述    :    设置页
 * @author  :   Jetictors
 * @time    :   2018/3/5 11:10
 * @version :   v1.0.1
 */
class SetFragment : BaseFragment() {

    companion object {
        fun newInstance() = SetFragment()
    }

    override fun initInject(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.frag_set
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initData()
        initListener()
    }

    private fun initListener() {

        // 手机
        ll_user_phone.setOnClickListener { (_mActivity as BaseActivity).start(EditPhoneFragment.newInstance()) }

        // 邮箱
        ll_user_email.setOnClickListener { (_mActivity as BaseActivity).start(EditEmailFragment.newInstance()) }

        // 修改密码
        ll_user_pwd.setOnClickListener { (_mActivity as BaseActivity).start(EditPwdFragment.newInstance()) }

        // 绑定微博
        switch_button_weibo.setOnCheckedChangeListener { buttonView, isChecked ->

        }

        // 绑定微信
        switch_button_wechat.setOnCheckedChangeListener { buttonView, isChecked ->

        }

        // 绑定github
        switch_button_github.setOnCheckedChangeListener { buttonView, isChecked ->

        }

        // 清空缓存
        ll_clear_cache.setOnClickListener {

        }

        // 设置新消息通知
        ll_msg_notify.setOnClickListener {

        }

        // 退出登陆
        btn_exit.setOnClickListener {

        }
    }

    private fun initData() {

    }

    private fun initTitle() {

    }
}