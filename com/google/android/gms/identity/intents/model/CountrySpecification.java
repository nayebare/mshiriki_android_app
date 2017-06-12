package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class CountrySpecification extends zza implements ReflectedParcelable {
    public static final Creator<CountrySpecification> CREATOR;
    private final int mVersionCode;
    String zzUe;

    static {
        CREATOR = new zza();
    }

    CountrySpecification(int i, String str) {
        this.mVersionCode = i;
        this.zzUe = str;
    }

    public CountrySpecification(String str) {
        this.mVersionCode = 1;
        this.zzUe = str;
    }

    public String getCountryCode() {
        return this.zzUe;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
