package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class InvitationRef extends zzc implements Invitation {
    private final Game zzbcY;
    private final ArrayList<Participant> zzbdD;
    private final ParticipantRef zzbdG;

    InvitationRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzbcY = new GameRef(dataHolder, i);
        this.zzbdD = new ArrayList(i2);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticipantRef participantRef = new ParticipantRef(this.zzazI, this.zzaCm + i3);
            if (participantRef.getParticipantId().equals(string)) {
                obj = participantRef;
            }
            this.zzbdD.add(participantRef);
        }
        this.zzbdG = (ParticipantRef) zzac.zzb(obj, (Object) "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.zza(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.zzbcY;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public int getInvitationType() {
        return getInteger("type");
    }

    public Participant getInviter() {
        return this.zzbdG;
    }

    public ArrayList<Participant> getParticipants() {
        return this.zzbdD;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.zza(this);
    }

    public String toString() {
        return InvitationEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) ((Invitation) freeze())).writeToParcel(parcel, i);
    }
}
