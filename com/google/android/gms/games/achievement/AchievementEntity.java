package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class AchievementEntity extends GamesAbstractSafeParcelable implements Achievement {
    public static final Creator<AchievementEntity> CREATOR;
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final String zzaYb;
    private final Uri zzaYc;
    private final String zzaYd;
    private final Uri zzaYe;
    private final String zzaYf;
    private final int zzaYg;
    private final String zzaYh;
    private final PlayerEntity zzaYi;
    private final int zzaYj;
    private final String zzaYk;
    private final long zzaYl;
    private final long zzaYm;
    private final String zzacd;
    private final int zzanR;

    static {
        CREATOR = new AchievementEntityCreator();
    }

    AchievementEntity(int i, String str, int i2, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i3, String str6, PlayerEntity playerEntity, int i4, int i5, String str7, long j, long j2) {
        this.mVersionCode = i;
        this.zzaYb = str;
        this.zzanR = i2;
        this.mName = str2;
        this.zzacd = str3;
        this.zzaYc = uri;
        this.zzaYd = str4;
        this.zzaYe = uri2;
        this.zzaYf = str5;
        this.zzaYg = i3;
        this.zzaYh = str6;
        this.zzaYi = playerEntity;
        this.mState = i4;
        this.zzaYj = i5;
        this.zzaYk = str7;
        this.zzaYl = j;
        this.zzaYm = j2;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzaYb = achievement.getAchievementId();
        this.zzanR = achievement.getType();
        this.mName = achievement.getName();
        this.zzacd = achievement.getDescription();
        this.zzaYc = achievement.getUnlockedImageUri();
        this.zzaYd = achievement.getUnlockedImageUrl();
        this.zzaYe = achievement.getRevealedImageUri();
        this.zzaYf = achievement.getRevealedImageUrl();
        this.zzaYi = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaYl = achievement.getLastUpdatedTimestamp();
        this.zzaYm = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaYg = achievement.getTotalSteps();
            this.zzaYh = achievement.getFormattedTotalSteps();
            this.zzaYj = achievement.getCurrentSteps();
            this.zzaYk = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaYg = 0;
            this.zzaYh = null;
            this.zzaYj = 0;
            this.zzaYk = null;
        }
        zzc.zzt(this.zzaYb);
        zzc.zzt(this.zzacd);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzaa.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzaa.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzaa.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzaa.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzaa.equal(achievement2.getName(), achievement.getName()) && zzaa.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzaa.equal(achievement2.getDescription(), achievement.getDescription()) && zzaa.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzaa.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzaa.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzaa.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zzg = zzaa.zzv(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzaYb;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzc.zzar(z);
        return zzDr();
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzc.zzar(z);
        return zzDs();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzc.zzar(z);
        zzg.zzb(this.zzaYk, charArrayBuffer);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzc.zzar(z);
        return zzDq();
    }

    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzc.zzar(z);
        zzg.zzb(this.zzaYh, charArrayBuffer);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaYl;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.mName, charArrayBuffer);
    }

    public Player getPlayer() {
        return this.zzaYi;
    }

    public Uri getRevealedImageUri() {
        return this.zzaYe;
    }

    public String getRevealedImageUrl() {
        return this.zzaYf;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzc.zzar(z);
        return zzDp();
    }

    public int getType() {
        return this.zzanR;
    }

    public Uri getUnlockedImageUri() {
        return this.zzaYc;
    }

    public String getUnlockedImageUrl() {
        return this.zzaYd;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getXpValue() {
        return this.zzaYm;
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
        AchievementEntityCreator.zza(this, parcel, i);
    }

    public int zzDp() {
        return this.zzaYg;
    }

    public String zzDq() {
        return this.zzaYh;
    }

    public int zzDr() {
        return this.zzaYj;
    }

    public String zzDs() {
        return this.zzaYk;
    }
}
