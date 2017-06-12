package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public final class zzb extends zza {
    public static final Creator<zzb> CREATOR;
    public static final zzb zzaQQ;
    private final String packageName;
    private final String version;
    private final int versionCode;
    private final String zzaQR;

    static {
        zzaQQ = new zzb(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, null, null);
        CREATOR = new zzc();
    }

    zzb(int i, String str, String str2, String str3) {
        this.versionCode = i;
        this.packageName = (String) zzac.zzw(str);
        this.version = BuildConfig.FLAVOR;
        this.zzaQR = str3;
    }

    public zzb(String str, String str2, String str3) {
        this(1, str, BuildConfig.FLAVOR, str3);
    }

    private boolean zza(zzb com_google_android_gms_fitness_data_zzb) {
        return this.packageName.equals(com_google_android_gms_fitness_data_zzb.packageName) && zzaa.equal(this.version, com_google_android_gms_fitness_data_zzb.version) && zzaa.equal(this.zzaQR, com_google_android_gms_fitness_data_zzb.zzaQR);
    }

    public static zzb zzdZ(String str) {
        return zzf(str, null, null);
    }

    public static zzb zzf(String str, String str2, String str3) {
        return GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(str) ? zzaQQ : new zzb(str, str2, str3);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzb) && zza((zzb) obj));
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersion() {
        return this.version;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.packageName, this.version, this.zzaQR);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.packageName, this.version, this.zzaQR});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public String zzBf() {
        return this.zzaQR;
    }
}
