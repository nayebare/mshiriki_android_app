package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class AppContentConditionEntity extends GamesAbstractSafeParcelable implements AppContentCondition {
    public static final Creator<AppContentConditionEntity> CREATOR;
    private final int mVersionCode;
    private final String zzaYA;
    private final String zzaYB;
    private final String zzaYC;
    private final Bundle zzaYD;

    static {
        CREATOR = new AppContentConditionEntityCreator();
    }

    AppContentConditionEntity(int i, String str, String str2, String str3, Bundle bundle) {
        this.mVersionCode = i;
        this.zzaYA = str;
        this.zzaYB = str2;
        this.zzaYC = str3;
        this.zzaYD = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appContentCondition) {
        this.mVersionCode = 1;
        this.zzaYA = appContentCondition.zzDK();
        this.zzaYB = appContentCondition.zzDL();
        this.zzaYC = appContentCondition.zzDM();
        this.zzaYD = appContentCondition.zzDN();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzaa.hashCode(appContentCondition.zzDK(), appContentCondition.zzDL(), appContentCondition.zzDM(), appContentCondition.zzDN());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzaa.equal(appContentCondition2.zzDK(), appContentCondition.zzDK()) && zzaa.equal(appContentCondition2.zzDL(), appContentCondition.zzDL()) && zzaa.equal(appContentCondition2.zzDM(), appContentCondition.zzDM()) && zzaa.equal(appContentCondition2.zzDN(), appContentCondition.zzDN());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzaa.zzv(appContentCondition).zzg("DefaultValue", appContentCondition.zzDK()).zzg("ExpectedValue", appContentCondition.zzDL()).zzg("Predicate", appContentCondition.zzDM()).zzg("PredicateParameters", appContentCondition.zzDN()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDO();
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
        AppContentConditionEntityCreator.zza(this, parcel, i);
    }

    public String zzDK() {
        return this.zzaYA;
    }

    public String zzDL() {
        return this.zzaYB;
    }

    public String zzDM() {
        return this.zzaYC;
    }

    public Bundle zzDN() {
        return this.zzaYD;
    }

    public AppContentCondition zzDO() {
        return this;
    }
}
