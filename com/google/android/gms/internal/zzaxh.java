package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.UserManager;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzs;

public class zzaxh {
    private final Context mContext;
    private volatile Boolean zzbBP;

    public zzaxh(Context context) {
        this.zzbBP = null;
        this.mContext = context;
    }

    public static boolean zzbw(Context context) {
        return zzs.zzyI() ? zzbx(context) : false;
    }

    @TargetApi(21)
    private static boolean zzbx(Context context) {
        UserManager userManager = (UserManager) context.getSystemService("user");
        return userManager != null && userManager.hasUserRestriction("ensure_verify_apps");
    }

    public static boolean zzby(Context context) {
        return zze(context, "package_verifier_enable", 1) == 1;
    }

    @TargetApi(17)
    private static int zze(Context context, String str, int i) {
        return zzs.zzyD() ? Global.getInt(context.getContentResolver(), str, i) : Secure.getInt(context.getContentResolver(), str, i);
    }

    public boolean zzNZ() {
        return zzOb() ? zzOa() : zzOa() && zzby(this.mContext);
    }

    public boolean zzOa() {
        if (zzOb()) {
            return (zzs.zzyI() && zzbw(this.mContext)) || Secure.getInt(this.mContext.getContentResolver(), "package_verifier_user_consent", 0) == 1;
        } else {
            if (zzs.zzyF()) {
                return Secure.getInt(this.mContext.getContentResolver(), "package_verifier_user_consent", 0) == 1;
            } else {
                try {
                    return this.mContext.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 2).getSharedPreferences("package_verifer_public_preferences", 1).getBoolean("accepted-anti-malware-consent", false);
                } catch (NameNotFoundException e) {
                    return false;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean zzOb() {
        /*
        r5 = this;
        r0 = 0;
        monitor-enter(r5);
        r1 = r5.zzbBP;	 Catch:{ all -> 0x002c }
        if (r1 != 0) goto L_0x0024;
    L_0x0006:
        r1 = r5.mContext;	 Catch:{ all -> 0x002c }
        r2 = r1.getPackageManager();	 Catch:{ all -> 0x002c }
        r1 = 0;
        r3 = "com.android.vending";
        r4 = 0;
        r1 = r2.getPackageInfo(r3, r4);	 Catch:{ NameNotFoundException -> 0x002f }
    L_0x0014:
        if (r1 == 0) goto L_0x001d;
    L_0x0016:
        r1 = r1.versionCode;	 Catch:{ all -> 0x002c }
        r2 = 80440000; // 0x4cb6ac0 float:4.7823105E-36 double:3.97426406E-316;
        if (r1 < r2) goto L_0x001e;
    L_0x001d:
        r0 = 1;
    L_0x001e:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x002c }
        r5.zzbBP = r0;	 Catch:{ all -> 0x002c }
    L_0x0024:
        r0 = r5.zzbBP;	 Catch:{ all -> 0x002c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x002c }
        monitor-exit(r5);
        return r0;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x002f:
        r2 = move-exception;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaxh.zzOb():boolean");
    }
}
