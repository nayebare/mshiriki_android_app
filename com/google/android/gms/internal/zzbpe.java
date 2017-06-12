package com.google.android.gms.internal;

import java.util.Iterator;

public interface zzbpe extends Comparable<zzbpe>, Iterable<zzbpd> {
    public static final zzbot zzchu;

    /* renamed from: com.google.android.gms.internal.zzbpe.1 */
    class C12751 extends zzbot {
        C12751() {
        }

        public /* synthetic */ int compareTo(Object obj) {
            return zzh((zzbpe) obj);
        }

        public boolean equals(Object obj) {
            return obj == this;
        }

        public boolean isEmpty() {
            return false;
        }

        public String toString() {
            return "<Max Node>";
        }

        public zzbpe zzZe() {
            return this;
        }

        public int zzh(zzbpe com_google_android_gms_internal_zzbpe) {
            return com_google_android_gms_internal_zzbpe == this ? 0 : 1;
        }

        public boolean zzk(zzbos com_google_android_gms_internal_zzbos) {
            return false;
        }

        public zzbpe zzm(zzbos com_google_android_gms_internal_zzbos) {
            return com_google_android_gms_internal_zzbos.zzZa() ? zzZe() : zzbox.zzZp();
        }
    }

    public enum zza {
        V1,
        V2
    }

    static {
        zzchu = new C12751();
    }

    int getChildCount();

    Object getValue();

    Object getValue(boolean z);

    boolean isEmpty();

    zzbpe zzO(zzbmj com_google_android_gms_internal_zzbmj);

    Iterator<zzbpd> zzVl();

    String zzZc();

    boolean zzZd();

    zzbpe zzZe();

    String zza(zza com_google_android_gms_internal_zzbpe_zza);

    zzbpe zze(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe);

    zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe);

    boolean zzk(zzbos com_google_android_gms_internal_zzbos);

    zzbos zzl(zzbos com_google_android_gms_internal_zzbos);

    zzbpe zzl(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe);

    zzbpe zzm(zzbos com_google_android_gms_internal_zzbos);
}
