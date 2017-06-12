package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpy;
import java.util.List;

@zzmb
public class zzc extends zzpd implements ServiceConnection {
    private Context mContext;
    private zzld zzIO;
    private boolean zzOQ;
    private zzb zzOR;
    private zzh zzOS;
    private List<zzf> zzOT;
    private zzk zzOU;
    private final Object zzrN;

    /* renamed from: com.google.android.gms.ads.internal.purchase.zzc.1 */
    class C04961 implements Runnable {
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ zzf zzOV;
        final /* synthetic */ zzc zzOW;

        C04961(zzc com_google_android_gms_ads_internal_purchase_zzc, zzf com_google_android_gms_ads_internal_purchase_zzf, Intent intent) {
            this.zzOW = com_google_android_gms_ads_internal_purchase_zzc;
            this.zzOV = com_google_android_gms_ads_internal_purchase_zzf;
            this.val$intent = intent;
        }

        public void run() {
            try {
                if (this.zzOW.zzOU.zza(this.zzOV.zzPf, -1, this.val$intent)) {
                    this.zzOW.zzIO.zza(new zzg(this.zzOW.mContext, this.zzOV.zzPg, true, -1, this.val$intent, this.zzOV));
                } else {
                    this.zzOW.zzIO.zza(new zzg(this.zzOW.mContext, this.zzOV.zzPg, false, -1, this.val$intent, this.zzOV));
                }
            } catch (RemoteException e) {
                zzpy.zzbe("Fail to verify and dispatch pending transaction");
            }
        }
    }

    public zzc(Context context, zzld com_google_android_gms_internal_zzld, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, com_google_android_gms_internal_zzld, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzq(context.getApplicationContext()));
    }

    zzc(Context context, zzld com_google_android_gms_internal_zzld, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.zzrN = new Object();
        this.zzOQ = false;
        this.zzOT = null;
        this.mContext = context;
        this.zzIO = com_google_android_gms_internal_zzld;
        this.zzOU = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzOR = com_google_android_gms_ads_internal_purchase_zzb;
        this.zzOS = com_google_android_gms_ads_internal_purchase_zzh;
        this.zzOT = this.zzOS.zzg(10);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzpe.m26v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzOQ);
    }

    private boolean zzf(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzrN.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzpy.zzbe("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzrN) {
            this.zzOR.zzV(iBinder);
            zzio();
            this.zzOQ = true;
            this.zzrN.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzpy.zzbd("In-app billing service disconnected.");
        this.zzOR.destroy();
    }

    public void onStop() {
        synchronized (this.zzrN) {
            zza.zzyc().zza(this.mContext, this);
            this.zzOR.destroy();
        }
    }

    protected void zza(zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        Intent intent = new Intent();
        zzv.zzcX();
        intent.putExtra("RESPONSE_CODE", 0);
        zzv.zzcX();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzv.zzcX();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzpi.zzWR.post(new C04961(this, com_google_android_gms_ads_internal_purchase_zzf, intent));
    }

    public void zzcm() {
        synchronized (this.zzrN) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            zza.zzyc().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zze(SystemClock.elapsedRealtime());
            zza.zzyc().zza(this.mContext, this);
            this.zzOR.destroy();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzio() {
        /*
        r12 = this;
        r0 = r12.zzOT;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = r12.zzOT;
        r1 = r0.iterator();
    L_0x0014:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r1.next();
        r0 = (com.google.android.gms.ads.internal.purchase.zzf) r0;
        r2 = r0.zzPg;
        r6.put(r2, r0);
        goto L_0x0014;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        r1 = r12.zzOR;
        r2 = r12.mContext;
        r2 = r2.getPackageName();
        r0 = r1.zzm(r2, r0);
        if (r0 != 0) goto L_0x0055;
    L_0x0035:
        r0 = r6.keySet();
        r1 = r0.iterator();
    L_0x003d:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x0043:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r12.zzOS;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.ads.internal.purchase.zzf) r0;
        r2.zza(r0);
        goto L_0x003d;
    L_0x0055:
        r1 = com.google.android.gms.ads.internal.zzv.zzcX();
        r1 = r1.zzd(r0);
        if (r1 != 0) goto L_0x0035;
    L_0x005f:
        r1 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r0.getStringArrayList(r1);
        r1 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r0.getStringArrayList(r1);
        r1 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r0.getStringArrayList(r1);
        r1 = "INAPP_CONTINUATION_TOKEN";
        r5 = r0.getString(r1);
        r0 = 0;
        r4 = r0;
    L_0x0079:
        r0 = r7.size();
        if (r4 >= r0) goto L_0x00bb;
    L_0x007f:
        r0 = r7.get(r4);
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x0089:
        r0 = r7.get(r4);
        r0 = (java.lang.String) r0;
        r1 = r8.get(r4);
        r1 = (java.lang.String) r1;
        r2 = r9.get(r4);
        r2 = (java.lang.String) r2;
        r3 = r6.get(r0);
        r3 = (com.google.android.gms.ads.internal.purchase.zzf) r3;
        r10 = com.google.android.gms.ads.internal.zzv.zzcX();
        r10 = r10.zzaD(r1);
        r11 = r3.zzPf;
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x00b7;
    L_0x00b1:
        r12.zza(r3, r1, r2);
        r6.remove(r0);
    L_0x00b7:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0079;
    L_0x00bb:
        if (r5 == 0) goto L_0x0035;
    L_0x00bd:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0035;
    L_0x00c3:
        r0 = r5;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzc.zzio():void");
    }
}
