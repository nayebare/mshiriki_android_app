package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zztr$zzb extends zza implements Result {
    public static final Creator<zztr$zzb> CREATOR;
    final int mVersionCode;
    public Status zzagv;
    public List<zztx> zzagw;
    @Deprecated
    public String[] zzagx;

    static {
        CREATOR = new zztt();
    }

    public zztr$zzb() {
        this.mVersionCode = 1;
    }

    zztr$zzb(int i, Status status, List<zztx> list, String[] strArr) {
        this.mVersionCode = i;
        this.zzagv = status;
        this.zzagw = list;
        this.zzagx = strArr;
    }

    public Status getStatus() {
        return this.zzagv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zztt.zza(this, parcel, i);
    }
}
