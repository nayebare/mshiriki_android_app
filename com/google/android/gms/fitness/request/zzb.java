package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzaos;

public class zzb extends zza {
    public static final Creator<zzb> CREATOR;
    private final int mVersionCode;
    private final String zzaUQ;
    private final BleDevice zzaUR;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzc();
    }

    zzb(int i, String str, BleDevice bleDevice, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaUQ = str;
        this.zzaUR = bleDevice;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzb(String str, BleDevice bleDevice, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 4;
        this.zzaUQ = str;
        this.zzaUR = bleDevice;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public String getDeviceAddress() {
        return this.zzaUQ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.zzaUQ, this.zzaUR});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public BleDevice zzBX() {
        return this.zzaUR;
    }
}
