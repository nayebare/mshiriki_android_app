package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzh extends zza<Long> {
    public zzh(String str, int i) {
        super(str, i);
    }

    protected void zza(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzh(dataHolder, i, i2);
    }

    protected Long zzh(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.zzb(getName(), i, i2));
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzx(bundle);
    }

    protected Long zzx(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
