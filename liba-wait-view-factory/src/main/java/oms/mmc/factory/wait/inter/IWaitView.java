package oms.mmc.factory.wait.inter;

import android.app.Activity;
import android.app.Application;

import oms.mmc.factory.wait.listener.WaitViewListener;

/**
 * 对话框实现类要实现的接口
 */
public interface IWaitView<T> {
    /**
     * 初始化
     *
     * @param application application实例
     */
    void init(final Application application);

    /**
     * 显示等待对话框
     *
     * @param activity activity
     */
    void showWaitDialog(Activity activity);

    /**
     * 显示等待对话框
     *
     * @param activity          activity
     * @param msgResId          附带的信息的资源id
     * @param isTouchCancelable 是否可以点击窗口外取消，并且关闭界面
     */
    void showWaitDialog(Activity activity, int msgResId, boolean isTouchCancelable);

    /**
     * 显示等待对话框
     *
     * @param activity          activity
     * @param msg               附带的信息
     * @param isTouchCancelable 是否可以点击窗口外取消，并且关闭界面
     */
    void showWaitDialog(Activity activity, CharSequence msg, boolean isTouchCancelable);

    /**
     * 隐藏等待对话框
     */
    void hideWaitDialog();

    /**
     * 等待对话框是否展示
     */
    boolean isShowing();

    /**
     * 传入的activity是否是等待对话框的宿主，这里用来判断当前结束的activity是否是该对话框的
     *
     * @param activity activity
     */
    boolean isHost(Activity activity);

    /**
     * 销毁Dialog，通常是activity要销毁了
     */
    void destroyDialog();

    /**
     * 添加等待对话框监听器
     *
     * @param listener 监听器
     */
    void addListener(WaitViewListener<T> listener);

    /**
     * 移除指定等待对话框监听器
     *
     * @param listener 监听器
     */
    void removeListener(WaitViewListener<T> listener);

    /**
     * 移除所有的等待对话框监听器
     */
    void removeAllListener();
}