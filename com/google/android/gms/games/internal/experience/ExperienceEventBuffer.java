package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends AbstractDataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zziD(i);
    }

    public ExperienceEvent zziD(int i) {
        return new ExperienceEventRef(this.zzazI, i);
    }
}
