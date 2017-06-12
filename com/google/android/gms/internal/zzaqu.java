package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaqu extends zza {
    public static final Creator<zzaqu> CREATOR;
    public final int version;
    private final String zzaIv;
    private final int zzbij;
    private final Account[] zzbik;

    static {
        CREATOR = new zzaqv();
    }

    zzaqu(int i, int i2, String str, Account[] accountArr) {
        this.version = i;
        this.zzbij = i2;
        this.zzaIv = str;
        this.zzbik = accountArr;
    }

    public String getAccountName() {
        return this.zzaIv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqv.zza(this, parcel, i);
    }

    public int zzGT() {
        return this.zzbij;
    }

    public Account[] zzGU() {
        return this.zzbik;
    }
}
