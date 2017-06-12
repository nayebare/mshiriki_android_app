package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzr extends zza<String> {
    public zzr(String str, int i) {
        super(str, i);
    }

    protected String zzA(Bundle bundle) {
        return bundle.getString(getName());
    }

    protected /* synthetic */ void zza(Bundle bundle, Object obj) {
        zze(bundle, (String) obj);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzi(dataHolder, i, i2);
    }

    protected void zze(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected String zzi(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzd(getName(), i, i2);
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzA(bundle);
    }
}
