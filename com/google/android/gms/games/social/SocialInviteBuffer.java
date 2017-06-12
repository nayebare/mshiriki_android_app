package com.google.android.gms.games.social;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public class SocialInviteBuffer extends AbstractDataBuffer<SocialInvite> {
    public SocialInviteBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zzjg(i);
    }

    public SocialInvite zzjg(int i) {
        return new SocialInviteRef(this.zzazI, i);
    }
}
