package com.wally.android.wait.sample.widget;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.wally.android.wait.sample.R;


public class IOSWaitDialog extends Dialog {
    private TextView message;

    public IOSWaitDialog(Context context) {
        this(context, R.layout.view_ios_wait_dialog, R.style.ios_dialog_wait);
    }

    public IOSWaitDialog(Context context, int layout, int style) {
        super(context, style);
        setContentView(layout);
        Window window = getWindow();
        LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.dimAmount = 0.0f;
        window.setAttributes(params);
        message = (TextView) findViewById(R.id.message);
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(true);
        showProgress();
    }

    private void showProgress() {
        //进度加载动画开始
        final ImageView progress = (ImageView) getWindow().findViewById(R.id.progress);
        ValueAnimator animator = ValueAnimator.ofFloat(0, 360);
        animator.setDuration(1200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float cValue = (Float) animation.getAnimatedValue();
                progress.setRotation(cValue);
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    public void setMessage(CharSequence msg) {
        if (TextUtils.isEmpty(msg)) {
            message.setVisibility(View.GONE);
        } else {
            message.setVisibility(View.VISIBLE);
            message.setText(msg);
        }
    }

    public void showMessage(CharSequence msg) {
        setMessage(msg);
        show();
    }
}
