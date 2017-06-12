package com.google.android.gms.games.video;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class VideoRef extends zzc implements Video {
    VideoRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzFV();
    }

    public int getDuration() {
        return getInteger("duration");
    }

    public long getFileSize() {
        return getLong("filesize");
    }

    public String getPackageName() {
        return getString("package");
    }

    public long getStartTime() {
        return getLong("start_time");
    }

    public String toString() {
        return VideoEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((VideoEntity) ((Video) freeze())).writeToParcel(parcel, i);
    }

    public String zzFQ() {
        return getString("filepath");
    }

    public Video zzFV() {
        return new VideoEntity(this);
    }
}
