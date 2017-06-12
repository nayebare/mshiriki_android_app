package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends zzc implements GameRequest {
    private final int zzaYG;

    public GameRequestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaYG = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.zza(this, obj);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.zzazI, this.zzaCm);
    }

    public int getRecipientStatus(String str) {
        for (int i = this.zzaCm; i < this.zzaCm + this.zzaYG; i++) {
            int zzcC = this.zzazI.zzcC(i);
            if (this.zzazI.zzd("recipient_external_player_id", i, zzcC).equals(str)) {
                return this.zzazI.zzc("recipient_status", i, zzcC);
            }
        }
        return -1;
    }

    public List<Player> getRecipients() {
        List arrayList = new ArrayList(this.zzaYG);
        for (int i = 0; i < this.zzaYG; i++) {
            arrayList.add(new PlayerRef(this.zzazI, this.zzaCm + i, "recipient_"));
        }
        return arrayList;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.zzazI, zzwB(), "sender_");
    }

    public int getStatus() {
        return getInteger(Games.EXTRA_STATUS);
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.zza(this);
    }

    public boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public String toString() {
        return GameRequestEntity.zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((GameRequestEntity) ((GameRequest) freeze())).writeToParcel(parcel, i);
    }
}
