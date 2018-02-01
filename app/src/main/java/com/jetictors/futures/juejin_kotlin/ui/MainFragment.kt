package com.jetictors.futures.juejin_kotlin.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.boil.boil.ui.BoilFragment
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.common.widgets.bottombar.BottomBar
import com.jetictors.futures.common.widgets.bottombar.BottomBarTab
import com.jetictors.futures.find.find.ui.FindFragment
import com.jetictors.futures.home.ui.HomeFragment
import com.jetictors.futures.juejin_kotlin.R
import com.jetictors.futures.mime.mime.ui.MimeFragment
import kotlinx.android.synthetic.main.frag_main.*
import me.yokeyword.fragmentation.SupportFragment

/**
 * 描述    : 主页4个fragment容器
 * author  : Jetictors
 * time    :  2018/2/1 9:55
 * version : v1.0.1
 */
class MainFragment : BaseFragment() {

    private val mTitles: Array<String> by lazy {
        arrayOf(
                getString(R.string.tx_home), getString(R.string.tx_boil),
                getString(R.string.tx_find), getString(R.string.tx_mime)
        )
    }

    private val mIcons: Array<Int> by lazy {
        arrayOf(
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher
        )
    }

    private lateinit var mFragments: Array<SupportFragment>

    companion object {

        const val INDEX_FIRST = 0
        const val INDEX_SECOND = 1
        const val INDEX_THIRD = 2
        const val INDEX_FOURTH = 3

        fun newInstance(): MainFragment {
            val mainFragment = MainFragment()
            return mainFragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.frag_main
    }

    override fun initEventAndData(view: View?) {
        initData()
        initListener()
    }

    private fun initListener() {
        bottomBar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener {
            override fun onTabUnselected(position: Int) {
            }

            override fun onTabReselected(position: Int) {
            }

            override fun onTabSelected(position: Int, prePosition: Int): Boolean {
                return true
            }

        })
    }

    private fun initData() {

        bottomBar.addItem(BottomBarTab(_mActivity, mIcons[0], mTitles[INDEX_THIRD]))
                .addItem(BottomBarTab(_mActivity, mIcons[1], mTitles[INDEX_SECOND]))
                .addItem(BottomBarTab(_mActivity, mIcons[2], mTitles[INDEX_THIRD]))
                .addItem(BottomBarTab(_mActivity, mIcons[3], mTitles[INDEX_FOURTH]))
    }

    override fun initInject(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {

            mFragments[INDEX_FIRST] = HomeFragment.newInstance()
            mFragments[INDEX_SECOND] = BoilFragment.newInstance()
            mFragments[INDEX_THIRD] = FindFragment.newInstance()
            mFragments[INDEX_FOURTH] = MimeFragment.newInstance()

            // 判断是否登录
            var loadIndex = INDEX_FIRST
            if (true) {

            } else {
                loadIndex = INDEX_THIRD
            }

            loadMultipleRootFragment(R.id.fl_tab_container, loadIndex, *mFragments)
        } else {
            mFragments[INDEX_FIRST] = findFragment(HomeFragment::class.java)
            mFragments[INDEX_SECOND] = findFragment(BoilFragment::class.java)
            mFragments[INDEX_THIRD] = findFragment(FindFragment::class.java)
            mFragments[INDEX_FOURTH] = findFragment(MimeFragment::class.java)
        }
    }

    override fun onBackPressedSupport(): Boolean {

        // 在已登录的情况下，设置成首页，反之，退出程序
        if (true) {
            bottomBar.setCurrentItem(0)
        } else {

        }
        return true
    }
}

