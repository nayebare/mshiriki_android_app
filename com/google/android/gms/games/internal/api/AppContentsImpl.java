package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl.LoadsImpl.1 */
        class C07211 implements LoadAppContentResult {
            final /* synthetic */ Status zzamf;

            C07211(LoadsImpl loadsImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        public LoadAppContentResult zzar(Status status) {
            return new C07211(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzar(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl.1 */
    class C07201 extends LoadsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, 0, null, null, false);
        }
    }
}
