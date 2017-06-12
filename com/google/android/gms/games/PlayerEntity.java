package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final boolean zzZA;
    private final Uri zzaWW;
    private final Uri zzaWX;
    private final long zzaXE;
    private final int zzaXF;
    private final long zzaXG;
    private final MostRecentGameInfoEntity zzaXH;
    private final PlayerLevelInfo zzaXI;
    private final boolean zzaXJ;
    private final boolean zzaXK;
    private final String zzaXL;
    private final Uri zzaXM;
    private final String zzaXN;
    private final Uri zzaXO;
    private final String zzaXP;
    private final int zzaXQ;
    private final long zzaXR;
    private final String zzaXh;
    private final String zzaXi;
    private String zzaiX;
    private final String zzalD;
    private String zzaus;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfs(parcel);
        }

        public PlayerEntity zzfs(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzf(DowngradeableSafeParcel.zzxo()) || DowngradeableSafeParcel.zzdp(PlayerEntity.class.getCanonicalName())) {
                return super.zzfs(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(14, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null, -1, -1, false);
        }
    }

    static {
        CREATOR = new PlayerEntityCreatorCompat();
    }

    PlayerEntity(int i, String str, String str2, Uri uri, Uri uri2, long j, int i2, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9, int i3, long j3, boolean z3) {
        this.mVersionCode = i;
        this.zzaus = str;
        this.zzaiX = str2;
        this.zzaWW = uri;
        this.zzaXh = str3;
        this.zzaWX = uri2;
        this.zzaXi = str4;
        this.zzaXE = j;
        this.zzaXF = i2;
        this.zzaXG = j2;
        this.zzalD = str5;
        this.zzaXJ = z;
        this.zzaXH = mostRecentGameInfoEntity;
        this.zzaXI = playerLevelInfo;
        this.zzaXK = z2;
        this.zzaXL = str6;
        this.mName = str7;
        this.zzaXM = uri3;
        this.zzaXN = str8;
        this.zzaXO = uri4;
        this.zzaXP = str9;
        this.zzaXQ = i3;
        this.zzaXR = j3;
        this.zzZA = z3;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean z) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        this.mVersionCode = 14;
        this.zzaus = z ? player.getPlayerId() : null;
        this.zzaiX = player.getDisplayName();
        this.zzaWW = player.getIconImageUri();
        this.zzaXh = player.getIconImageUrl();
        this.zzaWX = player.getHiResImageUri();
        this.zzaXi = player.getHiResImageUrl();
        this.zzaXE = player.getRetrievedTimestamp();
        this.zzaXF = player.zzDe();
        this.zzaXG = player.getLastPlayedWithTimestamp();
        this.zzalD = player.getTitle();
        this.zzaXJ = player.zzDf();
        MostRecentGameInfo zzDg = player.zzDg();
        if (zzDg != null) {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzDg);
        }
        this.zzaXH = mostRecentGameInfoEntity;
        this.zzaXI = player.getLevelInfo();
        this.zzaXK = player.zzDd();
        this.zzaXL = player.zzDc();
        this.mName = player.getName();
        this.zzaXM = player.getBannerImageLandscapeUri();
        this.zzaXN = player.getBannerImageLandscapeUrl();
        this.zzaXO = player.getBannerImagePortraitUri();
        this.zzaXP = player.getBannerImagePortraitUrl();
        this.zzaXQ = player.zzDh();
        this.zzaXR = player.zzDi();
        this.zzZA = player.isMuted();
        if (z) {
            zzc.zzt(this.zzaus);
        }
        zzc.zzt(this.zzaiX);
        zzc.zzar(this.zzaXE > 0);
    }

    static int zza(Player player) {
        return zzaa.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzDd()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzDc(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Integer.valueOf(player.zzDh()), Long.valueOf(player.zzDi()), Boolean.valueOf(player.isMuted()));
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzaa.equal(player2.getPlayerId(), player.getPlayerId()) && zzaa.equal(player2.getDisplayName(), player.getDisplayName()) && zzaa.equal(Boolean.valueOf(player2.zzDd()), Boolean.valueOf(player.zzDd())) && zzaa.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzaa.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzaa.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzaa.equal(player2.getTitle(), player.getTitle()) && zzaa.equal(player2.getLevelInfo(), player.getLevelInfo()) && zzaa.equal(player2.zzDc(), player.zzDc()) && zzaa.equal(player2.getName(), player.getName()) && zzaa.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && zzaa.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && zzaa.equal(Integer.valueOf(player2.zzDh()), Integer.valueOf(player.zzDh())) && zzaa.equal(Long.valueOf(player2.zzDi()), Long.valueOf(player.zzDi())) && zzaa.equal(Boolean.valueOf(player2.isMuted()), Boolean.valueOf(player.isMuted()));
    }

    static String zzb(Player player) {
        return zzaa.zzv(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzDd())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zzDc()).zzg("Name", player.getName()).zzg("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", player.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).zzg("GamerFriendStatus", Integer.valueOf(player.zzDh())).zzg("GamerFriendUpdateTimestamp", Long.valueOf(player.zzDi())).zzg("IsMuted", Boolean.valueOf(player.isMuted())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public Uri getBannerImageLandscapeUri() {
        return this.zzaXM;
    }

    public String getBannerImageLandscapeUrl() {
        return this.zzaXN;
    }

    public Uri getBannerImagePortraitUri() {
        return this.zzaXO;
    }

    public String getBannerImagePortraitUrl() {
        return this.zzaXP;
    }

    public String getDisplayName() {
        return this.zzaiX;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzaiX, charArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return this.zzaWX;
    }

    public String getHiResImageUrl() {
        return this.zzaXi;
    }

    public Uri getIconImageUri() {
        return this.zzaWW;
    }

    public String getIconImageUrl() {
        return this.zzaXh;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzaXG;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaXI;
    }

    public String getName() {
        return this.mName;
    }

    public String getPlayerId() {
        return this.zzaus;
    }

    public long getRetrievedTimestamp() {
        return this.zzaXE;
    }

    public String getTitle() {
        return this.zzalD;
    }

    public void getTitle(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzalD, charArrayBuffer);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzZA;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlayerEntityCreator.zza(this, parcel, i);
    }

    public String zzDc() {
        return this.zzaXL;
    }

    public boolean zzDd() {
        return this.zzaXK;
    }

    public int zzDe() {
        return this.zzaXF;
    }

    public boolean zzDf() {
        return this.zzaXJ;
    }

    public MostRecentGameInfo zzDg() {
        return this.zzaXH;
    }

    public int zzDh() {
        return this.zzaXQ;
    }

    public long zzDi() {
        return this.zzaXR;
    }
}
