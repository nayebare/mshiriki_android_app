package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblr.zza;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

enum zzbmh implements zzbmk {
    INSTANCE;
    
    static ThreadFactory zzcbX;
    static final zzbmv zzcbY;

    /* renamed from: com.google.android.gms.internal.zzbmh.1 */
    class C12121 implements zzbmv {
        C12121() {
        }

        public void zza(Thread thread, String str) {
        }

        public void zza(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        public void zza(Thread thread, boolean z) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbmh.2 */
    class C12132 implements zzbpn {
        C12132(zzbmh com_google_android_gms_internal_zzbmh) {
        }

        public void zza(Thread thread, String str) {
            zzbmh.zzcbY.zza(thread, str);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbmh.3 */
    class C12143 extends zzbqa {
        final /* synthetic */ zzbop zzbYs;

        C12143(zzbmh com_google_android_gms_internal_zzbmh, zzbop com_google_android_gms_internal_zzbop) {
            this.zzbYs = com_google_android_gms_internal_zzbop;
        }

        protected ThreadFactory getThreadFactory() {
            return zzbmh.zzcbX;
        }

        protected zzbmv zzXe() {
            return zzbmh.zzcbY;
        }

        public void zzj(Throwable th) {
            this.zzbYs.zzd(zzbqa.zzl(th), th);
        }
    }

    static {
        zzcbY = new C12121();
    }

    public static boolean isActive() {
        return zzXd() != null;
    }

    private static ThreadFactory zzXd() {
        if (zzcbX == null) {
            try {
                Class cls = Class.forName("com.google.appengine.api.ThreadManager");
                if (cls != null) {
                    zzcbX = (ThreadFactory) cls.getMethod("backgroundThreadFactory", new Class[0]).invoke(null, new Object[0]);
                }
            } catch (ClassNotFoundException e) {
                return null;
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
        }
        return zzcbX;
    }

    public void initialize() {
        zzbpo.zza(zzcbX, new C12132(this));
    }

    public zzblr zza(zzbmc com_google_android_gms_internal_zzbmc, zzbln com_google_android_gms_internal_zzbln, zzblp com_google_android_gms_internal_zzblp, zza com_google_android_gms_internal_zzblr_zza) {
        return new zzbls(com_google_android_gms_internal_zzbmc.zzWO(), com_google_android_gms_internal_zzblp, com_google_android_gms_internal_zzblr_zza);
    }

    public zzbly zza(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public zzbmg zza(zzbmc com_google_android_gms_internal_zzbmc) {
        return new zzbmw(zzXd(), zzcbY);
    }

    public zzbnn zza(zzbmc com_google_android_gms_internal_zzbmc, String str) {
        return null;
    }

    public zzboq zza(zzbmc com_google_android_gms_internal_zzbmc, zzboq.zza com_google_android_gms_internal_zzboq_zza, List<String> list) {
        return new zzboo(com_google_android_gms_internal_zzboq_zza, list);
    }

    public zzbmo zzb(zzbmc com_google_android_gms_internal_zzbmc) {
        return new C12143(this, com_google_android_gms_internal_zzbmc.zziW("RunLoop"));
    }

    public String zzc(zzbmc com_google_android_gms_internal_zzbmc) {
        String str = "AppEngine";
        String property = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder((String.valueOf(property).length() + 1) + String.valueOf(str).length()).append(property).append("/").append(str).toString();
    }
}
