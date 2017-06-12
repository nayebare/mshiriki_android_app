package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.query.Query;

public class zzakd extends zza {
    public static final Creator<zzakd> CREATOR;
    final int mVersionCode;
    final Query zzaNb;

    static {
        CREATOR = new zzake();
    }

    zzakd(int i, Query query) {
        this.mVersionCode = i;
        this.zzaNb = query;
    }

    public zzakd(Query query) {
        this(1, query);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzake.zza(this, parcel, i);
    }
}
