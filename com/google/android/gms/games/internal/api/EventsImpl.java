package com.google.android.gms.games.internal.api;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1 */
        class C07251 implements LoadEventsResult {
            final /* synthetic */ Status zzamf;

            C07251(LoadImpl loadImpl, Status status) {
                this.zzamf = status;
            }

            public EventBuffer getEvents() {
                return new EventBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult zzas(Status status) {
            return new C07251(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzas(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.1 */
    class C07221 extends LoadImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ String[] zzbaO;

        C07221(EventsImpl eventsImpl, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
            this.zzbaL = z;
            this.zzbaO = strArr;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaL, this.zzbaO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.2 */
    class C07232 extends LoadImpl {
        final /* synthetic */ boolean zzbaL;

        C07232(EventsImpl eventsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzbaL);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1 */
        class C07261 implements Result {
            final /* synthetic */ Status zzamf;

            C07261(UpdateImpl updateImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzc(Status status) {
            return new C07261(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.3 */
    class C07243 extends UpdateImpl {
        final /* synthetic */ String zzbaP;
        final /* synthetic */ int zzbaQ;

        C07243(EventsImpl eventsImpl, GoogleApiClient googleApiClient, String str, int i) {
            this.zzbaP = str;
            this.zzbaQ = i;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzo(this.zzbaP, this.zzbaQ);
        }
    }

    @SuppressLint({"MissingRemoteException"})
    public void increment(GoogleApiClient googleApiClient, String str, int i) {
        GamesClientImpl zzc = Games.zzc(googleApiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzo(str, i);
            } else {
                googleApiClient.zzb(new C07243(this, googleApiClient, str, i));
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C07232(this, googleApiClient, z));
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.zza(new C07221(this, googleApiClient, z, strArr));
    }
}
