package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.zzb;
import com.google.android.gms.drive.metadata.internal.zzg;

public class zzall {
    public static final MetadataField<Boolean> zzaOA;
    public static final MetadataField<Integer> zzaOz;

    static {
        zzaOz = new zzg("contentAvailability", 4300000);
        zzaOA = new zzb("isPinnable", 4300000);
    }
}
