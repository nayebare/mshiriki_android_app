package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class zzbqt {
    private boolean zzcjH;
    private int zzcjP;
    private long zzcjS;
    private Map<String, zzbqo> zzcjT;

    public zzbqt() {
        this(-1);
    }

    public zzbqt(int i, long j, Map<String, zzbqo> map, boolean z) {
        Map hashMap;
        this.zzcjP = i;
        this.zzcjS = j;
        if (map == null) {
            hashMap = new HashMap();
        }
        this.zzcjT = hashMap;
        this.zzcjH = z;
    }

    public zzbqt(long j) {
        this(0, j, null, false);
    }

    public int getLastFetchStatus() {
        return this.zzcjP;
    }

    public boolean isDeveloperModeEnabled() {
        return this.zzcjH;
    }

    public void zza(String str, zzbqo com_google_android_gms_internal_zzbqo) {
        this.zzcjT.put(str, com_google_android_gms_internal_zzbqo);
    }

    public void zzaH(Map<String, zzbqo> map) {
        Map hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        this.zzcjT = hashMap;
    }

    public void zzaS(long j) {
        this.zzcjS = j;
    }

    public Map<String, zzbqo> zzaay() {
        return this.zzcjT;
    }

    public long zzaaz() {
        return this.zzcjS;
    }

    public void zzbc(boolean z) {
        this.zzcjH = z;
    }

    public void zzjH(String str) {
        if (this.zzcjT.get(str) != null) {
            this.zzcjT.remove(str);
        }
    }

    public void zzpV(int i) {
        this.zzcjP = i;
    }
}
