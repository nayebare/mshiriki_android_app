package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class zzbmz extends zzbme {
    private final zzbml zzbXR;
    private final zzboe zzcbz;
    private final ValueEventListener zzcen;

    public zzbmz(zzbml com_google_android_gms_internal_zzbml, ValueEventListener valueEventListener, zzboe com_google_android_gms_internal_zzboe) {
        this.zzbXR = com_google_android_gms_internal_zzbml;
        this.zzcen = valueEventListener;
        this.zzcbz = com_google_android_gms_internal_zzboe;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzbmz) && ((zzbmz) obj).zzcen.equals(this.zzcen) && ((zzbmz) obj).zzbXR.equals(this.zzbXR) && ((zzbmz) obj).zzcbz.equals(this.zzcbz);
    }

    public int hashCode() {
        return (((this.zzcen.hashCode() * 31) + this.zzbXR.hashCode()) * 31) + this.zzcbz.hashCode();
    }

    public String toString() {
        return "ValueEventRegistration";
    }

    public zzboe zzWD() {
        return this.zzcbz;
    }

    public zzbme zza(zzboe com_google_android_gms_internal_zzboe) {
        return new zzbmz(this.zzbXR, this.zzcen, com_google_android_gms_internal_zzboe);
    }

    public zzbnz zza(zzbny com_google_android_gms_internal_zzbny, zzboe com_google_android_gms_internal_zzboe) {
        return new zzbnz(zza.VALUE, this, com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this.zzbXR, com_google_android_gms_internal_zzboe.zzVc()), com_google_android_gms_internal_zzbny.zzYi()), null);
    }

    public void zza(zzbnz com_google_android_gms_internal_zzbnz) {
        if (!zzXb()) {
            this.zzcen.onDataChange(com_google_android_gms_internal_zzbnz.zzYo());
        }
    }

    public void zza(DatabaseError databaseError) {
        this.zzcen.onCancelled(databaseError);
    }

    public boolean zza(zza com_google_android_gms_internal_zzboa_zza) {
        return com_google_android_gms_internal_zzboa_zza == zza.VALUE;
    }

    public boolean zzc(zzbme com_google_android_gms_internal_zzbme) {
        return (com_google_android_gms_internal_zzbme instanceof zzbmz) && ((zzbmz) com_google_android_gms_internal_zzbme).zzcen.equals(this.zzcen);
    }
}
