package com.google.android.gms.location.places;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public final class zzm extends zza {
    public static final Creator<zzm> CREATOR;
    private final int mPriority;
    final int mVersionCode;
    private final long zzbjb;
    private final long zzbjw;
    private final PlaceFilter zzblh;
    private final boolean zzbli;
    private final boolean zzblj;

    static {
        CREATOR = new zzn();
    }

    public zzm(int i, PlaceFilter placeFilter, long j, int i2, long j2, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzblh = placeFilter;
        this.zzbjw = j;
        this.mPriority = i2;
        this.zzbjb = j2;
        this.zzbli = z;
        this.zzblj = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm com_google_android_gms_location_places_zzm = (zzm) obj;
        return zzaa.equal(this.zzblh, com_google_android_gms_location_places_zzm.zzblh) && this.zzbjw == com_google_android_gms_location_places_zzm.zzbjw && this.mPriority == com_google_android_gms_location_places_zzm.mPriority && this.zzbjb == com_google_android_gms_location_places_zzm.zzbjb && this.zzbli == com_google_android_gms_location_places_zzm.zzbli;
    }

    public long getExpirationTime() {
        return this.zzbjb;
    }

    public long getInterval() {
        return this.zzbjw;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzblh, Long.valueOf(this.zzbjw), Integer.valueOf(this.mPriority), Long.valueOf(this.zzbjb), Boolean.valueOf(this.zzbli));
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return zzaa.zzv(this).zzg("filter", this.zzblh).zzg("interval", Long.valueOf(this.zzbjw)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzbjb)).zzg("receiveFailures", Boolean.valueOf(this.zzbli)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    @Deprecated
    public PlaceFilter zzHM() {
        return this.zzblh;
    }

    public boolean zzHT() {
        return this.zzbli;
    }

    public boolean zzHU() {
        return this.zzblj;
    }
}
