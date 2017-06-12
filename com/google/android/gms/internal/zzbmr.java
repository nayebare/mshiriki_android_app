package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzbmr {
    private zzbpe zzcdv;
    private Map<zzbos, zzbmr> zzcdw;

    public interface zzb {
        void zzf(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe);
    }

    /* renamed from: com.google.android.gms.internal.zzbmr.1 */
    class C12351 extends com.google.android.gms.internal.zzbot.zza {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ zzbmr zzcdx;

        C12351(zzbmr com_google_android_gms_internal_zzbmr, zzbmj com_google_android_gms_internal_zzbmj) {
            this.zzcdx = com_google_android_gms_internal_zzbmr;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
        }

        public void zzb(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzcdx.zzh(this.zzcbD.zza(com_google_android_gms_internal_zzbos), com_google_android_gms_internal_zzbpe);
        }
    }

    public interface zza {
        void zza(zzbos com_google_android_gms_internal_zzbos, zzbmr com_google_android_gms_internal_zzbmr);
    }

    /* renamed from: com.google.android.gms.internal.zzbmr.2 */
    class C12362 implements zza {
        final /* synthetic */ zzbmj zzcdy;
        final /* synthetic */ zzb zzcdz;

        C12362(zzbmr com_google_android_gms_internal_zzbmr, zzbmj com_google_android_gms_internal_zzbmj, zzb com_google_android_gms_internal_zzbmr_zzb) {
            this.zzcdy = com_google_android_gms_internal_zzbmj;
            this.zzcdz = com_google_android_gms_internal_zzbmr_zzb;
        }

        public void zza(zzbos com_google_android_gms_internal_zzbos, zzbmr com_google_android_gms_internal_zzbmr) {
            com_google_android_gms_internal_zzbmr.zza(this.zzcdy.zza(com_google_android_gms_internal_zzbos), this.zzcdz);
        }
    }

    public zzbmr() {
        this.zzcdv = null;
        this.zzcdw = null;
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzb com_google_android_gms_internal_zzbmr_zzb) {
        if (this.zzcdv != null) {
            com_google_android_gms_internal_zzbmr_zzb.zzf(com_google_android_gms_internal_zzbmj, this.zzcdv);
        } else {
            zza(new C12362(this, com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbmr_zzb));
        }
    }

    public void zza(zza com_google_android_gms_internal_zzbmr_zza) {
        if (this.zzcdw != null) {
            for (Entry entry : this.zzcdw.entrySet()) {
                com_google_android_gms_internal_zzbmr_zza.zza((zzbos) entry.getKey(), (zzbmr) entry.getValue());
            }
        }
    }

    public void zzh(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            this.zzcdv = com_google_android_gms_internal_zzbpe;
            this.zzcdw = null;
        } else if (this.zzcdv != null) {
            this.zzcdv = this.zzcdv.zzl(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe);
        } else {
            if (this.zzcdw == null) {
                this.zzcdw = new HashMap();
            }
            zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            if (!this.zzcdw.containsKey(zzXi)) {
                this.zzcdw.put(zzXi, new zzbmr());
            }
            ((zzbmr) this.zzcdw.get(zzXi)).zzh(com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzbpe);
        }
    }

    public boolean zzr(zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            this.zzcdv = null;
            this.zzcdw = null;
            return true;
        } else if (this.zzcdv != null) {
            if (this.zzcdv.zzZd()) {
                return false;
            }
            zzbot com_google_android_gms_internal_zzbot = (zzbot) this.zzcdv;
            this.zzcdv = null;
            com_google_android_gms_internal_zzbot.zza(new C12351(this, com_google_android_gms_internal_zzbmj));
            return zzr(com_google_android_gms_internal_zzbmj);
        } else if (this.zzcdw == null) {
            return true;
        } else {
            zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            zzbmj zzXj = com_google_android_gms_internal_zzbmj.zzXj();
            if (this.zzcdw.containsKey(zzXi) && ((zzbmr) this.zzcdw.get(zzXi)).zzr(zzXj)) {
                this.zzcdw.remove(zzXi);
            }
            if (!this.zzcdw.isEmpty()) {
                return false;
            }
            this.zzcdw = null;
            return true;
        }
    }
}
