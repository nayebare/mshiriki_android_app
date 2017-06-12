package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzbdZ;
    private final TurnBasedMatchBuffer zzbea;
    private final TurnBasedMatchBuffer zzbeb;
    private final TurnBasedMatchBuffer zzbec;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder zzc = zzc(bundle, 0);
        if (zzc != null) {
            this.zzbdZ = new InvitationBuffer(zzc);
        } else {
            this.zzbdZ = null;
        }
        zzc = zzc(bundle, 1);
        if (zzc != null) {
            this.zzbea = new TurnBasedMatchBuffer(zzc);
        } else {
            this.zzbea = null;
        }
        zzc = zzc(bundle, 2);
        if (zzc != null) {
            this.zzbeb = new TurnBasedMatchBuffer(zzc);
        } else {
            this.zzbeb = null;
        }
        zzc = zzc(bundle, 3);
        if (zzc != null) {
            this.zzbec = new TurnBasedMatchBuffer(zzc);
        } else {
            this.zzbec = null;
        }
    }

    private static DataHolder zzc(Bundle bundle, int i) {
        String zziC = TurnBasedMatchTurnStatus.zziC(i);
        return !bundle.containsKey(zziC) ? null : (DataHolder) bundle.getParcelable(zziC);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzbec;
    }

    public InvitationBuffer getInvitations() {
        return this.zzbdZ;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzbea;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzbeb;
    }

    public boolean hasData() {
        return (this.zzbdZ == null || this.zzbdZ.getCount() <= 0) ? (this.zzbea == null || this.zzbea.getCount() <= 0) ? (this.zzbeb == null || this.zzbeb.getCount() <= 0) ? this.zzbec != null && this.zzbec.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzbdZ != null) {
            this.zzbdZ.release();
        }
        if (this.zzbea != null) {
            this.zzbea.release();
        }
        if (this.zzbeb != null) {
            this.zzbeb.release();
        }
        if (this.zzbec != null) {
            this.zzbec.release();
        }
    }
}
