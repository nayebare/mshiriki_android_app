package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzem.zza;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzqa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzj extends zza {
    private final Context mContext;
    private final Object zzrN;
    private final zzjs zzsD;
    private final zzd zzsz;
    private final zzel zzti;
    @Nullable
    private final zzhj zztj;
    @Nullable
    private final zzhk zztk;
    private final SimpleArrayMap<String, zzhm> zztl;
    private final SimpleArrayMap<String, zzhl> zztm;
    private final zzgw zztn;
    private final List<String> zzto;
    private final zzet zztp;
    private final String zztq;
    private final zzqa zztr;
    @Nullable
    private WeakReference<zzr> zzts;

    /* renamed from: com.google.android.gms.ads.internal.zzj.1 */
    class C05131 implements Runnable {
        final /* synthetic */ zzdy zztt;
        final /* synthetic */ zzj zztu;

        C05131(zzj com_google_android_gms_ads_internal_zzj, zzdy com_google_android_gms_internal_zzdy) {
            this.zztu = com_google_android_gms_ads_internal_zzj;
            this.zztt = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            synchronized (this.zztu.zzrN) {
                zzr zzch = this.zztu.zzch();
                this.zztu.zzts = new WeakReference(zzch);
                zzch.zzb(this.zztu.zztj);
                zzch.zzb(this.zztu.zztk);
                zzch.zza(this.zztu.zztl);
                zzch.zza(this.zztu.zzti);
                zzch.zzb(this.zztu.zztm);
                zzch.zzb(this.zztu.zzcg());
                zzch.zzb(this.zztu.zztn);
                zzch.zza(this.zztu.zztp);
                zzch.zzb(this.zztt);
            }
        }
    }

    zzj(Context context, String str, zzjs com_google_android_gms_internal_zzjs, zzqa com_google_android_gms_internal_zzqa, zzel com_google_android_gms_internal_zzel, zzhj com_google_android_gms_internal_zzhj, zzhk com_google_android_gms_internal_zzhk, SimpleArrayMap<String, zzhm> simpleArrayMap, SimpleArrayMap<String, zzhl> simpleArrayMap2, zzgw com_google_android_gms_internal_zzgw, zzet com_google_android_gms_internal_zzet, zzd com_google_android_gms_ads_internal_zzd) {
        this.zzrN = new Object();
        this.mContext = context;
        this.zztq = str;
        this.zzsD = com_google_android_gms_internal_zzjs;
        this.zztr = com_google_android_gms_internal_zzqa;
        this.zzti = com_google_android_gms_internal_zzel;
        this.zztk = com_google_android_gms_internal_zzhk;
        this.zztj = com_google_android_gms_internal_zzhj;
        this.zztl = simpleArrayMap;
        this.zztm = simpleArrayMap2;
        this.zztn = com_google_android_gms_internal_zzgw;
        this.zzto = zzcg();
        this.zztp = com_google_android_gms_internal_zzet;
        this.zzsz = com_google_android_gms_ads_internal_zzd;
    }

    private List<String> zzcg() {
        List<String> arrayList = new ArrayList();
        if (this.zztk != null) {
            arrayList.add("1");
        }
        if (this.zztj != null) {
            arrayList.add("2");
        }
        if (this.zztl.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    @Nullable
    public String getMediationAdapterClassName() {
        synchronized (this.zzrN) {
            if (this.zzts != null) {
                zzr com_google_android_gms_ads_internal_zzr = (zzr) this.zzts.get();
                String mediationAdapterClassName = com_google_android_gms_ads_internal_zzr != null ? com_google_android_gms_ads_internal_zzr.getMediationAdapterClassName() : null;
                return mediationAdapterClassName;
            }
            return null;
        }
    }

    public boolean isLoading() {
        synchronized (this.zzrN) {
            if (this.zzts != null) {
                zzr com_google_android_gms_ads_internal_zzr = (zzr) this.zzts.get();
                boolean isLoading = com_google_android_gms_ads_internal_zzr != null ? com_google_android_gms_ads_internal_zzr.isLoading() : false;
                return isLoading;
            }
            return false;
        }
    }

    protected void runOnUiThread(Runnable runnable) {
        zzpi.zzWR.post(runnable);
    }

    protected zzr zzch() {
        return new zzr(this.mContext, this.zzsz, zzec.zzj(this.mContext), this.zztq, this.zzsD, this.zztr);
    }

    public void zzf(zzdy com_google_android_gms_internal_zzdy) {
        runOnUiThread(new C05131(this, com_google_android_gms_internal_zzdy));
    }
}
