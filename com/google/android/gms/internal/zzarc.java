package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.zzf;

final class zzarc {
    static boolean zzbp(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            if (zzf.zzav(context).zzb(context.getPackageManager(), packageInfo)) {
                return true;
            }
            String str = "InstantAppsApi";
            String str2 = "Incorrect signature for package ";
            String valueOf = String.valueOf(packageInfo.packageName);
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
