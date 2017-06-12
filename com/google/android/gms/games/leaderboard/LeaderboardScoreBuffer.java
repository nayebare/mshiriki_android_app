package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzbcZ;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzbcZ = new LeaderboardScoreBufferHeader(dataHolder.zzwy());
    }

    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.zzazI, i);
    }

    public LeaderboardScoreBufferHeader zzFA() {
        return this.zzbcZ;
    }
}
