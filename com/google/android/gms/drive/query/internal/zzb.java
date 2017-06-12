package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzb<T> extends zza {
    public static final zzc CREATOR;
    final int mVersionCode;
    final zzx zzaOM;
    final MetadataBundle zzaON;
    final MetadataField<T> zzaOO;

    static {
        CREATOR = new zzc();
    }

    zzb(int i, zzx com_google_android_gms_drive_query_internal_zzx, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaOM = com_google_android_gms_drive_query_internal_zzx;
        this.zzaON = metadataBundle;
        this.zzaOO = zzi.zza(metadataBundle);
    }

    public zzb(zzx com_google_android_gms_drive_query_internal_zzx, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, com_google_android_gms_drive_query_internal_zzx, MetadataBundle.zzb(searchableMetadataField, t));
    }

    public T getValue() {
        return this.zzaON.zza(this.zzaOO);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public <F> F zza(zzj<F> com_google_android_gms_drive_query_internal_zzj_F) {
        return com_google_android_gms_drive_query_internal_zzj_F.zzb(this.zzaOM, this.zzaOO, getValue());
    }
}
