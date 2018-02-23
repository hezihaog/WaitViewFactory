package com.wally.android.wait.sample.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.wally.android.wait.factory.IWaitViewFactory;
import com.wally.android.wait.sample.R;
import com.wally.android.wait.sample.base.BaseWaitViewActivity;
import com.wally.android.wait.sample.wait.factory.IOSWaitDialogFactory;

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
