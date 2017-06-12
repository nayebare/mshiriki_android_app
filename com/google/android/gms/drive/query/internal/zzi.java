package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class zzi {
    static MetadataField<?> zza(MetadataBundle metadataBundle) {
        Set zzAK = metadataBundle.zzAK();
        if (zzAK.size() == 1) {
            return (MetadataField) zzAK.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
