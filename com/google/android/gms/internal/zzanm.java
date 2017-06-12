package com.google.android.gms.internal;

import com.google.android.gms.internal.zzann.zza;
import java.util.concurrent.TimeUnit;

public class zzanm {
    public static <DP, DT> String zza(DP dp, zzani<DP, DT> com_google_android_gms_internal_zzani_DP__DT) {
        zzanj zzBi = com_google_android_gms_internal_zzani_DP__DT.zzBi();
        if (!zzBi.zzea(com_google_android_gms_internal_zzani_DP__DT.zzC(dp))) {
            return null;
        }
        Object zzB = com_google_android_gms_internal_zzani_DP__DT.zzB(dp);
        for (int i = 0; i < zzBi.zzD(zzB); i++) {
            String zzg = zzBi.zzg(zzB, i);
            if (com_google_android_gms_internal_zzani_DP__DT.zzd(dp, i)) {
                double zze = (double) zzBi.zze(zzB, i);
                if (zze == 1.0d) {
                    zze = (double) com_google_android_gms_internal_zzani_DP__DT.zzc(dp, i);
                } else if (zze == 2.0d) {
                    zze = com_google_android_gms_internal_zzani_DP__DT.zzb(dp, i);
                } else {
                    continue;
                }
                zza zzen = zzann.zzBT().zzen(zzg);
                if (zzen != null && !zzen.zzg(zze)) {
                    return "Field out of range";
                }
                zza zzJ = zzann.zzBT().zzJ(zzBi.zzE(zzB), zzg);
                if (zzJ != null) {
                    long zza = com_google_android_gms_internal_zzani_DP__DT.zza(dp, TimeUnit.NANOSECONDS);
                    if (zza == 0) {
                        return zze == 0.0d ? null : "DataPoint out of range";
                    } else {
                        if (!zzJ.zzg(zze / ((double) zza))) {
                            return "DataPoint out of range";
                        }
                    }
                } else {
                    continue;
                }
            } else if (!(zzBi.zzf(zzB, i) || zzann.zzaTV.contains(zzg))) {
                return String.valueOf(zzg).concat(" not set");
            }
        }
        return null;
    }
}
