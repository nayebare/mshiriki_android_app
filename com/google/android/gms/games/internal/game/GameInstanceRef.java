package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.constants.PlatformType;

public final class GameInstanceRef extends zzc implements GameInstance {
    GameInstanceRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public String toString() {
        return zzaa.zzv(this).zzg("ApplicationId", getApplicationId()).zzg("DisplayName", getDisplayName()).zzg("SupportsRealTime", Boolean.valueOf(zzFb())).zzg("SupportsTurnBased", Boolean.valueOf(zzFc())).zzg("PlatformType", PlatformType.zziC(zzBy())).zzg("PackageName", getPackageName()).zzg("PiracyCheckEnabled", Boolean.valueOf(zzFd())).zzg("Installed", Boolean.valueOf(zzFe())).toString();
    }

    public int zzBy() {
        return getInteger("platform_type");
    }

    public boolean zzFb() {
        return getInteger("real_time_support") > 0;
    }

    public boolean zzFc() {
        return getInteger("turn_based_support") > 0;
    }

    public boolean zzFd() {
        return getInteger("piracy_check") > 0;
    }

    public boolean zzFe() {
        return getInteger("installed") > 0;
    }
}
