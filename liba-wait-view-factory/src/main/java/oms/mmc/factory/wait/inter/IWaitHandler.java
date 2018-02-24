package oms.mmc.factory.wait.inter;

import android.app.Activity;

/**
 * WaitDialog实际处理者
 */
public interface IWaitHandler<T> {
    /**
     * 创建弹窗
     *
     * @param activity activity实例
     * @param msg      显示的等待提示消息文字
     * @return 等待对话框对象
     */
    T onCreateDialog(Activity activity, CharSequence msg);

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