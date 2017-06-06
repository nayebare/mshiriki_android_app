package com.xpwallet.mobileshiriki.commonbasisclasses;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by arjun on 18/01/2017.
 */

public class ShowDialogClass {

    private Context context;
    public static ProgressDialog progress;


    public static void showProgressing(Context context, String title, String message) {
            try {
                progress = new ProgressDialog(context);
                progress.setCanceledOnTouchOutside(false);
               progress.setCancelable(false);
                progress.setTitle(title);
                if (message != null) {
                    progress.setMessage(message);
                }
                progress.show();
            } catch (Exception e) {

            }
        }

    public static void hideProgressing() {
        try {


            if(progress!=null)

                progress.dismiss();
        } catch (Exception e) {

        }
    }
}
