package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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
public class Electricity extends WalletFragment {
    String check_electricity = AppUrl.BASE_URL + AppUrl.METER_VALIDATION;

    LinearLayout meterlayout;

    EditText meterno;

    Button confirm;

    Context context;
    String Meter_no, falsemsg;
    String message, error;
    static int count = 0;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        View v = inflater.inflate(R.layout.electricity, container, false);

        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        init(v);


        return v;
    }

    private void init(View v) {


        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 1;

        //.................initilisation of objects................//
        meterlayout = (LinearLayout) v.findViewById(R.id.meterlayout);
        meterno = (EditText) v.findViewById(R.id.meterno);


        confirm = (Button) v.findViewById(R.id.confirm);

        //.............click action on objects.....................//
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //...............hit api for check meter no is valid or not........//
//

                if (meterno.getText().toString().length() == 0) {

                    Util.showDialog(getActivity(), getText(R.string.meternoreq).toString(), "fail");
                } else {
                    count++;
                    get_meter_no_check();

                }
            }
        });


    }


    private void get_meter_no_check() {
        //............................hide the keyboard...............................//


        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }


        //.
        ShowDialogClass.showProgressing(context, StringsClass.loading, StringsClass.plswait);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, check_electricity,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {


                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");
                                if (success.equalsIgnoreCase("true")) {
                                    JSONObject data = jsonObject.getJSONObject("details");


                                    String clientmeterno = data.getString(Tags.clientmeterno);
                                    String customername = data.getString(Tags.customername);


                                    Meter_no = data.getString(Tags.clientmeterno);
                                    meterlayout.setVisibility(View.GONE);

                                    confirm.setVisibility(View.GONE);



                                    Bundle bundle = new Bundle();

                                    bundle.putString("clientmeterno", clientmeterno);
                                    bundle.putString("customername", customername);

                                    Electricity_Recharge fragobj = new Electricity_Recharge();
                                    fragobj.setArguments(bundle);
                                    runFragment(fragobj);

                                    ShowDialogClass.hideProgressing();

                                } else if (success.equalsIgnoreCase("false")) {



                                    message = jsonObject.getString("msg");


                                    Dialog dialog = Util.showAlertDialog(getActivity(), message, "fail");

                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            dialog.dismiss();
                                        }
                                    });

                                    ShowDialogClass.hideProgressing();


                                }

                            } catch (Exception e) {
//                                    e.printStackTrace();
                                ShowDialogClass.hideProgressing();

                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Dialog dialog = Util.showDialog(context, "Oops! Time Out, Please try again", "fail");
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {


                                dialog.dismiss();
                            }
                        });
//                            }

                        ShowDialogClass.hideProgressing();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());
                params.put(Tags.MeterNumber, meterno.getText().toString());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(35000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.countDownTimer.cancel();

    }
}

