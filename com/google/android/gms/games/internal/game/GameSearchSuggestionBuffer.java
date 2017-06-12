package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameSearchSuggestionBuffer extends AbstractDataBuffer<GameSearchSuggestion> {
    public GameSearchSuggestionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int i) {
        return zziI(i);
    }

    public GameSearchSuggestion zziI(int i) {
        return new GameSearchSuggestionRef(this.zzazI, i);
    }
}
