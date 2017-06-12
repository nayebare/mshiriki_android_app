package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class zzayk implements zzayp {
    private static final Object zzbCG;
    private static zzayk zzbHA;
    private static final Set<String> zzbHD;
    private zzazd zzbHB;
    private zzayq zzbHC;

    static {
        zzbCG = new Object();
        zzbHD = new HashSet(Arrays.asList(new String[]{"GET", "HEAD", "POST", "PUT"}));
    }

    private zzayk(Context context) {
        this(zzayr.zzbN(context), new zzazh());
    }

    zzayk(zzayq com_google_android_gms_internal_zzayq, zzazd com_google_android_gms_internal_zzazd) {
        this.zzbHC = com_google_android_gms_internal_zzayq;
        this.zzbHB = com_google_android_gms_internal_zzazd;
    }

    public static zzayp zzbM(Context context) {
        zzayp com_google_android_gms_internal_zzayp;
        synchronized (zzbCG) {
            if (zzbHA == null) {
                zzbHA = new zzayk(context);
            }
            com_google_android_gms_internal_zzayp = zzbHA;
        }
        return com_google_android_gms_internal_zzayp;
    }

    public void dispatch() {
        zzazj.zzQM().dispatch();
    }

    public boolean zza(String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
        if (str2 != null && !zzbHD.contains(str2)) {
            zzayx.zzbe(String.format("Unsupport http method %s. Drop the hit.", new Object[]{str2}));
            return false;
        } else if (zzazc.zzQB().isPreview() || this.zzbHB.zzpv()) {
            this.zzbHC.zzb(str, str2, str3, map, str4);
            return true;
        } else {
            zzayx.zzbe("Too many hits sent too quickly (rate throttled).");
            return false;
        }
    }

    public boolean zzah(String str, String str2) {
        return zza(str, null, str2, null, null);
    }

    public boolean zzhi(String str) {
        return zza(str, null, null, null, null);
    }
}
