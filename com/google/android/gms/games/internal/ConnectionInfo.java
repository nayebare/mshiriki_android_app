package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ConnectionInfo extends GamesAbstractSafeParcelable {
    public static final Creator<ConnectionInfo> CREATOR;
    private final int mVersionCode;
    private final String zzaYN;
    private final int zzaYO;

    static {
        CREATOR = new ConnectionInfoCreator();
    }

    public ConnectionInfo(int i, String str, int i2) {
        this.mVersionCode = i;
        this.zzaYN = str;
        this.zzaYO = i2;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ConnectionInfoCreator.zza(this, parcel, i);
    }

    public String zzDY() {
        return this.zzaYN;
    }

    public int zzDZ() {
        return this.zzaYO;
    }
}
