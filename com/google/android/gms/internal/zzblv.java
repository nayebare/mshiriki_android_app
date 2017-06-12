package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.EOFException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

class zzblv {
    private static long zzcaB;
    private final ScheduledExecutorService zzbYl;
    private final zzbop zzbYx;
    private zzb zzcaC;
    private boolean zzcaD;
    private boolean zzcaE;
    private long zzcaF;
    private zzblx zzcaG;
    private zza zzcaH;
    private ScheduledFuture<?> zzcaI;
    private ScheduledFuture<?> zzcaJ;
    private final zzbln zzcaK;

    public interface zza {
        void zzaV(boolean z);

        void zzas(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.internal.zzblv.1 */
    class C11991 implements Runnable {
        final /* synthetic */ zzblv zzcaL;

        C11991(zzblv com_google_android_gms_internal_zzblv) {
            this.zzcaL = com_google_android_gms_internal_zzblv;
        }

        public void run() {
            this.zzcaL.zzWs();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzblv.2 */
    class C12002 implements Runnable {
        final /* synthetic */ zzblv zzcaL;

        C12002(zzblv com_google_android_gms_internal_zzblv) {
            this.zzcaL = com_google_android_gms_internal_zzblv;
        }

        public void run() {
            if (this.zzcaL.zzcaC != null) {
                this.zzcaL.zzcaC.zziT("0");
                this.zzcaL.zzWp();
            }
        }
    }

    private interface zzb {
        void close();

        void connect();

        void zziT(String str);
    }

    private class zzc implements zzb, zzbpp {
        final /* synthetic */ zzblv zzcaL;
        private zzbpo zzcaM;

        /* renamed from: com.google.android.gms.internal.zzblv.zzc.1 */
        class C12011 implements Runnable {
            final /* synthetic */ zzc zzcaN;

            C12011(zzc com_google_android_gms_internal_zzblv_zzc) {
                this.zzcaN = com_google_android_gms_internal_zzblv_zzc;
            }

            public void run() {
                this.zzcaN.zzcaL.zzcaJ.cancel(false);
                this.zzcaN.zzcaL.zzcaD = true;
                if (this.zzcaN.zzcaL.zzbYx.zzYT()) {
                    this.zzcaN.zzcaL.zzbYx.zzi("websocket opened", new Object[0]);
                }
                this.zzcaN.zzcaL.zzWp();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzblv.zzc.2 */
        class C12022 implements Runnable {
            final /* synthetic */ zzc zzcaN;
            final /* synthetic */ String zzcaO;

            C12022(zzc com_google_android_gms_internal_zzblv_zzc, String str) {
                this.zzcaN = com_google_android_gms_internal_zzblv_zzc;
                this.zzcaO = str;
            }

            public void run() {
                this.zzcaN.zzcaL.zziS(this.zzcaO);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzblv.zzc.3 */
        class C12033 implements Runnable {
            final /* synthetic */ zzc zzcaN;

            C12033(zzc com_google_android_gms_internal_zzblv_zzc) {
                this.zzcaN = com_google_android_gms_internal_zzblv_zzc;
            }

            public void run() {
                if (this.zzcaN.zzcaL.zzbYx.zzYT()) {
                    this.zzcaN.zzcaL.zzbYx.zzi("closed", new Object[0]);
                }
                this.zzcaN.zzcaL.zzWr();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzblv.zzc.4 */
        class C12044 implements Runnable {
            final /* synthetic */ zzc zzcaN;
            final /* synthetic */ zzbpq zzcaP;

            C12044(zzc com_google_android_gms_internal_zzblv_zzc, zzbpq com_google_android_gms_internal_zzbpq) {
                this.zzcaN = com_google_android_gms_internal_zzblv_zzc;
                this.zzcaP = com_google_android_gms_internal_zzbpq;
            }

            public void run() {
                if (this.zzcaP.getCause() == null || !(this.zzcaP.getCause() instanceof EOFException)) {
                    this.zzcaN.zzcaL.zzbYx.zza("WebSocket error.", this.zzcaP, new Object[0]);
                } else {
                    this.zzcaN.zzcaL.zzbYx.zzi("WebSocket reached EOF.", new Object[0]);
                }
                this.zzcaN.zzcaL.zzWr();
            }
        }

        private zzc(zzblv com_google_android_gms_internal_zzblv, zzbpo com_google_android_gms_internal_zzbpo) {
            this.zzcaL = com_google_android_gms_internal_zzblv;
            this.zzcaM = com_google_android_gms_internal_zzbpo;
            this.zzcaM.zza((zzbpp) this);
        }

        private void shutdown() {
            this.zzcaM.close();
            try {
                this.zzcaM.zzZL();
            } catch (Throwable e) {
                this.zzcaL.zzbYx.zzd("Interrupted while shutting down websocket threads", e);
            }
        }

        public void close() {
            this.zzcaM.close();
        }

        public void connect() {
            try {
                this.zzcaM.connect();
            } catch (Throwable e) {
                if (this.zzcaL.zzbYx.zzYT()) {
                    this.zzcaL.zzbYx.zza("Error connecting", e, new Object[0]);
                }
                shutdown();
            }
        }

        public void onClose() {
            this.zzcaL.zzbYl.execute(new C12033(this));
        }

        public void zzWt() {
            this.zzcaL.zzbYl.execute(new C12011(this));
        }

        public void zza(zzbpq com_google_android_gms_internal_zzbpq) {
            this.zzcaL.zzbYl.execute(new C12044(this, com_google_android_gms_internal_zzbpq));
        }

        public void zza(zzbps com_google_android_gms_internal_zzbps) {
            String text = com_google_android_gms_internal_zzbps.getText();
            if (this.zzcaL.zzbYx.zzYT()) {
                zzbop zzb = this.zzcaL.zzbYx;
                String str = "ws message: ";
                String valueOf = String.valueOf(text);
                zzb.zzi(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
            this.zzcaL.zzbYl.execute(new C12022(this, text));
        }

        public void zziT(String str) {
            this.zzcaM.zziT(str);
        }
    }

    static {
        zzcaB = 0;
    }

    public zzblv(zzbln com_google_android_gms_internal_zzbln, zzblp com_google_android_gms_internal_zzblp, String str, zza com_google_android_gms_internal_zzblv_zza, String str2) {
        this.zzcaD = false;
        this.zzcaE = false;
        this.zzcaF = 0;
        this.zzcaK = com_google_android_gms_internal_zzbln;
        this.zzbYl = com_google_android_gms_internal_zzbln.zzVJ();
        this.zzcaH = com_google_android_gms_internal_zzblv_zza;
        long j = zzcaB;
        zzcaB = 1 + j;
        this.zzbYx = new zzbop(com_google_android_gms_internal_zzbln.zzVH(), "WebSocket", "ws_" + j);
        this.zzcaC = zza(com_google_android_gms_internal_zzblp, str, str2);
    }

    private boolean isBuffering() {
        return this.zzcaG != null;
    }

    private void shutdown() {
        this.zzcaE = true;
        this.zzcaH.zzaV(this.zzcaD);
    }

    private static String[] zzF(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            arrayList.add(str.substring(i2, Math.min(i2 + i, str.length())));
            i2 += i;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void zzWp() {
        if (!this.zzcaE) {
            if (this.zzcaI != null) {
                this.zzcaI.cancel(false);
                if (this.zzbYx.zzYT()) {
                    this.zzbYx.zzi("Reset keepAlive. Remaining: " + this.zzcaI.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
                }
            } else if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi("Reset keepAlive", new Object[0]);
            }
            this.zzcaI = this.zzbYl.schedule(zzWq(), 45000, TimeUnit.MILLISECONDS);
        }
    }

    private Runnable zzWq() {
        return new C12002(this);
    }

    private void zzWr() {
        if (!this.zzcaE) {
            if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi("closing itself", new Object[0]);
            }
            shutdown();
        }
        this.zzcaC = null;
        if (this.zzcaI != null) {
            this.zzcaI.cancel(false);
        }
    }

    private void zzWs() {
        if (!this.zzcaD && !this.zzcaE) {
            if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi("timed out on connect", new Object[0]);
            }
            this.zzcaC.close();
        }
    }

    private zzb zza(zzblp com_google_android_gms_internal_zzblp, String str, String str2) {
        if (str == null) {
            str = com_google_android_gms_internal_zzblp.getHost();
        }
        URI zza = zzblp.zza(str, com_google_android_gms_internal_zzblp.isSecure(), com_google_android_gms_internal_zzblp.getNamespace(), str2);
        Map hashMap = new HashMap();
        hashMap.put(HTTP.USER_AGENT, this.zzcaK.zzjQ());
        return new zzc(new zzbpo(zza, null, hashMap), null);
    }

    private void zziQ(String str) {
        Throwable th;
        zzbop com_google_android_gms_internal_zzbop;
        String str2;
        String valueOf;
        this.zzcaG.zziU(str);
        this.zzcaF--;
        if (this.zzcaF == 0) {
            try {
                this.zzcaG.zzWz();
                Map zzjf = zzbpx.zzjf(this.zzcaG.toString());
                this.zzcaG = null;
                if (this.zzbYx.zzYT()) {
                    zzbop com_google_android_gms_internal_zzbop2 = this.zzbYx;
                    String valueOf2 = String.valueOf(zzjf);
                    com_google_android_gms_internal_zzbop2.zzi(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("handleIncomingFrame complete frame: ").append(valueOf2).toString(), new Object[0]);
                }
                this.zzcaH.zzas(zzjf);
            } catch (Throwable e) {
                th = e;
                com_google_android_gms_internal_zzbop = this.zzbYx;
                str2 = "Error parsing frame: ";
                valueOf = String.valueOf(this.zzcaG.toString());
                com_google_android_gms_internal_zzbop.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                close();
                shutdown();
            } catch (Throwable e2) {
                th = e2;
                com_google_android_gms_internal_zzbop = this.zzbYx;
                str2 = "Error parsing frame (cast error): ";
                valueOf = String.valueOf(this.zzcaG.toString());
                com_google_android_gms_internal_zzbop.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                close();
                shutdown();
            }
        }
    }

    private String zziR(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    zzpJ(parseInt);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        zzpJ(1);
        return str;
    }

    private void zziS(String str) {
        if (!this.zzcaE) {
            zzWp();
            if (isBuffering()) {
                zziQ(str);
                return;
            }
            String zziR = zziR(str);
            if (zziR != null) {
                zziQ(zziR);
            }
        }
    }

    private void zzpJ(int i) {
        this.zzcaF = (long) i;
        this.zzcaG = new zzblx();
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi("HandleNewFrameCount: " + this.zzcaF, new Object[0]);
        }
    }

    public void close() {
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi("websocket is being closed", new Object[0]);
        }
        this.zzcaE = true;
        this.zzcaC.close();
        if (this.zzcaJ != null) {
            this.zzcaJ.cancel(true);
        }
        if (this.zzcaI != null) {
            this.zzcaI.cancel(true);
        }
    }

    public void open() {
        this.zzcaC.connect();
        this.zzcaJ = this.zzbYl.schedule(new C11991(this), NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, TimeUnit.MILLISECONDS);
    }

    public void send(Map<String, Object> map) {
        zzWp();
        String str;
        try {
            String[] zzF = zzF(zzbpx.zzaE(map), AccessibilityNodeInfoCompat.ACTION_COPY);
            if (zzF.length > 1) {
                this.zzcaC.zziT(zzF.length);
            }
            for (String str2 : zzF) {
                this.zzcaC.zziT(str2);
            }
        } catch (Throwable e) {
            Throwable th = e;
            zzbop com_google_android_gms_internal_zzbop = this.zzbYx;
            str2 = "Failed to serialize message: ";
            String valueOf = String.valueOf(map.toString());
            com_google_android_gms_internal_zzbop.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            shutdown();
        }
    }
}
