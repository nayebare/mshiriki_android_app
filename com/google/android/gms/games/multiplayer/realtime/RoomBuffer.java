package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer extends zzf<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzn(int i, int i2) {
        return zzr(i, i2);
    }

    protected Room zzr(int i, int i2) {
        return new RoomRef(this.zzazI, i, i2);
    }

    protected String zzwG() {
        return "external_match_id";
    }
}
