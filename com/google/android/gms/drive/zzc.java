package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class zzc extends zza {
    public static final Creator<zzc> CREATOR;
    final int mVersionCode;
    final ParcelFileDescriptor zzaCS;
    final int zzaJh;
    final int zzaJi;
    final DriveId zzaJj;
    final boolean zzaJk;
    final String zzxq;

    static {
        CREATOR = new zzd();
    }

    zzc(int i, ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, DriveId driveId, boolean z, String str) {
        this.mVersionCode = i;
        this.zzaCS = parcelFileDescriptor;
        this.zzaJh = i2;
        this.zzaJi = i3;
        this.zzaJj = driveId;
        this.zzaJk = z;
        this.zzxq = str;
    }

    public DriveId getDriveId() {
        return this.zzaJj;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzaCS.getFileDescriptor());
    }

    public int getMode() {
        return this.zzaJi;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzaCS.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzaCS;
    }

    public int getRequestId() {
        return this.zzaJh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzzz() {
        return this.zzaJk;
    }
}
