package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzi;

public class zzanl {
    private static int zzaTU;

    static {
        zzaTU = -1;
    }

    private static boolean zzBS() {
        return !TextUtils.isEmpty(Build.PRODUCT) && Build.PRODUCT.startsWith("glass_");
    }

    public static boolean zzaW(Context context) {
        return zzi.zzaI(context);
    }

    public static int zzaX(Context context) {
        if (zzaTU == -1) {
            if (zzaW(context)) {
                zzaTU = 3;
            } else if (zzba(context)) {
                zzaTU = 0;
            } else if (zzaY(context)) {
                zzaTU = 2;
            } else if (zzBS()) {
                zzaTU = 6;
            } else {
                zzaTU = 1;
            }
        }
        return zzaTU;
    }

    private static boolean zzaY(Context context) {
        return zzi.zzb(context.getResources()) && !zzaZ(context);
    }

    private static boolean zzaZ(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Throwable e) {
            Log.wtf("Fitness", "Unable to determine type of device, assuming phone.", e);
            return true;
        }
    }

    private static boolean zzba(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback");
    }
}
