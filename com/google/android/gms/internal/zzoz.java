package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzoz {
    final String zzVW;
    int zzWo;
    long zzWp;
    long zzWq;
    int zzWr;
    int zzWs;
    int zzWt;
    private final Object zzrN;

    public zzoz(String str) {
        this.zzWp = -1;
        this.zzWq = -1;
        this.zzWr = -1;
        this.zzWo = -1;
        this.zzrN = new Object();
        this.zzWs = 0;
        this.zzWt = 0;
        this.zzVW = str;
    }

    public static boolean zzx(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", SystemMediaRouteProvider.PACKAGE_NAME);
        if (identifier == 0) {
            zzpy.zzbd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzpy.zzbd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            zzpy.zzbe("Fail to fetch AdActivity theme");
            zzpy.zzbd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzag(int i) {
        this.zzWo = i;
    }

    public void zzb(zzdy com_google_android_gms_internal_zzdy, long j) {
        synchronized (this.zzrN) {
            if (this.zzWq == -1) {
                if (j - zzv.zzcN().zzjV() > ((Long) zzfx.zzCv.get()).longValue()) {
                    zzag(-1);
                } else {
                    zzag(zzv.zzcN().zzjW());
                }
                this.zzWq = j;
                this.zzWp = this.zzWq;
            } else {
                this.zzWp = j;
            }
            if (com_google_android_gms_internal_zzdy.extras == null || com_google_android_gms_internal_zzdy.extras.getInt("gw", 2) != 1) {
                this.zzWr++;
                this.zzWo++;
                return;
            }
        }
    }

    public Bundle zze(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzrN) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzVW);
            bundle.putLong("basets", this.zzWq);
            bundle.putLong("currts", this.zzWp);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzWr);
            bundle.putInt("preqs_in_session", this.zzWo);
            bundle.putInt("pclick", this.zzWs);
            bundle.putInt("pimp", this.zzWt);
            bundle.putBoolean("support_transparent_background", zzx(context));
        }
        return bundle;
    }

    public void zzjA() {
        synchronized (this.zzrN) {
            this.zzWs++;
        }
    }

    public int zzjW() {
        return this.zzWo;
    }

    public void zzjz() {
        synchronized (this.zzrN) {
            this.zzWt++;
        }
    }

    public long zzkd() {
        return this.zzWq;
    }
}
