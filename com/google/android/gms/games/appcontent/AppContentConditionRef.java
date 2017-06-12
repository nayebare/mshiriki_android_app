package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 4, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentConditionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDO();
    }

    public int hashCode() {
        return AppContentConditionEntity.zza(this);
    }

    public String toString() {
        return AppContentConditionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentConditionEntity) ((AppContentCondition) freeze())).writeToParcel(parcel, i);
    }

    public String zzDK() {
        return getString("condition_default_value");
    }

    public String zzDL() {
        return getString("condition_expected_value");
    }

    public String zzDM() {
        return getString("condition_predicate");
    }

    public Bundle zzDN() {
        return AppContentUtils.zzd(this.zzazI, this.zzaYK, "condition_predicate_parameters", this.zzaCm);
    }

    public AppContentCondition zzDO() {
        return new AppContentConditionEntity(this);
    }
}
