package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class zzp<T> extends zza {
    public static final zzq CREATOR;
    final int mVersionCode;
    final MetadataBundle zzaON;
    private final zzb<T> zzaPa;

    static {
        CREATOR = new zzq();
    }

    zzp(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaON = metadataBundle;
        this.zzaPa = (zzb) zzi.zza(metadataBundle);
    }

    public zzp(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(1, MetadataBundle.zzb(searchableCollectionMetadataField, Collections.singleton(t)));
    }

    public T getValue() {
        return ((Collection) this.zzaON.zza(this.zzaPa)).iterator().next();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    public <F> F zza(zzj<F> com_google_android_gms_drive_query_internal_zzj_F) {
        return com_google_android_gms_drive_query_internal_zzj_F.zzb(this.zzaPa, getValue());
    }
}
