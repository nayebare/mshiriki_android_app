package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import com.xpwallet.mobileshiriki.model_class.BeanClass;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Internet extends WalletFragment implements View.OnClickListener {

    String internet_recharge = AppUrl.BASE_URL + AppUrl.INTERNET_RECHARGE;
    String internet_duration = AppUrl.BASE_URL + AppUrl.CHECK_DURATION;
    String ineternet_set_amount = AppUrl.BASE_URL + AppUrl.INTERNET_RECHARGE_AMOUNT;

    EditText mobilenumber, agentpin;
    TextView durationvalue, amount;
    RelativeLayout durationlayout;
    Button ok;
    ArrayList<BeanClass> listnetdurationlist;
    MoviesAdapter adapter;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.internet, container, false);

        //....................initialisation of objects.........................//
        init(v);


        return v;
    }


    private void init(View v) {


        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 1;

        //................set the id of objects.....................//
        mobilenumber = (EditText) v.findViewById(R.id.mobilenumber);
        amount = (TextView) v.findViewById(R.id.amount);
        agentpin = (EditText) v.findViewById(R.id.pin);

        durationvalue = (TextView) v.findViewById(R.id.durationvalue);
        durationlayout = (RelativeLayout) v.findViewById(R.id.durationlayout);
        ok = (Button) v.findViewById(R.id.ok);

        //................click action on objects...............//
        ok.setOnClickListener(this);


        durationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInternet(getActivity()) == false) {
                    durationlayout.setEnabled(true);
                    durationlayout.setClickable(true);
                } else {
                    //................hit the service..................//
                    internetduration();

                    durationlayout.setEnabled(false);
                }
            }
        });

    }


    @Override
    public void onClick(View v) {


        if (durationvalue.getText().toString().length() == 0) {
            Util.showAlertDialog(getActivity(), getString(R.string.durationvalue).toString(), "fail");
        } else if (mobilenumber.getText().toString().length() == 0) {
            Util.showAlertDialog(getActivity(), getText(R.string.mobilenumberreq).toString(), "fail");
        } else if (amount.getText().toString().length() == 0) {
            Util.showAlertDialog(getActivity(), getText(R.string.amountreq).toString(), "fail");
        } else if (agentpin.getText().toString().length() == 0) {
            Util.showAlertDialog(getActivity(), "Enter pin", "fail");
        } else if (!agentpin.getText().toString().equals(SharedPrefrences.get_user_pin())) {
            Util.showAlertDialog(getActivity(), "Enter valid PIN", "fail");
        } else {

            String msg1 = mobilenumber.getText().toString();
            String msg = amount.getText().toString();
            String type = "Internet_recharge";


            confirmdiloag(getActivity(), type, "Mobile Number :" + " " + msg1, "Amount :" + " " + msg);
        }


    }


    public void internet_recharge() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, internet_recharge,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");


                                if (success.equals("true")) {

                                    Dialog dialog = Util.showDialog(getActivity(), "Internet code sent successfully", "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            getActivity().onBackPressed();
                                        }
                                    });

                                } else if (success.equals("false")) {
                                    String message = jsonObject.getString("msg");

                                    Dialog dialog = Util.showDialog(getActivity(), message, "fail");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            getActivity().onBackPressed();
                                        }
                                    });

                                }
                                ShowDialogClass.hideProgressing();

                            } catch (Exception e) {
//                                e.printStackTrace();
                                ShowDialogClass.hideProgressing();

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

                                dialog.dismiss();
                                ShowDialogClass.hideProgressing();

                            }
                        });
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                params.put(Tags.Amount, amount.getText().toString());
                params.put(Tags.MOBILE, mobilenumber.getText().toString());
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, agentpin.getText().toString());
                params.put(Tags.Duration, durationvalue.getText().toString());


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


    private void internetduration() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, internet_duration,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {
//
                            listnetdurationlist = new ArrayList<>();
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");
                                if (success.equals("true")) {

                                    durationlayout.setEnabled(true);
                                    JSONArray array = jsonObject.getJSONArray("data");
                                    for (int i = 0; i < array.length(); i++) {
                                        BeanClass beanClass = new BeanClass();

                                        JSONObject object = array.getJSONObject(i);
                                        beanClass.setId(object.getString("id"));
                                        beanClass.setDuration(object.getString("duration"));


                                        listnetdurationlist.add(beanClass);
                                    }

                                } else {
                                    durationlayout.setEnabled(true);

                                }

                                set_adapter();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }

    private void set_adapter() {

        adapter = new MoviesAdapter(getActivity(), listnetdurationlist, "internet");


        show_internet(getActivity(), adapter, durationvalue, "duration value", listnetdurationlist, "Internet");

    }

    //....................adapter........................//
    public static class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

        ArrayList<BeanClass> moviesList;
        int selectedItemposition;
        Context activity;
        String internet;

        public int getSelectedItem(int position) {

            selectedItemposition = position;
            return selectedItemposition;

            // get position

        }

        public int getSelectedItem() {
            return selectedItemposition;

        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView spinerItem;
            ImageView listCheck;

            public ViewHolder(View convertView) {
                super(convertView);
                spinerItem = (TextView) convertView.findViewById(R.id.spinnerItem);
                listCheck = (ImageView) convertView.findViewById(R.id.spinnerCheck);
//                listCheck.setVisibility(View.INVISIBLE);


            }


            @Override
            public void onClick(View v) {

            }
        }


        public MoviesAdapter(Context activity, ArrayList<BeanClass> moviesList, String internet) {
            this.moviesList = moviesList;
            this.activity = activity;
            this.internet = internet;

            if (selectedItemposition == -1) {
                moviesList.remove(0);
                this.selectedItemposition = -1;
            } else {
                this.selectedItemposition = selectedItemposition;
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.spinnerlayout, parent, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            BeanClass movie = moviesList.get(position);
            holder.spinerItem.setText(movie.getDuration() + " " + "Minutes");


            if (selectedItemposition == position) {

            }

        }


        @Override
        public int getItemCount() {
            return moviesList.size();
        }
    }

    public void set_amount(final String amount_adapter) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ineternet_set_amount,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {


                            try {
                                JSONObject jsonObject = new JSONObject(arg0);

                                String success = jsonObject.getString("success");
                                if (success.equals("true")) {
                                    JSONObject json = jsonObject.getJSONObject("data");
                                    amount.setText(json.getString("amount"));


                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());
                params.put(Tags.Duration, amount_adapter);


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
