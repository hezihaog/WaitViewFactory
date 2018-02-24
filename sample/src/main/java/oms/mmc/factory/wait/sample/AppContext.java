package oms.mmc.factory.wait.sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Package: com.wally.android.wait.sample
 * FileName: AppContext
 * Date: on 2018/2/23  下午5:00
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
