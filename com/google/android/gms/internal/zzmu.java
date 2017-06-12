package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzja.zzc;
import com.google.android.gms.internal.zzmc.zza;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzmu extends zzpd {
    private static zzja zzPU;
    static final long zzSs;
    static boolean zzSt;
    private static zzhy zzSu;
    private static zzic zzSv;
    private static zzhx zzSw;
    private static final Object zztU;
    private final Context mContext;
    private final Object zzPr;
    private final zza zzQQ;
    private final zzmh.zza zzQR;
    private zzc zzSx;

    static {
        zzSs = TimeUnit.SECONDS.toMillis(10);
        zztU = new Object();
        zzSt = false;
        zzPU = null;
        zzSu = null;
        zzSv = null;
        zzSw = null;
    }

    public zzmu(Context context, zzmh.zza com_google_android_gms_internal_zzmh_zza, zza com_google_android_gms_internal_zzmc_zza) {
        super(true);
        this.zzPr = new Object();
        this.zzQQ = com_google_android_gms_internal_zzmc_zza;
        this.mContext = context;
        this.zzQR = com_google_android_gms_internal_zzmh_zza;
        synchronized (zztU) {
            if (!zzSt) {
                zzSv = new zzic();
                zzSu = new zzhy(context.getApplicationContext(), com_google_android_gms_internal_zzmh_zza.zzvf);
                zzSw = new zzc();
                zzPU = new zzja(this.mContext.getApplicationContext(), this.zzQR.zzvf, (String) zzfx.zzAR.get(), new zzb(), new zza());
                zzSt = true;
            }
        }
    }

    private JSONObject zza(zzmh com_google_android_gms_internal_zzmh, String str) {
        Info advertisingIdInfo;
        Throwable e;
        Object obj;
        Map hashMap;
        JSONObject jSONObject = null;
        Bundle bundle = com_google_android_gms_internal_zzmh.zzRd.extras.getBundle("sdk_less_server_data");
        if (bundle != null) {
            JSONObject zza = zzna.zza(this.mContext, new zzmx().zzf(com_google_android_gms_internal_zzmh).zza(zzv.zzcS().zzv(this.mContext)));
            if (zza != null) {
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
                } catch (IOException e2) {
                    e = e2;
                    zzpy.zzc("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().zzP(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e3) {
                    e = e3;
                    zzpy.zzc("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().zzP(hashMap);
                    return jSONObject;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    e = e4;
                    zzpy.zzc("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().zzP(hashMap);
                    return jSONObject;
                } catch (GooglePlayServicesRepairableException e5) {
                    e = e5;
                    zzpy.zzc("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzv.zzcJ().zzP(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("request_param", zza);
                hashMap.put("data", bundle);
                if (advertisingIdInfo != null) {
                    hashMap.put("adid", advertisingIdInfo.getId());
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    }
                    hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                }
                try {
                    jSONObject = zzv.zzcJ().zzP(hashMap);
                } catch (JSONException e6) {
                }
            }
        }
        return jSONObject;
    }

    protected static void zzb(zzix com_google_android_gms_internal_zzix) {
        com_google_android_gms_internal_zzix.zza("/loadAd", zzSv);
        com_google_android_gms_internal_zzix.zza("/fetchHttpRequest", zzSu);
        com_google_android_gms_internal_zzix.zza("/invalidRequest", zzSw);
    }

    protected static void zzc(zzix com_google_android_gms_internal_zzix) {
        com_google_android_gms_internal_zzix.zzb("/loadAd", zzSv);
        com_google_android_gms_internal_zzix.zzb("/fetchHttpRequest", zzSu);
        com_google_android_gms_internal_zzix.zzb("/invalidRequest", zzSw);
    }

    private zzmk zze(zzmh com_google_android_gms_internal_zzmh) {
        String zzkk = zzv.zzcJ().zzkk();
        JSONObject zza = zza(com_google_android_gms_internal_zzmh, zzkk);
        if (zza == null) {
            return new zzmk(0);
        }
        long elapsedRealtime = zzv.zzcP().elapsedRealtime();
        Future zzab = zzSv.zzab(zzkk);
        zzpx.zzXU.post(new 2(this, zza, zzkk));
        try {
            JSONObject jSONObject = (JSONObject) zzab.get(zzSs - (zzv.zzcP().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzmk(-1);
            }
            zzmk zza2 = zzna.zza(this.mContext, com_google_android_gms_internal_zzmh, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.body)) ? zza2 : new zzmk(3);
        } catch (CancellationException e) {
            return new zzmk(-1);
        } catch (InterruptedException e2) {
            return new zzmk(-1);
        } catch (TimeoutException e3) {
            return new zzmk(2);
        } catch (ExecutionException e4) {
            return new zzmk(0);
        }
    }

    public void onStop() {
        synchronized (this.zzPr) {
            zzpx.zzXU.post(new 3(this));
        }
    }

    public void zzcm() {
        zzpy.zzbc("SdkLessAdLoaderBackgroundTask started.");
        zzmh com_google_android_gms_internal_zzmh = new zzmh(this.zzQR, null, -1);
        zzmk zze = zze(com_google_android_gms_internal_zzmh);
        zzec com_google_android_gms_internal_zzec = null;
        zzpx.zzXU.post(new 1(this, new zzov.zza(com_google_android_gms_internal_zzmh, zze, null, com_google_android_gms_internal_zzec, zze.errorCode, zzv.zzcP().elapsedRealtime(), zze.zzRO, null)));
    }
}
