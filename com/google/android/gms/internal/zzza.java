package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzza implements CastRemoteDisplayApi {
    private static final zzyu zzamu;
    private Api<?> zzawb;
    private VirtualDisplay zzawc;
    private final zzze zzawd;

    /* renamed from: com.google.android.gms.internal.zzza.1 */
    class C12921 extends com.google.android.gms.internal.zzze.zza {
        final /* synthetic */ zzza zzawe;

        C12921(zzza com_google_android_gms_internal_zzza) {
            this.zzawe = com_google_android_gms_internal_zzza;
        }

        public void zzcm(int i) {
            zzza.zzamu.zzb("onRemoteDisplayEnded", new Object[0]);
            this.zzawe.zzur();
        }
    }

    abstract class zzb extends com.google.android.gms.internal.zzzv.zza<CastRemoteDisplaySessionResult, zzzb> {
        final /* synthetic */ zzza zzawe;

        public zzb(zzza com_google_android_gms_internal_zzza, GoogleApiClient googleApiClient) {
            this.zzawe = com_google_android_gms_internal_zzza;
            super(com_google_android_gms_internal_zzza.zzawb, googleApiClient);
        }

        public void zza(zzzb com_google_android_gms_internal_zzzb) throws RemoteException {
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzu(status);
        }

        protected CastRemoteDisplaySessionResult zzu(Status status) {
            return new zzc(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzza.2 */
    class C12932 extends zzb {
        final /* synthetic */ zzza zzawe;
        final /* synthetic */ String zzta;

        C12932(zzza com_google_android_gms_internal_zzza, GoogleApiClient googleApiClient, String str) {
            this.zzawe = com_google_android_gms_internal_zzza;
            this.zzta = str;
            super(com_google_android_gms_internal_zzza, googleApiClient);
        }

        public void zza(zzzb com_google_android_gms_internal_zzzb) throws RemoteException {
            com_google_android_gms_internal_zzzb.zza(new zza(this, com_google_android_gms_internal_zzzb), this.zzawe.zzawd, this.zzta);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzza.3 */
    class C12943 extends zzb {
        C12943(zzza com_google_android_gms_internal_zzza, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_internal_zzza, googleApiClient);
        }

        public void zza(zzzb com_google_android_gms_internal_zzzb) throws RemoteException {
            com_google_android_gms_internal_zzzb.zza(new zzb(this));
        }
    }

    abstract class zza extends com.google.android.gms.internal.zzzc.zza {
        zza(zzza com_google_android_gms_internal_zzza) {
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int i) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzut() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private static final class zzc implements CastRemoteDisplaySessionResult {
        private final Display zzNI;
        private final Status zzahq;

        public zzc(Display display) {
            this.zzahq = Status.zzayh;
            this.zzNI = display;
        }

        public zzc(Status status) {
            this.zzahq = status;
            this.zzNI = null;
        }

        public Display getPresentationDisplay() {
            return this.zzNI;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static {
        zzamu = new zzyu("CastRemoteDisplayApiImpl");
    }

    public zzza(Api api) {
        this.zzawd = new C12921(this);
        this.zzawb = api;
    }

    @TargetApi(19)
    private void zzur() {
        if (this.zzawc != null) {
            if (this.zzawc.getDisplay() != null) {
                zzamu.zzb("releasing virtual display: " + this.zzawc.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzawc.release();
            this.zzawc = null;
        }
    }

    public PendingResult<CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zzamu.zzb("startRemoteDisplay", new Object[0]);
        return googleApiClient.zzb(new C12932(this, googleApiClient, str));
    }

    public PendingResult<CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zzamu.zzb("stopRemoteDisplay", new Object[0]);
        return googleApiClient.zzb(new C12943(this, googleApiClient));
    }
}
