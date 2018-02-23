package com.wally.android.wait.listener;

import android.app.Activity;

/**
 * Package: com.wally.android.wait.listener
 * FileName: WaitDialogListener
 * Date: on 2018/2/23  下午2:49
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public interface WaitViewListener<T> {
    /**
     * 创建弹窗
     *
     * @param waitView 等待对话框对象
     * @param activity activity实例
     * @param msg      显示的等待提示消息文字
     * @return 等待对话框对象
     */
    void onCreateDialog(T waitView, Activity activity, CharSequence msg);

    /**
     * 当显示时回调
     */
    void onShowWaitDialog();

    /**
     * 当隐藏时回调
     */
    void onHideWaitDialog();

    /**
     * 当销毁窗口时回调
     */
    void onDestroyDialog();
}