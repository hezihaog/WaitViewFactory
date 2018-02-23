package com.wally.android.wait.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wally.android.wait.sample.activity.IOSWaitDialogSampleActivity;
import com.wally.android.wait.sample.activity.ProgressWaitDialogSampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mProgressWaitBtn;
    private Button mIosWaitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressWaitBtn = findViewById(R.id.progressWaitBtn);
        mIosWaitBtn = findViewById(R.id.iosWaitBtn);
        mProgressWaitBtn.setOnClickListener(this);
        mIosWaitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.progressWaitBtn:
                startActivity(new Intent(this, ProgressWaitDialogSampleActivity.class));
                break;
            case R.id.iosWaitBtn:
                startActivity(new Intent(this, IOSWaitDialogSampleActivity.class));
                break;
            default:
                break;
        }
    }
}