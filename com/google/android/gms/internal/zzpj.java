package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@TargetApi(8)
@zzmb
public class zzpj {
    private zzpj() {
    }

    public static zzpj zzah(int i) {
        return i >= 21 ? new zzh() : i >= 19 ? new zzg() : i >= 18 ? new zze() : i >= 17 ? new zzd() : i >= 16 ? new zzf() : i >= 14 ? new zzc() : i >= 11 ? new zzb() : i >= 9 ? new zza() : new zzpj();
    }

    public String getDefaultUserAgent(Context context) {
        return BuildConfig.FLAVOR;
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public CookieManager zzL(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable e) {
            zzpy.zzb("Failed to obtain CookieManager.", e);
            zzv.zzcN().zza(e, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return BuildConfig.FLAVOR;
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public zzqq zzb(zzqp com_google_android_gms_internal_zzqp, boolean z) {
        return new zzqq(com_google_android_gms_internal_zzqp, z);
    }

    public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public Set<String> zzh(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public int zzkp() {
        return 0;
    }

    public int zzkq() {
        return 1;
    }

    public int zzkr() {
        return 5;
    }

    public LayoutParams zzks() {
        return new LayoutParams(-2, -2);
    }

    public boolean zzl(zzqp com_google_android_gms_internal_zzqp) {
        if (com_google_android_gms_internal_zzqp == null) {
            return false;
        }
        com_google_android_gms_internal_zzqp.onPause();
        return true;
    }

    public boolean zzm(zzqp com_google_android_gms_internal_zzqp) {
        if (com_google_android_gms_internal_zzqp == null) {
            return false;
        }
        com_google_android_gms_internal_zzqp.onResume();
        return true;
    }

    public WebChromeClient zzn(zzqp com_google_android_gms_internal_zzqp) {
        return null;
    }

    public boolean zzt(View view) {
        return false;
    }

    public boolean zzu(View view) {
        return false;
    }
}
