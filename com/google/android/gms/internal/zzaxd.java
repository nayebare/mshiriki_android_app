package com.google.android.gms.internal;

import java.util.Arrays;

public class zzaxd {
    private static final String TAG;
    private static final char[] zzbyu;
    private final byte[] zzbyp;

    static {
        TAG = zzaxd.class.getSimpleName();
        zzbyu = "0123456789abcdef".toCharArray();
    }

    public zzaxd(byte[] bArr) {
        this.zzbyp = bArr;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return z;
        }
        if (obj == this) {
            return true;
        }
        try {
            return Arrays.equals(this.zzbyp, ((zzaxd) obj).getBytes());
        } catch (ClassCastException e) {
            return z;
        }
    }

    public byte[] getBytes() {
        return this.zzbyp;
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzbyp) + 527;
    }

    public zzaxd zzmG(int i) {
        return new zzaxd(Arrays.copyOfRange(this.zzbyp, 0, i));
    }
}
