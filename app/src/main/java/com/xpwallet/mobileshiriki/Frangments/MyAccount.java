package com.xpwallet.mobileshiriki.Frangments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;

import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.util.Util;

public class MyAccount extends WalletFragment {
    LinearLayout commision, requestLoan, loanhistory, transactiohistory, banktowallet, balanceenuiry;
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.myaccount, container, false);


        //...........................initalisation..........................//
        init(rootView);


        return rootView;
    }


    private void init(View rootView) {



        //.....................set state ..........................//
        Constant.Main_ser_account_state = 2;

        //.....................define the id's of objects........................//

        balanceenuiry = (LinearLayout) rootView.findViewById(R.id.balanceenuiry);
        requestLoan = (LinearLayout) rootView.findViewById(R.id.loan);
        commision = (LinearLayout) rootView.findViewById(R.id.commision);
        loanhistory = (LinearLayout) rootView.findViewById(R.id.loanhistory);
        transactiohistory = (LinearLayout) rootView.findViewById(R.id.transactionhistory);
        banktowallet = (LinearLayout) rootView.findViewById(R.id.banktowallet);

        //........................click action on objects......................//
        balanceenuiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new BalanceEnquiry());
            }
        });

        requestLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new RequestLoan());
            }
        });
        commision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new Commissiondata());
            }
        });

        loanhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new LoanHistory());

            }
        });

        transactiohistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runFragment(new TransactionHistory());

            }
        });

        banktowallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showDialog(getActivity(), "Under Development", "fail");

            }
        });

    }


}

