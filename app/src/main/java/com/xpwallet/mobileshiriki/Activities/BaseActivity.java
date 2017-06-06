package com.xpwallet.mobileshiriki.Activities;

import android.app.Activity;
import android.os.Bundle;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;

/**
 * Created by arjun on 22/02/2017.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //.............set timer count down..................//
        MyCountDownTimer.countDownTimer = new MyCountDownTimer();
        onUserInteraction();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        //..................cancel and start counter when change activity...............//
        MyCountDownTimer.countDownTimer.cancel();
        MyCountDownTimer.countDownTimer.start();
    }


}
