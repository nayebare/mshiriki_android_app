package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.PopupManager.PopupLocationInfo;

public final class PopupLocationInfoParcelable extends GamesAbstractSafeParcelable {
    public static final Creator<PopupLocationInfoParcelable> CREATOR;
    private final int mVersionCode;
    private final Bundle zzbaE;
    private final IBinder zzbaF;

    static {
        CREATOR = new PopupLocationInfoParcelableCreator();
    }

    PopupLocationInfoParcelable(int i, Bundle bundle, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzbaE = bundle;
        this.zzbaF = iBinder;
    }

    public PopupLocationInfoParcelable(PopupLocationInfo popupLocationInfo) {
        this.mVersionCode = 1;
        this.zzbaE = popupLocationInfo.zzEM();
        this.zzbaF = popupLocationInfo.zzbaI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public IBinder getWindowToken() {
        return this.zzbaF;
    }

    public void writeToParcel(Parcel parcel, int i) {
        PopupLocationInfoParcelableCreator.zza(this, parcel, i);
    }

    public Bundle zzEM() {
        return this.zzbaE;
    }
}
