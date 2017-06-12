package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Locale;

public final class zzb extends zza implements DriveEvent {
    public static final Creator<zzb> CREATOR;
    final int mVersionCode;
    final zze zzaKh;
    final String zzaht;

    static {
        CREATOR = new zzc();
    }

    zzb(int i, String str, zze com_google_android_gms_drive_events_zze) {
        this.mVersionCode = i;
        this.zzaht = str;
        this.zzaKh = com_google_android_gms_drive_events_zze;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzb com_google_android_gms_drive_events_zzb = (zzb) obj;
        return zzaa.equal(this.zzaKh, com_google_android_gms_drive_events_zzb.zzaKh) && zzaa.equal(this.zzaht, com_google_android_gms_drive_events_zzb.zzaht);
    }

    public int getType() {
        return 4;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaKh, this.zzaht);
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[]{this.zzaKh});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
