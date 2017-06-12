package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.zzzv.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1 */
        class C07951 implements UpdateRequestsResult {
            final /* synthetic */ Status zzamf;

            C07951(UpdateRequestsImpl updateRequestsImpl, Status status) {
                this.zzamf = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String str) {
                String str2 = "Unknown request ID ";
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult zzaR(Status status) {
            return new C07951(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaR(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.1 */
    class C07841 extends UpdateRequestsImpl {
        final /* synthetic */ String[] zzbbi;

        C07841(RequestsImpl requestsImpl, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzbbi = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbbi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.2 */
    class C07852 extends UpdateRequestsImpl {
        final /* synthetic */ String[] zzbbi;

        C07852(RequestsImpl requestsImpl, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzbbi = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzbbi);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1 */
        class C07931 implements LoadRequestsResult {
            final /* synthetic */ Status zzamf;

            C07931(LoadRequestsImpl loadRequestsImpl, Status status) {
                this.zzamf = status;
            }

            public GameRequestBuffer getRequests(int i) {
                return new GameRequestBuffer(DataHolder.zzcD(this.zzamf.getStatusCode()));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult zzaP(Status status) {
            return new C07931(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaP(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.3 */
    class C07863 extends LoadRequestsImpl {
        final /* synthetic */ int zzbaR;
        final /* synthetic */ int zzbbj;
        final /* synthetic */ int zzbbk;

        C07863(RequestsImpl requestsImpl, GoogleApiClient googleApiClient, int i, int i2, int i3) {
            this.zzbbj = i;
            this.zzbbk = i2;
            this.zzbaR = i3;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbj, this.zzbbk, this.zzbaR);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1 */
        class C07941 implements SendRequestResult {
            final /* synthetic */ Status zzamf;

            C07941(SendRequestImpl sendRequestImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public SendRequestResult zzaQ(Status status) {
            return new C07941(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaQ(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.4 */
    class C07874 extends SendRequestImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, 0, null, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.5 */
    class C07885 extends SendRequestImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, 0, null, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.6 */
    class C07896 extends UpdateRequestsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.7 */
    class C07907 extends LoadRequestsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, 0, 0, 0);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1 */
        class C07921 implements LoadRequestSummariesResult {
            final /* synthetic */ Status zzamf;

            C07921(LoadRequestSummariesImpl loadRequestSummariesImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        public LoadRequestSummariesResult zzaO(Status status) {
            return new C07921(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaO(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.8 */
    class C07918 extends LoadRequestSummariesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this, null, 0);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.zzb(new C07841(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.zzb(new C07852(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) bundle.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent intent) {
        return intent == null ? new ArrayList() : getGameRequestsFromBundle(intent.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEq();
    }

    public int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEs();
    }

    public int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEr();
    }

    public Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.zzi(googleApiClient).zza(i, bArr, i2, bitmap, str);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient googleApiClient, int i, int i2, int i3) {
        return googleApiClient.zza(new C07863(this, googleApiClient, i, i2, i3));
    }

    public void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzd(googleApiClient.zzr(onRequestReceivedListener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEl();
        }
    }
}
