package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@zzmb
public final class zzie implements zzhx {
    private final zze zzHN;
    private final zzkj zzHO;
    private final zzhz zzHQ;

    public zzie(zzhz com_google_android_gms_internal_zzhz, zze com_google_android_gms_ads_internal_zze, zzkj com_google_android_gms_internal_zzkj) {
        this.zzHQ = com_google_android_gms_internal_zzhz;
        this.zzHN = com_google_android_gms_ads_internal_zze;
        this.zzHO = com_google_android_gms_internal_zzkj;
    }

    private static boolean zzd(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzv.zzcL().zzkq();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzv.zzcL().zzkp();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzv.zzcL().zzkr();
            }
        }
        return -1;
    }

    private static void zzf(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
        Context context = com_google_android_gms_internal_zzqp.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            zzpy.zzbe("Destination url cannot be empty.");
            return;
        }
        try {
            com_google_android_gms_internal_zzqp.zzkV().zza(new zzc(new zza(com_google_android_gms_internal_zzqp).zza(context, map)));
        } catch (ActivityNotFoundException e) {
            zzpy.zzbe(e.getMessage());
        }
    }

    private void zzr(boolean z) {
        if (this.zzHO != null) {
            this.zzHO.zzs(z);
        }
    }

    public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            zzpy.zzbe("Action missing from an open GMSG.");
        } else if (this.zzHN == null || this.zzHN.zzcb()) {
            zzqq zzkV = com_google_android_gms_internal_zzqp.zzkV();
            if ("expand".equalsIgnoreCase(str)) {
                if (com_google_android_gms_internal_zzqp.zzkZ()) {
                    zzpy.zzbe("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzr(false);
                zzkV.zza(zzd(map), zze(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                zzr(false);
                if (str != null) {
                    zzkV.zza(zzd(map), zze(map), str);
                } else {
                    zzkV.zza(zzd(map), zze(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.zzHQ == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.zzHQ.zza(str, new ArrayList());
                } else {
                    this.zzHQ.zza(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                zzr(true);
                zzf(com_google_android_gms_internal_zzqp, map);
            } else {
                zzr(true);
                str = (String) map.get("u");
                zzkV.zza(new zzc((String) map.get("i"), !TextUtils.isEmpty(str) ? zzv.zzcJ().zza(com_google_android_gms_internal_zzqp, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.zzHN.zzx((String) map.get("u"));
        }
    }
}
