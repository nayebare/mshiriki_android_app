package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR;
    private final int mVersionCode;
    private final String zzahi;
    private final GameEntity zzbbQ;
    private final long zzbdA;
    private final int zzbdB;
    private final ParticipantEntity zzbdC;
    private final ArrayList<ParticipantEntity> zzbdD;
    private final int zzbdE;
    private final int zzbdF;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfN(parcel);
        }

        public InvitationEntity zzfN(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzf(DowngradeableSafeParcel.zzxo()) || DowngradeableSafeParcel.zzdp(InvitationEntity.class.getCanonicalName())) {
                return super.zzfN(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add((ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    static {
        CREATOR = new InvitationEntityCreatorCompat();
    }

    InvitationEntity(int i, GameEntity gameEntity, String str, long j, int i2, ParticipantEntity participantEntity, ArrayList<ParticipantEntity> arrayList, int i3, int i4) {
        this.mVersionCode = i;
        this.zzbbQ = gameEntity;
        this.zzahi = str;
        this.zzbdA = j;
        this.zzbdB = i2;
        this.zzbdC = participantEntity;
        this.zzbdD = arrayList;
        this.zzbdE = i3;
        this.zzbdF = i4;
    }

    InvitationEntity(Invitation invitation) {
        this.mVersionCode = 2;
        this.zzbbQ = new GameEntity(invitation.getGame());
        this.zzahi = invitation.getInvitationId();
        this.zzbdA = invitation.getCreationTimestamp();
        this.zzbdB = invitation.getInvitationType();
        this.zzbdE = invitation.getVariant();
        this.zzbdF = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.zzbdD = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.zzbdD.add((ParticipantEntity) participant.freeze());
        }
        zzac.zzb(obj, (Object) "Must have a valid inviter!");
        this.zzbdC = (ParticipantEntity) obj.freeze();
    }

    static int zza(Invitation invitation) {
        return zzaa.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzaa.equal(invitation2.getGame(), invitation.getGame()) && zzaa.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && zzaa.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && zzaa.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && zzaa.equal(invitation2.getInviter(), invitation.getInviter()) && zzaa.equal(invitation2.getParticipants(), invitation.getParticipants()) && zzaa.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && zzaa.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return zzaa.zzv(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzbdF;
    }

    public long getCreationTimestamp() {
        return this.zzbdA;
    }

    public Game getGame() {
        return this.zzbbQ;
    }

    public String getInvitationId() {
        return this.zzahi;
    }

    public int getInvitationType() {
        return this.zzbdB;
    }

    public Participant getInviter() {
        return this.zzbdC;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzbdD);
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
        InvitationEntityCreator.zza(this, parcel, i);
    }
}
