package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzn<T> extends zza {
    public static final zzo CREATOR;
    final int mVersionCode;
    final MetadataBundle zzaON;
    final MetadataField<T> zzaOO;

    static {
        CREATOR = new zzo();
    }

    zzn(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaON = metadataBundle;
        this.zzaOO = zzi.zza(metadataBundle);
    }

    public zzn(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, MetadataBundle.zzb(searchableMetadataField, t));
    }

    public T getValue() {
        return this.zzaON.zza(this.zzaOO);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public <F> F zza(zzj<F> com_google_android_gms_drive_query_internal_zzj_F) {
        return com_google_android_gms_drive_query_internal_zzj_F.zze(this.zzaOO, getValue());
    }
}
