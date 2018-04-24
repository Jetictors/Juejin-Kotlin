package com.jetictors.futures.home.home.ui.adapter

import android.support.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jetictors.futures.home.R
import com.jetictors.futures.home.home.model.entity.TabManager
import com.kyleduo.switchbutton.SwitchButton

/**
 * @描述    :    标签管理页面adapter
 * @author  :   Jetictors
 * @time    :   2018/3/23 11:00
 * @version :   v1.0.1
 */
class TabManagerAdapter(@LayoutRes layout : Int, mDataList : MutableList<TabManager>)
    : BaseQuickAdapter<TabManager,BaseViewHolder>(layout,mDataList){

    override fun convert(helper: BaseViewHolder?, item: TabManager?) {
        helper?.setText(R.id.tx_home_tab,item?.typeName ?: "")

        val mSwitchBtn : SwitchButton? = helper?.getView(R.id.switch_tab_home)

        item?.let {
            mSwitchBtn?.isClickable = it.isAdd
        }
    }
}