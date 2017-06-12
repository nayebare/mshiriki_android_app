package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzja {
    private final Context mContext;
    private final String zzJd;
    private zzpn<zzix> zzJe;
    private zzpn<zzix> zzJf;
    @Nullable
    private zzd zzJg;
    private int zzJh;
    private final Object zzrN;
    private final zzqa zztr;

    public zzja(Context context, zzqa com_google_android_gms_internal_zzqa, String str) {
        this.zzrN = new Object();
        this.zzJh = 1;
        this.zzJd = str;
        this.mContext = context.getApplicationContext();
        this.zztr = com_google_android_gms_internal_zzqa;
        this.zzJe = new zzb();
        this.zzJf = new zzb();
    }

    public zzja(Context context, zzqa com_google_android_gms_internal_zzqa, String str, zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix, zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix2) {
        this(context, com_google_android_gms_internal_zzqa, str);
        this.zzJe = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix;
        this.zzJf = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix2;
    }

    private zzd zza(@Nullable zzav com_google_android_gms_internal_zzav) {
        zzd com_google_android_gms_internal_zzja_zzd = new zzd(this.zzJf);
        zzv.zzcJ().runOnUiThread(new 1(this, com_google_android_gms_internal_zzav, com_google_android_gms_internal_zzja_zzd));
        return com_google_android_gms_internal_zzja_zzd;
    }

    protected zzix zza(Context context, zzqa com_google_android_gms_internal_zzqa, @Nullable zzav com_google_android_gms_internal_zzav) {
        return new zziz(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzav, null);
    }

    protected zzd zzb(@Nullable zzav com_google_android_gms_internal_zzav) {
        zzd zza = zza(com_google_android_gms_internal_zzav);
        zza.zza(new 2(this, zza), new 3(this, zza));
        return zza;
    }

    public zzc zzc(@Nullable zzav com_google_android_gms_internal_zzav) {
        zzc zzgw;
        synchronized (this.zzrN) {
            if (this.zzJg == null || this.zzJg.getStatus() == -1) {
                this.zzJh = 2;
                this.zzJg = zzb(com_google_android_gms_internal_zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 0) {
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 1) {
                this.zzJh = 2;
                zzb(com_google_android_gms_internal_zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 2) {
                zzgw = this.zzJg.zzgw();
            } else {
                zzgw = this.zzJg.zzgw();
            }
        }
        return zzgw;
    }

    public zzc zzgv() {
        return zzc(null);
    }
}
