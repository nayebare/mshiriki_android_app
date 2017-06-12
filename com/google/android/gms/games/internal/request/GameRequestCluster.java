package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster extends GamesAbstractSafeParcelable implements GameRequest {
    public static final Creator<GameRequestCluster> CREATOR;
    private final int mVersionCode;
    private final ArrayList<GameRequestEntity> zzbcS;

    static {
        CREATOR = new GameRequestClusterCreator();
    }

    GameRequestCluster(int i, ArrayList<GameRequestEntity> arrayList) {
        this.mVersionCode = i;
        this.zzbcS = arrayList;
        zzFg();
    }

    private void zzFg() {
        zzc.zzar(!this.zzbcS.isEmpty());
        GameRequest gameRequest = (GameRequest) this.zzbcS.get(0);
        int size = this.zzbcS.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.zzbcS.get(i);
            zzc.zza(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            zzc.zza(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.zzbcS.size() != this.zzbcS.size()) {
            return false;
        }
        int size = this.zzbcS.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.zzbcS.get(i)).equals((GameRequest) gameRequestCluster.zzbcS.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public /* synthetic */ List getRecipients() {
        return zzFx();
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.zzbcS.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.zzbcS.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity) this.zzbcS.get(0)).getType();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbcS.toArray());
    }

    public boolean isConsumed(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        GameRequestClusterCreator.zza(this, parcel, i);
    }

    public ArrayList<GameRequest> zzFw() {
        return new ArrayList(this.zzbcS);
    }

    public ArrayList<Player> zzFx() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
}
