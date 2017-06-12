package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzbbI;
    private Handler zzbbJ;
    private boolean zzbbK;
    private HashMap<String, AtomicInteger> zzbbL;
    private int zzbbM;

    /* renamed from: com.google.android.gms.games.internal.events.EventIncrementCache.1 */
    class C08511 implements Runnable {
        final /* synthetic */ EventIncrementCache zzbbN;

        C08511(EventIncrementCache eventIncrementCache) {
            this.zzbbN = eventIncrementCache;
        }

        public void run() {
            this.zzbbN.zzER();
        }
    }

    public EventIncrementCache(Looper looper, int i) {
        this.zzbbI = new Object();
        this.zzbbJ = new Handler(looper);
        this.zzbbL = new HashMap();
        this.zzbbM = i;
    }

    private void zzER() {
        synchronized (this.zzbbI) {
            this.zzbbK = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzbbI) {
            for (Entry entry : this.zzbbL.entrySet()) {
                zzr((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzbbL.clear();
        }
    }

    protected abstract void zzr(String str, int i);

    public void zzv(String str, int i) {
        synchronized (this.zzbbI) {
            if (!this.zzbbK) {
                this.zzbbK = true;
                this.zzbbJ.postDelayed(new C08511(this), (long) this.zzbbM);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzbbL.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzbbL.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
