package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public class zzbqs implements FirebaseRemoteConfigValue {
    public static final Charset UTF_8;
    public static final Pattern zzaHr;
    public static final Pattern zzaHs;
    private final int zzAG;
    private final byte[] zzcjR;

    static {
        UTF_8 = Charset.forName(HTTP.UTF_8);
        zzaHr = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        zzaHs = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public zzbqs(byte[] bArr, int i) {
        this.zzcjR = bArr;
        this.zzAG = i;
    }

    private void zzaax() {
        if (this.zzcjR == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    public boolean asBoolean() throws IllegalArgumentException {
        if (this.zzAG == 0) {
            return false;
        }
        Object asString = asString();
        if (zzaHr.matcher(asString).matches()) {
            return true;
        }
        if (zzaHs.matcher(asString).matches()) {
            return false;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(asString).length() + 45).append("[Value: ").append(asString).append("] cannot be interpreted as a boolean.").toString());
    }

    public byte[] asByteArray() {
        return this.zzAG == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY : this.zzcjR;
    }

    public double asDouble() {
        if (this.zzAG == 0) {
            return 0.0d;
        }
        String asString = asString();
        try {
            return Double.valueOf(asString).doubleValue();
        } catch (Throwable e) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(asString).length() + 42).append("[Value: ").append(asString).append("] cannot be converted to a double.").toString(), e);
        }
    }

    public long asLong() {
        if (this.zzAG == 0) {
            return 0;
        }
        String asString = asString();
        try {
            return Long.valueOf(asString).longValue();
        } catch (Throwable e) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(asString).length() + 40).append("[Value: ").append(asString).append("] cannot be converted to a long.").toString(), e);
        }
    }

    public String asString() {
        if (this.zzAG == 0) {
            return BuildConfig.FLAVOR;
        }
        zzaax();
        return new String(this.zzcjR, UTF_8);
    }

    public int getSource() {
        return this.zzAG;
    }
}
