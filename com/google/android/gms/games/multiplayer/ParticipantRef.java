package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends zzc implements Participant {
    private final PlayerRef zzbdJ;

    public ParticipantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzbdJ = new PlayerRef(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.zza(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return zzdl("external_player_id") ? getString("default_display_name") : this.zzbdJ.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (zzdl("external_player_id")) {
            zza("default_display_name", charArrayBuffer);
        } else {
            this.zzbdJ.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getHiResImageUri() {
        return zzdl("external_player_id") ? zzdk("default_display_hi_res_image_uri") : this.zzbdJ.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return zzdl("external_player_id") ? getString("default_display_hi_res_image_url") : this.zzbdJ.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return zzdl("external_player_id") ? zzdk("default_display_image_uri") : this.zzbdJ.getIconImageUri();
    }

    public String getIconImageUrl() {
        return zzdl("external_player_id") ? getString("default_display_image_url") : this.zzbdJ.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return zzdl("external_player_id") ? null : this.zzbdJ;
    }

    public ParticipantResult getResult() {
        if (zzdl("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.zza(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((ParticipantEntity) ((Participant) freeze())).writeToParcel(parcel, i);
    }

    public String zzDY() {
        return getString("client_address");
    }
}
