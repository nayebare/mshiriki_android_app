package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class SnapshotMetadataRef extends zzc implements SnapshotMetadata {
    private final Game zzbcY;
    private final Player zzbeW;

    public SnapshotMetadataRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzbcY = new GameRef(dataHolder, i);
        this.zzbeW = new PlayerRef(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return SnapshotMetadataEntity.zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return new SnapshotMetadataEntity(this);
    }

    public float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        return f == 0.0f ? 0.0f : getFloat("cover_icon_image_width") / f;
    }

    public Uri getCoverImageUri() {
        return zzdk("cover_icon_image_uri");
    }

    public String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public String getDeviceName() {
        return getString("device_name");
    }

    public Game getGame() {
        return this.zzbcY;
    }

    public long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public Player getOwner() {
        return this.zzbeW;
    }

    public long getPlayedTime() {
        return getLong("duration");
    }

    public long getProgressValue() {
        return getLong("progress_value");
    }

    public String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public String getUniqueName() {
        return getString("unique_name");
    }

    public boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    public int hashCode() {
        return SnapshotMetadataEntity.zza(this);
    }

    public String toString() {
        return SnapshotMetadataEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((SnapshotMetadataEntity) ((SnapshotMetadata) freeze())).writeToParcel(parcel, i);
    }
}
