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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1 */
        class C07811 implements AcceptQuestResult {
            final /* synthetic */ Status zzamf;

            C07811(AcceptImpl acceptImpl, Status status) {
                this.zzamf = status;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public AcceptQuestResult zzaL(Status status) {
            return new C07811(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaL(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.1 */
    class C07751 extends AcceptImpl {
        final /* synthetic */ String zzbbe;

        C07751(QuestsImpl questsImpl, GoogleApiClient googleApiClient, String str) {
            this.zzbbe = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzbbe);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1 */
        class C07821 implements ClaimMilestoneResult {
            final /* synthetic */ Status zzamf;

            C07821(ClaimImpl claimImpl, Status status) {
                this.zzamf = status;
            }

            public Milestone getMilestone() {
                return null;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public ClaimMilestoneResult zzaM(Status status) {
            return new C07821(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaM(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.2 */
    class C07762 extends ClaimImpl {
        final /* synthetic */ String zzbbe;
        final /* synthetic */ String zzbbf;

        C07762(QuestsImpl questsImpl, GoogleApiClient googleApiClient, String str, String str2) {
            this.zzbbe = str;
            this.zzbbf = str2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbbe, this.zzbbf);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1 */
        class C07831 implements LoadQuestsResult {
            final /* synthetic */ Status zzamf;

            C07831(LoadsImpl loadsImpl, Status status) {
                this.zzamf = status;
            }

            public QuestBuffer getQuests() {
                return new QuestBuffer(DataHolder.zzcD(this.zzamf.getStatusCode()));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadQuestsResult zzaN(Status status) {
            return new C07831(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaN(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.3 */
    class C07773 extends LoadsImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ int zzbaR;
        final /* synthetic */ int[] zzbbg;

        C07773(QuestsImpl questsImpl, GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
            this.zzbbg = iArr;
            this.zzbaR = i;
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbg, this.zzbaR, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.4 */
    class C07784 extends LoadsImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ String[] zzbbh;

        C07784(QuestsImpl questsImpl, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
            this.zzbaL = z;
            this.zzbbh = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbaL, this.zzbbh);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.5 */
    class C07795 extends LoadsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, null, 0, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.6 */
    class C07806 extends LoadsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, false, null);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C07751(this, googleApiClient, str));
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.zzb(new C07762(this, googleApiClient, str, str2));
    }

    public Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.zzi(googleApiClient).zzer(str);
    }

    public Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.zzi(googleApiClient).zzc(iArr);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        return googleApiClient.zza(new C07773(this, googleApiClient, iArr, i, z));
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.zza(new C07784(this, googleApiClient, z, strArr));
    }

    public void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzc(googleApiClient.zzr(questUpdateListener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzes(str);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEk();
        }
    }
}
