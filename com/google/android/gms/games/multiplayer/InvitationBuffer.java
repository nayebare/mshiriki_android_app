package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class InvitationBuffer extends zzf<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzn(int i, int i2) {
        return zzq(i, i2);
    }

    protected Invitation zzq(int i, int i2) {
        return new InvitationRef(this.zzazI, i, i2);
    }

    protected String zzwG() {
        return "external_invitation_id";
    }
}
