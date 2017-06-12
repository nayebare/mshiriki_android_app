package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.zzaos;

public class zzax extends zza {
    public static final Creator<zzax> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzaos zzaUS;
    private final zzu zzaVN;

    static {
        CREATOR = new zzay();
    }

    zzax(int i, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzaVN = iBinder == null ? null : zzu.zza.zzcg(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaUS = zzaos.zza.zzcJ(iBinder2);
    }

    public zzax(zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 4;
        this.zzaVN = com_google_android_gms_fitness_data_zzu;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzaVN});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzay.zza(this, parcel, i);
    }

    IBinder zzCt() {
        return this.zzaVN == null ? null : this.zzaVN.asBinder();
    }
}
