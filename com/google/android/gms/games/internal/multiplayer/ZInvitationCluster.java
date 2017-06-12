package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster extends GamesAbstractSafeParcelable implements Invitation {
    public static final Creator<ZInvitationCluster> CREATOR;
    private final int mVersionCode;
    private final ArrayList<InvitationEntity> zzbbY;

    static {
        CREATOR = new InvitationClusterCreator();
    }

    ZInvitationCluster(int i, ArrayList<InvitationEntity> arrayList) {
        this.mVersionCode = i;
        this.zzbbY = arrayList;
        zzFg();
    }

    private void zzFg() {
        zzc.zzar(!this.zzbbY.isEmpty());
        Invitation invitation = (Invitation) this.zzbbY.get(0);
        int size = this.zzbbY.size();
        for (int i = 1; i < size; i++) {
            zzc.zza(invitation.getInviter().equals(((Invitation) this.zzbbY.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.zzbbY.size() != this.zzbbY.size()) {
            return false;
        }
        int size = this.zzbbY.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.zzbbY.get(i)).equals((Invitation) zInvitationCluster.zzbbY.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return ((InvitationEntity) this.zzbbY.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity) this.zzbbY.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbbY.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        InvitationClusterCreator.zza(this, parcel, i);
    }

    public ArrayList<Invitation> zzFh() {
        return new ArrayList(this.zzbbY);
    }
}
