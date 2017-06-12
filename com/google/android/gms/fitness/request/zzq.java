package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzaos;

public class zzq extends zza {
    public static final Creator<zzq> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzr();
    }

    zzq(int i, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = i;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzq(PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = 1;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    private boolean zzb(zzq com_google_android_gms_fitness_request_zzq) {
        return zzaa.equal(this.mPendingIntent, com_google_android_gms_fitness_request_zzq.mPendingIntent);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzq) && zzb((zzq) obj));
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
        return zzaa.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return "DataUpdateListenerUnregistrationRequest";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
