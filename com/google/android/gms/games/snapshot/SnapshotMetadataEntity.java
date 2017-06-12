package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class SnapshotMetadataEntity extends GamesAbstractSafeParcelable implements SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR;
    private final int mVersionCode;
    private final String zzaZn;
    private final String zzacd;
    private final String zzalD;
    private final GameEntity zzbbQ;
    private final Uri zzbeK;
    private final PlayerEntity zzbeN;
    private final String zzbeO;
    private final long zzbeP;
    private final long zzbeQ;
    private final float zzbeR;
    private final String zzbeS;
    private final boolean zzbeT;
    private final long zzbeU;
    private final String zzbeV;

    static {
        CREATOR = new SnapshotMetadataEntityCreator();
    }

    SnapshotMetadataEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, String str, Uri uri, String str2, String str3, String str4, long j, long j2, float f, String str5, boolean z, long j3, String str6) {
        this.mVersionCode = i;
        this.zzbbQ = gameEntity;
        this.zzbeN = playerEntity;
        this.zzaZn = str;
        this.zzbeK = uri;
        this.zzbeO = str2;
        this.zzbeR = f;
        this.zzalD = str3;
        this.zzacd = str4;
        this.zzbeP = j;
        this.zzbeQ = j2;
        this.zzbeS = str5;
        this.zzbeT = z;
        this.zzbeU = j3;
        this.zzbeV = str6;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.mVersionCode = 6;
        this.zzbbQ = new GameEntity(snapshotMetadata.getGame());
        this.zzbeN = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzaZn = snapshotMetadata.getSnapshotId();
        this.zzbeK = snapshotMetadata.getCoverImageUri();
        this.zzbeO = snapshotMetadata.getCoverImageUrl();
        this.zzbeR = snapshotMetadata.getCoverImageAspectRatio();
        this.zzalD = snapshotMetadata.getTitle();
        this.zzacd = snapshotMetadata.getDescription();
        this.zzbeP = snapshotMetadata.getLastModifiedTimestamp();
        this.zzbeQ = snapshotMetadata.getPlayedTime();
        this.zzbeS = snapshotMetadata.getUniqueName();
        this.zzbeT = snapshotMetadata.hasChangePending();
        this.zzbeU = snapshotMetadata.getProgressValue();
        this.zzbeV = snapshotMetadata.getDeviceName();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzaa.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzaa.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzaa.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzaa.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzaa.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzaa.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzaa.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzaa.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzaa.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzaa.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzaa.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzaa.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzaa.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && zzaa.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzaa.zzv(snapshotMetadata).zzg("Game", snapshotMetadata.getGame()).zzg("Owner", snapshotMetadata.getOwner()).zzg("SnapshotId", snapshotMetadata.getSnapshotId()).zzg("CoverImageUri", snapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zzg("Description", snapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zzg("UniqueName", snapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).zzg("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzbeR;
    }

    public Uri getCoverImageUri() {
        return this.zzbeK;
    }

    public String getCoverImageUrl() {
        return this.zzbeO;
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
    }

    public String getDeviceName() {
        return this.zzbeV;
    }

    public Game getGame() {
        return this.zzbbQ;
    }

    public long getLastModifiedTimestamp() {
        return this.zzbeP;
    }

    public Player getOwner() {
        return this.zzbeN;
    }

    public long getPlayedTime() {
        return this.zzbeQ;
    }

    public long getProgressValue() {
        return this.zzbeU;
    }

    public String getSnapshotId() {
        return this.zzaZn;
    }

    public String getTitle() {
        return this.zzalD;
    }

    public String getUniqueName() {
        return this.zzbeS;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasChangePending() {
        return this.zzbeT;
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
        SnapshotMetadataEntityCreator.zza(this, parcel, i);
    }
}
