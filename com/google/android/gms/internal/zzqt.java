package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bumptech.glide.request.target.Target;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.wearable.MessageApi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
class zzqt extends WebView implements OnGlobalLayoutListener, DownloadListener, zzqp {
    @Nullable
    private final zzav zzGr;
    private int zzLQ;
    private int zzLR;
    private int zzLT;
    private int zzLU;
    private String zzOn;
    private zzgd zzOo;
    private Boolean zzWh;
    private final zza zzYX;
    private final zzt zzYY;
    private zzqq zzYZ;
    private zze zzZa;
    private boolean zzZb;
    private boolean zzZc;
    private boolean zzZd;
    private boolean zzZe;
    private int zzZf;
    private boolean zzZg;
    boolean zzZh;
    private zzqu zzZi;
    private boolean zzZj;
    private boolean zzZk;
    private zzgs zzZl;
    private int zzZm;
    private int zzZn;
    private zzgd zzZo;
    private zzgd zzZp;
    private zzge zzZq;
    private WeakReference<OnClickListener> zzZr;
    private zze zzZs;
    private Map<String, zzil> zzZt;
    private final Object zzrN;
    private final zzd zzsz;
    private final zzqa zztr;
    private zzec zzum;
    private zzpw zzvP;
    private final WindowManager zzwf;

    @zzmb
    public static class zza extends MutableContextWrapper {
        private Activity zzXO;
        private Context zzZv;
        private Context zzvZ;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String str) {
            return this.zzZv.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.zzvZ = context.getApplicationContext();
            this.zzXO = context instanceof Activity ? (Activity) context : null;
            this.zzZv = context;
            super.setBaseContext(this.zzvZ);
        }

        public void startActivity(Intent intent) {
            if (this.zzXO != null) {
                this.zzXO.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.zzvZ.startActivity(intent);
        }

        public Activity zzkR() {
            return this.zzXO;
        }

        public Context zzkS() {
            return this.zzZv;
        }
    }

    protected zzqt(zza com_google_android_gms_internal_zzqt_zza, zzec com_google_android_gms_internal_zzec, boolean z, boolean z2, @Nullable zzav com_google_android_gms_internal_zzav, zzqa com_google_android_gms_internal_zzqa, zzgf com_google_android_gms_internal_zzgf, zzt com_google_android_gms_ads_internal_zzt, zzd com_google_android_gms_ads_internal_zzd) {
        super(com_google_android_gms_internal_zzqt_zza);
        this.zzrN = new Object();
        this.zzZg = true;
        this.zzZh = false;
        this.zzOn = BuildConfig.FLAVOR;
        this.zzLR = -1;
        this.zzLQ = -1;
        this.zzLT = -1;
        this.zzLU = -1;
        this.zzYX = com_google_android_gms_internal_zzqt_zza;
        this.zzum = com_google_android_gms_internal_zzec;
        this.zzZd = z;
        this.zzZf = -1;
        this.zzGr = com_google_android_gms_internal_zzav;
        this.zztr = com_google_android_gms_internal_zzqa;
        this.zzYY = com_google_android_gms_ads_internal_zzt;
        this.zzsz = com_google_android_gms_ads_internal_zzd;
        this.zzwf = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzv.zzcJ().zza((Context) com_google_android_gms_internal_zzqt_zza, com_google_android_gms_internal_zzqa.zzaZ, settings);
        zzv.zzcL().zza(getContext(), settings);
        setDownloadListener(this);
        zzlF();
        if (zzs.zzyD()) {
            addJavascriptInterface(new zzqv(this), "googleAdsJsInterface");
        }
        if (zzs.zzyx()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.zzvP = new zzpw(this.zzYX.zzkR(), this, this, null);
        zzd(com_google_android_gms_internal_zzgf);
    }

    private void zzO(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    static zzqt zzb(Context context, zzec com_google_android_gms_internal_zzec, boolean z, boolean z2, @Nullable zzav com_google_android_gms_internal_zzav, zzqa com_google_android_gms_internal_zzqa, zzgf com_google_android_gms_internal_zzgf, zzt com_google_android_gms_ads_internal_zzt, zzd com_google_android_gms_ads_internal_zzd) {
        return new zzqt(new zza(context), com_google_android_gms_internal_zzec, z, z2, com_google_android_gms_internal_zzav, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzgf, com_google_android_gms_ads_internal_zzt, com_google_android_gms_ads_internal_zzd);
    }

    private void zzd(zzgf com_google_android_gms_internal_zzgf) {
        zzlJ();
        this.zzZq = new zzge(new zzgf(true, "make_wv", this.zzum.zzzk));
        this.zzZq.zzfv().zzc(com_google_android_gms_internal_zzgf);
        this.zzOo = zzgb.zzb(this.zzZq.zzfv());
        this.zzZq.zza("native:view_create", this.zzOo);
        this.zzZp = null;
        this.zzZo = null;
    }

    private void zzlB() {
        synchronized (this.zzrN) {
            this.zzWh = zzv.zzcN().zzjT();
            if (this.zzWh == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zzb(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzlC() {
        zzgb.zza(this.zzZq.zzfv(), this.zzOo, "aeh2");
    }

    private void zzlD() {
        zzgb.zza(this.zzZq.zzfv(), this.zzOo, "aebb2");
    }

    private void zzlF() {
        synchronized (this.zzrN) {
            if (this.zzZd || this.zzum.zzzl) {
                if (VERSION.SDK_INT < 14) {
                    zzpy.zzbc("Disabling hardware acceleration on an overlay.");
                    zzlG();
                } else {
                    zzpy.zzbc("Enabling hardware acceleration on an overlay.");
                    zzlH();
                }
            } else if (VERSION.SDK_INT < 18) {
                zzpy.zzbc("Disabling hardware acceleration on an AdView.");
                zzlG();
            } else {
                zzpy.zzbc("Enabling hardware acceleration on an AdView.");
                zzlH();
            }
        }
    }

    private void zzlG() {
        synchronized (this.zzrN) {
            if (!this.zzZe) {
                zzv.zzcL().zzu(this);
            }
            this.zzZe = true;
        }
    }

    private void zzlH() {
        synchronized (this.zzrN) {
            if (this.zzZe) {
                zzv.zzcL().zzt(this);
            }
            this.zzZe = false;
        }
    }

    private void zzlI() {
        synchronized (this.zzrN) {
            this.zzZt = null;
        }
    }

    private void zzlJ() {
        if (this.zzZq != null) {
            zzgf zzfv = this.zzZq.zzfv();
            if (zzfv != null && zzv.zzcN().zzjN() != null) {
                zzv.zzcN().zzjN().zza(zzfv);
            }
        }
    }

    public void destroy() {
        synchronized (this.zzrN) {
            zzlJ();
            this.zzvP.zzkF();
            if (this.zzZa != null) {
                this.zzZa.close();
                this.zzZa.onDestroy();
                this.zzZa = null;
            }
            this.zzYZ.reset();
            if (this.zzZc) {
                return;
            }
            zzv.zzdg().zze(this);
            zzlI();
            this.zzZc = true;
            zzpe.m26v("Initiating WebView self destruct sequence in 3...");
            this.zzYZ.zzls();
        }
    }

    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                zzpy.zzbe("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    protected void finalize() throws Throwable {
        synchronized (this.zzrN) {
            if (!this.zzZc) {
                this.zzYZ.reset();
                zzv.zzdg().zze(this);
                zzlI();
            }
        }
        super.finalize();
    }

    public String getRequestId() {
        String str;
        synchronized (this.zzrN) {
            str = this.zzOn;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzrN) {
            i = this.zzZf;
        }
        return i;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZc;
        }
        return z;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                zzpy.zzbe("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                zzpy.zzbe("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                zzpy.zzbe("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String valueOf = String.valueOf(th);
                    zzpy.zzbe(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.zzrN) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzvP.onAttachedToWindow();
            }
            boolean z2 = this.zzZj;
            if (zzkV() == null || !zzkV().zzlo()) {
                z = z2;
            } else if (!this.zzZk) {
                OnGlobalLayoutListener zzlp = zzkV().zzlp();
                if (zzlp != null) {
                    zzv.zzdh().zza(getView(), zzlp);
                }
                OnScrollChangedListener zzlq = zzkV().zzlq();
                if (zzlq != null) {
                    zzv.zzdh().zza(getView(), zzlq);
                }
                this.zzZk = true;
            }
            zzO(z);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.zzrN) {
            if (!isDestroyed()) {
                this.zzvP.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzZk && zzkV() != null && zzkV().zzlo() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener zzlp = zzkV().zzlp();
                if (zzlp != null) {
                    zzv.zzcL().zza(getViewTreeObserver(), zzlp);
                }
                OnScrollChangedListener zzlq = zzkV().zzlq();
                if (zzlq != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzlq);
                }
                this.zzZk = false;
            }
        }
        zzO(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzv.zzcJ().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzpy.zzbc(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (zzkV() != null && zzkV().zzlz() != null) {
                    zzkV().zzlz().zzcc();
                }
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) zzfx.zzCp.get()).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if ((motionEvent.getActionMasked() == 8 ? 1 : 0) != 0 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onGlobalLayout() {
        boolean zzlA = zzlA();
        zze zzkT = zzkT();
        if (zzkT != null && zzlA) {
            zzkT.zzho();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        int i3 = Strategy.TTL_SECONDS_INFINITE;
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.zzZd || this.zzum.zzzn) {
                super.onMeasure(i, i2);
            } else if (this.zzum.zzzo) {
                if (((Boolean) zzfx.zzEe.get()).booleanValue() || !zzs.zzyD()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zza("/contentHeight", zzlE());
                zzbj("(function() {  var height = -1;  if (document.body) { height = document.body.offsetHeight;}  else if (document.documentElement) {      height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  window.googleAdsJsInterface.notify(url);  })();");
                r0 = this.zzYX.getResources().getDisplayMetrics().density;
                r1 = MeasureSpec.getSize(i);
                switch (this.zzZn) {
                    case MessageApi.UNKNOWN_REQUEST_ID /*-1*/:
                        i3 = MeasureSpec.getSize(i2);
                        break;
                    default:
                        i3 = (int) (r0 * ((float) this.zzZn));
                        break;
                }
                setMeasuredDimension(r1, i3);
            } else if (this.zzum.zzzl) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.zzwf.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                r1 = MeasureSpec.getSize(i2);
                mode = (mode == Target.SIZE_ORIGINAL || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == Target.SIZE_ORIGINAL || mode2 == 1073741824) {
                    i3 = r1;
                }
                if (this.zzum.widthPixels > mode || this.zzum.heightPixels > r0) {
                    r0 = this.zzYX.getResources().getDisplayMetrics().density;
                    mode2 = (int) (((float) this.zzum.heightPixels) / r0);
                    size = (int) (((float) size) / r0);
                    zzpy.zzbe(new StringBuilder(Quests.SELECT_RECENTLY_FAILED).append("Not enough space to show ad. Needs ").append((int) (((float) this.zzum.widthPixels) / r0)).append("x").append(mode2).append(" dp, but only has ").append(size).append("x").append((int) (((float) r1) / r0)).append(" dp.").toString());
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.zzum.widthPixels, this.zzum.heightPixels);
                }
            }
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                if (zzs.zzyx()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                zzpy.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                if (zzs.zzyx()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                zzpy.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (zzkV().zzlo()) {
            synchronized (this.zzrN) {
                if (this.zzZl != null) {
                    this.zzZl.zzc(motionEvent);
                }
            }
        } else if (this.zzGr != null) {
            this.zzGr.zza(motionEvent);
        }
        return isDestroyed() ? false : super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.zzYX.setBaseContext(context);
        this.zzvP.zzl(this.zzYX.zzkR());
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.zzZr = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setRequestedOrientation(int i) {
        synchronized (this.zzrN) {
            this.zzZf = i;
            if (this.zzZa != null) {
                this.zzZa.setRequestedOrientation(this.zzZf);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzqq) {
            this.zzYZ = (zzqq) webViewClient;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzpy.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzJ(boolean z) {
        synchronized (this.zzrN) {
            this.zzZd = z;
            zzlF();
        }
    }

    public void zzK(int i) {
        if (i == 0) {
            zzlD();
        }
        zzlC();
        if (this.zzZq.zzfv() != null) {
            this.zzZq.zzfv().zzg("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zztr.zzaZ);
        zza("onhide", hashMap);
    }

    public void zzK(boolean z) {
        synchronized (this.zzrN) {
            if (this.zzZa != null) {
                this.zzZa.zza(this.zzYZ.zzdz(), z);
            } else {
                this.zzZb = z;
            }
        }
    }

    public void zzL(boolean z) {
        synchronized (this.zzrN) {
            this.zzZg = z;
        }
    }

    public void zzM(boolean z) {
        synchronized (this.zzrN) {
            this.zzZm = (z ? 1 : -1) + this.zzZm;
            if (this.zzZm <= 0 && this.zzZa != null) {
                this.zzZa.zzhr();
            }
        }
    }

    public void zza(Context context, zzec com_google_android_gms_internal_zzec, zzgf com_google_android_gms_internal_zzgf) {
        synchronized (this.zzrN) {
            this.zzvP.zzkF();
            setContext(context);
            this.zzZa = null;
            this.zzum = com_google_android_gms_internal_zzec;
            this.zzZd = false;
            this.zzZb = false;
            this.zzOn = BuildConfig.FLAVOR;
            this.zzZf = -1;
            zzv.zzcL().zzm(this);
            loadUrl("about:blank");
            this.zzYZ.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzZg = true;
            this.zzZh = false;
            this.zzZi = null;
            zzd(com_google_android_gms_internal_zzgf);
            this.zzZj = false;
            this.zzZm = 0;
            zzv.zzdg().zze(this);
            zzlI();
        }
    }

    public void zza(com.google.android.gms.internal.zzcv.zza com_google_android_gms_internal_zzcv_zza) {
        synchronized (this.zzrN) {
            this.zzZj = com_google_android_gms_internal_zzcv_zza.zzxb;
        }
        zzO(com_google_android_gms_internal_zzcv_zza.zzxb);
    }

    public void zza(zzec com_google_android_gms_internal_zzec) {
        synchronized (this.zzrN) {
            this.zzum = com_google_android_gms_internal_zzec;
            requestLayout();
        }
    }

    public void zza(zzqu com_google_android_gms_internal_zzqu) {
        synchronized (this.zzrN) {
            if (this.zzZi != null) {
                zzpy.m25e("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.zzZi = com_google_android_gms_internal_zzqu;
        }
    }

    @TargetApi(19)
    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                zzpy.zzbe("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void zza(String str, zzhx com_google_android_gms_internal_zzhx) {
        if (this.zzYZ != null) {
            this.zzYZ.zza(str, com_google_android_gms_internal_zzhx);
        }
    }

    public void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzv.zzcJ().zzP(map));
        } catch (JSONException e) {
            zzpy.zzbe("Could not convert parameters to JSON.");
        }
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzi(str, jSONObject.toString());
    }

    public void zzb(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.zzrN) {
            this.zzZa = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void zzb(zzgs com_google_android_gms_internal_zzgs) {
        synchronized (this.zzrN) {
            this.zzZl = com_google_android_gms_internal_zzgs;
        }
    }

    void zzb(Boolean bool) {
        synchronized (this.zzrN) {
            this.zzWh = bool;
        }
        zzv.zzcN().zzb(bool);
    }

    public void zzb(String str, zzhx com_google_android_gms_internal_zzhx) {
        if (this.zzYZ != null) {
            this.zzYZ.zzb(str, com_google_android_gms_internal_zzhx);
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        zzpy.zzbc(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        zzbj(stringBuilder.toString());
    }

    public zzec zzbD() {
        zzec com_google_android_gms_internal_zzec;
        synchronized (this.zzrN) {
            com_google_android_gms_internal_zzec = this.zzum;
        }
        return com_google_android_gms_internal_zzec;
    }

    public void zzbV() {
        synchronized (this.zzrN) {
            this.zzZh = true;
            if (this.zzYY != null) {
                this.zzYY.zzbV();
            }
        }
    }

    public void zzbW() {
        synchronized (this.zzrN) {
            this.zzZh = false;
            if (this.zzYY != null) {
                this.zzYY.zzbW();
            }
        }
    }

    public void zzbf(String str) {
        synchronized (this.zzrN) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String valueOf = String.valueOf(th);
                zzpy.zzbe(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
            }
        }
    }

    public void zzbg(String str) {
        synchronized (this.zzrN) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            this.zzOn = str;
        }
    }

    protected void zzbi(String str) {
        synchronized (this.zzrN) {
            if (isDestroyed()) {
                zzpy.zzbe("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzbj(String str) {
        if (zzs.zzyF()) {
            if (zzjT() == null) {
                zzlB();
            }
            if (zzjT().booleanValue()) {
                zza(str, null);
                return;
            }
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            zzbi(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        zzbi(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public zzd zzbz() {
        return this.zzsz;
    }

    public void zzc(zze com_google_android_gms_ads_internal_overlay_zze) {
        synchronized (this.zzrN) {
            this.zzZs = com_google_android_gms_ads_internal_overlay_zze;
        }
    }

    public void zzhp() {
        if (this.zzZo == null) {
            zzgb.zza(this.zzZq.zzfv(), this.zzOo, "aes2");
            this.zzZo = zzgb.zzb(this.zzZq.zzfv());
            this.zzZq.zza("native:view_show", this.zzZo);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zztr.zzaZ);
        zza("onshow", hashMap);
    }

    public void zzi(String str, String str2) {
        zzbj(new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    Boolean zzjT() {
        Boolean bool;
        synchronized (this.zzrN) {
            bool = this.zzWh;
        }
        return bool;
    }

    public void zzkP() {
        zzlC();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zztr.zzaZ);
        zza("onhide", hashMap);
    }

    public void zzkQ() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzv.zzcJ().zzcq()));
        hashMap.put("app_volume", String.valueOf(zzv.zzcJ().zzco()));
        hashMap.put("device_volume", String.valueOf(zzv.zzcJ().zzH(getContext())));
        zza(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, hashMap);
    }

    public Activity zzkR() {
        return this.zzYX.zzkR();
    }

    public Context zzkS() {
        return this.zzYX.zzkS();
    }

    public zze zzkT() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.zzrN) {
            com_google_android_gms_ads_internal_overlay_zze = this.zzZa;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zze zzkU() {
        zze com_google_android_gms_ads_internal_overlay_zze;
        synchronized (this.zzrN) {
            com_google_android_gms_ads_internal_overlay_zze = this.zzZs;
        }
        return com_google_android_gms_ads_internal_overlay_zze;
    }

    public zzqq zzkV() {
        return this.zzYZ;
    }

    public boolean zzkW() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZb;
        }
        return z;
    }

    public zzav zzkX() {
        return this.zzGr;
    }

    public zzqa zzkY() {
        return this.zztr;
    }

    public boolean zzkZ() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZd;
        }
        return z;
    }

    public boolean zzlA() {
        if (!zzkV().zzdz() && !zzkV().zzlo()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics zza = zzv.zzcJ().zza(this.zzwf);
        int zzb = zzeh.zzeO().zzb(zza, zza.widthPixels);
        int zzb2 = zzeh.zzeO().zzb(zza, zza.heightPixels);
        Activity zzkR = zzkR();
        if (zzkR == null || zzkR.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzh = zzv.zzcJ().zzh(zzkR);
            i2 = zzeh.zzeO().zzb(zza, zzh[0]);
            i = zzeh.zzeO().zzb(zza, zzh[1]);
        }
        if (this.zzLQ == zzb && this.zzLR == zzb2 && this.zzLT == i2 && this.zzLU == i) {
            return false;
        }
        boolean z = (this.zzLQ == zzb && this.zzLR == zzb2) ? false : true;
        this.zzLQ = zzb;
        this.zzLR = zzb2;
        this.zzLT = i2;
        this.zzLU = i;
        new zzko(this).zza(zzb, zzb2, i2, i, zza.density, this.zzwf.getDefaultDisplay().getRotation());
        return z;
    }

    zzhx zzlE() {
        return new 1(this);
    }

    public void zzla() {
        synchronized (this.zzrN) {
            zzpe.m26v("Destroying WebView!");
            zzpi.zzWR.post(new 2(this));
        }
    }

    public boolean zzlb() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZg;
        }
        return z;
    }

    public boolean zzlc() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZh;
        }
        return z;
    }

    public zzqo zzld() {
        return null;
    }

    public zzgd zzle() {
        return this.zzOo;
    }

    public zzge zzlf() {
        return this.zzZq;
    }

    public zzqu zzlg() {
        zzqu com_google_android_gms_internal_zzqu;
        synchronized (this.zzrN) {
            com_google_android_gms_internal_zzqu = this.zzZi;
        }
        return com_google_android_gms_internal_zzqu;
    }

    public boolean zzlh() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZm > 0;
        }
        return z;
    }

    public void zzli() {
        this.zzvP.zzkE();
    }

    public void zzlj() {
        if (this.zzZp == null) {
            this.zzZp = zzgb.zzb(this.zzZq.zzfv());
            this.zzZq.zza("native:view_load", this.zzZp);
        }
    }

    public OnClickListener zzlk() {
        return (OnClickListener) this.zzZr.get();
    }

    public zzgs zzll() {
        zzgs com_google_android_gms_internal_zzgs;
        synchronized (this.zzrN) {
            com_google_android_gms_internal_zzgs = this.zzZl;
        }
        return com_google_android_gms_internal_zzgs;
    }

    public void zzlm() {
        setBackgroundColor(0);
    }
}
