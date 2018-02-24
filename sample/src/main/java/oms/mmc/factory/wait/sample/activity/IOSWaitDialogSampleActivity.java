package oms.mmc.factory.wait.sample.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import oms.mmc.factory.wait.factory.IWaitViewFactory;
import oms.mmc.factory.wait.sample.R;
import oms.mmc.factory.wait.sample.base.BaseWaitViewActivity;
import oms.mmc.factory.wait.sample.wait.factory.IOSWaitDialogFactory;

public class IOSWaitDialogSampleActivity extends BaseWaitViewActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ios_wait_dialog_sample);
        View rootLayout = findViewById(R.id.rootLayout);
        rootLayout.setOnClickListener(this);
        rootLayout.performClick();
    }

    @Override
    protected IWaitViewFactory onWaitViewFactoryReady() {
        return new IOSWaitDialogFactory();
    }

    @Override
    public void onClick(View v) {
        showWaitDialog();
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                hideWaitDialog();
            }
        }, 1500);
    }
}
