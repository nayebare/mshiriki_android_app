package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzqq.zza;
import org.apache.http.protocol.HTTP;

@zzmb
public class zzlk implements Runnable {
    protected final zzqp zzGt;
    private final Handler zzPu;
    private final long zzPv;
    private long zzPw;
    private zza zzPx;
    protected boolean zzPy;
    protected boolean zzPz;
    private final int zzrG;
    private final int zzrH;

    public zzlk(zza com_google_android_gms_internal_zzqq_zza, zzqp com_google_android_gms_internal_zzqp, int i, int i2) {
        this(com_google_android_gms_internal_zzqq_zza, com_google_android_gms_internal_zzqp, i, i2, 200, 50);
    }

    public zzlk(zza com_google_android_gms_internal_zzqq_zza, zzqp com_google_android_gms_internal_zzqp, int i, int i2, long j, long j2) {
        this.zzPv = j;
        this.zzPw = j2;
        this.zzPu = new Handler(Looper.getMainLooper());
        this.zzGt = com_google_android_gms_internal_zzqp;
        this.zzPx = com_google_android_gms_internal_zzqq_zza;
        this.zzPy = false;
        this.zzPz = false;
        this.zzrH = i2;
        this.zzrG = i;
    }

    static /* synthetic */ long zzc(zzlk com_google_android_gms_internal_zzlk) {
        long j = com_google_android_gms_internal_zzlk.zzPw - 1;
        com_google_android_gms_internal_zzlk.zzPw = j;
        return j;
    }

    public void run() {
        if (this.zzGt == null || zziz()) {
            this.zzPx.zza(this.zzGt, true);
        } else {
            new zza(this, this.zzGt.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(zzmk com_google_android_gms_internal_zzmk) {
        zza(com_google_android_gms_internal_zzmk, new zzra(this, this.zzGt, com_google_android_gms_internal_zzmk.zzRR));
    }

    public void zza(zzmk com_google_android_gms_internal_zzmk, zzra com_google_android_gms_internal_zzra) {
        this.zzGt.setWebViewClient(com_google_android_gms_internal_zzra);
        this.zzGt.loadDataWithBaseURL(TextUtils.isEmpty(com_google_android_gms_internal_zzmk.zzNb) ? null : zzv.zzcJ().zzaV(com_google_android_gms_internal_zzmk.zzNb), com_google_android_gms_internal_zzmk.body, "text/html", HTTP.UTF_8, null);
    }

    public boolean zziA() {
        return this.zzPz;
    }

    public void zzix() {
        this.zzPu.postDelayed(this, this.zzPv);
    }

    public synchronized void zziy() {
        this.zzPy = true;
    }

    public synchronized boolean zziz() {
        return this.zzPy;
    }
}
