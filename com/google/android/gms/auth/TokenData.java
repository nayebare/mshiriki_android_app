package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

public class TokenData extends zza implements ReflectedParcelable {
    public static final Creator<TokenData> CREATOR;
    final int mVersionCode;
    private final String zzahI;
    private final Long zzahJ;
    private final boolean zzahK;
    private final boolean zzahL;
    private final List<String> zzahM;

    static {
        CREATOR = new zzf();
    }

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.mVersionCode = i;
        this.zzahI = zzac.zzdv(str);
        this.zzahJ = l;
        this.zzahK = z;
        this.zzahL = z2;
        this.zzahM = list;
    }

    @Nullable
    public static TokenData zzd(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.zzahI, tokenData.zzahI) && zzaa.equal(this.zzahJ, tokenData.zzahJ) && this.zzahK == tokenData.zzahK && this.zzahL == tokenData.zzahL && zzaa.equal(this.zzahM, tokenData.zzahM);
    }

    public String getToken() {
        return this.zzahI;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahI, this.zzahJ, Boolean.valueOf(this.zzahK), Boolean.valueOf(this.zzahL), this.zzahM);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    @Nullable
    public Long zzqo() {
        return this.zzahJ;
    }

    public boolean zzqp() {
        return this.zzahK;
    }

    public boolean zzqq() {
        return this.zzahL;
    }

    @Nullable
    public List<String> zzqr() {
        return this.zzahM;
    }
}
