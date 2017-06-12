package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@zzmb
public class zzpy {
    public static void m25e(String str) {
        if (zzai(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzai(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzai(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void zzb(String str, Throwable th) {
        if (zzai(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzbc(String str) {
        if (zzai(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zzbd(String str) {
        if (zzai(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzbe(String str) {
        if (zzai(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (zzai(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }
}
