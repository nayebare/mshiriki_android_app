package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzmb
public class zzjp implements zzjh {
    private final Context mContext;
    private final zzmh zzKG;
    private final long zzKH;
    private final long zzKI;
    private final int zzKJ;
    private boolean zzKK;
    private final Map<zzqf<zzjn>, zzjm> zzKL;
    private List<zzjn> zzKM;
    private final zzjj zzKq;
    private final boolean zzKs;
    private final Object zzrN;
    private final zzjs zzsD;
    private final boolean zzvW;

    public zzjp(Context context, zzmh com_google_android_gms_internal_zzmh, zzjs com_google_android_gms_internal_zzjs, zzjj com_google_android_gms_internal_zzjj, boolean z, boolean z2, long j, long j2, int i) {
        this.zzrN = new Object();
        this.zzKK = false;
        this.zzKL = new HashMap();
        this.zzKM = new ArrayList();
        this.mContext = context;
        this.zzKG = com_google_android_gms_internal_zzmh;
        this.zzsD = com_google_android_gms_internal_zzjs;
        this.zzKq = com_google_android_gms_internal_zzjj;
        this.zzvW = z;
        this.zzKs = z2;
        this.zzKH = j;
        this.zzKI = j2;
        this.zzKJ = i;
    }

    private void zza(zzqf<zzjn> com_google_android_gms_internal_zzqf_com_google_android_gms_internal_zzjn) {
        zzpi.zzWR.post(new 2(this, com_google_android_gms_internal_zzqf_com_google_android_gms_internal_zzjn));
    }

    private zzjn zze(List<zzqf<zzjn>> list) {
        Throwable e;
        synchronized (this.zzrN) {
            if (this.zzKK) {
                zzjn com_google_android_gms_internal_zzjn = new zzjn(-1);
                return com_google_android_gms_internal_zzjn;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzqf com_google_android_gms_internal_zzqf = (zzqf) it.next();
                try {
                    com_google_android_gms_internal_zzjn = (zzjn) com_google_android_gms_internal_zzqf.get();
                    this.zzKM.add(com_google_android_gms_internal_zzjn);
                    if (com_google_android_gms_internal_zzjn != null && com_google_android_gms_internal_zzjn.zzKz == 0) {
                        zza(com_google_android_gms_internal_zzqf);
                        return com_google_android_gms_internal_zzjn;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    zzpy.zzc("Exception while processing an adapter; continuing with other adapters", e);
                } catch (ExecutionException e3) {
                    e = e3;
                    zzpy.zzc("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            zza(null);
            return new zzjn(1);
        }
    }

    private zzjn zzf(List<zzqf<zzjn>> list) {
        synchronized (this.zzrN) {
            if (this.zzKK) {
                zzjn com_google_android_gms_internal_zzjn = new zzjn(-1);
                return com_google_android_gms_internal_zzjn;
            }
            long j = -1;
            zzqf com_google_android_gms_internal_zzqf = null;
            com_google_android_gms_internal_zzjn = null;
            long j2 = this.zzKq.zzKi != -1 ? this.zzKq.zzKi : NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
            Iterator it = list.iterator();
            long j3 = j2;
            while (it.hasNext()) {
                zzjn com_google_android_gms_internal_zzjn2;
                zzjv com_google_android_gms_internal_zzjv;
                int zzgH;
                zzjn com_google_android_gms_internal_zzjn3;
                zzqf com_google_android_gms_internal_zzqf2;
                zzjn com_google_android_gms_internal_zzjn4;
                RemoteException max;
                zzqf com_google_android_gms_internal_zzqf3 = (zzqf) it.next();
                long currentTimeMillis = zzv.zzcP().currentTimeMillis();
                if (j3 == 0) {
                    try {
                        if (com_google_android_gms_internal_zzqf3.isDone()) {
                            com_google_android_gms_internal_zzjn2 = (zzjn) com_google_android_gms_internal_zzqf3.get();
                            this.zzKM.add(com_google_android_gms_internal_zzjn2);
                            if (com_google_android_gms_internal_zzjn2 != null && com_google_android_gms_internal_zzjn2.zzKz == 0) {
                                com_google_android_gms_internal_zzjv = com_google_android_gms_internal_zzjn2.zzKE;
                                if (com_google_android_gms_internal_zzjv != null && com_google_android_gms_internal_zzjv.zzgH() > j) {
                                    zzgH = com_google_android_gms_internal_zzjv.zzgH();
                                    com_google_android_gms_internal_zzjn3 = com_google_android_gms_internal_zzjn2;
                                    com_google_android_gms_internal_zzqf2 = com_google_android_gms_internal_zzqf3;
                                    com_google_android_gms_internal_zzjn4 = com_google_android_gms_internal_zzjn3;
                                    com_google_android_gms_internal_zzqf = com_google_android_gms_internal_zzqf2;
                                    com_google_android_gms_internal_zzjn3 = com_google_android_gms_internal_zzjn4;
                                    max = Math.max(j3 - (zzv.zzcP().currentTimeMillis() - currentTimeMillis), 0);
                                    j = zzgH;
                                    com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn3;
                                    j3 = max;
                                }
                            }
                            com_google_android_gms_internal_zzjn4 = com_google_android_gms_internal_zzjn;
                            com_google_android_gms_internal_zzqf2 = com_google_android_gms_internal_zzqf;
                            zzgH = j;
                            com_google_android_gms_internal_zzqf = com_google_android_gms_internal_zzqf2;
                            com_google_android_gms_internal_zzjn3 = com_google_android_gms_internal_zzjn4;
                            max = Math.max(j3 - (zzv.zzcP().currentTimeMillis() - currentTimeMillis), 0);
                            j = zzgH;
                            com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn3;
                            j3 = max;
                        }
                    } catch (InterruptedException e) {
                        max = e;
                        try {
                            zzpy.zzc("Exception while processing an adapter; continuing with other adapters", max);
                            j3 = max;
                        } finally {
                            com_google_android_gms_internal_zzjn = j3 - (zzv.zzcP().currentTimeMillis() - currentTimeMillis);
                            j = 0;
                            Math.max(com_google_android_gms_internal_zzjn, j);
                            j = j3;
                        }
                    } catch (ExecutionException e2) {
                        max = e2;
                        zzpy.zzc("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (RemoteException e3) {
                        max = e3;
                        zzpy.zzc("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (TimeoutException e4) {
                        max = e4;
                        zzpy.zzc("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    }
                }
                com_google_android_gms_internal_zzjn2 = (zzjn) com_google_android_gms_internal_zzqf3.get(j3, TimeUnit.MILLISECONDS);
                this.zzKM.add(com_google_android_gms_internal_zzjn2);
                com_google_android_gms_internal_zzjv = com_google_android_gms_internal_zzjn2.zzKE;
                zzgH = com_google_android_gms_internal_zzjv.zzgH();
                com_google_android_gms_internal_zzjn3 = com_google_android_gms_internal_zzjn2;
                com_google_android_gms_internal_zzqf2 = com_google_android_gms_internal_zzqf3;
                com_google_android_gms_internal_zzjn4 = com_google_android_gms_internal_zzjn3;
                com_google_android_gms_internal_zzqf = com_google_android_gms_internal_zzqf2;
                com_google_android_gms_internal_zzjn3 = com_google_android_gms_internal_zzjn4;
                max = Math.max(j3 - (zzv.zzcP().currentTimeMillis() - currentTimeMillis), 0);
                j = zzgH;
                com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn3;
                j3 = max;
            }
            zza(com_google_android_gms_internal_zzqf);
            return com_google_android_gms_internal_zzjn == null ? new zzjn(1) : com_google_android_gms_internal_zzjn;
        }
    }

    public void cancel() {
        synchronized (this.zzrN) {
            this.zzKK = true;
            for (zzjm cancel : this.zzKL.values()) {
                cancel.cancel();
            }
        }
    }

    public zzjn zzd(List<zzji> list) {
        zzpy.zzbc("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (zzji com_google_android_gms_internal_zzji : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzji.zzJH);
            zzpy.zzbd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String com_google_android_gms_internal_zzjm : com_google_android_gms_internal_zzji.zzJI) {
                zzjm com_google_android_gms_internal_zzjm2 = new zzjm(this.mContext, com_google_android_gms_internal_zzjm, this.zzsD, this.zzKq, com_google_android_gms_internal_zzji, this.zzKG.zzRd, this.zzKG.zzvj, this.zzKG.zzvf, this.zzvW, this.zzKs, this.zzKG.zzvx, this.zzKG.zzvB);
                zzqf zza = zzph.zza(newCachedThreadPool, new 1(this, com_google_android_gms_internal_zzjm2));
                this.zzKL.put(zza, com_google_android_gms_internal_zzjm2);
                arrayList.add(zza);
            }
        }
        switch (this.zzKJ) {
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return zzf(arrayList);
            default:
                return zze(arrayList);
        }
    }

    public List<zzjn> zzgB() {
        return this.zzKM;
    }
}
