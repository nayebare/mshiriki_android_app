package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1 */
        class C07181 implements LoadAchievementsResult {
            final /* synthetic */ Status zzamf;

            C07181(LoadImpl loadImpl, Status status) {
                this.zzamf = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.zzcD(14));
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

        public LoadAchievementsResult zzap(Status status) {
            return new C07181(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzap(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.10 */
    class AnonymousClass10 extends LoadImpl {
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.1 */
    class C07091 extends LoadImpl {
        final /* synthetic */ boolean zzbaL;

        C07091(AchievementsImpl achievementsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzbaL);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String zzGu;

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1 */
        class C07191 implements UpdateAchievementResult {
            final /* synthetic */ Status zzamf;
            final /* synthetic */ UpdateImpl zzbaN;

            C07191(UpdateImpl updateImpl, Status status) {
                this.zzbaN = updateImpl;
                this.zzamf = status;
            }

            public String getAchievementId() {
                return this.zzbaN.zzGu;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzGu = str;
        }

        public UpdateAchievementResult zzaq(Status status) {
            return new C07191(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaq(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.2 */
    class C07102 extends UpdateImpl {
        final /* synthetic */ String val$id;

        C07102(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.val$id = str2;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, this.val$id);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.3 */
    class C07113 extends UpdateImpl {
        final /* synthetic */ String val$id;

        C07113(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.val$id = str2;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.val$id);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.4 */
    class C07124 extends UpdateImpl {
        final /* synthetic */ String val$id;

        C07124(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.val$id = str2;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(null, this.val$id);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.5 */
    class C07135 extends UpdateImpl {
        final /* synthetic */ String val$id;

        C07135(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.val$id = str2;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.val$id);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.6 */
    class C07146 extends UpdateImpl {
        final /* synthetic */ String val$id;
        final /* synthetic */ int zzbaM;

        C07146(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.val$id = str2;
            this.zzbaM = i;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, this.val$id, this.zzbaM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.7 */
    class C07157 extends UpdateImpl {
        final /* synthetic */ String val$id;
        final /* synthetic */ int zzbaM;

        C07157(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.val$id = str2;
            this.zzbaM = i;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.val$id, this.zzbaM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.8 */
    class C07168 extends UpdateImpl {
        final /* synthetic */ String val$id;
        final /* synthetic */ int zzbaM;

        C07168(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.val$id = str2;
            this.zzbaM = i;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(null, this.val$id, this.zzbaM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.9 */
    class C07179 extends UpdateImpl {
        final /* synthetic */ String val$id;
        final /* synthetic */ int zzbaM;

        C07179(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.val$id = str2;
            this.zzbaM = i;
            super(str, googleApiClient);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.val$id, this.zzbaM);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEf();
    }

    public void increment(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.zzb(new C07146(this, str, googleApiClient, str, i));
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.zzb(new C07157(this, str, googleApiClient, str, i));
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C07091(this, googleApiClient, z));
    }

    public void reveal(GoogleApiClient googleApiClient, String str) {
        googleApiClient.zzb(new C07102(this, str, googleApiClient, str));
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C07113(this, str, googleApiClient, str));
    }

    public void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.zzb(new C07168(this, str, googleApiClient, str, i));
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.zzb(new C07179(this, str, googleApiClient, str, i));
    }

    public void unlock(GoogleApiClient googleApiClient, String str) {
        googleApiClient.zzb(new C07124(this, str, googleApiClient, str));
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C07135(this, str, googleApiClient, str));
    }
}
