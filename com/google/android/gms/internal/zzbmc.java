package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboq.zza;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.concurrent.ScheduledExecutorService;

public class zzbmc {
    protected long cacheSize;
    protected FirebaseApp zzbYm;
    protected zzboq zzbZw;
    protected boolean zzbZx;
    protected String zzbZz;
    protected zzbmg zzcbK;
    protected zzbly zzcbL;
    protected zzbmo zzcbM;
    protected String zzcbN;
    protected zza zzcbO;
    private boolean zzcbP;
    private zzbmk zzcbQ;
    private boolean zzcbx;

    /* renamed from: com.google.android.gms.internal.zzbmc.1 */
    class C12101 implements zzblm {
        final /* synthetic */ zzbly zzcbR;

        /* renamed from: com.google.android.gms.internal.zzbmc.1.1 */
        class C12091 implements zzbly.zza {
            final /* synthetic */ zzblm.zza zzcbg;

            C12091(C12101 c12101, zzblm.zza com_google_android_gms_internal_zzblm_zza) {
                this.zzcbg = com_google_android_gms_internal_zzblm_zza;
            }

            public void onError(String str) {
                this.zzcbg.onError(str);
            }

            public void zziM(String str) {
                this.zzcbg.zziM(str);
            }
        }

        C12101(zzbly com_google_android_gms_internal_zzbly) {
            this.zzcbR = com_google_android_gms_internal_zzbly;
        }

        public void zza(boolean z, zzblm.zza com_google_android_gms_internal_zzblm_zza) {
            this.zzcbR.zza(z, new C12091(this, com_google_android_gms_internal_zzblm_zza));
        }
    }

    public zzbmc() {
        this.zzcbO = zza.INFO;
        this.cacheSize = 10485760;
        this.zzcbx = false;
        this.zzcbP = false;
    }

    private ScheduledExecutorService zzVJ() {
        zzbmo zzWR = zzWR();
        if (zzWR instanceof zzbqa) {
            return ((zzbqa) zzWR).zzVJ();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private zzbmk zzWI() {
        if (this.zzcbQ == null) {
            if (zzbpv.zzZW()) {
                zzWJ();
            } else if (zzbmh.isActive()) {
                zzbmk com_google_android_gms_internal_zzbmk = zzbmh.INSTANCE;
                com_google_android_gms_internal_zzbmk.initialize();
                this.zzcbQ = com_google_android_gms_internal_zzbmk;
            } else {
                this.zzcbQ = zzbmi.INSTANCE;
            }
        }
        return this.zzcbQ;
    }

    private synchronized void zzWJ() {
        this.zzcbQ = new zzbkx(this.zzbYm);
    }

    private void zzWL() {
        zzWU();
        zzWI();
        zzWX();
        zzWW();
        zzWV();
        zzWZ();
        zzWY();
    }

    private void zzWM() {
        this.zzcbK.restart();
        this.zzcbM.restart();
    }

    private void zzWU() {
        if (this.zzbZw == null) {
            this.zzbZw = zzWI().zza(this, this.zzcbO, null);
        }
    }

    private void zzWV() {
        if (this.zzcbM == null) {
            this.zzcbM = this.zzcbQ.zzb(this);
        }
    }

    private void zzWW() {
        if (this.zzcbK == null) {
            this.zzcbK = zzWI().zza(this);
        }
    }

    private void zzWX() {
        if (this.zzbZz == null) {
            this.zzbZz = zziY(zzWI().zzc(this));
        }
    }

    private void zzWY() {
        if (this.zzcbL == null) {
            this.zzcbL = zzWI().zza(zzVJ());
        }
    }

    private void zzWZ() {
        if (this.zzcbN == null) {
            this.zzcbN = "default";
        }
    }

    private static zzblm zza(zzbly com_google_android_gms_internal_zzbly) {
        return new C12101(com_google_android_gms_internal_zzbly);
    }

    private String zziY(String str) {
        return "Firebase/" + "5" + "/" + FirebaseDatabase.getSdkVersion() + "/" + str;
    }

    public boolean isFrozen() {
        return this.zzcbx;
    }

    void stop() {
        this.zzcbP = true;
        this.zzcbK.shutdown();
        this.zzcbM.shutdown();
    }

    public zzboq zzVH() {
        return this.zzbZw;
    }

    public boolean zzVK() {
        return this.zzbZx;
    }

    public void zzWK() {
        if (this.zzcbP) {
            zzWM();
            this.zzcbP = false;
        }
    }

    protected void zzWN() {
        if (isFrozen()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public zzbln zzWO() {
        return new zzbln(zzVH(), zza(zzWT()), zzVJ(), zzVK(), FirebaseDatabase.getSdkVersion(), zzjQ());
    }

    public long zzWP() {
        return this.cacheSize;
    }

    public zzbmg zzWQ() {
        return this.zzcbK;
    }

    public zzbmo zzWR() {
        return this.zzcbM;
    }

    public String zzWS() {
        return this.zzcbN;
    }

    public zzbly zzWT() {
        return this.zzcbL;
    }

    public zza zzWu() {
        return this.zzcbO;
    }

    synchronized void zzWz() {
        if (!this.zzcbx) {
            this.zzcbx = true;
            zzWL();
        }
    }

    public zzblr zza(zzblp com_google_android_gms_internal_zzblp, zzblr.zza com_google_android_gms_internal_zzblr_zza) {
        return zzWI().zza(this, zzWO(), com_google_android_gms_internal_zzblp, com_google_android_gms_internal_zzblr_zza);
    }

    public zzbop zziW(String str) {
        return new zzbop(this.zzbZw, str);
    }

    zzbnn zziX(String str) {
        if (!this.zzbZx) {
            return new zzbnm();
        }
        zzbnn zza = this.zzcbQ.zza(this, str);
        if (zza != null) {
            return zza;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public String zzjQ() {
        return this.zzbZz;
    }
}
