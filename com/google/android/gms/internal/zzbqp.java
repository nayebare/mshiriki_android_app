package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzbqu.zza;
import com.google.android.gms.internal.zzbqu.zzb;
import com.google.android.gms.internal.zzbqu.zzc;
import com.google.android.gms.internal.zzbqu.zzd;
import com.google.android.gms.internal.zzbqu.zze;
import com.google.android.gms.internal.zzbqu.zzf;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzbqp implements Runnable {
    public final Context mContext;
    public final zzbqt zzcjD;
    public final zzbqq zzcjK;
    public final zzbqq zzcjL;
    public final zzbqq zzcjM;

    public zzbqp(Context context, zzbqq com_google_android_gms_internal_zzbqq, zzbqq com_google_android_gms_internal_zzbqq2, zzbqq com_google_android_gms_internal_zzbqq3, zzbqt com_google_android_gms_internal_zzbqt) {
        this.mContext = context;
        this.zzcjK = com_google_android_gms_internal_zzbqq;
        this.zzcjL = com_google_android_gms_internal_zzbqq2;
        this.zzcjM = com_google_android_gms_internal_zzbqq3;
        this.zzcjD = com_google_android_gms_internal_zzbqt;
    }

    private zza zza(zzbqq com_google_android_gms_internal_zzbqq) {
        zza com_google_android_gms_internal_zzbqu_zza = new zza();
        if (com_google_android_gms_internal_zzbqq.zzaav() != null) {
            Map zzaav = com_google_android_gms_internal_zzbqq.zzaav();
            List arrayList = new ArrayList();
            for (String str : zzaav.keySet()) {
                List arrayList2 = new ArrayList();
                Map map = (Map) zzaav.get(str);
                for (String str2 : map.keySet()) {
                    zzb com_google_android_gms_internal_zzbqu_zzb = new zzb();
                    com_google_android_gms_internal_zzbqu_zzb.zzaA = str2;
                    com_google_android_gms_internal_zzbqu_zzb.zzcjW = (byte[]) map.get(str2);
                    arrayList2.add(com_google_android_gms_internal_zzbqu_zzb);
                }
                zzd com_google_android_gms_internal_zzbqu_zzd = new zzd();
                com_google_android_gms_internal_zzbqu_zzd.zzaFs = str;
                com_google_android_gms_internal_zzbqu_zzd.zzcka = (zzb[]) arrayList2.toArray(new zzb[arrayList2.size()]);
                arrayList.add(com_google_android_gms_internal_zzbqu_zzd);
            }
            com_google_android_gms_internal_zzbqu_zza.zzcjU = (zzd[]) arrayList.toArray(new zzd[arrayList.size()]);
        }
        com_google_android_gms_internal_zzbqu_zza.timestamp = com_google_android_gms_internal_zzbqq.getTimestamp();
        return com_google_android_gms_internal_zzbqu_zza;
    }

    public void run() {
        zze com_google_android_gms_internal_zzbqu_zze = new zze();
        if (this.zzcjK != null) {
            com_google_android_gms_internal_zzbqu_zze.zzckb = zza(this.zzcjK);
        }
        if (this.zzcjL != null) {
            com_google_android_gms_internal_zzbqu_zze.zzckc = zza(this.zzcjL);
        }
        if (this.zzcjM != null) {
            com_google_android_gms_internal_zzbqu_zze.zzckd = zza(this.zzcjM);
        }
        if (this.zzcjD != null) {
            zzc com_google_android_gms_internal_zzbqu_zzc = new zzc();
            com_google_android_gms_internal_zzbqu_zzc.zzcjX = this.zzcjD.getLastFetchStatus();
            com_google_android_gms_internal_zzbqu_zzc.zzcjY = this.zzcjD.isDeveloperModeEnabled();
            com_google_android_gms_internal_zzbqu_zze.zzcke = com_google_android_gms_internal_zzbqu_zzc;
        }
        if (!(this.zzcjD == null || this.zzcjD.zzaay() == null)) {
            List arrayList = new ArrayList();
            Map zzaay = this.zzcjD.zzaay();
            for (String str : zzaay.keySet()) {
                if (zzaay.get(str) != null) {
                    zzf com_google_android_gms_internal_zzbqu_zzf = new zzf();
                    com_google_android_gms_internal_zzbqu_zzf.zzaFs = str;
                    com_google_android_gms_internal_zzbqu_zzf.zzckh = ((zzbqo) zzaay.get(str)).zzaau();
                    com_google_android_gms_internal_zzbqu_zzf.resourceId = ((zzbqo) zzaay.get(str)).zzaat();
                    arrayList.add(com_google_android_gms_internal_zzbqu_zzf);
                }
            }
            com_google_android_gms_internal_zzbqu_zze.zzckf = (zzf[]) arrayList.toArray(new zzf[arrayList.size()]);
        }
        byte[] zzf = zzbut.zzf(com_google_android_gms_internal_zzbqu_zze);
        try {
            FileOutputStream openFileOutput = this.mContext.openFileOutput("persisted_config", 0);
            openFileOutput.write(zzf);
            openFileOutput.close();
        } catch (Throwable e) {
            Log.e("AsyncPersisterTask", "Could not persist config.", e);
        }
    }
}
