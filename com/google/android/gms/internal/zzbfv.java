package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzbfv {
    private static final String zzbGK;
    private static final Integer zzbKH;
    private final Object zzYe;
    private final int zzanR;
    private final List<Integer> zzbKI;
    private final boolean zzbKJ;

    public static class zza {
        private final Object zzYe;
        private final List<Integer> zzbKI;
        private final Integer zzbKK;
        private boolean zzbKL;

        public zza(int i, Object obj) {
            this.zzbKI = new ArrayList();
            this.zzbKL = false;
            this.zzbKK = Integer.valueOf(i);
            this.zzYe = obj;
        }

        public zzbfv zzRD() {
            zzac.zzw(this.zzbKK);
            zzac.zzw(this.zzYe);
            return new zzbfv(this.zzYe, this.zzbKI, this.zzbKL, null);
        }

        public zza zzaP(boolean z) {
            this.zzbKL = z;
            return this;
        }

        public zza zzmZ(int i) {
            this.zzbKI.add(Integer.valueOf(i));
            return this;
        }
    }

    static {
        zzbGK = new String(BuildConfig.FLAVOR);
        zzbKH = Integer.valueOf(0);
    }

    private zzbfv(Integer num, Object obj, List<Integer> list, boolean z) {
        this.zzanR = num.intValue();
        this.zzYe = obj;
        this.zzbKI = Collections.unmodifiableList(list);
        this.zzbKJ = z;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzbfv) && ((zzbfv) obj).getValue().equals(this.zzYe);
    }

    public int getType() {
        return this.zzanR;
    }

    public Object getValue() {
        return this.zzYe;
    }

    public int hashCode() {
        return this.zzYe.hashCode();
    }

    public String toString() {
        if (this.zzYe != null) {
            return this.zzYe.toString();
        }
        zzayx.m23e("Fail to convert a null object to string");
        return zzbGK;
    }

    public List<Integer> zzRC() {
        return this.zzbKI;
    }
}
