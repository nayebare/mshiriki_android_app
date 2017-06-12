package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzayv.zza;
import com.google.android.gms.tagmanager.zzay;
import com.google.android.gms.tagmanager.zzbb;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class zzazn extends zza {
    private final ExecutorService zzbHn;
    private final zzbb zzbHp;
    private final Map<String, zzayg> zzbJg;
    private final zzayh zzbJh;

    /* renamed from: com.google.android.gms.internal.zzazn.1 */
    class C11361 implements Runnable {
        final /* synthetic */ String zzbIY;
        final /* synthetic */ String zzbIZ;
        final /* synthetic */ String zzbJa;
        final /* synthetic */ zzayu zzbJi;
        final /* synthetic */ zzazn zzbJj;

        C11361(zzazn com_google_android_gms_internal_zzazn, String str, String str2, String str3, zzayu com_google_android_gms_internal_zzayu) {
            this.zzbJj = com_google_android_gms_internal_zzazn;
            this.zzbIY = str;
            this.zzbIZ = str2;
            this.zzbJa = str3;
            this.zzbJi = com_google_android_gms_internal_zzayu;
        }

        public void run() {
            boolean z = true;
            try {
                if (!this.zzbJj.zzbJg.containsKey(this.zzbIY)) {
                    this.zzbJj.zzbJg.put(this.zzbIY, this.zzbJj.zzbJh.zzm(this.zzbIY, this.zzbIZ, this.zzbJa));
                }
            } catch (Throwable th) {
                z = false;
            }
            try {
                if (this.zzbJi != null) {
                    this.zzbJi.zza(z, this.zzbIY);
                }
            } catch (Throwable e) {
                zzayx.zzb("Error relaying callback", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazn.2 */
    class C11372 implements Runnable {
        final /* synthetic */ zzazn zzbJj;
        final /* synthetic */ zzaym zzbJk;

        C11372(zzazn com_google_android_gms_internal_zzazn, zzaym com_google_android_gms_internal_zzaym) {
            this.zzbJj = com_google_android_gms_internal_zzazn;
            this.zzbJk = com_google_android_gms_internal_zzaym;
        }

        public void run() {
            if (this.zzbJj.zzbJg.isEmpty()) {
                zzayx.m23e("TagManagerBackend emit called without loaded container.");
                return;
            }
            for (zzayg zza : this.zzbJj.zzbJg.values()) {
                zza.zza(this.zzbJk);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzazn.3 */
    class C11383 implements Runnable {
        final /* synthetic */ zzazn zzbJj;

        C11383(zzazn com_google_android_gms_internal_zzazn) {
            this.zzbJj = com_google_android_gms_internal_zzazn;
        }

        public void run() {
            if (this.zzbJj.zzbJg.isEmpty()) {
                zzayx.zzbe("TagManagerBackend dispatch called without loaded container.");
                return;
            }
            for (zzayg dispatch : this.zzbJj.zzbJg.values()) {
                dispatch.dispatch();
            }
        }
    }

    public zzazn(Context context, zzbb com_google_android_gms_tagmanager_zzbb, zzay com_google_android_gms_tagmanager_zzay) {
        this(com_google_android_gms_tagmanager_zzbb, new zzayh(context, com_google_android_gms_tagmanager_zzbb, com_google_android_gms_tagmanager_zzay), zzazo.zzQR());
    }

    zzazn(zzbb com_google_android_gms_tagmanager_zzbb, zzayh com_google_android_gms_internal_zzayh, ExecutorService executorService) {
        this.zzbJg = new HashMap(1);
        zzac.zzw(com_google_android_gms_tagmanager_zzbb);
        this.zzbHp = com_google_android_gms_tagmanager_zzbb;
        this.zzbJh = com_google_android_gms_internal_zzayh;
        this.zzbHn = executorService;
    }

    public void dispatch() {
        this.zzbHn.execute(new C11383(this));
    }

    public void zzQw() throws RemoteException {
        this.zzbJg.clear();
    }

    public void zza(String str, Bundle bundle, String str2, long j, boolean z) throws RemoteException {
        this.zzbHn.execute(new C11372(this, new zzaym(str, bundle, str2, new Date(j), z, this.zzbHp)));
    }

    public void zza(String str, @Nullable String str2, @Nullable String str3, @Nullable zzayu com_google_android_gms_internal_zzayu) throws RemoteException {
        this.zzbHn.execute(new C11361(this, str, str2, str3, com_google_android_gms_internal_zzayu));
    }

    public void zzn(String str, @Nullable String str2, @Nullable String str3) throws RemoteException {
        zza(str, str2, str3, null);
    }
}
