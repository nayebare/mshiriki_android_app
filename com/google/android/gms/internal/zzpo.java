package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzpo {
    private final String[] zzXl;
    private final double[] zzXm;
    private final double[] zzXn;
    private final int[] zzXo;
    private int zzXp;

    private zzpo(zzb com_google_android_gms_internal_zzpo_zzb) {
        int size = zzb.zza(com_google_android_gms_internal_zzpo_zzb).size();
        this.zzXl = (String[]) zzb.zzb(com_google_android_gms_internal_zzpo_zzb).toArray(new String[size]);
        this.zzXm = zzn(zzb.zza(com_google_android_gms_internal_zzpo_zzb));
        this.zzXn = zzn(zzb.zzc(com_google_android_gms_internal_zzpo_zzb));
        this.zzXo = new int[size];
        this.zzXp = 0;
    }

    private double[] zzn(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        List<zza> arrayList = new ArrayList(this.zzXl.length);
        for (int i = 0; i < this.zzXl.length; i++) {
            arrayList.add(new zza(this.zzXl[i], this.zzXn[i], this.zzXm[i], ((double) this.zzXo[i]) / ((double) this.zzXp), this.zzXo[i]));
        }
        return arrayList;
    }

    public void zza(double d) {
        this.zzXp++;
        int i = 0;
        while (i < this.zzXn.length) {
            if (this.zzXn[i] <= d && d < this.zzXm[i]) {
                int[] iArr = this.zzXo;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzXn[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
