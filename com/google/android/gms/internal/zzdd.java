package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzmb
public abstract class zzdd {
    @Nullable
    private static MessageDigest zzyb;
    protected Object zzrN;

    static {
        zzyb = null;
    }

    public zzdd() {
        this.zzrN = new Object();
    }

    abstract byte[] zzF(String str);

    @Nullable
    protected MessageDigest zzeo() {
        MessageDigest messageDigest;
        synchronized (this.zzrN) {
            if (zzyb != null) {
                messageDigest = zzyb;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzyb = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzyb;
            }
        }
        return messageDigest;
    }
}
