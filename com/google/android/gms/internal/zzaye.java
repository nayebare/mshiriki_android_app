package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;

public class zzaye {
    private static Object zzbCG;
    private static zzaye zzbHh;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzWx;
    private volatile Info zzacA;
    private volatile long zzbCA;
    private volatile long zzbCB;
    private volatile long zzbCC;
    private volatile long zzbCD;
    private final Object zzbCE;
    private volatile boolean zzbHf;
    private zza zzbHg;
    private final zze zzuI;

    public interface zza {
        Info zzOv();
    }

    /* renamed from: com.google.android.gms.internal.zzaye.1 */
    class C11121 implements zza {
        final /* synthetic */ zzaye zzbHi;

        C11121(zzaye com_google_android_gms_internal_zzaye) {
            this.zzbHi = com_google_android_gms_internal_zzaye;
        }

        public Info zzOv() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzbHi.mContext);
            } catch (Throwable e) {
                zzayx.zzc("IllegalStateException getting Advertising Id Info", e);
            } catch (Throwable e2) {
                zzayx.zzc("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            } catch (Throwable e22) {
                zzayx.zzc("IOException getting Ad Id Info", e22);
            } catch (Throwable e222) {
                this.zzbHi.zzbHf = false;
                zzayx.zzc("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            } catch (Throwable e2222) {
                zzayx.zzc("Unknown exception. Could not get the Advertising Id Info.", e2222);
            }
            return info;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaye.2 */
    class C11132 implements Runnable {
        final /* synthetic */ zzaye zzbHi;

        C11132(zzaye com_google_android_gms_internal_zzaye) {
            this.zzbHi = com_google_android_gms_internal_zzaye;
        }

        public void run() {
            this.zzbHi.zzOu();
        }
    }

    static {
        zzbCG = new Object();
    }

    private zzaye(Context context) {
        this(context, null, zzh.zzyv());
    }

    public zzaye(Context context, zza com_google_android_gms_internal_zzaye_zza, zze com_google_android_gms_common_util_zze) {
        this.zzbCA = 900000;
        this.zzbCB = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.zzbHf = true;
        this.mClosed = false;
        this.zzbCE = new Object();
        this.zzbHg = new C11121(this);
        this.zzuI = com_google_android_gms_common_util_zze;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (com_google_android_gms_internal_zzaye_zza != null) {
            this.zzbHg = com_google_android_gms_internal_zzaye_zza;
        }
        this.zzbCC = this.zzuI.currentTimeMillis();
        this.zzWx = new Thread(new C11132(this));
    }

    private void zzOr() {
        synchronized (this) {
            try {
                zzOs();
                wait(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private void zzOs() {
        if (this.zzuI.currentTimeMillis() - this.zzbCC > this.zzbCB) {
            synchronized (this.zzbCE) {
                this.zzbCE.notify();
            }
            this.zzbCC = this.zzuI.currentTimeMillis();
        }
    }

    private void zzOt() {
        if (this.zzuI.currentTimeMillis() - this.zzbCD > 3600000) {
            this.zzacA = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzOu() {
        /*
        r4 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r0 = r4.mClosed;
        r0 = 0;
        r1 = r4.zzbHf;
        if (r1 == 0) goto L_0x0012;
    L_0x000c:
        r0 = r4.zzbHg;
        r0 = r0.zzOv();
    L_0x0012:
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r4.zzacA = r0;
        r0 = r4.zzuI;
        r0 = r0.currentTimeMillis();
        r4.zzbCD = r0;
        r0 = "Obtained fresh AdvertisingId info from GmsCore.";
        com.google.android.gms.internal.zzayx.zzbd(r0);
    L_0x0023:
        monitor-enter(r4);
        r4.notifyAll();	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r1 = r4.zzbCE;	 Catch:{ InterruptedException -> 0x0037 }
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x0037 }
        r0 = r4.zzbCE;	 Catch:{ all -> 0x0034 }
        r2 = r4.zzbCA;	 Catch:{ all -> 0x0034 }
        r0.wait(r2);	 Catch:{ all -> 0x0034 }
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
        goto L_0x0005;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ InterruptedException -> 0x0037 }
    L_0x0037:
        r0 = move-exception;
        r0 = "sleep interrupted in AdvertiserDataPoller thread; continuing";
        com.google.android.gms.internal.zzayx.zzbd(r0);
        goto L_0x0005;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaye.zzOu():void");
    }

    public static zzaye zzbL(Context context) {
        if (zzbHh == null) {
            synchronized (zzbCG) {
                if (zzbHh == null) {
                    zzbHh = new zzaye(context);
                    zzbHh.start();
                }
            }
        }
        return zzbHh;
    }

    public boolean isLimitAdTrackingEnabled() {
        if (this.zzacA == null) {
            zzOr();
        } else {
            zzOs();
        }
        zzOt();
        return this.zzacA == null ? true : this.zzacA.isLimitAdTrackingEnabled();
    }

    public void start() {
        this.zzWx.start();
    }

    public String zzOq() {
        if (this.zzacA == null) {
            zzOr();
        } else {
            zzOs();
        }
        zzOt();
        return this.zzacA == null ? null : this.zzacA.getId();
    }
}
