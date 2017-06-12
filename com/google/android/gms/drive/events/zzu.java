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

public final class zzu extends zza {
    public static final Creator<zzu> CREATOR;
    final int mVersionCode;
    final List<DriveSpace> zzaKk;
    private final Set<DriveSpace> zzaKl;

    static {
        CREATOR = new zzv();
    }

    zzu(int i, List<DriveSpace> list) {
        this(i, list, list == null ? null : new HashSet(list));
    }

    private zzu(int i, List<DriveSpace> list, Set<DriveSpace> set) {
        this.mVersionCode = i;
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
        return zzaa.equal(this.zzaKl, ((zzu) obj).zzaKl);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaKl);
    }

    public String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", new Object[]{this.zzaKk});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }
}
