package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class SnapshotEntity extends GamesAbstractSafeParcelable implements Snapshot {
    public static final Creator<SnapshotEntity> CREATOR;
    private final int mVersionCode;
    private final SnapshotMetadataEntity zzbeF;
    private final SnapshotContentsEntity zzbeG;

    static {
        CREATOR = new SnapshotEntityCreator();
    }

    SnapshotEntity(int i, SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this.mVersionCode = i;
        this.zzbeF = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzbeG = snapshotContentsEntity;
    }

    public SnapshotEntity(SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this(2, snapshotMetadata, snapshotContentsEntity);
    }

    private boolean isClosed() {
        return this.zzbeG.isClosed();
    }

    static boolean zza(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return zzaa.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && zzaa.equal(snapshot2.getSnapshotContents(), snapshot.getSnapshotContents());
    }

    static int zzb(Snapshot snapshot) {
        return zzaa.hashCode(snapshot.getMetadata(), snapshot.getSnapshotContents());
    }

    static String zzc(Snapshot snapshot) {
        return zzaa.zzv(snapshot).zzg("Metadata", snapshot.getMetadata()).zzg("HasContents", Boolean.valueOf(snapshot.getSnapshotContents() != null)).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Snapshot freeze() {
        return this;
    }

    public SnapshotMetadata getMetadata() {
        return this.zzbeF;
    }

    public SnapshotContents getSnapshotContents() {
        return isClosed() ? null : this.zzbeG;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotEntityCreator.zza(this, parcel, i);
    }
}
