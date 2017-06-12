package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity extends GamesAbstractSafeParcelable implements AppContentSection {
    public static final Creator<AppContentSectionEntity> CREATOR;
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGu;
    private final String zzTW;
    private final ArrayList<AppContentCardEntity> zzaYE;
    private final String zzaYF;
    private final ArrayList<AppContentAnnotationEntity> zzaYw;
    private final String zzaYy;
    private final String zzalD;
    private final String zzasu;

    static {
        CREATOR = new AppContentSectionEntityCreator();
    }

    AppContentSectionEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentCardEntity> arrayList2, String str, Bundle bundle, String str2, String str3, String str4, String str5, String str6, ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.mVersionCode = i;
        this.mActions = arrayList;
        this.zzaYw = arrayList3;
        this.zzaYE = arrayList2;
        this.zzaYF = str6;
        this.zzasu = str;
        this.mExtras = bundle;
        this.zzGu = str5;
        this.zzaYy = str2;
        this.zzalD = str3;
        this.zzTW = str4;
    }

    public AppContentSectionEntity(AppContentSection appContentSection) {
        int i;
        int i2 = 0;
        this.mVersionCode = 5;
        this.zzaYF = appContentSection.zzDQ();
        this.zzasu = appContentSection.zzDv();
        this.mExtras = appContentSection.getExtras();
        this.zzGu = appContentSection.getId();
        this.zzaYy = appContentSection.zzDH();
        this.zzalD = appContentSection.getTitle();
        this.zzTW = appContentSection.getType();
        List actions = appContentSection.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = appContentSection.zzDP();
        size = actions.size();
        this.zzaYE = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaYE.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zzDF = appContentSection.zzDF();
        int size2 = zzDF.size();
        this.zzaYw = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaYw.add((AppContentAnnotationEntity) ((AppContentAnnotation) zzDF.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzaa.hashCode(appContentSection.getActions(), appContentSection.zzDF(), appContentSection.zzDP(), appContentSection.zzDQ(), appContentSection.zzDv(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzDH(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzaa.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzaa.equal(appContentSection2.zzDF(), appContentSection.zzDF()) && zzaa.equal(appContentSection2.zzDP(), appContentSection.zzDP()) && zzaa.equal(appContentSection2.zzDQ(), appContentSection.zzDQ()) && zzaa.equal(appContentSection2.zzDv(), appContentSection.zzDv()) && zzaa.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzaa.equal(appContentSection2.getId(), appContentSection.getId()) && zzaa.equal(appContentSection2.zzDH(), appContentSection.zzDH()) && zzaa.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzaa.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzaa.zzv(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzDF()).zzg("Cards", appContentSection.zzDP()).zzg("CardType", appContentSection.zzDQ()).zzg("ContentDescription", appContentSection.zzDv()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzDH()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzDR();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
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
        AppContentSectionEntityCreator.zza(this, parcel, i);
    }

    public List<AppContentAnnotation> zzDF() {
        return new ArrayList(this.zzaYw);
    }

    public String zzDH() {
        return this.zzaYy;
    }

    public List<AppContentCard> zzDP() {
        return new ArrayList(this.zzaYE);
    }

    public String zzDQ() {
        return this.zzaYF;
    }

    public AppContentSection zzDR() {
        return this;
    }

    public String zzDv() {
        return this.zzasu;
    }
}
