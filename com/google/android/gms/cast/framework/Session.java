package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzyu;

public abstract class Session {
    private static final zzyu zzaoQ;
    private final zza zzapA;
    private final zzm zzapz;

    private class zza extends com.google.android.gms.cast.framework.zzq.zza {
        final /* synthetic */ Session zzapB;

        private zza(Session session) {
            this.zzapB = session;
        }

        public void end(boolean z) {
            this.zzapB.end(z);
        }

        public long getSessionRemainingTimeMs() {
            return this.zzapB.getSessionRemainingTimeMs();
        }

        public void resume(Bundle bundle) {
            this.zzapB.resume(bundle);
        }

        public void start(Bundle bundle) {
            this.zzapB.start(bundle);
        }

        public int zzsd() {
            return 10084208;
        }

        public zzd zzss() {
            return zze.zzA(this.zzapB);
        }
    }

    static {
        zzaoQ = new zzyu("Session");
    }

    protected Session(Context context, String str, String str2) {
        this.zzapA = new zza();
        this.zzapz = zzwq.zza(context, str, str2, this.zzapA);
    }

    protected abstract void end(boolean z);

    public final String getCategory() {
        zzac.zzdn("Must be called from the main thread.");
        try {
            return this.zzapz.getCategory();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "getCategory", zzm.class.getSimpleName());
            return null;
        }
    }

    public final String getSessionId() {
        zzac.zzdn("Must be called from the main thread.");
        try {
            return this.zzapz.getSessionId();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "getSessionId", zzm.class.getSimpleName());
            return null;
        }
    }

    public long getSessionRemainingTimeMs() {
        zzac.zzdn("Must be called from the main thread.");
        return 0;
    }

    public boolean isConnected() {
        boolean z = false;
        zzac.zzdn("Must be called from the main thread.");
        try {
            z = this.zzapz.isConnected();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "isConnected", zzm.class.getSimpleName());
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z = false;
        zzac.zzdn("Must be called from the main thread.");
        try {
            z = this.zzapz.isConnecting();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "isConnecting", zzm.class.getSimpleName());
        }
        return z;
    }

    public boolean isDisconnected() {
        boolean z = true;
        zzac.zzdn("Must be called from the main thread.");
        try {
            z = this.zzapz.isDisconnected();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "isDisconnected", zzm.class.getSimpleName());
        }
        return z;
    }

    public boolean isDisconnecting() {
        boolean z = false;
        zzac.zzdn("Must be called from the main thread.");
        try {
            z = this.zzapz.isDisconnecting();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "isDisconnecting", zzm.class.getSimpleName());
        }
        return z;
    }

    public boolean isResuming() {
        boolean z = false;
        zzac.zzdn("Must be called from the main thread.");
        try {
            z = this.zzapz.isResuming();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "isResuming", zzm.class.getSimpleName());
        }
        return z;
    }

    public boolean isSuspended() {
        boolean z = false;
        zzac.zzdn("Must be called from the main thread.");
        try {
            z = this.zzapz.isSuspended();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "isSuspended", zzm.class.getSimpleName());
        }
        return z;
    }

    protected final void notifyFailedToResumeSession(int i) {
        try {
            this.zzapz.notifyFailedToResumeSession(i);
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "notifyFailedToResumeSession", zzm.class.getSimpleName());
        }
    }

    protected final void notifyFailedToStartSession(int i) {
        try {
            this.zzapz.notifyFailedToStartSession(i);
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "notifyFailedToStartSession", zzm.class.getSimpleName());
        }
    }

    protected final void notifySessionEnded(int i) {
        try {
            this.zzapz.notifySessionEnded(i);
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "notifySessionEnded", zzm.class.getSimpleName());
        }
    }

    protected final void notifySessionResumed(boolean z) {
        try {
            this.zzapz.notifySessionResumed(z);
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "notifySessionResumed", zzm.class.getSimpleName());
        }
    }

    protected final void notifySessionStarted(String str) {
        try {
            this.zzapz.notifySessionStarted(str);
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "notifySessionStarted", zzm.class.getSimpleName());
        }
    }

    protected final void notifySessionSuspended(int i) {
        try {
            this.zzapz.notifySessionSuspended(i);
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "notifySessionSuspended", zzm.class.getSimpleName());
        }
    }

    protected abstract void resume(Bundle bundle);

    protected abstract void start(Bundle bundle);

    public final zzd zzsp() {
        try {
            return this.zzapz.zzsp();
        } catch (Throwable e) {
            zzaoQ.zzb(e, "Unable to call %s on %s.", "getWrappedObject", zzm.class.getSimpleName());
            return null;
        }
    }
}
