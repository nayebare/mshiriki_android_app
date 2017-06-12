package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;
import com.google.firebase.database.DataSnapshot;

public class zzbnz implements zzboa {
    private final zzbme zzcfE;
    private final zza zzcfG;
    private final DataSnapshot zzcfK;
    private final String zzcfL;

    public zzbnz(zza com_google_android_gms_internal_zzboa_zza, zzbme com_google_android_gms_internal_zzbme, DataSnapshot dataSnapshot, String str) {
        this.zzcfG = com_google_android_gms_internal_zzboa_zza;
        this.zzcfE = com_google_android_gms_internal_zzbme;
        this.zzcfK = dataSnapshot;
        this.zzcfL = str;
    }

    public String toString() {
        if (this.zzcfG == zza.VALUE) {
            String valueOf = String.valueOf(zzVc());
            String valueOf2 = String.valueOf(this.zzcfG);
            String valueOf3 = String.valueOf(this.zzcfK.getValue(true));
            return new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append(": ").append(valueOf2).append(": ").append(valueOf3).toString();
        }
        valueOf = String.valueOf(zzVc());
        valueOf2 = String.valueOf(this.zzcfG);
        valueOf3 = String.valueOf(this.zzcfK.getKey());
        String valueOf4 = String.valueOf(this.zzcfK.getValue(true));
        return new StringBuilder((((String.valueOf(valueOf).length() + 10) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(valueOf).append(": ").append(valueOf2).append(": { ").append(valueOf3).append(": ").append(valueOf4).append(" }").toString();
    }

    public zzbmj zzVc() {
        zzbmj zzVc = this.zzcfK.getRef().zzVc();
        return this.zzcfG == zza.VALUE ? zzVc : zzVc.zzXk();
    }

    public void zzYj() {
        this.zzcfE.zza(this);
    }

    public zza zzYl() {
        return this.zzcfG;
    }

    public DataSnapshot zzYo() {
        return this.zzcfK;
    }

    public String zzYp() {
        return this.zzcfL;
    }
}
