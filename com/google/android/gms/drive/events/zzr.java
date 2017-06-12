package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzafz;
import java.util.List;

public final class zzr extends zza implements DriveEvent {
    public static final Creator<zzr> CREATOR;
    final int mVersionCode;
    final List<zzafz> zzaKD;
    final String zzaht;

    static {
        CREATOR = new zzs();
    }

    zzr(int i, String str, List<zzafz> list) {
        this.mVersionCode = i;
        this.zzaht = str;
        this.zzaKD = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzr com_google_android_gms_drive_events_zzr = (zzr) obj;
        return zzaa.equal(this.zzaht, com_google_android_gms_drive_events_zzr.zzaht) && zzaa.equal(this.zzaKD, com_google_android_gms_drive_events_zzr.zzaKD);
    }

    public int getType() {
        return 7;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaht, this.zzaKD);
    }

    public String toString() {
        return String.format("TransferStateEvent[%s]", new Object[]{TextUtils.join("','", this.zzaKD)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }
}
