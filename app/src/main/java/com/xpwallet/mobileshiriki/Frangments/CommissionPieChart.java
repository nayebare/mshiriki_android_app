package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.xpwallet.mobileshiriki.Frangments.WalletFragment.checkInternet;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommissionPieChart extends Fragment {
    static PieChart pieChart;




    int i;
    String url = AppUrl.BASE_URL + AppUrl.GET_COMMISSION_ACC_DATE;
    String get_FROM_date, get_to_date, name;
    int amount_sum;
    LinearLayout chart1, chart2;

    public static final int[] MY_COLORS = {
            Color.rgb(84, 124, 101), Color.rgb(64, 64, 64), Color.rgb(153, 19, 0),
            Color.rgb(38, 40, 53), Color.rgb(215, 60, 55)
    };

    ArrayList<CommissionListItem> questions;
    MyCountDownTimer countDownTimer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_commission_pie_chart, container, false);

        //................intialisation objects..............//
        init(v);


        return v;
    }

    private void init(View v) {

        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();



        Constant.Receipt_txn = 2;

//
//        //..............get values from  bundle...............//
        get_FROM_date = this.getArguments().getString("get_from_date");
        get_to_date = this.getArguments().getString("get_to_date");

        //.........intialisation the id of objects............//

        pieChart = (PieChart) v.findViewById(R.id.chart1);
        chart1 = (LinearLayout) v.findViewById(R.id.chartmain);
        chart2 = (LinearLayout) v.findViewById(R.id.text_chart);

        //...................call commission list................//
        if (checkInternet(getActivity()) == false) {


        } else {
            getCommissionHist(get_FROM_date, get_to_date);
        }


    }

    private void getCommissionHist(final String get_FROM_date, final String get_to_date) {

        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);
        final StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub


                        questions = new ArrayList<CommissionListItem>();
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");
                                JSONArray ammount;
                                if (success.equalsIgnoreCase("true")) {

                                    JSONObject json = jsonObject.getJSONObject("data");

                                    ammount = json.getJSONArray("sum_amount");
                                    JSONArray ammount1 = json.getJSONArray("company_name");

                                    String index_value= String.valueOf(json.getJSONArray("sum_amount").get(0));
                                    if (index_value.equalsIgnoreCase("0")) {
                                        chart1.setVisibility(View.GONE);
                                        chart2.setVisibility(View.VISIBLE);

                                    } else {
                                        chart1.setVisibility(View.VISIBLE);
                                        chart2.setVisibility(View.GONE);

                                        get_total(ammount, ammount1);

                                    }

                                }


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
                params.put(Tags.FROM_DATE, get_FROM_date);
                params.put(Tags.TO_DATE, get_to_date);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();

    }

    private void get_total(JSONArray ammount, JSONArray ammount1) {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < ammount.length(); i++) {
            try {
                amount_sum = ammount.getInt(i);

                if (amount_sum != 0) {
                    entries.add(new Entry(amount_sum, i));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        ArrayList<String> labels = new ArrayList<String>();


        for (int i = 0; i < ammount1.length(); i++) {
            try {
                name = ammount1.getString(i);
                if (ammount.getInt(i) != 0) {
                    labels.add(name);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added My Own colors
        for (int c : MY_COLORS)
            colors.add(c);


        dataSet.setColors(colors);

        //  create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(labels, dataSet);

        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);

        // undo all highlights
        pieChart.highlightValues(null);

        // refresh/update pie chart
        pieChart.invalidate();

        // animate piechart
        pieChart.animateXY(1400, 1400);


        // Legends to show on bottom of the graph
        Legend l = pieChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(7);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}


