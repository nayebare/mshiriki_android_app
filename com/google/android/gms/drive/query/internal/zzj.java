package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import java.util.List;

public interface zzj<F> {
    F zzAT();

    F zzAU();

    <T> F zzb(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t);

    <T> F zzb(zzx com_google_android_gms_drive_query_internal_zzx, MetadataField<T> metadataField, T t);

    F zzb(zzx com_google_android_gms_drive_query_internal_zzx, List<F> list);

    F zzdU(String str);

    F zze(MetadataField<?> metadataField);

    <T> F zze(MetadataField<T> metadataField, T t);

    F zzz(F f);
}
