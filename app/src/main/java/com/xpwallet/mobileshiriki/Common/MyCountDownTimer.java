package com.xpwallet.mobileshiriki.Common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;

import com.xpwallet.mobileshiriki.Activities.LoginScreen;
import com.xpwallet.mobileshiriki.Activities.MainActivity;
import com.xpwallet.mobileshiriki.util.Tags;

public class MyCountDownTimer extends CountDownTimer {
    public MyCountDownTimer() {
        super(10 * 60 * 1000, 1000);
    }


    public static MyCountDownTimer countDownTimer;
    static Context myContext;

    @Override
    public void onFinish() {

        //...................finish the acticity..............//

        ((Activity) myContext).finish();

        //...................stop  the timer..............//

        MainActivity.timer.cancel();
        MainActivity.timer.purge();

       //...................Remove the saved data from shared prefrences ..............//
        SharedPreferences preferences = myContext.getSharedPreferences("Prefrences", Context.MODE_PRIVATE);
        preferences.edit().remove(Tags.USERID).commit();

        //...................go to Login Screen ..............//

        Intent i = new Intent(myContext, LoginScreen.class);
        myContext.startActivity(i);


    }

    public static void setContext(Context context) {
        myContext = context;
    }


    @Override
    public void onTick(long millisUntilFinished) {
    }
}