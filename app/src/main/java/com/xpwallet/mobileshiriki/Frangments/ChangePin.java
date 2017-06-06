package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.Common.PasswordTransformation;
import com.xpwallet.mobileshiriki.Activities.LoginScreen;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePin extends WalletFragment {
    String change_url = AppUrl.BASE_URL + AppUrl.CHANGE_PIN;
    private EditText pin, newpin, confirmpin;
    private Button ok;
    SharedPrefrences sharedPrefrences;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.change_pin2, container, false);


        //.................Intialisation of objects............//
        init(v);

        return v;
    }

    private void init(View v) {
//        //........set countdown...........................//
//        countDownTimer = new MyCountDownTimer();
//        countDownTimer.countDownTimer.start();

        sharedPrefrences = new SharedPrefrences(getActivity());
        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;

        //.................set the id of objects..............//

        pin = (EditText) v.findViewById(R.id.pin);
        newpin = (EditText) v.findViewById(R.id.newpin);
        confirmpin = (EditText) v.findViewById(R.id.confirmNewPIN);
        ok = (Button) v.findViewById(R.id.ok);

        pin.setTransformationMethod(new PasswordTransformation());
        newpin.setTransformationMethod(new PasswordTransformation());
        confirmpin.setTransformationMethod(new PasswordTransformation());

        //....................click action on objects..............................//

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkInternet(getActivity()) == false) {
                    ok.setEnabled(true);
                    ok.setClickable(true);
                } else if (pin.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.txnPinReq).toString(), "fail");
                } else if (!pin.getText().toString().equalsIgnoreCase(sharedPrefrences.get_user_pin())) {
                    Util.showAlertDialog(getActivity(), getText(R.string.current_pin).toString(), "fail");
                } else if (newpin.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.newPinRequired).toString(), "fail");
                } else if (newpin.getText().toString().length() < 4) {
                    Util.showAlertDialog(getActivity(), getText(R.string.range4).toString(), "fail");
                } else if (confirmpin.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.retypePinRequired).toString(), "fail");
                } else if (confirmpin.getText().toString().length() < 4) {
                    Util.showAlertDialog(getActivity(), getText(R.string.range4).toString(), "fail");
                } else if (pin.getText().toString().equals(newpin.getText().toString())) {
                    Util.showAlertDialog(getActivity(), getText(R.string.msgtxnPindiff).toString(), "fail");
                } else if (!newpin.getText().toString().equals(confirmpin.getText().toString())) {
                    Util.showAlertDialog(getActivity(), getText(R.string.msgretypePinsame).toString(), "fail");
                } else {

                    //.............hit api.................//
                    change_pin();
                }
            }
        });
    }

    private void change_pin() {
        //....................show progress dialog.....................//
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, change_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");

                                if (success.equals("true")) {
                                    String msg = jsonObject.getString("msg");
                                    pin.setEnabled(false);
                                    newpin.setEnabled(false);
                                    confirmpin.setEnabled(false);
                                    ok.setEnabled(false);

                                    //...............hide dialog...............//
                                    ShowDialogClass.hideProgressing();

                                    Dialog dialog = Util.showDialog(getActivity(), msg, "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            Intent i = new Intent(getActivity(), LoginScreen.class);
                                            startActivity(i);
                                            getActivity().finish();
                                        }
                                    });

                                } else if (success.equals("false")) {
                                    String error = jsonObject.getString("msg");
                                    Util.showAlertDialog(getActivity(), error, "fail");


                                    //...............hide dialog...............//
                                    ShowDialogClass.hideProgressing();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                //...............hide dialog...............//
                                ShowDialogClass.hideProgressing();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Dialog dialog = Util.showDialog(getActivity(), " Oops! time out, Please try again", "fail");

                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                dialog.dismiss();
                            }
                        });
                        ShowDialogClass.hideProgressing();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());
                params.put(Tags.NEWPIN, newpin.getText().toString());
                params.put(Tags.CONFIRMPIN, confirmpin.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
