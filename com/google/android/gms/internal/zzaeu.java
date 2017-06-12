package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaeu extends zza {
    public static final Creator<zzaeu> CREATOR;
    public final int type;
    public final int versionCode;
    public final String zzaHZ;
    public final zzaec zzaIg;
    public zzaeq zzaIh;
    private final com.google.android.gms.awareness.fence.zza zzaIi;
    public final PendingIntent zzaIj;
    public final long zzaIk;
    public final long zzaIl;

    static {
        CREATOR = new zzaev();
    }

    zzaeu(int i, int i2, zzaec com_google_android_gms_internal_zzaec, IBinder iBinder, PendingIntent pendingIntent, String str, long j, long j2) {
        this.versionCode = i;
        this.type = i2;
        this.zzaIg = com_google_android_gms_internal_zzaec;
        this.zzaIh = iBinder == null ? null : zzaeq.zza.zzbF(iBinder);
        this.zzaIi = null;
        this.zzaIj = pendingIntent;
        this.zzaHZ = str;
        this.zzaIk = j;
        this.zzaIl = j2;
    }

    private zzaeu(int i, zzaec com_google_android_gms_internal_zzaec, com.google.android.gms.awareness.fence.zza com_google_android_gms_awareness_fence_zza, PendingIntent pendingIntent, String str, long j, long j2) {
        this.versionCode = 1;
        this.type = i;
        this.zzaIg = com_google_android_gms_internal_zzaec;
        this.zzaIh = null;
        this.zzaIi = com_google_android_gms_awareness_fence_zza;
        this.zzaIj = pendingIntent;
        this.zzaHZ = str;
        this.zzaIk = j;
        this.zzaIl = j2;
    }

    public static final zzaeu zza(PendingIntent pendingIntent) {
        return new zzaeu(4, null, null, pendingIntent, null, -1, -1);
    }

    public static final zzaeu zza(String str, zzaee com_google_android_gms_internal_zzaee, PendingIntent pendingIntent) {
        return new zzaeu(2, zzaec.zza(str, com_google_android_gms_internal_zzaee), null, pendingIntent, null, -1, -1);
    }

    public static final zzaeu zzdG(String str) {
        return new zzaeu(5, null, null, null, str, -1, -1);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaev.zza(this, parcel, i);
    }

    void zzb(zzcg<com.google.android.gms.awareness.fence.zza, zzaeb> com_google_android_gms_internal_zzcg_com_google_android_gms_awareness_fence_zza__com_google_android_gms_internal_zzaeb) {
        if (this.zzaIh == null && this.zzaIi != null) {
            this.zzaIh = (zzaeq) com_google_android_gms_internal_zzcg_com_google_android_gms_awareness_fence_zza__com_google_android_gms_internal_zzaeb.zzc(this.zzaIi);
        }
    }

    IBinder zzzs() {
        return this.zzaIh == null ? null : this.zzaIh.asBinder();
    }
}
