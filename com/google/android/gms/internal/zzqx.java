package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
@zzmb
public class zzqx extends zzqz {
    public zzqx(zzqp com_google_android_gms_internal_zzqp, boolean z) {
        super(com_google_android_gms_internal_zzqp, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, null);
    }
}
