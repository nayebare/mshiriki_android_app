package com.xpwallet.mobileshiriki.Frangments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;
import com.xpwallet.mobileshiriki.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends WalletFragment implements View.OnClickListener {
    Button services, myaccount;
    TextView username, date;
    Fragment fragment;
    CircleImageView ci;
    String user_details = AppUrl.BASE_URL + AppUrl.USER_DETAILS;
    String Login_User_Phone, Login_User_First_name, Login_User_Last_Name, Login_User_Image, Login_User_Created_time, Login_User_Updated_time;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);


//
        //...................initialisation .................//
        init(rootView);

        return rootView;

    }

    private void init(View rootView) {
        //........set countdown...........................//
        countDownTimer = new MyCountDownTimer();
        countDownTimer.countDownTimer.start();

       //.............Replace fragment.............//


        FragmentManager fragmentManager = getFragmentManager();
        if (Constant.Main_ser_account_state == 1) {
            Services sevice_fragment = new Services();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, sevice_fragment).commit();
            Constant.Main_ser_account_state = 0;
        } else if (Constant.Main_ser_account_state == 2) {
            MyAccount sevice_fragment1 = new MyAccount();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, sevice_fragment1).commit();
            Constant.Main_ser_account_state = 0;

        } else {
            Services sevice_fragment = new Services();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, sevice_fragment).commit();
            Constant.Main_ser_account_state = 0;
        }

        services = (Button) rootView.findViewById(R.id.service);
        myaccount = (Button) rootView.findViewById(R.id.myaccount);
        username = (TextView) rootView.findViewById(R.id.username);
        date = (TextView) rootView.findViewById(R.id.date);
        ci = (CircleImageView) rootView.findViewById(R.id.profile_image);

        //....................get user details.................//


        if (!SharedPrefrences.get__updated_time().equals(Login_User_Updated_time)) {
            ;

            get_profile();
        } else {
        }


        //................................set the user_details............//
        username.setText(SharedPrefrences.get_user_first_name() + " " + SharedPrefrences.get_user_last_name());
        date.setText("Member since" + " " + SharedPrefrences.get_user_created_time());


        Util.set_user_image(getActivity(), SharedPrefrences.get_user_image(), ci);


        //.....................click action on objects..............//
        //.....................click action on objects..............//
        services.setOnClickListener(this);
        myaccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.service) {
            ;

            if (!(Constant.Main_ser_account_state == 1)) {
                animfragment(new Services(), R.anim.push_right_in, R.anim.push_right_out);

            } else {
            }
        } else if (v.getId() == R.id.myaccount) {
            if (!(Constant.Main_ser_account_state == 2)) {
                animfragment(new MyAccount(), R.anim.push_right_in, R.anim.push_right_out);

            } else {
            }
        }
    }


    private void get_profile() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, user_details,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null) {

                            try {
                                JSONObject jsonObject = new JSONObject(arg0);


                                String success = jsonObject.getString("success");
                                if (success.equalsIgnoreCase("true")) {
                                    JSONObject Details = jsonObject.getJSONObject("details");
                                    Login_User_First_name = Details.getString("first_name");
                                    Login_User_Last_Name = Details.getString("last_name");
                                    Login_User_Phone = Details.getString("phone");
                                    Login_User_Image = Details.getString("image");
                                    Login_User_Created_time = Details.getString("created_at");

                                    Login_User_Updated_time = Details.getString("updated_at");
                                    SharedPrefrences.set_updated_time(Login_User_Updated_time);


                                    SharedPrefrences.set_user_details(Login_User_First_name, Login_User_Last_Name, Login_User_Image, Login_User_Created_time);


                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//
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

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}

