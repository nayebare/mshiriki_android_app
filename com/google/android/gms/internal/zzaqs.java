package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zzaqs {
    private static zzaqs zzbih;
    private final Context mContext;

    private zzaqs(Context context) {
        this.mContext = context;
    }

    private static boolean zzGS() {
        return VERSION.SDK_INT >= 16;
    }

    @Nullable
    public static synchronized zzaqs zzbn(Context context) {
        zzaqs com_google_android_gms_internal_zzaqs;
        synchronized (zzaqs.class) {
            if (zzbih == null) {
                zzbih = zzbo(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzaqs = zzbih;
        }
        return com_google_android_gms_internal_zzaqs;
    }

    private static zzaqs zzbo(Context context) {
        if (!zzGS() || !zzarc.zzbp(context)) {
            return null;
        }
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(zzaqt.zzbii.getAuthority(), 0);
        if (resolveContentProvider == null) {
            return null;
        }
        if (resolveContentProvider.packageName.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
            return new zzaqs(context);
        }
        String valueOf = String.valueOf(resolveContentProvider.packageName);
        Log.e("IAMetadataClient", new StringBuilder(String.valueOf(valueOf).length() + 85).append("Package ").append(valueOf).append(" is invalid for instant apps content provider; instant apps will be disabled.").toString());
        return null;
    }

    @TargetApi(16)
    private Bundle zzh(String str, Bundle bundle) throws RemoteException {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Bundle call = this.mContext.getContentResolver().call(zzaqt.zzbii, str, null, bundle);
            if (call != null) {
                return call;
            }
            throw new RemoteException();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public ApplicationInfo getApplicationInfo(String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        bundle.putInt("flags", i);
        return (ApplicationInfo) zzh("getWHApplicationInfo", bundle).getParcelable("result");
    }

    public PackageInfo getPackageInfo(String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        bundle.putInt("flags", i);
        return (PackageInfo) zzh("getWHPackageInfo", bundle).getParcelable("result");
    }

    public String zzeQ(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        return zzh("getApplicationLabel", bundle).getString("result");
    }

    public ComponentName zzeR(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("shadowActivity", str);
        return (ComponentName) zzh("getCallingActivity", bundle).getParcelable("result");
    }

    public String zzjJ(int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        return zzh("getAppPackageForUid", bundle).getString("result");
    }
}
