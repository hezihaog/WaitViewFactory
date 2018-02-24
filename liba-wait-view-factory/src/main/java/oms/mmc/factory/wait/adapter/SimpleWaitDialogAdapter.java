package oms.mmc.factory.wait.adapter;

import android.app.Activity;
import android.app.Dialog;

import oms.mmc.factory.wait.listener.WaitViewListener;

/**
 * Package: com.wally.android.wait.adapter
 * FileName: SimpleWaitViewAdapter
 * Date: on 2018/2/23  下午3:14
 * Auther: zihe
 * Descirbe:WaitViewListener针对Dialog类型的空实现
 * Email: hezihao@linghit.com
 */

public class SimpleWaitDialogAdapter implements WaitViewListener<Dialog> {
    @Override
    public void onCreateDialog(Dialog waitView, Activity activity, CharSequence msg) {

    }

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