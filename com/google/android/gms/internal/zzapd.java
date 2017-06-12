package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzbb;
import com.google.android.gms.fitness.request.zzbd;
import com.google.android.gms.fitness.request.zzbf;
import com.google.android.gms.fitness.request.zzbh;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzapd implements SessionsApi {

    /* renamed from: com.google.android.gms.internal.zzapd.1 */
    class C09901 extends zzc {
        final /* synthetic */ Session zzaUG;

        C09901(zzapd com_google_android_gms_internal_zzapd, GoogleApiClient googleApiClient, Session session) {
            this.zzaUG = session;
            super(googleApiClient);
        }

        protected void zza(zzanx com_google_android_gms_internal_zzanx) throws RemoteException {
            ((zzaom) com_google_android_gms_internal_zzanx.zzwW()).zza(new zzbd(this.zzaUG, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapd.2 */
    class C09912 extends zza<SessionStopResult> {
        final /* synthetic */ String val$name;
        final /* synthetic */ String zzaUH;

        C09912(zzapd com_google_android_gms_internal_zzapd, GoogleApiClient googleApiClient, String str, String str2) {
            this.val$name = str;
            this.zzaUH = str2;
            super(googleApiClient);
        }

        protected void zza(zzanx com_google_android_gms_internal_zzanx) throws RemoteException {
            ((zzaom) com_google_android_gms_internal_zzanx.zzwW()).zza(new zzbf(this.val$name, this.zzaUH, new zzb(null)));
        }

        protected SessionStopResult zzaa(Status status) {
            return SessionStopResult.zzai(status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaa(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapd.3 */
    class C09923 extends zzc {
        final /* synthetic */ SessionInsertRequest zzaUI;

        C09923(zzapd com_google_android_gms_internal_zzapd, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
            this.zzaUI = sessionInsertRequest;
            super(googleApiClient);
        }

        protected void zza(zzanx com_google_android_gms_internal_zzanx) throws RemoteException {
            ((zzaom) com_google_android_gms_internal_zzanx.zzwW()).zza(new SessionInsertRequest(this.zzaUI, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapd.4 */
    class C09934 extends zza<SessionReadResult> {
        final /* synthetic */ SessionReadRequest zzaUJ;

        C09934(zzapd com_google_android_gms_internal_zzapd, GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
            this.zzaUJ = sessionReadRequest;
            super(googleApiClient);
        }

        protected void zza(zzanx com_google_android_gms_internal_zzanx) throws RemoteException {
            ((zzaom) com_google_android_gms_internal_zzanx.zzwW()).zza(new SessionReadRequest(this.zzaUJ, new zza(null)));
        }

        protected SessionReadResult zzab(Status status) {
            return SessionReadResult.zzah(status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzab(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapd.5 */
    class C09945 extends zzc {
        final /* synthetic */ PendingIntent zzaUB;
        final /* synthetic */ int zzaUK;

        C09945(zzapd com_google_android_gms_internal_zzapd, GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
            this.zzaUB = pendingIntent;
            this.zzaUK = i;
            super(googleApiClient);
        }

        protected void zza(zzanx com_google_android_gms_internal_zzanx) throws RemoteException {
            ((zzaom) com_google_android_gms_internal_zzanx.zzwW()).zza(new zzbb(this.zzaUB, new zzape(this), this.zzaUK));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzapd.6 */
    class C09956 extends zzc {
        final /* synthetic */ PendingIntent zzaUB;

        C09956(zzapd com_google_android_gms_internal_zzapd, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaUB = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzanx com_google_android_gms_internal_zzanx) throws RemoteException {
            ((zzaom) com_google_android_gms_internal_zzanx.zzwW()).zza(new zzbh(this.zzaUB, new zzape(this)));
        }
    }

    private static class zza extends com.google.android.gms.internal.zzaoq.zza {
        private final com.google.android.gms.internal.zzzv.zzb<SessionReadResult> zzaFq;

        private zza(com.google.android.gms.internal.zzzv.zzb<SessionReadResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzaFq.setResult(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzaor.zza {
        private final com.google.android.gms.internal.zzzv.zzb<SessionStopResult> zzaFq;

        private zzb(com.google.android.gms.internal.zzzv.zzb<SessionStopResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzaFq.setResult(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.zzb(new C09912(this, googleApiClient, str, str2));
    }

    public PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.zza(new C09923(this, googleApiClient, sessionInsertRequest));
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
        return googleApiClient.zza(new C09934(this, googleApiClient, sessionReadRequest));
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, pendingIntent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session) {
        zzac.zzb((Object) session, (Object) "Session cannot be null");
        zzac.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return googleApiClient.zzb(new C09901(this, googleApiClient, session));
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, null, str);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C09956(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
        return googleApiClient.zzb(new C09945(this, googleApiClient, pendingIntent, i));
    }
}
