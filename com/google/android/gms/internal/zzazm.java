package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.tagmanager.TagManagerService;
import com.google.android.gms.tagmanager.zzay;
import com.google.android.gms.tagmanager.zzbb;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzazm {
    private static final Pattern zzbIG;
    private static volatile zzazm zzbIH;
    private static zzc zzbIQ;
    private final Context mContext;
    private String zzbCS;
    private final ExecutorService zzbHn;
    private final ScheduledExecutorService zzbHo;
    private final zzbb zzbHp;
    private final zzay zzbHy;
    private final zzazp zzbII;
    private final zzazc zzbIJ;
    private final zza zzbIK;
    private final Object zzbIL;
    private String zzbIM;
    private int zzbIN;
    private final Queue<Runnable> zzbIO;
    private volatile boolean zzbIP;
    private volatile boolean zztW;

    public interface zzc {
        zzazm zzb(Context context, zzbb com_google_android_gms_tagmanager_zzbb, zzay com_google_android_gms_tagmanager_zzay);
    }

    /* renamed from: com.google.android.gms.internal.zzazm.1 */
    class C11241 implements zzc {
        C11241() {
        }

        public zzazm zzb(Context context, zzbb com_google_android_gms_tagmanager_zzbb, zzay com_google_android_gms_tagmanager_zzay) {
            return new zzazm(context, com_google_android_gms_tagmanager_zzbb, com_google_android_gms_tagmanager_zzay, new zzazp(context), zzazo.zzQR(), zzazo.zzQS(), zzazc.zzQB(), new zza(context));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazm.2 */
    class C11262 extends com.google.android.gms.tagmanager.zzba.zza {
        final /* synthetic */ zzazm zzbIR;

        /* renamed from: com.google.android.gms.internal.zzazm.2.1 */
        class C11251 implements Runnable {
            final /* synthetic */ String val$name;
            private boolean zzbIS;
            final /* synthetic */ Bundle zzbIT;
            final /* synthetic */ String zzbIU;
            final /* synthetic */ long zzbIV;
            final /* synthetic */ C11262 zzbIW;
            final /* synthetic */ String zzbuc;

            C11251(C11262 c11262, String str, Bundle bundle, String str2, long j, String str3) {
                this.zzbIW = c11262;
                this.val$name = str;
                this.zzbIT = bundle;
                this.zzbIU = str2;
                this.zzbIV = j;
                this.zzbuc = str3;
                this.zzbIS = false;
            }

            public void run() {
                if (this.zzbIW.zzbIR.zzbIN == 3) {
                    this.zzbIW.zzbIR.zzbII.zza(this.val$name, this.zzbIT, this.zzbIU, this.zzbIV, true);
                } else if (this.zzbIW.zzbIR.zzbIN == 4) {
                    zzayx.m24v(String.format("Container failed to load: skipping  event interceptor by logging event back to Firebase directly: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzbIU, this.zzbIT}));
                    try {
                        this.zzbIW.zzbIR.zzbHp.zza(this.zzbIU, this.val$name, this.zzbIT, this.zzbIV);
                    } catch (RemoteException e) {
                        String str = "Error logging event on measurement proxy";
                        String valueOf = String.valueOf(e.getMessage());
                        zzayx.m23e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    }
                } else if (this.zzbIW.zzbIR.zzbIN != 1 && this.zzbIW.zzbIR.zzbIN != 2) {
                    zzayx.zzbe("Unexpected state:" + this.zzbIW.zzbIR.zzbIN);
                } else if (this.zzbIS) {
                    zzayx.zzbe("Invalid state - not expecting to see a deferred eventduring container loading.");
                } else {
                    zzayx.m24v(String.format("Container not loaded yet: deferring event interceptor by enqueuing the event: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzbuc, this.zzbIT}));
                    this.zzbIS = true;
                    this.zzbIW.zzbIR.zzbIO.add(this);
                }
            }
        }

        C11262(zzazm com_google_android_gms_internal_zzazm) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
        }

        public void zzb(String str, String str2, Bundle bundle, long j) throws RemoteException {
            this.zzbIR.zzbHn.submit(new C11251(this, str2, bundle, new StringBuilder(String.valueOf(str).length() + 4).append(str).append("+").append("gtm").toString(), j, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazm.3 */
    class C11283 extends com.google.android.gms.tagmanager.zzaz.zza {
        final /* synthetic */ zzazm zzbIR;

        /* renamed from: com.google.android.gms.internal.zzazm.3.1 */
        class C11271 implements Runnable {
            final /* synthetic */ String val$name;
            private boolean zzbIS;
            final /* synthetic */ Bundle zzbIT;
            final /* synthetic */ String zzbIU;
            final /* synthetic */ long zzbIV;
            final /* synthetic */ C11283 zzbIX;
            final /* synthetic */ String zzbuc;

            C11271(C11283 c11283, String str, Bundle bundle, String str2, long j, String str3) {
                this.zzbIX = c11283;
                this.val$name = str;
                this.zzbIT = bundle;
                this.zzbIU = str2;
                this.zzbIV = j;
                this.zzbuc = str3;
                this.zzbIS = false;
            }

            public void run() {
                if (this.zzbIX.zzbIR.zzbIN == 3) {
                    this.zzbIX.zzbIR.zzbII.zza(this.val$name, this.zzbIT, this.zzbIU, this.zzbIV, false);
                } else if (this.zzbIX.zzbIR.zzbIN == 1 || this.zzbIX.zzbIR.zzbIN == 2) {
                    if (this.zzbIS) {
                        zzayx.zzbe("Invalid state - not expecting to see a deferred event during container loading.");
                        return;
                    }
                    zzayx.m24v(String.format("Container not loaded yet: deferring event listener by enqueuing the event: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzbuc, this.zzbIT}));
                    this.zzbIS = true;
                    this.zzbIX.zzbIR.zzbIO.add(this);
                } else if (this.zzbIX.zzbIR.zzbIN == 4) {
                    zzayx.m24v(String.format("Container failed to load: skipping event listener by ignoring the event: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzbuc, this.zzbIT}));
                } else {
                    zzayx.zzbe("Unexpected state:" + this.zzbIX.zzbIR.zzbIN);
                }
            }
        }

        C11283(zzazm com_google_android_gms_internal_zzazm) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
        }

        public void zzc(String str, String str2, Bundle bundle, long j) {
            if (!str.endsWith("+gtm")) {
                this.zzbIR.zzbHn.submit(new C11271(this, str2, bundle, new StringBuilder(String.valueOf(str).length() + 4).append(str).append("+").append("gtm").toString(), j, str));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazm.4 */
    class C11294 implements Runnable {
        final /* synthetic */ zzazm zzbIR;
        final /* synthetic */ String zzbIY;
        final /* synthetic */ String zzbIZ;
        final /* synthetic */ String zzbJa;

        C11294(zzazm com_google_android_gms_internal_zzazm, String str, String str2, String str3) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
            this.zzbIY = str;
            this.zzbIZ = str2;
            this.zzbJa = str3;
        }

        public void run() {
            String str = this.zzbIY;
            zzayx.m24v(new StringBuilder(String.valueOf(str).length() + 28).append("Starting to load container ").append(str).append(".").toString());
            if (this.zzbIR.zzbIN != 1) {
                zzayx.zzbe("Unexpected state - container loading already initiated.");
                return;
            }
            this.zzbIR.zzbIN = 2;
            this.zzbIR.zzbII.zzb(this.zzbIY, this.zzbIZ, this.zzbJa, new zzb(null));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazm.5 */
    class C11315 implements Runnable {
        final /* synthetic */ zzazm zzbIR;

        /* renamed from: com.google.android.gms.internal.zzazm.5.1 */
        class C11301 implements Runnable {
            final /* synthetic */ C11315 zzbJb;

            C11301(C11315 c11315) {
                this.zzbJb = c11315;
            }

            public void run() {
                if (this.zzbJb.zzbIR.zzbIN == 1 || this.zzbJb.zzbIR.zzbIN == 2) {
                    this.zzbJb.zzbIR.zzbIN = 4;
                    zzayx.m23e("Container load timed out after 5000ms.");
                    while (!this.zzbJb.zzbIR.zzbIO.isEmpty()) {
                        this.zzbJb.zzbIR.zzbHn.submit((Runnable) this.zzbJb.zzbIR.zzbIO.remove());
                    }
                }
            }
        }

        C11315(zzazm com_google_android_gms_internal_zzazm) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
        }

        public void run() {
            this.zzbIR.zzbHn.submit(new C11301(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazm.6 */
    class C11336 implements ComponentCallbacks2 {
        final /* synthetic */ zzazm zzbIR;

        /* renamed from: com.google.android.gms.internal.zzazm.6.1 */
        class C11321 implements Runnable {
            final /* synthetic */ C11336 zzbJc;

            C11321(C11336 c11336) {
                this.zzbJc = c11336;
            }

            public void run() {
                zzayx.m24v("App's UI deactivated. Dispatching hits.");
                this.zzbJc.zzbIR.zzbII.dispatch();
            }
        }

        C11336(zzazm com_google_android_gms_internal_zzazm) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzbIR.zzbHn.submit(new C11321(this));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazm.7 */
    class C11347 implements Runnable {
        final /* synthetic */ zzazm zzbIR;
        final /* synthetic */ Uri zzbJd;

        C11347(zzazm com_google_android_gms_internal_zzazm, Uri uri) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
            this.zzbJd = uri;
        }

        public void run() {
            String valueOf = String.valueOf(this.zzbJd);
            zzayx.m24v(new StringBuilder(String.valueOf(valueOf).length() + 25).append("Preview requested to uri ").append(valueOf).toString());
            synchronized (this.zzbIR.zzbIL) {
                if (this.zzbIR.zzbIN == 2) {
                    zzayx.m24v("Still initializing. Defer preview container loading.");
                    this.zzbIR.zzbIO.add(this);
                    return;
                }
                valueOf = (String) this.zzbIR.zzj(null).first;
                if (valueOf == null) {
                    zzayx.zzbe("Preview failed (no container found)");
                } else if (!this.zzbIR.zzbIJ.zzc(valueOf, this.zzbJd)) {
                    valueOf = String.valueOf(this.zzbJd);
                    zzayx.zzbe(new StringBuilder(String.valueOf(valueOf).length() + 73).append("Cannot preview the app with the uri: ").append(valueOf).append(". Launching current version instead.").toString());
                } else if (this.zzbIR.zztW) {
                    valueOf = String.valueOf(this.zzbJd);
                    zzayx.zzbd(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Starting to load preview container: ").append(valueOf).toString());
                    if (this.zzbIR.zzbII.zzQW()) {
                        this.zzbIR.zztW = false;
                        this.zzbIR.zzbIN = 1;
                        this.zzbIR.initialize();
                        return;
                    }
                    zzayx.zzbe("Failed to reset TagManager service for preview");
                } else {
                    valueOf = String.valueOf(this.zzbJd);
                    zzayx.m24v(new StringBuilder(String.valueOf(valueOf).length() + 84).append("Deferring container loading for preview uri: ").append(valueOf).append("(Tag Manager has not been initialized).").toString());
                }
            }
        }
    }

    protected static class zza {
        private final Context mContext;

        public zza(Context context) {
            this.mContext = context;
        }

        public String[] zzQQ() throws IOException {
            return this.mContext.getAssets().list(BuildConfig.FLAVOR);
        }

        public String[] zzhQ(String str) throws IOException {
            return this.mContext.getAssets().list(str);
        }
    }

    private class zzb extends com.google.android.gms.internal.zzayu.zza {
        final /* synthetic */ zzazm zzbIR;

        /* renamed from: com.google.android.gms.internal.zzazm.zzb.1 */
        class C11351 implements Runnable {
            final /* synthetic */ String zzbIY;
            final /* synthetic */ boolean zzbJe;
            final /* synthetic */ zzb zzbJf;

            C11351(zzb com_google_android_gms_internal_zzazm_zzb, boolean z, String str) {
                this.zzbJf = com_google_android_gms_internal_zzazm_zzb;
                this.zzbJe = z;
                this.zzbIY = str;
            }

            public void run() {
                if (this.zzbJf.zzbIR.zzbIN == 2) {
                    String str;
                    if (this.zzbJe) {
                        this.zzbJf.zzbIR.zzbIN = 3;
                        str = this.zzbIY;
                        zzayx.m24v(new StringBuilder(String.valueOf(str).length() + 18).append("Container ").append(str).append(" loaded.").toString());
                    } else {
                        this.zzbJf.zzbIR.zzbIN = 4;
                        String str2 = "Error loading container:";
                        str = String.valueOf(this.zzbIY);
                        zzayx.m23e(str.length() != 0 ? str2.concat(str) : new String(str2));
                    }
                    while (!this.zzbJf.zzbIR.zzbIO.isEmpty()) {
                        this.zzbJf.zzbIR.zzbHn.submit((Runnable) this.zzbJf.zzbIR.zzbIO.remove());
                    }
                    return;
                }
                zzayx.zzbe("Container load callback completed after timeout");
            }
        }

        private zzb(zzazm com_google_android_gms_internal_zzazm) {
            this.zzbIR = com_google_android_gms_internal_zzazm;
        }

        public void zza(boolean z, String str) throws RemoteException {
            this.zzbIR.zzbHn.submit(new C11351(this, z, str));
        }
    }

    static {
        zzbIG = Pattern.compile("(gtm-[a-z0-9]{1,10})\\.json", 2);
        zzbIQ = new C11241();
    }

    zzazm(Context context, zzbb com_google_android_gms_tagmanager_zzbb, zzay com_google_android_gms_tagmanager_zzay, zzazp com_google_android_gms_internal_zzazp, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzazc com_google_android_gms_internal_zzazc, zza com_google_android_gms_internal_zzazm_zza) {
        this.zzbIL = new Object();
        this.zzbIN = 1;
        this.zzbIO = new LinkedList();
        this.zztW = false;
        this.zzbIP = false;
        zzac.zzw(context);
        zzac.zzw(com_google_android_gms_tagmanager_zzbb);
        this.mContext = context;
        this.zzbHp = com_google_android_gms_tagmanager_zzbb;
        this.zzbHy = com_google_android_gms_tagmanager_zzay;
        this.zzbII = com_google_android_gms_internal_zzazp;
        this.zzbHn = executorService;
        this.zzbHo = scheduledExecutorService;
        this.zzbIJ = com_google_android_gms_internal_zzazc;
        this.zzbIK = com_google_android_gms_internal_zzazm_zza;
    }

    @TargetApi(14)
    private void zzPZ() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C11336(this));
        }
    }

    private zza zzQO() {
        return this.zzbIK;
    }

    @WorkerThread
    private void zzQP() {
        try {
            this.zzbHp.zza(new C11262(this));
        } catch (RemoteException e) {
            String str = "Error communicating with measurement proxy:";
            String valueOf = String.valueOf(e.getMessage());
            zzayx.m23e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            this.zzbHp.zza(new C11283(this));
        } catch (RemoteException e2) {
            str = "Error communicating with measurement proxy:";
            valueOf = String.valueOf(e2.getMessage());
            zzayx.m23e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static zzazm zza(Context context, zzbb com_google_android_gms_tagmanager_zzbb, zzay com_google_android_gms_tagmanager_zzay) {
        zzac.zzw(context);
        zzac.zzw(context);
        zzazm com_google_android_gms_internal_zzazm = zzbIH;
        if (com_google_android_gms_internal_zzazm == null) {
            synchronized (zzazm.class) {
                com_google_android_gms_internal_zzazm = zzbIH;
                if (com_google_android_gms_internal_zzazm == null) {
                    com_google_android_gms_internal_zzazm = zzbIQ.zzb(context, com_google_android_gms_tagmanager_zzbb, com_google_android_gms_tagmanager_zzay);
                    zzbIH = com_google_android_gms_internal_zzazm;
                }
            }
        }
        return com_google_android_gms_internal_zzazm;
    }

    private static boolean zzb(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    private Pair<String, String> zzj(String[] strArr) {
        int i = 0;
        zzayx.m24v("Looking up container asset.");
        if (this.zzbCS != null && this.zzbIM != null) {
            return Pair.create(this.zzbCS, this.zzbIM);
        }
        if (strArr == null) {
            try {
                strArr = zzQO().zzhQ("containers");
            } catch (Throwable e) {
                zzayx.zzb(String.format("Failed to enumerate assets in folder %s", new Object[]{"containers"}), e);
                return Pair.create(null, null);
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String valueOf;
            Matcher matcher = zzbIG.matcher(strArr[i3]);
            if (!matcher.matches()) {
                zzayx.zzbe(String.format("Ignoring container asset %s (does not match %s)", new Object[]{strArr[i3], zzbIG.pattern()}));
            } else if (i2 == 0) {
                this.zzbCS = matcher.group(1);
                String valueOf2 = String.valueOf("containers");
                r3 = String.valueOf(File.separator);
                valueOf = String.valueOf(strArr[i3]);
                this.zzbIM = new StringBuilder(((String.valueOf(valueOf2).length() + 0) + String.valueOf(r3).length()) + String.valueOf(valueOf).length()).append(valueOf2).append(r3).append(valueOf).toString();
                r3 = "Asset found for container ";
                valueOf2 = String.valueOf(this.zzbCS);
                zzayx.m24v(valueOf2.length() != 0 ? r3.concat(valueOf2) : new String(r3));
                i2 = 1;
            } else {
                valueOf = "Extra container asset found, will not be loaded: ";
                r3 = String.valueOf(strArr[i3]);
                zzayx.zzbe(r3.length() != 0 ? valueOf.concat(r3) : new String(valueOf));
            }
        }
        if (i2 == 0) {
            zzayx.zzbe("No container asset found in /assets/containers. Checking top level /assets directory for container assets.");
            try {
                String[] zzQQ = zzQO().zzQQ();
                while (i < zzQQ.length) {
                    Matcher matcher2 = zzbIG.matcher(zzQQ[i]);
                    if (matcher2.matches()) {
                        String valueOf3;
                        if (i2 == 0) {
                            this.zzbCS = matcher2.group(1);
                            this.zzbIM = zzQQ[i];
                            valueOf2 = "Asset found for container ";
                            valueOf3 = String.valueOf(this.zzbCS);
                            zzayx.m24v(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
                            zzayx.zzbe("Loading container assets from top level /assets directory. Please move the container asset to /assets/containers");
                            i2 = 1;
                        } else {
                            valueOf = "Extra container asset found, will not be loaded: ";
                            valueOf3 = String.valueOf(zzQQ[i]);
                            zzayx.zzbe(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
                        }
                    }
                    i++;
                }
            } catch (Throwable e2) {
                zzayx.zzb("Failed to enumerate assets.", e2);
                return Pair.create(null, null);
            }
        }
        return Pair.create(this.zzbCS, this.zzbIM);
    }

    @WorkerThread
    public void initialize() {
        zzi(null);
    }

    @WorkerThread
    public void zzai(String str, @Nullable String str2) {
        zzn(str, str2, null);
    }

    @WorkerThread
    public void zzi(String[] strArr) {
        zzayx.m24v("Initializing Tag Manager.");
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzbIL) {
            if (this.zztW) {
                return;
            }
            try {
                if (zzb(this.mContext, TagManagerService.class)) {
                    Pair zzj = zzj(strArr);
                    String str = (String) zzj.first;
                    String str2 = (String) zzj.second;
                    if (str == null || str2 == null) {
                        zzayx.zzbe("Tag Manager's event handler WILL NOT be installed (no container loaded)");
                    } else {
                        String str3 = "Loading container ";
                        String valueOf = String.valueOf(str);
                        zzayx.zzbd(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                        zzai(str, str2);
                        if (!this.zzbIP) {
                            zzayx.zzbd("Installing Tag Manager event handler.");
                            this.zzbIP = true;
                            zzQP();
                            zzPZ();
                            zzayx.zzbd("Tag Manager event handler installed.");
                        }
                    }
                    this.zztW = true;
                    zzayx.zzbd("Tag Manager initilization took " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return;
                }
                boolean z = "Tag Manager fails to initialize (TagManagerService not enabled in the manifest)";
                zzayx.zzbe(z);
                this.zztW = z;
            } finally {
                this.zztW = true;
            }
        }
    }

    @WorkerThread
    public void zzn(String str, @Nullable String str2, @Nullable String str3) {
        this.zzbHn.submit(new C11294(this, str, str2, str3));
        this.zzbHo.schedule(new C11315(this), 5000, TimeUnit.MILLISECONDS);
    }

    void zzx(Uri uri) {
        this.zzbHn.submit(new C11347(this, uri));
    }
}
