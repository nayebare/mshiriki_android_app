package com.google.android.gms.fitness.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Games;

public class zzl extends zza implements Result {
    public static final Creator<zzl> CREATOR;
    private final Uri uri;
    private final int versionCode;
    private final Status zzagv;

    static {
        CREATOR = new zzm();
    }

    zzl(int i, Uri uri, Status status) {
        this.versionCode = i;
        this.uri = uri;
        this.zzagv = status;
    }

    private boolean zzb(zzl com_google_android_gms_fitness_result_zzl) {
        return this.zzagv.equals(com_google_android_gms_fitness_result_zzl.zzagv) && zzaa.equal(this.uri, com_google_android_gms_fitness_result_zzl.uri);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzl) && zzb((zzl) obj));
    }

    public Status getStatus() {
        return this.zzagv;
    }

    public Uri getUri() {
        return this.uri;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzagv, this.uri);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzagv).zzg("uri", this.uri).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
