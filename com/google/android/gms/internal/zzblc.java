package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class zzblc<T> implements Iterable<T> {
    private final zzbla<T, Void> zzbYO;

    private static class zza<T> implements Iterator<T> {
        final Iterator<Entry<T, Void>> zzbYP;

        public zza(Iterator<Entry<T, Void>> it) {
            this.zzbYP = it;
        }

        public boolean hasNext() {
            return this.zzbYP.hasNext();
        }

        public T next() {
            return ((Entry) this.zzbYP.next()).getKey();
        }

        public void remove() {
            this.zzbYP.remove();
        }
    }

    private zzblc(zzbla<T, Void> com_google_android_gms_internal_zzbla_T__java_lang_Void) {
        this.zzbYO = com_google_android_gms_internal_zzbla_T__java_lang_Void;
    }

    public zzblc(List<T> list, Comparator<T> comparator) {
        this.zzbYO = com.google.android.gms.internal.zzbla.zza.zzb(list, Collections.emptyMap(), com.google.android.gms.internal.zzbla.zza.zzVm(), comparator);
    }

    public Iterator<T> iterator() {
        return new zza(this.zzbYO.iterator());
    }

    public Iterator<T> zzVl() {
        return new zza(this.zzbYO.zzVl());
    }

    public T zzVn() {
        return this.zzbYO.zzVj();
    }

    public T zzVo() {
        return this.zzbYO.zzVk();
    }

    public zzblc<T> zzaj(T t) {
        zzbla zzae = this.zzbYO.zzae(t);
        return zzae == this.zzbYO ? this : new zzblc(zzae);
    }

    public zzblc<T> zzak(T t) {
        return new zzblc(this.zzbYO.zzj(t, null));
    }

    public T zzal(T t) {
        return this.zzbYO.zzaf(t);
    }
}
