package oms.mmc.factory.wait.factory;

import android.app.Activity;

import oms.mmc.factory.wait.WaitDialogController;
import oms.mmc.factory.wait.iml.ProgressWaitDialogIml;

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