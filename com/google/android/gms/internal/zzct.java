package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja.zzc;
import com.google.android.gms.internal.zzqi.zzb;
import org.json.JSONObject;

@zzmb
public class zzct implements zzcu {
    private final zzhx zzwA;
    private final zzhx zzwB;
    private zzc zzwD;
    private boolean zzwE;
    private final zzcq zzwx;
    private final zzhx zzwz;

    public zzct(zzcq com_google_android_gms_internal_zzcq, zzja com_google_android_gms_internal_zzja) {
        this.zzwz = new 5(this);
        this.zzwA = new 6(this);
        this.zzwB = new 7(this);
        this.zzwx = com_google_android_gms_internal_zzcq;
        this.zzwD = com_google_android_gms_internal_zzja.zzgv();
        this.zzwD.zza(new 1(this), new 2(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwx.zzdN().zzdy());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjb com_google_android_gms_internal_zzjb) {
        com_google_android_gms_internal_zzjb.zza("/updateActiveView", this.zzwz);
        com_google_android_gms_internal_zzjb.zza("/untrackActiveViewUnit", this.zzwA);
        com_google_android_gms_internal_zzjb.zza("/visibilityChanged", this.zzwB);
    }

    public void zzc(JSONObject jSONObject, boolean z) {
        this.zzwD.zza(new 3(this, jSONObject), new zzb());
    }

    void zzd(zzjb com_google_android_gms_internal_zzjb) {
        com_google_android_gms_internal_zzjb.zzb("/visibilityChanged", this.zzwB);
        com_google_android_gms_internal_zzjb.zzb("/untrackActiveViewUnit", this.zzwA);
        com_google_android_gms_internal_zzjb.zzb("/updateActiveView", this.zzwz);
    }

    public boolean zzdR() {
        return this.zzwE;
    }

    public void zzdS() {
        this.zzwD.zza(new 4(this), new zzb());
        this.zzwD.release();
    }
}
