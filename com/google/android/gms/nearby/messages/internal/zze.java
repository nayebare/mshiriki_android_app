package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.nearby.messages.Distance;
import com.google.android.gms.wearable.MessageApi;
import java.util.Locale;

public class zze extends zza implements Distance {
    public static final Creator<zze> CREATOR;
    public final int accuracy;
    final int mVersionCode;
    public final double zzbyy;

    static {
        CREATOR = new zzf();
    }

    public zze(int i, double d) {
        this(1, i, d);
    }

    zze(int i, int i2, double d) {
        this.mVersionCode = i;
        this.accuracy = i2;
        this.zzbyy = d;
    }

    private static String zzlX(int i) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return "LOW";
            default:
                return "UNKNOWN";
        }
    }

    public int compareTo(@NonNull Distance distance) {
        return (Double.isNaN(getMeters()) && Double.isNaN(distance.getMeters())) ? 0 : Double.compare(getMeters(), distance.getMeters());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        Distance distance = (zze) obj;
        return getAccuracy() == distance.getAccuracy() && compareTo(distance) == 0;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public double getMeters() {
        return this.zzbyy;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(getAccuracy()), Double.valueOf(getMeters()));
    }

    public String toString() {
        return String.format(Locale.US, "(%.1fm, %s)", new Object[]{Double.valueOf(this.zzbyy), zzlX(this.accuracy)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
