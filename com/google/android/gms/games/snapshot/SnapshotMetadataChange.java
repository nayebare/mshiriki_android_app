package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public interface SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE;

    public static final class Builder {
        private String zzacd;
        private Long zzbeH;
        private Long zzbeI;
        private BitmapTeleporter zzbeJ;
        private Uri zzbeK;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzacd, this.zzbeH, this.zzbeJ, this.zzbeK, this.zzbeI);
        }

        public Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.zzacd = snapshotMetadata.getDescription();
            this.zzbeH = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzbeI = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzbeH.longValue() == -1) {
                this.zzbeH = null;
            }
            this.zzbeK = snapshotMetadata.getCoverImageUri();
            if (this.zzbeK != null) {
                this.zzbeJ = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap bitmap) {
            this.zzbeJ = new BitmapTeleporter(bitmap);
            this.zzbeK = null;
            return this;
        }

        public Builder setDescription(String str) {
            this.zzacd = str;
            return this;
        }

        public Builder setPlayedTimeMillis(long j) {
            this.zzbeH = Long.valueOf(j);
            return this;
        }

        public Builder setProgressValue(long j) {
            this.zzbeI = Long.valueOf(j);
            return this;
        }
    }

    static {
        EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
    }

    Bitmap getCoverImage();

    String getDescription();

    Long getPlayedTimeMillis();

    Long getProgressValue();

    BitmapTeleporter zzFL();
}
