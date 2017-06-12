package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzboc {
    private final zzbop zzbYx;
    private final zzbmg zzcbK;

    /* renamed from: com.google.android.gms.internal.zzboc.1 */
    class C12651 implements Runnable {
        final /* synthetic */ ArrayList zzcfV;
        final /* synthetic */ zzboc zzcfW;

        C12651(zzboc com_google_android_gms_internal_zzboc, ArrayList arrayList) {
            this.zzcfW = com_google_android_gms_internal_zzboc;
            this.zzcfV = arrayList;
        }

        public void run() {
            Iterator it = this.zzcfV.iterator();
            while (it.hasNext()) {
                zzboa com_google_android_gms_internal_zzboa = (zzboa) it.next();
                if (this.zzcfW.zzbYx.zzYT()) {
                    zzbop zza = this.zzcfW.zzbYx;
                    String str = "Raising ";
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzboa.toString());
                    zza.zzi(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                }
                com_google_android_gms_internal_zzboa.zzYj();
            }
        }
    }

    public zzboc(zzbmc com_google_android_gms_internal_zzbmc) {
        this.zzcbK = com_google_android_gms_internal_zzbmc.zzWQ();
        this.zzbYx = com_google_android_gms_internal_zzbmc.zziW("EventRaiser");
    }

    public void zzY(List<? extends zzboa> list) {
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi("Raising " + list.size() + " event(s)", new Object[0]);
        }
        this.zzcbK.zzq(new C12651(this, new ArrayList(list)));
    }
}
