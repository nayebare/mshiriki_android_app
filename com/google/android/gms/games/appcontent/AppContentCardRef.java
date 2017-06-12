package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 0, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDJ();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzazI, this.zzaYK, "card_actions", this.zzaCm);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzazI, this.zzaYK, "card_data", this.zzaCm);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentCardEntity) ((AppContentCard) freeze())).writeToParcel(parcel, i);
    }

    public List<AppContentAnnotation> zzDF() {
        return AppContentUtils.zzb(this.zzazI, this.zzaYK, "card_annotations", this.zzaCm);
    }

    public int zzDG() {
        return getInteger("card_current_steps");
    }

    public String zzDH() {
        return getString("card_subtitle");
    }

    public int zzDI() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zzDJ() {
        return new AppContentCardEntity(this);
    }

    public List<AppContentCondition> zzDu() {
        return AppContentUtils.zzc(this.zzazI, this.zzaYK, "card_conditions", this.zzaCm);
    }

    public String zzDv() {
        return getString("card_content_description");
    }
}
