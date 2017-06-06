package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
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

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dstv extends WalletFragment {
    String tv_recharge = AppUrl.BASE_URL + AppUrl.TV_RECHARGE;
    EditText smartcard, phone, amount, agentpin;
    Button confirm;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dstv, container, false);

        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //...................initialisation.................//
        init(v);
        return v;

    }

    private void init(View v) {


        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 1;

        //..................initialisation of objects........................//

        smartcard = (EditText) v.findViewById(R.id.smartcard);
        phone = (EditText) v.findViewById(R.id.phone);
        amount = (EditText) v.findViewById(R.id.amount);
        agentpin = (EditText) v.findViewById(R.id.agentpin);
        confirm = (Button) v.findViewById(R.id.confirm);

        //...............click action on objects.................//
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (smartcard.getText().toString().length() == 0) {
                    Util.showDialog(getActivity(), getText(R.string.smartcardreq).toString(), "fail");
                } else if (smartcard.getText().toString().length() < 11) {
                    Util.showDialog(getActivity(), "Smart card number should not be less than 9 digits", "fail");
                } else if (phone.getText().toString().length() == 0) {
                    Util.showDialog(getActivity(), getText(R.string.phonereq).toString(), "fail");


                } else if (phone.getText().toString().length() < 9) {
                    Util.showDialog(getActivity(), "Phone " + " " + getText(R.string.range9).toString(), "fail");


                } else if (amount.getText().toString().length() == 0) {
                    Util.showDialog(getActivity(), getText(R.string.amountre).toString(), "fail");
                } else if (amount.getText().toString().length() <= 2) {
                    Util.showDialog(getActivity(), "amount" + " " + getText(R.string.range).toString(), "fail");
                } else if (agentpin.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), "Enter Pin", "fail");
                } else if (!agentpin.getText().toString().equals(SharedPrefrences.get_user_pin())) {
                    Util.showAlertDialog(getActivity(), "Enter valid PIN", "fail");
                } else {


                    //.....................hide keyboard...............//
                    try {
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    //........................recharge_dstv....................//
                    String msg1 = smartcard.getText().toString();
                    String msg = amount.getText().toString();
                    String type = "Dishtv";

                    confirmdiloag(getActivity(), type, "Smart Card Number :" + " " + msg1, "Amount :" + " " + msg);
//            recharge_dstv();
                }
            }
        });

    }


    public void recharge_dstv() {
        if (checkInternet(getActivity()) == false) {
        } else {
            get_Recharge_dstv();

        }

    }

    private void get_Recharge_dstv() {


        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, tv_recharge,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                String message = jsonObject.getString("msg");


                                if (success.equalsIgnoreCase("true")) {
                                    confirm.setEnabled(false);

                                    Dialog dialog = Util.showDialog(getActivity(), message, "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
//
                                            getActivity().onBackPressed();


                                        }
                                    });
                                    ShowDialogClass.hideProgressing();


                                } else {


                                    Dialog dialog = Util.showAlertDialog(getActivity(), message, "fail");

                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {

                                            dialog.dismiss();

                                            ShowDialogClass.hideProgressing();

                                        }
                                    });
                                }
                                Util.hideProgressing();

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
                        Dialog dialog = Util.showDialog(getActivity(), "Oops! Time Out, Please try again", "fail");
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
//                                      ;
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
                params.put(Tags.PIN, agentpin.getText().toString());
                params.put(Tags.smartcardno, smartcard.getText().toString());
                params.put(Tags.Amount, amount.getText().toString());
                params.put(Tags.costumer_number, phone.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(35000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}

