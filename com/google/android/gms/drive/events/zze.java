package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class zze extends zza {
    public static final Creator<zze> CREATOR;
    final int mVersionCode;
    final int zzaKi;
    final boolean zzaKj;
    final List<DriveSpace> zzaKk;
    private final Set<DriveSpace> zzaKl;

    static {
        CREATOR = new zzf();
    }

    zze(int i, int i2, boolean z, List<DriveSpace> list) {
        this(i, i2, z, list, list == null ? null : new HashSet(list));
    }

    private zze(int i, int i2, boolean z, List<DriveSpace> list, Set<DriveSpace> set) {
        this.mVersionCode = i;
        this.zzaKi = i2;
        this.zzaKj = z;
        this.zzaKk = list;
        this.zzaKl = set;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zze com_google_android_gms_drive_events_zze = (zze) obj;
        return zzaa.equal(this.zzaKl, com_google_android_gms_drive_events_zze.zzaKl) && this.zzaKi == com_google_android_gms_drive_events_zze.zzaKi && this.zzaKj == com_google_android_gms_drive_events_zze.zzaKj;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaKl, Integer.valueOf(this.zzaKi), Boolean.valueOf(this.zzaKj));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[]{Integer.valueOf(this.zzaKi), Boolean.valueOf(this.zzaKj), this.zzaKk});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
