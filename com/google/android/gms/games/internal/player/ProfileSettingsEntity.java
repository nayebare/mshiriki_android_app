package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public class ProfileSettingsEntity extends GamesAbstractSafeParcelable implements LoadProfileSettingsResult {
    public static final Creator<ProfileSettingsEntity> CREATOR;
    private final int mVersionCode;
    private final boolean zzaXJ;
    private final String zzaXL;
    private final Status zzahq;
    private final boolean zzbcM;
    private final boolean zzbcN;
    private final StockProfileImageEntity zzbcO;
    private final boolean zzbcP;
    private final boolean zzbcQ;

    static {
        CREATOR = new ProfileSettingsEntityCreator();
    }

    ProfileSettingsEntity(int i, Status status, String str, boolean z, boolean z2, boolean z3, StockProfileImageEntity stockProfileImageEntity, boolean z4, boolean z5) {
        this.mVersionCode = i;
        this.zzahq = status;
        this.zzaXL = str;
        this.zzbcM = z;
        this.zzaXJ = z2;
        this.zzbcN = z3;
        this.zzbcO = stockProfileImageEntity;
        this.zzbcP = z4;
        this.zzbcQ = z5;
    }

    public ProfileSettingsEntity(DataHolder dataHolder) {
        this.mVersionCode = 3;
        this.zzahq = new Status(dataHolder.getStatusCode());
        if (!this.zzahq.isSuccess() || dataHolder.getCount() <= 0) {
            this.zzaXL = null;
            this.zzbcM = false;
            this.zzaXJ = false;
            this.zzbcN = false;
            this.zzbcO = null;
            this.zzbcP = false;
            this.zzbcQ = false;
            return;
        }
        int zzcC = dataHolder.zzcC(0);
        this.zzaXL = dataHolder.zzd("gamer_tag", 0, zzcC);
        this.zzbcM = dataHolder.zze("gamer_tag_explicitly_set", 0, zzcC);
        this.zzaXJ = dataHolder.zze("profile_visible", 0, zzcC);
        this.zzbcN = dataHolder.zze("profile_visibility_explicitly_set", 0, zzcC);
        Object zzd = dataHolder.zzd("stock_avatar_url", 0, zzcC);
        Object zzd2 = dataHolder.zzd("stock_avatar_uri", 0, zzcC);
        if (TextUtils.isEmpty(zzd) || TextUtils.isEmpty(zzd2)) {
            this.zzbcO = null;
        } else {
            this.zzbcO = new StockProfileImageEntity(zzd, Uri.parse(zzd2));
        }
        this.zzbcP = dataHolder.zze("profile_discoverable", 0, zzcC);
        this.zzbcQ = dataHolder.zze("auto_sign_in", 0, zzcC);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LoadProfileSettingsResult)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        LoadProfileSettingsResult loadProfileSettingsResult = (LoadProfileSettingsResult) obj;
        return zzaa.equal(this.zzaXL, loadProfileSettingsResult.zzDc()) && zzaa.equal(Boolean.valueOf(this.zzbcM), Boolean.valueOf(loadProfileSettingsResult.zzDm())) && zzaa.equal(Boolean.valueOf(this.zzaXJ), Boolean.valueOf(loadProfileSettingsResult.zzDf())) && zzaa.equal(Boolean.valueOf(this.zzbcN), Boolean.valueOf(loadProfileSettingsResult.zzDk())) && zzaa.equal(this.zzahq, loadProfileSettingsResult.getStatus()) && zzaa.equal(this.zzbcO, loadProfileSettingsResult.zzDl()) && zzaa.equal(Boolean.valueOf(this.zzbcP), Boolean.valueOf(loadProfileSettingsResult.zzDn())) && zzaa.equal(Boolean.valueOf(this.zzbcQ), Boolean.valueOf(loadProfileSettingsResult.zzDo()));
    }

    public Status getStatus() {
        return this.zzahq;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaXL, Boolean.valueOf(this.zzbcM), Boolean.valueOf(this.zzaXJ), Boolean.valueOf(this.zzbcN), this.zzahq, this.zzbcO, Boolean.valueOf(this.zzbcP), Boolean.valueOf(this.zzbcQ));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("GamerTag", this.zzaXL).zzg("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzbcM)).zzg("IsProfileVisible", Boolean.valueOf(this.zzaXJ)).zzg("IsVisibilityExplicitlySet", Boolean.valueOf(this.zzbcN)).zzg("Status", this.zzahq).zzg("StockProfileImage", this.zzbcO).zzg("IsProfileDiscoverable", Boolean.valueOf(this.zzbcP)).zzg("AutoSignIn", Boolean.valueOf(this.zzbcQ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ProfileSettingsEntityCreator.zza(this, parcel, i);
    }

    public String zzDc() {
        return this.zzaXL;
    }

    public boolean zzDf() {
        return this.zzaXJ;
    }

    public boolean zzDk() {
        return this.zzbcN;
    }

    public StockProfileImage zzDl() {
        return this.zzbcO;
    }

    public boolean zzDm() {
        return this.zzbcM;
    }

    public boolean zzDn() {
        return this.zzbcP;
    }

    public boolean zzDo() {
        return this.zzbcQ;
    }
}
