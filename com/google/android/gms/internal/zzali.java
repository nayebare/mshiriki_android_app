package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzc;
import com.google.android.gms.drive.metadata.internal.zzf.zza;
import com.google.android.gms.drive.metadata.internal.zzl;
import java.util.Arrays;

public class zzali extends zzl<AppVisibleCustomProperties> {
    public static final zza zzaOr;

    /* renamed from: com.google.android.gms.internal.zzali.1 */
    class C09571 implements zza {
        C09571() {
        }

        public String zzAH() {
            return "customPropertiesExtraHolder";
        }

        public void zzb(DataHolder dataHolder) {
            zzali.zzd(dataHolder);
        }
    }

    static {
        zzaOr = new C09571();
    }

    public zzali(int i) {
        super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), i);
    }

    private static void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zzwy().getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                LongSparseArray zzf = zzf(dataHolder2);
                SparseArray sparseArray = new SparseArray();
                for (int i = 0; i < dataHolder.getCount(); i++) {
                    AppVisibleCustomProperties.zza com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = (AppVisibleCustomProperties.zza) zzf.get(dataHolder.zzb("sqlId", i, dataHolder.zzcC(i)));
                    if (com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza != null) {
                        sparseArray.append(i, com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza.zzAE());
                    }
                }
                dataHolder.zzwy().putSparseParcelableArray("customPropertiesExtra", sparseArray);
            } finally {
                dataHolder2.close();
                dataHolder.zzwy().remove("customPropertiesExtraHolder");
            }
        }
    }

    private static void zzd(DataHolder dataHolder) {
        Bundle zzwy = dataHolder.zzwy();
        if (zzwy != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zzwy.getParcelable("customPropertiesExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zzwy.remove("customPropertiesExtraHolder");
                }
            }
        }
    }

    private static LongSparseArray<AppVisibleCustomProperties.zza> zzf(DataHolder dataHolder) {
        Bundle zzwy = dataHolder.zzwy();
        String string = zzwy.getString("entryIdColumn");
        String string2 = zzwy.getString("keyColumn");
        String string3 = zzwy.getString("visibilityColumn");
        String string4 = zzwy.getString("valueColumn");
        LongSparseArray<AppVisibleCustomProperties.zza> longSparseArray = new LongSparseArray();
        for (int i = 0; i < dataHolder.getCount(); i++) {
            int zzcC = dataHolder.zzcC(i);
            long zzb = dataHolder.zzb(string, i, zzcC);
            String zzd = dataHolder.zzd(string2, i, zzcC);
            int zzc = dataHolder.zzc(string3, i, zzcC);
            zzc com_google_android_gms_drive_metadata_internal_zzc = new zzc(new CustomPropertyKey(zzd, zzc), dataHolder.zzd(string4, i, zzcC));
            AppVisibleCustomProperties.zza com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = (AppVisibleCustomProperties.zza) longSparseArray.get(zzb);
            if (com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza == null) {
                com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = new AppVisibleCustomProperties.zza();
                longSparseArray.put(zzb, com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza);
            }
            com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza.zza(com_google_android_gms_drive_metadata_internal_zzc);
        }
        return longSparseArray;
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzl(dataHolder, i, i2);
    }

    protected AppVisibleCustomProperties zzl(DataHolder dataHolder, int i, int i2) {
        Bundle zzwy = dataHolder.zzwy();
        SparseArray sparseParcelableArray = zzwy.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (zzwy.getParcelable("customPropertiesExtraHolder") != null) {
                zzc(dataHolder);
                sparseParcelableArray = zzwy.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzaNq;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.zzaNq);
    }
}
