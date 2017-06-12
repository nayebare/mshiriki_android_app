package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import com.google.android.gms.drive.ExecutionOptions;
import java.util.List;

@zzmb
public class zzgl implements zzbvb {
    @Nullable
    private CustomTabsSession zzFA;
    @Nullable
    private CustomTabsClient zzFB;
    @Nullable
    private CustomTabsServiceConnection zzFC;
    @Nullable
    private zza zzFD;

    public static boolean zzn(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(zzbuz.zzcf(context));
            }
        }
        return false;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.zzFB == null) {
            return false;
        }
        CustomTabsSession zzfC = zzfC();
        return zzfC != null ? zzfC.mayLaunchUrl(uri, bundle, list) : false;
    }

    public void zza(CustomTabsClient customTabsClient) {
        this.zzFB = customTabsClient;
        this.zzFB.warmup(0);
        if (this.zzFD != null) {
            this.zzFD.zzfE();
        }
    }

    public void zza(zza com_google_android_gms_internal_zzgl_zza) {
        this.zzFD = com_google_android_gms_internal_zzgl_zza;
    }

    public void zzd(Activity activity) {
        if (this.zzFC != null) {
            activity.unbindService(this.zzFC);
            this.zzFB = null;
            this.zzFA = null;
            this.zzFC = null;
        }
    }

    public void zze(Activity activity) {
        if (this.zzFB == null) {
            String zzcf = zzbuz.zzcf(activity);
            if (zzcf != null) {
                this.zzFC = new zzbva(this);
                CustomTabsClient.bindCustomTabsService(activity, zzcf, this.zzFC);
            }
        }
    }

    @Nullable
    public CustomTabsSession zzfC() {
        if (this.zzFB == null) {
            this.zzFA = null;
        } else if (this.zzFA == null) {
            this.zzFA = this.zzFB.newSession(null);
        }
        return this.zzFA;
    }

    public void zzfD() {
        this.zzFB = null;
        this.zzFA = null;
        if (this.zzFD != null) {
            this.zzFD.zzfF();
        }
    }
}
