package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class zzbnm implements zzbnn {
    private boolean zzbYy;

    public zzbnm() {
        this.zzbYy = false;
    }

    private void zzVi() {
        zzbqg.zzb(this.zzbYy, "Transaction expected to already be in progress.");
    }

    public List<zzbmx> zzVe() {
        return Collections.emptyList();
    }

    public void zzVh() {
        zzVi();
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, long j) {
        zzVi();
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, long j) {
        zzVi();
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, zzbpe com_google_android_gms_internal_zzbpe) {
        zzVi();
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, Set<zzbos> set) {
        zzVi();
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, Set<zzbos> set, Set<zzbos> set2) {
        zzVi();
    }

    public void zzaA(long j) {
        zzVi();
    }

    public void zzc(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        zzVi();
    }

    public void zzd(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        zzVi();
    }

    public zzbnw zzf(zzboe com_google_android_gms_internal_zzboe) {
        return new zzbnw(zzboz.zza(zzbox.zzZp(), com_google_android_gms_internal_zzboe.zzYz()), false, false);
    }

    public <T> T zzf(Callable<T> callable) {
        zzbqg.zzb(!this.zzbYy, "runInTransaction called when an existing transaction is already in progress.");
        this.zzbYy = true;
        try {
            T call = callable.call();
            this.zzbYy = false;
            return call;
        } catch (Throwable th) {
            this.zzbYy = false;
        }
    }

    public void zzg(zzboe com_google_android_gms_internal_zzboe) {
        zzVi();
    }

    public void zzh(zzboe com_google_android_gms_internal_zzboe) {
        zzVi();
    }

    public void zzi(zzboe com_google_android_gms_internal_zzboe) {
        zzVi();
    }

    public void zzk(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        zzVi();
    }
}
