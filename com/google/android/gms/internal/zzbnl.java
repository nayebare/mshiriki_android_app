package com.google.android.gms.internal;

public class zzbnl implements zzbnj {
    public final long zzceX;

    public zzbnl(long j) {
        this.zzceX = j;
    }

    public float zzXV() {
        return 0.2f;
    }

    public long zzXW() {
        return 1000;
    }

    public boolean zzaN(long j) {
        return j > 1000;
    }

    public boolean zzi(long j, long j2) {
        return j > this.zzceX || j2 > 1000;
    }
}
