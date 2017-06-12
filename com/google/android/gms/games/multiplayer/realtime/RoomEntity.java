package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR;
    private final int mVersionCode;
    private final String zzaZu;
    private final String zzacd;
    private final long zzbdA;
    private final ArrayList<ParticipantEntity> zzbdD;
    private final int zzbdE;
    private final Bundle zzbdU;
    private final String zzbdW;
    private final int zzbdX;
    private final int zzbdY;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfR(parcel);
        }

        public RoomEntity zzfR(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzf(DowngradeableSafeParcel.zzxo()) || DowngradeableSafeParcel.zzdp(RoomEntity.class.getCanonicalName())) {
                return super.zzfR(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add((ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    static {
        CREATOR = new RoomEntityCreatorCompat();
    }

    RoomEntity(int i, String str, String str2, long j, int i2, String str3, int i3, Bundle bundle, ArrayList<ParticipantEntity> arrayList, int i4) {
        this.mVersionCode = i;
        this.zzaZu = str;
        this.zzbdW = str2;
        this.zzbdA = j;
        this.zzbdX = i2;
        this.zzacd = str3;
        this.zzbdE = i3;
        this.zzbdU = bundle;
        this.zzbdD = arrayList;
        this.zzbdY = i4;
    }

    public RoomEntity(Room room) {
        this.mVersionCode = 2;
        this.zzaZu = room.getRoomId();
        this.zzbdW = room.getCreatorId();
        this.zzbdA = room.getCreationTimestamp();
        this.zzbdX = room.getStatus();
        this.zzacd = room.getDescription();
        this.zzbdE = room.getVariant();
        this.zzbdU = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.zzbdD = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzbdD.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.zzbdY = room.getAutoMatchWaitEstimateSeconds();
    }

    static int zza(Room room) {
        return zzaa.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int zza(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        String valueOf = String.valueOf(room.getRoomId());
        throw new IllegalStateException(new StringBuilder((String.valueOf(str).length() + 28) + String.valueOf(valueOf).length()).append("Participant ").append(str).append(" is not in room ").append(valueOf).toString());
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return zzaa.equal(room2.getRoomId(), room.getRoomId()) && zzaa.equal(room2.getCreatorId(), room.getCreatorId()) && zzaa.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && zzaa.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && zzaa.equal(room2.getDescription(), room.getDescription()) && zzaa.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && zzaa.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && zzaa.equal(room2.getParticipants(), room.getParticipants()) && zzaa.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String zzb(Room room) {
        return zzaa.zzv(room).zzg("RoomId", room.getRoomId()).zzg("CreatorId", room.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(room.getStatus())).zzg("Description", room.getDescription()).zzg("Variant", Integer.valueOf(room.getVariant())).zzg("AutoMatchCriteria", room.getAutoMatchCriteria()).zzg("Participants", room.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String zzb(Room room, String str) {
        ArrayList participants = room.getParticipants();
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

    static Participant zzc(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        String valueOf = String.valueOf(room.getRoomId());
        throw new IllegalStateException(new StringBuilder((String.valueOf(str).length() + 29) + String.valueOf(valueOf).length()).append("Participant ").append(str).append(" is not in match ").append(valueOf).toString());
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzbdU;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.zzbdY;
    }

    public long getCreationTimestamp() {
        return this.zzbdA;
    }

    public String getCreatorId() {
        return this.zzbdW;
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
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
        return zza((Room) this, str);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzbdD);
    }

    public String getRoomId() {
        return this.zzaZu;
    }

    public int getStatus() {
        return this.zzbdX;
    }

    public int getVariant() {
        return this.zzbdE;
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

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        RoomEntityCreator.zza(this, parcel, i);
    }
}
