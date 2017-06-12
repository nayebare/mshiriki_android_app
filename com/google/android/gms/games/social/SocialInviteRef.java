package com.google.android.gms.games.social;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class SocialInviteRef extends zzc implements SocialInvite {
    private final Player zzbeZ;

    SocialInviteRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzbeZ = new PlayerRef(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return SocialInviteEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFN();
    }

    public int getDirection() {
        return getInteger("direction");
    }

    public long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public Player getPlayer() {
        return this.zzbeZ;
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return SocialInviteEntity.zza(this);
    }

    public String toString() {
        return SocialInviteEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((SocialInviteEntity) ((SocialInvite) freeze())).writeToParcel(parcel, i);
    }

    public String zzFM() {
        return getString("external_social_invite_id");
    }

    public SocialInvite zzFN() {
        return new SocialInviteEntity(this);
    }
}
