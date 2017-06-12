package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzads extends zzd<zzadr> {
    public zzads(DataHolder dataHolder) {
        super(dataHolder, zzadr.CREATOR);
    }

    public /* synthetic */ Object get(int i) {
        return zzdt(i);
    }

    public /* synthetic */ SafeParcelable zzcB(int i) {
        return (zzadr) get(i);
    }

    public zzadr zzdt(int i) {
        return (zzadr) super.zzcB(i);
    }
}
