package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzk implements zzj<Boolean> {
    private Boolean zzaOZ;

    private zzk() {
        this.zzaOZ = Boolean.valueOf(false);
    }

    public static boolean zza(Filter filter) {
        return filter == null ? false : ((Boolean) filter.zza(new zzk())).booleanValue();
    }

    public /* synthetic */ Object zzAT() {
        return zzAW();
    }

    public /* synthetic */ Object zzAU() {
        return zzAV();
    }

    public Boolean zzAV() {
        return this.zzaOZ;
    }

    public Boolean zzAW() {
        return this.zzaOZ;
    }

    public /* synthetic */ Object zzb(zzb com_google_android_gms_drive_metadata_zzb, Object obj) {
        return zzc(com_google_android_gms_drive_metadata_zzb, obj);
    }

    public /* synthetic */ Object zzb(zzx com_google_android_gms_drive_query_internal_zzx, MetadataField metadataField, Object obj) {
        return zzc(com_google_android_gms_drive_query_internal_zzx, metadataField, obj);
    }

    public /* synthetic */ Object zzb(zzx com_google_android_gms_drive_query_internal_zzx, List list) {
        return zzc(com_google_android_gms_drive_query_internal_zzx, list);
    }

    public <T> Boolean zzc(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t) {
        return this.zzaOZ;
    }

    public <T> Boolean zzc(zzx com_google_android_gms_drive_query_internal_zzx, MetadataField<T> metadataField, T t) {
        return this.zzaOZ;
    }

    public Boolean zzc(zzx com_google_android_gms_drive_query_internal_zzx, List<Boolean> list) {
        return this.zzaOZ;
    }

    public Boolean zzd(Boolean bool) {
        return this.zzaOZ;
    }

    public /* synthetic */ Object zzdU(String str) {
        return zzdV(str);
    }

    public Boolean zzdV(String str) {
        if (!str.isEmpty()) {
            this.zzaOZ = Boolean.valueOf(true);
        }
        return this.zzaOZ;
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzf(metadataField);
    }

    public /* synthetic */ Object zze(MetadataField metadataField, Object obj) {
        return zzf(metadataField, obj);
    }

    public Boolean zzf(MetadataField<?> metadataField) {
        return this.zzaOZ;
    }

    public <T> Boolean zzf(MetadataField<T> metadataField, T t) {
        return this.zzaOZ;
    }

    public /* synthetic */ Object zzz(Object obj) {
        return zzd((Boolean) obj);
    }
}
