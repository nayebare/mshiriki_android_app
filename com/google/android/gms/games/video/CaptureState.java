package com.google.android.gms.games.video;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public final class CaptureState {
    private final boolean zzapK;
    private final boolean zzbfl;
    private final int zzbfm;
    private final int zzbfn;
    private final boolean zzui;

    private CaptureState(boolean z, int i, int i2, boolean z2, boolean z3) {
        zzac.zzas(VideoConfiguration.isValidCaptureMode(i, true));
        zzac.zzas(VideoConfiguration.isValidQualityLevel(i2, true));
        this.zzbfl = z;
        this.zzbfm = i;
        this.zzbfn = i2;
        this.zzapK = z2;
        this.zzui = z3;
    }

    public static CaptureState zzC(Bundle bundle) {
        return (bundle == null || bundle.get("IsCapturing") == null) ? null : new CaptureState(bundle.getBoolean("IsCapturing", false), bundle.getInt("CaptureMode", -1), bundle.getInt("CaptureQuality", -1), bundle.getBoolean("IsOverlayVisible", false), bundle.getBoolean("IsPaused", false));
    }

    public int getCaptureMode() {
        return this.zzbfm;
    }

    public int getCaptureQuality() {
        return this.zzbfn;
    }

    public boolean isCapturing() {
        return this.zzbfl;
    }

    public boolean isOverlayVisible() {
        return this.zzapK;
    }

    public boolean isPaused() {
        return this.zzui;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("IsCapturing", Boolean.valueOf(this.zzbfl)).zzg("CaptureMode", Integer.valueOf(this.zzbfm)).zzg("CaptureQuality", Integer.valueOf(this.zzbfn)).zzg("IsOverlayVisible", Boolean.valueOf(this.zzapK)).zzg("IsPaused", Boolean.valueOf(this.zzui)).toString();
    }
}
