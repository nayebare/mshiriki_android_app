package com.xpwallet.mobileshiriki.Frangments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xpwallet.mobileshiriki.Activities.MainActivity;
import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.model_class.Get_loan_history;
import com.xpwallet.mobileshiriki.model_class.Get_trans_history;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoanHistory extends WalletFragment {

    private ListView mLv;

    ArrayList<Get_loan_history> get_homeServiceData;
    ListViewAdapter listViewAdapter;
    private JSONObject jsonObject;
    TextView duedate;
    Get_trans_history transhistory;
    LinearLayout duedateLayout;
    String url = AppUrl.BASE_URL + AppUrl.LOAN_DETAILS;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.loanhistry, container, false);
        layoutCount = 1;

        //..................initialisation of objects.................//
        init(rootView);

        return rootView;
    }

    private void init(View rootView) {
        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 2;

        //...................initialisation of objects......................//
        mLv = (ListView) rootView.findViewById(R.id.list_view);
        duedate = (TextView) rootView.findViewById(R.id.duedate);
        duedateLayout = (LinearLayout) rootView.findViewById(R.id.duedateLayout);

        //..............set arraylist and adapter...............//
        get_homeServiceData = new ArrayList<>();
        listViewAdapter = new ListViewAdapter();

        //................hit the api..............................//

        if (checkInternet(getActivity()) == false) {


        } else {
            getGovtServicetDataTask();
        }
    }

    private void getdatedata() {
        for (int i = 0; i < get_homeServiceData.size(); i++) {
            transhistory = new Get_trans_history();
            String date = get_homeServiceData.get(0).getDue_date();
            duedate.setText("Due date of your loan is  :" + " " + date);
            if (get_homeServiceData.get(0).getAmount().contains("-")) {
                duedateLayout.setVisibility(View.GONE);
            } else {
                duedateLayout.setVisibility(View.VISIBLE);
            }

        }


    }


    private void getGovtServicetDataTask() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub

                        if (arg0 != null) {
                            try {
                                jsonObject = new JSONObject(arg0);
                                parseInf0Datadiet(jsonObject);

                                //................hide dialog.....................//
                                ShowDialogClass.hideProgressing();

                            } catch (Exception e) {
                                e.printStackTrace();
                                //................hide dialog.....................//
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

    private void parseInf0Datadiet(JSONObject jsonObject) {
        try {
            String success = jsonObject.getString("success");
            if (success.equals("true")) {

                org.json.JSONArray jsonArray = jsonObject.getJSONArray("loans");
                if (jsonArray.length() == 0) {


                    Dialog dialog = Util.showDialog(getActivity(), getText(R.string.noloanhistory).toString(), "fail");
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Intent i = new Intent(getActivity(), MainActivity.class);
                            getActivity().startActivity(i);
                            getActivity().finish();
                        }
                    });
                } else {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        Get_loan_history getHomeServiceData = new Get_loan_history();
                        getHomeServiceData.setId(jsonObject1.getString("id"));
                        getHomeServiceData.setUser_id(jsonObject1.getString("user_id"));
                        getHomeServiceData.setAcc_type(jsonObject1.getString("acc_type"));
                        getHomeServiceData.setCurrency(jsonObject1.getString("currency"));
                        getHomeServiceData.setAmount(jsonObject1.getString("amount"));
                        getHomeServiceData.setBalance(jsonObject1.getString("balance"));
                        getHomeServiceData.setCreated_at(jsonObject1.getString("created_at"));
                        getHomeServiceData.setDue_date(jsonObject1.getString("due_date"));
                        get_homeServiceData.add(getHomeServiceData);
                        //................hide progress bar..............//
                        ShowDialogClass.hideProgressing();

                        getdatedata();
                    }
                    mLv.setAdapter(listViewAdapter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return get_homeServiceData.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getActivity().getLayoutInflater().inflate(R.layout.loan_history_item, parent, false);
            TextView trans_date = (TextView) convertView.findViewById(R.id.loan_date);
            TextView trans_id = (TextView) convertView.findViewById(R.id.loan_id);
            TextView trans_amount = (TextView) convertView.findViewById(R.id.loan_amount);
            TextView trans_loan = (TextView) convertView.findViewById(R.id.loann_loan);


            trans_date.setText(get_homeServiceData.get(position).getCreated_at().substring(0, 16).replace('T', ' '));
            if (get_homeServiceData.get(position).getAmount().contains("-")) {
                trans_amount.setTextColor(getResources().getColor(R.color.txncreditamount));
                trans_loan.setTextColor(getResources().getColor(R.color.txncreditamount));
                trans_id.setText("Credit Payment");


            } else {

                trans_amount.setTextColor(getResources().getColor(R.color.txndebitamount));
                trans_loan.setTextColor(getResources().getColor(R.color.txndebitamount));
                trans_id.setText("Service Credit");
//
            }
            trans_amount.setText(Util.getamountdecimal(get_homeServiceData.get(position).getAmount()));
            trans_loan.setText(Util.getamountdecimal(get_homeServiceData.get(position).getBalance()));




            return convertView;
        }


    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
