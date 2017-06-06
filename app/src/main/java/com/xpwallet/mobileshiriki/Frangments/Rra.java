package com.xpwallet.mobileshiriki.Frangments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpwallet.mobileshiriki.Common.MyCountDownTimer;
import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.commonbasisclasses.Constant;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rra extends WalletFragment {
    MyCountDownTimer countDownTimer;
    public Rra() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Constant.Main_ser_account_state = 1;
        Constant.Fragement_state = 1;
        return inflater.inflate(R.layout.rra, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        countDownTimer.countDownTimer.cancel();

    }

}
