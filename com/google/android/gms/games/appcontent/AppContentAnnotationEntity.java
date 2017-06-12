package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class AppContentAnnotationEntity extends GamesAbstractSafeParcelable implements AppContentAnnotation {
    public static final Creator<AppContentAnnotationEntity> CREATOR;
    private final int mVersionCode;
    private final String zzGu;
    private final Uri zzaYq;
    private final String zzaYr;
    private final String zzaYs;
    private final int zzaYt;
    private final int zzaYu;
    private final Bundle zzaYv;
    private final String zzacd;
    private final String zzalD;

    static {
        CREATOR = new AppContentAnnotationEntityCreator();
    }

    AppContentAnnotationEntity(int i, String str, Uri uri, String str2, String str3, String str4, String str5, int i2, int i3, Bundle bundle) {
        this.mVersionCode = i;
        this.zzacd = str;
        this.zzGu = str3;
        this.zzaYs = str5;
        this.zzaYt = i2;
        this.zzaYq = uri;
        this.zzaYu = i3;
        this.zzaYr = str4;
        this.zzaYv = bundle;
        this.zzalD = str2;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appContentAnnotation) {
        this.mVersionCode = 4;
        this.zzacd = appContentAnnotation.getDescription();
        this.zzGu = appContentAnnotation.getId();
        this.zzaYs = appContentAnnotation.zzDy();
        this.zzaYt = appContentAnnotation.zzDz();
        this.zzaYq = appContentAnnotation.zzDA();
        this.zzaYu = appContentAnnotation.zzDC();
        this.zzaYr = appContentAnnotation.zzDD();
        this.zzaYv = appContentAnnotation.zzDB();
        this.zzalD = appContentAnnotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzaa.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzDy(), Integer.valueOf(appContentAnnotation.zzDz()), appContentAnnotation.zzDA(), Integer.valueOf(appContentAnnotation.zzDC()), appContentAnnotation.zzDD(), appContentAnnotation.zzDB(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzaa.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzaa.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzaa.equal(appContentAnnotation2.zzDy(), appContentAnnotation.zzDy()) && zzaa.equal(Integer.valueOf(appContentAnnotation2.zzDz()), Integer.valueOf(appContentAnnotation.zzDz())) && zzaa.equal(appContentAnnotation2.zzDA(), appContentAnnotation.zzDA()) && zzaa.equal(Integer.valueOf(appContentAnnotation2.zzDC()), Integer.valueOf(appContentAnnotation.zzDC())) && zzaa.equal(appContentAnnotation2.zzDD(), appContentAnnotation.zzDD()) && zzaa.equal(appContentAnnotation2.zzDB(), appContentAnnotation.zzDB()) && zzaa.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzaa.zzv(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zzDy()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zzDz())).zzg("ImageUri", appContentAnnotation.zzDA()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zzDC())).zzg("LayoutSlot", appContentAnnotation.zzDD()).zzg("Modifiers", appContentAnnotation.zzDB()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDE();
    }

    public String getDescription() {
        return this.zzacd;
    }

    public String getId() {
        return this.zzGu;
    }

    public String getTitle() {
        return this.zzalD;
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
        AppContentAnnotationEntityCreator.zza(this, parcel, i);
    }

    public Uri zzDA() {
        return this.zzaYq;
    }

    public Bundle zzDB() {
        return this.zzaYv;
    }

    public int zzDC() {
        return this.zzaYu;
    }

    public String zzDD() {
        return this.zzaYr;
    }

    public AppContentAnnotation zzDE() {
        return this;
    }

    public String zzDy() {
        return this.zzaYs;
    }

    public int zzDz() {
        return this.zzaYt;
    }
}
