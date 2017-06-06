package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceEnquiry extends WalletFragment {
    TextView username, accountbalance, loanbalance, commissionbalance, pently;
    SharedPreferences shared;
    LinearLayout loanpenalty, outstandingloan, commbalance;
    String url = AppUrl.BASE_URL + AppUrl.BALANCE_ENQUIRY;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.balance_enquiry, container, false);

        //.......................set countdown timer.......................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //.............................intialisation of all objects....................//
        init(v);

        return v;
    }

    private void init(View v) {

        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 2;

        //...................initialisation of objects...............//
        username = (TextView) v.findViewById(R.id.username);
        username.setText(SharedPrefrences.get_user_first_name() + " " + SharedPrefrences.get_user_last_name());


        accountbalance = (TextView) v.findViewById(R.id.accountbalance);
        loanbalance = (TextView) v.findViewById(R.id.loanbalance);
        commissionbalance = (TextView) v.findViewById(R.id.commissionbalance);
        pently = (TextView) v.findViewById(R.id.pently);

        loanpenalty = (LinearLayout) v.findViewById(R.id.loanpenalty);
        outstandingloan = (LinearLayout) v.findViewById(R.id.outstandingloan);
        commbalance = (LinearLayout) v.findViewById(R.id.commbalance);


        //...................check the network connection....................//

        if (checkInternet(getActivity()) == false) {

        } else {
            //...................hit the api....................//
            requestForData();

        }


    }

    private void requestForData() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                if (success.equals("true")) {

                                    JSONObject details = jsonObject.getJSONObject("details");


                                    accountbalance.setText("RWF" + " " + Util.getamountdecimal(details.getString(Tags.Agentbalance)));
                                    loanbalance.setText(Util.getamountdecimal(details.getString(Tags.AgentCredit)));
                                    commissionbalance.setText(Util.getamountdecimal(details.getString(Tags.Agentcommission)));
                                    pently.setText(Util.getamountdecimal(details.getString(Tags.Agentpenalty)));
                                    if (details.getString(Tags.AgentCredit).equals("0.0")) {
                                        outstandingloan.setVisibility(View.GONE);
                                    } else {
                                        outstandingloan.setVisibility(View.VISIBLE);
                                    }
                                    if (details.getString(Tags.Agentcommission).equals("0")) {
                                        commbalance.setVisibility(View.GONE);
                                    } else {
                                        commbalance.setVisibility(View.VISIBLE);
                                    }
                                    if (details.getString(Tags.Agentpenalty).equals("0.0")) {
                                        loanpenalty.setVisibility(View.GONE);
                                    } else if (details.getString(Tags.Agentpenalty).equals("0")) {
                                        loanpenalty.setVisibility(View.GONE);
                                    } else {
                                        loanpenalty.setVisibility(View.VISIBLE);
                                    }
                                    ShowDialogClass.hideProgressing();

                                } else if (success.equals("false")) {
                                    String error = jsonObject.getString("msg");
                                    Util.showAlertDialog(getActivity(), error, "fail");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                ShowDialogClass.hideProgressing();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Dialog dialog = Util.showDialog(getActivity(), "Oops! Time Out, Please try again", "fail");
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
//
                                dialog.dismiss();
                            }
                        });
                        ShowDialogClass.hideProgressing();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());
                return params;
            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());


        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}



