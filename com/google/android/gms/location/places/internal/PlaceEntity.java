package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceEntity extends zza implements ReflectedParcelable, Place {
    public static final Creator<PlaceEntity> CREATOR;
    private final String mName;
    final int mVersionCode;
    private final String zzGu;
    private final String zzaQS;
    private final List<Integer> zzbkA;
    private final String zzbkB;
    private final Uri zzbkC;
    private final LatLng zzbkz;
    private final Bundle zzblT;
    @Deprecated
    private final zzs zzblU;
    private final float zzblV;
    private final LatLngBounds zzblW;
    private final String zzblX;
    private final boolean zzblY;
    private final float zzblZ;
    private Locale zzblw;
    private final int zzbma;
    private final List<Integer> zzbmb;
    private final String zzbmc;
    private final List<String> zzbmd;
    private final zzu zzbme;
    private final Map<Integer, String> zzbmf;
    private final TimeZone zzbmg;

    static {
        CREATOR = new zzo();
    }

    PlaceEntity(int i, String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i2, zzs com_google_android_gms_location_places_internal_zzs, zzu com_google_android_gms_location_places_internal_zzu) {
        List emptyList;
        this.mVersionCode = i;
        this.zzGu = str;
        this.zzbkA = Collections.unmodifiableList(list);
        this.zzbmb = list2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzblT = bundle;
        this.mName = str2;
        this.zzaQS = str3;
        this.zzbkB = str4;
        this.zzbmc = str5;
        if (list3 == null) {
            emptyList = Collections.emptyList();
        }
        this.zzbmd = emptyList;
        this.zzbkz = latLng;
        this.zzblV = f;
        this.zzblW = latLngBounds;
        if (str6 == null) {
            str6 = "UTC";
        }
        this.zzblX = str6;
        this.zzbkC = uri;
        this.zzblY = z;
        this.zzblZ = f2;
        this.zzbma = i2;
        this.zzbmf = Collections.unmodifiableMap(new HashMap());
        this.zzbmg = null;
        this.zzblw = null;
        this.zzblU = com_google_android_gms_location_places_internal_zzs;
        this.zzbme = com_google_android_gms_location_places_internal_zzu;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceEntity)) {
            return false;
        }
        PlaceEntity placeEntity = (PlaceEntity) obj;
        return this.zzGu.equals(placeEntity.zzGu) && zzaa.equal(this.zzblw, placeEntity.zzblw);
    }

    public /* synthetic */ Object freeze() {
        return zzIm();
    }

    public String getAddress() {
        return this.zzaQS;
    }

    public CharSequence getAttributions() {
        return zzf.zzo(this.zzbmd);
    }

    public String getId() {
        return this.zzGu;
    }

    public LatLng getLatLng() {
        return this.zzbkz;
    }

    public Locale getLocale() {
        return this.zzblw;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzbkB;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzbkA;
    }

    public int getPriceLevel() {
        return this.zzbma;
    }

    public float getRating() {
        return this.zzblZ;
    }

    public LatLngBounds getViewport() {
        return this.zzblW;
    }

    public Uri getWebsiteUri() {
        return this.zzbkC;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzGu, this.zzblw);
    }

    public boolean isDataValid() {
        return true;
    }

    public void setLocale(Locale locale) {
        this.zzblw = locale;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return zzaa.zzv(this).zzg("id", this.zzGu).zzg("placeTypes", this.zzbkA).zzg("locale", this.zzblw).zzg("name", this.mName).zzg("address", this.zzaQS).zzg("phoneNumber", this.zzbkB).zzg("latlng", this.zzbkz).zzg("viewport", this.zzblW).zzg("websiteUri", this.zzbkC).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzblY)).zzg("priceLevel", Integer.valueOf(this.zzbma)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public List<Integer> zzId() {
        return this.zzbmb;
    }

    public float zzIe() {
        return this.zzblV;
    }

    public String zzIf() {
        return this.zzbmc;
    }

    public List<String> zzIg() {
        return this.zzbmd;
    }

    public boolean zzIh() {
        return this.zzblY;
    }

    public zzu zzIi() {
        return this.zzbme;
    }

    public Bundle zzIj() {
        return this.zzblT;
    }

    public String zzIk() {
        return this.zzblX;
    }

    @Deprecated
    public zzs zzIl() {
        return this.zzblU;
    }

    public Place zzIm() {
        return this;
    }
}
