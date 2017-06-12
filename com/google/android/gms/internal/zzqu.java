package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.internal.zzew.zza;
import java.util.HashMap;
import java.util.Map;

@zzmb
public class zzqu extends zza {
    private final zzqp zzGt;
    private boolean zzZA;
    private float zzZB;
    private float zzZC;
    private final float zzZw;
    private int zzZx;
    private zzex zzZy;
    private boolean zzZz;
    private final Object zzrN;
    private boolean zzrQ;

    public zzqu(zzqp com_google_android_gms_internal_zzqp, float f) {
        this.zzrN = new Object();
        this.zzrQ = true;
        this.zzGt = com_google_android_gms_internal_zzqp;
        this.zzZw = f;
    }

    private void zzbk(String str) {
        zzd(str, null);
    }

    private void zzd(String str, @Nullable Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzv.zzcJ().runOnUiThread(new 1(this, hashMap));
    }

    private void zzk(int i, int i2) {
        zzv.zzcJ().runOnUiThread(new 2(this, i, i2));
    }

    public float getAspectRatio() {
        float f;
        synchronized (this.zzrN) {
            f = this.zzZC;
        }
        return f;
    }

    public int getPlaybackState() {
        int i;
        synchronized (this.zzrN) {
            i = this.zzZx;
        }
        return i;
    }

    public boolean isMuted() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZA;
        }
        return z;
    }

    public void pause() {
        zzbk("pause");
    }

    public void play() {
        zzbk("play");
    }

    public void zzP(boolean z) {
        synchronized (this.zzrN) {
            this.zzrQ = z;
        }
        zzd("initialState", zzf.zze("muteStart", z ? "1" : "0"));
    }

    public void zza(float f, int i, boolean z, float f2) {
        int i2;
        synchronized (this.zzrN) {
            this.zzZB = f;
            this.zzZA = z;
            i2 = this.zzZx;
            this.zzZx = i;
            this.zzZC = f2;
        }
        zzk(i2, i);
    }

    public void zza(zzex com_google_android_gms_internal_zzex) {
        synchronized (this.zzrN) {
            this.zzZy = com_google_android_gms_internal_zzex;
        }
    }

    public float zzeR() {
        return this.zzZw;
    }

    public float zzeS() {
        float f;
        synchronized (this.zzrN) {
            f = this.zzZB;
        }
        return f;
    }

    public void zzn(boolean z) {
        zzbk(z ? "mute" : "unmute");
    }
}
