package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzaos;

public class zzbb extends zza {
    public static final Creator<zzbb> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzaos zzaUS;
    private final int zzaWg;

    static {
        CREATOR = new zzbc();
    }

    zzbb(int i, PendingIntent pendingIntent, IBinder iBinder, int i2) {
        this.mVersionCode = i;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = iBinder == null ? null : zzaos.zza.zzcJ(iBinder);
        this.zzaWg = i2;
    }

    public zzbb(PendingIntent pendingIntent, zzaos com_google_android_gms_internal_zzaos, int i) {
        this.mVersionCode = 6;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = com_google_android_gms_internal_zzaos;
        this.zzaWg = i;
    }

    private boolean zzb(zzbb com_google_android_gms_fitness_request_zzbb) {
        return this.zzaWg == com_google_android_gms_fitness_request_zzbb.zzaWg && zzaa.equal(this.mPendingIntent, com_google_android_gms_fitness_request_zzbb.mPendingIntent);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzbb) && zzb((zzbb) obj));
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

    public int hashCode() {
        return zzaa.hashCode(this.mPendingIntent, Integer.valueOf(this.zzaWg));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaWg)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }

    public int zzCx() {
        return this.zzaWg;
    }
}
