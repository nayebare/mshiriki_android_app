package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzut;

public final class IdToken extends zza implements ReflectedParcelable {
    public static final Creator<IdToken> CREATOR;
    final int mVersionCode;
    @NonNull
    private final String zzaih;
    @NonNull
    private final String zzaix;

    static {
        CREATOR = new zze();
    }

    IdToken(int i, @NonNull String str, @NonNull String str2) {
        zzut.zzcs(str);
        zzac.zzb(!TextUtils.isEmpty(str2), (Object) "id token string cannot be null or empty");
        this.mVersionCode = i;
        this.zzaih = str;
        this.zzaix = str2;
    }

    public IdToken(@NonNull String str, @NonNull String str2) {
        this(1, str, str2);
    }

    @NonNull
    public String getAccountType() {
        return this.zzaih;
    }

    @NonNull
    public String getIdToken() {
        return this.zzaix;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
