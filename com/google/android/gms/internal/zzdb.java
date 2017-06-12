package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzs;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@zzmb
public class zzdb extends Thread {
    private boolean mStarted;
    private boolean zzak;
    private final Object zzrN;
    private boolean zzxD;
    private final zzcz zzxE;
    private final zzma zzxF;
    private final int zzxG;
    private final int zzxH;
    private final int zzxI;
    private final int zzxJ;
    private final int zzxK;
    private final int zzxL;
    private final String zzxM;
    private final int zzxe;
    private final int zzxg;

    @zzmb
    class zza {
        final int zzxU;
        final int zzxV;

        zza(zzdb com_google_android_gms_internal_zzdb, int i, int i2) {
            this.zzxU = i;
            this.zzxV = i2;
        }
    }

    public zzdb(zzcz com_google_android_gms_internal_zzcz, zzma com_google_android_gms_internal_zzma) {
        this.mStarted = false;
        this.zzxD = false;
        this.zzak = false;
        this.zzxE = com_google_android_gms_internal_zzcz;
        this.zzxF = com_google_android_gms_internal_zzma;
        this.zzrN = new Object();
        this.zzxe = ((Integer) zzfx.zzBP.get()).intValue();
        this.zzxH = ((Integer) zzfx.zzBQ.get()).intValue();
        this.zzxg = ((Integer) zzfx.zzBR.get()).intValue();
        this.zzxI = ((Integer) zzfx.zzBS.get()).intValue();
        this.zzxJ = ((Integer) zzfx.zzBV.get()).intValue();
        this.zzxK = ((Integer) zzfx.zzBX.get()).intValue();
        this.zzxL = ((Integer) zzfx.zzBY.get()).intValue();
        this.zzxG = ((Integer) zzfx.zzBT.get()).intValue();
        this.zzxM = (String) zzfx.zzCa.get();
        setName("ContentFetchTask");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.zzef();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        if (r0 == 0) goto L_0x003f;
    L_0x0006:
        r0 = com.google.android.gms.ads.internal.zzv.zzcM();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r0 = r0.getActivity();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        if (r0 != 0) goto L_0x0034;
    L_0x0010:
        r0 = "ContentFetchThread: no activity. Sleeping.";
        com.google.android.gms.internal.zzpy.zzbc(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r3.zzeh();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
    L_0x0018:
        r0 = r3.zzxG;	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
    L_0x0020:
        r1 = r3.zzrN;
        monitor-enter(r1);
    L_0x0023:
        r0 = r3.zzxD;	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0056;
    L_0x0027:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.internal.zzpy.zzbc(r0);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r3.zzrN;	 Catch:{ InterruptedException -> 0x0032 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0032 }
        goto L_0x0023;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0023;
    L_0x0034:
        r3.zza(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        goto L_0x0018;
    L_0x0038:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.zzpy.zzb(r1, r0);
        goto L_0x0020;
    L_0x003f:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.internal.zzpy.zzbc(r0);	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        r3.zzeh();	 Catch:{ InterruptedException -> 0x0038, Throwable -> 0x0048 }
        goto L_0x0018;
    L_0x0048:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.zzpy.zzb(r1, r0);
        r1 = r3.zzxF;
        r2 = "ContentFetchTask.run";
        r1.zza(r0, r2);
        goto L_0x0020;
    L_0x0056:
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        goto L_0x0000;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdb.run():void");
    }

    public void wakeup() {
        synchronized (this.zzrN) {
            this.zzxD = false;
            this.zzrN.notifyAll();
            zzpy.zzbc("ContentFetchThread: wakeup");
        }
    }

    zza zza(@Nullable View view, zzcy com_google_android_gms_internal_zzcy) {
        int i = 0;
        if (view == null) {
            return new zza(this, 0, 0);
        }
        Context context = zzv.zzcM().getContext();
        if (context != null) {
            String str = (String) view.getTag(context.getResources().getIdentifier((String) zzfx.zzBZ.get(), "id", context.getPackageName()));
            if (!(TextUtils.isEmpty(this.zzxM) || str == null || !str.equals(this.zzxM))) {
                return new zza(this, 0, 0);
            }
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(this, 0, 0);
            }
            com_google_android_gms_internal_zzcy.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zza(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzqp)) {
            com_google_android_gms_internal_zzcy.zzea();
            return zza((WebView) view, com_google_android_gms_internal_zzcy, globalVisibleRect) ? new zza(this, 0, 1) : new zza(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zza zza = zza(viewGroup.getChildAt(i3), com_google_android_gms_internal_zzcy);
                i2 += zza.zzxU;
                i += zza.zzxV;
            }
            return new zza(this, i2, i);
        }
    }

    void zza(@Nullable Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                zzpy.zzbc("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                zzh(view);
            }
        }
    }

    void zza(zzcy com_google_android_gms_internal_zzcy, WebView webView, String str, boolean z) {
        com_google_android_gms_internal_zzcy.zzdZ();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    com_google_android_gms_internal_zzcy.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String valueOf = String.valueOf(webView.getTitle());
                    com_google_android_gms_internal_zzcy.zza(new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (com_google_android_gms_internal_zzcy.zzdU()) {
                this.zzxE.zzb(com_google_android_gms_internal_zzcy);
            }
        } catch (JSONException e) {
            zzpy.zzbc("Json string may be malformed.");
        } catch (Throwable th) {
            zzpy.zza("Failed to get webview content.", th);
            this.zzxF.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    boolean zza(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    @TargetApi(19)
    boolean zza(WebView webView, zzcy com_google_android_gms_internal_zzcy, boolean z) {
        if (!zzs.zzyF()) {
            return false;
        }
        com_google_android_gms_internal_zzcy.zzea();
        webView.post(new 2(this, com_google_android_gms_internal_zzcy, webView, z));
        return true;
    }

    public void zzee() {
        synchronized (this.zzrN) {
            if (this.mStarted) {
                zzpy.zzbc("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    boolean zzef() {
        try {
            Context context = zzv.zzcM().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (zza(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && zzh(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzcy zzeg() {
        return this.zzxE.zzed();
    }

    public void zzeh() {
        synchronized (this.zzrN) {
            this.zzxD = true;
            zzpy.zzbc("ContentFetchThread: paused, mPause = " + this.zzxD);
        }
    }

    public boolean zzei() {
        return this.zzxD;
    }

    boolean zzh(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean zzh(@Nullable View view) {
        if (view == null) {
            return false;
        }
        view.post(new 1(this, view));
        return true;
    }

    void zzi(View view) {
        try {
            zzcy com_google_android_gms_internal_zzcy = new zzcy(this.zzxe, this.zzxH, this.zzxg, this.zzxI, this.zzxJ, this.zzxK, this.zzxL);
            zza zza = zza(view, com_google_android_gms_internal_zzcy);
            com_google_android_gms_internal_zzcy.zzeb();
            if (zza.zzxU != 0 || zza.zzxV != 0) {
                if (zza.zzxV != 0 || com_google_android_gms_internal_zzcy.zzec() != 0) {
                    if (zza.zzxV != 0 || !this.zzxE.zza(com_google_android_gms_internal_zzcy)) {
                        this.zzxE.zzc(com_google_android_gms_internal_zzcy);
                    }
                }
            }
        } catch (Throwable e) {
            zzpy.zzb("Exception in fetchContentOnUIThread", e);
            this.zzxF.zza(e, "ContentFetchTask.fetchContent");
        }
    }
}
