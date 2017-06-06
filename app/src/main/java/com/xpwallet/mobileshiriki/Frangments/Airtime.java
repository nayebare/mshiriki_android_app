package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
import com.xpwallet.mobileshiriki.adapter.RecyclerItemClickListener;
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
public class Airtime extends WalletFragment {

    String mtopup_url = AppUrl.BASE_URL + AppUrl.MOBILE_RECHARGE;
    String get_operator_list = AppUrl.BASE_URL + AppUrl.OPERATOR_LIST;

    TextView operatorvalue;
    ArrayList<BeanClass> listoperatorlist;
    RelativeLayout operator;
    Button confirm;
    EditText mobilenumber, amount, pin;
    static int count = 0;

    MyCountDownTimer countDownTimer;

    String success;
    Airtime_operator_list adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.airtime, container, false);

       //..............get the operator list..........//
        get_operator_list();

        //..............Intialisation the counter..........//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

        //..................initialisation..................//
        init(v);


        return v;

    }

    private void init(View v) {


        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 1;
        //.................set id  of all objects...................//
        operatorvalue = (TextView) v.findViewById(R.id.operatorvalue);
        confirm = (Button) v.findViewById(R.id.confirm);
        mobilenumber = (EditText) v.findViewById(R.id.mobilenumber);
        amount = (EditText) v.findViewById(R.id.amount);
        pin = (EditText) v.findViewById(R.id.pin);
        operator = (RelativeLayout) v.findViewById(R.id.operator);


        //...................click action on objects......................//

        operator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //......................get operator list........................//

                get_operator_list();
                operator.setEnabled(false);
            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operatorvalue.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.operatorreqd).toString(), "fail");
                } else if (mobilenumber.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.mobilenumberreq).toString(), "fail");
                } else if (mobilenumber.getText().toString().length() < 9) {
                    Util.showAlertDialog(getActivity(), getText(R.string.mobilenumberreq).toString(), "fail");

                } else if (amount.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.amountreq).toString(), "fail");
                } else if (amount.getText().toString().length() < 3) {
                    Util.showAlertDialog(getActivity(), getText(R.string.range3).toString(), "fail");
                } else if (pin.getText().toString().length() == 0) {
                    Util.showAlertDialog(getActivity(), getText(R.string.txnPinRequired).toString(), "fail");
                } else if (!pin.getText().toString().equals(SharedPrefrences.get_user_pin())) {
                    Util.showAlertDialog(getActivity(), "Enter valid PIN", "fail");
                } else {


                    String msg1 = mobilenumber.getText().toString();
                    String msg = amount.getText().toString();
                    String type = "Airtime";
                    //.................set coonformatiomn dialog and then hit airtime api after conformation.............//
                    confirmdiloag(getActivity(), type, "Mobile Number :" + " " + msg1, "Amount :" + " " + msg);

                }


            }
        });
    }

    public void getAirtime() {
        confirm.setEnabled(false);
        //...................show progress bar.........................//
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        //...................send request........................//
        StringRequest stringRequest = new StringRequest(Request.Method.POST, mtopup_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {

                        //................get result...................//
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                String success = jsonObject.getString("success");

                                if (success.equals("true")) {
                                    String msg = jsonObject.getString("msg");
                                    String msg_detail = jsonObject.getString("msg_detail");
                                    operator.setEnabled(false);

                                    Dialog dialog = Util.showDialog(getActivity(), msg, "success");
                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
//
                                            getActivity().onBackPressed();


                                        }
                                    });
                                    operator.setClickable(false);
                                    mobilenumber.setEnabled(false);
                                    pin.setEnabled(false);
                                    amount.setEnabled(false);
                                    confirm.setEnabled(false);


                                    ShowDialogClass.hideProgressing();

                                } else if (success.contains("false")) {

                                    operator.setClickable(true);
                                    mobilenumber.setEnabled(true);
                                    pin.setEnabled(true);
                                    amount.setEnabled(true);
                                    confirm.setEnabled(true);

                                    String msg;
                                    if (success.contains("~")) {
                                        msg = success.substring(6);

                                    } else {
                                        msg = jsonObject.getString("msg");
                                    }


                                    Dialog dialog = Util.showAlertDialog(getActivity(), msg, "fail");

                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            dialog.dismiss();
                                        }
                                    });


                                }

                                ShowDialogClass.hideProgressing();

                            } catch (Exception e) {
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
                            }
                        });
                        ShowDialogClass.hideProgressing();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                params.put(Tags.OPERATOR, operatorvalue.getText().toString());
                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.MOBILE, mobilenumber.getText().toString());
                params.put(Tags.PIN, pin.getText().toString());
                params.put(Tags.Amount, amount.getText().toString());
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

    public void get_operator_list() {
        ShowDialogClass.showProgressing(getActivity(), StringsClass.loading, StringsClass.plswait);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, get_operator_list,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {


                        listoperatorlist = new ArrayList<>();
                        if (arg0 != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(arg0);
                                success = jsonObject.getString("success");

                                if (success.equals("true")) {
                                    operator.setEnabled(true);


                                    JSONArray array = jsonObject.getJSONArray("msg");

                                    for (int i = 0; i < array.length(); i++) {
                                        BeanClass beanClass = new BeanClass();
                                        JSONObject jsonObject1 = array.getJSONObject(i);
                                        beanClass.setOperator_list(jsonObject1.getString("category_name"));
                                        listoperatorlist.add(beanClass);

                                    }
                                    ShowDialogClass.hideProgressing();


                                } else {
                                    ShowDialogClass.hideProgressing();

                                    operator.setEnabled(true);

                                    Dialog dialog = Util.showAlertDialog(getActivity(), "no details found", "fail");

                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            dialog.dismiss();
                                        }
                                    });
                                }

                                //.............set adapter................//
                                set_adapter();
                                ShowDialogClass.hideProgressing();


                            } catch (Exception e) {
                                e.printStackTrace();
//                                ShowDialogClass.hideProgressing();

                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ShowDialogClass.hideProgressing();

                        Dialog dialog = Util.showDialog(getActivity(), "Oops! Time Out, Please try again", "fail");
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {

                                dialog.dismiss();
                            }
                        });
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put(Tags.PHONE, SharedPrefrences.get_user_phone());
                params.put(Tags.PIN, SharedPrefrences.get_user_pin());
                params.put(Tags.Get_txn_cat, Tags.Airtime);

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }


    private void set_adapter() {
        adapter = new Airtime_operator_list(getActivity(), listoperatorlist, "Airtime");



        final Dialog alertDialog = new Dialog(getActivity());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//this line MUST BE BEFORE setContentView
        alertDialog.setContentView(R.layout.listdialog);
        alertDialog.setCanceledOnTouchOutside(false);
        final RelativeLayout listHead = (RelativeLayout) alertDialog.findViewById(R.id.listHead);
        TextView confirmTitle = (TextView) alertDialog.findViewById(R.id.confirmTitle);
        listHead.setBackgroundColor(getActivity().getResources().getColor(R.color.lastTxnbackground));
        confirmTitle.setText("Select Mobile Operator");


        final RecyclerView recycler_view = (RecyclerView) alertDialog.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(mLayoutManager);

        recycler_view.setAdapter(adapter);

        ImageView cancel = (ImageView) alertDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


        recycler_view.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {


                        if (operatorvalue != null)

//                            if (internet.equalsIgnoreCase("Airtime")) {
//                                Log.e("dfdfhdgyd", "");
                            operatorvalue.setText(listoperatorlist.get(position).getOperator_list());


                        adapter.getSelectedItem(position);


                        alertDialog.dismiss();
                    }
                })
        );

        alertDialog.show();

    }


    //....................adapter........................//
    public class Airtime_operator_list extends RecyclerView.Adapter<Airtime_operator_list.ViewHolder> {

        private ArrayList<BeanClass> moviesList;
        int selectedItemposition;
        Context activity;
        String internet;

        public int getSelectedItem(int position) {

            selectedItemposition = position;
            return selectedItemposition;

            // get position

        }


        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView spinerItem;
            ImageView listCheck;

            public ViewHolder(View convertView) {
                super(convertView);
                spinerItem = (TextView) convertView.findViewById(R.id.spinnerItem);
                listCheck = (ImageView) convertView.findViewById(R.id.spinnerCheck);


            }


            @Override
            public void onClick(View v) {


            }
        }


        public Airtime_operator_list(Context activity, ArrayList<BeanClass> moviesList, String internet) {
            this.moviesList = moviesList;
            this.activity = activity;
            this.internet = internet;

            if (selectedItemposition == -1) {
                moviesList.remove(0);
                this.selectedItemposition = -1;
            } else {
            }
        }

        @Override
        public Airtime_operator_list.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.spinnerlayout, parent, false);

            return new Airtime_operator_list.ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            BeanClass movie = moviesList.get(position);

            holder.spinerItem.setText(movie.getOperator_list());


            if (selectedItemposition == position) {

            }
        }


        @Override
        public int getItemCount() {
            return moviesList.size();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
