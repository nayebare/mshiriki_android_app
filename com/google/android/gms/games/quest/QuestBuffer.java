package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class QuestBuffer extends zzf<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzn(int i, int i2) {
        return zzt(i, i2);
    }

    protected Quest zzt(int i, int i2) {
        return new QuestRef(this.zzazI, i, i2);
    }

    protected String zzwG() {
        return "external_quest_id";
    }
}
