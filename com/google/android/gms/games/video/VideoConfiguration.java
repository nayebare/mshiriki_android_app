package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class VideoConfiguration extends zza {
    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;
    public static final Creator<VideoConfiguration> CREATOR;
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;
    private final int mVersionCode;
    private final int zzbfm;
    private final int zzbft;
    private final String zzbfu;
    private final String zzbfv;
    private final String zzbfw;
    private final String zzbfx;
    private final boolean zzbfy;

    public static final class Builder {
        private int zzbfm;
        private int zzbft;
        private String zzbfu;
        private String zzbfv;
        private String zzbfw;
        private String zzbfx;
        private boolean zzbfy;

        public Builder(int i, int i2) {
            this.zzbft = i;
            this.zzbfm = i2;
            this.zzbfy = true;
            this.zzbfu = null;
            this.zzbfv = null;
            this.zzbfw = null;
            this.zzbfx = null;
        }

        public VideoConfiguration build() {
            return new VideoConfiguration(this.zzbfm, null, null, null, null, this.zzbfy, null);
        }

        public Builder setCaptureMode(int i) {
            this.zzbfm = i;
            return this;
        }

        public Builder setQualityLevel(int i) {
            this.zzbft = i;
            return this;
        }
    }

    static {
        CREATOR = new VideoConfigurationCreator();
    }

    public VideoConfiguration(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z) {
        boolean z2 = true;
        this.mVersionCode = i;
        zzac.zzas(isValidQualityLevel(i2, false));
        zzac.zzas(isValidCaptureMode(i3, false));
        this.zzbft = i2;
        this.zzbfm = i3;
        this.zzbfy = z;
        if (i3 == QUALITY_LEVEL_HD) {
            this.zzbfv = str2;
            this.zzbfu = str;
            this.zzbfw = str3;
            this.zzbfx = str4;
            return;
        }
        zzac.zzb(str2 == null, (Object) "Stream key should be null when not streaming");
        zzac.zzb(str == null, (Object) "Stream url should be null when not streaming");
        zzac.zzb(str3 == null, (Object) "Stream title should be null when not streaming");
        if (str4 != null) {
            z2 = false;
        }
        zzac.zzb(z2, (Object) "Stream description should be null when not streaming");
        this.zzbfv = null;
        this.zzbfu = null;
        this.zzbfw = null;
        this.zzbfx = null;
    }

    private VideoConfiguration(int i, int i2, String str, String str2, String str3, String str4, boolean z) {
        this((int) QUALITY_LEVEL_XHD, i, i2, str, str2, str3, str4, z);
    }

    public static boolean isValidCaptureMode(int i, boolean z) {
        switch (i) {
            case QUALITY_LEVEL_UNKNOWN /*-1*/:
                return z;
            case QUALITY_LEVEL_SD /*0*/:
            case QUALITY_LEVEL_HD /*1*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidQualityLevel(int i, boolean z) {
        switch (i) {
            case QUALITY_LEVEL_UNKNOWN /*-1*/:
                return z;
            case QUALITY_LEVEL_SD /*0*/:
            case QUALITY_LEVEL_HD /*1*/:
            case QUALITY_LEVEL_XHD /*2*/:
            case QUALITY_LEVEL_FULLHD /*3*/:
                return true;
            default:
                return false;
        }
    }

    public int getCaptureMode() {
        return this.zzbfm;
    }

    public int getQualityLevel() {
        return this.zzbft;
    }

    public String getStreamUrl() {
        return this.zzbfu;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        VideoConfigurationCreator.zza(this, parcel, i);
    }

    public String zzFR() {
        return this.zzbfv;
    }

    public String zzFS() {
        return this.zzbfw;
    }

    public String zzFT() {
        return this.zzbfx;
    }

    public boolean zzFU() {
        return this.zzbfy;
    }
}
