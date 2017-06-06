package com.xpwallet.mobileshiriki.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.xpwallet.mobileshiriki.Frangments.WalletFragment.checkInternet;

public class ForgotPin extends BaseActivity {
    String forget_pin = AppUrl.BASE_URL + AppUrl.FORGET_PIN;
    LinearLayout nationallayout, forgotpinlayout;
    EditText nationid, newpin, confirmNewPIN;
    Button ok, submit;
    String msg, Login_user_phn, Login_user_nation_id;
    MyCountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pin);

        //...................set activity in count down.............//
        MyCountDownTimer.setContext(ForgotPin.this);
        //...................initialisation ...............//
        initui();

    }


    private void initui() {

        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //...................get data through intent.........................//
        Intent i = getIntent();
        Login_user_phn = i.getStringExtra("user_phone");
        Login_user_nation_id = i.getStringExtra("user_national_id");

        //.......................intialisation the objects.....................//

        nationallayout = (LinearLayout) findViewById(R.id.nationallayout);
        forgotpinlayout = (LinearLayout) findViewById(R.id.forgotpinlayout);
        nationid = (EditText) findViewById(R.id.nationid);
        newpin = (EditText) findViewById(R.id.newpin);
        confirmNewPIN = (EditText) findViewById(R.id.confirmNewPIN);
        ok = (Button) findViewById(R.id.ok);
        submit = (Button) findViewById(R.id.submit);

        //................click action on objects.................//
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //............................hide the keyboard...............................//

                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }


                checknationalid();
            }

        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //............................hide the keyboard...............................//

                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }


                if (checkInternet(ForgotPin.this) == false) {
                    submit.setEnabled(true);
                    submit.setClickable(true);

                } else {
                    forgotpin();
                }
            }


        });
    }

    private void forgotpin() {


        if (newpin.getText().toString().length() == 0) {

            Util.showDialog(ForgotPin.this, getText(R.string.newPinRequired).toString(), "fail");
        } else if (newpin.getText().toString().length() < 4) {
            Util.showDialog(ForgotPin.this, getText(R.string.range4).toString(), "fail");

        } else if (confirmNewPIN.getText().toString().length() == 0) {
            Util.showDialog(ForgotPin.this, getText(R.string.retypePinRequired).toString(), "fail");
        } else if (!newpin.getText().toString().equals(confirmNewPIN.getText().toString())) {
            Util.showAlertDialog(ForgotPin.this, getText(R.string.msgretypePinsame).toString(), "fail");
        } else {
            //............. create forget pin request.................//
            for_got_pin();
        }


    }

    private void checknationalid() {
        String nationalid = nationid.getText().toString();
        if (nationalid.equalsIgnoreCase("")) {
            Dialog dialog = Util.showDialog(this, "National ID  is required", "fail");
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    dialog.dismiss();
                }
            });
        } else if (nationalid.equalsIgnoreCase(Login_user_nation_id)) {
            nationallayout.setVisibility(View.GONE);
            forgotpinlayout.setVisibility(View.VISIBLE);
        } else {

            Dialog dialog = Util.showDialog(this, "National ID doesn't match,You can't reset PIN", "fail");
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    dialog.dismiss();
                }
            });
        }
    }


    private void for_got_pin() {

        //....................show progress dialog..................//
        ShowDialogClass.showProgressing(this, StringsClass.loading, StringsClass.plswait);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, forget_pin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                if (success.equals("true")) {
                                    JSONObject data = jsonObject.getJSONObject("details");
                                    msg = data.getString("msg");
                                    Dialog dialog = Util.showDialog(ForgotPin.this, msg, "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            Intent i = new Intent(ForgotPin.this, LoginScreen.class);
                                            startActivity(i);
                                            finish();
                                        }
                                    });

                                    //.................hide progress bar..................//
                                    ShowDialogClass.hideProgressing();

                                } else {
                                    Util.showDialog(ForgotPin.this, msg, "fail");
                                    //.................hide progress bar..................//
                                    ShowDialogClass.hideProgressing();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(Tags.PHONE, Login_user_phn);
                params.put(Tags.newpin, newpin.getText().toString());
                params.put(Tags.confirmpin, confirmNewPIN.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(ForgotPin.this);
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ForgotPin.this, LoginScreen.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
