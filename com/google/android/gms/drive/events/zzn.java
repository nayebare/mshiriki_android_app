package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzafz;

public final class zzn extends zza implements DriveEvent {
    public static final Creator<zzn> CREATOR;
    final int mVersionCode;
    final zzafz zzaKB;

    static {
        CREATOR = new zzo();
    }

    zzn(int i, zzafz com_google_android_gms_internal_zzafz) {
        this.mVersionCode = i;
        this.zzaKB = com_google_android_gms_internal_zzafz;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return zzaa.equal(this.zzaKB, ((zzn) obj).zzaKB);
    }

    public int getType() {
        return 8;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaKB);
    }

    public String toString() {
        return String.format("TransferProgressEvent[%s]", new Object[]{this.zzaKB.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public zzafz zzAe() {
        return this.zzaKB;
    }
}
