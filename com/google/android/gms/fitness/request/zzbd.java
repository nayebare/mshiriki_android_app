package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzaos;
import java.util.concurrent.TimeUnit;

public class zzbd extends zza {
    public static final Creator<zzbd> CREATOR;
    private final int mVersionCode;
    private final Session zzaQL;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzbe();
    }

    zzbd(int i, Session session, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaQL = session;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzbd(Session session, zzaos com_google_android_gms_internal_zzaos) {
        zzac.zzb(session.getStartTime(TimeUnit.MILLISECONDS) < System.currentTimeMillis(), (Object) "Cannot start a session in the future");
        zzac.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.mVersionCode = 3;
        this.zzaQL = session;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    private boolean zzb(zzbd com_google_android_gms_fitness_request_zzbd) {
        return zzaa.equal(this.zzaQL, com_google_android_gms_fitness_request_zzbd.zzaQL);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzbd) && zzb((zzbd) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public Session getSession() {
        return this.zzaQL;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaQL);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("session", this.zzaQL).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbe.zza(this, parcel, i);
    }
}
