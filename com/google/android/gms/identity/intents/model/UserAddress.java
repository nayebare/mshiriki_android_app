package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress extends zza implements ReflectedParcelable {
    public static final Creator<UserAddress> CREATOR;
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzUe;
    String zzbgO;
    String zzbgP;
    String zzbgQ;
    String zzbgR;
    String zzbgS;
    String zzbgT;
    String zzbgU;
    String zzbgV;
    String zzbgW;
    boolean zzbgX;
    String zzbgY;
    String zzbgZ;

    static {
        CREATOR = new zzb();
    }

    UserAddress() {
        this.mVersionCode = 1;
    }

    UserAddress(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.mVersionCode = i;
        this.name = str;
        this.zzbgO = str2;
        this.zzbgP = str3;
        this.zzbgQ = str4;
        this.zzbgR = str5;
        this.zzbgS = str6;
        this.zzbgT = str7;
        this.zzbgU = str8;
        this.zzUe = str9;
        this.zzbgV = str10;
        this.zzbgW = str11;
        this.phoneNumber = str12;
        this.zzbgX = z;
        this.zzbgY = str13;
        this.zzbgZ = str14;
    }

    public static UserAddress fromIntent(Intent intent) {
        return (intent == null || !intent.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) intent.getParcelableExtra(Extras.EXTRA_ADDRESS);
    }

    public String getAddress1() {
        return this.zzbgO;
    }

    public String getAddress2() {
        return this.zzbgP;
    }

    public String getAddress3() {
        return this.zzbgQ;
    }

    public String getAddress4() {
        return this.zzbgR;
    }

    public String getAddress5() {
        return this.zzbgS;
    }

    public String getAdministrativeArea() {
        return this.zzbgT;
    }

    public String getCompanyName() {
        return this.zzbgY;
    }

    public String getCountryCode() {
        return this.zzUe;
    }

    public String getEmailAddress() {
        return this.zzbgZ;
    }

    public String getLocality() {
        return this.zzbgU;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalCode() {
        return this.zzbgV;
    }

    public String getSortingCode() {
        return this.zzbgW;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzbgX;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
