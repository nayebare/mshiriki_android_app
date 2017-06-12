package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzjq implements zzjh {
    private final Context mContext;
    private final zzmh zzKG;
    private final long zzKH;
    private final long zzKI;
    private boolean zzKK;
    private List<zzjn> zzKM;
    private zzjm zzKQ;
    private final zzjj zzKq;
    private final boolean zzKs;
    private final Object zzrN;
    private final zzjs zzsD;
    private final zzgf zzsr;
    private final boolean zzvW;

    public zzjq(Context context, zzmh com_google_android_gms_internal_zzmh, zzjs com_google_android_gms_internal_zzjs, zzjj com_google_android_gms_internal_zzjj, boolean z, boolean z2, long j, long j2, zzgf com_google_android_gms_internal_zzgf) {
        this.zzrN = new Object();
        this.zzKK = false;
        this.zzKM = new ArrayList();
        this.mContext = context;
        this.zzKG = com_google_android_gms_internal_zzmh;
        this.zzsD = com_google_android_gms_internal_zzjs;
        this.zzKq = com_google_android_gms_internal_zzjj;
        this.zzvW = z;
        this.zzKs = z2;
        this.zzKH = j;
        this.zzKI = j2;
        this.zzsr = com_google_android_gms_internal_zzgf;
    }

    public void cancel() {
        synchronized (this.zzrN) {
            this.zzKK = true;
            if (this.zzKQ != null) {
                this.zzKQ.cancel();
            }
        }
    }

    public zzjn zzd(List<zzji> list) {
        zzpy.zzbc("Starting mediation.");
        Iterable arrayList = new ArrayList();
        zzgd zzfw = this.zzsr.zzfw();
        for (zzji com_google_android_gms_internal_zzji : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzji.zzJH);
            zzpy.zzbd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String str2 : com_google_android_gms_internal_zzji.zzJI) {
                zzgd zzfw2 = this.zzsr.zzfw();
                synchronized (this.zzrN) {
                    if (this.zzKK) {
                        zzjn com_google_android_gms_internal_zzjn = new zzjn(-1);
                        return com_google_android_gms_internal_zzjn;
                    }
                    this.zzKQ = new zzjm(this.mContext, str2, this.zzsD, this.zzKq, com_google_android_gms_internal_zzji, this.zzKG.zzRd, this.zzKG.zzvj, this.zzKG.zzvf, this.zzvW, this.zzKs, this.zzKG.zzvx, this.zzKG.zzvB);
                    com_google_android_gms_internal_zzjn = this.zzKQ.zza(this.zzKH, this.zzKI);
                    this.zzKM.add(com_google_android_gms_internal_zzjn);
                    if (com_google_android_gms_internal_zzjn.zzKz == 0) {
                        zzpy.zzbc("Adapter succeeded.");
                        this.zzsr.zzg("mediation_network_succeed", str2);
                        if (!arrayList.isEmpty()) {
                            this.zzsr.zzg("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.zzsr.zza(zzfw2, "mls");
                        this.zzsr.zza(zzfw, "ttm");
                        return com_google_android_gms_internal_zzjn;
                    }
                    arrayList.add(str2);
                    this.zzsr.zza(zzfw2, "mlf");
                    if (com_google_android_gms_internal_zzjn.zzKB != null) {
                        zzpi.zzWR.post(new 1(this, com_google_android_gms_internal_zzjn));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzsr.zzg("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzjn(1);
    }

    public List<zzjn> zzgB() {
        return this.zzKM;
    }
}
