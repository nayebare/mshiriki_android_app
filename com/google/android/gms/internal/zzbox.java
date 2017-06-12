package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.internal.zzbpe.zza;
import java.util.Collections;
import java.util.Iterator;

public class zzbox extends zzbot implements zzbpe {
    private static final zzbox zzchh;

    static {
        zzchh = new zzbox();
    }

    private zzbox() {
    }

    public static zzbox zzZp() {
        return zzchh;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzh((zzbpe) obj);
    }

    public boolean equals(Object obj) {
        if (obj instanceof zzbox) {
            return true;
        }
        boolean z = (obj instanceof zzbpe) && ((zzbpe) obj).isEmpty() && zzZe().equals(((zzbpe) obj).zzZe());
        return z;
    }

    public int getChildCount() {
        return 0;
    }

    public Object getValue() {
        return null;
    }

    public Object getValue(boolean z) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator<zzbpd> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        return "<Empty Node>";
    }

    public zzbpe zzO(zzbmj com_google_android_gms_internal_zzbmj) {
        return this;
    }

    public Iterator<zzbpd> zzVl() {
        return Collections.emptyList().iterator();
    }

    public String zzZc() {
        return BuildConfig.FLAVOR;
    }

    public boolean zzZd() {
        return false;
    }

    public zzbpe zzZe() {
        return this;
    }

    public String zza(zza com_google_android_gms_internal_zzbpe_zza) {
        return BuildConfig.FLAVOR;
    }

    public zzbpe zze(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return (com_google_android_gms_internal_zzbpe.isEmpty() || com_google_android_gms_internal_zzbos.zzZa()) ? this : new zzbot().zze(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
    }

    public /* synthetic */ zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzl(com_google_android_gms_internal_zzbpe);
    }

    public int zzh(zzbpe com_google_android_gms_internal_zzbpe) {
        return com_google_android_gms_internal_zzbpe.isEmpty() ? 0 : -1;
    }

    public boolean zzk(zzbos com_google_android_gms_internal_zzbos) {
        return false;
    }

    public zzbos zzl(zzbos com_google_android_gms_internal_zzbos) {
        return null;
    }

    public zzbox zzl(zzbpe com_google_android_gms_internal_zzbpe) {
        return this;
    }

    public zzbpe zzl(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return com_google_android_gms_internal_zzbpe;
        }
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        return zze(zzXi, zzm(zzXi).zzl(com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzbpe));
    }

    public zzbpe zzm(zzbos com_google_android_gms_internal_zzbos) {
        return this;
    }
}
