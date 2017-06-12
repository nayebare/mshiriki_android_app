package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

public class zze {
    public static String zza(WakeLock wakeLock, String str) {
        Object obj;
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            obj = BuildConfig.FLAVOR;
        }
        String valueOf2 = String.valueOf(obj);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static String zzdB(String str) {
        return GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(str) ? null : str;
    }

    static List<String> zzz(List<String> list) {
        return (list != null && list.size() == 1 && GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(list.get(0))) ? null : list;
    }
}
