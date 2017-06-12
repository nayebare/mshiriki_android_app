package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzalh;
import com.google.android.gms.internal.zzali;
import com.google.android.gms.internal.zzalj;
import com.google.android.gms.internal.zzall;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzf {
    private static final Map<String, MetadataField<?>> zzaNu;
    private static final Map<String, zza> zzaNv;

    public interface zza {
        String zzAH();

        void zzb(DataHolder dataHolder);
    }

    static {
        zzaNu = new HashMap();
        zzaNv = new HashMap();
        zzb(zzalh.zzaNA);
        zzb(zzalh.zzaOg);
        zzb(zzalh.zzaNX);
        zzb(zzalh.zzaOe);
        zzb(zzalh.zzaOh);
        zzb(zzalh.zzaNN);
        zzb(zzalh.zzaNM);
        zzb(zzalh.zzaNO);
        zzb(zzalh.zzaNP);
        zzb(zzalh.zzaNQ);
        zzb(zzalh.zzaNK);
        zzb(zzalh.zzaNS);
        zzb(zzalh.zzaNT);
        zzb(zzalh.zzaNU);
        zzb(zzalh.zzaOc);
        zzb(zzalh.zzaNB);
        zzb(zzalh.zzaNZ);
        zzb(zzalh.zzaND);
        zzb(zzalh.zzaNL);
        zzb(zzalh.zzaNE);
        zzb(zzalh.zzaNF);
        zzb(zzalh.zzaNG);
        zzb(zzalh.zzaNH);
        zzb(zzalh.zzaNW);
        zzb(zzalh.zzaNR);
        zzb(zzalh.zzaNY);
        zzb(zzalh.zzaOa);
        zzb(zzalh.zzaOb);
        zzb(zzalh.zzaOd);
        zzb(zzalh.zzaOi);
        zzb(zzalh.zzaOj);
        zzb(zzalh.zzaNJ);
        zzb(zzalh.zzaNI);
        zzb(zzalh.zzaOf);
        zzb(zzalh.zzaNV);
        zzb(zzalh.zzaNC);
        zzb(zzalh.zzaOk);
        zzb(zzalh.zzaOl);
        zzb(zzalh.zzaOm);
        zzb(zzalh.zzaOn);
        zzb(zzalh.zzaOo);
        zzb(zzalh.zzaOp);
        zzb(zzalh.zzaOq);
        zzb(zzalj.zzaOs);
        zzb(zzalj.zzaOu);
        zzb(zzalj.zzaOv);
        zzb(zzalj.zzaOw);
        zzb(zzalj.zzaOt);
        zzb(zzalj.zzaOx);
        zzb(zzall.zzaOz);
        zzb(zzall.zzaOA);
        zzn com_google_android_gms_drive_metadata_internal_zzn = zzalh.zzaOc;
        zza(zzn.zzaNz);
        zza(zzali.zzaOr);
    }

    public static Collection<MetadataField<?>> zzAG() {
        return Collections.unmodifiableCollection(zzaNu.values());
    }

    public static void zza(DataHolder dataHolder) {
        for (zza zzb : zzaNv.values()) {
            zzb.zzb(dataHolder);
        }
    }

    private static void zza(zza com_google_android_gms_drive_metadata_internal_zzf_zza) {
        if (zzaNv.put(com_google_android_gms_drive_metadata_internal_zzf_zza.zzAH(), com_google_android_gms_drive_metadata_internal_zzf_zza) != null) {
            String valueOf = String.valueOf(com_google_android_gms_drive_metadata_internal_zzf_zza.zzAH());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("A cleaner for key ").append(valueOf).append(" has already been registered").toString());
        }
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzaNu.containsKey(metadataField.getName())) {
            String str = "Duplicate field name registered: ";
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        zzaNu.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzdN(String str) {
        return (MetadataField) zzaNu.get(str);
    }
}
