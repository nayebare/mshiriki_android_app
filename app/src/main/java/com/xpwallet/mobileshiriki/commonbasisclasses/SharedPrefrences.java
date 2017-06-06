package com.xpwallet.mobileshiriki.commonbasisclasses;

import android.content.Context;
import android.content.SharedPreferences;

import com.xpwallet.mobileshiriki.util.Tags;

/**
 * Created by arjun on 18/01/2017.
 */

public class SharedPrefrences {
    static SharedPreferences mPref;
    SharedPreferences.Editor editor;
    public static String My_Prefrences = "Prefrences";

    public SharedPrefrences(Context mContext) {
        mPref = mContext.getSharedPreferences(My_Prefrences, Context.MODE_PRIVATE);
        editor = mPref.edit();
    }

    public static void set_notification_token(String token) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(Tags.Token, token)
        ;
        editor.commit();
        editor.apply();
    }


    public static String gettoken() {
        return mPref.getString(Tags.Token, "");
    }


    public static void set_updated_time(String time) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(Tags.Count, time);
        editor.commit();
    }


    public static String get__updated_time() {
        return mPref.getString(Tags.UPDATED_AT, "");
    }

    public static void set_user_id(String Id, String login_phone, String login_pin) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(Tags.PHONE, login_phone);
        editor.putString(Tags.PIN, login_pin);
        editor.putString(Tags.USERID, Id);
        editor.commit();
    }

    public static void set_user_details(String login_first_name, String login_last_name, String login_image, String created_time) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(Tags.FIRST_NAME, login_first_name);
        editor.putString(Tags.LAST_NAME, login_last_name);
        editor.putString(Tags.LOGIN_IMAGE, login_image);
        editor.putString(Tags.CREATEDDATE, created_time);

        editor.commit();
    }

    public static String get_user_first_name() {
        return mPref.getString(Tags.FIRST_NAME, "");
    }

    public static String get_user_last_name() {
        return mPref.getString(Tags.LAST_NAME, "");
    }


    public static String get_user_image() {
        return mPref.getString(Tags.LOGIN_IMAGE, "");
    }

    public static String get_user_created_time() {
        return mPref.getString(Tags.CREATEDDATE, "");
    }


    public static String get_user_id() {
        return mPref.getString(Tags.USERID, "");
    }

    public static String get_user_phone() {
        return mPref.getString(Tags.PHONE, "");
    }

    public static String get_user_pin() {
        return mPref.getString(Tags.PIN, "");
    }

    public static void set_imei_number(String imei) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(Tags.IMEI_Number, imei);

        editor.commit();
    }

    public static String get_imei_number() {
        return mPref.getString(Tags.IMEI_Number, "");
    }

    public static void remover_user_is(String login_user_id) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.remove(login_user_id).commit();

    }

}
