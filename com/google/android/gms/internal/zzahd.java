package com.google.android.gms.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzahd extends Metadata {
    private final MetadataBundle zzaLk;

    public zzahd(MetadataBundle metadataBundle) {
        this.zzaLk = metadataBundle;
    }

    public /* synthetic */ Object freeze() {
        return zzzO();
    }

    public boolean isDataValid() {
        return this.zzaLk != null;
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzaLk);
        return new StringBuilder(String.valueOf(valueOf).length() + 17).append("Metadata [mImpl=").append(valueOf).append("]").toString();
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzaLk.zza(metadataField);
    }

    public Metadata zzzO() {
        return new zzahd(this.zzaLk.zzAJ());
    }
}
