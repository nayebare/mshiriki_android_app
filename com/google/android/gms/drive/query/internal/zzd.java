package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzd extends zza {
    public static final Creator<zzd> CREATOR;
    final int mVersionCode;
    final MetadataBundle zzaON;
    private final MetadataField<?> zzaOO;

    static {
        CREATOR = new zze();
    }

    zzd(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaON = metadataBundle;
        this.zzaOO = zzi.zza(metadataBundle);
    }

    public zzd(SearchableMetadataField<?> searchableMetadataField) {
        this(1, MetadataBundle.zzb(searchableMetadataField, null));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public <T> T zza(zzj<T> com_google_android_gms_drive_query_internal_zzj_T) {
        return com_google_android_gms_drive_query_internal_zzj_T.zze(this.zzaOO);
    }
}
