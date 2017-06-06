package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
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
import com.xpwallet.mobileshiriki.model_class.NotificationDetail;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Contants;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.xpwallet.mobileshiriki.Frangments.WalletFragment.checkInternet;

/**
 * A simple {@link Fragment} subclass.
 */
public class Notification extends Fragment {
    ListView list_view;
    private JSONObject jsonObject;
    ArrayList<NotificationDetail> get_homeServiceData;
    ListViewAdapter listViewAdapter;
    String url = AppUrl.BASE_URL + AppUrl.GET_NOTIFICATION;
    String url1 = AppUrl.BASE_URL + AppUrl.READ_NOTIFICATION;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.notification, container, false);

        Contants.Click_count = 1;

        //...................initialisation........................//
        init(v);

        return v;
    }

    private void init(View v) {

        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;


        //......................initialisation the objects.................//
        list_view = (ListView) v.findViewById(R.id.list_view);


        //...............hit the api..................//
        if (checkInternet(getActivity()) == false) {

        } else {

            getNotificationDetail();

        }

    }

    private void getNotificationDetail() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub
                        get_homeServiceData = new ArrayList<>();

                        if (arg0 != null) {
                            try {
                                jsonObject = new JSONObject(arg0);
                                try {
                                    String success = jsonObject.getString("success");
                                    if (success.equals("true")) {

                                        org.json.JSONArray jsonArray = jsonObject.getJSONArray("notifications");

                                        for (int i = 0; i < jsonArray.length(); i++) {

                                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                            NotificationDetail notificationDetail = new NotificationDetail();
                                            notificationDetail.setNotification_content(jsonObject1.getString("notification_content"));
                                            notificationDetail.setCreated_at(jsonObject1.getString("created_at"));
                                            notificationDetail.setNotification_id(jsonObject1.getString("id"));
                                            get_homeServiceData.add(notificationDetail);

                                            ShowDialogClass.hideProgressing();
                                        }

                                        set_read_status(get_homeServiceData.get(0).getNotification_id());

                                    } else {
                                        Dialog dialog = Util.showDialog(getActivity(), "No Notification Found", "fail");
                                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                            @Override
                                            public void onDismiss(DialogInterface dialog) {
                                                Intent i = new Intent(getActivity(), MainActivity.class);
                                                getActivity().startActivity(i);
                                                getActivity().finish();
                                            }
                                        });
                                    }

                                    //....................set adapter.........................///
                                    setadapter();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    ShowDialogClass.hideProgressing();

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

                                ShowDialogClass.hideProgressing();

                                dialog.dismiss();
                            }
                        });
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
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(35000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsObjRequest);

    }

    private void setadapter() {
        listViewAdapter = new ListViewAdapter();
        list_view.setAdapter(listViewAdapter);


    }


    private void set_read_status(final String notification_id) {
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url1, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub

                        if (arg0 != null) {
                            try {
                                jsonObject = new JSONObject(arg0);


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

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());
                params.put(Tags.NOTIFICATION_ID, notification_id);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();


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
            convertView = getActivity().getLayoutInflater().inflate(R.layout.notificationdata, parent, false);
            TextView notification_content = (TextView) convertView.findViewById(R.id.notification_content);
            TextView notificationdate = (TextView) convertView.findViewById(R.id.notificationdate);

            notification_content.setText(get_homeServiceData.get(position).getNotification_content());
            notificationdate.setText(get_homeServiceData.get(position).getCreated_at().substring(0, 16).replace('T', ' '));


//            list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    final Dialog notidialog = new Dialog(getActivity());
//                    notidialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                    notidialog.setContentView(R.layout.notificationdialog);
//                    notidialog.setCanceledOnTouchOutside(false);
//
//                    TextView textnotification = (TextView) notidialog.findViewById(R.id.textnotification);
//                    textnotification.setText(get_homeServiceData.get(position).getNotification_content());
//
//                    Button ok = (Button) notidialog.findViewById(R.id.ok);
//                    ok.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent i = new Intent(getActivity(), MainActivity.class);
//                            startActivity(i);
//
//                        }
//                    });
//
////                    Button cancel = (Button) notidialog.findViewById(R.id.cancel);
////                    cancel.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View v) {
////                            notidialog.dismiss();
////                        }
////                    });
//                    notidialog.show();
//                }
//            });
//
//
            return convertView;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }

}
