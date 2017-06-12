package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public final class TurnBasedMatchEntity extends GamesAbstractSafeParcelable implements TurnBasedMatch {
    public static final Creator<TurnBasedMatchEntity> CREATOR;
    private final int mVersion;
    private final int mVersionCode;
    private final long zzaYl;
    private final String zzaZP;
    private final String zzacd;
    private final GameEntity zzbbQ;
    private final long zzbdA;
    private final ArrayList<ParticipantEntity> zzbdD;
    private final int zzbdE;
    private final Bundle zzbdU;
    private final String zzbdW;
    private final String zzbee;
    private final String zzbef;
    private final int zzbeg;
    private final byte[] zzbeh;
    private final String zzbei;
    private final byte[] zzbej;
    private final int zzbek;
    private final int zzbel;
    private final boolean zzbem;
    private final String zzben;

    static {
        CREATOR = new TurnBasedMatchEntityCreator();
    }

    TurnBasedMatchEntity(int i, GameEntity gameEntity, String str, String str2, long j, String str3, long j2, String str4, int i2, int i3, int i4, byte[] bArr, ArrayList<ParticipantEntity> arrayList, String str5, byte[] bArr2, int i5, Bundle bundle, int i6, boolean z, String str6, String str7) {
        this.mVersionCode = i;
        this.zzbbQ = gameEntity;
        this.zzaZP = str;
        this.zzbdW = str2;
        this.zzbdA = j;
        this.zzbee = str3;
        this.zzaYl = j2;
        this.zzbef = str4;
        this.zzbeg = i2;
        this.zzbel = i6;
        this.zzbdE = i3;
        this.mVersion = i4;
        this.zzbeh = bArr;
        this.zzbdD = arrayList;
        this.zzbei = str5;
        this.zzbej = bArr2;
        this.zzbek = i5;
        this.zzbdU = bundle;
        this.zzbem = z;
        this.zzacd = str6;
        this.zzben = str7;
    }

    public TurnBasedMatchEntity(TurnBasedMatch turnBasedMatch) {
        this.mVersionCode = 2;
        this.zzbbQ = new GameEntity(turnBasedMatch.getGame());
        this.zzaZP = turnBasedMatch.getMatchId();
        this.zzbdW = turnBasedMatch.getCreatorId();
        this.zzbdA = turnBasedMatch.getCreationTimestamp();
        this.zzbee = turnBasedMatch.getLastUpdaterId();
        this.zzaYl = turnBasedMatch.getLastUpdatedTimestamp();
        this.zzbef = turnBasedMatch.getPendingParticipantId();
        this.zzbeg = turnBasedMatch.getStatus();
        this.zzbel = turnBasedMatch.getTurnStatus();
        this.zzbdE = turnBasedMatch.getVariant();
        this.mVersion = turnBasedMatch.getVersion();
        this.zzbei = turnBasedMatch.getRematchId();
        this.zzbek = turnBasedMatch.getMatchNumber();
        this.zzbdU = turnBasedMatch.getAutoMatchCriteria();
        this.zzbem = turnBasedMatch.isLocallyModified();
        this.zzacd = turnBasedMatch.getDescription();
        this.zzben = turnBasedMatch.getDescriptionParticipantId();
        Object data = turnBasedMatch.getData();
        if (data == null) {
            this.zzbeh = null;
        } else {
            this.zzbeh = new byte[data.length];
            System.arraycopy(data, 0, this.zzbeh, 0, data.length);
        }
        data = turnBasedMatch.getPreviousMatchData();
        if (data == null) {
            this.zzbej = null;
        } else {
            this.zzbej = new byte[data.length];
            System.arraycopy(data, 0, this.zzbej, 0, data.length);
        }
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        this.zzbdD = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzbdD.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return zzaa.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        String valueOf = String.valueOf(turnBasedMatch.getMatchId());
        throw new IllegalStateException(new StringBuilder((String.valueOf(str).length() + 29) + String.valueOf(valueOf).length()).append("Participant ").append(str).append(" is not in match ").append(valueOf).toString());
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return zzaa.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && zzaa.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && zzaa.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && zzaa.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && zzaa.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && zzaa.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && zzaa.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && zzaa.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && zzaa.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && zzaa.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && zzaa.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && zzaa.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && zzaa.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && zzaa.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && zzaa.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzaa.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && zzaa.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && zzaa.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return zzaa.zzv(turnBasedMatch).zzg("Game", turnBasedMatch.getGame()).zzg("MatchId", turnBasedMatch.getMatchId()).zzg("CreatorId", turnBasedMatch.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).zzg("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).zzg("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).zzg("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).zzg("Description", turnBasedMatch.getDescription()).zzg("Variant", Integer.valueOf(turnBasedMatch.getVariant())).zzg("Data", turnBasedMatch.getData()).zzg("Version", Integer.valueOf(turnBasedMatch.getVersion())).zzg("Participants", turnBasedMatch.getParticipants()).zzg("RematchId", turnBasedMatch.getRematchId()).zzg("PreviousData", turnBasedMatch.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).zzg("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).zzg("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        String valueOf = String.valueOf(turnBasedMatch.getMatchId());
        throw new IllegalStateException(new StringBuilder((String.valueOf(str).length() + 29) + String.valueOf(valueOf).length()).append("Participant ").append(str).append(" is not in match ").append(valueOf).toString());
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.zzbeg == 2 && this.zzbei == null;
    }

    public boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzbdU;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzbdU == null ? 0 : this.zzbdU.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.zzbdA;
    }

    public String getCreatorId() {
        return this.zzbdW;
    }

    public byte[] getData() {
        return this.zzbeh;
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.zzben;
    }

    public Game getGame() {
        return this.zzbbQ;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaYl;
    }

    public String getLastUpdaterId() {
        return this.zzbee;
    }

    public String getMatchId() {
        return this.zzaZP;
    }

    public int getMatchNumber() {
        return this.zzbek;
    }

    public Participant getParticipant(String str) {
        return zzc(this, str);
    }

    public String getParticipantId(String str) {
        return zzb(this, str);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public int getParticipantStatus(String str) {
        return zza((TurnBasedMatch) this, str);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzbdD);
    }

    public String getPendingParticipantId() {
        return this.zzbef;
    }

    public byte[] getPreviousMatchData() {
        return this.zzbej;
    }

    public String getRematchId() {
        return this.zzbei;
    }

    public int getStatus() {
        return this.zzbeg;
    }

    public int getTurnStatus() {
        return this.zzbel;
    }

    public int getVariant() {
        return this.zzbdE;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.zzbem;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        TurnBasedMatchEntityCreator.zza(this, parcel, i);
    }
}
