package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {

    public static final class Builder {
        int zzbdE;
        final RoomUpdateListener zzbdP;
        RoomStatusUpdateListener zzbdQ;
        RealTimeMessageReceivedListener zzbdR;
        String zzbdS;
        ArrayList<String> zzbdT;
        Bundle zzbdU;

        private Builder(RoomUpdateListener roomUpdateListener) {
            this.zzbdS = null;
            this.zzbdE = -1;
            this.zzbdT = new ArrayList();
            this.zzbdP = (RoomUpdateListener) zzac.zzb((Object) roomUpdateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> arrayList) {
            zzac.zzw(arrayList);
            this.zzbdT.addAll(arrayList);
            return this;
        }

        public Builder addPlayersToInvite(String... strArr) {
            zzac.zzw(strArr);
            this.zzbdT.addAll(Arrays.asList(strArr));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzbdU = bundle;
            return this;
        }

        public Builder setInvitationIdToAccept(String str) {
            zzac.zzw(str);
            this.zzbdS = str;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.zzbdR = realTimeMessageReceivedListener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.zzbdQ = roomStatusUpdateListener;
            return this;
        }

        public Builder setVariant(int i) {
            boolean z = i == -1 || i > 0;
            zzac.zzb(z, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzbdE = i;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(null);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();
}
