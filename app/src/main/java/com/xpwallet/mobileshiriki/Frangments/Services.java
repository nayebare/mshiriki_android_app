package com.xpwallet.mobileshiriki.Frangments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;

import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;

public class Services extends WalletFragment {
    LinearLayout airtime, electricity, dstv, rra, canal, startimes, internet;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.services, container, false);


        //.................initialisation....................//
        init(rootView);

        return rootView;
    }

    private void init(View rootView) {

        //.....................set state ..........................//
        Constant.Main_ser_account_state = 1;


        //.......................set id of objects..........................//
        airtime = (LinearLayout) rootView.findViewById(R.id.airtime);
        electricity = (LinearLayout) rootView.findViewById(R.id.electricity);
        dstv = (LinearLayout) rootView.findViewById(R.id.dstv);
        canal = (LinearLayout) rootView.findViewById(R.id.canal);
        rra = (LinearLayout) rootView.findViewById(R.id.rra);
        startimes = (LinearLayout) rootView.findViewById(R.id.startimes);
        internet = (LinearLayout) rootView.findViewById(R.id.internet);

        //...................click action on objects.............................//
        airtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_operator_list();
                runFragment(new Airtime());


            }
        });

        electricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Electricity());
            }
        });

        dstv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Dstv());
            }
        });
        canal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Canal());
            }
        });
        rra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Rra());
            }
        });
        startimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Startimes());
            }
        });
        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Internet());

            }
        });

    }

}

//
