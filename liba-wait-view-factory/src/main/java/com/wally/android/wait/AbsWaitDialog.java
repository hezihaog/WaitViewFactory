package com.wally.android.wait;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;

import com.wally.android.wait.adapter.SimpleActivityLifecycleCallback;
import com.wally.android.wait.inter.IWaitHandler;
import com.wally.android.wait.inter.IWaitView;
import com.wally.android.wait.listener.WaitViewListener;

import java.util.ArrayList;


/**
 * 对话框实现类抽象类
 */
public abstract class AbsWaitDialog implements IWaitView<Dialog>, IWaitHandler<Dialog> {
    private int hostHashCode;
    private Dialog dialog;
    private ArrayList<WaitViewListener<Dialog>> listeners;

    @Override
    public void init(final Application application) {
        SimpleActivityLifecycleCallback lifecycleCallback = new SimpleActivityLifecycleCallback() {
            @Override
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (isHost(activity)) {
                    destroyDialog();
                    application.unregisterActivityLifecycleCallbacks(this);
                }
            }
        };
        application.registerActivityLifecycleCallbacks(lifecycleCallback);
    }

    @Override
    public void showWaitDialog(final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showWaitDialog(activity, null, true);
            }
        });
    }

    @Override
    public void showWaitDialog(Activity activity, int msgResId, boolean isTouchCancelable) {
        showWaitDialog(activity, activity.getResources().getString(msgResId), isTouchCancelable);
    }

    @Override
    public void showWaitDialog(final Activity activity, CharSequence msg, final boolean isTouchCancelable) {
        if (!(activity != null && !activity.isFinishing())) {
            return;
        }
        hostHashCode = activity.hashCode();
        if (dialog == null) {
            dialog = onCreateDialog(activity, msg);
            if (listeners != null) {
                for (WaitViewListener<Dialog> listener : listeners) {
                    listener.onCreateDialog(dialog, activity, msg);
                }
            }
        }
        if (isShowing()) {
            return;
        }
        //设置是否可以点击取消等待对话框
        dialog.setCanceledOnTouchOutside(isTouchCancelable);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //不能点击取消的话，按返回键取消时，关闭界面
                if (!isTouchCancelable) {
                    activity.finish();
                }
            }
        });
        if (!activity.isFinishing()) {
            dialog.show();
            onShowWaitDialog();
            if (listeners != null) {
                for (WaitViewListener<Dialog> listener : listeners) {
                    listener.onShowWaitDialog();
                }
            }
        }
    }

    @Override
    public void hideWaitDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            onHideWaitDialog();
            if (listeners != null) {
                for (WaitViewListener<Dialog> listener : listeners) {
                    listener.onHideWaitDialog();
                }
            }
        }
    }

    @Override
    public boolean isShowing() {
        if (dialog == null && isShowing()) {
            return false;
        }
        return dialog.isShowing();
    }

    @Override
    public void destroyDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
            onDestroyDialog();
        }
        if (listeners != null) {
            for (WaitViewListener<Dialog> listener : listeners) {
                listener.onDestroyDialog();
            }
        }
        removeAllListener();
    }

    @Override
    public boolean isHost(Activity activity) {
        return hostHashCode == activity.hashCode();
    }

    @Override
    public void addListener(WaitViewListener<Dialog> listener) {
        if (listeners == null) {
            listeners = new ArrayList<WaitViewListener<Dialog>>();
        }
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(WaitViewListener<Dialog> listener) {
        if (listeners != null && listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    @Override
    public void removeAllListener() {
        if (listeners != null) {
            listeners.clear();
        }
    }

    /**
     * 生命周期方法，如果需要做一些处理，子类可重写方法进行添加
     */
    @Override
    public void onShowWaitDialog() {
    }

    @Override
    public void onHideWaitDialog() {
    }

    @Override
    public void onDestroyDialog() {
    }
}