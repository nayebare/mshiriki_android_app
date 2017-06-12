package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class zzbfw<T> {
    protected Map<String, zzbfw<?>> zzbKM;

    /* renamed from: com.google.android.gms.internal.zzbfw.1 */
    class C11551 implements Iterator<zzbfw<?>> {
        final /* synthetic */ Iterator zzbKN;

        C11551(zzbfw com_google_android_gms_internal_zzbfw, Iterator it) {
            this.zzbKN = it;
        }

        public boolean hasNext() {
            return this.zzbKN.hasNext();
        }

        public /* synthetic */ Object next() {
            return zzRH();
        }

        public void remove() {
            this.zzbKN.remove();
        }

        public zzbfw<?> zzRH() {
            return new zzbge((String) this.zzbKN.next());
        }
    }

    private static class zza implements Iterator<zzbfw<?>> {
        private zza() {
        }

        public boolean hasNext() {
            return false;
        }

        public /* synthetic */ Object next() {
            return zzRH();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public zzbfw<?> zzRH() {
            throw new NoSuchElementException();
        }
    }

    public abstract String toString();

    public Iterator<zzbfw<?>> zzRE() {
        return new zza();
    }

    public abstract T zzRF();

    protected Iterator<zzbfw<?>> zzRG() {
        return this.zzbKM == null ? new zza() : new C11551(this, this.zzbKM.keySet().iterator());
    }

    public void zzc(String str, zzbfw<?> com_google_android_gms_internal_zzbfw_) {
        if (this.zzbKM == null) {
            this.zzbKM = new HashMap();
        }
        this.zzbKM.put(str, com_google_android_gms_internal_zzbfw_);
    }

    public boolean zzif(String str) {
        return this.zzbKM != null && this.zzbKM.containsKey(str);
    }

    public zzbfw<?> zzig(String str) {
        return this.zzbKM != null ? (zzbfw) this.zzbKM.get(str) : zzbga.zzbKV;
    }

    public boolean zzih(String str) {
        return false;
    }

    public zzazt zzii(String str) {
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 56).append("Attempting to access Native Method ").append(str).append(" on unsupported type.").toString());
    }
}
