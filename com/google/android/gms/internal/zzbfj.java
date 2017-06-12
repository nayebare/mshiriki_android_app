package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzbfj {
    private final Context mContext;
    private final ExecutorService zzbFy;
    private final zza zzbKn;

    interface zza {
        InputStream open(String str) throws IOException;
    }

    /* renamed from: com.google.android.gms.internal.zzbfj.1 */
    class C11471 implements zza {
        final /* synthetic */ Context zztd;

        C11471(Context context) {
            this.zztd = context;
        }

        public InputStream open(String str) throws IOException {
            return this.zztd.getAssets().open(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbfj.2 */
    class C11482 implements Runnable {
        final /* synthetic */ String zzbKo;
        final /* synthetic */ zzbfd zzbKp;
        final /* synthetic */ zzbfj zzbKq;

        C11482(zzbfj com_google_android_gms_internal_zzbfj, String str, zzbfd com_google_android_gms_internal_zzbfd) {
            this.zzbKq = com_google_android_gms_internal_zzbfj;
            this.zzbKo = str;
            this.zzbKp = com_google_android_gms_internal_zzbfd;
        }

        public void run() {
            this.zzbKq.zzb(this.zzbKo, this.zzbKp);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbfj.3 */
    class C11493 implements Runnable {
        final /* synthetic */ String zzbKo;
        final /* synthetic */ zzbfd zzbKp;
        final /* synthetic */ zzbfj zzbKq;
        final /* synthetic */ String zzbKr;

        C11493(zzbfj com_google_android_gms_internal_zzbfj, String str, String str2, zzbfd com_google_android_gms_internal_zzbfd) {
            this.zzbKq = com_google_android_gms_internal_zzbfj;
            this.zzbKo = str;
            this.zzbKr = str2;
            this.zzbKp = com_google_android_gms_internal_zzbfd;
        }

        public void run() {
            this.zzbKq.zzb(this.zzbKo, this.zzbKr, this.zzbKp);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbfj.4 */
    class C11504 implements Runnable {
        final /* synthetic */ String zzbKo;
        final /* synthetic */ zzbfj zzbKq;
        final /* synthetic */ byte[] zzbKs;

        C11504(zzbfj com_google_android_gms_internal_zzbfj, String str, byte[] bArr) {
            this.zzbKq = com_google_android_gms_internal_zzbfj;
            this.zzbKo = str;
            this.zzbKs = bArr;
        }

        public void run() {
            this.zzbKq.zzh(this.zzbKo, this.zzbKs);
        }
    }

    public zzbfj(Context context) {
        this(context, Executors.newSingleThreadExecutor(), new C11471(context));
    }

    zzbfj(Context context, ExecutorService executorService, zza com_google_android_gms_internal_zzbfj_zza) {
        this.mContext = context;
        this.zzbFy = executorService;
        this.zzbKn = com_google_android_gms_internal_zzbfj_zza;
    }

    private String zzhZ(String str) {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private byte[] zzm(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzo.zza(inputStream, byteArrayOutputStream);
        } catch (IOException e) {
            zzayx.zzbe("Failed to read the resource from disk");
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                zzayx.zzbe("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void zza(String str, zzbfd com_google_android_gms_internal_zzbfd) {
        this.zzbFy.execute(new C11482(this, str, com_google_android_gms_internal_zzbfd));
    }

    public void zza(String str, String str2, zzbfd com_google_android_gms_internal_zzbfd) {
        this.zzbFy.execute(new C11493(this, str, str2, com_google_android_gms_internal_zzbfd));
    }

    void zzb(String str, zzbfd com_google_android_gms_internal_zzbfd) {
        zzayx.m24v("Starting to load a saved resource file from Disk.");
        try {
            com_google_android_gms_internal_zzbfd.zzM(zzm(new FileInputStream(zzhY(str))));
        } catch (FileNotFoundException e) {
            String str2 = "Saved resource not found: ";
            String valueOf = String.valueOf(zzhZ(str));
            zzayx.m23e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            com_google_android_gms_internal_zzbfd.zzw(0, 1);
        }
    }

    void zzb(String str, String str2, zzbfd com_google_android_gms_internal_zzbfd) {
        zzayx.m24v("Starting to load a default asset file from Disk.");
        if (str2 == null) {
            zzayx.m24v("Default asset file is not specified. Not proceeding with the loading");
            com_google_android_gms_internal_zzbfd.zzw(0, 2);
            return;
        }
        try {
            InputStream open = this.zzbKn.open(str2);
            if (open != null) {
                com_google_android_gms_internal_zzbfd.zzM(zzm(open));
            } else {
                com_google_android_gms_internal_zzbfd.zzw(0, 2);
            }
        } catch (IOException e) {
            zzayx.m23e(new StringBuilder((String.valueOf(str).length() + 42) + String.valueOf(str2).length()).append("Default asset file not found. ").append(str).append(". Filename: ").append(str2).toString());
            com_google_android_gms_internal_zzbfd.zzw(0, 2);
        }
    }

    public void zzg(String str, byte[] bArr) {
        this.zzbFy.execute(new C11504(this, str, bArr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zzh(java.lang.String r4, byte[] r5) {
        /*
        r3 = this;
        r0 = r3.zzhY(r4);
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0036 }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0036 }
        r1.write(r5);	 Catch:{ IOException -> 0x0044 }
        r1.close();	 Catch:{ IOException -> 0x003d }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003d }
        r1 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x003d }
        r1 = r1.length();	 Catch:{ IOException -> 0x003d }
        r1 = r1 + 24;
        r0.<init>(r1);	 Catch:{ IOException -> 0x003d }
        r1 = "Resource ";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x003d }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x003d }
        r1 = " saved on Disk.";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x003d }
        r0 = r0.toString();	 Catch:{ IOException -> 0x003d }
        com.google.android.gms.internal.zzayx.m24v(r0);	 Catch:{ IOException -> 0x003d }
    L_0x0035:
        return;
    L_0x0036:
        r0 = move-exception;
        r0 = "Error opening resource file for writing";
        com.google.android.gms.internal.zzayx.m23e(r0);
        goto L_0x0035;
    L_0x003d:
        r0 = move-exception;
        r0 = "Error closing stream for writing resource to disk";
        com.google.android.gms.internal.zzayx.m23e(r0);
        goto L_0x0035;
    L_0x0044:
        r2 = move-exception;
        r2 = "Error writing resource to disk. Removing resource from disk";
        com.google.android.gms.internal.zzayx.m23e(r2);	 Catch:{ all -> 0x007e }
        r0.delete();	 Catch:{ all -> 0x007e }
        r1.close();	 Catch:{ IOException -> 0x0077 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0077 }
        r1 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x0077 }
        r1 = r1.length();	 Catch:{ IOException -> 0x0077 }
        r1 = r1 + 24;
        r0.<init>(r1);	 Catch:{ IOException -> 0x0077 }
        r1 = "Resource ";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0077 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x0077 }
        r1 = " saved on Disk.";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0077 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0077 }
        com.google.android.gms.internal.zzayx.m24v(r0);	 Catch:{ IOException -> 0x0077 }
        goto L_0x0035;
    L_0x0077:
        r0 = move-exception;
        r0 = "Error closing stream for writing resource to disk";
        com.google.android.gms.internal.zzayx.m23e(r0);
        goto L_0x0035;
    L_0x007e:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00a9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a9 }
        r2 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x00a9 }
        r2 = r2.length();	 Catch:{ IOException -> 0x00a9 }
        r2 = r2 + 24;
        r1.<init>(r2);	 Catch:{ IOException -> 0x00a9 }
        r2 = "Resource ";
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x00a9 }
        r1 = r1.append(r4);	 Catch:{ IOException -> 0x00a9 }
        r2 = " saved on Disk.";
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x00a9 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x00a9 }
        com.google.android.gms.internal.zzayx.m24v(r1);	 Catch:{ IOException -> 0x00a9 }
    L_0x00a8:
        throw r0;
    L_0x00a9:
        r1 = move-exception;
        r1 = "Error closing stream for writing resource to disk";
        com.google.android.gms.internal.zzayx.m23e(r1);
        goto L_0x00a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbfj.zzh(java.lang.String, byte[]):void");
    }

    public long zzhX(String str) {
        File zzhY = zzhY(str);
        return zzhY.exists() ? zzhY.lastModified() : 0;
    }

    File zzhY(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzhZ(str));
    }
}
