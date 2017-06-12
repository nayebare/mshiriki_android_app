package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzasf extends zza implements Result {
    public static final Creator<zzasf> CREATOR;
    final int mVersionCode;
    private final Status zzahq;
    private final List<zzasd> zzbmJ;

    static {
        CREATOR = new zzasg();
    }

    zzasf(int i, Status status, List<zzasd> list) {
        this.mVersionCode = i;
        this.zzahq = status;
        this.zzbmJ = list;
    }

    public Status getStatus() {
        return this.zzahq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzasg.zza(this, parcel, i);
    }

    public List<zzasd> zzIs() {
        return this.zzbmJ;
    }
}
