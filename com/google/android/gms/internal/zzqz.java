package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzv;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.protocol.HTTP;

@TargetApi(11)
@zzmb
public class zzqz extends zzqq {
    public zzqz(zzqp com_google_android_gms_internal_zzqp, boolean z) {
        super(com_google_android_gms_internal_zzqp, z);
    }

    protected WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        Exception e;
        String valueOf;
        if (webView instanceof zzqp) {
            zzqp com_google_android_gms_internal_zzqp = (zzqp) webView;
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (com_google_android_gms_internal_zzqp.zzkV() != null) {
                com_google_android_gms_internal_zzqp.zzkV().zzhl();
            }
            String str2 = com_google_android_gms_internal_zzqp.zzbD().zzzl ? (String) zzfx.zzBJ.get() : com_google_android_gms_internal_zzqp.zzkZ() ? (String) zzfx.zzBI.get() : (String) zzfx.zzBH.get();
            try {
                return zzf(com_google_android_gms_internal_zzqp.getContext(), com_google_android_gms_internal_zzqp.zzkY().zzaZ, str2);
            } catch (IOException e2) {
                e = e2;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                zzpy.zzbe(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzpy.zzbe(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (InterruptedException e4) {
                e = e4;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzpy.zzbe(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            } catch (TimeoutException e5) {
                e = e5;
                str2 = "Could not fetch MRAID JS. ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                zzpy.zzbe(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
        }
        zzpy.zzbe("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }

    protected WebResourceResponse zzf(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        Map hashMap = new HashMap();
        hashMap.put(HTTP.USER_AGENT, zzv.zzcJ().zzh(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzpp(context).zzc(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", HTTP.UTF_8, new ByteArrayInputStream(str3.getBytes(HTTP.UTF_8)));
    }
}
