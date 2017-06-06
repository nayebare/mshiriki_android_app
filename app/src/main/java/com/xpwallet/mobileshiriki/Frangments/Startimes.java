package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;

import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.adapter.SpinerAdapter;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;
import com.xpwallet.mobileshiriki.util.Util;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Startimes extends WalletFragment {
    RadioGroup radioGroup;
    SpinerAdapter spinerAdapter,spinerdthAdapter;
    private TextView price;
    private String[] priceDttList;
    private ArrayList<String> listpriceDttList = new ArrayList<>();
    private String[] priceDthList;
    private ArrayList<String> listpriceDthList = new ArrayList<>();
    MyCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutCount = 0;
        View v = inflater.inflate(R.layout.startimes, container, false);

        //................initialisation ........................//
        init(v);




        return v;
    }

     private  void init(View v){

         //........set countdown...........................//
         countDownTimer = new MyCountDownTimer();
         countDownTimer.countDownTimer.start();

         //....................set the value for backpress.....................//
         Constant.Fragement_state = 1;
         Constant.Main_ser_account_state = 1;

         //..........................intialisation the objects...................//
         radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
         price = (TextView) v.findViewById(R.id.price);
         priceDttList = getActivity().getResources().getStringArray(R.array.Dtt);

         //...................actions on objects.....................//
         for (int i = 0; i < priceDttList.length; i++) {
             listpriceDttList.add(priceDttList[i]);
         }

         spinerAdapter = new SpinerAdapter(getActivity(), listpriceDttList,-1);

         priceDthList = getActivity().getResources().getStringArray(R.array.Dth);

         for (int i = 0; i < priceDthList.length; i++) {
             listpriceDthList.add(priceDthList[i]);
         }

         spinerdthAdapter = new SpinerAdapter(getActivity(), listpriceDthList,-1);

         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 switch (checkedId) {
                     case R.id.radioButton:
                         setDttPrice();
                         break;
                     case R.id.radioButton2:
                         setDthPrice();
                         break;
                 }
             }
         });

     }
    private void setDthPrice() {
        Dialog dialog = Util.showListDialog(getActivity(), spinerdthAdapter, null, getText(R.string.Select_Bonquet).toString());
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                String priceVAl=null;
                if (Util.price != null)
                    priceVAl = "Price of: " + Util.price.substring(Util.price.indexOf("(") + 1, Util.price.indexOf(")"));
                price.setText(priceVAl);
            }
        });
    }

    private void setDttPrice() {
        Dialog dialog = Util.showListDialog(getActivity(), spinerAdapter, null,getText(R.string.Select_Bonquet).toString());
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                String priceVAl=null;
                if (Util.price != null)
                    priceVAl = "Price of: " + Util.price.substring(Util.price.indexOf("(") + 1, Util.price.indexOf(")"));
                price.setText(priceVAl);
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
