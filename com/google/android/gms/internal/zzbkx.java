package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.internal.zzblr.zza;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.zzb;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.idl.zzc;
import com.google.firebase.database.connection.idl.zze;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class zzbkx implements zzbmk {
    private final FirebaseApp zzbYm;
    private final Set<String> zzbYr;
    private final Context zzqs;

    /* renamed from: com.google.android.gms.internal.zzbkx.1 */
    class C11831 extends zzbqa {
        final /* synthetic */ zzbop zzbYs;
        final /* synthetic */ zzbkx zzbYt;

        /* renamed from: com.google.android.gms.internal.zzbkx.1.1 */
        class C11821 implements Runnable {
            final /* synthetic */ String zzIg;
            final /* synthetic */ Throwable zzbYu;

            C11821(C11831 c11831, String str, Throwable th) {
                this.zzIg = str;
                this.zzbYu = th;
            }

            public void run() {
                throw new RuntimeException(this.zzIg, this.zzbYu);
            }
        }

        C11831(zzbkx com_google_android_gms_internal_zzbkx, zzbop com_google_android_gms_internal_zzbop) {
            this.zzbYt = com_google_android_gms_internal_zzbkx;
            this.zzbYs = com_google_android_gms_internal_zzbop;
        }

        public void zzj(Throwable th) {
            String zzl = zzbqa.zzl(th);
            this.zzbYs.zzd(zzl, th);
            new Handler(this.zzbYt.zzqs.getMainLooper()).post(new C11821(this, zzl, th));
            zzVJ().shutdownNow();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbkx.2 */
    class C11842 implements zzb {
        final /* synthetic */ zzblr zzbYv;

        C11842(zzbkx com_google_android_gms_internal_zzbkx, zzblr com_google_android_gms_internal_zzblr) {
            this.zzbYv = com_google_android_gms_internal_zzblr;
        }

        public void zzaQ(boolean z) {
            if (z) {
                this.zzbYv.interrupt("app_in_background");
            } else {
                this.zzbYv.resume("app_in_background");
            }
        }
    }

    public zzbkx(FirebaseApp firebaseApp) {
        this.zzbYr = new HashSet();
        this.zzbYm = firebaseApp;
        if (this.zzbYm == null) {
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        }
        this.zzqs = this.zzbYm.getApplicationContext();
    }

    public zzblr zza(zzbmc com_google_android_gms_internal_zzbmc, zzbln com_google_android_gms_internal_zzbln, zzblp com_google_android_gms_internal_zzblp, zza com_google_android_gms_internal_zzblr_zza) {
        zze zza = zze.zza(this.zzqs, new zzc(com_google_android_gms_internal_zzblp, com_google_android_gms_internal_zzbmc.zzWu(), null, com_google_android_gms_internal_zzbmc.zzVK(), FirebaseDatabase.getSdkVersion(), com_google_android_gms_internal_zzbmc.zzjQ()), com_google_android_gms_internal_zzbln, com_google_android_gms_internal_zzblr_zza);
        this.zzbYm.zza(new C11842(this, zza));
        return zza;
    }

    public zzbly zza(ScheduledExecutorService scheduledExecutorService) {
        return new zzbkv(this.zzbYm, scheduledExecutorService);
    }

    public zzbmg zza(zzbmc com_google_android_gms_internal_zzbmc) {
        return new zzbkw();
    }

    public zzbnn zza(zzbmc com_google_android_gms_internal_zzbmc, String str) {
        String zzWS = com_google_android_gms_internal_zzbmc.zzWS();
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(zzWS).length()).append(str).append("_").append(zzWS).toString();
        if (this.zzbYr.contains(stringBuilder)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(zzWS).length() + 47).append("SessionPersistenceKey '").append(zzWS).append("' has already been used.").toString());
        }
        this.zzbYr.add(stringBuilder);
        return new zzbnk(com_google_android_gms_internal_zzbmc, new zzbky(this.zzqs, com_google_android_gms_internal_zzbmc, stringBuilder), new zzbnl(com_google_android_gms_internal_zzbmc.zzWP()));
    }

    public zzboq zza(zzbmc com_google_android_gms_internal_zzbmc, zzboq.zza com_google_android_gms_internal_zzboq_zza, List<String> list) {
        return new zzbon(com_google_android_gms_internal_zzboq_zza, list);
    }

    public zzbmo zzb(zzbmc com_google_android_gms_internal_zzbmc) {
        return new C11831(this, com_google_android_gms_internal_zzbmc.zziW("RunLoop"));
    }

    public String zzc(zzbmc com_google_android_gms_internal_zzbmc) {
        return VERSION.SDK_INT + "/Android";
    }
}
