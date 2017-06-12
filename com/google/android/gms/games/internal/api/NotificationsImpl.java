package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1 */
    class C07511 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1.1 */
        class C07501 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status zzamf;
            final /* synthetic */ C07511 zzbba;

            C07501(C07511 c07511, Status status) {
                this.zzbba = c07511;
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, true);
        }

        public GameMuteStatusChangeResult zzaB(Status status) {
            return new C07501(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2 */
    class C07532 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2.1 */
        class C07521 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status zzamf;
            final /* synthetic */ C07532 zzbbb;

            C07521(C07532 c07532, Status status) {
                this.zzbbb = c07532;
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, false);
        }

        public GameMuteStatusChangeResult zzaB(Status status) {
            return new C07521(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3 */
    class C07553 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3.1 */
        class C07541 implements GameMuteStatusLoadResult {
            final /* synthetic */ Status zzamf;
            final /* synthetic */ C07553 zzbbc;

            C07541(C07553 c07553, Status status) {
                this.zzbbc = c07553;
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, null);
        }

        public GameMuteStatusLoadResult zzaC(Status status) {
            return new C07541(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaC(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1 */
        class C07591 implements ContactSettingLoadResult {
            final /* synthetic */ Status zzamf;

            C07591(ContactSettingLoadImpl contactSettingLoadImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public ContactSettingLoadResult zzaD(Status status) {
            return new C07591(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaD(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.4 */
    class C07564 extends ContactSettingLoadImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl((zzb) this, false);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.5 */
    class C07575 extends ContactSettingUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, false, null);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1 */
        class C07601 implements InboxCountResult {
            final /* synthetic */ Status zzamf;

            C07601(InboxCountImpl inboxCountImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public InboxCountResult zzaE(Status status) {
            return new C07601(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaE(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.6 */
    class C07586 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzs(this);
        }
    }

    public void clear(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zziz(i);
        }
    }

    public void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, 63);
    }
}
