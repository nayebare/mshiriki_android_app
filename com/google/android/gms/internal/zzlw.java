package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzlu.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlw implements zza<zzgp> {
    private final boolean zzQH;
    private final boolean zzQI;

    public zzlw(boolean z, boolean z2) {
        this.zzQH = z;
        this.zzQI = z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzqp zzb(com.google.android.gms.internal.zzqf<com.google.android.gms.internal.zzqp> r4) {
        /*
        r3 = this;
        r0 = com.google.android.gms.internal.zzfx.zzDY;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (java.lang.Integer) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r0.intValue();	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r4.get(r0, r2);	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (com.google.android.gms.internal.zzqp) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = move-exception;
        r1 = "InterruptedException occurred while waiting for video to load";
        com.google.android.gms.internal.zzpy.zzc(r1, r0);
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x0023:
        r0 = 0;
        goto L_0x0015;
    L_0x0025:
        r0 = move-exception;
    L_0x0026:
        r1 = "Exception occurred while waiting for video to load";
        com.google.android.gms.internal.zzpy.zzc(r1, r0);
        goto L_0x0023;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlw.zzb(com.google.android.gms.internal.zzqf):com.google.android.gms.internal.zzqp");
    }

    public /* synthetic */ zzgu.zza zza(zzlu com_google_android_gms_internal_zzlu, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzb(com_google_android_gms_internal_zzlu, jSONObject);
    }

    public zzgp zzb(zzlu com_google_android_gms_internal_zzlu, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzqf> zza = com_google_android_gms_internal_zzlu.zza(jSONObject, "images", true, this.zzQH, this.zzQI);
        zzqf zza2 = com_google_android_gms_internal_zzlu.zza(jSONObject, "app_icon", true, this.zzQH);
        zzqf zzc = com_google_android_gms_internal_zzlu.zzc(jSONObject, "video");
        zzqf zze = com_google_android_gms_internal_zzlu.zze(jSONObject);
        List arrayList = new ArrayList();
        for (zzqf com_google_android_gms_internal_zzqf : zza) {
            arrayList.add((zzgo) com_google_android_gms_internal_zzqf.get());
        }
        zzqp zzb = zzb(zzc);
        return new zzgp(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzgz) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (zzgm) zze.get(), new Bundle(), zzb != null ? zzb.zzlg() : null, zzb != null ? zzb.getView() : null);
    }
}
