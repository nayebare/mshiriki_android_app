package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzbbO;

    public EventIncrementManager() {
        this.zzbbO = new AtomicReference();
    }

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzbbO.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    protected abstract EventIncrementCache zzEz();

    public void zzo(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzbbO.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zzEz();
            if (!this.zzbbO.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.zzbbO.get();
            }
        }
        eventIncrementCache.zzv(str, i);
    }
}
