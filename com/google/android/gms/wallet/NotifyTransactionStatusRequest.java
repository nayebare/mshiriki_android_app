package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public final class NotifyTransactionStatusRequest extends zza {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR;
    final int mVersionCode;
    int status;
    String zzbNX;
    String zzbPj;

    static {
        CREATOR = new zzp();
    }

    NotifyTransactionStatusRequest() {
        this.mVersionCode = 1;
    }

    NotifyTransactionStatusRequest(int i, String str, int i2, String str2) {
        this.mVersionCode = i;
        this.zzbNX = str;
        this.status = i2;
        this.zzbPj = str2;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder(notifyTransactionStatusRequest, null);
    }

    public String getDetailedReason() {
        return this.zzbPj;
    }

    public String getGoogleTransactionId() {
        return this.zzbNX;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
