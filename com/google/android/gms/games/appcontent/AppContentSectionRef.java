package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaYG;

    AppContentSectionRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList, 0, i);
        this.zzaYG = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDR();
    }

    public /* synthetic */ List getActions() {
        return zzDS();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzazI, this.zzaYK, "section_data", this.zzaCm);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentSectionEntity) ((AppContentSection) freeze())).writeToParcel(parcel, i);
    }

    public /* synthetic */ List zzDF() {
        return zzDT();
    }

    public String zzDH() {
        return getString("section_subtitle");
    }

    public /* synthetic */ List zzDP() {
        return zzDU();
    }

    public String zzDQ() {
        return getString("section_card_type");
    }

    public AppContentSection zzDR() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzDS() {
        return AppContentUtils.zza(this.zzazI, this.zzaYK, "section_actions", this.zzaCm);
    }

    public ArrayList<AppContentAnnotation> zzDT() {
        return AppContentUtils.zzb(this.zzazI, this.zzaYK, "section_annotations", this.zzaCm);
    }

    public ArrayList<AppContentCard> zzDU() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzaYG);
        for (int i = 0; i < this.zzaYG; i++) {
            arrayList.add(new AppContentCardRef(this.zzaYK, this.zzaCm + i));
        }
        return arrayList;
    }

    public String zzDv() {
        return getString("section_content_description");
    }
}
