package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzarm extends zza implements Result {
    public static final Creator<zzarm> CREATOR;
    public static final zzarm zzbkd;
    private final int mVersionCode;
    private final Status zzahq;

    static {
        zzbkd = new zzarm(Status.zzayh);
        CREATOR = new zzarn();
    }

    zzarm(int i, Status status) {
        this.mVersionCode = i;
        this.zzahq = status;
    }

    public zzarm(Status status) {
        this(1, status);
    }

    public Status getStatus() {
        return this.zzahq;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzarn.zza(this, parcel, i);
    }
}
