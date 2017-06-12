package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzl<T extends ReflectedParcelable> extends zza<T> {
    public zzl(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void zza(Bundle bundle, ReflectedParcelable reflectedParcelable) {
        bundle.putParcelable(getName(), reflectedParcelable);
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzz(bundle);
    }

    protected T zzz(Bundle bundle) {
        return (ReflectedParcelable) bundle.getParcelable(getName());
    }
}
