package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;

public class zzbnx implements zzboa {
    private final zzbmj zzbXY;
    private final zzbme zzcfE;
    private final DatabaseError zzcfF;

    public zzbnx(zzbme com_google_android_gms_internal_zzbme, DatabaseError databaseError, zzbmj com_google_android_gms_internal_zzbmj) {
        this.zzcfE = com_google_android_gms_internal_zzbme;
        this.zzbXY = com_google_android_gms_internal_zzbmj;
        this.zzcfF = databaseError;
    }

    public String toString() {
        String valueOf = String.valueOf(zzVc());
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append(valueOf).append(":CANCEL").toString();
    }

    public zzbmj zzVc() {
        return this.zzbXY;
    }

    public void zzYj() {
        this.zzcfE.zza(this.zzcfF);
    }
}
