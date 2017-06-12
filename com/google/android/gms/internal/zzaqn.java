package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaqn extends zza {
    public static final Creator<zzaqn> CREATOR;
    public final int version;
    private final String zzaIv;
    private final int zzbhU;
    private final boolean zzbhV;
    private final Intent zzbhW;
    private final Intent zzbhX;
    private final byte[] zzbhY;
    private final zzaqe zzbhZ;
    private final zzara zzbia;
    private final boolean zzbib;

    static {
        CREATOR = new zzaqo();
    }

    zzaqn(int i, int i2, String str, boolean z, Intent intent, Intent intent2, byte[] bArr, zzaqe com_google_android_gms_internal_zzaqe, zzara com_google_android_gms_internal_zzara, boolean z2) {
        this.version = i;
        this.zzbhU = i2;
        this.zzaIv = str;
        this.zzbhV = z;
        this.zzbhW = intent;
        this.zzbhX = intent2;
        this.zzbhY = bArr;
        this.zzbhZ = com_google_android_gms_internal_zzaqe;
        this.zzbia = com_google_android_gms_internal_zzara;
        this.zzbib = z2;
    }

    public String getAccountName() {
        return this.zzaIv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqo.zza(this, parcel, i);
    }

    public int zzGK() {
        return this.zzbhU;
    }

    public boolean zzGL() {
        return this.zzbhV;
    }

    public Intent zzGM() {
        return this.zzbhW;
    }

    public Intent zzGN() {
        return this.zzbhX;
    }

    public byte[] zzGO() {
        return this.zzbhY;
    }

    public zzaqe zzGP() {
        return this.zzbhZ;
    }

    public zzara zzGQ() {
        return this.zzbia;
    }

    public boolean zzGR() {
        return this.zzbib;
    }
}
