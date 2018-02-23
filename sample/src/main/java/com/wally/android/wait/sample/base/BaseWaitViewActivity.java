package com.wally.android.wait.sample.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wally.android.wait.WaitDialogController;
import com.wally.android.wait.factory.BaseWaitDialogFactory;
import com.wally.android.wait.factory.IWaitViewFactory;
import com.wally.android.wait.listener.WaitViewListener;
import com.wally.android.wait.sample.R;

/**
 * Package: com.wally.android.wait.sample
 * FileName: BaseActivity
 * Date: on 2018/2/23  下午2:20
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public abstract class BaseWaitViewActivity extends AppCompatActivity {
    public static final String TAG = BaseWaitViewActivity.class.getName();
    private WaitDialogController mWaitDialogController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取当前界面设置的等待对话框工厂对象
        IWaitViewFactory waitViewFactory = onWaitViewFactoryReady();
        //获取控制对象
        mWaitDialogController = waitViewFactory.getWaitDialogController(this);
        //使用控制对象获取真正的对话框实现类，添加一个显示监听
        mWaitDialogController.getWaitIml().addListener(new WaitViewListener<Dialog>() {
            @Override
            public void onCreateDialog(Dialog waitView, Activity activity, CharSequence msg) {
                Log.d(TAG, "onCreateDialog ::: 等待对话框创建了");
            }

            @Override
            public void onShowWaitDialog() {
                Log.d(TAG, "onCreateDialog ::: 等待对话框展示了");
            }

            @Override
            public void onHideWaitDialog() {
                Log.d(TAG, "onCreateDialog ::: 等待对话框隐藏了");
            }

            @Override
            public void onDestroyDialog() {
                Log.d(TAG, "onCreateDialog ::: 等待对话框销毁了");
            }
        });
    }

    /**
     * 默认创建一个等待对话框工厂对象，子类需要不同的对话框时，复写该方法
     */
    protected IWaitViewFactory onWaitViewFactoryReady() {
        return new BaseWaitDialogFactory();
    }

    public void showWaitDialog() {
        if (mWaitDialogController != null && mWaitDialogController.getWaitIml() != null) {
            mWaitDialogController.getWaitIml().showWaitDialog(this, R.string.wait_dialog_tip_loading, false);
        }
    }

    public void hideWaitDialog() {
        if (mWaitDialogController != null && mWaitDialogController.getWaitIml() != null) {
            mWaitDialogController.getWaitIml().hideWaitDialog();
        }
    }
}