package com.google.android.gms.internal;

import org.json.JSONObject;

@zzmb
public class zzkm {
    private final boolean zzLJ;
    private final boolean zzLK;
    private final boolean zzLL;
    private final boolean zzLM;
    private final boolean zzLN;

    private zzkm(zza com_google_android_gms_internal_zzkm_zza) {
        this.zzLJ = zza.zza(com_google_android_gms_internal_zzkm_zza);
        this.zzLK = zza.zzb(com_google_android_gms_internal_zzkm_zza);
        this.zzLL = zza.zzc(com_google_android_gms_internal_zzkm_zza);
        this.zzLM = zza.zzd(com_google_android_gms_internal_zzkm_zza);
        this.zzLN = zza.zze(com_google_android_gms_internal_zzkm_zza);
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzLJ).put("tel", this.zzLK).put("calendar", this.zzLL).put("storePicture", this.zzLM).put("inlineVideo", this.zzLN);
        } catch (Throwable e) {
            zzpy.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
