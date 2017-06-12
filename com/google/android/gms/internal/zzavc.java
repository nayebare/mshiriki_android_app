package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzavc extends zza {
    public static final Creator<zzavc> CREATOR;
    private final byte[] data;
    final int versionCode;
    private final zzauj zzbwL;
    private final zzaup zzbwO;

    static {
        CREATOR = new zzavd();
    }

    zzavc(int i, zzauj com_google_android_gms_internal_zzauj, byte[] bArr, IBinder iBinder) {
        this.versionCode = i;
        this.zzbwL = (zzauj) zzac.zzw(com_google_android_gms_internal_zzauj);
        this.data = (byte[]) zzac.zzw(bArr);
        zzac.zzw(iBinder);
        this.zzbwO = zzaup.zza.zzew(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzbwO == null ? null : this.zzbwO.asBinder();
    }

    public byte[] getData() {
        return this.data;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavd.zza(this, parcel, i);
    }

    public zzauj zzMM() {
        return this.zzbwL;
    }
}
