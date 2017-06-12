package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class MilestoneBuffer extends AbstractDataBuffer<Milestone> {
    public Milestone get(int i) {
        return new MilestoneRef(this.zzazI, i);
    }
}
