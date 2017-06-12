package com.google.android.gms.drive.query;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.zzj;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.List;

public class zzc implements zzj<String> {
    public String zzAR() {
        return "all()";
    }

    public String zzAS() {
        return "ownedByMe()";
    }

    public /* synthetic */ Object zzAT() {
        return zzAS();
    }

    public /* synthetic */ Object zzAU() {
        return zzAR();
    }

    public <T> String zza(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t) {
        return String.format("contains(%s,%s)", new Object[]{com_google_android_gms_drive_metadata_zzb_T.getName(), t});
    }

    public <T> String zza(zzx com_google_android_gms_drive_query_internal_zzx, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{com_google_android_gms_drive_query_internal_zzx.getTag(), metadataField.getName(), t});
    }

    public String zza(zzx com_google_android_gms_drive_query_internal_zzx, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(com_google_android_gms_drive_query_internal_zzx.getTag()).concat("("));
        String str = BuildConfig.FLAVOR;
        String str2 = str;
        for (String str3 : list) {
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            str2 = ",";
        }
        return stringBuilder.append(")").toString();
    }

    public /* synthetic */ Object zzb(zzb com_google_android_gms_drive_metadata_zzb, Object obj) {
        return zza(com_google_android_gms_drive_metadata_zzb, obj);
    }

    public /* synthetic */ Object zzb(zzx com_google_android_gms_drive_query_internal_zzx, MetadataField metadataField, Object obj) {
        return zza(com_google_android_gms_drive_query_internal_zzx, metadataField, obj);
    }

    public /* synthetic */ Object zzb(zzx com_google_android_gms_drive_query_internal_zzx, List list) {
        return zza(com_google_android_gms_drive_query_internal_zzx, list);
    }

    public String zzd(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    public <T> String zzd(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    public String zzdS(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    public String zzdT(String str) {
        return String.format("fullTextSearch(%s)", new Object[]{str});
    }

    public /* synthetic */ Object zzdU(String str) {
        return zzdT(str);
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzd(metadataField);
    }

    public /* synthetic */ Object zze(MetadataField metadataField, Object obj) {
        return zzd(metadataField, obj);
    }

    public /* synthetic */ Object zzz(Object obj) {
        return zzdS((String) obj);
    }
}
