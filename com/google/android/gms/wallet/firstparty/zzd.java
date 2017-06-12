package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public final class zzd extends zza {
    public static final Creator<zzd> CREATOR;
    private final int mVersionCode;
    byte[] zzbPC;
    byte[] zzbPD;

    static {
        CREATOR = new zze();
    }

    zzd() {
        this(1, null, null);
    }

    zzd(int i, byte[] bArr, byte[] bArr2) {
        this.mVersionCode = i;
        this.zzbPC = bArr;
        this.zzbPD = bArr2;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
