package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity extends GamesAbstractSafeParcelable implements AppContentAction {
    public static final Creator<AppContentActionEntity> CREATOR;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGu;
    private final String zzTW;
    private final ArrayList<AppContentConditionEntity> zzaYn;
    private final AppContentAnnotationEntity zzaYo;
    private final String zzaYp;
    private final String zzasu;

    static {
        CREATOR = new AppContentActionEntityCreator();
    }

    AppContentActionEntity(int i, ArrayList<AppContentConditionEntity> arrayList, String str, Bundle bundle, String str2, String str3, AppContentAnnotationEntity appContentAnnotationEntity, String str4) {
        this.mVersionCode = i;
        this.zzaYo = appContentAnnotationEntity;
        this.zzaYn = arrayList;
        this.zzasu = str;
        this.mExtras = bundle;
        this.zzGu = str3;
        this.zzaYp = str4;
        this.zzTW = str2;
    }

    public AppContentActionEntity(AppContentAction appContentAction) {
        this.mVersionCode = 5;
        this.zzaYo = (AppContentAnnotationEntity) appContentAction.zzDt().freeze();
        this.zzasu = appContentAction.zzDv();
        this.mExtras = appContentAction.getExtras();
        this.zzGu = appContentAction.getId();
        this.zzaYp = appContentAction.zzDw();
        this.zzTW = appContentAction.getType();
        List zzDu = appContentAction.zzDu();
        int size = zzDu.size();
        this.zzaYn = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaYn.add((AppContentConditionEntity) ((AppContentCondition) zzDu.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzaa.hashCode(appContentAction.zzDt(), appContentAction.zzDu(), appContentAction.zzDv(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzDw(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzaa.equal(appContentAction2.zzDt(), appContentAction.zzDt()) && zzaa.equal(appContentAction2.zzDu(), appContentAction.zzDu()) && zzaa.equal(appContentAction2.zzDv(), appContentAction.zzDv()) && zzaa.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzaa.equal(appContentAction2.getId(), appContentAction.getId()) && zzaa.equal(appContentAction2.zzDw(), appContentAction.zzDw()) && zzaa.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzaa.zzv(appContentAction).zzg("Annotation", appContentAction.zzDt()).zzg("Conditions", appContentAction.zzDu()).zzg("ContentDescription", appContentAction.zzDv()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zzDw()).zzg("Type", appContentAction.getType()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDx();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzGu;
    }

    public String getType() {
        return this.zzTW;
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
        AppContentActionEntityCreator.zza(this, parcel, i);
    }

    public AppContentAnnotation zzDt() {
        return this.zzaYo;
    }

    public List<AppContentCondition> zzDu() {
        return new ArrayList(this.zzaYn);
    }

    public String zzDv() {
        return this.zzasu;
    }

    public String zzDw() {
        return this.zzaYp;
    }

    public AppContentAction zzDx() {
        return this;
    }
}
