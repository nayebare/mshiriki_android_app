package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Locale;

public final class zzp extends zza {
    public static final Creator<zzp> CREATOR;
    final int mVersionCode;
    final int zzaKC;

    static {
        CREATOR = new zzq();
    }

    zzp(int i, int i2) {
        this.mVersionCode = i;
        this.zzaKC = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return zzaa.equal(Integer.valueOf(this.zzaKC), Integer.valueOf(((zzp) obj).zzaKC));
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaKC));
    }

    public String toString() {
        return String.format(Locale.US, "TransferProgressOptions[type=%d]", new Object[]{Integer.valueOf(this.zzaKC)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
