package com.jetictors.futures.mime.mime.ui

import android.os.Bundle
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.mime.R
import kotlinx.android.synthetic.main.frag_forget_pwd.*
import me.yokeyword.fragmentation.SupportFragment

/**
 * @描述    :    收藏集页面
 * @author  :   Jetictors
 * @time    :   2018/3/8 10:08
 * @version :   v1.0.1
 */
class CollectFragment :BaseFragment() {

    companion object {

        private const val INDEX_FIRST = 0
        private const val INDEX_SECOND = 1

        fun newInstance() = CollectFragment()
    }

    private var mFragments : Array<SupportFragment?> = arrayOfNulls(2)

    private val mTabTexts : Array<String> by lazy {
        arrayOf(getString(R.string.collect_tab_mime_create), getString(R.string.collect_tab_mime_follow))
    }

    override fun initInject(savedInstanceState: Bundle?) {
        if (savedInstanceState == null){
            mFragments[INDEX_FIRST] = MimeCreateCollectFragment.newInstance()
            mFragments[INDEX_SECOND] = MimeFollowCollectFragment.newInstance()
        }else{
            mFragments[INDEX_FIRST] = findFragment(MimeCreateCollectFragment::class.java)
            mFragments[INDEX_SECOND] = findFragment(MimeFollowCollectFragment::class.java)
        }
    }

    override fun getLayoutId() = R.layout.frag_forget_pwd

    override fun initEventAndData(view: View?) {
        initTitle()
        initView()
    }

    private fun initView() {
        this.forget_view_pager.currentItem = 0
        this.forget_view_pager.adapter = object : FragmentStatePagerAdapter(childFragmentManager){
            override fun getItem(position: Int) = mFragments[position]

            override fun getCount() = mFragments.size

            override fun getPageTitle(position: Int) = mTabTexts[position]
        }

        this.forget_tab_layout.setupWithViewPager(this.forget_view_pager)
    }

    private fun initTitle() {
    }
}