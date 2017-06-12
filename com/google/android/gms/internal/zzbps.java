package com.google.android.gms.internal;

public class zzbps {
    private byte[] zzcif;
    private String zzcig;
    private byte zzcih;

    public zzbps(String str) {
        this.zzcig = str;
        this.zzcih = (byte) 1;
    }

    public zzbps(byte[] bArr) {
        this.zzcif = bArr;
        this.zzcih = (byte) 2;
    }

    public String getText() {
        return this.zzcig;
    }
}
