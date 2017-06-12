package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblf.zza;
import com.google.android.gms.internal.zzblf.zzb;
import java.util.Comparator;

public abstract class zzblh<K, V> implements zzblf<K, V> {
    private final V value;
    private final K zzbYU;
    private zzblf<K, V> zzbYV;
    private final zzblf<K, V> zzbYW;

    zzblh(K k, V v, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2) {
        zzblf zzVr;
        zzblf zzVr2;
        this.zzbYU = k;
        this.value = v;
        if (com_google_android_gms_internal_zzblf_K__V == null) {
            zzVr = zzble.zzVr();
        }
        this.zzbYV = zzVr;
        if (com_google_android_gms_internal_zzblf_K__V2 == null) {
            zzVr2 = zzble.zzVr();
        }
        this.zzbYW = zzVr2;
    }

    private zzblh<K, V> zzVA() {
        zzblh<K, V> zzVB;
        if (this.zzbYW.zzVq() && !this.zzbYV.zzVq()) {
            zzVB = zzVB();
        }
        if (zzVB.zzbYV.zzVq() && ((zzblh) zzVB.zzbYV).zzbYV.zzVq()) {
            zzVB = zzVB.zzVC();
        }
        return (zzVB.zzbYV.zzVq() && zzVB.zzbYW.zzVq()) ? zzVB.zzVD() : zzVB;
    }

    private zzblh<K, V> zzVB() {
        return (zzblh) this.zzbYW.zza(null, null, zzVp(), (zzblh) zza(null, null, zza.RED, null, ((zzblh) this.zzbYW).zzbYV), null);
    }

    private zzblh<K, V> zzVC() {
        return (zzblh) this.zzbYV.zza(null, null, zzVp(), null, (zzblh) zza(null, null, zza.RED, ((zzblh) this.zzbYV).zzbYW, null));
    }

    private zzblh<K, V> zzVD() {
        return (zzblh) zza(null, null, zza((zzblf) this), this.zzbYV.zza(null, null, zza(this.zzbYV), null, null), this.zzbYW.zza(null, null, zza(this.zzbYW), null, null));
    }

    private zzblf<K, V> zzVx() {
        if (this.zzbYV.isEmpty()) {
            return zzble.zzVr();
        }
        if (!(zzVs().zzVq() || zzVs().zzVs().zzVq())) {
            this = zzVy();
        }
        return zza(null, null, ((zzblh) this.zzbYV).zzVx(), null).zzVA();
    }

    private zzblh<K, V> zzVy() {
        zzblh<K, V> zzVD = zzVD();
        return zzVD.zzVt().zzVs().zzVq() ? zzVD.zza(null, null, null, ((zzblh) zzVD.zzVt()).zzVC()).zzVB().zzVD() : zzVD;
    }

    private zzblh<K, V> zzVz() {
        zzblh<K, V> zzVD = zzVD();
        return zzVD.zzVs().zzVs().zzVq() ? zzVD.zzVC().zzVD() : zzVD;
    }

    private static zza zza(zzblf com_google_android_gms_internal_zzblf) {
        return com_google_android_gms_internal_zzblf.zzVq() ? zza.BLACK : zza.RED;
    }

    public K getKey() {
        return this.zzbYU;
    }

    public V getValue() {
        return this.value;
    }

    public boolean isEmpty() {
        return false;
    }

    protected abstract zza zzVp();

    public zzblf<K, V> zzVs() {
        return this.zzbYV;
    }

    public zzblf<K, V> zzVt() {
        return this.zzbYW;
    }

    public zzblf<K, V> zzVu() {
        return this.zzbYV.isEmpty() ? this : this.zzbYV.zzVu();
    }

    public zzblf<K, V> zzVv() {
        return this.zzbYW.isEmpty() ? this : this.zzbYW.zzVv();
    }

    public int zzVw() {
        return (this.zzbYV.zzVw() + 1) + this.zzbYW.zzVw();
    }

    public /* synthetic */ zzblf zza(Object obj, Object obj2, zza com_google_android_gms_internal_zzblf_zza, zzblf com_google_android_gms_internal_zzblf, zzblf com_google_android_gms_internal_zzblf2) {
        return zzb(obj, obj2, com_google_android_gms_internal_zzblf_zza, com_google_android_gms_internal_zzblf, com_google_android_gms_internal_zzblf2);
    }

    public zzblf<K, V> zza(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.zzbYU);
        zzblh zza = compare < 0 ? zza(null, null, this.zzbYV.zza(k, v, comparator), null) : compare == 0 ? zza(k, v, null, null) : zza(null, null, null, this.zzbYW.zza(k, v, comparator));
        return zza.zzVA();
    }

    public zzblf<K, V> zza(K k, Comparator<K> comparator) {
        zzblh zza;
        if (comparator.compare(k, this.zzbYU) < 0) {
            if (!(this.zzbYV.isEmpty() || this.zzbYV.zzVq() || ((zzblh) this.zzbYV).zzbYV.zzVq())) {
                this = zzVy();
            }
            zza = zza(null, null, this.zzbYV.zza(k, comparator), null);
        } else {
            if (this.zzbYV.zzVq()) {
                this = zzVC();
            }
            if (!(this.zzbYW.isEmpty() || this.zzbYW.zzVq() || ((zzblh) this.zzbYW).zzbYV.zzVq())) {
                this = zzVz();
            }
            if (comparator.compare(k, this.zzbYU) == 0) {
                if (this.zzbYW.isEmpty()) {
                    return zzble.zzVr();
                }
                zzblf zzVu = this.zzbYW.zzVu();
                this = zza(zzVu.getKey(), zzVu.getValue(), null, ((zzblh) this.zzbYW).zzVx());
            }
            zza = zza(null, null, null, this.zzbYW.zza(k, comparator));
        }
        return zza.zzVA();
    }

    protected abstract zzblh<K, V> zza(K k, V v, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2);

    public void zza(zzb<K, V> com_google_android_gms_internal_zzblf_zzb_K__V) {
        this.zzbYV.zza(com_google_android_gms_internal_zzblf_zzb_K__V);
        com_google_android_gms_internal_zzblf_zzb_K__V.zzk(this.zzbYU, this.value);
        this.zzbYW.zza(com_google_android_gms_internal_zzblf_zzb_K__V);
    }

    public zzblh<K, V> zzb(K k, V v, zza com_google_android_gms_internal_zzblf_zza, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2) {
        Object obj;
        Object obj2;
        zzblf com_google_android_gms_internal_zzblf;
        zzblf com_google_android_gms_internal_zzblf2;
        if (k == null) {
            obj = this.zzbYU;
        }
        if (v == null) {
            obj2 = this.value;
        }
        if (com_google_android_gms_internal_zzblf_K__V == null) {
            com_google_android_gms_internal_zzblf = this.zzbYV;
        }
        if (com_google_android_gms_internal_zzblf_K__V2 == null) {
            com_google_android_gms_internal_zzblf2 = this.zzbYW;
        }
        return com_google_android_gms_internal_zzblf_zza == zza.RED ? new zzblg(obj, obj2, com_google_android_gms_internal_zzblf, com_google_android_gms_internal_zzblf2) : new zzbld(obj, obj2, com_google_android_gms_internal_zzblf, com_google_android_gms_internal_zzblf2);
    }

    void zzb(zzblf<K, V> com_google_android_gms_internal_zzblf_K__V) {
        this.zzbYV = com_google_android_gms_internal_zzblf_K__V;
    }
}
