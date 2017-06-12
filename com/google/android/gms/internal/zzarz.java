package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;
import java.util.Locale;

public class zzarz extends zza implements Geofence {
    public static final Creator<zzarz> CREATOR;
    private final int mVersionCode;
    private final String zzOn;
    private final int zzbja;
    private final short zzbjc;
    private final double zzbjd;
    private final double zzbje;
    private final float zzbjf;
    private final int zzbjg;
    private final int zzbjh;
    private final long zzbkw;

    static {
        CREATOR = new zzasa();
    }

    public zzarz(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        zzeX(str);
        zzf(f);
        zza(d, d2);
        int zzks = zzks(i2);
        this.mVersionCode = i;
        this.zzbjc = s;
        this.zzOn = str;
        this.zzbjd = d;
        this.zzbje = d2;
        this.zzbjf = f;
        this.zzbkw = j;
        this.zzbja = zzks;
        this.zzbjg = i3;
        this.zzbjh = i4;
    }

    public zzarz(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void zzeX(String str) {
        if (str == null || str.length() > 100) {
            String str2 = "requestId is null or too long: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    private static void zzf(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static int zzks(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    @SuppressLint({"DefaultLocale"})
    private static String zzkt(int i) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static zzarz zzw(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzarz com_google_android_gms_internal_zzarz = (zzarz) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return com_google_android_gms_internal_zzarz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof zzarz)) {
            return false;
        }
        zzarz com_google_android_gms_internal_zzarz = (zzarz) obj;
        return this.zzbjf != com_google_android_gms_internal_zzarz.zzbjf ? false : this.zzbjd != com_google_android_gms_internal_zzarz.zzbjd ? false : this.zzbje != com_google_android_gms_internal_zzarz.zzbje ? false : this.zzbjc == com_google_android_gms_internal_zzarz.zzbjc;
    }

    public long getExpirationTime() {
        return this.zzbkw;
    }

    public double getLatitude() {
        return this.zzbjd;
    }

    public double getLongitude() {
        return this.zzbje;
    }

    public float getRadius() {
        return this.zzbjf;
    }

    public String getRequestId() {
        return this.zzOn;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzbjd);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzbje);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzbjf)) * 31) + this.zzbjc) * 31) + this.zzbja;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{zzkt(this.zzbjc), this.zzOn, Integer.valueOf(this.zzbja), Double.valueOf(this.zzbjd), Double.valueOf(this.zzbje), Float.valueOf(this.zzbjf), Integer.valueOf(this.zzbjg / CardNetwork.OTHER), Integer.valueOf(this.zzbjh), Long.valueOf(this.zzbkw)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzasa.zza(this, parcel, i);
    }

    public short zzHG() {
        return this.zzbjc;
    }

    public int zzHH() {
        return this.zzbja;
    }

    public int zzHI() {
        return this.zzbjg;
    }

    public int zzHJ() {
        return this.zzbjh;
    }
}
