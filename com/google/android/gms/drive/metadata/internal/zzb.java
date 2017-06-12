package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public class zzb extends zza<Boolean> {
    public zzb(String str, int i) {
        super(str, i);
    }

    public zzb(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void zza(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zze(dataHolder, i, i2);
    }

    protected Boolean zze(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.zze(getName(), i, i2));
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzu(bundle);
    }

    protected Boolean zzu(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
