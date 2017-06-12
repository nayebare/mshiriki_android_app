package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class SnapshotMetadataChangeEntity extends GamesAbstractSafeParcelable implements SnapshotMetadataChange {
    public static final Creator<SnapshotMetadataChangeEntity> CREATOR;
    private final int mVersionCode;
    private final String zzacd;
    private final Long zzbeI;
    private final Uri zzbeK;
    private final Long zzbeL;
    private BitmapTeleporter zzbeM;

    static {
        CREATOR = new SnapshotMetadataChangeCreator();
    }

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int i, String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        boolean z = true;
        this.mVersionCode = i;
        this.zzacd = str;
        this.zzbeL = l;
        this.zzbeM = bitmapTeleporter;
        this.zzbeK = uri;
        this.zzbeI = l2;
        if (this.zzbeM != null) {
            if (this.zzbeK != null) {
                z = false;
            }
            zzac.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzbeK != null) {
            if (this.zzbeM != null) {
                z = false;
            }
            zzac.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this(5, str, l, bitmapTeleporter, uri, l2);
    }

    public Bitmap getCoverImage() {
        return this.zzbeM == null ? null : this.zzbeM.zzwz();
    }

    public Uri getCoverImageUri() {
        return this.zzbeK;
    }

    public String getDescription() {
        return this.zzacd;
    }

    public Long getPlayedTimeMillis() {
        return this.zzbeL;
    }

    public Long getProgressValue() {
        return this.zzbeI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataChangeCreator.zza(this, parcel, i);
    }

    public BitmapTeleporter zzFL() {
        return this.zzbeM;
    }
}
