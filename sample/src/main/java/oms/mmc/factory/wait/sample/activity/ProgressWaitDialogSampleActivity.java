package oms.mmc.factory.wait.sample.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import oms.mmc.factory.wait.factory.BaseWaitDialogFactory;
import oms.mmc.factory.wait.factory.IWaitViewFactory;
import com.wally.android.wait.sample.R;
import oms.mmc.factory.wait.sample.base.BaseWaitViewActivity;

public class ProgressWaitDialogSampleActivity extends BaseWaitViewActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_wait_dialog_sample);
        View rootLayout = findViewById(R.id.rootLayout);
        rootLayout.setOnClickListener(this);
        rootLayout.performClick();
    }

    @Override
    protected IWaitViewFactory onWaitViewFactoryReady() {
        return new BaseWaitDialogFactory();
    }

    @Override
    public void onClick(View v) {
        //展示等待对话框
        showWaitDialog();
        //1.5秒后隐藏对话框
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                hideWaitDialog();
            }
        }, 1500);
    }
}