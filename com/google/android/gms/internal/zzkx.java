package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzmb
public class zzkx implements zzkv {
    private final Context mContext;
    final Set<WebView> zzOG;

    public zzkx(Context context) {
        this.zzOG = Collections.synchronizedSet(new HashSet());
        this.mContext = context;
    }

    public void zza(String str, String str2, String str3) {
        zzpy.zzbc("Fetching assets for the given html");
        zzpi.zzWR.post(new 1(this, str2, str3));
    }

    public WebView zzij() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
