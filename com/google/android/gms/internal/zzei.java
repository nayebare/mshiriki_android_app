package com.google.android.gms.internal;

import com.google.android.gms.internal.zzet.zza;
import java.util.Random;

@zzmb
public class zzei extends zza {
    private Object zzrN;
    private final Random zzzI;
    private long zzzJ;

    public zzei() {
        this.zzrN = new Object();
        this.zzzI = new Random();
        zzeQ();
    }

    public long getValue() {
        return this.zzzJ;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzeQ() {
        /*
        r8 = this;
        r4 = 0;
        r3 = r8.zzrN;
        monitor-enter(r3);
        r0 = 3;
        r2 = r0;
        r0 = r4;
    L_0x0008:
        r2 = r2 + -1;
        if (r2 <= 0) goto L_0x0023;
    L_0x000c:
        r0 = r8.zzzI;	 Catch:{ all -> 0x0027 }
        r0 = r0.nextInt();	 Catch:{ all -> 0x0027 }
        r0 = (long) r0;	 Catch:{ all -> 0x0027 }
        r6 = 2147483648; // 0x80000000 float:-0.0 double:1.0609978955E-314;
        r0 = r0 + r6;
        r6 = r8.zzzJ;	 Catch:{ all -> 0x0027 }
        r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r6 == 0) goto L_0x0008;
    L_0x001f:
        r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r6 == 0) goto L_0x0008;
    L_0x0023:
        r8.zzzJ = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        return;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzei.zzeQ():void");
    }
}
