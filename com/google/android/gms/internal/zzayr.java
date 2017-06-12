package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class zzayr extends Thread implements zzayq {
    private static zzayr zzbHN;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean zzMS;
    private final LinkedBlockingQueue<Runnable> zzbEn;
    private volatile zzays zzbHO;
    private final zze zzuI;

    /* renamed from: com.google.android.gms.internal.zzayr.1 */
    class C11161 implements Runnable {
        final /* synthetic */ long zzbEr;
        final /* synthetic */ zzayq zzbHP;
        final /* synthetic */ String zzbHQ;
        final /* synthetic */ String zzbHR;
        final /* synthetic */ Map zzbHS;
        final /* synthetic */ String zzbHT;
        final /* synthetic */ zzayr zzbHU;
        final /* synthetic */ String zzsk;

        C11161(zzayr com_google_android_gms_internal_zzayr, zzayq com_google_android_gms_internal_zzayq, long j, String str, String str2, String str3, Map map, String str4) {
            this.zzbHU = com_google_android_gms_internal_zzayr;
            this.zzbHP = com_google_android_gms_internal_zzayq;
            this.zzbEr = j;
            this.zzsk = str;
            this.zzbHQ = str2;
            this.zzbHR = str3;
            this.zzbHS = map;
            this.zzbHT = str4;
        }

        public void run() {
            if (this.zzbHU.zzbHO == null) {
                zzazj zzQM = zzazj.zzQM();
                zzQM.zza(this.zzbHU.mContext, this.zzbHP);
                this.zzbHU.zzbHO = zzQM.zzQN();
            }
            this.zzbHU.zzbHO.zza(this.zzbEr, this.zzsk, this.zzbHQ, this.zzbHR, this.zzbHS, this.zzbHT);
        }
    }

    private zzayr(Context context) {
        super("GAThread");
        this.zzbEn = new LinkedBlockingQueue();
        this.zzMS = false;
        this.mClosed = false;
        this.zzuI = zzh.zzyv();
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzayr zzbN(Context context) {
        if (zzbHN == null) {
            zzbHN = new zzayr(context);
        }
        return zzbHN;
    }

    private String zzg(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        while (true) {
            boolean z = this.mClosed;
            try {
                Runnable runnable = (Runnable) this.zzbEn.take();
                if (!this.zzMS) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzayx.zzbd(e.toString());
            } catch (Throwable th) {
                String str = "Error on Google TagManager Thread: ";
                String valueOf = String.valueOf(zzg(th));
                zzayx.m23e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                zzayx.m23e("Google TagManager is shutting down.");
                this.zzMS = true;
            }
        }
    }

    void zza(String str, long j, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
        zzp(new C11161(this, this, j, str, str2, str3, map, str4));
    }

    public void zzb(String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
        zza(str, this.zzuI.currentTimeMillis(), str2, str3, map, str4);
    }

    public void zzp(Runnable runnable) {
        this.zzbEn.add(runnable);
    }
}
