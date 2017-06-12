package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import java.util.Map.Entry;

public class zzbnu<T> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private zzbos zzcfw;
    private zzbnu<T> zzcfx;
    private zzbnv<T> zzcfy;

    public interface zzb<T> {
        void zzd(zzbnu<T> com_google_android_gms_internal_zzbnu_T);
    }

    public interface zza<T> {
        boolean zze(zzbnu<T> com_google_android_gms_internal_zzbnu_T);
    }

    /* renamed from: com.google.android.gms.internal.zzbnu.1 */
    class C12631 implements zzb<T> {
        final /* synthetic */ boolean zzcfA;
        final /* synthetic */ zzb zzcfz;

        C12631(zzbnu com_google_android_gms_internal_zzbnu, zzb com_google_android_gms_internal_zzbnu_zzb, boolean z) {
            this.zzcfz = com_google_android_gms_internal_zzbnu_zzb;
            this.zzcfA = z;
        }

        public void zzd(zzbnu<T> com_google_android_gms_internal_zzbnu_T) {
            com_google_android_gms_internal_zzbnu_T.zza(this.zzcfz, true, this.zzcfA);
        }
    }

    static {
        $assertionsDisabled = !zzbnu.class.desiredAssertionStatus();
    }

    public zzbnu() {
        this(null, null, new zzbnv());
    }

    public zzbnu(zzbos com_google_android_gms_internal_zzbos, zzbnu<T> com_google_android_gms_internal_zzbnu_T, zzbnv<T> com_google_android_gms_internal_zzbnv_T) {
        this.zzcfw = com_google_android_gms_internal_zzbos;
        this.zzcfx = com_google_android_gms_internal_zzbnu_T;
        this.zzcfy = com_google_android_gms_internal_zzbnv_T;
    }

    private void zzYf() {
        if (this.zzcfx != null) {
            this.zzcfx.zza(this.zzcfw, this);
        }
    }

    private void zza(zzbos com_google_android_gms_internal_zzbos, zzbnu<T> com_google_android_gms_internal_zzbnu_T) {
        boolean isEmpty = com_google_android_gms_internal_zzbnu_T.isEmpty();
        boolean containsKey = this.zzcfy.zzcdw.containsKey(com_google_android_gms_internal_zzbos);
        if (isEmpty && containsKey) {
            this.zzcfy.zzcdw.remove(com_google_android_gms_internal_zzbos);
            zzYf();
        } else if (!isEmpty && !containsKey) {
            this.zzcfy.zzcdw.put(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbnu_T.zzcfy);
            zzYf();
        }
    }

    public T getValue() {
        return this.zzcfy.value;
    }

    public boolean hasChildren() {
        return !this.zzcfy.zzcdw.isEmpty();
    }

    public boolean isEmpty() {
        return this.zzcfy.value == null && this.zzcfy.zzcdw.isEmpty();
    }

    public void setValue(T t) {
        this.zzcfy.value = t;
        zzYf();
    }

    public String toString() {
        return toString(BuildConfig.FLAVOR);
    }

    String toString(String str) {
        String asString = this.zzcfw == null ? "<anon>" : this.zzcfw.asString();
        String valueOf = String.valueOf(this.zzcfy.toString(String.valueOf(str).concat("\t")));
        return new StringBuilder(((String.valueOf(str).length() + 1) + String.valueOf(asString).length()) + String.valueOf(valueOf).length()).append(str).append(asString).append("\n").append(valueOf).toString();
    }

    public zzbnu<T> zzL(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbnu<T> com_google_android_gms_internal_zzbnu_T;
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        while (zzXi != null) {
            zzbnu<T> com_google_android_gms_internal_zzbnu = new zzbnu(zzXi, com_google_android_gms_internal_zzbnu_T, com_google_android_gms_internal_zzbnu_T.zzcfy.zzcdw.containsKey(zzXi) ? (zzbnv) com_google_android_gms_internal_zzbnu_T.zzcfy.zzcdw.get(zzXi) : new zzbnv());
            com_google_android_gms_internal_zzbmj = com_google_android_gms_internal_zzbmj.zzXj();
            zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            com_google_android_gms_internal_zzbnu_T = com_google_android_gms_internal_zzbnu;
        }
        return com_google_android_gms_internal_zzbnu_T;
    }

    public zzbmj zzVc() {
        if (this.zzcfx != null) {
            if ($assertionsDisabled || this.zzcfw != null) {
                return this.zzcfx.zzVc().zza(this.zzcfw);
            }
            throw new AssertionError();
        } else if (this.zzcfw == null) {
            return zzbmj.zzXf();
        } else {
            return new zzbmj(this.zzcfw);
        }
    }

    public void zza(zzb<T> com_google_android_gms_internal_zzbnu_zzb_T) {
        zza(com_google_android_gms_internal_zzbnu_zzb_T, false, false);
    }

    public void zza(zzb<T> com_google_android_gms_internal_zzbnu_zzb_T, boolean z, boolean z2) {
        if (z && !z2) {
            com_google_android_gms_internal_zzbnu_zzb_T.zzd(this);
        }
        zzb(new C12631(this, com_google_android_gms_internal_zzbnu_zzb_T, z2));
        if (z && z2) {
            com_google_android_gms_internal_zzbnu_zzb_T.zzd(this);
        }
    }

    public boolean zza(zza<T> com_google_android_gms_internal_zzbnu_zza_T) {
        return zza((zza) com_google_android_gms_internal_zzbnu_zza_T, false);
    }

    public boolean zza(zza<T> com_google_android_gms_internal_zzbnu_zza_T, boolean z) {
        if (!z) {
            this = this.zzcfx;
        }
        while (this != null) {
            com_google_android_gms_internal_zzbnu_zza_T.zze(this);
            this = this.zzcfx;
        }
        return false;
    }

    public void zzb(zzb<T> com_google_android_gms_internal_zzbnu_zzb_T) {
        Object[] toArray = this.zzcfy.zzcdw.entrySet().toArray();
        for (Object obj : toArray) {
            Entry entry = (Entry) obj;
            com_google_android_gms_internal_zzbnu_zzb_T.zzd(new zzbnu((zzbos) entry.getKey(), this, (zzbnv) entry.getValue()));
        }
    }
}
