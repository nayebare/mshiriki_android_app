package com.xpwallet.mobileshiriki.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;

public class SplashScreen extends Activity {

    SharedPrefrences sharedPrefrences;
    protected static Context context;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
        FirebaseCrash.log("Activity created");

        //.........................intialisation of shared prefrences................//
        sharedPrefrences = new SharedPrefrences(SplashScreen.this);

        //....................go to next activity.....................//
        go_next_activity();

    }

    private void go_next_activity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //...........................go to next activity............................//

                Intent i = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(i);
                finish();


            }
        }, 3000);
    }

}
