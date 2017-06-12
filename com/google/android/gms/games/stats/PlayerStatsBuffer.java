package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerStatsBuffer extends AbstractDataBuffer<PlayerStats> {
    public PlayerStatsBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zzji(i);
    }

    public PlayerStats zzji(int i) {
        return new PlayerStatsRef(this.zzazI, i);
    }
}
