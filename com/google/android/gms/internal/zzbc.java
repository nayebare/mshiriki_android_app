package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzaf.zza;
import com.google.android.gms.internal.zzaf.zzd;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzbc {
    private static final String TAG;
    protected static final Object zzqC;
    protected static final Object zzqG;
    private static zzc zzqI;
    private volatile boolean zzpX;
    private Future zzqA;
    private volatile boolean zzqB;
    private zzap zzqD;
    private GoogleApiClient zzqE;
    protected boolean zzqF;
    protected boolean zzqH;
    protected boolean zzqJ;
    private Map<Pair<String, String>, zzbx> zzqK;
    protected Context zzqr;
    protected Context zzqs;
    private ExecutorService zzqt;
    private DexClassLoader zzqu;
    private zzax zzqv;
    private byte[] zzqw;
    private volatile AdvertisingIdClient zzqx;
    private Future zzqy;
    private volatile zza zzqz;

    /* renamed from: com.google.android.gms.internal.zzbc.1 */
    class C11421 implements Runnable {
        final /* synthetic */ zzbc zzqL;

        C11421(zzbc com_google_android_gms_internal_zzbc) {
            this.zzqL = com_google_android_gms_internal_zzbc;
        }

        public void run() {
            this.zzqL.zzaU();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbc.2 */
    class C11432 implements Runnable {
        final /* synthetic */ zzbc zzqL;

        C11432(zzbc com_google_android_gms_internal_zzbc) {
            this.zzqL = com_google_android_gms_internal_zzbc;
        }

        public void run() {
            this.zzqL.zzaX();
            synchronized (zzbc.zzqC) {
                this.zzqL.zzqB = false;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbc.3 */
    class C11443 implements Runnable {
        final /* synthetic */ zzbc zzqL;

        C11443(zzbc com_google_android_gms_internal_zzbc) {
            this.zzqL = com_google_android_gms_internal_zzbc;
        }

        public void run() {
            zzfx.initialize(this.zzqL.zzqr);
        }
    }

    static {
        TAG = zzbc.class.getSimpleName();
        zzqC = new Object();
        zzqG = new Object();
        zzqI = null;
    }

    private zzbc(Context context) {
        this.zzqx = null;
        this.zzpX = false;
        this.zzqy = null;
        this.zzqz = null;
        this.zzqA = null;
        this.zzqB = false;
        this.zzqE = null;
        this.zzqF = false;
        this.zzqH = false;
        this.zzqJ = false;
        this.zzqr = context;
        this.zzqs = context.getApplicationContext();
        this.zzqK = new HashMap();
    }

    public static zzbc zza(Context context, String str, String str2, boolean z) {
        zzbc com_google_android_gms_internal_zzbc = new zzbc(context);
        try {
            com_google_android_gms_internal_zzbc.zzc(str, str2, z);
            return com_google_android_gms_internal_zzbc;
        } catch (zzaz e) {
            return null;
        }
    }

    @NonNull
    private File zza(String str, File file, String str2) throws zzax.zza, IOException {
        File file2 = new File(String.format("%s/%s.jar", new Object[]{file, str2}));
        if (!file2.exists()) {
            byte[] zzc = this.zzqv.zzc(this.zzqw, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
        }
        return file2;
    }

    private void zza(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    private void zza(File file, String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
            if (file3.exists()) {
                long length = file3.length();
                if (length > 0) {
                    byte[] bArr = new byte[((int) length)];
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            if (fileInputStream.read(bArr) <= 0) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                                zza(file3);
                                return;
                            }
                            zzd com_google_android_gms_internal_zzaf_zzd = new zzd();
                            com_google_android_gms_internal_zzaf_zzd.zzcw = VERSION.SDK.getBytes();
                            com_google_android_gms_internal_zzaf_zzd.zzcv = str.getBytes();
                            bArr = this.zzqv.zzd(this.zzqw, bArr).getBytes();
                            com_google_android_gms_internal_zzaf_zzd.data = bArr;
                            com_google_android_gms_internal_zzaf_zzd.zzcu = zzan.zzh(bArr);
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] zzf = zzbut.zzf(com_google_android_gms_internal_zzaf_zzd);
                                fileOutputStream.write(zzf, 0, zzf.length);
                                fileOutputStream.close();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                }
                                zza(file3);
                            } catch (IOException e4) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                zza(file3);
                            } catch (NoSuchAlgorithmException e7) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                zza(file3);
                            } catch (zzax.zza e8) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                zza(file3);
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileOutputStream2 = fileOutputStream;
                                th = th3;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                zza(file3);
                                throw th;
                            }
                        } catch (IOException e11) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            zza(file3);
                        } catch (NoSuchAlgorithmException e12) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            zza(file3);
                        } catch (zzax.zza e13) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            zza(file3);
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            zza(file3);
                            throw th;
                        }
                    } catch (IOException e14) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        zza(file3);
                    } catch (NoSuchAlgorithmException e15) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        zza(file3);
                    } catch (zzax.zza e16) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        zza(file3);
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        zza(file3);
                        throw th;
                    }
                }
            }
        }
    }

    private void zzaU() {
        try {
            if (this.zzqx == null && this.zzqs != null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzqs);
                advertisingIdClient.start();
                this.zzqx = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            this.zzqx = null;
        } catch (IOException e2) {
            this.zzqx = null;
        } catch (GooglePlayServicesRepairableException e3) {
            this.zzqx = null;
        }
    }

    private void zzaV() {
        if (((Boolean) zzfx.zzDD.get()).booleanValue()) {
            zzaW();
        }
    }

    private void zzaX() {
        if (this.zzqH) {
            try {
                this.zzqz = zzapt.zzi(this.zzqr, this.zzqr.getPackageName(), Integer.toString(this.zzqr.getPackageManager().getPackageInfo(this.zzqr.getPackageName(), 0).versionCode));
            } catch (NameNotFoundException e) {
            }
        }
    }

    private void zzaY() {
        boolean z = true;
        this.zzqt.execute(new C11443(this));
        zzqI = zzc.zzuz();
        this.zzqF = zzqI.zzak(this.zzqr) > 0;
        if (zzqI.isGooglePlayServicesAvailable(this.zzqr) != 0) {
            z = false;
        }
        this.zzqH = z;
        if (this.zzqr.getApplicationContext() != null) {
            this.zzqE = new Builder(this.zzqr).addApi(zzzf.API).build();
        }
    }

    private boolean zzb(File file, String str) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
        if (file3.exists()) {
            return false;
        }
        FileInputStream fileInputStream2;
        try {
            long length = file2.length();
            if (length <= 0) {
                zza(file2);
                return false;
            }
            byte[] bArr = new byte[((int) length)];
            fileInputStream2 = new FileInputStream(file2);
            try {
                if (fileInputStream2.read(bArr) <= 0) {
                    Log.d(TAG, "Cannot read the cache data.");
                    zza(file2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                    return false;
                }
                zzd zze = zzd.zze(bArr);
                if (str.equals(new String(zze.zzcv)) && Arrays.equals(zze.zzcu, zzan.zzh(zze.data)) && Arrays.equals(zze.zzcw, VERSION.SDK.getBytes())) {
                    bArr = this.zzqv.zzc(this.zzqw, new String(zze.data));
                    file3.createNewFile();
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                    try {
                        fileOutputStream3.write(bArr, 0, bArr.length);
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileOutputStream3.close();
                            return true;
                        } catch (IOException e3) {
                            return true;
                        }
                    } catch (IOException e4) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        return false;
                    } catch (NoSuchAlgorithmException e7) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (zzax.zza e8) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                }
                zza(file2);
                try {
                    fileInputStream2.close();
                } catch (IOException e11) {
                }
                return false;
            } catch (IOException e12) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (NoSuchAlgorithmException e13) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (zzax.zza e14) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (IOException e15) {
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (NoSuchAlgorithmException e16) {
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (zzax.zza e17) {
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    private void zzc(boolean z) {
        this.zzpX = z;
        if (z) {
            this.zzqy = this.zzqt.submit(new C11421(this));
        }
    }

    private boolean zzc(String str, String str2, boolean z) throws zzaz {
        this.zzqt = Executors.newCachedThreadPool();
        zzc(z);
        zzaY();
        zzaV();
        if (zzbe.zzbd() && ((Boolean) zzfx.zzDB.get()).booleanValue()) {
            throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
        }
        zzo(str);
        zzp(str2);
        this.zzqD = new zzap(this);
        return true;
    }

    private void zzo(String str) throws zzaz {
        this.zzqv = new zzax(null);
        try {
            this.zzqw = this.zzqv.zzn(str);
        } catch (Throwable e) {
            throw new zzaz(e);
        }
    }

    private boolean zzp(String str) throws zzaz {
        File file;
        String zzX;
        File zza;
        try {
            File cacheDir = this.zzqr.getCacheDir();
            if (cacheDir == null) {
                cacheDir = this.zzqr.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new zzaz();
                }
            }
            file = cacheDir;
            zzX = zzay.zzX();
            zza = zza(str, file, zzX);
            zzb(file, zzX);
            this.zzqu = new DexClassLoader(zza.getAbsolutePath(), file.getAbsolutePath(), null, this.zzqr.getClassLoader());
            zza(zza);
            zza(file, zzX);
            zzq(String.format("%s/%s.dex", new Object[]{file, zzX}));
            return true;
        } catch (Throwable e) {
            throw new zzaz(e);
        } catch (Throwable e2) {
            throw new zzaz(e2);
        } catch (Throwable e22) {
            throw new zzaz(e22);
        } catch (Throwable e222) {
            throw new zzaz(e222);
        } catch (Throwable th) {
            zza(zza);
            zza(file, zzX);
            zzq(String.format("%s/%s.dex", new Object[]{file, zzX}));
        }
    }

    private void zzq(String str) {
        zza(new File(str));
    }

    public Context getApplicationContext() {
        return this.zzqs;
    }

    public Context getContext() {
        return this.zzqr;
    }

    public int zzT() {
        zzap zzaQ = zzaQ();
        return zzaQ != null ? zzaQ.zzT() : Target.SIZE_ORIGINAL;
    }

    public boolean zza(String str, String str2, List<Class> list) {
        if (this.zzqK.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzqK.put(new Pair(str, str2), new zzbx(this, str, str2, list));
        return true;
    }

    public ExecutorService zzaJ() {
        return this.zzqt;
    }

    public DexClassLoader zzaK() {
        return this.zzqu;
    }

    public zzax zzaL() {
        return this.zzqv;
    }

    public byte[] zzaM() {
        return this.zzqw;
    }

    public GoogleApiClient zzaN() {
        return this.zzqE;
    }

    public boolean zzaO() {
        return this.zzqF;
    }

    public boolean zzaP() {
        return this.zzqJ;
    }

    public zzap zzaQ() {
        return this.zzqD;
    }

    public boolean zzaR() {
        return this.zzqH;
    }

    public zza zzaS() {
        return this.zzqz;
    }

    public Future zzaT() {
        return this.zzqA;
    }

    public void zzaW() {
        synchronized (zzqC) {
            if (!this.zzqB) {
                this.zzqA = this.zzqt.submit(new C11432(this));
                this.zzqB = true;
            }
        }
    }

    public AdvertisingIdClient zzaZ() {
        if (!this.zzpX) {
            return null;
        }
        if (this.zzqx != null) {
            return this.zzqx;
        }
        if (this.zzqy != null) {
            try {
                this.zzqy.get(2000, TimeUnit.MILLISECONDS);
                this.zzqy = null;
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
                this.zzqy.cancel(true);
            }
        }
        return this.zzqx;
    }

    public void zzba() {
        synchronized (zzqG) {
            if (this.zzqJ) {
                return;
            }
            if (!this.zzqH || this.zzqE == null) {
                this.zzqJ = false;
            } else {
                this.zzqE.connect();
                this.zzqJ = true;
            }
        }
    }

    public void zzbb() {
        synchronized (zzqG) {
            if (this.zzqJ && this.zzqE != null) {
                this.zzqE.disconnect();
                this.zzqJ = false;
            }
        }
    }

    public Method zzc(String str, String str2) {
        zzbx com_google_android_gms_internal_zzbx = (zzbx) this.zzqK.get(new Pair(str, str2));
        return com_google_android_gms_internal_zzbx == null ? null : com_google_android_gms_internal_zzbx.zzbn();
    }
}
