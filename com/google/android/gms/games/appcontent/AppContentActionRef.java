package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 1, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDx();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzazI, this.zzaYK, "action_data", this.zzaCm);
    }

    public String getId() {
        return getString("action_id");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentActionEntity) ((AppContentAction) freeze())).writeToParcel(parcel, i);
    }

    public AppContentAnnotation zzDt() {
        List zzb = AppContentUtils.zzb(this.zzazI, this.zzaYK, "action_annotation", this.zzaCm);
        return zzb.size() == 1 ? (AppContentAnnotation) zzb.get(0) : null;
    }

    public List<AppContentCondition> zzDu() {
        return AppContentUtils.zzc(this.zzazI, this.zzaYK, "action_conditions", this.zzaCm);
    }

    public String zzDv() {
        return getString("action_content_description");
    }

    public String zzDw() {
        return getString("overflow_text");
    }

    public AppContentAction zzDx() {
        return new AppContentActionEntity(this);
    }
}
