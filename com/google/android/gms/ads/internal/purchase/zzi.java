package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpy;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzi {

    /* renamed from: com.google.android.gms.ads.internal.purchase.zzi.1 */
    class C04971 implements ServiceConnection {
        final /* synthetic */ Context zztd;

        C04971(zzi com_google_android_gms_ads_internal_purchase_zzi, Context context) {
            this.zztd = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = false;
            zzb com_google_android_gms_ads_internal_purchase_zzb = new zzb(this.zztd.getApplicationContext(), false);
            com_google_android_gms_ads_internal_purchase_zzb.zzV(iBinder);
            int zzb = com_google_android_gms_ads_internal_purchase_zzb.zzb(3, this.zztd.getPackageName(), "inapp");
            zzoy zzcN = zzv.zzcN();
            if (zzb == 0) {
                z = true;
            }
            zzcN.zzH(z);
            zza.zzyc().zza(this.zztd, this);
            com_google_android_gms_ads_internal_purchase_zzb.destroy();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.zza(intent, gInAppPurchaseManagerInfoParcel);
        zzv.zzcJ().zzb(context, intent);
    }

    public String zzaD(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                zzpy.zzbe("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String zzaE(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                zzpy.zzbe("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public int zzd(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            zzpy.zzbe("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String str = "Unexpected type for intent response code. ";
            String valueOf = String.valueOf(obj.getClass().getName());
            zzpy.zzbe(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 5;
        }
    }

    public int zzd(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzpy.zzbe("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String str = "Unexpected type for intent response code. ";
            String valueOf = String.valueOf(obj.getClass().getName());
            zzpy.zzbe(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 5;
        }
    }

    public String zze(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String zzf(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }

    public void zzr(Context context) {
        ServiceConnection c04971 = new C04971(this, context);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        zza.zzyc().zza(context, intent, c04971, 1);
    }
}
