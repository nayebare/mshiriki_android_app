package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzawz.zza;
import java.util.List;

public class zzaxb extends zzl<zzawz> {
    private final Context mContext;

    public zzaxb(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
    }

    private String zzgx(String str) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.mContext.getPackageName(), Cast.MAX_NAMESPACE_LENGTH);
            if (applicationInfo == null) {
                return null;
            }
            Bundle bundle = applicationInfo.metaData;
            return bundle == null ? null : (String) bundle.get(str);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public void zza(zzawy com_google_android_gms_internal_zzawy, String str) throws RemoteException {
        ((zzawz) zzwW()).zza(com_google_android_gms_internal_zzawy, str);
    }

    public void zza(zzawy com_google_android_gms_internal_zzawy, List<Integer> list, int i, String str, String str2) throws RemoteException {
        String zzgx = str2 == null ? zzgx("com.google.android.safetynet.API_KEY") : str2;
        int[] iArr = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            iArr[i2] = ((Integer) list.get(i2)).intValue();
        }
        ((zzawz) zzwW()).zza(com_google_android_gms_internal_zzawy, zzgx, iArr, i, str);
    }

    public void zza(zzawy com_google_android_gms_internal_zzawy, byte[] bArr) throws RemoteException {
        ((zzawz) zzwW()).zza(com_google_android_gms_internal_zzawy, bArr, zzgx("com.google.android.safetynet.ATTEST_API_KEY"));
    }

    public void zzb(zzawy com_google_android_gms_internal_zzawy) throws RemoteException {
        ((zzawz) zzwW()).zzb(com_google_android_gms_internal_zzawy);
    }

    public void zzc(zzawy com_google_android_gms_internal_zzawy) throws RemoteException {
        ((zzawz) zzwW()).zzc(com_google_android_gms_internal_zzawy);
    }

    protected zzawz zzeT(IBinder iBinder) {
        return zza.zzeS(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.safetynet.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzeT(iBinder);
    }
}
