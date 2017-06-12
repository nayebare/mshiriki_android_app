package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public final class RoomRef extends zzc implements Room {
    private final int zzaYG;

    RoomRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaYG = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return RoomEntity.zza((Room) this, obj);
    }

    public Room freeze() {
        return new RoomEntity(this);
    }

    public Bundle getAutoMatchCriteria() {
        return !getBoolean("has_automatch_criteria") ? null : RoomConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return getInteger("automatch_wait_estimate_sec");
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public String getCreatorId() {
        return getString("creator_external");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public Participant getParticipant(String str) {
        return RoomEntity.zzc(this, str);
    }

    public String getParticipantId(String str) {
        return RoomEntity.zzb(this, str);
    }

    public ArrayList<String> getParticipantIds() {
        return RoomEntity.zzc(this);
    }

    public int getParticipantStatus(String str) {
        return RoomEntity.zza((Room) this, str);
    }

    public ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList(this.zzaYG);
        for (int i = 0; i < this.zzaYG; i++) {
            arrayList.add(new ParticipantRef(this.zzazI, this.zzaCm + i));
        }
        return arrayList;
    }

    public String getRoomId() {
        return getString("external_match_id");
    }

    public int getStatus() {
        return getInteger(Games.EXTRA_STATUS);
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return RoomEntity.zza(this);
    }

    public String toString() {
        return RoomEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((RoomEntity) ((Room) freeze())).writeToParcel(parcel, i);
    }
}
