package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(21)
@zzmb
public class zzrb extends zzqz {
    public zzrb(zzqp com_google_android_gms_internal_zzqp, boolean z) {
        super(com_google_android_gms_internal_zzqp, z);
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : zza(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
