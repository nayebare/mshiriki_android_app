package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 2, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDE();
    }

    public String getDescription() {
        return getString("annotation_description");
    }

    public String getId() {
        return getString("annotation_id");
    }

    public String getTitle() {
        return getString("annotation_title");
    }

    public int hashCode() {
        return AppContentAnnotationEntity.zza(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentAnnotationEntity) ((AppContentAnnotation) freeze())).writeToParcel(parcel, i);
    }

    public Uri zzDA() {
        return zzdk("annotation_image_uri");
    }

    public Bundle zzDB() {
        return AppContentUtils.zzd(this.zzazI, this.zzaYK, "annotation_modifiers", this.zzaCm);
    }

    public int zzDC() {
        return getInteger("annotation_image_width");
    }

    public String zzDD() {
        return getString("annotation_layout_slot");
    }

    public AppContentAnnotation zzDE() {
        return new AppContentAnnotationEntity(this);
    }

    public String zzDy() {
        return getString("annotation_image_default_id");
    }

    public int zzDz() {
        return getInteger("annotation_image_height");
    }
}
