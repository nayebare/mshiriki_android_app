package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int zzbdE;
        ArrayList<String> zzbdT;
        Bundle zzbdU;
        int zzbed;

        private Builder() {
            this.zzbdE = -1;
            this.zzbdT = new ArrayList();
            this.zzbdU = null;
            this.zzbed = 2;
        }

        public Builder addInvitedPlayer(String str) {
            zzac.zzw(str);
            this.zzbdT.add(str);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> arrayList) {
            zzac.zzw(arrayList);
            this.zzbdT.addAll(arrayList);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzbdU = bundle;
            return this;
        }

        public Builder setVariant(int i) {
            boolean z = i == -1 || i > 0;
            zzac.zzb(z, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.zzbdE = i;
            return this;
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zzFG();
}
