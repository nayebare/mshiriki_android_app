package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.drive.DriveId;

public class zzafz extends zza {
    public static final Creator<zzafz> CREATOR;
    final int mVersionCode;
    final int zzJh;
    final DriveId zzaJj;
    final int zzaKC;
    final long zzaKF;
    final long zzaKG;

    static {
        CREATOR = new zzaga();
    }

    zzafz(int i, int i2, DriveId driveId, int i3, long j, long j2) {
        this.mVersionCode = i;
        this.zzaKC = i2;
        this.zzaJj = driveId;
        this.zzJh = i3;
        this.zzaKF = j;
        this.zzaKG = j2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzafz com_google_android_gms_internal_zzafz = (zzafz) obj;
        return this.zzaKC == com_google_android_gms_internal_zzafz.zzaKC && zzaa.equal(this.zzaJj, com_google_android_gms_internal_zzafz.zzaJj) && this.zzJh == com_google_android_gms_internal_zzafz.zzJh && this.zzaKF == com_google_android_gms_internal_zzafz.zzaKF && this.zzaKG == com_google_android_gms_internal_zzafz.zzaKG;
    }

    public long getBytesTransferred() {
        return this.zzaKF;
    }

    public DriveId getDriveId() {
        return this.zzaJj;
    }

    public int getStatus() {
        return this.zzJh;
    }

    public long getTotalBytes() {
        return this.zzaKG;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaKC), this.zzaJj, Integer.valueOf(this.zzJh), Long.valueOf(this.zzaKF), Long.valueOf(this.zzaKG));
    }

    public String toString() {
        return String.format("TransferProgressData[TransferType: %d, DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[]{Integer.valueOf(this.zzaKC), this.zzaJj, Integer.valueOf(this.zzJh), Long.valueOf(this.zzaKF), Long.valueOf(this.zzaKG)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaga.zza(this, parcel, i);
    }

    public int zzAf() {
        return this.zzaKC;
    }
}
