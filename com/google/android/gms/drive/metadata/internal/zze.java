package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zzd;
import java.util.Date;

public class zze extends zzd<Date> {
    public zze(String str, int i) {
        super(str, i);
    }

    protected void zza(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzf(dataHolder, i, i2);
    }

    protected Date zzf(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.zzb(getName(), i, i2));
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzv(bundle);
    }

    protected Date zzv(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
