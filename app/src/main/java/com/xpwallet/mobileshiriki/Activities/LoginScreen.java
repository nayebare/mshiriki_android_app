package com.xpwallet.mobileshiriki.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.xpwallet.mobileshiriki.Common.PasswordTransformation;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.ConnectionDetector;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import static com.xpwallet.mobileshiriki.firebaseclasses.MyFirebaseMessagingService.Notification_id;


public class LoginScreen extends AppCompatActivity {
    public String login_url = AppUrl.BASE_URL + AppUrl.LOGIN;
    EditText account, transpin;
    TextView forgotpin;
    Button login;
    private Activity context;
    public static String msg, Login_User_Phone, Login_User_First_name, Login_User_Last_Name, Login_User_Image, myAndroidDeviceId1, myAndroidDeviceId;

    public static String Login_User_Created_time, token1, user_number;
    private final int REQUEST_CODE_IME = 20;
    SharedPrefrences sharedPrefrences;
    String check_nationalID = AppUrl.BASE_URL + AppUrl.CHECK_NATIONAL_ID;
    LinearLayout Forget_layout;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        context = LoginScreen.this;
        Constant.Context = "LoginScreen";

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //.......................initialisation......................//
        init();


    }

    private void init() {

        //.................get and set values in shared prefrences.................//
        sharedPrefrences = new SharedPrefrences(this);
        sharedPrefrences.get_user_id();

        token1 = FirebaseInstanceId.getInstance().getToken();
        sharedPrefrences.set_notification_token(token1);


        //............set state.........//
        Constant.login_state = 1;

        if (Build.VERSION.SDK_INT < 23) {
            //.................get/_user_phone_imei number....................//
            get_phone_details();
        }

        //.................set the id of all objects....................//
        account = (EditText) findViewById(R.id.walletId);
        transpin = (EditText) findViewById(R.id.userPin);
        login = (Button) findViewById(R.id.login_button);

        transpin.setTransformationMethod(new PasswordTransformation());
        forgotpin = (TextView) findViewById(R.id.forgotpin);
        Forget_layout = (LinearLayout) findViewById(R.id.forget_layout);
        //.....................click action on obj0ects.....................//

        Forget_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (account.getText().toString().length() == 0) {
                    Util.showAlertDialog(LoginScreen.this, getText(R.string.walletIDreq).toString(), "fail");
                } else {

                    get_national_id_code();


                }


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //............................hide the keyboard...............................//

                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }


                if (checkInternet(context) == false) {
                    login.setEnabled(true);
                    login.setClickable(true);
                } else if (account.getText().toString().length() == 0) {
                    Util.showAlertDialog(LoginScreen.this, getText(R.string.walletIDreq).toString(), "fail");
                } else if (transpin.getText().toString().length() == 0) {
                    Util.showAlertDialog(LoginScreen.this, getText(R.string.txnPinRequired).toString(), "fail");
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (checkPermission()) {
                        //................hit the api................//
                        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        manager.cancel(Notification_id);
                        login();

                    } else {
                        requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_PHONE_STATE}, REQUEST_CODE_IME);
                    }
                } else {

                    //................hit the api................//


                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.cancel(Notification_id);
                    login();
                }


            }


        });


    }

    public boolean checkInternet(Activity ctx) {
        ConnectionDetector cd = new ConnectionDetector(ctx);
        if (cd.isConnectingToInternet() == false) {
            Util.showAlertDialog(ctx, ctx.getText(R.string.msgNoInternetConnection).toString(), "fail");
            return false;
        }
        return true;
    }


    private void login() {

        ShowDialogClass.showProgressing(LoginScreen.this, StringsClass.loading, StringsClass.plswait);

        Util.ssl();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {

                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                if (success.equals("true")) {

                                    login.setEnabled(false);

                                    JSONObject jsonObject1 = jsonObject.getJSONObject("details");

                                    sharedPrefrences.set_user_id(jsonObject1.getString(Tags.USERID), jsonObject1.getString(Tags.PHONE), transpin.getText().toString());

                                    Login_User_Created_time = jsonObject1.getString(Tags.CREATEDDATE);
                                    Login_User_First_name = jsonObject1.getString("user");
                                    Login_User_Last_Name = jsonObject1.getString("last_name");
                                    Login_User_Phone = jsonObject1.getString("phone");
                                    Login_User_Image = jsonObject1.getString("image");
                                    Login_User_Created_time = jsonObject1.getString("created_on");
                                    sharedPrefrences.set_user_details(Login_User_First_name, Login_User_Last_Name, Login_User_Image, Login_User_Created_time);


                                    Intent i = new Intent(LoginScreen.this, MainActivity.class);
                                    i.putExtra(Tags.USERNAME, jsonObject1.getString(Tags.USERNAME));
                                    i.putExtra(Tags.Image, jsonObject1.getString(Tags.Image));
                                    startActivity(i);
                                    finish();


                                    ShowDialogClass.hideProgressing();
//                                ;

                                } else if (success.equals("false")) {
                                    login.setEnabled(true);

                                    String error = jsonObject.getString("msg");

                                    Dialog dialog = Util.showDialog(LoginScreen.this, error, "fail");

                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                        }
                                    });

                                    ShowDialogClass.hideProgressing();


                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                ShowDialogClass.hideProgressing();

                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("xpwallet", "error" + error);

                        if (error.equals("com.android.volley.NoConnectionError")) {
                            dialog = Util.showDialog(LoginScreen.this, " Oops! time out, Server issue", "fail");
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    dialog.dismiss();
                                }
                            });
                        } else {
                            dialog = Util.showDialog(LoginScreen.this, " Oops! time out, Please try again", "fail");
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    dialog.dismiss();
                                }
                            });
                        }


                        ShowDialogClass.hideProgressing();


                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(Tags.PHONE, account.getText().toString());
                params.put(Tags.PIN, transpin.getText().toString());
                params.put(Tags.GCM_KEY, sharedPrefrences.gettoken());
                params.put(Tags.IMEI_Number, sharedPrefrences.get_imei_number());
                params.put(Tags.VERSION, "1.2");


                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(LoginScreen.this);

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(35000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }

    private boolean checkPermission() {

        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return true;

        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_IME && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            get_phone_details();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences preferences = getSharedPreferences("Prefrences", Context.MODE_PRIVATE);
        preferences.edit().remove(Tags.USERID).commit();
        finish();
    }

    public void get_phone_details() {

        TelephonyManager mTelephony = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);


        if (mTelephony.getDeviceId().equalsIgnoreCase("")) {
            myAndroidDeviceId1 = mTelephony.getDeviceId();
            sharedPrefrences.set_imei_number(myAndroidDeviceId1);


        } else if (!mTelephony.getDeviceId().equalsIgnoreCase("")) {

            myAndroidDeviceId1 = mTelephony.getDeviceId();
            sharedPrefrences.set_imei_number(myAndroidDeviceId1);
        } else {
            myAndroidDeviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        }
    }

    private void get_national_id_code() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, check_nationalID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                if (success.equals("true")) {

                                    Forget_layout.setEnabled(false);

                                    JSONObject data = jsonObject.getJSONObject("details");


                                    user_number = String.valueOf(data.get("national_id"));
                                    Intent i = new Intent(LoginScreen.this, ForgotPin.class);
                                    i.putExtra("user_national_id", user_number);
                                    i.putExtra("user_phone", account.getText().toString());
                                    startActivity(i);
                                    finish();


                                    if (user_number.equalsIgnoreCase("")) {
                                        Dialog dialog = Util.showDialog(LoginScreen.this, "National_id should not be empty", "fail");
                                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                            @Override
                                            public void onDismiss(DialogInterface dialog) {

                                                dialog.dismiss();
                                            }
                                        });

                                    }


                                } else {
                                    Forget_layout.setEnabled(true);

                                    msg = jsonObject.getString("msg");
                                    Dialog dialog = Util.showDialog(LoginScreen.this, msg, "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
//
                                            dialog.dismiss();
                                        }
                                    });

                                    //...............hide dialog..............//

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

                        if (error.equals("com.android.volley.NoConnectionError")) {
                            Dialog dialog = Util.showDialog(LoginScreen.this, "Oops! Server error", "fail");
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {

                                    dialog.dismiss();
                                }
                            });
                        } else {
                            Dialog dialog = Util.showDialog(LoginScreen.this, "Oops! Time Out, Please try again", "fail");
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {

                                    dialog.dismiss();
                                }
                            });
                        }

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(Tags.PHONE, account.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(35000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }
}







