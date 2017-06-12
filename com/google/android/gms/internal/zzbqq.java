package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class zzbqq {
    private long zzavX;
    private Map<String, Map<String, byte[]>> zzcjN;

    public zzbqq(Map<String, Map<String, byte[]>> map, long j) {
        this.zzcjN = map;
        this.zzavX = j;
    }

    public long getTimestamp() {
        return this.zzavX;
    }

    public void setTimestamp(long j) {
        this.zzavX = j;
    }

    public Map<String, Map<String, byte[]>> zzaav() {
        return this.zzcjN;
    }

    public boolean zzaaw() {
        return (this.zzcjN == null || this.zzcjN.isEmpty()) ? false : true;
    }

    public boolean zzav(String str, String str2) {
        return zzaaw() && zzjG(str2) && zzaw(str, str2) != null;
    }

    public byte[] zzaw(String str, String str2) {
        return (str == null || !zzjG(str2)) ? null : (byte[]) ((Map) this.zzcjN.get(str2)).get(str);
    }

    public Set<String> zzax(String str, String str2) {
        Set<String> treeSet = new TreeSet();
        if (!zzjG(str2)) {
            return treeSet;
        }
        if (str == null || str.isEmpty()) {
            return ((Map) this.zzcjN.get(str2)).keySet();
        }
        for (String str3 : ((Map) this.zzcjN.get(str2)).keySet()) {
            if (str3.startsWith(str)) {
                treeSet.add(str3);
            }
        }
        return treeSet;
    }

    public void zzj(Map<String, byte[]> map, String str) {
        if (this.zzcjN == null) {
            this.zzcjN = new HashMap();
        }
        this.zzcjN.put(str, map);
    }

    public boolean zzjG(String str) {
        if (str == null) {
            return false;
        }
        boolean z = (!zzaaw() || this.zzcjN.get(str) == null || ((Map) this.zzcjN.get(str)).isEmpty()) ? false : true;
        return z;
    }
}
