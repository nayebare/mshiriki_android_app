package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;
import com.google.firebase.database.DatabaseError;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class zzbme {
    static final /* synthetic */ boolean $assertionsDisabled;
    private AtomicBoolean zzcbT;
    private zzbmf zzcbU;
    private boolean zzcbV;

    static {
        $assertionsDisabled = !zzbme.class.desiredAssertionStatus();
    }

    public zzbme() {
        this.zzcbT = new AtomicBoolean(false);
        this.zzcbV = false;
    }

    public abstract zzboe zzWD();

    public void zzXa() {
        if (this.zzcbT.compareAndSet(false, true) && this.zzcbU != null) {
            this.zzcbU.zzd(this);
            this.zzcbU = null;
        }
    }

    public boolean zzXb() {
        return this.zzcbT.get();
    }

    public boolean zzXc() {
        return this.zzcbV;
    }

    public abstract zzbme zza(zzboe com_google_android_gms_internal_zzboe);

    public abstract zzbnz zza(zzbny com_google_android_gms_internal_zzbny, zzboe com_google_android_gms_internal_zzboe);

    public void zza(zzbmf com_google_android_gms_internal_zzbmf) {
        if (!$assertionsDisabled && zzXb()) {
            throw new AssertionError();
        } else if ($assertionsDisabled || this.zzcbU == null) {
            this.zzcbU = com_google_android_gms_internal_zzbmf;
        } else {
            throw new AssertionError();
        }
    }

    public abstract void zza(zzbnz com_google_android_gms_internal_zzbnz);

    public abstract void zza(DatabaseError databaseError);

    public abstract boolean zza(zza com_google_android_gms_internal_zzboa_zza);

    public void zzba(boolean z) {
        this.zzcbV = z;
    }

    public abstract boolean zzc(zzbme com_google_android_gms_internal_zzbme);
}
