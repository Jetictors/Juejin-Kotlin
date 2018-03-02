package com.jetictors.futures.mime.login.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_forget_pwd.*
import me.yokeyword.fragmentation.SupportFragment


/**
 * 描述    : 忘记密码页
 * author  : Jetictors
 * time    :  2018/1/29 14:13
 * version : v1.0.1
 */
class ForgetPwdFragment : BaseFragment(){

    companion object {

        private const val INDEX_FIRST = 1
        private const val INDEX_SECOND = 2

        fun newInstance() = ForgetPwdFragment()
    }

    private var mFragments : Array<SupportFragment?> = arrayOfNulls(2)

    private val mTabTexts : Array<String> by lazy {
        arrayOf(getString(R.string.forget_pwd_tab_phone), getString(R.string.forget_pwd_tab_email))
    }

    override fun initInject(savedInstanceState: Bundle?) {
        if (savedInstanceState == null){
            mFragments[INDEX_FIRST] = PhoneFindPwdFragment.newInstance()
            mFragments[INDEX_SECOND] = EmailFindPwdFragment.newInstance()

            loadMultipleRootFragment(R.id.forget_container, INDEX_FIRST,*mFragments)
        }else{
            mFragments[INDEX_FIRST] = findFragment(PhoneFindPwdFragment::class.java)
            mFragments[INDEX_SECOND] = findFragment(EmailFindPwdFragment::class.java)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_forget_pwd
    }

    override fun initEventAndData(view: View?) {
        initTitle()
        initView()
    }

    private fun initView() {

    }

    private fun initTitle() {

    }
}