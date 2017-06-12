package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzfu;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzng;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzqr;

@zzmb
public class zzv {
    private static final Object zztU;
    private static zzv zzux;
    private final zzf zzuA;
    private final zzln zzuB;
    private final zzpi zzuC;
    private final zzqr zzuD;
    private final zzpj zzuE;
    private final zzda zzuF;
    private final zzoy zzuG;
    private final zzdk zzuH;
    private final zze zzuI;
    private final zzg zzuJ;
    private final zzga zzuK;
    private final zzpm zzuL;
    private final zzng zzuM;
    private final zzfu zzuN;
    private final zzfv zzuO;
    private final zzfw zzuP;
    private final zzqh zzuQ;
    private final zzi zzuR;
    private final zzis zzuS;
    private final zzje zzuT;
    private final zzpq zzuU;
    private final zzr zzuV;
    private final zzs zzuW;
    private final zzjo zzuX;
    private final zzpr zzuY;
    private final zzq zzuZ;
    private final zza zzuy;
    private final zzmc zzuz;
    private final zzik zzva;
    private final zzqk zzvb;

    static {
        zztU = new Object();
        zza(new zzv());
    }

    protected zzv() {
        this.zzuy = new zza();
        this.zzuz = new zzmc();
        this.zzuA = new zzf();
        this.zzuB = new zzln();
        this.zzuC = new zzpi();
        this.zzuD = new zzqr();
        this.zzuE = zzpj.zzah(VERSION.SDK_INT);
        this.zzuF = new zzda();
        this.zzuG = new zzoy(this.zzuC);
        this.zzuH = new zzdk();
        this.zzuI = zzh.zzyv();
        this.zzuJ = new zzg();
        this.zzuK = new zzga();
        this.zzuL = new zzpm();
        this.zzuM = new zzng();
        this.zzuN = new zzfu();
        this.zzuO = new zzfv();
        this.zzuP = new zzfw();
        this.zzuQ = new zzqh();
        this.zzuR = new zzi();
        this.zzuS = new zzis();
        this.zzuT = new zzje();
        this.zzuU = new zzpq();
        this.zzuV = new zzr();
        this.zzuW = new zzs();
        this.zzuX = new zzjo();
        this.zzuY = new zzpr();
        this.zzuZ = new zzq();
        this.zzva = new zzik();
        this.zzvb = new zzqk();
    }

    protected static void zza(zzv com_google_android_gms_ads_internal_zzv) {
        synchronized (zztU) {
            zzux = com_google_android_gms_ads_internal_zzv;
        }
    }

    private static zzv zzcE() {
        zzv com_google_android_gms_ads_internal_zzv;
        synchronized (zztU) {
            com_google_android_gms_ads_internal_zzv = zzux;
        }
        return com_google_android_gms_ads_internal_zzv;
    }

    public static zzmc zzcF() {
        return zzcE().zzuz;
    }

    public static zza zzcG() {
        return zzcE().zzuy;
    }

    public static zzf zzcH() {
        return zzcE().zzuA;
    }

    public static zzln zzcI() {
        return zzcE().zzuB;
    }

    public static zzpi zzcJ() {
        return zzcE().zzuC;
    }

    public static zzqr zzcK() {
        return zzcE().zzuD;
    }

    public static zzpj zzcL() {
        return zzcE().zzuE;
    }

    public static zzda zzcM() {
        return zzcE().zzuF;
    }

    public static zzoy zzcN() {
        return zzcE().zzuG;
    }

    public static zzdk zzcO() {
        return zzcE().zzuH;
    }

    public static zze zzcP() {
        return zzcE().zzuI;
    }

    public static zzga zzcQ() {
        return zzcE().zzuK;
    }

    public static zzpm zzcR() {
        return zzcE().zzuL;
    }

    public static zzng zzcS() {
        return zzcE().zzuM;
    }

    public static zzfv zzcT() {
        return zzcE().zzuO;
    }

    public static zzfu zzcU() {
        return zzcE().zzuN;
    }

    public static zzfw zzcV() {
        return zzcE().zzuP;
    }

    public static zzqh zzcW() {
        return zzcE().zzuQ;
    }

    public static zzi zzcX() {
        return zzcE().zzuR;
    }

    public static zzis zzcY() {
        return zzcE().zzuS;
    }

    public static zzpq zzcZ() {
        return zzcE().zzuU;
    }

    public static zzr zzda() {
        return zzcE().zzuV;
    }

    public static zzs zzdb() {
        return zzcE().zzuW;
    }

    public static zzjo zzdc() {
        return zzcE().zzuX;
    }

    public static zzq zzdd() {
        return zzcE().zzuZ;
    }

    public static zzpr zzde() {
        return zzcE().zzuY;
    }

    public static zzg zzdf() {
        return zzcE().zzuJ;
    }

    public static zzik zzdg() {
        return zzcE().zzva;
    }

    public static zzqk zzdh() {
        return zzcE().zzvb;
    }
}
