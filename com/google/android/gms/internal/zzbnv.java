package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzbnv<T> {
    public T value;
    public Map<zzbos, zzbnv<T>> zzcdw;

    public zzbnv() {
        this.zzcdw = new HashMap();
    }

    String toString(String str) {
        String valueOf = String.valueOf(this.value);
        valueOf = new StringBuilder((String.valueOf(str).length() + 10) + String.valueOf(valueOf).length()).append(str).append("<value>: ").append(valueOf).append("\n").toString();
        if (this.zzcdw.isEmpty()) {
            return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append(str).append("<empty>").toString();
        }
        String str2 = valueOf;
        for (Entry entry : this.zzcdw.entrySet()) {
            str2 = String.valueOf(str2);
            String valueOf2 = String.valueOf(entry.getKey());
            valueOf = String.valueOf(((zzbnv) entry.getValue()).toString(String.valueOf(str).concat("\t")));
            str2 = new StringBuilder((((String.valueOf(str2).length() + 3) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()).append(str2).append(str).append(valueOf2).append(":\n").append(valueOf).append("\n").toString();
        }
        return str2;
    }
}
