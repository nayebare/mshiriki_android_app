package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class ExperienceEventEntity extends GamesAbstractSafeParcelable implements ExperienceEvent {
    public static final Creator<ExperienceEventEntity> CREATOR;
    private final int mVersionCode;
    private final Uri zzaWW;
    private final String zzaXh;
    private final int zzanR;
    private final String zzbbP;
    private final GameEntity zzbbQ;
    private final String zzbbR;
    private final String zzbbS;
    private final long zzbbT;
    private final long zzbbU;
    private final long zzbbV;
    private final int zzbbW;

    static {
        CREATOR = new ExperienceEventEntityCreator();
    }

    ExperienceEventEntity(int i, String str, GameEntity gameEntity, String str2, String str3, String str4, Uri uri, long j, long j2, long j3, int i2, int i3) {
        this.mVersionCode = i;
        this.zzbbP = str;
        this.zzbbQ = gameEntity;
        this.zzbbR = str2;
        this.zzbbS = str3;
        this.zzaXh = str4;
        this.zzaWW = uri;
        this.zzbbT = j;
        this.zzbbU = j2;
        this.zzbbV = j3;
        this.zzanR = i2;
        this.zzbbW = i3;
    }

    public ExperienceEventEntity(ExperienceEvent experienceEvent) {
        this.mVersionCode = 1;
        this.zzbbP = experienceEvent.zzES();
        this.zzbbQ = new GameEntity(experienceEvent.getGame());
        this.zzbbR = experienceEvent.zzET();
        this.zzbbS = experienceEvent.zzEU();
        this.zzaXh = experienceEvent.getIconImageUrl();
        this.zzaWW = experienceEvent.getIconImageUri();
        this.zzbbT = experienceEvent.zzEV();
        this.zzbbU = experienceEvent.zzEW();
        this.zzbbV = experienceEvent.zzEX();
        this.zzanR = experienceEvent.getType();
        this.zzbbW = experienceEvent.zzEY();
    }

    static int zza(ExperienceEvent experienceEvent) {
        return zzaa.hashCode(experienceEvent.zzES(), experienceEvent.getGame(), experienceEvent.zzET(), experienceEvent.zzEU(), experienceEvent.getIconImageUrl(), experienceEvent.getIconImageUri(), Long.valueOf(experienceEvent.zzEV()), Long.valueOf(experienceEvent.zzEW()), Long.valueOf(experienceEvent.zzEX()), Integer.valueOf(experienceEvent.getType()), Integer.valueOf(experienceEvent.zzEY()));
    }

    static boolean zza(ExperienceEvent experienceEvent, Object obj) {
        if (!(obj instanceof ExperienceEvent)) {
            return false;
        }
        if (experienceEvent == obj) {
            return true;
        }
        ExperienceEvent experienceEvent2 = (ExperienceEvent) obj;
        return zzaa.equal(experienceEvent2.zzES(), experienceEvent.zzES()) && zzaa.equal(experienceEvent2.getGame(), experienceEvent.getGame()) && zzaa.equal(experienceEvent2.zzET(), experienceEvent.zzET()) && zzaa.equal(experienceEvent2.zzEU(), experienceEvent.zzEU()) && zzaa.equal(experienceEvent2.getIconImageUrl(), experienceEvent.getIconImageUrl()) && zzaa.equal(experienceEvent2.getIconImageUri(), experienceEvent.getIconImageUri()) && zzaa.equal(Long.valueOf(experienceEvent2.zzEV()), Long.valueOf(experienceEvent.zzEV())) && zzaa.equal(Long.valueOf(experienceEvent2.zzEW()), Long.valueOf(experienceEvent.zzEW())) && zzaa.equal(Long.valueOf(experienceEvent2.zzEX()), Long.valueOf(experienceEvent.zzEX())) && zzaa.equal(Integer.valueOf(experienceEvent2.getType()), Integer.valueOf(experienceEvent.getType())) && zzaa.equal(Integer.valueOf(experienceEvent2.zzEY()), Integer.valueOf(experienceEvent.zzEY()));
    }

    static String zzb(ExperienceEvent experienceEvent) {
        return zzaa.zzv(experienceEvent).zzg("ExperienceId", experienceEvent.zzES()).zzg("Game", experienceEvent.getGame()).zzg("DisplayTitle", experienceEvent.zzET()).zzg("DisplayDescription", experienceEvent.zzEU()).zzg("IconImageUrl", experienceEvent.getIconImageUrl()).zzg("IconImageUri", experienceEvent.getIconImageUri()).zzg("CreatedTimestamp", Long.valueOf(experienceEvent.zzEV())).zzg("XpEarned", Long.valueOf(experienceEvent.zzEW())).zzg("CurrentXp", Long.valueOf(experienceEvent.zzEX())).zzg("Type", Integer.valueOf(experienceEvent.getType())).zzg("NewLevel", Integer.valueOf(experienceEvent.zzEY())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzEZ();
    }

    public Game getGame() {
        return this.zzbbQ;
    }

    public Uri getIconImageUri() {
        return this.zzaWW;
    }

    public String getIconImageUrl() {
        return this.zzaXh;
    }

    public int getType() {
        return this.zzanR;
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
        ExperienceEventEntityCreator.zza(this, parcel, i);
    }

    public String zzES() {
        return this.zzbbP;
    }

    public String zzET() {
        return this.zzbbR;
    }

    public String zzEU() {
        return this.zzbbS;
    }

    public long zzEV() {
        return this.zzbbT;
    }

    public long zzEW() {
        return this.zzbbU;
    }

    public long zzEX() {
        return this.zzbbV;
    }

    public int zzEY() {
        return this.zzbbW;
    }

    public ExperienceEvent zzEZ() {
        return this;
    }
}
