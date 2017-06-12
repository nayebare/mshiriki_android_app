package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class zzarv extends zza {
    public static final Creator<zzarv> CREATOR;
    static final List<zzarj> zzbko;
    @Nullable
    String mTag;
    private final int mVersionCode;
    LocationRequest zzaVV;
    boolean zzbiI;
    List<zzarj> zzbiU;
    boolean zzbkp;
    boolean zzbkq;

    static {
        zzbko = Collections.emptyList();
        CREATOR = new zzarw();
    }

    zzarv(int i, LocationRequest locationRequest, boolean z, List<zzarj> list, @Nullable String str, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzaVV = locationRequest;
        this.zzbiI = z;
        this.zzbiU = list;
        this.mTag = str;
        this.zzbkp = z2;
        this.zzbkq = z3;
    }

    public static zzarv zza(@Nullable String str, LocationRequest locationRequest) {
        return new zzarv(1, locationRequest, true, zzbko, str, false, false);
    }

    @Deprecated
    public static zzarv zzb(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzarv)) {
            return false;
        }
        zzarv com_google_android_gms_internal_zzarv = (zzarv) obj;
        return zzaa.equal(this.zzaVV, com_google_android_gms_internal_zzarv.zzaVV) && this.zzbiI == com_google_android_gms_internal_zzarv.zzbiI && this.zzbkp == com_google_android_gms_internal_zzarv.zzbkp && zzaa.equal(this.zzbiU, com_google_android_gms_internal_zzarv.zzbiU) && this.zzbkq == com_google_android_gms_internal_zzarv.zzbkq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzaVV.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zzaVV.toString());
        if (this.mTag != null) {
            stringBuilder.append(" tag=").append(this.mTag);
        }
        stringBuilder.append(" trigger=").append(this.zzbiI);
        stringBuilder.append(" hideAppOps=").append(this.zzbkp);
        stringBuilder.append(" clients=").append(this.zzbiU);
        stringBuilder.append(" forceCoarseLocation=").append(this.zzbkq);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzarw.zza(this, parcel, i);
    }
}
