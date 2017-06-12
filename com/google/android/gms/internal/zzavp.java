package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class zzavp extends zza {
    public static final Creator<zzavp> CREATOR;
    private static final zzavt[] zzbyc;
    private static final String[] zzbyd;
    private static final String zzbye;
    public static final zzavp zzbyf;
    final int mVersionCode;
    @Nullable
    @Deprecated
    final String zzD;
    @Deprecated
    final zzavt zzbyg;
    private final String zzbyh;
    @Deprecated
    final zzavt[] zzbyi;
    @Deprecated
    final String[] zzbyj;
    @Nullable
    private final String zzbyk;

    static {
        CREATOR = new zzavq();
        zzbyc = new zzavt[0];
        zzbyd = new String[0];
        zzbye = null;
        zzbyf = new zzavp(BuildConfig.FLAVOR, zzbyc, zzbyd, null);
    }

    zzavp(int i, @Nullable zzavt com_google_android_gms_internal_zzavt, @Nullable String str, @Nullable String str2, @Nullable zzavt[] com_google_android_gms_internal_zzavtArr, @Nullable String[] strArr, @Nullable String str3) {
        this.mVersionCode = ((Integer) zzac.zzw(Integer.valueOf(i))).intValue();
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.zzbyh = str2;
        if (com_google_android_gms_internal_zzavtArr == null) {
            com_google_android_gms_internal_zzavtArr = zzbyc;
        }
        this.zzbyi = com_google_android_gms_internal_zzavtArr;
        if (strArr == null) {
            strArr = zzbyd;
        }
        this.zzbyj = strArr;
        this.zzbyg = this.zzbyi.length == 0 ? zzavt.zzbyo : this.zzbyi[0];
        this.zzD = this.zzbyj.length == 0 ? null : this.zzbyj[0];
        this.zzbyk = str3;
    }

    @Deprecated
    public zzavp(String str, zzavt[] com_google_android_gms_internal_zzavtArr, String[] strArr, String str2) {
        this(1, null, null, str, com_google_android_gms_internal_zzavtArr, strArr, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzavp)) {
            return false;
        }
        zzavp com_google_android_gms_internal_zzavp = (zzavp) obj;
        return zzaa.equal(this.zzbyh, com_google_android_gms_internal_zzavp.zzbyh) && zzaa.equal(this.zzbyk, com_google_android_gms_internal_zzavp.zzbyk);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbyh, this.zzbyk);
    }

    public String toString() {
        String str = this.zzbyh;
        String str2 = this.zzbyk;
        return new StringBuilder((String.valueOf(str).length() + 40) + String.valueOf(str2).length()).append("NearbyDevice{handle=").append(str).append(", bluetoothAddress=").append(str2).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavq.zza(this, parcel, i);
    }

    public String zzNg() {
        return this.zzbyh;
    }

    @Nullable
    public String zzNh() {
        return this.zzbyk;
    }
}
