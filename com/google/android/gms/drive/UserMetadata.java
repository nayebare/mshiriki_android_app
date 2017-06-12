package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class UserMetadata extends zza implements ReflectedParcelable {
    public static final Creator<UserMetadata> CREATOR;
    final int mVersionCode;
    final String zzaKb;
    final String zzaKc;
    final boolean zzaKd;
    final String zzaKe;
    final String zzaiX;

    static {
        CREATOR = new zzq();
    }

    UserMetadata(int i, String str, String str2, String str3, boolean z, String str4) {
        this.mVersionCode = i;
        this.zzaKb = str;
        this.zzaiX = str2;
        this.zzaKc = str3;
        this.zzaKd = z;
        this.zzaKe = str4;
    }

    public UserMetadata(String str, String str2, String str3, boolean z, String str4) {
        this(1, str, str2, str3, z, str4);
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzaKb, this.zzaiX, this.zzaKc, Boolean.valueOf(this.zzaKd), this.zzaKe});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
