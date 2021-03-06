package oms.mmc.factory.wait.iml;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;

import oms.mmc.factory.wait.AbsWaitDialog;


/**
 * Package: oms.mmc.android.fast.framwork.basiclib.util
 * FileName: ProgressDialogWaitIml
 * Date: on 2018/2/5  下午12:32
 * Auther: zihe
 * Descirbe:ProgressDialog形式的等待覆盖
 * Email: hezihao@linghit.com
 */

public class ProgressWaitDialogIml extends AbsWaitDialog {

    @Override
    public Dialog onCreateDialog(Activity activity, CharSequence msg) {
        ProgressDialog dialog = new ProgressDialog(activity);
        if (msg != null) {
            dialog.setMessage(msg);
        }
        return dialog;
    }
}