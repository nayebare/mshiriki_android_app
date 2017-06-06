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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.Activities.MainActivity;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestLoan extends WalletFragment {
    public String requestloan_url = AppUrl.BASE_URL + AppUrl.REQUEST_LOAN;
    RadioGroup radioGroup;
    RadioButton five, ten, twenty, fifty, onelakh;
    Button confirm;
    TextView accountbal, usercredit, loanoutstanding, username;
    String account_balance, user_credit, loan_balance;
    CircleImageView ci;
    String url = AppUrl.BASE_URL + AppUrl.GET_ACCOUNT_INFO;
    MyCountDownTimer countDownTimer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutCount = 1;
        View v = inflater.inflate(R.layout.request_loan, container, false);

        //....................intialisation............................//
        init(v);


        return v;

    }

    private void init(View v) {
        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();


        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;

        Constant.Main_ser_account_state = 2;


        //.......................intialisation of objects........................//
        username = (TextView) v.findViewById(R.id.username);
        radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
        confirm = (Button) v.findViewById(R.id.confirm);
        five = (RadioButton) v.findViewById(R.id.five);
        ten = (RadioButton) v.findViewById(R.id.ten);
        twenty = (RadioButton) v.findViewById(R.id.twenty);
        fifty = (RadioButton) v.findViewById(R.id.fifty);
        onelakh = (RadioButton) v.findViewById(R.id.onelikh);
        accountbal = (TextView) v.findViewById(R.id.accountbal);
        usercredit = (TextView) v.findViewById(R.id.usercredit);
        loanoutstanding = (TextView) v.findViewById(R.id.loanoutstanding);
        ci = (CircleImageView) v.findViewById(R.id.userImage);

        username.setText(SharedPrefrences.get_user_first_name() + " " + SharedPrefrences.get_user_last_name());


        //....................actions on objects................//

        Util.set_user_image(getActivity(), SharedPrefrences.get_user_image(), ci);


        //....................click action on objects.......................//

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkInternet(getActivity()) == false) {
                    confirm.setEnabled(true);
                    confirm.setClickable(true);

                } else if (radioGroup.getCheckedRadioButtonId() == -1) {


                    Dialog dialog = Util.showDialog(getActivity(), getText(R.string.selectAmount).toString(), "fail");
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            dialog.dismiss();
                        }
                    });


                } else {
                    request_for_loan();
                }
            }

        });


        //....................hit the api............................//

        if (checkInternet(getActivity()) == false) {


        } else {
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
                                    JSONObject json = jsonObject.getJSONObject("details");
                                    account_balance = json.getString("account_balance");
                                    user_credit = json.getString("user_credit_limit");
                                    loan_balance = json.getString("loan_balance");

                                    compareCreditlimit(user_credit);
                                    accountbal.setText(Util.getamountdecimal(account_balance));
                                    usercredit.setText(user_credit.substring(0, user_credit.indexOf(".")));
                                    loanoutstanding.setText(Util.getamountdecimal(loan_balance));

                                    //........................hide dialog...................//
                                    ShowDialogClass.hideProgressing();

                                } else if (success.equals("false")) {
                                    String error = jsonObject.getString("msg");

//
                                    Dialog dialog = Util.showAlertDialog(getActivity(), error, "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            Intent i = new Intent(getActivity(), MainActivity.class);
                                            getActivity().startActivity(i);
                                            getActivity().finish();
                                        }
                                    });
                                    //........................hide dialog...................//
                                    ShowDialogClass.hideProgressing();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                //........................hide dialog...................//
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
                params.put(Tags.USERID, SharedPrefrences.get_user_id());

                return params;
            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();

    }

    private void compareCreditlimit(String user_credit) {
        if (user_credit.equals("5000.0")) {
            five.setEnabled(true);
            ten.setEnabled(false);
            twenty.setEnabled(false);
            fifty.setEnabled(false);
            onelakh.setEnabled(false);
        } else if (user_credit.equals("10000.0")) {
            ten.setEnabled(true);
            twenty.setEnabled(false);
            fifty.setEnabled(false);
            onelakh.setEnabled(false);

        } else if (user_credit.equals("20000.0")) {
            twenty.setEnabled(true);
            fifty.setEnabled(false);
            onelakh.setEnabled(false);

        }
        if (user_credit.equals("50000.0")) {
            fifty.setEnabled(true);
            onelakh.setEnabled(false);

        }
        if (user_credit.equals("100000.0")) {
            onelakh.setEnabled(true);

        }

    }

    private String getAmount() {
        String amount1 = null;
        int selectedId = radioGroup.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.five:
                amount1 = five.getText().toString();
                break;
            case R.id.ten:
                amount1 = ten.getText().toString();
                break;
            case R.id.twenty:
                amount1 = twenty.getText().toString();
                break;
            case R.id.fifty:
                amount1 = fifty.getText().toString();
                break;
            case R.id.onelikh:
                amount1 = onelakh.getText().toString();
                break;
        }

        return amount1;
    }

    private void request_for_loan() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, requestloan_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                String msg = jsonObject.getString("msg");

                                if (success.equalsIgnoreCase("true")) {
                                    Dialog dialog = Util.showDialog(getActivity(), msg, "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            Intent i = new Intent(getActivity(), MainActivity.class);
                                            startActivity(i);
                                            getActivity().finish();
//                                            dialog.dismiss();

                                        }
                                    });

                                    five.setEnabled(false);
                                    ten.setEnabled(false);
                                    twenty.setEnabled(false);
                                    fifty.setEnabled(false);
                                    onelakh.setEnabled(false);
                                    confirm.setEnabled(false);
                                    //........................hide dialog...................//
                                    ShowDialogClass.hideProgressing();

                                } else if (success.equals("false")) {


                                    Dialog dialog = Util.showDialog(getActivity(), msg, "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            Intent i = new Intent(getActivity(), MainActivity.class);
                                            startActivity(i);
                                            getActivity().finish();
//                                            dialog.dismiss();

                                        }
                                    });
                                    five.setEnabled(false);
                                    ten.setEnabled(false);
                                    twenty.setEnabled(false);
                                    fifty.setEnabled(false);
                                    onelakh.setEnabled(false);
                                    confirm.setEnabled(false);

                                    //........................hide dialog...................//
                                    ShowDialogClass.hideProgressing();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
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
//                                            Intent i = new Intent(LoginScreen.this, MainActivity.class);
//                                            startActivity(i);
                                request_for_loan();
                                dialog.dismiss();
                            }
                        });
                        ShowDialogClass.hideProgressing();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());

                params.put(Tags.Amount, getAmount());
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


