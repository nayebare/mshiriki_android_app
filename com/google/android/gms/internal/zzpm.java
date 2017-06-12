package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzpm {
    private String zzXi;
    private String zzXj;
    private boolean zzXk;
    private final Object zzrN;

    public zzpm() {
        this.zzrN = new Object();
        this.zzXi = BuildConfig.FLAVOR;
        this.zzXj = BuildConfig.FLAVOR;
        this.zzXk = false;
    }

    private Uri zze(Context context, String str, String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzM(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        return buildUpon.build();
    }

    private void zzo(Context context, String str) {
        zzv.zzcJ().zza(context, zze(context, (String) zzfx.zzES.get(), str));
    }

    public void zzI(boolean z) {
        synchronized (this.zzrN) {
            this.zzXk = z;
        }
    }

    public String zzM(Context context) {
        String str;
        synchronized (this.zzrN) {
            if (TextUtils.isEmpty(this.zzXi)) {
                this.zzXi = zzv.zzcJ().zzi(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzXi)) {
                    this.zzXi = zzv.zzcJ().zzkk();
                    zzv.zzcJ().zzd(context, "debug_signals_id.txt", this.zzXi);
                }
            }
            str = this.zzXi;
        }
        return str;
    }

    public void zza(Context context, String str, String str2, String str3) {
        Builder buildUpon = zze(context, (String) zzfx.zzEV.get(), str3).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzv.zzcJ().zzc(context, str, buildUpon.build().toString());
    }

    public void zzba(String str) {
        synchronized (this.zzrN) {
            this.zzXj = str;
        }
    }

    public void zzj(Context context, String str) {
        if (zzl(context, str)) {
            zzpy.zzbc("Device is linked for in app preview.");
        } else {
            zzo(context, str);
        }
    }

    public void zzk(Context context, String str) {
        if (zzm(context, str)) {
            zzpy.zzbc("Device is linked for debug signals.");
        } else {
            zzo(context, str);
        }
    }

    public String zzky() {
        String str;
        synchronized (this.zzrN) {
            str = this.zzXj;
        }
        return str;
    }

    public boolean zzkz() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzXk;
        }
        return z;
    }

    boolean zzl(Context context, String str) {
        Object zzn = zzn(context, zze(context, (String) zzfx.zzET.get(), str).toString());
        if (TextUtils.isEmpty(zzn)) {
            zzpy.zzbc("Not linked for in app preview.");
            return false;
        }
        zzba(zzn.trim());
        return true;
    }

    boolean zzm(Context context, String str) {
        Object zzn = zzn(context, zze(context, (String) zzfx.zzEU.get(), str).toString());
        if (TextUtils.isEmpty(zzn)) {
            zzpy.zzbc("Not linked for debug signals.");
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(zzn.trim());
        zzI(parseBoolean);
        return parseBoolean;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String zzn(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = this;
        r5 = 1;
        r0 = new com.google.android.gms.internal.zzpp;
        r0.<init>(r7);
        r1 = new com.google.android.gms.internal.zzpm$1;
        r1.<init>(r6, r8);
        r2 = r0.zza(r8, r1);
        r0 = com.google.android.gms.internal.zzfx.zzEW;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = r0.get();	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = (java.lang.Integer) r0;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = r0.intValue();	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = (long) r0;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = r2.get(r0, r3);	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
        r0 = (java.lang.String) r0;	 Catch:{ TimeoutException -> 0x0025, InterruptedException -> 0x0045, Exception -> 0x0064 }
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = move-exception;
        r1 = r0;
        r3 = "Timeout while retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r4 = r0.length();
        if (r4 == 0) goto L_0x003f;
    L_0x0033:
        r0 = r3.concat(r0);
    L_0x0037:
        com.google.android.gms.internal.zzpy.zzb(r0, r1);
        r2.cancel(r5);
    L_0x003d:
        r0 = 0;
        goto L_0x0024;
    L_0x003f:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0037;
    L_0x0045:
        r0 = move-exception;
        r1 = r0;
        r3 = "Interrupted while retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r4 = r0.length();
        if (r4 == 0) goto L_0x005e;
    L_0x0053:
        r0 = r3.concat(r0);
    L_0x0057:
        com.google.android.gms.internal.zzpy.zzb(r0, r1);
        r2.cancel(r5);
        goto L_0x003d;
    L_0x005e:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0057;
    L_0x0064:
        r0 = move-exception;
        r1 = r0;
        r2 = "Error retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r3 = r0.length();
        if (r3 == 0) goto L_0x007a;
    L_0x0072:
        r0 = r2.concat(r0);
    L_0x0076:
        com.google.android.gms.internal.zzpy.zzb(r0, r1);
        goto L_0x003d;
    L_0x007a:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpm.zzn(android.content.Context, java.lang.String):java.lang.String");
    }
}
