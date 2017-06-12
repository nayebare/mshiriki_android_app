package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.tagmanager.zzbb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzayg {
    private volatile int mState;
    private final String zzbCS;
    private ScheduledFuture<?> zzbFw;
    private final String zzbHj;
    private final String zzbHk;
    private final zzazf zzbHl;
    private final zzbfe zzbHm;
    private final ExecutorService zzbHn;
    private final ScheduledExecutorService zzbHo;
    private final zzbb zzbHp;
    private final zzayi zzbHq;
    private zzaze zzbHr;
    private List<zzaym> zzbHs;
    private boolean zzbHt;
    private final com.google.android.gms.common.util.zze zzuI;

    /* renamed from: com.google.android.gms.internal.zzayg.1 */
    class C11141 implements Runnable {
        final /* synthetic */ zzayg zzbHu;

        C11141(zzayg com_google_android_gms_internal_zzayg) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
        }

        @WorkerThread
        public void run() {
            if (this.zzbHu.mState == 2) {
                this.zzbHu.zzbHr.dispatch();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzayg.2 */
    class C11152 implements Runnable {
        final /* synthetic */ zzayg zzbHu;

        C11152(zzayg com_google_android_gms_internal_zzayg) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
        }

        public void run() {
            this.zzbHu.zzbHn.execute(new zzd(null));
        }
    }

    private class zza implements Runnable {
        final /* synthetic */ zzayg zzbHu;

        private zza(zzayg com_google_android_gms_internal_zzayg) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
        }

        @WorkerThread
        public void run() {
            this.zzbHu.mState = 3;
            String zzd = this.zzbHu.zzbCS;
            zzayx.zzbe(new StringBuilder(String.valueOf(zzd).length() + 26).append("Container ").append(zzd).append(" loading failed.").toString());
            if (this.zzbHu.zzbHs != null) {
                for (zzaym com_google_android_gms_internal_zzaym : this.zzbHu.zzbHs) {
                    if (com_google_android_gms_internal_zzaym.zzQs()) {
                        try {
                            this.zzbHu.zzbHp.zza("app", com_google_android_gms_internal_zzaym.zzQp(), com_google_android_gms_internal_zzaym.zzQq(), com_google_android_gms_internal_zzaym.currentTimeMillis());
                            zzd = String.valueOf(com_google_android_gms_internal_zzaym.zzQp());
                            zzayx.m24v(new StringBuilder(String.valueOf(zzd).length() + 50).append("Logged event ").append(zzd).append(" to Firebase (marked as passthrough).").toString());
                        } catch (RemoteException e) {
                            String str = "Error logging event with measurement proxy:";
                            zzd = String.valueOf(e.getMessage());
                            zzayx.m23e(zzd.length() != 0 ? str.concat(zzd) : new String(str));
                        }
                    } else {
                        zzd = String.valueOf(com_google_android_gms_internal_zzaym.zzQp());
                        zzayx.m24v(new StringBuilder(String.valueOf(zzd).length() + 45).append("Discarded event ").append(zzd).append(" (marked as non-passthrough).").toString());
                    }
                }
                this.zzbHu.zzbHs = null;
            }
        }
    }

    private class zzb implements com.google.android.gms.internal.zzbfe.zza, Runnable {
        final /* synthetic */ zzayg zzbHu;

        private zzb(zzayg com_google_android_gms_internal_zzayg) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
        }

        @WorkerThread
        public void run() {
            zzac.zzar(this.zzbHu.mState == 1);
            List arrayList = new ArrayList();
            this.zzbHu.zzbHt = false;
            if (zzazc.zzQB().zzhK(this.zzbHu.zzbCS)) {
                arrayList.add(Integer.valueOf(0));
            } else {
                this.zzbHu.zzbHt = this.zzbHu.zzbHq.zzQo();
                if (this.zzbHu.zzbHt) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList.add(Integer.valueOf(0));
                } else {
                    arrayList.add(Integer.valueOf(0));
                    arrayList.add(Integer.valueOf(1));
                }
                arrayList.add(Integer.valueOf(2));
            }
            this.zzbHu.zzbHm.zza(this.zzbHu.zzbCS, this.zzbHu.zzbHk, this.zzbHu.zzbHj, arrayList, this, this.zzbHu.zzbHq);
        }

        public void zza(zzbfi com_google_android_gms_internal_zzbfi) {
            if (com_google_android_gms_internal_zzbfi.getStatus() == Status.zzayh) {
                this.zzbHu.zzbHn.execute(new zze(this.zzbHu, com_google_android_gms_internal_zzbfi));
            } else {
                this.zzbHu.zzbHn.execute(new zza(null));
            }
        }
    }

    private class zzc implements Runnable {
        final /* synthetic */ zzayg zzbHu;
        private final zzaym zzbHv;

        public zzc(zzayg com_google_android_gms_internal_zzayg, zzaym com_google_android_gms_internal_zzaym) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
            this.zzbHv = com_google_android_gms_internal_zzaym;
        }

        @WorkerThread
        public void run() {
            String str;
            String valueOf;
            if (this.zzbHu.mState == 2) {
                str = "Evaluating tags for event ";
                valueOf = String.valueOf(this.zzbHv.zzQp());
                zzayx.m24v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                this.zzbHu.zzbHr.zzb(this.zzbHv);
            } else if (this.zzbHu.mState == 1) {
                this.zzbHu.zzbHs.add(this.zzbHv);
                valueOf = String.valueOf(this.zzbHv.zzQp());
                zzayx.m24v(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Added event ").append(valueOf).append(" to pending queue.").toString());
            } else if (this.zzbHu.mState == 3) {
                valueOf = String.valueOf(this.zzbHv.zzQp());
                zzayx.m24v(new StringBuilder(String.valueOf(valueOf).length() + 61).append("Failed to evaluate tags for event ").append(valueOf).append(" (container failed to load)").toString());
                if (this.zzbHv.zzQs()) {
                    try {
                        this.zzbHu.zzbHp.zza("app", this.zzbHv.zzQp(), this.zzbHv.zzQq(), this.zzbHv.currentTimeMillis());
                        valueOf = String.valueOf(this.zzbHv.zzQp());
                        zzayx.m24v(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Logged passthrough event ").append(valueOf).append(" to Firebase.").toString());
                        return;
                    } catch (RemoteException e) {
                        str = "Error logging event with measurement proxy:";
                        valueOf = String.valueOf(e.getMessage());
                        zzayx.m23e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return;
                    }
                }
                str = "Discarded non-passthrough event ";
                valueOf = String.valueOf(this.zzbHv.zzQp());
                zzayx.m24v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }

    private class zzd implements com.google.android.gms.internal.zzbfe.zza, Runnable {
        final /* synthetic */ zzayg zzbHu;

        private zzd(zzayg com_google_android_gms_internal_zzayg) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
        }

        @WorkerThread
        public void run() {
            zzac.zzar(this.zzbHu.mState == 2);
            if (!zzazc.zzQB().zzhK(this.zzbHu.zzbCS)) {
                String zzd = this.zzbHu.zzbCS;
                zzayx.m24v(new StringBuilder(String.valueOf(zzd).length() + 24).append("Refreshing container ").append(zzd).append("...").toString());
                List arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                this.zzbHu.zzbHm.zza(this.zzbHu.zzbCS, this.zzbHu.zzbHk, this.zzbHu.zzbHj, arrayList, this, this.zzbHu.zzbHq);
            }
        }

        public void zza(zzbfi com_google_android_gms_internal_zzbfi) {
            if (com_google_android_gms_internal_zzbfi.getStatus() == Status.zzayh) {
                String zzd = this.zzbHu.zzbCS;
                zzayx.m24v(new StringBuilder(String.valueOf(zzd).length() + 47).append("Refreshed container ").append(zzd).append(". Reinitializing runtime...").toString());
                this.zzbHu.zzbHn.execute(new zze(this.zzbHu, com_google_android_gms_internal_zzbfi));
                return;
            }
            this.zzbHu.zzay(this.zzbHu.zzbHq.zzOM());
        }
    }

    private class zze implements Runnable {
        final /* synthetic */ zzayg zzbHu;
        private final zzbfi zzbHw;

        zze(zzayg com_google_android_gms_internal_zzayg, zzbfi com_google_android_gms_internal_zzbfi) {
            this.zzbHu = com_google_android_gms_internal_zzayg;
            this.zzbHw = com_google_android_gms_internal_zzbfi;
        }

        @WorkerThread
        public void run() {
            String valueOf;
            zzbfr zzRn = this.zzbHw.zzRi().zzRn();
            zzbfu zzRj = this.zzbHw.zzRj();
            Object obj = this.zzbHu.zzbHr == null ? 1 : null;
            this.zzbHu.zzbHr = this.zzbHu.zzbHl.zza(zzRn, zzRj);
            this.zzbHu.mState = 2;
            String zzd = this.zzbHu.zzbCS;
            zzayx.m24v(new StringBuilder(String.valueOf(zzd).length() + 48).append("Container ").append(zzd).append(" loaded during runtime initialization.").toString());
            if (this.zzbHu.zzbHs != null) {
                for (zzaym com_google_android_gms_internal_zzaym : this.zzbHu.zzbHs) {
                    String str = "Evaluating tags for pending event ";
                    valueOf = String.valueOf(com_google_android_gms_internal_zzaym.zzQp());
                    zzayx.m24v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    this.zzbHu.zzbHr.zzb(com_google_android_gms_internal_zzaym);
                }
                this.zzbHu.zzbHs = null;
            }
            this.zzbHu.zzbHr.dispatch();
            valueOf = "Runtime initialized successfully for container ";
            zzd = String.valueOf(this.zzbHu.zzbCS);
            zzayx.m24v(zzd.length() != 0 ? valueOf.concat(zzd) : new String(valueOf));
            long zzRo = this.zzbHw.zzRi().zzRo() + this.zzbHu.zzbHq.zzOL();
            if (obj == null || !this.zzbHu.zzbHt || this.zzbHw.getSource() != 1 || zzRo >= this.zzbHu.zzuI.currentTimeMillis()) {
                this.zzbHu.zzay(Math.max(900000, zzRo - this.zzbHu.zzuI.currentTimeMillis()));
            } else {
                this.zzbHu.zzay(this.zzbHu.zzbHq.zzQn());
            }
        }
    }

    zzayg(String str, @Nullable String str2, @Nullable String str3, zzazf com_google_android_gms_internal_zzazf, zzbfe com_google_android_gms_internal_zzbfe, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzbb com_google_android_gms_tagmanager_zzbb, com.google.android.gms.common.util.zze com_google_android_gms_common_util_zze, zzayi com_google_android_gms_internal_zzayi) {
        this.mState = 1;
        this.zzbHs = new ArrayList();
        this.zzbFw = null;
        this.zzbHt = false;
        this.zzbCS = (String) zzac.zzw(str);
        this.zzbHl = (zzazf) zzac.zzw(com_google_android_gms_internal_zzazf);
        this.zzbHm = (zzbfe) zzac.zzw(com_google_android_gms_internal_zzbfe);
        this.zzbHn = (ExecutorService) zzac.zzw(executorService);
        this.zzbHo = (ScheduledExecutorService) zzac.zzw(scheduledExecutorService);
        this.zzbHp = (zzbb) zzac.zzw(com_google_android_gms_tagmanager_zzbb);
        this.zzuI = (com.google.android.gms.common.util.zze) zzac.zzw(com_google_android_gms_common_util_zze);
        this.zzbHq = (zzayi) zzac.zzw(com_google_android_gms_internal_zzayi);
        this.zzbHj = str3;
        this.zzbHk = str2;
        this.zzbHs.add(new zzaym("gtm.load", new Bundle(), "gtm", new Date(), false, this.zzbHp));
        String str4 = this.zzbCS;
        zzayx.m24v(new StringBuilder(String.valueOf(str4).length() + 35).append("Container ").append(str4).append("is scheduled for loading.").toString());
        this.zzbHn.execute(new zzb());
    }

    private void zzay(long j) {
        if (this.zzbFw != null) {
            this.zzbFw.cancel(false);
        }
        String str = this.zzbCS;
        zzayx.m24v(new StringBuilder(String.valueOf(str).length() + 45).append("Refresh container ").append(str).append(" in ").append(j).append("ms.").toString());
        this.zzbFw = this.zzbHo.schedule(new C11152(this), j, TimeUnit.MILLISECONDS);
    }

    public void dispatch() {
        this.zzbHn.execute(new C11141(this));
    }

    public void zza(zzaym com_google_android_gms_internal_zzaym) {
        this.zzbHn.execute(new zzc(this, com_google_android_gms_internal_zzaym));
    }
}
