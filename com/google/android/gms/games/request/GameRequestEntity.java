package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity extends GamesAbstractSafeParcelable implements GameRequest {
    public static final Creator<GameRequestEntity> CREATOR;
    private final int mVersionCode;
    private final int zzJh;
    private final String zzOn;
    private final int zzanR;
    private final GameEntity zzbbQ;
    private final long zzbdA;
    private final PlayerEntity zzbeA;
    private final ArrayList<PlayerEntity> zzbeB;
    private final long zzbeC;
    private final Bundle zzbeD;
    private final byte[] zzbeh;

    static {
        CREATOR = new GameRequestEntityCreator();
    }

    GameRequestEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, byte[] bArr, String str, ArrayList<PlayerEntity> arrayList, int i2, long j, long j2, Bundle bundle, int i3) {
        this.mVersionCode = i;
        this.zzbbQ = gameEntity;
        this.zzbeA = playerEntity;
        this.zzbeh = bArr;
        this.zzOn = str;
        this.zzbeB = arrayList;
        this.zzanR = i2;
        this.zzbdA = j;
        this.zzbeC = j2;
        this.zzbeD = bundle;
        this.zzJh = i3;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.mVersionCode = 2;
        this.zzbbQ = new GameEntity(gameRequest.getGame());
        this.zzbeA = new PlayerEntity(gameRequest.getSender());
        this.zzOn = gameRequest.getRequestId();
        this.zzanR = gameRequest.getType();
        this.zzbdA = gameRequest.getCreationTimestamp();
        this.zzbeC = gameRequest.getExpirationTimestamp();
        this.zzJh = gameRequest.getStatus();
        Object data = gameRequest.getData();
        if (data == null) {
            this.zzbeh = null;
        } else {
            this.zzbeh = new byte[data.length];
            System.arraycopy(data, 0, this.zzbeh, 0, data.length);
        }
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.zzbeB = new ArrayList(size);
        this.zzbeD = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzbeB.add((PlayerEntity) player);
            this.zzbeD.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzaa.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzaa.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzaa.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzaa.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzaa.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzaa.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzaa.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzaa.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzaa.zzv(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzbdA;
    }

    public byte[] getData() {
        return this.zzbeh;
    }

    public long getExpirationTimestamp() {
        return this.zzbeC;
    }

    public Game getGame() {
        return this.zzbbQ;
    }

    public int getRecipientStatus(String str) {
        return this.zzbeD.getInt(str, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzbeB);
    }

    public String getRequestId() {
        return this.zzOn;
    }

    public Player getSender() {
        return this.zzbeA;
    }

    public int getStatus() {
        return this.zzJh;
    }

    public int getType() {
        return this.zzanR;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        GameRequestEntityCreator.zza(this, parcel, i);
    }

    public Bundle zzFK() {
        return this.zzbeD;
    }
}
