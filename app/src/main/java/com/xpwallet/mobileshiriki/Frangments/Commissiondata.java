package com.xpwallet.mobileshiriki.Frangments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.xpwallet.mobileshiriki.model_class.CommissionListItem;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Desktop on 12-Jan-17.
 */
public class Commissiondata extends WalletFragment implements View.OnClickListener {
    private ListView mLv;
    private JSONObject jsonObject, jsonObject1;
    private JSONArray jsonArray;

    private SimpleDateFormat dateFormatter;
    Date myDate;
    private DatePickerDialog fromDatePickerDialog, toDatePickerDialog;
    Calendar newCalendar;

    TextView servicetype;
    ImageView dateshow;
    Dialog listDialog;
    EditText fromdate, todate;


    ArrayList<CommissionListItem> commissiondata, commhis;
    ListCommAdapter listCommAdapter;

    String fromda, todat, getFromDate, getToDate,  filename;
    String url = AppUrl.BASE_URL + AppUrl.COMISSION_DETAILS;


    View rootView;
    MyCountDownTimer countDownTimer;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.graphdata, container, false);

        //...................initialisation ...................//
        init();

        return rootView;

    }

    private void init() {
        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 2;
        Constant.Receipt_txn=0;

        //..............set the id of all objects............//
        mLv = (ListView) rootView.findViewById(R.id.list_view);
        servicetype = (TextView) rootView.findViewById(R.id.servicetype);
        dateshow = (ImageView) rootView.findViewById(R.id.dateshow);


        commhis = new ArrayList<>();
        listCommAdapter = new ListCommAdapter();
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        newCalendar = Calendar.getInstance();


        //...................click action on objects.................//
        dateshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questiona_dialog();
            }
        });
        if (checkInternet(getActivity()) == false) {
        }
        else {
            getCommissionHist();
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

        //.............click action on dialog objects..............//

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

                    getFromDate = fromdate.getText().toString();
                    getToDate = todate.getText().toString();
                    myDate = new Date();
                    filename = dateFormatter.format(myDate);

                    if (Util.compareDates(getFromDate, getToDate)) {
                        adddatainpiechart(getFromDate, getToDate);
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
                fromda = dateFormatter.format(newDate.getTime());
                fromdate.setText(fromda);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                todat = dateFormatter.format(newDate.getTime());
                todate.setText(todat);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }


    private void adddatainpiechart(String getFromDate, String getToDate) {


        //..............go to next screen................//
        Bundle bundle = new Bundle();
        bundle.putString("get_from_date", getFromDate);
        bundle.putString("get_to_date", getToDate);
        CommissionPieChart fragobj = new CommissionPieChart();
        fragobj.setArguments(bundle);
        runFragment(fragobj);


    }


    private void gettodayCommissiondata() {
        commissiondata = new ArrayList<>();
        myDate = new Date();
        filename = dateFormatter.format(myDate);
        for (int i = 0; i < commhis.size(); i++) {
            try {
                String date = commhis.get(i).getTxn_date();
                if (Util.compareDates(filename, date.substring(0, date.indexOf("T"))) && Util.compareDates(date.substring(0, date.indexOf("T")), filename)) {
                    CommissionListItem commissionListItem = new CommissionListItem();
                    commissionListItem.setSub_type(commhis.get(i).getSub_type());
                    commissionListItem.setPost_balance(commhis.get(i).getPost_balance());
                    commissionListItem.setAmount(commhis.get(i).getAmount());
                    commissionListItem.setService_type(commhis.get(i).getService_type());

                    commissiondata.add(commissionListItem);
                    ShowDialogClass.hideProgressing();

                    get_total();


                }
            } catch (ParseException e) {
                e.printStackTrace();
                ShowDialogClass.hideProgressing();

            }


        }
        if (commissiondata.size() == 0) {


            Dialog dialog = Util.showDialog(getActivity(), getString(R.string.nocommission), "fail");

            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
         dialog.dismiss();
                }
            });


        }

        mLv.setAdapter(listCommAdapter);


    }

    private void get_total() {


        double sum = 0;

        for (int i = 0; i < commissiondata.size(); i++) {
            if (commissiondata.get(i).getService_type().equals("MTOP_UP")) {
                sum += Double.parseDouble(commissiondata.get(i).getPost_balance());

            } else if (commissiondata.get(i).getService_type().equals("ELECTRICITY")) {
                sum += Double.parseDouble(commissiondata.get(i).getPost_balance());

            }


        }

    }

    private void getCommissionHist() {

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
                                if (jsonObject1.getString("service_type").equals("MTOP_UP"))
                                    servicetype.setText("Airtime");

                                ShowDialogClass.hideProgressing();

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

    private void parseInf0Datadiet(JSONObject jsonObject) {
        commissiondata = new ArrayList<>();

        try {
            String success = jsonObject.getString("success");
            if (success.equals("true")) {
                jsonArray = jsonObject.getJSONArray("commission");
                for (int i = 0; i < jsonArray.length(); i++) {
                    CommissionListItem commissionListItem = new CommissionListItem();

                    jsonObject1 = jsonArray.getJSONObject(i);
                    commissionListItem.setTxn_date(jsonObject1.getString("txn_date"));
                    commissionListItem.setService_type(jsonObject1.getString("service_type"));
                    commissionListItem.setSub_type(jsonObject1.getString("sub_type"));
                    commissionListItem.setPost_balance(jsonObject1.getString("post_balance"));
                    commissionListItem.setAmount(jsonObject1.getString("amount"));
                    commissiondata.add(commissionListItem);
                    ShowDialogClass.hideProgressing();
                }

                commhis = commissiondata;
                gettodayCommissiondata();
                mLv.setAdapter(listCommAdapter);

            } else if (success.equals("false")) {
                String commission = jsonObject.getString("commission");


                Dialog dialog = Util.showDialog(getActivity(), commission, "fail");

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                      dialog.dismiss();
                    }
                });
                ShowDialogClass.hideProgressing();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == fromdate) {
            fromDatePickerDialog.show();
        } else if (v == todate) {
            toDatePickerDialog.show();
        }
    }

    class ListCommAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return commissiondata.size();
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
            convertView = getActivity().getLayoutInflater().inflate(R.layout.graph_history_item, parent, false);
            TextView subtype = (TextView) convertView.findViewById(R.id.subtype);
            TextView amount = (TextView) convertView.findViewById(R.id.amount);
            TextView commision = (TextView) convertView.findViewById(R.id.commision);

            subtype.setText(commissiondata.get(position).getSub_type());
            amount.setText(Util.getamountdecimal(commissiondata.get(position).getAmount()));
            commision.setText(Util.getamountdecimal(commissiondata.get(position).getPost_balance()));


            return convertView;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
