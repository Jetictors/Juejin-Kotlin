package com.jetictors.futures.common.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.CheckResult
import com.jetictors.futures.common.fmarework.IDaggerListener
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import me.yokeyword.fragmentation.SupportActivity

/**
 * 创建者：邓浩宸
 * 时间 ：2016/11/15 16:08
 * 描述 ：无MVP的activity基类
 */
abstract class BaseActivity : SupportActivity(), LifecycleProvider<ActivityEvent>, IDaggerListener {

    protected abstract var mContext: Context

    // 重写RxLife控制生命周期
    private val lifecycleSubject = BehaviorSubject.create<ActivityEvent>()

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {

        initInject(savedInstanceState)

        super.onCreate(savedInstanceState)

        lifecycleSubject.onNext(ActivityEvent.CREATE)

        if (layout > 0) {
            setContentView(layout)
        }

        mContext = this

        initEventAndData(savedInstanceState)
    }

    override fun onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY)
        super.onDestroy()
    }

    /**
     * 该方法回调时机为,Activity回退栈内Fragment的数量 小于等于1 时,默认finish Activity
     * 请尽量复写该方法,避免复写onBackPress(),以保证SupportFragment内的onBackPressedSupport()回退事件正常执行
     */
    override fun onBackPressedSupport() {
        super.onBackPressedSupport()
    }

    protected fun isCompatible(apiLevel: Int): Boolean {
        return Build.VERSION.SDK_INT >= apiLevel
    }

    protected abstract fun initEventAndData(savedInstanceState: Bundle?)

    @CheckResult
    override fun lifecycle(): Observable<ActivityEvent> {
        return lifecycleSubject.hide()
    }

    @CheckResult
    override fun <T> bindUntilEvent(event: ActivityEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }

    @CheckResult
    override fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject)
    }


    @CallSuper
    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(ActivityEvent.START)
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(ActivityEvent.RESUME)
    }

    @CallSuper
    override fun onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE)
        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP)
        super.onStop()
    }

}