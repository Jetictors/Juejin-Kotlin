package com.jetictors.futures.juejin_kotlin.ui

import android.os.Bundle
import android.view.View
import com.jetictors.futures.boil.boil.ui.BoilFragment
import com.jetictors.futures.common.base.BaseFragment
import com.jetictors.futures.common.fmarework.OnBackToFirstListener
import com.jetictors.futures.common.widgets.bottombar.BottomBar
import com.jetictors.futures.common.widgets.bottombar.BottomBarTab
import com.jetictors.futures.find.find.ui.FindFragment
import com.jetictors.futures.home.home.ui.HomeFragment
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
class MainFragment : BaseFragment(), OnBackToFirstListener {

    /*
        底部栏item的当前下标
     */
    private var currentIndex = -1

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



    private val mTitles: Array<String> by lazy {
        arrayOf(
                getString(R.string.tx_home), getString(R.string.tx_boil),
                getString(R.string.tx_find), getString(R.string.tx_mime)
        )
    }

    private val mIcons: Array<Int> by lazy {
        arrayOf(
                R.drawable.abc_ic_star_black_48dp, R.drawable.abc_ic_star_black_48dp,
                R.drawable.abc_ic_star_black_48dp, R.drawable.abc_ic_star_black_48dp
        )
    }

    private var mFragments: Array<SupportFragment?> = arrayOfNulls<SupportFragment>(4)

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
                showHideFragment(mFragments[position], mFragments[prePosition])
                return false
            }
        })
    }

    private fun initData() {

        bottomBar.addItem(BottomBarTab(_mActivity, mIcons[INDEX_FIRST], mTitles[INDEX_FIRST]))
                .addItem(BottomBarTab(_mActivity, mIcons[INDEX_SECOND], mTitles[INDEX_SECOND]))
                .addItem(BottomBarTab(_mActivity, mIcons[INDEX_THIRD], mTitles[INDEX_THIRD]))
                .addItem(BottomBarTab(_mActivity, mIcons[INDEX_FOURTH], mTitles[INDEX_FOURTH]))
    }

    override fun initInject(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {

            mFragments[INDEX_FIRST] = HomeFragment.newInstance()
            mFragments[INDEX_SECOND] = BoilFragment.newInstance()
            mFragments[INDEX_THIRD] = FindFragment.newInstance()
            mFragments[INDEX_FOURTH] = MimeFragment.newInstance()

            // 判断是否登录
            var loadIndex = INDEX_FIRST
            if (false) {
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

    override fun backToFirstFragment() {
        bottomBar.setCurrentItem(0)
    }
}

