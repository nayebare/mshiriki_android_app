package com.xpwallet.mobileshiriki.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.adapter.SpinerAdapter;
import com.xpwallet.mobileshiriki.commonbasisclasses.ShowDialogClass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Util {
    public static final boolean IS_PRODUCTION = true;
    //    private static SecondLevelCategoryAdp adapter;
    public static ProgressDialog progress;
    Activity activity;

    public static String price = null;

    public static Context context;
    ;

    public static String getText(EditText fieldName) {
        return fieldName.getText().toString().trim();
    }

    public static String customTrim(EditText fieldName) {
        String ss = getText(fieldName).replaceAll(" +", "");
        return ss;
    }

    public static String getSpinnerText(Spinner fieldName) {
        return fieldName.getSelectedItem().toString();
    }

//    static Airtime airtime = new Airtime();
//    static Internet internet = new Internet();

    public static Dialog showDialog(Context context, String message, String responseType) {

        final Dialog alertDialog = new Dialog(context);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//this line MUST BE BEFORE setContentView
        alertDialog.setContentView(R.layout.dialog);
        alertDialog.setCanceledOnTouchOutside(false);
        LinearLayout iconBackground = (LinearLayout) alertDialog.findViewById(R.id.iconbackground);
        ImageView icon = (ImageView) alertDialog.findViewById(R.id.icon);

        Log.e("in", "" + responseType);
        if (responseType.equals("200") || responseType.equals("success")) {
            iconBackground.setBackgroundColor(context.getResources().getColor(R.color.buttonNormal));
            icon.setImageDrawable(context.getResources().getDrawable(R.drawable.dialogcheck));
        }
        TextView text = (TextView) alertDialog.findViewById(R.id.text_dialog);
        text.setText(message);

        Button dialogButton = (Button) alertDialog.findViewById(R.id.btn_dialogOK);
        dialogButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {


                alertDialog.dismiss();
            }
        });

        alertDialog.show();
        return alertDialog;
    }

    public static void sendRequest(Map<String, String> getParams) {
        //common lines
    }


    public static float getfloatValue(String givenString) {
        float returnValue = 0;
        if (givenString == null)
            return returnValue;
        try {
            returnValue = Float.parseFloat(givenString);
        } catch (Exception e) {
        }
        return returnValue;
    }
//public BigDecimal getamountdecimal(BigDecimal amount){
//    BigDecimal value = amount.setScale(2, RoundingMode.HALF_UP);
//    return value;
//}

    public static String getamountdecimal(String amount) {
        BigDecimal xmlvalue = new BigDecimal(amount);
        xmlvalue = xmlvalue.setScale(2, RoundingMode.HALF_DOWN);
        String str1 = xmlvalue.toString();
        return str1;
    }

    public static boolean compareDates(String psDate1, String psDate2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse((psDate1));
        Date date2 = dateFormat.parse((psDate2));
        if (date1.after(date2)) {
            return false;
        } else
            return true;

    }


    public static int getDaysBetween(String objDate1, String objDate2) {
        Date date1 = new Date(objDate1);
        Date date2 = new Date(objDate2);

        dateFloor(date1);
        dateFloor(date2);

        double miliSecDiff = date1.getTime() - date2.getTime();
        if (miliSecDiff == 0)
            return 0;

        Double daysBetween = miliSecDiff / 86400000;
        return daysBetween.intValue();
    }

    public static void dateFloor(Date givenDate) {
        givenDate.setHours(0);
        givenDate.setMinutes(0);
        givenDate.setSeconds(0);
    }


    public static Dialog showAlertDialog(Context context, String message, String responseType) {
        showDialog(context, message, responseType);
        ShowDialogClass.hideProgressing();
        return null;
    }


    public static String amountsubString(String string) {
        string.substring(string.indexOf("."));
        return string;

    }


    public static Dialog showListDialog(final Context context, final SpinerAdapter adapter, final TextView uiControl, String title) {
        price = null;
        final Dialog alertDialog = new Dialog(context);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//this line MUST BE BEFORE setContentView
        alertDialog.setContentView(R.layout.dialog_list_xml);
        alertDialog.setCanceledOnTouchOutside(false);
        final RelativeLayout listHead = (RelativeLayout) alertDialog.findViewById(R.id.listHead);
        TextView confirmTitle = (TextView) alertDialog.findViewById(R.id.confirmTitle);
        listHead.setBackgroundColor(context.getResources().getColor(R.color.lastTxnbackground));
        confirmTitle.setText(title);
        final ListView listView = (ListView) alertDialog.findViewById(R.id.dialogList);
        listView.setAdapter(adapter);

        ImageView cancel = (ImageView) alertDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        if (adapter.getSelectedItem() >= 0)
            price = listView.getItemAtPosition(adapter.getSelectedItem()).toString();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                price = listView.getItemAtPosition(position).toString();

                TextView listItem = (TextView) view.findViewById(R.id.spinnerItem);
                if (uiControl != null)
                    uiControl.setText(listItem.getText().toString());
                adapter.setSelectedItem(position);
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
        return alertDialog;
    }


    public static void showProgressing(Context context, String title, String message) {
        try {
            progress = new ProgressDialog(context);
            progress.setCanceledOnTouchOutside(false);
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
            progress.hide();
        } catch (Exception e) {

        }
    }

    public static void set_user_image(Context context, String url, ImageView view) {
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.user)
                .crossFade()
                .into(view);

    }

    public  static void ssl(){
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
        {
            public java.security.cert.X509Certificate[] getAcceptedIssuers()
            {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType)
            {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType)
            {
            }
        } };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");

            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
