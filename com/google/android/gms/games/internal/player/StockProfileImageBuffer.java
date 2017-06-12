package com.google.android.gms.games.internal.player;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public class StockProfileImageBuffer extends AbstractDataBuffer<StockProfileImage> {
    public StockProfileImageBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zziO(i);
    }

    public StockProfileImage zziO(int i) {
        return new StockProfileImageRef(this.zzazI, i);
    }
}
