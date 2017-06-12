package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblr.zza;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

enum zzbmi implements zzbmk {
    INSTANCE;

    /* renamed from: com.google.android.gms.internal.zzbmi.1 */
    class C12151 extends zzbqa {
        final /* synthetic */ zzbop zzbYs;

        C12151(zzbmi com_google_android_gms_internal_zzbmi, zzbop com_google_android_gms_internal_zzbop) {
            this.zzbYs = com_google_android_gms_internal_zzbop;
        }

        public void zzj(Throwable th) {
            this.zzbYs.zzd(zzbqa.zzl(th), th);
        }
    }

    public zzblr zza(zzbmc com_google_android_gms_internal_zzbmc, zzbln com_google_android_gms_internal_zzbln, zzblp com_google_android_gms_internal_zzblp, zza com_google_android_gms_internal_zzblr_zza) {
        return new zzbls(com_google_android_gms_internal_zzbmc.zzWO(), com_google_android_gms_internal_zzblp, com_google_android_gms_internal_zzblr_zza);
    }

    public zzbly zza(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public zzbmg zza(zzbmc com_google_android_gms_internal_zzbmc) {
        return new zzbmw(Executors.defaultThreadFactory(), zzbmv.zzced);
    }

    public zzbnn zza(zzbmc com_google_android_gms_internal_zzbmc, String str) {
        return null;
    }

    public zzboq zza(zzbmc com_google_android_gms_internal_zzbmc, zzboq.zza com_google_android_gms_internal_zzboq_zza, List<String> list) {
        return new zzboo(com_google_android_gms_internal_zzboq_zza, list);
    }

    public zzbmo zzb(zzbmc com_google_android_gms_internal_zzbmc) {
        return new C12151(this, com_google_android_gms_internal_zzbmc.zziW("RunLoop"));
    }

    public String zzc(zzbmc com_google_android_gms_internal_zzbmc) {
        String property = System.getProperty("java.vm.name", "Unknown JVM");
        String property2 = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder((String.valueOf(property2).length() + 1) + String.valueOf(property).length()).append(property2).append("/").append(property).toString();
    }
}
