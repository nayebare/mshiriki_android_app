package com.xpwallet.mobileshiriki.Frangments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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


public class Electricity_Recharge extends WalletFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    String pay_bill = AppUrl.BASE_URL + AppUrl.ELECTRICITY_RECHARGE;
    String Meter_no, falsemsg;
    String meter_no, user_name;

    EditText meterno, amount, Customer_number, agentpin;
    Button ammount_confirm1;
    TextView meternumber, username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_electricity__recharge, container, false);
        //...........initialisation...........................//
        init(v);
        return v;
    }

    private void init(View v) {

        ///......................get data................//

        Constant.Receipt_txn = 3;


        meter_no = this.getArguments().getString("clientmeterno");
        user_name = this.getArguments().getString("customername");



        //..........initialisation objects id................//
        username = (TextView) v.findViewById(R.id.username);
        meternumber = (TextView) v.findViewById(R.id.meternumber);

        amount = (EditText) v.findViewById(R.id.amount);
        Customer_number = (EditText) v.findViewById(R.id.mobile_number);
        ammount_confirm1 = (Button) v.findViewById(R.id.confirm_ammount);
        agentpin = (EditText) v.findViewById(R.id.pin);

        //................set details.......................//
        username.setText("Customer Number :" + " " + user_name);
        meternumber.setText("Meter Number :" + " " + meter_no);
        //................click action on objects...............//
        ammount_confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //............................hide the keyboard...............................//

                try {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                if (amount.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getActivity().getText(R.string.amountreq).toString(), "fail");

                } else if (amount.getText().toString().length() < 3) {
                    Util.showAlertDialog(getActivity(), "Amount" + " " + getActivity().getText(R.string.range).toString(), "fail");

                } else if (Customer_number.getText().toString().equals("")) {
                    Util.showAlertDialog(getActivity(), getText(R.string.mobilenumberreq).toString(), "fail");

                } else if (Customer_number.getText().toString().length() < 9) {
                    Util.showAlertDialog(getActivity(), getText(R.string.mobilenumberreq).toString(), "fail");

                } else if (agentpin.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), "Enter Pin", "fail");
                } else if (!agentpin.getText().toString().equals(SharedPrefrences.get_user_pin())) {
                    Util.showAlertDialog(getActivity(), "Enter valid PIN", "fail");
                } else {
                    confirmdiloag(getActivity(), "e_recharge", "Meter Number :-" + " " + meter_no, "Amount:" + " " + amount.getText().toString());
                }


            }
        });

    }

    //..................recharge_electricity.......................//
    public void pre_paid_electricity_bill() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, pay_bill,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");
                                String falsemsg1 = jsonObject.getString("msg");

                                if (success.equalsIgnoreCase("true")) {


                                    Constant.Receipt_txn = 0;



                                    Dialog dialog = Util.showDialog(getActivity(), falsemsg1, "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
//
                                            getActivity().onBackPressed();

//

                                        }
                                    });

                                    ShowDialogClass.hideProgressing();

                                } else {
                                    Constant.Receipt_txn = 0;
                                    if (success.contains("~")) {
                                        falsemsg = success.substring(6);

                                    } else {
                                        falsemsg = jsonObject.getString("msg");
                                    }

                                    Dialog dialog = Util.showDialog(getActivity(), falsemsg, "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {


                                            getActivity().onBackPressed();
                                            dialog.dismiss();

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
                        Constant.Receipt_txn = 0;
                        Dialog dialog = Util.showDialog(getActivity(), "Oops! Time Out, Please try again", "fail");
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
                params.put(Tags.PIN, agentpin.getText().toString());
                params.put(Tags.MeterNumber, meter_no);
                params.put(Tags.AMOUNT, amount.getText().toString());
                params.put(Tags.costumer_number, Customer_number.getText().toString());

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


}
