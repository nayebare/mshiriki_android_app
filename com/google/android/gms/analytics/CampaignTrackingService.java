package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzayd;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzsx;
import com.google.android.gms.internal.zztg;

public class CampaignTrackingService extends Service {
    private static Boolean zzaax;
    private Handler mHandler;

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.1 */
    class C05311 implements Runnable {
        final /* synthetic */ CampaignTrackingService zzaaA;
        final /* synthetic */ zzsx zzaay;
        final /* synthetic */ int zzaaz;
        final /* synthetic */ Handler zzs;

        C05311(CampaignTrackingService campaignTrackingService, zzsx com_google_android_gms_internal_zzsx, Handler handler, int i) {
            this.zzaaA = campaignTrackingService;
            this.zzaay = com_google_android_gms_internal_zzsx;
            this.zzs = handler;
            this.zzaaz = i;
        }

        public void run() {
            this.zzaaA.zza(this.zzaay, this.zzs, this.zzaaz);
        }
    }

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.2 */
    class C05322 implements Runnable {
        final /* synthetic */ CampaignTrackingService zzaaA;
        final /* synthetic */ zzsx zzaay;
        final /* synthetic */ int zzaaz;
        final /* synthetic */ Handler zzs;

        C05322(CampaignTrackingService campaignTrackingService, zzsx com_google_android_gms_internal_zzsx, Handler handler, int i) {
            this.zzaaA = campaignTrackingService;
            this.zzaay = com_google_android_gms_internal_zzsx;
            this.zzs = handler;
            this.zzaaz = i;
        }

        public void run() {
            this.zzaaA.zza(this.zzaay, this.zzs, this.zzaaz);
        }
    }

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.3 */
    class C05333 implements Runnable {
        final /* synthetic */ CampaignTrackingService zzaaA;
        final /* synthetic */ zzsx zzaay;
        final /* synthetic */ int zzaaz;

        C05333(CampaignTrackingService campaignTrackingService, int i, zzsx com_google_android_gms_internal_zzsx) {
            this.zzaaA = campaignTrackingService;
            this.zzaaz = i;
            this.zzaay = com_google_android_gms_internal_zzsx;
        }

        public void run() {
            boolean stopSelfResult = this.zzaaA.stopSelfResult(this.zzaaz);
            if (stopSelfResult) {
                this.zzaay.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
            }
        }
    }

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.mHandler = handler;
        return handler;
    }

    public static boolean zzU(Context context) {
        zzac.zzw(context);
        if (zzaax != null) {
            return zzaax.booleanValue();
        }
        boolean zzr = zztg.zzr(context, "com.google.android.gms.analytics.CampaignTrackingService");
        zzaax = Boolean.valueOf(zzr);
        return zzr;
    }

    private void zzlS() {
        try {
            synchronized (CampaignTrackingReceiver.zztU) {
                zzayd com_google_android_gms_internal_zzayd = CampaignTrackingReceiver.zzaav;
                if (com_google_android_gms_internal_zzayd != null && com_google_android_gms_internal_zzayd.isHeld()) {
                    com_google_android_gms_internal_zzayd.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        super.onCreate();
        zzrw.zzW(this).zznr().zzbO("CampaignTrackingService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzrw.zzW(this).zznr().zzbO("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int i, int i2) {
        zzlS();
        zzrw zzW = zzrw.zzW(this);
        zzsx zznr = zzW.zznr();
        String stringExtra = intent.getStringExtra("referrer");
        Handler handler = getHandler();
        if (TextUtils.isEmpty(stringExtra)) {
            zznr.zzbR("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            zzW.zznt().zzg(new C05311(this, zznr, handler, i2));
        } else {
            int zzoz = zzW.zzns().zzoz();
            if (stringExtra.length() > zzoz) {
                zznr.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzoz));
                stringExtra = stringExtra.substring(0, zzoz);
            }
            zznr.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), stringExtra);
            zzW.zzlZ().zza(stringExtra, new C05322(this, zznr, handler, i2));
        }
        return 2;
    }

    protected void zza(zzsx com_google_android_gms_internal_zzsx, Handler handler, int i) {
        handler.post(new C05333(this, i, com_google_android_gms_internal_zzsx));
    }
}
