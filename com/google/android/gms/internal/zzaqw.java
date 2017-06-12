package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.google.android.gms.instantapps.PackageManagerWrapper;

public class zzaqw implements PackageManagerWrapper {
    private static zzaqw zzbil;
    private final boolean zzbim;
    private final Context zzqr;

    zzaqw(Context context, boolean z) {
        this.zzqr = context;
        this.zzbim = z;
    }

    private boolean zzeS(String str) {
        return str.equals("com.google.android.instantapps.supervisor");
    }

    public static synchronized zzaqw zzh(Context context, boolean z) {
        zzaqw com_google_android_gms_internal_zzaqw;
        synchronized (zzaqw.class) {
            Context applicationContext = context.getApplicationContext();
            if (!(zzbil != null && zzbil.zzqr == applicationContext && zzbil.zzbim == z)) {
                zzbil = new zzaqw(applicationContext, z);
            }
            com_google_android_gms_internal_zzaqw = zzbil;
        }
        return com_google_android_gms_internal_zzaqw;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String r4, int r5) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
        r3 = this;
        r0 = r3.zzbim;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = r3.zzqr;	 Catch:{ NameNotFoundException -> 0x000f }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000f }
        r0 = r0.getApplicationInfo(r4, r5);	 Catch:{ NameNotFoundException -> 0x000f }
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = move-exception;
    L_0x0010:
        r0 = r3.zzqr;
        r0 = com.google.android.gms.internal.zzaqs.zzbn(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0018:
        r0 = r0.getApplicationInfo(r4, r5);	 Catch:{ RemoteException -> 0x0024 }
        if (r0 != 0) goto L_0x000e;
    L_0x001e:
        r0 = new android.content.pm.PackageManager$NameNotFoundException;
        r0.<init>();
        throw r0;
    L_0x0024:
        r0 = move-exception;
        r1 = "InstantAppsPMW";
        r2 = "Error getting application info";
        android.util.Log.e(r1, r2, r0);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaqw.getApplicationInfo(java.lang.String, int):android.content.pm.ApplicationInfo");
    }

    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        if (this.zzbim && this.zzqr.getPackageManager().getPackagesForUid(applicationInfo.uid) != null) {
            return this.zzqr.getPackageManager().getApplicationLabel(applicationInfo);
        }
        zzaqs zzbn = zzaqs.zzbn(this.zzqr);
        if (zzbn != null) {
            try {
                return zzbn.zzeQ(applicationInfo.packageName);
            } catch (Throwable e) {
                Log.e("InstantAppsPMW", "Error getting application label", e);
            }
        }
        return null;
    }

    public ComponentName getCallingActivity(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (!(callingActivity == null || callingActivity.getPackageName() == null || !zzeS(callingActivity.getPackageName()))) {
            zzaqs zzbn = zzaqs.zzbn(this.zzqr);
            if (zzbn != null) {
                try {
                    ComponentName zzeR = zzbn.zzeR(callingActivity.getClassName());
                    if (zzeR != null) {
                        return zzeR;
                    }
                } catch (Throwable e) {
                    Log.e("InstantAppsPMW", "Error getting calling activity", e);
                }
            }
        }
        return callingActivity;
    }

    public String getCallingPackage(Activity activity) {
        ComponentName callingActivity = getCallingActivity(activity);
        return callingActivity != null ? callingActivity.getPackageName() : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.pm.PackageInfo getPackageInfo(java.lang.String r4, int r5) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
        r3 = this;
        r0 = r3.zzbim;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = r3.zzqr;	 Catch:{ NameNotFoundException -> 0x000f }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000f }
        r0 = r0.getPackageInfo(r4, r5);	 Catch:{ NameNotFoundException -> 0x000f }
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = move-exception;
    L_0x0010:
        r0 = r3.zzqr;
        r0 = com.google.android.gms.internal.zzaqs.zzbn(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0018:
        r0 = r0.getPackageInfo(r4, r5);	 Catch:{ RemoteException -> 0x0024 }
        if (r0 != 0) goto L_0x000e;
    L_0x001e:
        r0 = new android.content.pm.PackageManager$NameNotFoundException;
        r0.<init>();
        throw r0;
    L_0x0024:
        r0 = move-exception;
        r1 = "InstantAppsPMW";
        r2 = "Error getting package info";
        android.util.Log.e(r1, r2, r0);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaqw.getPackageInfo(java.lang.String, int):android.content.pm.PackageInfo");
    }

    public String[] getPackagesForUid(int i) {
        if (this.zzbim) {
            String[] packagesForUid = this.zzqr.getPackageManager().getPackagesForUid(i);
            if (packagesForUid != null) {
                return packagesForUid;
            }
        }
        zzaqs zzbn = zzaqs.zzbn(this.zzqr);
        if (zzbn == null) {
            return null;
        }
        try {
            if (zzbn.zzjJ(i) == null) {
                return null;
            }
            return new String[]{zzbn.zzjJ(i)};
        } catch (Throwable e) {
            Log.e("InstantAppsPMW", "Error getting app package for UID", e);
            return null;
        }
    }

    public boolean isInstantApp(int i) {
        zzaqs zzbn = zzaqs.zzbn(this.zzqr);
        if (zzbn == null) {
            return false;
        }
        try {
            return zzbn.zzjJ(i) != null;
        } catch (Throwable e) {
            Log.e("InstantAppsPMW", "Error checking if app is instant app", e);
            return false;
        }
    }
}
