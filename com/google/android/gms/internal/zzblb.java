package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

public class zzblb<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<zzblh<K, V>> zzbYM;
    private final boolean zzbYN;

    zzblb(zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, K k, Comparator<K> comparator, boolean z) {
        this.zzbYM = new Stack();
        this.zzbYN = z;
        zzblf com_google_android_gms_internal_zzblf = com_google_android_gms_internal_zzblf_K__V;
        while (!com_google_android_gms_internal_zzblf.isEmpty()) {
            int compare = k != null ? z ? comparator.compare(k, com_google_android_gms_internal_zzblf.getKey()) : comparator.compare(com_google_android_gms_internal_zzblf.getKey(), k) : 1;
            if (compare < 0) {
                com_google_android_gms_internal_zzblf = z ? com_google_android_gms_internal_zzblf.zzVs() : com_google_android_gms_internal_zzblf.zzVt();
            } else if (compare == 0) {
                this.zzbYM.push((zzblh) com_google_android_gms_internal_zzblf);
                return;
            } else {
                this.zzbYM.push((zzblh) com_google_android_gms_internal_zzblf);
                com_google_android_gms_internal_zzblf = z ? com_google_android_gms_internal_zzblf.zzVt() : com_google_android_gms_internal_zzblf.zzVs();
            }
        }
    }

    public boolean hasNext() {
        return this.zzbYM.size() > 0;
    }

    public Entry<K, V> next() {
        try {
            zzblh com_google_android_gms_internal_zzblh = (zzblh) this.zzbYM.pop();
            Entry simpleEntry = new SimpleEntry(com_google_android_gms_internal_zzblh.getKey(), com_google_android_gms_internal_zzblh.getValue());
            zzblf zzVs;
            if (this.zzbYN) {
                for (zzVs = com_google_android_gms_internal_zzblh.zzVs(); !zzVs.isEmpty(); zzVs = zzVs.zzVt()) {
                    this.zzbYM.push((zzblh) zzVs);
                }
            } else {
                for (zzVs = com_google_android_gms_internal_zzblh.zzVt(); !zzVs.isEmpty(); zzVs = zzVs.zzVs()) {
                    this.zzbYM.push((zzblh) zzVs);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
