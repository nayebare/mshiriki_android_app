package com.xpwallet.mobileshiriki.Frangments;

import android.app.Dialog;

import android.content.DialogInterface;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
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


public class Tnx_Receipt extends WalletFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    TextView customer_text, desc_text, txn_type, txn_desc, txn_ammount, txn_date, txn_status, txn_customer_n, txn_token_number, token_text;
    String url = AppUrl.BASE_URL + AppUrl.TXN_RECEIPT;
    LinearLayout print_btn;
    String recipt_id;
    MyCountDownTimer countDownTimer;
    View token_number, customer_view, desc_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tnx_receipt, container, false);
        //....................initialisation...............//
        init(v);

        return v;

    }

    private void init(View v) {

        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        Constant.Receipt_txn = 1;

        recipt_id = this.getArguments().getString("recipt_id");

        //.................set id id of all objects......................//
        txn_type = (TextView) v.findViewById(R.id.recipt_type);
        txn_desc = (TextView) v.findViewById(R.id.receipt_desc);
        txn_status = (TextView) v.findViewById(R.id.recipt_status);
        txn_date = (TextView) v.findViewById(R.id.recipt_date);
        txn_ammount = (TextView) v.findViewById(R.id.receipt_amnt);
        txn_customer_n = (TextView) v.findViewById(R.id.receipt_customer_name);
        txn_token_number = (TextView) v.findViewById(R.id.receipt_token);
        token_text = (TextView) v.findViewById(R.id.textView7);

        customer_text = (TextView) v.findViewById(R.id.customer_text);
        desc_text = (TextView) v.findViewById(R.id.desc_text);

        token_number = (View) v.findViewById(R.id.token_view);
        customer_view = (View) v.findViewById(R.id.Customer_view);
        desc_view = (View) v.findViewById(R.id.desc_view);

        print_btn = (LinearLayout) v.findViewById(R.id.print);




        //................click action on objects......................//
        print_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Util.showDialog(getActivity(), "Under Development", "fail");


            }
        });

        //................hit api......................//

        get_details();

    }

    private void get_details() {
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
                                if (success.equalsIgnoreCase("true")) {


                                    JSONObject jsonObject1 = jsonObject.getJSONObject("txn_data");




                                    if (jsonObject1.getString("transaction_type").equals(jsonObject1.getString("transaction_sub_type"))) {
                                        txn_type.setText(jsonObject1.getString("transaction_type"));

                                    } else {
                                        txn_type.setText(jsonObject1.getString("transaction_type") + " " + jsonObject1.getString("transaction_sub_type"));

                                    }


                                    txn_ammount.setText(Util.getamountdecimal(jsonObject1.getString("amount")));

                                    txn_status.setText("PROCESSED");


                                    if (jsonObject1.getString("customer_number").equals("null") && jsonObject1.getString("token").equals("null") && jsonObject1.getString("vat").equals("null")) {


                                    } else {


                                        desc_text.setVisibility(View.VISIBLE);
                                        token_text.setVisibility(View.VISIBLE);
                                        customer_text.setVisibility(View.VISIBLE);

                                        txn_token_number.setVisibility(View.VISIBLE);
                                        customer_view.setVisibility(View.VISIBLE);
                                        desc_view.setVisibility(View.VISIBLE);
                                        token_number.setVisibility(View.VISIBLE);
                                        txn_customer_n.setVisibility(View.VISIBLE);
                                        txn_desc.setVisibility(View.VISIBLE);

                                        txn_customer_n.setText(jsonObject1.getString("customer_number"));

                                        txn_token_number.setText(jsonObject1.getString("token"));
                                        txn_desc.setText("VAT :" + jsonObject1.getString("vat") + " " + "Unit :" + jsonObject1.getString("unit"));

                                    }

                                    String date = jsonObject1.getString("date");
                                    txn_date.setText(date.substring(0, date.indexOf("T")));


                                    ShowDialogClass.hideProgressing();


                                } else {
                                    Dialog dialog = Util.showDialog(getActivity(), getText(R.string.lblNoTransactionFound).toString(), "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            dialog.dismiss();
                                        }
                                    });
                                    ShowDialogClass.hideProgressing();

                                }

                                ShowDialogClass.hideProgressing();


                            } catch (Exception e) {
                                e.printStackTrace();

                                //................hide dialog............//
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
                params.put(Tags.RECEIPT_ID, recipt_id);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(35000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();

    }



    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }

}
