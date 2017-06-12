package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqi.zzb;
import com.google.android.gms.internal.zzqi.zzc;
import com.google.android.gms.internal.zzqp;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzg {
    private Context mContext;
    private final Object zzrN;
    public final zzhx zzsX;

    /* renamed from: com.google.android.gms.ads.internal.zzg.1 */
    class C05101 implements zzhx {
        final /* synthetic */ zzg zzsY;

        C05101(zzg com_google_android_gms_ads_internal_zzg) {
            this.zzsY = com_google_android_gms_ads_internal_zzg;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            com_google_android_gms_internal_zzqp.zzb("/appSettingsFetched", this);
            synchronized (this.zzsY.zzrN) {
                if (map != null) {
                    if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                        zzv.zzcN().zzd(this.zzsY.mContext, (String) map.get("appSettingsJson"));
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzg.2 */
    class C05122 implements Runnable {
        final /* synthetic */ zzg zzsY;
        final /* synthetic */ zzja zzsZ;
        final /* synthetic */ String zzta;
        final /* synthetic */ String zztb;
        final /* synthetic */ boolean zztc;
        final /* synthetic */ Context zztd;

        /* renamed from: com.google.android.gms.ads.internal.zzg.2.1 */
        class C05111 implements zzc<zzjb> {
            final /* synthetic */ C05122 zzte;

            C05111(C05122 c05122) {
                this.zzte = c05122;
            }

            public void zzb(zzjb com_google_android_gms_internal_zzjb) {
                com_google_android_gms_internal_zzjb.zza("/appSettingsFetched", this.zzte.zzsY.zzsX);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(this.zzte.zzta)) {
                        jSONObject.put("app_id", this.zzte.zzta);
                    } else if (!TextUtils.isEmpty(this.zzte.zztb)) {
                        jSONObject.put("ad_unit_id", this.zzte.zztb);
                    }
                    jSONObject.put("is_init", this.zzte.zztc);
                    jSONObject.put("pn", this.zzte.zztd.getPackageName());
                    com_google_android_gms_internal_zzjb.zza("AFMA_fetchAppSettings", jSONObject);
                } catch (Throwable e) {
                    com_google_android_gms_internal_zzjb.zzb("/appSettingsFetched", this.zzte.zzsY.zzsX);
                    zzpy.zzb("Error requesting application settings", e);
                }
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        C05122(zzg com_google_android_gms_ads_internal_zzg, zzja com_google_android_gms_internal_zzja, String str, String str2, boolean z, Context context) {
            this.zzsY = com_google_android_gms_ads_internal_zzg;
            this.zzsZ = com_google_android_gms_internal_zzja;
            this.zzta = str;
            this.zztb = str2;
            this.zztc = z;
            this.zztd = context;
        }

        public void run() {
            this.zzsZ.zzgv().zza(new C05111(this), new zzb());
        }
    }

    public zzg() {
        this.zzrN = new Object();
        this.zzsX = new C05101(this);
    }

    private static boolean zza(@Nullable zzox com_google_android_gms_internal_zzox) {
        if (com_google_android_gms_internal_zzox == null) {
            return true;
        }
        boolean z = (((zzv.zzcP().currentTimeMillis() - com_google_android_gms_internal_zzox.zzjF()) > ((Long) zzfx.zzEr.get()).longValue() ? 1 : ((zzv.zzcP().currentTimeMillis() - com_google_android_gms_internal_zzox.zzjF()) == ((Long) zzfx.zzEr.get()).longValue() ? 0 : -1)) > 0) || !com_google_android_gms_internal_zzox.zzjG();
        return z;
    }

    public void zza(Context context, zzqa com_google_android_gms_internal_zzqa, boolean z, @Nullable zzox com_google_android_gms_internal_zzox, String str, @Nullable String str2) {
        if (!zza(com_google_android_gms_internal_zzox)) {
            return;
        }
        if (context == null) {
            zzpy.zzbe("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            zzpy.zzbe("App settings could not be fetched. Required parameters missing");
        } else {
            this.mContext = context;
            zzpi.zzWR.post(new C05122(this, zzv.zzcJ().zzd(context, com_google_android_gms_internal_zzqa), str, str2, z, context));
        }
    }
}
