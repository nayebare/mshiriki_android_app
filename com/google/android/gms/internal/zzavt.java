package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.nearby.messages.EddystoneUid;
import com.google.android.gms.nearby.messages.IBeaconId;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzavt extends zza {
    public static final Creator<zzavt> CREATOR;
    public static final zzavt zzbyo;
    final int mVersionCode;
    private final int zzanR;
    final byte[] zzbyp;
    private final EddystoneUid zzbyq;
    private final IBeaconId zzbyr;

    static {
        CREATOR = new zzavu();
        zzbyo = new zzavt();
    }

    private zzavt() {
        this(1, 1, null);
    }

    zzavt(int i, int i2, byte[] bArr) {
        IBeaconId iBeaconId = null;
        this.mVersionCode = i;
        this.zzanR = i2;
        this.zzbyp = bArr;
        this.zzbyq = i2 == 2 ? new EddystoneUid(bArr) : null;
        if (i2 == 3) {
            iBeaconId = new IBeaconId(bArr);
        }
        this.zzbyr = iBeaconId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzavt)) {
            return false;
        }
        zzavt com_google_android_gms_internal_zzavt = (zzavt) obj;
        return zzaa.equal(Integer.valueOf(this.zzanR), Integer.valueOf(com_google_android_gms_internal_zzavt.zzanR)) && zzaa.equal(this.zzbyp, com_google_android_gms_internal_zzavt.zzbyp);
    }

    public int getType() {
        return this.zzanR;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzanR), this.zzbyp);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("NearbyDeviceId{");
        switch (this.zzanR) {
            case MessageApi.FILTER_PREFIX /*1*/:
                append.append("UNKNOWN");
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                append.append("eddystoneUid=").append(this.zzbyq);
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                append.append("iBeaconId=").append(this.zzbyr);
                break;
        }
        append.append("}");
        return append.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavu.zza(this, parcel, i);
    }
}
