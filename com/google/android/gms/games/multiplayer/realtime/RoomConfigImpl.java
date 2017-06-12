package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final String zzahi;
    private final int zzbdE;
    private final RoomUpdateListener zzbdP;
    private final RoomStatusUpdateListener zzbdQ;
    private final RealTimeMessageReceivedListener zzbdR;
    private final Bundle zzbdU;
    private final String[] zzbdV;

    RoomConfigImpl(Builder builder) {
        this.zzbdP = builder.zzbdP;
        this.zzbdQ = builder.zzbdQ;
        this.zzbdR = builder.zzbdR;
        this.zzahi = builder.zzbdS;
        this.zzbdE = builder.zzbdE;
        this.zzbdU = builder.zzbdU;
        this.zzbdV = (String[]) builder.zzbdT.toArray(new String[builder.zzbdT.size()]);
        zzac.zzb(this.zzbdR, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzbdU;
    }

    public String getInvitationId() {
        return this.zzahi;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzbdV;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzbdR;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzbdQ;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzbdP;
    }

    public int getVariant() {
        return this.zzbdE;
    }
}
