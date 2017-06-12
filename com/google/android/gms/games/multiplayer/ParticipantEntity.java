package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR;
    private final int mVersionCode;
    private final int zzJh;
    private final Uri zzaWW;
    private final Uri zzaWX;
    private final String zzaXh;
    private final String zzaXi;
    private final String zzaYN;
    private final PlayerEntity zzaYi;
    private final String zzaZX;
    private final String zzaiX;
    private final int zzamo;
    private final boolean zzbdH;
    private final ParticipantResult zzbdI;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfO(parcel);
        }

        public ParticipantEntity zzfO(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.zzf(DowngradeableSafeParcel.zzxo()) || DowngradeableSafeParcel.zzdp(ParticipantEntity.class.getCanonicalName())) {
                return super.zzfO(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    static {
        CREATOR = new ParticipantEntityCreatorCompat();
    }

    ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.mVersionCode = i;
        this.zzaZX = str;
        this.zzaiX = str2;
        this.zzaWW = uri;
        this.zzaWX = uri2;
        this.zzJh = i2;
        this.zzaYN = str3;
        this.zzbdH = z;
        this.zzaYi = playerEntity;
        this.zzamo = i3;
        this.zzbdI = participantResult;
        this.zzaXh = str4;
        this.zzaXi = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzaZX = participant.getParticipantId();
        this.zzaiX = participant.getDisplayName();
        this.zzaWW = participant.getIconImageUri();
        this.zzaWX = participant.getHiResImageUri();
        this.zzJh = participant.getStatus();
        this.zzaYN = participant.zzDY();
        this.zzbdH = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaYi = player == null ? null : new PlayerEntity(player);
        this.zzamo = participant.getCapabilities();
        this.zzbdI = participant.getResult();
        this.zzaXh = participant.getIconImageUrl();
        this.zzaXi = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzaa.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzDY(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzaa.equal(participant2.getPlayer(), participant.getPlayer()) && zzaa.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzaa.equal(participant2.zzDY(), participant.zzDY()) && zzaa.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzaa.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzaa.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzaa.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzaa.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzaa.equal(participant2.getResult(), participant.getResult()) && zzaa.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzaa.zzv(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzDY()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzamo;
    }

    public String getDisplayName() {
        return this.zzaYi == null ? this.zzaiX : this.zzaYi.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzaYi == null) {
            zzg.zzb(this.zzaiX, charArrayBuffer);
        } else {
            this.zzaYi.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzaYi == null ? this.zzaWX : this.zzaYi.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzaYi == null ? this.zzaXi : this.zzaYi.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzaYi == null ? this.zzaWW : this.zzaYi.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzaYi == null ? this.zzaXh : this.zzaYi.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzaZX;
    }

    public Player getPlayer() {
        return this.zzaYi;
    }

    public ParticipantResult getResult() {
        return this.zzbdI;
    }

    public int getStatus() {
        return this.zzJh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzbdH;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParticipantEntityCreator.zza(this, parcel, i);
    }

    public String zzDY() {
        return this.zzaYN;
    }
}
