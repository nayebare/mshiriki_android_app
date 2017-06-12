package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbmt.zzd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.Transaction.Result;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzbml implements com.google.android.gms.internal.zzblr.zza {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final zzbmm zzbXP;
    private final zzblr zzcaY;
    private final zzbqc zzccf;
    private zzbmq zzccg;
    private zzbmr zzcch;
    private zzbnu<List<zza>> zzcci;
    private boolean zzccj;
    private final zzboc zzcck;
    private final zzbmc zzccl;
    private final zzbop zzccm;
    private final zzbop zzccn;
    private final zzbop zzcco;
    public long zzccp;
    private long zzccq;
    private zzbmt zzccr;
    private zzbmt zzccs;
    private FirebaseDatabase zzcct;
    private boolean zzccu;
    private long zzccv;

    /* renamed from: com.google.android.gms.internal.zzbml.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zza zzccG;
        final /* synthetic */ zzbml zzccw;

        AnonymousClass10(zzbml com_google_android_gms_internal_zzbml, zza com_google_android_gms_internal_zzbml_zza) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzccG = com_google_android_gms_internal_zzbml_zza;
        }

        public void run() {
            this.zzccw.zze(new zzbmz(this.zzccw, this.zzccG.zzccW, zzboe.zzN(this.zzccG.zzbXY)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ zza zzccG;
        final /* synthetic */ DatabaseError zzccH;
        final /* synthetic */ DataSnapshot zzccI;

        AnonymousClass11(zzbml com_google_android_gms_internal_zzbml, zza com_google_android_gms_internal_zzbml_zza, DatabaseError databaseError, DataSnapshot dataSnapshot) {
            this.zzccG = com_google_android_gms_internal_zzbml_zza;
            this.zzccH = databaseError;
            this.zzccI = dataSnapshot;
        }

        public void run() {
            this.zzccG.zzccV.onComplete(this.zzccH, false, this.zzccI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.13 */
    class AnonymousClass13 implements com.google.android.gms.internal.zzbnu.zzb<List<zza>> {
        final /* synthetic */ List zzccD;
        final /* synthetic */ zzbml zzccw;

        AnonymousClass13(zzbml com_google_android_gms_internal_zzbml, List list) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzccD = list;
        }

        public void zzd(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
            this.zzccw.zza(this.zzccD, (zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.14 */
    class AnonymousClass14 implements com.google.android.gms.internal.zzbnu.zza<List<zza>> {
        final /* synthetic */ int zzccJ;
        final /* synthetic */ zzbml zzccw;

        AnonymousClass14(zzbml com_google_android_gms_internal_zzbml, int i) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzccJ = i;
        }

        public boolean zze(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
            this.zzccw.zza((zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza, this.zzccJ);
            return false;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.15 */
    class AnonymousClass15 implements com.google.android.gms.internal.zzbnu.zzb<List<zza>> {
        final /* synthetic */ int zzccJ;
        final /* synthetic */ zzbml zzccw;

        AnonymousClass15(zzbml com_google_android_gms_internal_zzbml, int i) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzccJ = i;
        }

        public void zzd(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
            this.zzccw.zza((zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza, this.zzccJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.16 */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ zza zzccG;
        final /* synthetic */ DatabaseError zzccK;

        AnonymousClass16(zzbml com_google_android_gms_internal_zzbml, zza com_google_android_gms_internal_zzbml_zza, DatabaseError databaseError) {
            this.zzccG = com_google_android_gms_internal_zzbml_zza;
            this.zzccK = databaseError;
        }

        public void run() {
            this.zzccG.zzccV.onComplete(this.zzccK, false, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.19 */
    class AnonymousClass19 implements zzblu {
        final /* synthetic */ zzbmx zzccQ;
        final /* synthetic */ zzbml zzccw;

        AnonymousClass19(zzbml com_google_android_gms_internal_zzbml, zzbmx com_google_android_gms_internal_zzbmx) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzccQ = com_google_android_gms_internal_zzbmx;
        }

        public void zzan(String str, String str2) {
            DatabaseError zzap = zzbml.zzao(str, str2);
            this.zzccw.zza("Persisted write", this.zzccQ.zzVc(), zzap);
            this.zzccw.zza(this.zzccQ.zzXC(), this.zzccQ.zzVc(), zzap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.1 */
    class C12191 implements Runnable {
        final /* synthetic */ zzbml zzccw;

        C12191(zzbml com_google_android_gms_internal_zzbml) {
            this.zzccw = com_google_android_gms_internal_zzbml;
        }

        public void run() {
            this.zzccw.zzXn();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.20 */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ DatabaseError zzccR;
        final /* synthetic */ DatabaseReference zzccS;
        final /* synthetic */ CompletionListener zzccz;

        AnonymousClass20(zzbml com_google_android_gms_internal_zzbml, CompletionListener completionListener, DatabaseError databaseError, DatabaseReference databaseReference) {
            this.zzccz = completionListener;
            this.zzccR = databaseError;
            this.zzccS = databaseReference;
        }

        public void run() {
            this.zzccz.onComplete(this.zzccR, this.zzccS);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.21 */
    class AnonymousClass21 implements zzblu {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ long zzccT;
        final /* synthetic */ zzbml zzccw;
        final /* synthetic */ CompletionListener zzccz;

        AnonymousClass21(zzbml com_google_android_gms_internal_zzbml, zzbmj com_google_android_gms_internal_zzbmj, long j, CompletionListener completionListener) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
            this.zzccT = j;
            this.zzccz = completionListener;
        }

        public void zzan(String str, String str2) {
            DatabaseError zzap = zzbml.zzao(str, str2);
            this.zzccw.zza("setValue", this.zzcbD, zzap);
            this.zzccw.zza(this.zzccT, this.zzcbD, zzap);
            this.zzccw.zza(this.zzccz, zzap, this.zzcbD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.22 */
    class AnonymousClass22 implements zzblu {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ long zzccT;
        final /* synthetic */ zzbml zzccw;
        final /* synthetic */ CompletionListener zzccz;

        AnonymousClass22(zzbml com_google_android_gms_internal_zzbml, zzbmj com_google_android_gms_internal_zzbmj, long j, CompletionListener completionListener) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
            this.zzccT = j;
            this.zzccz = completionListener;
        }

        public void zzan(String str, String str2) {
            DatabaseError zzap = zzbml.zzao(str, str2);
            this.zzccw.zza("updateChildren", this.zzcbD, zzap);
            this.zzccw.zza(this.zzccT, this.zzcbD, zzap);
            this.zzccw.zza(this.zzccz, zzap, this.zzcbD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.23 */
    class AnonymousClass23 implements zzblu {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ zzbpe zzccU;
        final /* synthetic */ zzbml zzccw;
        final /* synthetic */ CompletionListener zzccz;

        AnonymousClass23(zzbml com_google_android_gms_internal_zzbml, zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, CompletionListener completionListener) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
            this.zzccU = com_google_android_gms_internal_zzbpe;
            this.zzccz = completionListener;
        }

        public void zzan(String str, String str2) {
            DatabaseError zzap = zzbml.zzao(str, str2);
            this.zzccw.zza("onDisconnect().setValue", this.zzcbD, zzap);
            if (zzap == null) {
                this.zzccw.zzcch.zzh(this.zzcbD, this.zzccU);
            }
            this.zzccw.zza(this.zzccz, zzap, this.zzcbD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.2 */
    class C12202 implements zzblu {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ zzbml zzccw;
        final /* synthetic */ Map zzccx;
        final /* synthetic */ CompletionListener zzccy;

        C12202(zzbml com_google_android_gms_internal_zzbml, zzbmj com_google_android_gms_internal_zzbmj, Map map, CompletionListener completionListener) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
            this.zzccx = map;
            this.zzccy = completionListener;
        }

        public void zzan(String str, String str2) {
            DatabaseError zzap = zzbml.zzao(str, str2);
            this.zzccw.zza("onDisconnect().updateChildren", this.zzcbD, zzap);
            if (zzap == null) {
                for (Entry entry : this.zzccx.entrySet()) {
                    this.zzccw.zzcch.zzh(this.zzcbD.zzh((zzbmj) entry.getKey()), (zzbpe) entry.getValue());
                }
            }
            this.zzccw.zza(this.zzccy, zzap, this.zzcbD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.3 */
    class C12213 implements zzblu {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ zzbml zzccw;
        final /* synthetic */ CompletionListener zzccz;

        C12213(zzbml com_google_android_gms_internal_zzbml, zzbmj com_google_android_gms_internal_zzbmj, CompletionListener completionListener) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
            this.zzccz = completionListener;
        }

        public void zzan(String str, String str2) {
            DatabaseError zzap = zzbml.zzao(str, str2);
            if (zzap == null) {
                this.zzccw.zzcch.zzr(this.zzcbD);
            }
            this.zzccw.zza(this.zzccz, zzap, this.zzcbD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.4 */
    class C12224 implements com.google.android.gms.internal.zzbmr.zzb {
        final /* synthetic */ List zzccA;
        final /* synthetic */ zzbml zzccw;

        C12224(zzbml com_google_android_gms_internal_zzbml, List list) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzccA = list;
        }

        public void zzf(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzccA.addAll(this.zzccw.zzccs.zzi(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe));
            this.zzccw.zzo(this.zzccw.zzb(com_google_android_gms_internal_zzbmj, -9));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.5 */
    class C12235 implements ValueEventListener {
        C12235(zzbml com_google_android_gms_internal_zzbml) {
        }

        public void onCancelled(DatabaseError databaseError) {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.6 */
    class C12246 implements Runnable {
        final /* synthetic */ Handler zzbXL;
        final /* synthetic */ DatabaseError zzccB;
        final /* synthetic */ DataSnapshot zzccC;

        C12246(zzbml com_google_android_gms_internal_zzbml, Handler handler, DatabaseError databaseError, DataSnapshot dataSnapshot) {
            this.zzbXL = handler;
            this.zzccB = databaseError;
            this.zzccC = dataSnapshot;
        }

        public void run() {
            this.zzbXL.onComplete(this.zzccB, false, this.zzccC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.7 */
    class C12257 implements com.google.android.gms.internal.zzbnu.zzb<List<zza>> {
        final /* synthetic */ zzbml zzccw;

        C12257(zzbml com_google_android_gms_internal_zzbml) {
            this.zzccw = com_google_android_gms_internal_zzbml;
        }

        public void zzd(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
            this.zzccw.zza((zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.8 */
    class C12278 implements zzblu {
        final /* synthetic */ zzbmj zzcbD;
        final /* synthetic */ List zzccD;
        final /* synthetic */ zzbml zzccE;
        final /* synthetic */ zzbml zzccw;

        /* renamed from: com.google.android.gms.internal.zzbml.8.1 */
        class C12261 implements Runnable {
            final /* synthetic */ DataSnapshot zzccC;
            final /* synthetic */ zza zzccF;

            C12261(C12278 c12278, zza com_google_android_gms_internal_zzbml_zza, DataSnapshot dataSnapshot) {
                this.zzccF = com_google_android_gms_internal_zzbml_zza;
                this.zzccC = dataSnapshot;
            }

            public void run() {
                this.zzccF.zzccV.onComplete(null, true, this.zzccC);
            }
        }

        C12278(zzbml com_google_android_gms_internal_zzbml, zzbmj com_google_android_gms_internal_zzbmj, List list, zzbml com_google_android_gms_internal_zzbml2) {
            this.zzccw = com_google_android_gms_internal_zzbml;
            this.zzcbD = com_google_android_gms_internal_zzbmj;
            this.zzccD = list;
            this.zzccE = com_google_android_gms_internal_zzbml2;
        }

        public void zzan(String str, String str2) {
            int i = 0;
            DatabaseError zzap = zzbml.zzao(str, str2);
            this.zzccw.zza("Transaction", this.zzcbD, zzap);
            List arrayList = new ArrayList();
            if (zzap == null) {
                List arrayList2 = new ArrayList();
                for (zza com_google_android_gms_internal_zzbml_zza : this.zzccD) {
                    com_google_android_gms_internal_zzbml_zza.zzccX = zzb.COMPLETED;
                    arrayList.addAll(this.zzccw.zzccs.zza(com_google_android_gms_internal_zzbml_zza.zzcdb, false, false, this.zzccw.zzccf));
                    arrayList2.add(new C12261(this, com_google_android_gms_internal_zzbml_zza, com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this.zzccE, com_google_android_gms_internal_zzbml_zza.zzbXY), zzboz.zzn(com_google_android_gms_internal_zzbml_zza.zzcde))));
                    this.zzccw.zze(new zzbmz(this.zzccw, com_google_android_gms_internal_zzbml_zza.zzccW, zzboe.zzN(com_google_android_gms_internal_zzbml_zza.zzbXY)));
                }
                this.zzccw.zzb(this.zzccw.zzcci.zzL(this.zzcbD));
                this.zzccw.zzXt();
                this.zzccE.zzW(arrayList);
                while (i < arrayList2.size()) {
                    this.zzccw.zzq((Runnable) arrayList2.get(i));
                    i++;
                }
                return;
            }
            if (zzap.getCode() == -1) {
                for (zza com_google_android_gms_internal_zzbml_zza2 : this.zzccD) {
                    if (com_google_android_gms_internal_zzbml_zza2.zzccX == zzb.SENT_NEEDS_ABORT) {
                        com_google_android_gms_internal_zzbml_zza2.zzccX = zzb.NEEDS_ABORT;
                    } else {
                        com_google_android_gms_internal_zzbml_zza2.zzccX = zzb.RUN;
                    }
                }
            } else {
                for (zza com_google_android_gms_internal_zzbml_zza22 : this.zzccD) {
                    com_google_android_gms_internal_zzbml_zza22.zzccX = zzb.NEEDS_ABORT;
                    com_google_android_gms_internal_zzbml_zza22.zzcda = zzap;
                }
            }
            this.zzccw.zzo(this.zzcbD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbml.9 */
    class C12289 implements com.google.android.gms.internal.zzbnu.zzb<List<zza>> {
        final /* synthetic */ zzbml zzccw;

        C12289(zzbml com_google_android_gms_internal_zzbml) {
            this.zzccw = com_google_android_gms_internal_zzbml;
        }

        public void zzd(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
            this.zzccw.zzb((zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza);
        }
    }

    private static class zza implements Comparable<zza> {
        private int retryCount;
        private zzbmj zzbXY;
        private Handler zzccV;
        private ValueEventListener zzccW;
        private zzb zzccX;
        private long zzccY;
        private boolean zzccZ;
        private DatabaseError zzcda;
        private long zzcdb;
        private zzbpe zzcdc;
        private zzbpe zzcdd;
        private zzbpe zzcde;

        private zza(zzbmj com_google_android_gms_internal_zzbmj, Handler handler, ValueEventListener valueEventListener, zzb com_google_android_gms_internal_zzbml_zzb, boolean z, long j) {
            this.zzbXY = com_google_android_gms_internal_zzbmj;
            this.zzccV = handler;
            this.zzccW = valueEventListener;
            this.zzccX = com_google_android_gms_internal_zzbml_zzb;
            this.retryCount = 0;
            this.zzccZ = z;
            this.zzccY = j;
            this.zzcda = null;
            this.zzcdc = null;
            this.zzcdd = null;
            this.zzcde = null;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return zza((zza) obj);
        }

        public int zza(zza com_google_android_gms_internal_zzbml_zza) {
            return this.zzccY < com_google_android_gms_internal_zzbml_zza.zzccY ? -1 : this.zzccY == com_google_android_gms_internal_zzbml_zza.zzccY ? 0 : 1;
        }
    }

    private enum zzb {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    static {
        $assertionsDisabled = !zzbml.class.desiredAssertionStatus();
    }

    zzbml(zzbmm com_google_android_gms_internal_zzbmm, zzbmc com_google_android_gms_internal_zzbmc, FirebaseDatabase firebaseDatabase) {
        this.zzccf = new zzbqc(new zzbpz(), 0);
        this.zzccj = false;
        this.zzccp = 0;
        this.zzccq = 1;
        this.zzccu = false;
        this.zzccv = 0;
        this.zzbXP = com_google_android_gms_internal_zzbmm;
        this.zzccl = com_google_android_gms_internal_zzbmc;
        this.zzcct = firebaseDatabase;
        this.zzccm = this.zzccl.zziW("RepoOperation");
        this.zzccn = this.zzccl.zziW("Transaction");
        this.zzcco = this.zzccl.zziW("DataOperation");
        this.zzcck = new zzboc(this.zzccl);
        this.zzcaY = com_google_android_gms_internal_zzbmc.zza(new zzblp(com_google_android_gms_internal_zzbmm.zzbZA, com_google_android_gms_internal_zzbmm.zzaFs, com_google_android_gms_internal_zzbmm.zzbZB), this);
        zzs(new C12191(this));
    }

    private void zzW(List<? extends zzboa> list) {
        if (!list.isEmpty()) {
            this.zzcck.zzY(list);
        }
    }

    private void zzXn() {
        this.zzccl.zzWT().zza(new com.google.android.gms.internal.zzbly.zzb() {
            final /* synthetic */ zzbml zzccw;

            {
                this.zzccw = r1;
            }

            public void zziV(String str) {
                this.zzccw.zzccm.zzi("Auth token changed, triggering auth token refresh", new Object[0]);
                this.zzccw.zzcaY.zziO(str);
            }
        });
        this.zzcaY.initialize();
        zzbnn zziX = this.zzccl.zziX(this.zzbXP.zzbZA);
        this.zzccg = new zzbmq();
        this.zzcch = new zzbmr();
        this.zzcci = new zzbnu();
        this.zzccr = new zzbmt(this.zzccl, new zzbnm(), new zzd() {
            final /* synthetic */ zzbml zzccw;

            /* renamed from: com.google.android.gms.internal.zzbml.17.1 */
            class C12171 implements Runnable {
                final /* synthetic */ zzboe zzccL;
                final /* synthetic */ com.google.android.gms.internal.zzbmt.zza zzccM;
                final /* synthetic */ AnonymousClass17 zzccN;

                C12171(AnonymousClass17 anonymousClass17, zzboe com_google_android_gms_internal_zzboe, com.google.android.gms.internal.zzbmt.zza com_google_android_gms_internal_zzbmt_zza) {
                    this.zzccN = anonymousClass17;
                    this.zzccL = com_google_android_gms_internal_zzboe;
                    this.zzccM = com_google_android_gms_internal_zzbmt_zza;
                }

                public void run() {
                    zzbpe zzq = this.zzccN.zzccw.zzccg.zzq(this.zzccL.zzVc());
                    if (!zzq.isEmpty()) {
                        this.zzccN.zzccw.zzW(this.zzccN.zzccw.zzccr.zzi(this.zzccL.zzVc(), zzq));
                        this.zzccM.zzb(null);
                    }
                }
            }

            {
                this.zzccw = r1;
            }

            public void zza(zzboe com_google_android_gms_internal_zzboe, zzbmu com_google_android_gms_internal_zzbmu) {
            }

            public void zza(zzboe com_google_android_gms_internal_zzboe, zzbmu com_google_android_gms_internal_zzbmu, zzblq com_google_android_gms_internal_zzblq, com.google.android.gms.internal.zzbmt.zza com_google_android_gms_internal_zzbmt_zza) {
                this.zzccw.zzs(new C12171(this, com_google_android_gms_internal_zzboe, com_google_android_gms_internal_zzbmt_zza));
            }
        });
        this.zzccs = new zzbmt(this.zzccl, zziX, new zzd() {
            final /* synthetic */ zzbml zzccw;

            /* renamed from: com.google.android.gms.internal.zzbml.18.1 */
            class C12181 implements zzblu {
                final /* synthetic */ com.google.android.gms.internal.zzbmt.zza zzccO;
                final /* synthetic */ AnonymousClass18 zzccP;

                C12181(AnonymousClass18 anonymousClass18, com.google.android.gms.internal.zzbmt.zza com_google_android_gms_internal_zzbmt_zza) {
                    this.zzccP = anonymousClass18;
                    this.zzccO = com_google_android_gms_internal_zzbmt_zza;
                }

                public void zzan(String str, String str2) {
                    this.zzccP.zzccw.zzW(this.zzccO.zzb(zzbml.zzao(str, str2)));
                }
            }

            {
                this.zzccw = r1;
            }

            public void zza(zzboe com_google_android_gms_internal_zzboe, zzbmu com_google_android_gms_internal_zzbmu) {
                this.zzccw.zzcaY.zza(com_google_android_gms_internal_zzboe.zzVc().zzXh(), com_google_android_gms_internal_zzboe.zzYG().zzYC());
            }

            public void zza(zzboe com_google_android_gms_internal_zzboe, zzbmu com_google_android_gms_internal_zzbmu, zzblq com_google_android_gms_internal_zzblq, com.google.android.gms.internal.zzbmt.zza com_google_android_gms_internal_zzbmt_zza) {
                this.zzccw.zzcaY.zza(com_google_android_gms_internal_zzboe.zzVc().zzXh(), com_google_android_gms_internal_zzboe.zzYG().zzYC(), com_google_android_gms_internal_zzblq, com_google_android_gms_internal_zzbmu != null ? Long.valueOf(com_google_android_gms_internal_zzbmu.zzXB()) : null, new C12181(this, com_google_android_gms_internal_zzbmt_zza));
            }
        });
        zza(zziX);
        zzb(zzbmb.zzcbI, Boolean.valueOf(false));
        zzb(zzbmb.zzcbJ, Boolean.valueOf(false));
    }

    private long zzXr() {
        long j = this.zzccq;
        this.zzccq = 1 + j;
        return j;
    }

    private void zzXs() {
        zzbmr zza = zzbmp.zza(this.zzcch, zzbmp.zza(this.zzccf));
        List arrayList = new ArrayList();
        zza.zza(zzbmj.zzXf(), new C12224(this, arrayList));
        this.zzcch = new zzbmr();
        zzW(arrayList);
    }

    private void zzXt() {
        zzbnu com_google_android_gms_internal_zzbnu = this.zzcci;
        zzb(com_google_android_gms_internal_zzbnu);
        zza(com_google_android_gms_internal_zzbnu);
    }

    private long zzXu() {
        long j = this.zzccv;
        this.zzccv = 1 + j;
        return j;
    }

    private zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj, List<Long> list) {
        zzbpe zzc = this.zzccs.zzc(com_google_android_gms_internal_zzbmj, list);
        return zzc == null ? zzbox.zzZp() : zzc;
    }

    private void zza(long j, zzbmj com_google_android_gms_internal_zzbmj, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List zza = this.zzccs.zza(j, !(databaseError == null), true, this.zzccf);
            if (zza.size() > 0) {
                zzo(com_google_android_gms_internal_zzbmj);
            }
            zzW(zza);
        }
    }

    private void zza(zzbnn com_google_android_gms_internal_zzbnn) {
        List<zzbmx> zzVe = com_google_android_gms_internal_zzbnn.zzVe();
        Map zza = zzbmp.zza(this.zzccf);
        long j = Long.MIN_VALUE;
        for (zzbmx com_google_android_gms_internal_zzbmx : zzVe) {
            zzblu anonymousClass19 = new AnonymousClass19(this, com_google_android_gms_internal_zzbmx);
            if (j >= com_google_android_gms_internal_zzbmx.zzXC()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            long zzXC = com_google_android_gms_internal_zzbmx.zzXC();
            this.zzccq = com_google_android_gms_internal_zzbmx.zzXC() + 1;
            if (com_google_android_gms_internal_zzbmx.zzXF()) {
                if (this.zzccm.zzYT()) {
                    this.zzccm.zzi("Restoring overwrite with id " + com_google_android_gms_internal_zzbmx.zzXC(), new Object[0]);
                }
                this.zzcaY.zza(com_google_android_gms_internal_zzbmx.zzVc().zzXh(), com_google_android_gms_internal_zzbmx.zzXD().getValue(true), anonymousClass19);
                this.zzccs.zza(com_google_android_gms_internal_zzbmx.zzVc(), com_google_android_gms_internal_zzbmx.zzXD(), zzbmp.zza(com_google_android_gms_internal_zzbmx.zzXD(), zza), com_google_android_gms_internal_zzbmx.zzXC(), true, false);
            } else {
                if (this.zzccm.zzYT()) {
                    this.zzccm.zzi("Restoring merge with id " + com_google_android_gms_internal_zzbmx.zzXC(), new Object[0]);
                }
                this.zzcaY.zza(com_google_android_gms_internal_zzbmx.zzVc().zzXh(), com_google_android_gms_internal_zzbmx.zzXE().zzaZ(true), anonymousClass19);
                this.zzccs.zza(com_google_android_gms_internal_zzbmx.zzVc(), com_google_android_gms_internal_zzbmx.zzXE(), zzbmp.zza(com_google_android_gms_internal_zzbmx.zzXE(), zza), com_google_android_gms_internal_zzbmx.zzXC(), false);
            }
            j = zzXC;
        }
    }

    private void zza(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
        if (((List) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.getValue()) != null) {
            List<zza> zzc = zzc((zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza);
            if ($assertionsDisabled || zzc.size() > 0) {
                Boolean valueOf;
                Boolean valueOf2 = Boolean.valueOf(true);
                for (zza zzd : zzc) {
                    if (zzd.zzccX != zzb.RUN) {
                        valueOf = Boolean.valueOf(false);
                        break;
                    }
                }
                valueOf = valueOf2;
                if (valueOf.booleanValue()) {
                    zza((List) zzc, com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.zzVc());
                    return;
                }
                return;
            }
            throw new AssertionError();
        } else if (com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.hasChildren()) {
            com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.zzb(new C12257(this));
        }
    }

    private void zza(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza, int i) {
        List list = (List) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.getValue();
        List arrayList = new ArrayList();
        if (list != null) {
            DatabaseError zziE;
            List<Runnable> arrayList2 = new ArrayList();
            if (i == -9) {
                zziE = DatabaseError.zziE("overriddenBySet");
            } else {
                zzbqg.zzb(i == -25, "Unknown transaction abort reason: " + i);
                zziE = DatabaseError.zzpI(-25);
            }
            int i2 = 0;
            int i3 = -1;
            while (i2 < list.size()) {
                int i4;
                zza com_google_android_gms_internal_zzbml_zza = (zza) list.get(i2);
                if (com_google_android_gms_internal_zzbml_zza.zzccX == zzb.SENT_NEEDS_ABORT) {
                    i4 = i3;
                } else if (com_google_android_gms_internal_zzbml_zza.zzccX == zzb.SENT) {
                    if ($assertionsDisabled || i3 == i2 - 1) {
                        com_google_android_gms_internal_zzbml_zza.zzccX = zzb.SENT_NEEDS_ABORT;
                        com_google_android_gms_internal_zzbml_zza.zzcda = zziE;
                        i4 = i2;
                    } else {
                        throw new AssertionError();
                    }
                } else if ($assertionsDisabled || com_google_android_gms_internal_zzbml_zza.zzccX == zzb.RUN) {
                    zze(new zzbmz(this, com_google_android_gms_internal_zzbml_zza.zzccW, zzboe.zzN(com_google_android_gms_internal_zzbml_zza.zzbXY)));
                    if (i == -9) {
                        arrayList.addAll(this.zzccs.zza(com_google_android_gms_internal_zzbml_zza.zzcdb, true, false, this.zzccf));
                    } else {
                        zzbqg.zzb(i == -25, "Unknown transaction abort reason: " + i);
                    }
                    arrayList2.add(new AnonymousClass16(this, com_google_android_gms_internal_zzbml_zza, zziE));
                    i4 = i3;
                } else {
                    throw new AssertionError();
                }
                i2++;
                i3 = i4;
            }
            if (i3 == -1) {
                com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.setValue(null);
            } else {
                com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.setValue(list.subList(0, i3 + 1));
            }
            zzW(arrayList);
            for (Runnable zzq : arrayList2) {
                zzq(zzq);
            }
        }
    }

    private void zza(String str, zzbmj com_google_android_gms_internal_zzbmj, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj.toString());
            String valueOf2 = String.valueOf(databaseError.toString());
            com_google_android_gms_internal_zzbop.warn(new StringBuilder(((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append(str).append(" at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
        }
    }

    private void zza(List<zza> list, zzbmj com_google_android_gms_internal_zzbmj) {
        List arrayList = new ArrayList();
        for (zza zzc : list) {
            arrayList.add(Long.valueOf(zzc.zzcdb));
        }
        zzbpe zza = zza(com_google_android_gms_internal_zzbmj, arrayList);
        String zzZc = zza.zzZc();
        zzbpe com_google_android_gms_internal_zzbpe = zza;
        for (zza zzc2 : list) {
            if ($assertionsDisabled || zzc2.zzccX == zzb.RUN) {
                zzc2.zzccX = zzb.SENT;
                zzc2.retryCount = zzc2.retryCount + 1;
                com_google_android_gms_internal_zzbpe = com_google_android_gms_internal_zzbpe.zzl(zzbmj.zza(com_google_android_gms_internal_zzbmj, zzc2.zzbXY), zzc2.zzcdd);
            } else {
                throw new AssertionError();
            }
        }
        Object value = com_google_android_gms_internal_zzbpe.getValue(true);
        zzXr();
        this.zzcaY.zza(com_google_android_gms_internal_zzbmj.zzXh(), value, zzZc, new C12278(this, com_google_android_gms_internal_zzbmj, list, this));
    }

    private void zza(List<zza> list, zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
        List list2 = (List) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.getValue();
        if (list2 != null) {
            list.addAll(list2);
        }
        com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.zzb(new AnonymousClass13(this, list));
    }

    private static DatabaseError zzao(String str, String str2) {
        return str != null ? DatabaseError.zzal(str, str2) : null;
    }

    private zzbmj zzb(zzbmj com_google_android_gms_internal_zzbmj, int i) {
        zzbmj zzVc = zzp(com_google_android_gms_internal_zzbmj).zzVc();
        if (this.zzccn.zzYT()) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            String valueOf2 = String.valueOf(zzVc);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(valueOf2).length()).append("Aborting transactions for path: ").append(valueOf).append(". Affected: ").append(valueOf2).toString(), new Object[0]);
        }
        zzbnu zzL = this.zzcci.zzL(com_google_android_gms_internal_zzbmj);
        zzL.zza(new AnonymousClass14(this, i));
        zza(zzL, i);
        zzL.zza(new AnonymousClass15(this, i));
        return zzVc;
    }

    private void zzb(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
        List list = (List) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.getValue();
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                int i2;
                if (((zza) list.get(i)).zzccX == zzb.COMPLETED) {
                    list.remove(i);
                    i2 = i;
                } else {
                    i2 = i + 1;
                }
                i = i2;
            }
            if (list.size() > 0) {
                com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.setValue(list);
            } else {
                com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.setValue(null);
            }
        }
        com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.zzb(new C12289(this));
    }

    private void zzb(zzbos com_google_android_gms_internal_zzbos, Object obj) {
        if (com_google_android_gms_internal_zzbos.equals(zzbmb.zzcbH)) {
            this.zzccf.zzaP(((Long) obj).longValue());
        }
        zzbmj com_google_android_gms_internal_zzbmj = new zzbmj(zzbmb.zzcbG, com_google_android_gms_internal_zzbos);
        try {
            zzbpe zzar = zzbpf.zzar(obj);
            this.zzccg.zzg(com_google_android_gms_internal_zzbmj, zzar);
            zzW(this.zzccr.zzi(com_google_android_gms_internal_zzbmj, zzar));
        } catch (DatabaseException e) {
            this.zzccm.zzd("Failed to parse info update", e);
        }
    }

    private void zzb(List<zza> list, zzbmj com_google_android_gms_internal_zzbmj) {
        if (!list.isEmpty()) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (zza zzc : list) {
                arrayList2.add(Long.valueOf(zzc.zzcdb));
            }
            for (zza com_google_android_gms_internal_zzbml_zza : list) {
                zzbmj zza = zzbmj.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbml_zza.zzbXY);
                ArrayList arrayList3 = new ArrayList();
                if ($assertionsDisabled || zza != null) {
                    Object obj;
                    DatabaseError zzk;
                    if (com_google_android_gms_internal_zzbml_zza.zzccX == zzb.NEEDS_ABORT) {
                        obj = 1;
                        zzk = com_google_android_gms_internal_zzbml_zza.zzcda;
                        if (zzk.getCode() != -25) {
                            arrayList3.addAll(this.zzccs.zza(com_google_android_gms_internal_zzbml_zza.zzcdb, true, false, this.zzccf));
                        }
                    } else if (com_google_android_gms_internal_zzbml_zza.zzccX != zzb.RUN) {
                        zzk = null;
                        obj = null;
                    } else if (com_google_android_gms_internal_zzbml_zza.retryCount >= 25) {
                        obj = 1;
                        zzk = DatabaseError.zziE("maxretries");
                        arrayList3.addAll(this.zzccs.zza(com_google_android_gms_internal_zzbml_zza.zzcdb, true, false, this.zzccf));
                    } else {
                        Result doTransaction;
                        zzbpe zza2 = zza(com_google_android_gms_internal_zzbml_zza.zzbXY, arrayList2);
                        com_google_android_gms_internal_zzbml_zza.zzcdc = zza2;
                        try {
                            doTransaction = com_google_android_gms_internal_zzbml_zza.zzccV.doTransaction(com.google.firebase.database.zza.zza(zza2));
                            zzk = null;
                        } catch (Throwable th) {
                            DatabaseError fromException = DatabaseError.fromException(th);
                            doTransaction = Transaction.abort();
                            zzk = fromException;
                        }
                        if (doTransaction.isSuccess()) {
                            Long valueOf = Long.valueOf(com_google_android_gms_internal_zzbml_zza.zzcdb);
                            Map zza3 = zzbmp.zza(this.zzccf);
                            zzbpe zzUY = doTransaction.zzUY();
                            zzbpe zza4 = zzbmp.zza(zzUY, zza3);
                            com_google_android_gms_internal_zzbml_zza.zzcdd = zzUY;
                            com_google_android_gms_internal_zzbml_zza.zzcde = zza4;
                            com_google_android_gms_internal_zzbml_zza.zzcdb = zzXr();
                            arrayList2.remove(valueOf);
                            arrayList3.addAll(this.zzccs.zza(com_google_android_gms_internal_zzbml_zza.zzbXY, zzUY, zza4, com_google_android_gms_internal_zzbml_zza.zzcdb, com_google_android_gms_internal_zzbml_zza.zzccZ, false));
                            arrayList3.addAll(this.zzccs.zza(valueOf.longValue(), true, false, this.zzccf));
                            zzk = null;
                            obj = null;
                        } else {
                            obj = 1;
                            arrayList3.addAll(this.zzccs.zza(com_google_android_gms_internal_zzbml_zza.zzcdb, true, false, this.zzccf));
                        }
                    }
                    zzW(arrayList3);
                    if (obj != null) {
                        com_google_android_gms_internal_zzbml_zza.zzccX = zzb.COMPLETED;
                        DataSnapshot zza5 = com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this, com_google_android_gms_internal_zzbml_zza.zzbXY), zzboz.zzn(com_google_android_gms_internal_zzbml_zza.zzcdc));
                        zzs(new AnonymousClass10(this, com_google_android_gms_internal_zzbml_zza));
                        arrayList.add(new AnonymousClass11(this, com_google_android_gms_internal_zzbml_zza, zzk, zza5));
                    }
                } else {
                    throw new AssertionError();
                }
            }
            zzb(this.zzcci);
            for (int i = 0; i < arrayList.size(); i++) {
                zzq((Runnable) arrayList.get(i));
            }
            zzXt();
        }
    }

    private List<zza> zzc(zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza) {
        List arrayList = new ArrayList();
        zza(arrayList, (zzbnu) com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza);
        Collections.sort(arrayList);
        return arrayList;
    }

    private zzbpe zzn(zzbmj com_google_android_gms_internal_zzbmj) {
        return zza(com_google_android_gms_internal_zzbmj, new ArrayList());
    }

    private zzbmj zzo(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbnu zzp = zzp(com_google_android_gms_internal_zzbmj);
        zzbmj zzVc = zzp.zzVc();
        zzb(zzc(zzp), zzVc);
        return zzVc;
    }

    private zzbnu<List<zza>> zzp(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbnu<List<zza>> com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza = this.zzcci;
        while (!com_google_android_gms_internal_zzbmj.isEmpty() && com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.getValue() == null) {
            com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza = com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza.zzL(new zzbmj(com_google_android_gms_internal_zzbmj.zzXi()));
            com_google_android_gms_internal_zzbmj = com_google_android_gms_internal_zzbmj.zzXj();
        }
        return com_google_android_gms_internal_zzbnu_java_util_List_com_google_android_gms_internal_zzbml_zza;
    }

    public FirebaseDatabase getDatabase() {
        return this.zzcct;
    }

    void interrupt() {
        this.zzcaY.interrupt("repo_interrupt");
    }

    public void onDisconnect() {
        zza(zzbmb.zzcbJ, Boolean.valueOf(false));
        zzXs();
    }

    public void purgeOutstandingWrites() {
        if (this.zzccm.zzYT()) {
            this.zzccm.zzi("Purging writes", new Object[0]);
        }
        zzW(this.zzccs.zzXz());
        zzb(zzbmj.zzXf(), -25);
        this.zzcaY.purgeOutstandingWrites();
    }

    void resume() {
        this.zzcaY.resume("repo_interrupt");
    }

    public String toString() {
        return this.zzbXP.toString();
    }

    public void zzVP() {
        zza(zzbmb.zzcbJ, Boolean.valueOf(true));
    }

    public zzbmm zzXo() {
        return this.zzbXP;
    }

    public long zzXp() {
        return this.zzccf.zzZY();
    }

    boolean zzXq() {
        return (this.zzccr.isEmpty() && this.zzccs.isEmpty()) ? false : true;
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, CompletionListener completionListener, Map<String, Object> map) {
        if (this.zzccm.zzYT()) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder(String.valueOf(valueOf).length() + 8).append("update: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.zzcco.zzYT()) {
            com_google_android_gms_internal_zzbop = this.zzcco;
            valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            String valueOf2 = String.valueOf(map);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("update: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        if (com_google_android_gms_internal_zzbma.isEmpty()) {
            if (this.zzccm.zzYT()) {
                this.zzccm.zzi("update called with no changes. No-op", new Object[0]);
            }
            zza(completionListener, null, com_google_android_gms_internal_zzbmj);
            return;
        }
        zzbma zza = zzbmp.zza(com_google_android_gms_internal_zzbma, zzbmp.zza(this.zzccf));
        long zzXr = zzXr();
        zzW(this.zzccs.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbma, zza, zzXr, true));
        this.zzcaY.zza(com_google_android_gms_internal_zzbmj.zzXh(), (Map) map, new AnonymousClass22(this, com_google_android_gms_internal_zzbmj, zzXr, completionListener));
        zzo(zzb(com_google_android_gms_internal_zzbmj, -9));
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, CompletionListener completionListener) {
        if (this.zzccm.zzYT()) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder(String.valueOf(valueOf).length() + 5).append("set: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.zzcco.zzYT()) {
            com_google_android_gms_internal_zzbop = this.zzcco;
            valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbpe);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()).append("set: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        zzbpe zza = zzbmp.zza(com_google_android_gms_internal_zzbpe, zzbmp.zza(this.zzccf));
        long zzXr = zzXr();
        zzW(this.zzccs.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, zza, zzXr, true, true));
        this.zzcaY.zza(com_google_android_gms_internal_zzbmj.zzXh(), com_google_android_gms_internal_zzbpe.getValue(true), new AnonymousClass21(this, com_google_android_gms_internal_zzbmj, zzXr, completionListener));
        zzo(zzb(com_google_android_gms_internal_zzbmj, -9));
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, CompletionListener completionListener) {
        this.zzcaY.zza(com_google_android_gms_internal_zzbmj.zzXh(), new C12213(this, com_google_android_gms_internal_zzbmj, completionListener));
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, Handler handler, boolean z) {
        if (this.zzccm.zzYT()) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder(String.valueOf(valueOf).length() + 13).append("transaction: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.zzcco.zzYT()) {
            com_google_android_gms_internal_zzbop = this.zzccm;
            valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder(String.valueOf(valueOf).length() + 13).append("transaction: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.zzccl.zzVK() && !this.zzccu) {
            this.zzccu = true;
            this.zzccn.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference zza = com.google.firebase.database.zza.zza(this, com_google_android_gms_internal_zzbmj);
        C12235 c12235 = new C12235(this);
        zzf(new zzbmz(this, c12235, zza.zzVd()));
        zza com_google_android_gms_internal_zzbml_zza = new zza(handler, c12235, zzb.INITIALIZING, z, zzXu(), null);
        zzbpe zzn = zzn(com_google_android_gms_internal_zzbmj);
        com_google_android_gms_internal_zzbml_zza.zzcdc = zzn;
        Result result;
        DatabaseError databaseError;
        try {
            Result doTransaction = handler.doTransaction(com.google.firebase.database.zza.zza(zzn));
            if (doTransaction == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
            result = doTransaction;
            databaseError = null;
            if (result.isSuccess()) {
                com_google_android_gms_internal_zzbml_zza.zzccX = zzb.RUN;
                zzbnu zzL = this.zzcci.zzL(com_google_android_gms_internal_zzbmj);
                List list = (List) zzL.getValue();
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(com_google_android_gms_internal_zzbml_zza);
                zzL.setValue(list);
                Map zza2 = zzbmp.zza(this.zzccf);
                zzbpe zzUY = result.zzUY();
                zzbpe zza3 = zzbmp.zza(zzUY, zza2);
                com_google_android_gms_internal_zzbml_zza.zzcdd = zzUY;
                com_google_android_gms_internal_zzbml_zza.zzcde = zza3;
                com_google_android_gms_internal_zzbml_zza.zzcdb = zzXr();
                zzW(this.zzccs.zza(com_google_android_gms_internal_zzbmj, zzUY, zza3, com_google_android_gms_internal_zzbml_zza.zzcdb, z, false));
                zzXt();
                return;
            }
            com_google_android_gms_internal_zzbml_zza.zzcdd = null;
            com_google_android_gms_internal_zzbml_zza.zzcde = null;
            zzq(new C12246(this, handler, databaseError, com.google.firebase.database.zza.zza(zza, zzboz.zzn(com_google_android_gms_internal_zzbml_zza.zzcdc))));
        } catch (Throwable th) {
            DatabaseError fromException = DatabaseError.fromException(th);
            databaseError = fromException;
            result = Transaction.abort();
        }
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, Map<zzbmj, zzbpe> map, CompletionListener completionListener, Map<String, Object> map2) {
        this.zzcaY.zzb(com_google_android_gms_internal_zzbmj.zzXh(), (Map) map2, new C12202(this, com_google_android_gms_internal_zzbmj, map, completionListener));
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, boolean z) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzboe.zzVc().isEmpty() || !com_google_android_gms_internal_zzboe.zzVc().zzXi().equals(zzbmb.zzcbG)) {
            this.zzccs.zza(com_google_android_gms_internal_zzboe, z);
            return;
        }
        throw new AssertionError();
    }

    public void zza(zzbos com_google_android_gms_internal_zzbos, Object obj) {
        zzb(com_google_android_gms_internal_zzbos, obj);
    }

    void zza(CompletionListener completionListener, DatabaseError databaseError, zzbmj com_google_android_gms_internal_zzbmj) {
        if (completionListener != null) {
            zzbos zzXl = com_google_android_gms_internal_zzbmj.zzXl();
            DatabaseReference zza = (zzXl == null || !zzXl.zzZa()) ? com.google.firebase.database.zza.zza(this, com_google_android_gms_internal_zzbmj) : com.google.firebase.database.zza.zza(this, com_google_android_gms_internal_zzbmj.zzXk());
            zzq(new AnonymousClass20(this, completionListener, databaseError, zza));
        }
    }

    public void zza(List<String> list, Object obj, boolean z, Long l) {
        List zza;
        zzbmj com_google_android_gms_internal_zzbmj = new zzbmj((List) list);
        if (this.zzccm.zzYT()) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder(String.valueOf(valueOf).length() + 14).append("onDataUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.zzcco.zzYT()) {
            com_google_android_gms_internal_zzbop = this.zzccm;
            valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            String valueOf2 = String.valueOf(obj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(valueOf2).length()).append("onDataUpdate: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        this.zzccp++;
        if (l != null) {
            try {
                zzbmu com_google_android_gms_internal_zzbmu = new zzbmu(l.longValue());
                if (z) {
                    Map hashMap = new HashMap();
                    for (Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new zzbmj((String) entry.getKey()), zzbpf.zzar(entry.getValue()));
                    }
                    zza = this.zzccs.zza(com_google_android_gms_internal_zzbmj, hashMap, com_google_android_gms_internal_zzbmu);
                } else {
                    zza = this.zzccs.zza(com_google_android_gms_internal_zzbmj, zzbpf.zzar(obj), com_google_android_gms_internal_zzbmu);
                }
            } catch (DatabaseException e) {
                this.zzccm.zzd("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            Map hashMap2 = new HashMap();
            for (Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new zzbmj((String) entry2.getKey()), zzbpf.zzar(entry2.getValue()));
            }
            zza = this.zzccs.zza(com_google_android_gms_internal_zzbmj, hashMap2);
        } else {
            zza = this.zzccs.zzi(com_google_android_gms_internal_zzbmj, zzbpf.zzar(obj));
        }
        if (zza.size() > 0) {
            zzo(com_google_android_gms_internal_zzbmj);
        }
        zzW(zza);
    }

    public void zza(List<String> list, List<zzblt> list2, Long l) {
        zzbmj com_google_android_gms_internal_zzbmj = new zzbmj((List) list);
        if (this.zzccm.zzYT()) {
            zzbop com_google_android_gms_internal_zzbop = this.zzccm;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder(String.valueOf(valueOf).length() + 20).append("onRangeMergeUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.zzcco.zzYT()) {
            com_google_android_gms_internal_zzbop = this.zzccm;
            valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
            String valueOf2 = String.valueOf(list2);
            com_google_android_gms_internal_zzbop.zzi(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append("onRangeMergeUpdate: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        this.zzccp++;
        List arrayList = new ArrayList(list2.size());
        for (zzblt com_google_android_gms_internal_zzbpj : list2) {
            arrayList.add(new zzbpj(com_google_android_gms_internal_zzbpj));
        }
        List zza = l != null ? this.zzccs.zza(com_google_android_gms_internal_zzbmj, arrayList, new zzbmu(l.longValue())) : this.zzccs.zzb(com_google_android_gms_internal_zzbmj, arrayList);
        if (zza.size() > 0) {
            zzo(com_google_android_gms_internal_zzbmj);
        }
        zzW(zza);
    }

    public void zzaX(boolean z) {
        zza(zzbmb.zzcbI, Boolean.valueOf(z));
    }

    public void zzaw(Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            zzb(zzbos.zzjb((String) entry.getKey()), entry.getValue());
        }
    }

    public void zzb(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, CompletionListener completionListener) {
        this.zzcaY.zzb(com_google_android_gms_internal_zzbmj.zzXh(), com_google_android_gms_internal_zzbpe.getValue(true), new AnonymousClass23(this, com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, completionListener));
    }

    public void zze(zzbme com_google_android_gms_internal_zzbme) {
        zzW(zzbmb.zzcbG.equals(com_google_android_gms_internal_zzbme.zzWD().zzVc().zzXi()) ? this.zzccr.zzh(com_google_android_gms_internal_zzbme) : this.zzccs.zzh(com_google_android_gms_internal_zzbme));
    }

    public void zzf(zzbme com_google_android_gms_internal_zzbme) {
        zzbos zzXi = com_google_android_gms_internal_zzbme.zzWD().zzVc().zzXi();
        List zzg = (zzXi == null || !zzXi.equals(zzbmb.zzcbG)) ? this.zzccs.zzg(com_google_android_gms_internal_zzbme) : this.zzccr.zzg(com_google_android_gms_internal_zzbme);
        zzW(zzg);
    }

    public void zzq(Runnable runnable) {
        this.zzccl.zzWK();
        this.zzccl.zzWQ().zzq(runnable);
    }

    public void zzs(Runnable runnable) {
        this.zzccl.zzWK();
        this.zzccl.zzWR().zzs(runnable);
    }
}
