package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class AppContentTupleEntity extends GamesAbstractSafeParcelable implements AppContentTuple {
    public static final Creator<AppContentTupleEntity> CREATOR;
    private final String mName;
    private final String mValue;
    private final int mVersionCode;

    static {
        CREATOR = new AppContentTupleEntityCreator();
    }

    AppContentTupleEntity(int i, String str, String str2) {
        this.mVersionCode = i;
        this.mName = str;
        this.mValue = str2;
    }

    public AppContentTupleEntity(AppContentTuple appContentTuple) {
        this.mVersionCode = 1;
        this.mName = appContentTuple.getName();
        this.mValue = appContentTuple.getValue();
    }

    static int zza(AppContentTuple appContentTuple) {
        return zzaa.hashCode(appContentTuple.getName(), appContentTuple.getValue());
    }

    static boolean zza(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return zzaa.equal(appContentTuple2.getName(), appContentTuple.getName()) && zzaa.equal(appContentTuple2.getValue(), appContentTuple.getValue());
    }

    static String zzb(AppContentTuple appContentTuple) {
        return zzaa.zzv(appContentTuple).zzg("Name", appContentTuple.getName()).zzg("Value", appContentTuple.getValue()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDV();
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppContentTupleEntityCreator.zza(this, parcel, i);
    }

    public AppContentTuple zzDV() {
        return this;
    }
}
