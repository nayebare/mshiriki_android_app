package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef zzbbX;

    public ExperienceEventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        if (zzdl("external_game_id")) {
            this.zzbbX = null;
        } else {
            this.zzbbX = new GameRef(this.zzazI, this.zzaCm);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ExperienceEventEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzEZ();
    }

    public Game getGame() {
        return this.zzbbX;
    }

    public Uri getIconImageUri() {
        return zzdk("icon_uri");
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return ExperienceEventEntity.zza(this);
    }

    public String toString() {
        return ExperienceEventEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((ExperienceEventEntity) ((ExperienceEvent) freeze())).writeToParcel(parcel, i);
    }

    public String zzES() {
        return getString("external_experience_id");
    }

    public String zzET() {
        return getString("display_title");
    }

    public String zzEU() {
        return getString("display_description");
    }

    public long zzEV() {
        return getLong("created_timestamp");
    }

    public long zzEW() {
        return getLong("xp_earned");
    }

    public long zzEX() {
        return getLong("current_xp");
    }

    public int zzEY() {
        return getInteger("newLevel");
    }

    public ExperienceEvent zzEZ() {
        return new ExperienceEventEntity(this);
    }
}
