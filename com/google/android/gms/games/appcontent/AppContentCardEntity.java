package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity extends GamesAbstractSafeParcelable implements AppContentCard {
    public static final Creator<AppContentCardEntity> CREATOR;
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGu;
    private final String zzTW;
    private final ArrayList<AppContentConditionEntity> zzaYn;
    private final ArrayList<AppContentAnnotationEntity> zzaYw;
    private final int zzaYx;
    private final String zzaYy;
    private final int zzaYz;
    private final String zzacd;
    private final String zzalD;
    private final String zzasu;

    static {
        CREATOR = new AppContentCardEntityCreator();
    }

    AppContentCardEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i2, String str2, Bundle bundle, String str3, String str4, int i3, String str5, String str6) {
        this.mVersionCode = i;
        this.mActions = arrayList;
        this.zzaYw = arrayList2;
        this.zzaYn = arrayList3;
        this.zzasu = str;
        this.zzaYx = i2;
        this.zzacd = str2;
        this.mExtras = bundle;
        this.zzGu = str6;
        this.zzaYy = str3;
        this.zzalD = str4;
        this.zzaYz = i3;
        this.zzTW = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        int i;
        int i2 = 0;
        this.mVersionCode = 4;
        this.zzasu = appContentCard.zzDv();
        this.zzaYx = appContentCard.zzDG();
        this.zzacd = appContentCard.getDescription();
        this.mExtras = appContentCard.getExtras();
        this.zzGu = appContentCard.getId();
        this.zzalD = appContentCard.getTitle();
        this.zzaYy = appContentCard.zzDH();
        this.zzaYz = appContentCard.zzDI();
        this.zzTW = appContentCard.getType();
        List actions = appContentCard.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = appContentCard.zzDF();
        size = actions.size();
        this.zzaYw = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaYw.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zzDu = appContentCard.zzDu();
        int size2 = zzDu.size();
        this.zzaYn = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaYn.add((AppContentConditionEntity) ((AppContentCondition) zzDu.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzaa.hashCode(appContentCard.getActions(), appContentCard.zzDF(), appContentCard.zzDu(), appContentCard.zzDv(), Integer.valueOf(appContentCard.zzDG()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzDH(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzDI()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzaa.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzaa.equal(appContentCard2.zzDF(), appContentCard.zzDF()) && zzaa.equal(appContentCard2.zzDu(), appContentCard.zzDu()) && zzaa.equal(appContentCard2.zzDv(), appContentCard.zzDv()) && zzaa.equal(Integer.valueOf(appContentCard2.zzDG()), Integer.valueOf(appContentCard.zzDG())) && zzaa.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzaa.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzaa.equal(appContentCard2.getId(), appContentCard.getId()) && zzaa.equal(appContentCard2.zzDH(), appContentCard.zzDH()) && zzaa.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzaa.equal(Integer.valueOf(appContentCard2.zzDI()), Integer.valueOf(appContentCard.zzDI())) && zzaa.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzaa.zzv(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzDF()).zzg("Conditions", appContentCard.zzDu()).zzg("ContentDescription", appContentCard.zzDv()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzDG())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzDH()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzDI())).zzg("Type", appContentCard.getType()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDJ();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzacd;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzGu;
    }

    public String getTitle() {
        return this.zzalD;
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    public List<AppContentAnnotation> zzDF() {
        return new ArrayList(this.zzaYw);
    }

    public int zzDG() {
        return this.zzaYx;
    }

    public String zzDH() {
        return this.zzaYy;
    }

    public int zzDI() {
        return this.zzaYz;
    }

    public AppContentCard zzDJ() {
        return this;
    }

    public List<AppContentCondition> zzDu() {
        return new ArrayList(this.zzaYn);
    }

    public String zzDv() {
        return this.zzasu;
    }
}
