package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T> implements MetadataField<T> {
    private final String zzaNl;
    private final Set<String> zzaNm;
    private final Set<String> zzaNn;
    private final int zzaNo;

    protected zza(String str, int i) {
        this.zzaNl = (String) zzac.zzb((Object) str, (Object) "fieldName");
        this.zzaNm = Collections.singleton(str);
        this.zzaNn = Collections.emptySet();
        this.zzaNo = i;
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzaNl = (String) zzac.zzb((Object) str, (Object) "fieldName");
        this.zzaNm = Collections.unmodifiableSet(new HashSet(collection));
        this.zzaNn = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzaNo = i;
    }

    public final String getName() {
        return this.zzaNl;
    }

    public String toString() {
        return this.zzaNl;
    }

    public final Collection<String> zzAC() {
        return this.zzaNm;
    }

    public final T zza(DataHolder dataHolder, int i, int i2) {
        return zzb(dataHolder, i, i2) ? zzc(dataHolder, i, i2) : null;
    }

    protected abstract void zza(Bundle bundle, T t);

    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzac.zzb((Object) dataHolder, (Object) "dataHolder");
        zzac.zzb((Object) metadataBundle, (Object) "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.zzc(this, zzc(dataHolder, i, i2));
        }
    }

    public final void zza(T t, Bundle bundle) {
        zzac.zzb((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            zza(bundle, (Object) t);
        }
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String str : this.zzaNm) {
            if (dataHolder.zzdj(str)) {
                if (dataHolder.zzi(str, i, i2)) {
                }
            }
            return false;
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i, int i2);

    public final T zzs(Bundle bundle) {
        zzac.zzb((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? zzt(bundle) : null;
    }

    protected abstract T zzt(Bundle bundle);
}
