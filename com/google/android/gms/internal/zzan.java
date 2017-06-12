package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.internal.zzaf.zzc;
import com.google.android.gms.internal.zzaf.zzf;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

final class zzan {
    static boolean zzlI;
    private static MessageDigest zzlJ;
    private static final Object zzlK;
    private static final Object zzlL;
    static CountDownLatch zzlM;

    private static final class zza implements Runnable {
        private zza() {
        }

        public void run() {
            try {
                zzan.zzlJ = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                zzan.zzlM.countDown();
            }
        }
    }

    static {
        zzlI = false;
        zzlJ = null;
        zzlK = new Object();
        zzlL = new Object();
        zzlM = new CountDownLatch(1);
    }

    static void zzR() {
        synchronized (zzlL) {
            if (!zzlI) {
                zzlI = true;
                new Thread(new zza()).start();
            }
        }
    }

    static MessageDigest zzS() {
        zzR();
        boolean z = false;
        try {
            z = zzlM.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return (z && zzlJ != null) ? zzlJ : null;
    }

    private static int zza(boolean z) {
        return z ? 239 : MotionEventCompat.ACTION_MASK;
    }

    static String zza(com.google.android.gms.internal.zzaf.zza com_google_android_gms_internal_zzaf_zza, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zza(zzbut.zzf(com_google_android_gms_internal_zzaf_zza), str, z);
    }

    static String zza(String str, String str2, boolean z) {
        byte[] zzb = zzb(str, str2, z);
        return zzb != null ? zzal.zza(zzb, true) : Integer.toString(7);
    }

    static String zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zzal.zza(z ? zzb(bArr, str) : zza(bArr, str), true);
    }

    static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void zza(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzbtm(str.getBytes(HTTP.UTF_8)).zzY(bArr);
    }

    static byte[] zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector zza = zza(bArr, (int) MotionEventCompat.ACTION_MASK);
        if (zza == null || zza.size() == 0) {
            return zzb(zzbut.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str);
        }
        zzf com_google_android_gms_internal_zzaf_zzf = new zzf();
        com_google_android_gms_internal_zzaf_zzf.zzcz = new byte[zza.size()][];
        Iterator it = zza.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            com_google_android_gms_internal_zzaf_zzf.zzcz[i] = zzb((byte[]) it.next(), str, false);
            i = i2;
        }
        com_google_android_gms_internal_zzaf_zzf.zzcu = zzh(bArr);
        return zzbut.zzf(com_google_android_gms_internal_zzaf_zzf);
    }

    static com.google.android.gms.internal.zzaf.zza zzb(long j) {
        com.google.android.gms.internal.zzaf.zza com_google_android_gms_internal_zzaf_zza = new com.google.android.gms.internal.zzaf.zza();
        com_google_android_gms_internal_zzaf_zza.zzbs = Long.valueOf(j);
        return com_google_android_gms_internal_zzaf_zza;
    }

    static byte[] zzb(String str, String str2, boolean z) {
        zzc com_google_android_gms_internal_zzaf_zzc = new zzc();
        try {
            com_google_android_gms_internal_zzaf_zzc.zzcs = str.length() < 3 ? str.getBytes(HTTP.ISO_8859_1) : zzal.zza(str, true);
            byte[] bytes = z ? str2.length() < 3 ? str2.getBytes(HTTP.ISO_8859_1) : zzal.zza(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes(HTTP.ISO_8859_1) : zzal.zza(zza(str2.getBytes(HTTP.ISO_8859_1), null, ((Boolean) zzfx.zzDi.get()).booleanValue()), true);
            com_google_android_gms_internal_zzaf_zzc.zzct = bytes;
            return zzbut.zzf(com_google_android_gms_internal_zzaf_zzc);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    static byte[] zzb(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zzb(bArr, str, true);
    }

    private static byte[] zzb(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        byte[] array;
        int zza = zza(z);
        if (bArr.length > zza) {
            bArr = zzbut.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < zza) {
            bArr2 = new byte[(zza - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(zza + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(zza + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED).put(zzh(array)).put(array).array();
        }
        bArr2 = new byte[FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED];
        new zzao().zzb(array, bArr2);
        if (str != null && str.length() > 0) {
            zza(str, bArr2);
        }
        return bArr2;
    }

    public static byte[] zzh(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzlK) {
            MessageDigest zzS = zzS();
            if (zzS == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzS.reset();
            zzS.update(bArr);
            digest = zzlJ.digest();
        }
        return digest;
    }
}
