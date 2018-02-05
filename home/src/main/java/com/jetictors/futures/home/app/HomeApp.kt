package com.jetictors.futures.home.app

import android.app.Application

import com.alibaba.android.arouter.facade.annotation.Route
import com.jetictors.futures.common.base.BaseChildApplication
import com.jetictors.futures.common.utils.ApplicationLike

/**
 * @author 浩宸
 * @time 2017/3/24 14:42
 * @desc  这里的application只是在作为单独App是debug时使用的,初始化一些东西,但是实际开发是还是放在主工程的app中去初始化(IM模块除外)
 */
@Route(path = "/home/application1")
class HomeApp : BaseChildApplication(), ApplicationLike {

    //不要对一个 Activity Context 保持长生命周期的引用。尽量在一切可以使用应用 ApplicationContext 代替 Context 的地方进行替换。
    override fun onCreateAsLibrary(application: Application) {
        super.onCreateAsLibrary(application)
    }
}
