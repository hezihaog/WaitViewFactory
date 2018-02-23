package com.wally.android.wait.factory;

import android.app.Activity;

import com.wally.android.wait.WaitDialogController;
import com.wally.android.wait.iml.ProgressWaitDialogIml;

/**
 * Package: com.wally.android.wait.factory
 * FileName: BaseWaitDialogFactory
 * Date: on 2018/2/23  下午2:09
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class BaseWaitDialogFactory implements IWaitViewFactory {

    @Override
    public WaitDialogController getWaitDialogController(Activity activity) {
        return new WaitDialogController(activity, ProgressWaitDialogIml.class);
    }
}