package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzov.zza;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@zzmb
public class zzlv {
    private final Context mContext;
    private final zzr zzGl;
    private final zzav zzGr;
    private final zza zzPo;
    private OnGlobalLayoutListener zzQA;
    private OnScrollChangedListener zzQB;
    private final Object zzrN;
    private final zzgf zzsr;
    private int zzvI;
    private int zzvJ;
    private zzpt zzvK;

    public zzlv(Context context, zzav com_google_android_gms_internal_zzav, zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf, zzr com_google_android_gms_ads_internal_zzr) {
        this.zzrN = new Object();
        this.zzvI = -1;
        this.zzvJ = -1;
        this.mContext = context;
        this.zzGr = com_google_android_gms_internal_zzav;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzsr = com_google_android_gms_internal_zzgf;
        this.zzGl = com_google_android_gms_ads_internal_zzr;
        this.zzvK = new zzpt(200);
    }

    private OnGlobalLayoutListener zza(WeakReference<zzqp> weakReference) {
        if (this.zzQA == null) {
            this.zzQA = new 3(this, weakReference);
        }
        return this.zzQA;
    }

    private void zza(WeakReference<zzqp> weakReference, boolean z) {
        if (weakReference != null) {
            zzqp com_google_android_gms_internal_zzqp = (zzqp) weakReference.get();
            if (com_google_android_gms_internal_zzqp != null && com_google_android_gms_internal_zzqp.getView() != null) {
                if (!z || this.zzvK.tryAcquire()) {
                    int[] iArr = new int[2];
                    com_google_android_gms_internal_zzqp.getView().getLocationOnScreen(iArr);
                    int zzc = zzeh.zzeO().zzc(this.mContext, iArr[0]);
                    int zzc2 = zzeh.zzeO().zzc(this.mContext, iArr[1]);
                    synchronized (this.zzrN) {
                        if (!(this.zzvI == zzc && this.zzvJ == zzc2)) {
                            this.zzvI = zzc;
                            this.zzvJ = zzc2;
                            com_google_android_gms_internal_zzqp.zzkV().zza(this.zzvI, this.zzvJ, !z);
                        }
                    }
                }
            }
        }
    }

    private OnScrollChangedListener zzb(WeakReference<zzqp> weakReference) {
        if (this.zzQB == null) {
            this.zzQB = new 4(this, weakReference);
        }
        return this.zzQB;
    }

    private void zzj(zzqp com_google_android_gms_internal_zzqp) {
        zzqq zzkV = com_google_android_gms_internal_zzqp.zzkV();
        zzkV.zza("/video", zzhw.zzHq);
        zzkV.zza("/videoMeta", zzhw.zzHr);
        zzkV.zza("/precache", zzhw.zzHs);
        zzkV.zza("/delayPageLoaded", zzhw.zzHv);
        zzkV.zza("/instrument", zzhw.zzHt);
        zzkV.zza("/log", zzhw.zzHl);
        zzkV.zza("/videoClicked", zzhw.zzHm);
        zzkV.zza("/trackActiveViewUnit", new 2(this));
    }

    public zzqf<zzqp> zzf(JSONObject jSONObject) {
        zzqc com_google_android_gms_internal_zzqc = new zzqc();
        zzv.zzcJ().runOnUiThread(new 1(this, jSONObject, com_google_android_gms_internal_zzqc));
        return com_google_android_gms_internal_zzqc;
    }

    zzqp zziU() {
        return zzv.zzcK().zza(this.mContext, zzec.zzj(this.mContext), false, false, this.zzGr, this.zzPo.zzSF.zzvf, this.zzsr, null, this.zzGl.zzbz());
    }
}
