package com.xpwallet.mobileshiriki.Frangments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.model_class.Get_trans_history;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionHistory extends WalletFragment implements View.OnClickListener {
    private ListView mLv;
    ArrayList<Get_trans_history> txnHistory;
    ListTransAdapter listTransAdapter;
    private JSONObject jsonObject;
    ImageView dateshow;
    Dialog listDialog;
    EditText fromdate, todate;

    private DatePickerDialog fromDatePickerDialog, toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Calendar newCalendar;

    private JSONArray jsonArray;
    Date myDate;
    String filename;
    TextView noTxns, accountbal;
    LinearLayout date_picker;

    Date from_date;
    int i = 0;


    String url = AppUrl.BASE_URL + AppUrl.TRANSION_HISTORY;
    String url2 = AppUrl.BASE_URL + AppUrl.TXN_HISTORY_DATES;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.transaction_history, container, false);
        layoutCount = 1;
        //..................initialsation.....................................//
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
        Constant.Receipt_txn = 0;
        //...................initialisation objects....................//
        mLv = (ListView) v.findViewById(R.id.list_view);
        noTxns = (TextView) v.findViewById(R.id.noTxns);
        accountbal = (TextView) v.findViewById(R.id.accountbal);
        dateshow = (ImageView) v.findViewById(R.id.dateshow);
        date_picker = (LinearLayout) v.findViewById(R.id.trxn_dates);

        //......................set calander.........................//
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        newCalendar = Calendar.getInstance();

        //..................click action on objects...................//
        date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questiona_dialog();
            }
        });

        //...................click action on list view...............//
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Bundle bundle = new Bundle();

                bundle.putString("recipt_id", txnHistory.get(position).getId());

                Tnx_Receipt fragobj = new Tnx_Receipt();
                fragobj.setArguments(bundle);
                runFragment(fragobj);


            }
        });



        if (checkInternet(getActivity()) == false) {


        } else {
            //...............get transion history.................//

            getTransactionhist();

        }
    }


    private void questiona_dialog() {
        listDialog = new Dialog(getActivity());
        listDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        listDialog.setContentView(R.layout.calenderdate);
        ImageView cancel = (ImageView) listDialog.findViewById(R.id.cancel);
        fromdate = (EditText) listDialog.findViewById(R.id.etxt_fromdate);
        fromdate.setInputType(InputType.TYPE_NULL);
        fromdate.requestFocus();

        todate = (EditText) listDialog.findViewById(R.id.etxt_todate);
        todate.setInputType(InputType.TYPE_NULL);
        setDateTimeField();


        Button submit = (Button) listDialog.findViewById(R.id.submit);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listDialog.dismiss();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String getFromDate = fromdate.getText().toString();
                    String getToDate = todate.getText().toString();
                    myDate = new Date();
                    filename = dateFormatter.format(myDate);

                    if (Util.compareDates(getFromDate, getToDate)) {
                        adddata1(getFromDate, getToDate);
                    } else {
                        Util.showDialog(getActivity(), "From date should not be greater than To date", "fail");
                    }


                } catch (ParseException e) {
                    e.printStackTrace();
                }


                listDialog.dismiss();
            }


        });

        listDialog.show();

    }

    private void adddata1(final String getFromDate, final String getToDate) throws ParseException {


         //................show progress bar..................................//
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        //................send request..................................//

        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url2, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub


                        txnHistory = new ArrayList<>();
                        //.....................get result...................//

                        if (arg0 != null) {
                            try {
                                jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");
                                if (success.equalsIgnoreCase("true")) {

                                    accountbal.setText("Account Balance :" + " " + Util.getamountdecimal(jsonObject.getString("acc_balance")));
                                    jsonArray = jsonObject.getJSONArray("txn_data");

                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        Get_trans_history transhistory = new Get_trans_history();
                                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                        transhistory.setService_type(jsonObject1.getString("service_type"));
                                        transhistory.setSub_type(jsonObject1.getString("sub_type"));
                                        transhistory.setTxn_date(jsonObject1.getString("txn_date"));
                                        transhistory.setAmount(jsonObject1.getString("amount"));
                                        transhistory.setAccount_id(jsonObject1.getString("account_id"));
                                        transhistory.setDesc(jsonObject1.getString("description"));
                                        transhistory.setParam(jsonObject1.getString("param1"));
                                        transhistory.setId(jsonObject1.getString("id"));
                                        txnHistory.add(transhistory);
//                                        //................hide dialog............//
                                        ShowDialogClass.hideProgressing();

                                    }

                                } else {
                                    Dialog dialog = Util.showDialog(getActivity(), getText(R.string.lblNoTransactionFound).toString(), "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            getActivity().onBackPressed();
                                            dialog.dismiss();
                                        }
                                    });
                                    ShowDialogClass.hideProgressing();

                                }
                                listTransAdapter = new ListTransAdapter();
                                mLv.setAdapter(listTransAdapter);


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
                params.put(Tags.FROM_DATE, getFromDate);
                params.put(Tags.TO_DATE, getToDate);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsObjRequest.setRetryPolicy(policy);
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();


    }

   //..................set from and to date.....................//
    private void setDateTimeField() {
        fromdate.setOnClickListener(this);
        todate.setOnClickListener(this);
        myDate = new Date();
        filename = dateFormatter.format(myDate);
        fromdate.setText(filename);
        todate.setText(filename);

        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromdate.setText(dateFormatter.format(newDate.getTime()));
                from_date = newDate.getTime();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                todate.setText(dateFormatter.format(newDate.getTime()));

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }



    private void getTransactionhist() {


        //..................show progress bar..................//
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        //..................send request..................//
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub

                        txnHistory = new ArrayList<>();

                        //..................get response.................//

                        if (arg0 != null) {
                            try {
                                jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");
                                if (success.equalsIgnoreCase("true")) {

                                    accountbal.setText("Account Balance :" + " " + Util.getamountdecimal(jsonObject.getString("acc_balance")));
                                    jsonArray = jsonObject.getJSONArray("txn_data");

                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        Get_trans_history transhistory = new Get_trans_history();
                                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                        transhistory.setService_type(jsonObject1.getString("service_type"));
                                        transhistory.setSub_type(jsonObject1.getString("sub_type"));
                                        transhistory.setTxn_date(jsonObject1.getString("txn_date"));
                                        transhistory.setAmount(jsonObject1.getString("amount"));
                                        transhistory.setAccount_id(jsonObject1.getString("account_id"));
                                        transhistory.setDesc(jsonObject1.getString("description"));
                                        transhistory.setParam(jsonObject1.getString("param1"));
                                        transhistory.setId(jsonObject1.getString("id"));

                                        txnHistory.add(transhistory);
//                                        //................hide dialog............//
                                        ShowDialogClass.hideProgressing();

                                    }

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
                                listTransAdapter = new ListTransAdapter();
                                mLv.setAdapter(listTransAdapter);


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
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsObjRequest.setRetryPolicy(policy);
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();


    }


    @Override
    public void onClick(View v) {
        if (v == fromdate) {
            fromDatePickerDialog.show();
        } else if (v == todate) {
            toDatePickerDialog.show();
        }
    }




    //......................List adapter class..................//
    class ListTransAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return txnHistory.size();
        }


        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getActivity().getLayoutInflater().inflate(R.layout.transaction_history_item, parent, false);

            //..........................initialisation layout objects................//
            TextView trans_date = (TextView) convertView.findViewById(R.id.trans_date);
            TextView trans_id = (TextView) convertView.findViewById(R.id.trans_id);
            TextView trans_amount = (TextView) convertView.findViewById(R.id.trans_amount);
            TextView trans_provider = (TextView) convertView.findViewById(R.id.trans_provider);
            TextView trans_mobile = (TextView) convertView.findViewById(R.id.trans_mobile);

            String date = txnHistory.get(position).getTxn_date();

            //..................set the objects values..................//

            trans_date.setText(date.substring(0, 16).replace('T', ' '));
            trans_id.setText(txnHistory.get(position).getService_type());

            trans_amount.setText(Util.getamountdecimal(txnHistory.get(position).getAmount()));

            if (txnHistory.get(position).getSub_type().equalsIgnoreCase("ELECTRICITY")) {
                trans_provider.setText("T.N." + " " + txnHistory.get(position).getParam());

            } else {
                trans_provider.setText(txnHistory.get(position).getSub_type());

            }

            if (txnHistory.get(position).getService_type().equals("loan_deposit") || txnHistory.get(position).getSub_type().equals("loan_deposit")) {
                trans_id.setText("Credit Payment");
                trans_provider.setText("Credit Payment");
            } else if (txnHistory.get(position).getService_type().equals("nonpayment_loan") || txnHistory.get(position).getSub_type().equals("nonpayment_loan")) {
                trans_id.setText("Non-Payment Credit");
                trans_provider.setText("Non-Payment Credit");
            }
            else if (txnHistory.get(position).getService_type().equals("nonpayment_penalty") || txnHistory.get(position).getSub_type().equals("nonpayment_penalty")) {
                trans_id.setText("Non-Payment Penalty");
                trans_provider.setText("Non-Payment Penalty");
            }
            else if (txnHistory.get(position).getService_type().equals("commission_tax_deduct") || txnHistory.get(position).getSub_type().equals("commission_tax_deduct")) {
                trans_id.setText("Tax Deduction");
                trans_provider.setText("Tax Deduction");
            }

            else if (txnHistory.get(position).getService_type().equals("cash_deposit") || txnHistory.get(position).getSub_type().equals("cash_deposit")) {

                trans_id.setText("Cash Deposit");
                trans_provider.setText(txnHistory.get(position).getDesc() + " " + "Deposit");
            } else if (txnHistory.get(position).getService_type().equals("loan_request") || txnHistory.get(position).getSub_type().equals("loan_request")) {
                trans_id.setText("Service Credit");
                trans_provider.setText("Service Credit");
            } else if (txnHistory.get(position).getService_type().equals("commission_payment") || txnHistory.get(position).getSub_type().equals("commission_payment")) {
                trans_id.setText("Commission Payment");
                trans_provider.setText("Commission Payment");
            } else if (txnHistory.get(position).getService_type().equals("cash_payment") || txnHistory.get(position).getSub_type().equals("cash_payment")) {
                trans_id.setText("Cash Payment");
                trans_provider.setText("Cash Payment");
            } else if (txnHistory.get(position).getService_type().equals("delay_charge") || txnHistory.get(position).getSub_type().equals("delay_charge")) {
                trans_id.setText("Penalty Deposit");
                trans_provider.setText("Penalty Deposit");
            } else if (txnHistory.get(position).getService_type().equals("MTOP_UP")) {
                trans_id.setText("Airtime");
            }


            if (txnHistory.get(position).getAccount_id().equals("null")) {
                trans_mobile.setVisibility(View.INVISIBLE);
            } else {
                trans_mobile.setText("C.N." + " " + txnHistory.get(position).getAccount_id());
            }

            return convertView;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }

}
