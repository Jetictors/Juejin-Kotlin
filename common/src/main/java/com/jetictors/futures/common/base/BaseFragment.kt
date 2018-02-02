package com.jetictors.futures.common.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.annotation.CheckResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

import com.jetictors.futures.common.fmarework.IDaggerListener
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.android.RxLifecycleAndroid

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import me.yokeyword.fragmentation.SupportFragment
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator
import me.yokeyword.fragmentation.anim.FragmentAnimator


/**
 * 创建者：邓浩宸
 * 时间 ：2016/11/15 16:08
 * 描述 ：无MVP的Fragment基类
 */
abstract class BaseFragment : SupportFragment(), LifecycleProvider<FragmentEvent>, IDaggerListener {

    protected var mView: View? = null

    //_mActivity在SupportFragment中已经在onAttach中绑定了activity可以直接使用
    protected var mContext: Context? = null

    /**
     * 判断软键盘是否弹出
     */
    val isSHowKeyboard: Boolean
        get() {
            if (_mActivity == null || view == null) {
                return false
            }

            val imm = _mActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager

            if (imm?.hideSoftInputFromWindow(view?.windowToken, 0) == true) {
                imm.showSoftInput(view, 0)
                return true
            } else {
                return false
            }
        }


    abstract fun getLayoutId(): Int

    private val lifecycleSubject = BehaviorSubject.create<FragmentEvent>()

    /**
     * activity与fragment绑定时调用
     */
    override fun onAttach(context: Context?) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE_VIEW)
        if (getLayoutId() > 0) {
            mView = inflater?.inflate(getLayoutId(), null)
        }
        initInject(savedInstanceState)
        return mView
    }

    /**
     * 默认为横向切换动画
     *
     * @return
     */
    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return DefaultHorizontalAnimator()
    }

    /**
     * view 创建的回调
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!useLazy()) {
            initEventAndData(view)
        }
    }


    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        if (useLazy()) {
            initEventAndData(mView)
        }
    }

    fun useLazy(): Boolean {
        return true
    }

    protected fun showKeyboard(isShow: Boolean) {
        val activity = activity ?: return

        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if (isShow) {
            if (activity.currentFocus == null) {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            } else {
                imm.showSoftInput(activity.currentFocus, 0)
            }
        } else {
            if (activity.currentFocus != null) {
                imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS)
            }

        }
    }

    /**
     * 当Fragment状态改变时调用
     *
     * @param hidden
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }

    protected abstract fun initEventAndData(view: View?)

    override fun onBackPressedSupport(): Boolean {
        return super.onBackPressedSupport()
    }

    override fun onSupportVisible() {
        super.onSupportVisible()
        // todo,当该Fragment对用户可见时
    }

    override fun onSupportInvisible() {
        super.onSupportInvisible()
        // todo,当该Fragment对用户不可见时
    }

    @CheckResult
    override fun lifecycle(): Observable<FragmentEvent> {
        return lifecycleSubject.hide()
    }

    @CheckResult
    override fun <T> bindUntilEvent(event: FragmentEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }

    @CheckResult
    override fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindFragment(lifecycleSubject)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        lifecycleSubject.onNext(FragmentEvent.ATTACH)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE)
    }


    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(FragmentEvent.START)
    }

    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(FragmentEvent.RESUME)
    }

    override fun onPause() {
        lifecycleSubject.onNext(FragmentEvent.PAUSE)
        super.onPause()
    }

    override fun onStop() {
        lifecycleSubject.onNext(FragmentEvent.STOP)
        super.onStop()
    }

    override fun onDestroyView() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW)
        super.onDestroyView()
        mView = null
        mContext = null
    }

    override fun onDestroy() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY)
        super.onDestroy()
    }

    override fun onDetach() {
        lifecycleSubject.onNext(FragmentEvent.DETACH)
        super.onDetach()
    }
}
