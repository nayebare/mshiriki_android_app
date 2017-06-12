package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class CountrySpecification extends zza {
    public static final Creator<CountrySpecification> CREATOR;
    private final int mVersionCode;
    String zzUe;

    static {
        CREATOR = new zzd();
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
        zzd.zza(this, parcel, i);
    }
}
