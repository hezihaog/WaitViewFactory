package com.wally.android.wait.factory;

import android.app.Activity;

import com.wally.android.wait.WaitDialogController;

/**
 * Package: com.wally.android.wait.factory
 * FileName: IWaitFactory
 * Date: on 2018/2/23  下午2:05
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public interface IWaitViewFactory {
    WaitDialogController getWaitDialogController(Activity activity);
}