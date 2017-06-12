package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerBuffer extends AbstractDataBuffer<Player> {
    public PlayerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Player get(int i) {
        return new PlayerRef(this.zzazI, i);
    }
}
