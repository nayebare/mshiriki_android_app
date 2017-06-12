package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.social.Social;
import com.google.android.gms.games.social.Social.InviteUpdateResult;
import com.google.android.gms.games.social.Social.LoadInvitesResult;
import com.google.android.gms.internal.zzzv.zzb;

public class SocialImpl implements Social {

    private static abstract class SocialInviteUpdateImpl extends BaseGamesApiMethodImpl<InviteUpdateResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.SocialInviteUpdateImpl.1 */
        class C08161 implements InviteUpdateResult {
            final /* synthetic */ Status zzamf;

            C08161(SocialInviteUpdateImpl socialInviteUpdateImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public InviteUpdateResult zzaX(Status status) {
            return new C08161(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaX(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.1 */
    class C08061 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.2 */
    class C08072 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzp((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.3 */
    class C08083 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzr(this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.4 */
    class C08094 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzq((zzb) this, null);
        }
    }

    private static abstract class LoadSocialInvitesImpl extends BaseGamesApiMethodImpl<LoadInvitesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.LoadSocialInvitesImpl.1 */
        class C08151 implements LoadInvitesResult {
            final /* synthetic */ Status zzamf;

            C08151(LoadSocialInvitesImpl loadSocialInvitesImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        public LoadInvitesResult zzaW(Status status) {
            return new C08151(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaW(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.5 */
    class C08105 extends LoadSocialInvitesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.6 */
    class C08116 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.7 */
    class C08127 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.8 */
    class C08138 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzs(this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.9 */
    class C08149 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, null, false);
        }
    }
}
