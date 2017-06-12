package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

public class zzbmn {
    private static final zzbmn zzcdn;
    private final Map<zzbmc, Map<String, zzbml>> zzcdo;

    /* renamed from: com.google.android.gms.internal.zzbmn.1 */
    class C12291 implements Runnable {
        final /* synthetic */ zzbml zzccE;

        C12291(zzbml com_google_android_gms_internal_zzbml) {
            this.zzccE = com_google_android_gms_internal_zzbml;
        }

        public void run() {
            this.zzccE.interrupt();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbmn.2 */
    class C12302 implements Runnable {
        final /* synthetic */ zzbml zzccE;

        C12302(zzbml com_google_android_gms_internal_zzbml) {
            this.zzccE = com_google_android_gms_internal_zzbml;
        }

        public void run() {
            this.zzccE.resume();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbmn.3 */
    class C12313 implements Runnable {
        final /* synthetic */ zzbmc zzcdp;
        final /* synthetic */ zzbmn zzcdq;

        C12313(zzbmn com_google_android_gms_internal_zzbmn, zzbmc com_google_android_gms_internal_zzbmc) {
            this.zzcdq = com_google_android_gms_internal_zzbmn;
            this.zzcdp = com_google_android_gms_internal_zzbmc;
        }

        public void run() {
            synchronized (this.zzcdq.zzcdo) {
                if (this.zzcdq.zzcdo.containsKey(this.zzcdp)) {
                    Object obj = 1;
                    for (zzbml com_google_android_gms_internal_zzbml : ((Map) this.zzcdq.zzcdo.get(this.zzcdp)).values()) {
                        com_google_android_gms_internal_zzbml.interrupt();
                        Object obj2 = (obj == null || com_google_android_gms_internal_zzbml.zzXq()) ? null : 1;
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.zzcdp.stop();
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbmn.4 */
    class C12324 implements Runnable {
        final /* synthetic */ zzbmc zzcdp;
        final /* synthetic */ zzbmn zzcdq;

        C12324(zzbmn com_google_android_gms_internal_zzbmn, zzbmc com_google_android_gms_internal_zzbmc) {
            this.zzcdq = com_google_android_gms_internal_zzbmn;
            this.zzcdp = com_google_android_gms_internal_zzbmc;
        }

        public void run() {
            synchronized (this.zzcdq.zzcdo) {
                if (this.zzcdq.zzcdo.containsKey(this.zzcdp)) {
                    for (zzbml resume : ((Map) this.zzcdq.zzcdo.get(this.zzcdp)).values()) {
                        resume.resume();
                    }
                }
            }
        }
    }

    static {
        zzcdn = new zzbmn();
    }

    public zzbmn() {
        this.zzcdo = new HashMap();
    }

    public static zzbml zza(zzbmc com_google_android_gms_internal_zzbmc, zzbmm com_google_android_gms_internal_zzbmm, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return zzcdn.zzb(com_google_android_gms_internal_zzbmc, com_google_android_gms_internal_zzbmm, firebaseDatabase);
    }

    private zzbml zzb(zzbmc com_google_android_gms_internal_zzbmc, zzbmm com_google_android_gms_internal_zzbmm, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        zzbml com_google_android_gms_internal_zzbml;
        com_google_android_gms_internal_zzbmc.zzWz();
        String str = com_google_android_gms_internal_zzbmm.zzbZA;
        String str2 = com_google_android_gms_internal_zzbmm.zzaFs;
        str2 = new StringBuilder((String.valueOf(str).length() + 9) + String.valueOf(str2).length()).append("https://").append(str).append("/").append(str2).toString();
        synchronized (this.zzcdo) {
            if (!this.zzcdo.containsKey(com_google_android_gms_internal_zzbmc)) {
                this.zzcdo.put(com_google_android_gms_internal_zzbmc, new HashMap());
            }
            Map map = (Map) this.zzcdo.get(com_google_android_gms_internal_zzbmc);
            if (map.containsKey(str2)) {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
            com_google_android_gms_internal_zzbml = new zzbml(com_google_android_gms_internal_zzbmm, com_google_android_gms_internal_zzbmc, firebaseDatabase);
            map.put(str2, com_google_android_gms_internal_zzbml);
        }
        return com_google_android_gms_internal_zzbml;
    }

    public static void zzd(zzbmc com_google_android_gms_internal_zzbmc) {
        zzcdn.zzf(com_google_android_gms_internal_zzbmc);
    }

    public static void zze(zzbmc com_google_android_gms_internal_zzbmc) {
        zzcdn.zzg(com_google_android_gms_internal_zzbmc);
    }

    private void zzf(zzbmc com_google_android_gms_internal_zzbmc) {
        zzbmo zzWR = com_google_android_gms_internal_zzbmc.zzWR();
        if (zzWR != null) {
            zzWR.zzs(new C12313(this, com_google_android_gms_internal_zzbmc));
        }
    }

    private void zzg(zzbmc com_google_android_gms_internal_zzbmc) {
        zzbmo zzWR = com_google_android_gms_internal_zzbmc.zzWR();
        if (zzWR != null) {
            zzWR.zzs(new C12324(this, com_google_android_gms_internal_zzbmc));
        }
    }

    public static void zzk(zzbml com_google_android_gms_internal_zzbml) {
        com_google_android_gms_internal_zzbml.zzs(new C12291(com_google_android_gms_internal_zzbml));
    }

    public static void zzl(zzbml com_google_android_gms_internal_zzbml) {
        com_google_android_gms_internal_zzbml.zzs(new C12302(com_google_android_gms_internal_zzbml));
    }
}
