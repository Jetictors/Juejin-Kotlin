package com.jetictors.futures.mime.mime.ui.adapter

import android.support.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @描述    :    消息中心adapter
 * @author  :   Jetictors
 * @time    :   2018/3/23 13:29
 * @version :   v1.0.1
 */
class MessageAdapter(@LayoutRes layout : Int , mDataList : MutableList<String>)
    : BaseQuickAdapter<String,BaseViewHolder>(layout,mDataList) {

    override fun convert(helper: BaseViewHolder?, item: String?) {

    }

    override fun getItemCount(): Int {
        return 15
    }
}