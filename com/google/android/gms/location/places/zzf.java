package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public final class zzf extends zza {
    public static final Creator<zzf> CREATOR;
    private int mPriority;
    private final int mVersionCode;
    private final int zzbja;
    private final int zzbkP;
    @Deprecated
    private final PlaceFilter zzbkQ;
    private final zzd zzbkR;
    private final boolean zzbkS;
    private final int zzbkT;

    static {
        CREATOR = new zzg();
    }

    zzf(int i, int i2, int i3, PlaceFilter placeFilter, zzd com_google_android_gms_location_places_zzd, boolean z, int i4, int i5) {
        this.mPriority = C0308R.styleable.AppCompatTheme_ratingBarStyleSmall;
        this.mVersionCode = i;
        this.zzbja = i2;
        this.zzbkP = i3;
        if (com_google_android_gms_location_places_zzd != null) {
            this.zzbkR = com_google_android_gms_location_places_zzd;
        } else if (placeFilter == null) {
            this.zzbkR = null;
        } else if (placeFilter.getPlaceIds() != null && !placeFilter.getPlaceIds().isEmpty()) {
            this.zzbkR = zzd.zzm(placeFilter.getPlaceIds());
        } else if (placeFilter.zzHQ() == null || placeFilter.zzHQ().isEmpty()) {
            this.zzbkR = null;
        } else {
            this.zzbkR = zzd.zzn(placeFilter.zzHQ());
        }
        this.zzbkQ = null;
        this.zzbkS = z;
        this.zzbkT = i4;
        this.mPriority = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf com_google_android_gms_location_places_zzf = (zzf) obj;
        return this.zzbja == com_google_android_gms_location_places_zzf.zzbja && this.zzbkP == com_google_android_gms_location_places_zzf.zzbkP && zzaa.equal(this.zzbkR, com_google_android_gms_location_places_zzf.zzbkR) && this.mPriority == com_google_android_gms_location_places_zzf.mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzbja), Integer.valueOf(this.zzbkP), this.zzbkR, Integer.valueOf(this.mPriority));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("transitionTypes", Integer.valueOf(this.zzbja)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzbkP)).zzg("nearbyAlertFilter", this.zzbkR).zzg("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public int zzHH() {
        return this.zzbja;
    }

    public int zzHL() {
        return this.zzbkP;
    }

    @Deprecated
    public PlaceFilter zzHM() {
        return null;
    }

    public zzd zzHN() {
        return this.zzbkR;
    }

    public boolean zzHO() {
        return this.zzbkS;
    }

    public int zzHP() {
        return this.zzbkT;
    }
}
