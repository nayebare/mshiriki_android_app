package com.google.android.gms.games.social;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public class SocialInviteEntity extends GamesAbstractSafeParcelable implements SocialInvite {
    public static final Creator<SocialInviteEntity> CREATOR;
    private final int mVersionCode;
    private final PlayerEntity zzaYi;
    private final int zzanR;
    private final long zzbeP;
    private final String zzbeX;
    private final int zzbeY;

    static {
        CREATOR = new SocialInviteEntityCreator();
    }

    SocialInviteEntity(int i, String str, PlayerEntity playerEntity, int i2, int i3, long j) {
        this.mVersionCode = i;
        this.zzbeX = str;
        this.zzaYi = playerEntity;
        this.zzanR = i2;
        this.zzbeY = i3;
        this.zzbeP = j;
    }

    public SocialInviteEntity(SocialInvite socialInvite) {
        this.mVersionCode = 1;
        this.zzbeX = socialInvite.zzFM();
        Player player = socialInvite.getPlayer();
        this.zzaYi = player == null ? null : (PlayerEntity) player.freeze();
        this.zzanR = socialInvite.getType();
        this.zzbeY = socialInvite.getDirection();
        this.zzbeP = socialInvite.getLastModifiedTimestamp();
    }

    static int zza(SocialInvite socialInvite) {
        return zzaa.hashCode(socialInvite.zzFM(), socialInvite.getPlayer(), Integer.valueOf(socialInvite.getType()), Integer.valueOf(socialInvite.getDirection()), Long.valueOf(socialInvite.getLastModifiedTimestamp()));
    }

    static boolean zza(SocialInvite socialInvite, Object obj) {
        if (!(obj instanceof SocialInvite)) {
            return false;
        }
        if (socialInvite == obj) {
            return true;
        }
        SocialInvite socialInvite2 = (SocialInvite) obj;
        return zzaa.equal(socialInvite2.zzFM(), socialInvite.zzFM()) && zzaa.equal(socialInvite2.getPlayer(), socialInvite.getPlayer()) && zzaa.equal(Integer.valueOf(socialInvite2.getType()), Integer.valueOf(socialInvite.getType())) && zzaa.equal(Integer.valueOf(socialInvite2.getDirection()), Integer.valueOf(socialInvite.getDirection())) && zzaa.equal(Long.valueOf(socialInvite2.getLastModifiedTimestamp()), Long.valueOf(socialInvite.getLastModifiedTimestamp()));
    }

    static String zzb(SocialInvite socialInvite) {
        return zzaa.zzv(socialInvite).zzg("Social Invite ID", socialInvite.zzFM()).zzg("Player", socialInvite.getPlayer()).zzg("Type", Integer.valueOf(socialInvite.getType())).zzg("Direction", Integer.valueOf(socialInvite.getDirection())).zzg("Last Modified Timestamp", Long.valueOf(socialInvite.getLastModifiedTimestamp())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFN();
    }

    public int getDirection() {
        return this.zzbeY;
    }

    public long getLastModifiedTimestamp() {
        return this.zzbeP;
    }

    public Player getPlayer() {
        return this.zzaYi;
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
        SocialInviteEntityCreator.zza(this, parcel, i);
    }

    public String zzFM() {
        return this.zzbeX;
    }

    public SocialInvite zzFN() {
        return this;
    }
}
