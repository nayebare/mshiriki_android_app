package com.xpwallet.mobileshiriki.Frangments;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.adapter.RecyclerItemClickListener;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;
import com.xpwallet.mobileshiriki.commonbasisclasses.StringsClass;
import com.xpwallet.mobileshiriki.model_class.BeanClass;
import com.xpwallet.mobileshiriki.util.ConnectionDetector;
import com.xpwallet.mobileshiriki.util.Util;

import java.util.ArrayList;

import static com.xpwallet.mobileshiriki.Common.MyCountDownTimer.countDownTimer;

/**
 * Created by Desktop on 9/17/2016.
 */
public abstract class WalletFragment extends Fragment {
    public static int layoutCount = 0;
    protected Context ctx = null;
    AsyncTaskRunner runner;
    private boolean myAsyncTaskIsRunning = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ctx = getActivity();
        ShowDialogClass.showProgressing(ctx, StringsClass.loading, StringsClass.plswait);

        Util.ssl();


        if (savedInstanceState != null) {
            myAsyncTaskIsRunning = savedInstanceState.getBoolean("myAsyncTaskIsRunning");
        }
        if (myAsyncTaskIsRunning) {
//            runner = new runner();
            runner.execute();
        }


        checkInternet(getActivity());
        return null;
    }

    protected void sendRequest() {
        try {
            runner = new AsyncTaskRunner();
            runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Exception e) {
        }
    }

    public void runFragment(Fragment fragment) {
        try {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contentPanel, fragment).commit();
        } catch (Exception e) {
        }
    }

    protected void animfragment(Fragment fragment, int enterAnim, int exitAnim) {
        if (fragment != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();

            ft.setCustomAnimations(enterAnim, exitAnim);
            ft.replace(R.id.content_frame, fragment, "fragment");
            ft.commit();
        } else {
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("myAsyncTaskIsRunning", myAsyncTaskIsRunning);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (runner != null) runner.cancel(true);
        runner = null;

    }

    protected class AsyncTaskRunner extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            try {
                ShowDialogClass.showProgressing(ctx, StringsClass.loading, StringsClass.plswait);

//                Util.showProgressing(getActivity(), getText(R.string.loading).toString(), getText(R.string.plsWait).toString());
                super.onPreExecute();
            } catch (Exception e) {
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                duringRequest();
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            try {
                Util.hideProgressing();
                afterRequest();
                super.onPostExecute(aVoid);
            } catch (Exception e) {
            }
        }
    }


    protected void duringRequest() {

    }

    protected void afterRequest() {

    }

    //
//    @Override
//    protected void onStop() {
//        // notice here that I keep a reference to the task being executed as a class member:
//        if (this.myTask != null && this.myTask.getStatus() == Status.RUNNING) this.myTask.cancel(true);
//        super.onStop();
//    }
    public static boolean checkInternet(Activity ctx) {
        ConnectionDetector cd = new ConnectionDetector(ctx);
        if (cd.isConnectingToInternet() == false) {
            Util.showAlertDialog(ctx, ctx.getText(R.string.msgNoInternetConnection).toString(), "fail");
            return false;
        }
        return true;
    }


    public Dialog confirmdiloag(final Context context, final String type, String message, String amount) {


        final Dialog confirmdialog = new Dialog(context);
        confirmdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        confirmdialog.setContentView(R.layout.informationconfirm);
        confirmdialog.setCanceledOnTouchOutside(false);

        TextView phone = (TextView) confirmdialog.findViewById(R.id.phone);
        phone.setText(message);

        TextView amount1 = (TextView) confirmdialog.findViewById(R.id.amount);
        amount1.setText(amount);

        final Button ok = (Button) confirmdialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok.setEnabled(false);
                if (type.equals("Airtime")) {
                    getAirtime();
                    confirmdialog.dismiss();
                } else if (type.equals("e_recharge")) {
                    pre_paid_electricity_bill();
                    confirmdialog.dismiss();
                } else if (type.equals("Internet_recharge")) {
                    internet_recharge();
                    confirmdialog.dismiss();
                } else if (type.equals("Dishtv")) {
                    recharge_dstv();
                    confirmdialog.dismiss();
                }


            }
        });

        Button cancel = (Button) confirmdialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmdialog.dismiss();
            }
        });
        confirmdialog.show();


        return confirmdialog;


    }


    public Dialog show_internet(final Context context, final Internet.MoviesAdapter adapter, final TextView uiControl, String title, final ArrayList<BeanClass> listnetdurationlist, final String internet) {


        final Dialog alertDialog = new Dialog(context);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//this line MUST BE BEFORE setContentView
        alertDialog.setContentView(R.layout.listdialog);
        alertDialog.setCanceledOnTouchOutside(false);
        final RelativeLayout listHead = (RelativeLayout) alertDialog.findViewById(R.id.listHead);
        TextView confirmTitle = (TextView) alertDialog.findViewById(R.id.confirmTitle);
        listHead.setBackgroundColor(context.getResources().getColor(R.color.lastTxnbackground));
        confirmTitle.setText(title);


        final RecyclerView recycler_view = (RecyclerView) alertDialog.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
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
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {


                        if (uiControl != null)

                            if (internet.equalsIgnoreCase("Airtime")) {
                                uiControl.setText(listnetdurationlist.get(position).getOperator_list());

                            } else {
                                uiControl.setText(listnetdurationlist.get(position).getDuration() + " " + "Minutes");

                            }


                        adapter.getSelectedItem(position);

                        if (internet.equalsIgnoreCase("Airtime")) {
                            alertDialog.dismiss();


                        } else {
                            set_amount(listnetdurationlist.get(position).getDuration());

                        }


                        alertDialog.dismiss();
                    }
                })
        );

        alertDialog.show();
        return alertDialog;
    }


    public void internet_recharge() {
    }

    public void getAirtime() {
    }

    public void pre_paid_electricity_bill() {
    }


    public void set_amount(String operator_list) {
    }

    public void recharge_dstv() {
    }

    public void get_operator_list() {

    }


}
