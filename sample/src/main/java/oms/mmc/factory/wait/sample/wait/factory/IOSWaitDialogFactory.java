package oms.mmc.factory.wait.sample.wait.factory;

import android.app.Activity;

import oms.mmc.factory.wait.WaitDialogController;
import oms.mmc.factory.wait.factory.IWaitViewFactory;
import oms.mmc.factory.wait.sample.wait.iml.IOSWaitDialogIml;

/**
 * Package: com.wally.android.wait.sample.factory
 * FileName: IOSWaitDialogFactory
 * Date: on 2018/2/23  下午2:30
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class IOSWaitDialogFactory implements IWaitViewFactory {

    @Override
    public WaitDialogController getWaitDialogController(Activity activity) {
        return new WaitDialogController(activity, IOSWaitDialogIml.class);
    }
}