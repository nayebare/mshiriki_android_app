package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class zzalj {
    public static final zza zzaOs;
    public static final zzb zzaOt;
    public static final zzd zzaOu;
    public static final zzc zzaOv;
    public static final zzf zzaOw;
    public static final zze zzaOx;

    public static class zza extends com.google.android.gms.drive.metadata.internal.zze implements SortableMetadataField<Date> {
        public zza(String str, int i) {
            super(str, i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zze implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends com.google.android.gms.drive.metadata.internal.zze implements SortableMetadataField<Date> {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zze implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends com.google.android.gms.drive.metadata.internal.zze implements SortableMetadataField<Date> {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zze implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    static {
        zzaOs = new zza("created", 4100000);
        zzaOt = new zzb("lastOpenedTime", 4300000);
        zzaOu = new zzd("modified", 4100000);
        zzaOv = new zzc("modifiedByMe", 4100000);
        zzaOw = new zzf("sharedWithMe", 4100000);
        zzaOx = new zze("recency", 8000000);
    }
}
