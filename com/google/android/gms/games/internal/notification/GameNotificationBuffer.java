package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    public /* synthetic */ Object get(int i) {
        return zziL(i);
    }

    public GameNotification zziL(int i) {
        return new GameNotificationRef(this.zzazI, i);
    }
}
