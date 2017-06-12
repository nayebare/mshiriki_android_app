package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class VideoCapabilities extends GamesAbstractSafeParcelable {
    public static final Creator<VideoCapabilities> CREATOR;
    private final int mVersionCode;
    private final boolean zzbfo;
    private final boolean zzbfp;
    private final boolean zzbfq;
    private final boolean[] zzbfr;
    private final boolean[] zzbfs;

    static {
        CREATOR = new VideoCapabilitiesCreator();
    }

    public VideoCapabilities(int i, boolean z, boolean z2, boolean z3, boolean[] zArr, boolean[] zArr2) {
        this.mVersionCode = i;
        this.zzbfo = z;
        this.zzbfp = z2;
        this.zzbfq = z3;
        this.zzbfr = zArr;
        this.zzbfs = zArr2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return zzaa.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && zzaa.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && zzaa.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && zzaa.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && zzaa.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public boolean[] getSupportedCaptureModes() {
        return this.zzbfr;
    }

    public boolean[] getSupportedQualityLevels() {
        return this.zzbfs;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public boolean isCameraSupported() {
        return this.zzbfo;
    }

    public boolean isFullySupported(int i, int i2) {
        return this.zzbfo && this.zzbfp && this.zzbfq && supportsCaptureMode(i) && supportsQualityLevel(i2);
    }

    public boolean isMicSupported() {
        return this.zzbfp;
    }

    public boolean isWriteStorageSupported() {
        return this.zzbfq;
    }

    public boolean supportsCaptureMode(int i) {
        zzac.zzar(VideoConfiguration.isValidCaptureMode(i, false));
        return this.zzbfr[i];
    }

    public boolean supportsQualityLevel(int i) {
        zzac.zzar(VideoConfiguration.isValidQualityLevel(i, false));
        return this.zzbfs[i];
    }

    public String toString() {
        return zzaa.zzv(this).zzg("SupportedCaptureModes", getSupportedCaptureModes()).zzg("SupportedQualityLevels", getSupportedQualityLevels()).zzg("CameraSupported", Boolean.valueOf(isCameraSupported())).zzg("MicSupported", Boolean.valueOf(isMicSupported())).zzg("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        VideoCapabilitiesCreator.zza(this, parcel, i);
    }
}
