package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;

public final class VideoEntity extends zza implements Video {
    public static final Creator<VideoEntity> CREATOR;
    private final int mVersionCode;
    private final long zzKH;
    private final String zzQL;
    private final int zzaDh;
    private final long zzbfA;
    private final String zzbfz;

    static {
        CREATOR = new VideoEntityCreator();
    }

    VideoEntity(int i, int i2, String str, long j, long j2, String str2) {
        this.mVersionCode = i;
        this.zzaDh = i2;
        this.zzbfz = str;
        this.zzbfA = j;
        this.zzKH = j2;
        this.zzQL = str2;
    }

    public VideoEntity(Video video) {
        this.mVersionCode = 1;
        this.zzaDh = video.getDuration();
        this.zzbfz = video.zzFQ();
        this.zzbfA = video.getFileSize();
        this.zzKH = video.getStartTime();
        this.zzQL = video.getPackageName();
        zzc.zzt(this.zzbfz);
        zzc.zzt(this.zzQL);
    }

    static int zza(Video video) {
        return zzaa.hashCode(Integer.valueOf(video.getDuration()), video.zzFQ(), Long.valueOf(video.getFileSize()), Long.valueOf(video.getStartTime()), video.getPackageName());
    }

    static boolean zza(Video video, Object obj) {
        if (!(obj instanceof Video)) {
            return false;
        }
        if (video == obj) {
            return true;
        }
        Video video2 = (Video) obj;
        return zzaa.equal(Integer.valueOf(video2.getDuration()), Integer.valueOf(video.getDuration())) && zzaa.equal(video2.zzFQ(), video.zzFQ()) && zzaa.equal(Long.valueOf(video2.getFileSize()), Long.valueOf(video.getFileSize())) && zzaa.equal(Long.valueOf(video2.getStartTime()), Long.valueOf(video.getStartTime())) && zzaa.equal(video2.getPackageName(), video.getPackageName());
    }

    static String zzb(Video video) {
        return zzaa.zzv(video).zzg("Duration", Integer.valueOf(video.getDuration())).zzg("File path", video.zzFQ()).zzg("File size", Long.valueOf(video.getFileSize())).zzg("Start time", Long.valueOf(video.getStartTime())).zzg("Package name", video.getPackageName()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFV();
    }

    public int getDuration() {
        return this.zzaDh;
    }

    public long getFileSize() {
        return this.zzbfA;
    }

    public String getPackageName() {
        return this.zzQL;
    }

    public long getStartTime() {
        return this.zzKH;
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
        VideoEntityCreator.zza(this, parcel, i);
    }

    public String zzFQ() {
        return this.zzbfz;
    }

    public Video zzFV() {
        return this;
    }
}
