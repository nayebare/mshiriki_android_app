package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent extends zza implements ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR;
    final int mVersionCode;
    final DriveId zzaJj;
    final int zzaKg;

    static {
        CREATOR = new zza();
    }

    ChangeEvent(int i, DriveId driveId, int i2) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaKg = i2;
    }

    public DriveId getDriveId() {
        return this.zzaJj;
    }

    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzaKg & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzaKg & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzaKg & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.zzaJj, Integer.valueOf(this.zzaKg)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
