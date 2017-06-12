package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.cast.framework.zzo.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public class zzr<T extends Session> extends zza {
    private final SessionManagerListener<T> zzapD;
    private final Class<T> zzapE;

    public zzr(@NonNull SessionManagerListener<T> sessionManagerListener, @NonNull Class<T> cls) {
        this.zzapD = sessionManagerListener;
        this.zzapE = cls;
    }

    public void zzA(@NonNull zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionEnding((Session) this.zzapE.cast(session));
        }
    }

    public void zza(@NonNull zzd com_google_android_gms_dynamic_zzd, boolean z) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionResumed((Session) this.zzapE.cast(session), z);
        }
    }

    public void zzd(@NonNull zzd com_google_android_gms_dynamic_zzd, int i) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionStartFailed((Session) this.zzapE.cast(session), i);
        }
    }

    public void zzd(@NonNull zzd com_google_android_gms_dynamic_zzd, String str) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionStarted((Session) this.zzapE.cast(session), str);
        }
    }

    public void zze(@NonNull zzd com_google_android_gms_dynamic_zzd, int i) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionEnded((Session) this.zzapE.cast(session), i);
        }
    }

    public void zze(@NonNull zzd com_google_android_gms_dynamic_zzd, String str) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionResuming((Session) this.zzapE.cast(session), str);
        }
    }

    public void zzf(@NonNull zzd com_google_android_gms_dynamic_zzd, int i) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionResumeFailed((Session) this.zzapE.cast(session), i);
        }
    }

    public void zzg(@NonNull zzd com_google_android_gms_dynamic_zzd, int i) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionSuspended((Session) this.zzapE.cast(session), i);
        }
    }

    public int zzsd() {
        return 10084208;
    }

    public zzd zzse() {
        return zze.zzA(this.zzapD);
    }

    public void zzz(@NonNull zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
        Session session = (Session) zze.zzE(com_google_android_gms_dynamic_zzd);
        if (this.zzapE.isInstance(session)) {
            this.zzapD.onSessionStarting((Session) this.zzapE.cast(session));
        }
    }
}
