package com.google.android.gms.internal;

import java.util.Random;

public class zzbqf {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int[] zzciA;
    private static final Random zzciy;
    private static long zzciz;

    static {
        $assertionsDisabled = !zzbqf.class.desiredAssertionStatus();
        zzciy = new Random();
        zzciz = 0;
        zzciA = new int[12];
    }

    public static synchronized String zzaQ(long j) {
        String stringBuilder;
        int i = 0;
        synchronized (zzbqf.class) {
            int i2;
            int i3 = j == zzciz ? 1 : 0;
            zzciz = j;
            char[] cArr = new char[8];
            StringBuilder stringBuilder2 = new StringBuilder(20);
            for (i2 = 7; i2 >= 0; i2--) {
                cArr[i2] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt((int) (j % 64));
                j /= 64;
            }
            if ($assertionsDisabled || j == 0) {
                stringBuilder2.append(cArr);
                if (i3 == 0) {
                    for (i2 = 0; i2 < 12; i2++) {
                        zzciA[i2] = zzciy.nextInt(64);
                    }
                } else {
                    zzaaa();
                }
                while (i < 12) {
                    stringBuilder2.append("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(zzciA[i]));
                    i++;
                }
                if ($assertionsDisabled || stringBuilder2.length() == 20) {
                    stringBuilder = stringBuilder2.toString();
                } else {
                    throw new AssertionError();
                }
            }
            throw new AssertionError();
        }
        return stringBuilder;
    }

    private static void zzaaa() {
        int i = 11;
        while (i >= 0) {
            if (zzciA[i] != 63) {
                zzciA[i] = zzciA[i] + 1;
                return;
            } else {
                zzciA[i] = 0;
                i--;
            }
        }
    }
}
