package com.xpwallet.mobileshiriki.Frangments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class Canal extends WalletFragment {
    TextView price, pricevalue;
    LinearLayout pricee;
    private String[] priceList;
    private ArrayList<String> listpriceList = new ArrayList<>();
    SpinerAdapter spinerAdapter;
    MyCountDownTimer countDownTimer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.canal, container, false);

        //......................initialisation..................//
        init(v);

        return v;
    }

    private void init(View v) {


        //....................set the value for backpress.....................//
        Constant.Fragement_state = 1;
        Constant.Main_ser_account_state = 1;

        //.................set the id of objects........................//
        pricee = (LinearLayout) v.findViewById(R.id.pricee);
        pricevalue = (TextView) v.findViewById(R.id.pricevalue);
        price = (TextView) v.findViewById(R.id.textView);

        priceList = getActivity().getResources().getStringArray(R.array.canal_item);
        for (int i = 0; i < priceList.length; i++) {
            listpriceList.add(priceList[i]);
        }
        spinerAdapter = new SpinerAdapter(getActivity(), listpriceList, -1);

        //.............click action on objects......................//

        pricee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = Util.showListDialog(getActivity(), spinerAdapter, pricevalue, getText(R.string.Select_Bonquet).toString());
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        String priceVAl = null;
                        if (Util.price != null)
                            priceVAl = "Price of: " + Util.price.substring(Util.price.indexOf("(") + 1, Util.price.indexOf(")"));
                        price.setText(priceVAl);
                    }
                });
            }
        });


    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }
}
