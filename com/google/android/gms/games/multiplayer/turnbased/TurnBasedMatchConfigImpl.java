package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzbdE;
    private final Bundle zzbdU;
    private final String[] zzbdV;
    private final int zzbed;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzbdE = builder.zzbdE;
        this.zzbed = builder.zzbed;
        this.zzbdU = builder.zzbdU;
        this.zzbdV = (String[]) builder.zzbdT.toArray(new String[builder.zzbdT.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzbdU;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzbdV;
    }

    public int getVariant() {
        return this.zzbdE;
    }

    public int zzFG() {
        return this.zzbed;
    }
}
