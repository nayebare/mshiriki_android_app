package com.xpwallet.mobileshiriki.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.xpwallet.mobileshiriki.Common.DrawerMenu;
import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.Frangments.Airtime;
import com.xpwallet.mobileshiriki.Frangments.Canal;
import com.xpwallet.mobileshiriki.Frangments.ChangePin;
import com.xpwallet.mobileshiriki.Frangments.Commissiondata;
import com.xpwallet.mobileshiriki.Frangments.Dstv;
import com.xpwallet.mobileshiriki.Frangments.Electricity;
import com.xpwallet.mobileshiriki.Frangments.Home;
import com.xpwallet.mobileshiriki.Frangments.Internet;
import com.xpwallet.mobileshiriki.Frangments.Notification;
import com.xpwallet.mobileshiriki.Frangments.Rra;
import com.xpwallet.mobileshiriki.Frangments.Startimes;
import com.xpwallet.mobileshiriki.Frangments.TransactionHistory;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.adapter.RecyclerItemClickListener;
import com.xpwallet.mobileshiriki.adapter.MyAdapter;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.commonbasisclasses.SharedPrefrences;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.util.AppUrl;
import com.xpwallet.mobileshiriki.util.Tags;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static com.xpwallet.mobileshiriki.Frangments.WalletFragment.checkInternet;

import static com.xpwallet.mobileshiriki.firebaseclasses.MyFirebaseMessagingService.Notification_id;

public class MainActivity extends BaseActivity {
    private static final int FUNCTION_HOME = 3;
    private Toolbar toolbar;
    List<DrawerMenu> drMenuRegistered = new ArrayList<DrawerMenu>(40);
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    ImageView notification, menuicon;
    Dialog listDialog;
    TextView actionbar_notifcation_textview;

    RelativeLayout count_back;
    String msg, success;
    String url = AppUrl.BASE_URL + AppUrl.GET_LOAN_STATUS;
    JSONObject jsonObject;

    public static Activity context;

    public static Timer timer;

    private Question_A question_a; ///for adapter
    int image[] = {R.drawable.changepin, R.drawable.translate, R.drawable.update, R.drawable.logout};
    String array_question_a[] = {"Change Pin / Hindura ijambobanga", "System Update / Kongerera sisiteme ubushobozi", "Logout / Sohoka"};

    int delay = 1000; // delay for 1 sec.
    int period = 2000; // repeat every 10 sec.
    boolean exit = false;
    private FirebaseAnalytics mFirebaseAnalytics;
    Dialog notidialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        question_a = new Question_A();

        context = this;



        //.....................Intialisation counter..............//
        MyCountDownTimer.setContext(MainActivity.this);


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
        FirebaseCrash.log("Activity created");

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //.................set the toolbar................//
        setToolbar();


        //......................initialisation of objects..................//
        init();


    }

    private void init() {


        //...................replace fragment...............//
        FragmentManager fragmentManager = getFragmentManager();
        Home home_fragment = new Home();
        fragmentManager.beginTransaction().replace(R.id.contentPanel, home_fragment).addToBackStack(null).commit();


        //......................hit loan payment conformation.................//
        if (checkInternet(context) == false) {

        } else {

            get_loan_conform();//                    internetduration();

        }

        //...............initialisation the  objects.......................//
        count_back = (RelativeLayout) findViewById(R.id.text_count);
        actionbar_notifcation_textview = (TextView) findViewById(R.id.actionbar_notifcation_textview);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        menuicon = (ImageView) findViewById(R.id.menuicon);
        notification = (ImageView) findViewById(R.id.notification);


        //....................set timer for receive notification alert................//
        get_timer();
        //................click actions on objects.......................//

        menuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                questiona_dialog();
            }
        });


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_back.setVisibility(View.GONE);

                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.cancel(Notification_id);

                Constant.Notification_count2 = 0;
                runFragment(new Notification());

            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };


        //.......................set the gestures.......................//


        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Drawer.closeDrawers();
                        if (position == 1) {

                            runFragment(new Home());
                        } else if (position == 2) {
                            runFragment(new Airtime());
                        } else if (position == 3) {
                            runFragment(new Electricity());
                        } else if (position == 4) {
                            runFragment(new Dstv());
                        } else if (position == 5) {
                            runFragment(new Canal());
                        } else if (position == 6) {
                            runFragment(new Startimes());
                        } else if (position == 7) {
                            runFragment(new Rra());
                        } else if (position == 8) {
                            runFragment(new Internet());
                        } else
                            Log.e(">>", "other" + position);
                    }
                })
        );

    }

    private void greetingMsg() {
        SharedPreferences sharedPref = getSharedPreferences("GamePrefs", 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDate = sdf.format(new Date());
        if (sharedPref.getString("LAST_LAUNCH_DATE", "nodate").contains(currentDate)) {

        } else {
            //..................display good morning alert..........//
            displayalert();
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("LAST_LAUNCH_DATE", currentDate);
            editor.commit();
        }

    }

    private void displayalert() {

        final Dialog alertdiaog = new Dialog(MainActivity.this);
        alertdiaog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertdiaog.setContentView(R.layout.confirmationdialog);
        LinearLayout confirmlayout = (LinearLayout) alertdiaog.findViewById(R.id.confirmlayout);
        TextView confirmtext = (TextView) alertdiaog.findViewById(R.id.confirmtext);
        TextView text_dialog = (TextView) alertdiaog.findViewById(R.id.text_dialog);

        if (success.equals("true")) {
            confirmlayout.setVisibility(View.VISIBLE);
            confirmtext.setText(msg);


        } else {
            confirmlayout.setVisibility(View.GONE);
        }

        text_dialog.setText("Good Morning!");
        Button btn_dialogOK = (Button) alertdiaog.findViewById(R.id.btn_dialogOK);
        btn_dialogOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdiaog.dismiss();
            }
        });
        alertdiaog.show();


    }


    private void initDrawerMenu() {
        drMenuRegistered.add(new DrawerMenu(R.drawable.home, "Home", FUNCTION_HOME));
        drMenuRegistered.add(new DrawerMenu(R.drawable.airtime, "Airtime", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.electricity, "Electricity ", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.startimes, "StarTimes", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.canal, "Canal", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.dishtv, "DSTV", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.rra, "RRA", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.internet, "Internet", null));
        drMenuRegistered.add(new DrawerMenu(R.drawable.commission, "Internet", null));
    }

    @Override
    public void onResume() {
        super.onResume();


        drMenuRegistered.clear();

        initDrawerMenu();

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        String firstName = "xpwallet";
        String lastName = "tech";
        String NAME = (firstName == null && lastName == null) ? "" : firstName + " " + lastName;

        mAdapter = new MyAdapter(MainActivity.this, drMenuRegistered, NAME, null);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void runFragment(Fragment fragment) {
        try {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contentPanel, fragment).commit();
        } catch (Exception e) {
        }
    }

    public void onBackPressed() {


        ShowDialogClass.hideProgressing();

        if (Drawer.isDrawerOpen(Gravity.LEFT)) {
            Drawer.closeDrawer(Gravity.LEFT);
        } else if (Constant.Receipt_txn == 1) {
            Constant.Receipt_txn = 0;
            runFragment(new TransactionHistory());
        } else if (Constant.Receipt_txn == 2) {
            Constant.Receipt_txn = 0;
            runFragment(new Commissiondata());
        } else if (Constant.Receipt_txn == 3) {
            Constant.Receipt_txn = 0;
            runFragment(new Electricity());
        } else if (Constant.Fragement_state == 1) {
            Constant.Fragement_state = 0;

            runFragment(new Home());

        } else {
            if (exit) {

                //...............finish the current screen and remove the saved data...............//

                SharedPrefrences.remover_user_is(SharedPrefrences.get_user_id());

                Intent i = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(i);

                ((Activity) MainActivity.this).finish();


            } else {
                SharedPrefrences.remover_user_is(SharedPrefrences.get_user_id());

                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;


            }

        }
    }
    //...................menu elements adapter class...............//

    class Question_A extends BaseAdapter {
        @Override
        public int getCount() {
            return array_question_a.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.menu_items, viewGroup, false);

            //..............initilisation the objects....................//
            TextView spinerItem = (TextView) view.findViewById(R.id.menuItem);
            ImageView listCheck = (ImageView) view.findViewById(R.id.menuicon);
            spinerItem.setText(array_question_a[i]);
            listCheck.setImageResource(image[i]);
            return view;
        }

    }


    //.....................menu item alert..................//
    private void questiona_dialog() {
        listDialog = new Dialog(this);
        listDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        listDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.menulistdialog, null, false);
        listDialog.setContentView(v);
        listDialog.setCancelable(true);
        ImageView cancel = (ImageView) listDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listDialog.dismiss();
            }
        });

        final ListView dialog_ListView = (ListView) listDialog.findViewById(R.id.dialogList);

        dialog_ListView.setAdapter(question_a);

        listDialog.show();
        dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        runFragment(new ChangePin());
                        break;
                    case 2:

                        SharedPreferences sp = getSharedPreferences("lstatus", MODE_PRIVATE);
                        SharedPreferences.Editor ed = sp.edit();
                        ed.putString("login", "logged out");
                        ed.commit();


                        SharedPreferences sp1 = getSharedPreferences("Prefrences", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed1 = sp1.edit();
                        ed1.remove("token");
                        ed1.remove("user_id");
                        ed1.remove(Tags.Success);

                        ed1.commit();

                        timer.cancel();
                        timer.purge();

                        Intent i5 = new Intent(MainActivity.this, LoginScreen.class);
                        startActivity(i5);
                        finish();

                        break;
                }
                listDialog.dismiss();
            }
        });
    }


    private void get_loan_conform() {
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        // TODO Auto-generated method stub
                        if (arg0 != null) {
                            try {
                                jsonObject = new JSONObject(arg0);
                                success = jsonObject.getString("success");
                                JSONObject j2 = jsonObject.getJSONObject("details");
                                msg = j2.getString("msg");
                                greetingMsg();


                            } catch (Exception e) {
                                e.printStackTrace();
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

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);
        requestQueue.getCache().clear();

    }


    public void get_timer() {
        timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {


                TimerMethod();


            }
        }, delay, period);


    }

    private void TimerMethod() {

        this.runOnUiThread(Timer_Tick);
    }

    private Runnable Timer_Tick = new Runnable() {
        public void run() {



            if (Constant.Notification_count2 == 0) {
                count_back.setVisibility(View.GONE);
            } else {
                if (Constant.Notification_login_id.equals(SharedPrefrences.get_user_id())) {
                    count_back.setVisibility(View.VISIBLE);
                    actionbar_notifcation_textview.setText(String.valueOf(Constant.Notification_count2));
                }


            }

            if (!(Constant.Notification_count1 == 0)) {


                if (Constant.Notification_login_id.equals(SharedPrefrences.get_user_id())) {

                    //..................handle notification alert......................//
                    get_count();

                }

            } else {
            }


        }
    };

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setNavigationIcon(R.drawable.menu);
    }


    private void get_count() {


        Constant.Notification_count1 = 0;


        notidialog = new Dialog(MainActivity.this);
        notidialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        notidialog.setContentView(R.layout.notificationdialog);
        notidialog.setCanceledOnTouchOutside(false);

        TextView textnotification = (TextView) notidialog.findViewById(R.id.textnotification);
        textnotification.setText(Constant.Notification_title);

        Button ok = (Button) notidialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.cancel(Notification_id);

                SharedPreferences sp = getSharedPreferences("Prefrences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                if (Constant.Notification_type.equalsIgnoreCase("Deactivate Device")) {
//                    sp.getString(Tags.USERID,"");
                    editor.remove(Tags.USERID).commit();


                    timer.cancel();
                    timer.purge();


                    Intent i = new Intent(getApplicationContext(), LoginScreen.class);
                    startActivity(i);
                    finish();
                    notidialog.dismiss();

                } else if (Constant.Notification_type.equalsIgnoreCase("suspended account")) {

                    manager.cancel(Notification_id);

                    editor.remove(Tags.USERID).commit();


                    notidialog.dismiss();

                } else if (Constant.Notification_type.equalsIgnoreCase("deleted account")) {
                    editor.remove(Tags.USERID).commit();
                    timer.cancel();
                    timer.purge();

                    Intent i = new Intent(getApplicationContext(), LoginScreen.class);
                    startActivity(i);
                    finish();
                    notidialog.dismiss();

                } else {
                    if (notidialog != null && notidialog.isShowing()) {
                        notidialog.dismiss();
                    }
                }
            }
        });
        if (!isFinishing()) {
            notidialog.show();
        }


    }

    @Override
    protected void onDestroy() {
        try {
            if (notidialog != null && notidialog.isShowing()) {
                ShowDialogClass.hideProgressing();
                notidialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }
}