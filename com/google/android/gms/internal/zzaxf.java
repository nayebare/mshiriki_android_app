package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.data.DataHolder;

public class zzaxf {
    private static final String TAG;
    int[] zzbBB;
    int zzbBe;

    static {
        TAG = zzaxf.class.getSimpleName();
    }

    public zzaxf(DataHolder dataHolder, int i) {
        if (dataHolder != null && dataHolder.getStatusCode() == 0) {
            Object zzJ = zzJ(dataHolder.zzg(BuildConfig.FLAVOR, i, dataHolder.zzcC(i)));
            if (zzJ != null && zzJ.length >= 3 && zzJ[0] == 1 && zzJ[1] == 1936614772) {
                this.zzbBB = new int[zzJ.length];
                System.arraycopy(zzJ, 0, this.zzbBB, 0, zzJ.length);
                this.zzbBe = this.zzbBB[2];
            }
        }
    }

    private static long zzI(byte[] bArr) {
        return ((((((long) bArr[3]) & 255) | ((((long) bArr[2]) & 255) << 8)) | ((((long) bArr[1]) & 255) << 16)) | ((((long) bArr[0]) & 255) << 24)) & 4294967295L;
    }

    public static int[] zzJ(byte[] bArr) {
        if (bArr == null || bArr.length % 4 != 0) {
            return null;
        }
        int[] iArr = new int[(bArr.length / 4)];
        for (int i = 0; i < bArr.length; i += 4) {
            iArr[i / 4] = (int) (((((((long) bArr[i + 3]) & 255) | ((((long) bArr[i + 2]) & 255) << 8)) | ((((long) bArr[i + 1]) & 255) << 16)) | ((((long) bArr[i]) & 255) << 24)) & 4294967295L);
        }
        return iArr;
    }

    private static int zza(int[] iArr, long j) {
        int i = 3;
        int length = iArr.length - 1;
        while (i <= length) {
            int i2 = ((length - i) / 2) + i;
            long zzau = zzau((long) iArr[i2]);
            if (zzau == j) {
                return i2;
            }
            if (zzau < j) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return -1;
    }

    private static long zzau(long j) {
        return 4294967295L & j;
    }

    public int getThreatType() {
        return this.zzbBe;
    }

    public boolean zzH(byte[] bArr) {
        if (this.zzbBB == null) {
            return false;
        }
        return zza(this.zzbBB, zzI(bArr)) != -1;
    }
}
