package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.TransportMediator;
import android.support.v7.mediarouter.C0308R;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.mikephil.charting.BuildConfig;
import com.google.ads.AdSize;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.iid.InstanceID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzmb
public class zzqq extends WebViewClient {
    private static final String[] zzYA;
    private static final String[] zzYB;
    protected zzqp zzGt;
    private zzib zzHL;
    private zze zzHN;
    private zzkj zzHO;
    private zzhz zzHQ;
    private zzht zzHc;
    private zzkp zzLz;
    private zza zzPx;
    private final HashMap<String, List<zzhx>> zzYC;
    private zzh zzYD;
    private zzb zzYE;
    private zzc zzYF;
    private boolean zzYG;
    private boolean zzYH;
    private OnGlobalLayoutListener zzYI;
    private OnScrollChangedListener zzYJ;
    private boolean zzYK;
    private zzq zzYL;
    private final zzkn zzYM;
    private zze zzYN;
    @Nullable
    protected zzop zzYO;
    private boolean zzYP;
    private boolean zzYQ;
    private boolean zzYR;
    private int zzYS;
    private final Object zzrN;
    private boolean zzvV;
    private zzdt zzyD;

    static {
        zzYA = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", InstanceID.ERROR_TIMEOUT, "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
        zzYB = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    }

    public zzqq(zzqp com_google_android_gms_internal_zzqp, boolean z) {
        this(com_google_android_gms_internal_zzqp, z, new zzkn(com_google_android_gms_internal_zzqp, com_google_android_gms_internal_zzqp.zzkS(), new zzfp(com_google_android_gms_internal_zzqp.getContext())), null);
    }

    zzqq(zzqp com_google_android_gms_internal_zzqp, boolean z, zzkn com_google_android_gms_internal_zzkn, zzkj com_google_android_gms_internal_zzkj) {
        this.zzYC = new HashMap();
        this.zzrN = new Object();
        this.zzYG = false;
        this.zzGt = com_google_android_gms_internal_zzqp;
        this.zzvV = z;
        this.zzYM = com_google_android_gms_internal_zzkn;
        this.zzHO = com_google_android_gms_internal_zzkj;
    }

    private void zzb(Context context, String str, String str2, String str3) {
        if (((Boolean) zzfx.zzCS.get()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompatApi24.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            bundle.putString("host", zzbh(str3));
            zzv.zzcJ().zza(context, this.zzGt.zzkY().zzaZ, "gmob-apps", bundle, true);
        }
    }

    private String zzbh(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : BuildConfig.FLAVOR;
    }

    private static boolean zzi(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzlx() {
        if (this.zzYE != null) {
            this.zzYE.zzk(this.zzGt);
            this.zzYE = null;
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        zzpe.m26v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzrN) {
            if (this.zzYP) {
                zzpe.m26v("Blank page loaded, 1...");
                this.zzGt.zzla();
                return;
            }
            this.zzYQ = true;
            zzlx();
            zzly();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= zzYA.length) ? String.valueOf(i) : zzYA[(-i) - 1];
        zzb(this.zzGt.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= zzYB.length) ? String.valueOf(primaryError) : zzYB[primaryError];
            zzb(this.zzGt.getContext(), "ssl_err", valueOf, zzv.zzcL().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.zzYO != null) {
            this.zzYO = null;
        }
        synchronized (this.zzrN) {
            this.zzYC.clear();
            this.zzyD = null;
            this.zzYD = null;
            this.zzPx = null;
            this.zzYE = null;
            this.zzHc = null;
            this.zzYG = false;
            this.zzvV = false;
            this.zzYH = false;
            this.zzYK = false;
            this.zzHQ = null;
            this.zzYL = null;
            this.zzYF = null;
            if (this.zzHO != null) {
                this.zzHO.zzs(true);
                this.zzHO = null;
            }
        }
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            zzdo zzJ = zzdo.zzJ(str);
            if (zzJ == null) {
                return null;
            }
            zzdl zza = zzv.zzcO().zza(zzJ);
            return (zza == null || !zza.zzer()) ? null : new WebResourceResponse(BuildConfig.FLAVOR, BuildConfig.FLAVOR, zza.zzes());
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case C0308R.styleable.AppCompatTheme_panelBackground /*79*/:
            case C0308R.styleable.AppCompatTheme_colorAccent /*85*/:
            case C0308R.styleable.AppCompatTheme_colorControlNormal /*86*/:
            case C0308R.styleable.AppCompatTheme_colorControlActivated /*87*/:
            case C0308R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
            case C0308R.styleable.AppCompatTheme_colorButtonNormal /*89*/:
            case AdSize.LARGE_AD_HEIGHT /*90*/:
            case C0308R.styleable.AppCompatTheme_controlBackground /*91*/:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case Cast.MAX_NAMESPACE_LENGTH /*128*/:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        zzpe.m26v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        } else if (this.zzYG && webView == this.zzGt.getWebView() && zzi(parse)) {
            if (this.zzyD != null && ((Boolean) zzfx.zzCi.get()).booleanValue()) {
                this.zzyD.onAdClicked();
                this.zzyD = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.zzGt.getWebView().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(str);
            zzpy.zzbe(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri;
            try {
                zzav zzkX = this.zzGt.zzkX();
                if (zzkX != null && zzkX.zzc(parse)) {
                    parse = zzkX.zza(parse, this.zzGt.getContext(), this.zzGt.getView());
                }
                uri = parse;
            } catch (zzaw e) {
                String str3 = "Unable to append parameter to URL: ";
                str2 = String.valueOf(str);
                zzpy.zzbe(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                uri = parse;
            }
            if (this.zzHN == null || this.zzHN.zzcb()) {
                zza(new zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzHN.zzx(str);
            }
        }
        return true;
    }

    public void zzN(boolean z) {
        this.zzYG = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzYM.zze(i, i2);
        if (this.zzHO != null) {
            this.zzHO.zza(i, i2, z);
        }
    }

    public final void zza(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.zzrN) {
            this.zzYH = true;
            this.zzGt.zzli();
            this.zzYI = onGlobalLayoutListener;
            this.zzYJ = onScrollChangedListener;
        }
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzgR = this.zzHO != null ? this.zzHO.zzgR() : false;
        zzf zzcH = zzv.zzcH();
        Context context = this.zzGt.getContext();
        if (!zzgR) {
            z = true;
        }
        zzcH.zza(context, adOverlayInfoParcel, z);
        if (this.zzYO != null && adOverlayInfoParcel.url == null && adOverlayInfoParcel.zzMW != null) {
            String str = adOverlayInfoParcel.zzMW.url;
        }
    }

    public final void zza(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean zzkZ = this.zzGt.zzkZ();
        zzdt com_google_android_gms_internal_zzdt = (!zzkZ || this.zzGt.zzbD().zzzl) ? this.zzyD : null;
        if (!zzkZ) {
            com_google_android_gms_ads_internal_overlay_zzh = this.zzYD;
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, com_google_android_gms_internal_zzdt, com_google_android_gms_ads_internal_overlay_zzh, this.zzYL, this.zzGt.zzkY()));
    }

    public void zza(zzdt com_google_android_gms_internal_zzdt, zzh com_google_android_gms_ads_internal_overlay_zzh, zzht com_google_android_gms_internal_zzht, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, zzhz com_google_android_gms_internal_zzhz, @Nullable zzib com_google_android_gms_internal_zzib, zze com_google_android_gms_ads_internal_zze, zzkp com_google_android_gms_internal_zzkp, @Nullable zzop com_google_android_gms_internal_zzop) {
        if (com_google_android_gms_ads_internal_zze == null) {
            com_google_android_gms_ads_internal_zze = new zze(this.zzGt.getContext());
        }
        this.zzHO = new zzkj(this.zzGt, com_google_android_gms_internal_zzkp);
        this.zzYO = com_google_android_gms_internal_zzop;
        zza("/appEvent", new zzhs(com_google_android_gms_internal_zzht));
        zza("/backButton", zzhw.zzHo);
        zza("/refresh", zzhw.zzHp);
        zza("/canOpenURLs", zzhw.zzHe);
        zza("/canOpenIntents", zzhw.zzHf);
        zza("/click", zzhw.zzHg);
        zza("/close", zzhw.zzHh);
        zza("/customClose", zzhw.zzHj);
        zza("/instrument", zzhw.zzHt);
        zza("/delayPageLoaded", zzhw.zzHv);
        zza("/delayPageClosed", zzhw.zzHw);
        zza("/getLocationInfo", zzhw.zzHx);
        zza("/httpTrack", zzhw.zzHk);
        zza("/log", zzhw.zzHl);
        zza("/mraid", new zzid(com_google_android_gms_ads_internal_zze, this.zzHO));
        zza("/mraidLoaded", this.zzYM);
        zza("/open", new zzie(com_google_android_gms_internal_zzhz, com_google_android_gms_ads_internal_zze, this.zzHO));
        zza("/precache", zzhw.zzHs);
        zza("/touch", zzhw.zzHn);
        zza("/video", zzhw.zzHq);
        zza("/videoMeta", zzhw.zzHr);
        zza("/appStreaming", zzhw.zzHi);
        if (com_google_android_gms_internal_zzib != null) {
            zza("/setInterstitialProperties", new zzia(com_google_android_gms_internal_zzib));
        }
        this.zzyD = com_google_android_gms_internal_zzdt;
        this.zzYD = com_google_android_gms_ads_internal_overlay_zzh;
        this.zzHc = com_google_android_gms_internal_zzht;
        this.zzHQ = com_google_android_gms_internal_zzhz;
        this.zzYL = com_google_android_gms_ads_internal_overlay_zzq;
        this.zzHN = com_google_android_gms_ads_internal_zze;
        this.zzLz = com_google_android_gms_internal_zzkp;
        this.zzHL = com_google_android_gms_internal_zzib;
        zzN(z);
    }

    public void zza(zza com_google_android_gms_internal_zzqq_zza) {
        this.zzPx = com_google_android_gms_internal_zzqq_zza;
    }

    public void zza(zzb com_google_android_gms_internal_zzqq_zzb) {
        this.zzYE = com_google_android_gms_internal_zzqq_zzb;
    }

    public void zza(zzc com_google_android_gms_internal_zzqq_zzc) {
        this.zzYF = com_google_android_gms_internal_zzqq_zzc;
    }

    public void zza(zze com_google_android_gms_internal_zzqq_zze) {
        this.zzYN = com_google_android_gms_internal_zzqq_zze;
    }

    public void zza(String str, zzhx com_google_android_gms_internal_zzhx) {
        synchronized (this.zzrN) {
            List list = (List) this.zzYC.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzYC.put(str, list);
            }
            list.add(com_google_android_gms_internal_zzhx);
        }
    }

    public final void zza(boolean z, int i) {
        zzdt com_google_android_gms_internal_zzdt = (!this.zzGt.zzkZ() || this.zzGt.zzbD().zzzl) ? this.zzyD : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_internal_zzdt, this.zzYD, this.zzYL, this.zzGt, z, i, this.zzGt.zzkY()));
    }

    public final void zza(boolean z, int i, String str) {
        zzh com_google_android_gms_ads_internal_overlay_zzh = null;
        boolean zzkZ = this.zzGt.zzkZ();
        zzdt com_google_android_gms_internal_zzdt = (!zzkZ || this.zzGt.zzbD().zzzl) ? this.zzyD : null;
        if (!zzkZ) {
            com_google_android_gms_ads_internal_overlay_zzh = new zzd(this.zzGt, this.zzYD);
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_internal_zzdt, com_google_android_gms_ads_internal_overlay_zzh, this.zzHc, this.zzYL, this.zzGt, z, i, str, this.zzGt.zzkY(), this.zzHQ));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzkZ = this.zzGt.zzkZ();
        zzdt com_google_android_gms_internal_zzdt = (!zzkZ || this.zzGt.zzbD().zzzl) ? this.zzyD : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_internal_zzdt, zzkZ ? null : new zzd(this.zzGt, this.zzYD), this.zzHc, this.zzYL, this.zzGt, z, i, str, str2, this.zzGt.zzkY(), this.zzHQ));
    }

    public void zzb(String str, zzhx com_google_android_gms_internal_zzhx) {
        synchronized (this.zzrN) {
            List list = (List) this.zzYC.get(str);
            if (list == null) {
                return;
            }
            list.remove(com_google_android_gms_internal_zzhx);
        }
    }

    public void zzd(int i, int i2) {
        if (this.zzHO != null) {
            this.zzHO.zzd(i, i2);
        }
    }

    public boolean zzdz() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzvV;
        }
        return z;
    }

    public final void zzhl() {
        synchronized (this.zzrN) {
            this.zzYG = false;
            this.zzvV = true;
            zzv.zzcJ().runOnUiThread(new 2(this));
        }
    }

    public void zzj(Uri uri) {
        String path = uri.getPath();
        List<zzhx> list = (List) this.zzYC.get(path);
        if (list != null) {
            Map zzg = zzv.zzcJ().zzg(uri);
            if (zzpy.zzai(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                zzpe.m26v(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : zzg.keySet()) {
                    str = (String) zzg.get(path2);
                    zzpe.m26v(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (zzhx zza : list) {
                zza.zza(this.zzGt, zzg);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        zzpe.m26v(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    public zze zzln() {
        return this.zzHN;
    }

    public boolean zzlo() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzYH;
        }
        return z;
    }

    public OnGlobalLayoutListener zzlp() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.zzrN) {
            onGlobalLayoutListener = this.zzYI;
        }
        return onGlobalLayoutListener;
    }

    public OnScrollChangedListener zzlq() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.zzrN) {
            onScrollChangedListener = this.zzYJ;
        }
        return onScrollChangedListener;
    }

    public boolean zzlr() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzYK;
        }
        return z;
    }

    public void zzls() {
        synchronized (this.zzrN) {
            zzpe.m26v("Loading blank page in WebView, 2...");
            this.zzYP = true;
            this.zzGt.zzbf("about:blank");
        }
    }

    public void zzlt() {
        if (this.zzYO != null) {
            zzpi.zzWR.post(new 1(this));
        }
    }

    public void zzlu() {
        synchronized (this.zzrN) {
            this.zzYK = true;
        }
        this.zzYS++;
        zzly();
    }

    public void zzlv() {
        this.zzYS--;
        zzly();
    }

    public void zzlw() {
        this.zzYR = true;
        zzly();
    }

    public final void zzly() {
        if (this.zzPx != null && ((this.zzYQ && this.zzYS <= 0) || this.zzYR)) {
            this.zzPx.zza(this.zzGt, !this.zzYR);
            this.zzPx = null;
        }
        this.zzGt.zzlj();
    }

    public zze zzlz() {
        return this.zzYN;
    }

    public void zzo(zzqp com_google_android_gms_internal_zzqp) {
        this.zzGt = com_google_android_gms_internal_zzqp;
    }
}
