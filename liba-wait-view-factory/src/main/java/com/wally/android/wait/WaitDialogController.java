package com.wally.android.wait;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;

import com.wally.android.wait.iml.ProgressWaitDialogIml;
import com.wally.android.wait.inter.IWaitView;
import com.wally.android.wait.inter.IWaitViewController;

import java.lang.reflect.Constructor;

/**
 * Package: oms.mmc.android.fast.framwork.basiclib.util
 * FileName: WaitDialogHelper
 * Date: on 2018/2/5  下午12:20
 * Auther: zihe
 * Descirbe:等待对话框控制器
 * Email: hezihao@linghit.com
 */

public class WaitDialogController implements IWaitViewController<Dialog> {
    private Application mApplication;
    private IWaitView<Dialog> mWaitIml;

    public WaitDialogController(Activity activity) {
        this(activity, ProgressWaitDialogIml.class);
    }

    public WaitDialogController(Activity activity, Class<? extends IWaitView<Dialog>> waitImlClass) {
        this.mApplication = activity.getApplication();
        this.mWaitIml = parseIml(waitImlClass);
    }

    /**
     * 解析实现类
     *
     * @param waitImlClass 等待对话框执行实现类
     */
    @Override
    public IWaitView<Dialog> parseIml(Class<? extends IWaitView<Dialog>> waitImlClass) {
        if (waitImlClass == null) {
            throw new IllegalArgumentException("waitIml must not null");
        }
        IWaitView<Dialog> waitIml = null;
        try {
            Constructor<? extends IWaitView> constructor = waitImlClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            waitIml = waitImlClass.newInstance();
            waitIml.init(mApplication);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return waitIml;
    }

    @Override
    public void setWaitIml(IWaitView<Dialog> newWaitIml) {
        this.mWaitIml = newWaitIml;
    }

    @Override
    public void setWaitIml(Class<? extends IWaitView<Dialog>> newWaitImlClass) {
        this.mWaitIml = parseIml(newWaitImlClass);
    }

    @Override
    public IWaitView<Dialog> getWaitIml() {
        return mWaitIml;
    }

    @Override
    public Application getApplication() {
        return mApplication;
    }
}