package com.jetictors.futures.boil.boil.presenter.contract

import com.jetictors.futures.common.base.mvp.IBaseModel
import com.jetictors.futures.common.base.mvp.IBasePresenter
import com.jetictors.futures.common.base.mvp.IBaseView

/**
 * @描述    :    boil页面契约类
 * @author  :   Jetictors
 * @time    :   2018/3/16 18:43
 * @version :   v1.0.1
 */
interface IBoilContract {

    interface IBoilView : IBaseView{

    }

    interface IBoilPresenter : IBasePresenter<IBoilView>{
    }

    interface IBoilModel : IBaseModel{

    }

}