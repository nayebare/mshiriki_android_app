package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza {
    public static final Creator<PlaceFilter> CREATOR;
    private static final PlaceFilter zzbkX;
    final int mVersionCode;
    final List<String> zzbkH;
    final List<Integer> zzbkI;
    final List<zzp> zzbkJ;
    private final Set<String> zzbkM;
    private final Set<Integer> zzbkN;
    private final Set<zzp> zzbkO;
    final boolean zzbkY;

    @Deprecated
    public static final class zza {
        private boolean zzbkY;
        private Collection<Integer> zzbkZ;
        private Collection<zzp> zzbla;
        private String[] zzblb;

        private zza() {
            this.zzbkZ = null;
            this.zzbkY = false;
            this.zzbla = null;
            this.zzblb = null;
        }

        public PlaceFilter zzHS() {
            return new PlaceFilter(null, false, null, null);
        }
    }

    static {
        CREATOR = new zzi();
        zzbkX = new PlaceFilter();
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int i, @Nullable List<Integer> list, boolean z, @Nullable List<String> list2, @Nullable List<zzp> list3) {
        this.mVersionCode = i;
        this.zzbkI = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzbkY = z;
        this.zzbkJ = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzbkH = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzbkN = zzD(this.zzbkI);
        this.zzbkO = zzD(this.zzbkJ);
        this.zzbkM = zzD(this.zzbkH);
    }

    public PlaceFilter(@Nullable Collection<Integer> collection, boolean z, @Nullable Collection<String> collection2, @Nullable Collection<zzp> collection3) {
        this(0, zzk(collection), z, zzk(collection2), zzk(collection3));
    }

    public PlaceFilter(boolean z, @Nullable Collection<String> collection) {
        this(null, z, collection, null);
    }

    @Deprecated
    public static PlaceFilter zzHR() {
        return new zza().zzHS();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzbkN.equals(placeFilter.zzbkN) && this.zzbkY == placeFilter.zzbkY && this.zzbkO.equals(placeFilter.zzbkO) && this.zzbkM.equals(placeFilter.zzbkM);
    }

    public Set<String> getPlaceIds() {
        return this.zzbkM;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbkN, Boolean.valueOf(this.zzbkY), this.zzbkO, this.zzbkM);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzbkY;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzaa.zza zzv = zzaa.zzv(this);
        if (!this.zzbkN.isEmpty()) {
            zzv.zzg("types", this.zzbkN);
        }
        zzv.zzg("requireOpenNow", Boolean.valueOf(this.zzbkY));
        if (!this.zzbkM.isEmpty()) {
            zzv.zzg("placeIds", this.zzbkM);
        }
        if (!this.zzbkO.isEmpty()) {
            zzv.zzg("requestedUserDataTypes", this.zzbkO);
        }
        return zzv.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public Set<Integer> zzHQ() {
        return this.zzbkN;
    }
}
