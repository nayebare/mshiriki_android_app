package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;

public class zzbmm {
    public String zzaFs;
    public String zzbZA;
    public boolean zzbZB;
    public String zzcdm;

    public String toString() {
        String str = this.zzbZB ? "s" : BuildConfig.FLAVOR;
        String str2 = this.zzbZA;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
