package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity extends GamesAbstractSafeParcelable implements Quest {
    public static final Creator<QuestEntity> CREATOR;
    private final Uri mIconUri;
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final long zzaYl;
    private final String zzacd;
    private final int zzanR;
    private final GameEntity zzbbQ;
    private final String zzber;
    private final long zzbes;
    private final Uri zzbet;
    private final String zzbeu;
    private final long zzbev;
    private final String zzbew;
    private final long zzbex;
    private final long zzbey;
    private final ArrayList<MilestoneEntity> zzbez;

    static {
        CREATOR = new QuestEntityCreator();
    }

    QuestEntity(int i, GameEntity gameEntity, String str, long j, Uri uri, String str2, String str3, long j2, long j3, Uri uri2, String str4, String str5, long j4, long j5, int i2, int i3, ArrayList<MilestoneEntity> arrayList) {
        this.mVersionCode = i;
        this.zzbbQ = gameEntity;
        this.zzber = str;
        this.zzbes = j;
        this.zzbet = uri;
        this.zzbeu = str2;
        this.zzacd = str3;
        this.zzbev = j2;
        this.zzaYl = j3;
        this.mIconUri = uri2;
        this.zzbew = str4;
        this.mName = str5;
        this.zzbex = j4;
        this.zzbey = j5;
        this.mState = i2;
        this.zzanR = i3;
        this.zzbez = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.mVersionCode = 2;
        this.zzbbQ = new GameEntity(quest.getGame());
        this.zzber = quest.getQuestId();
        this.zzbes = quest.getAcceptedTimestamp();
        this.zzacd = quest.getDescription();
        this.zzbet = quest.getBannerImageUri();
        this.zzbeu = quest.getBannerImageUrl();
        this.zzbev = quest.getEndTimestamp();
        this.mIconUri = quest.getIconImageUri();
        this.zzbew = quest.getIconImageUrl();
        this.zzaYl = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzbex = quest.zzFJ();
        this.zzbey = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzanR = quest.getType();
        List zzFI = quest.zzFI();
        int size = zzFI.size();
        this.zzbez = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzbez.add((MilestoneEntity) ((Milestone) zzFI.get(i)).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzaa.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzFI(), quest.getName(), Long.valueOf(quest.zzFJ()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzaa.equal(quest2.getGame(), quest.getGame()) && zzaa.equal(quest2.getQuestId(), quest.getQuestId()) && zzaa.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzaa.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzaa.equal(quest2.getDescription(), quest.getDescription()) && zzaa.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzaa.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzaa.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzaa.equal(quest2.zzFI(), quest.zzFI()) && zzaa.equal(quest2.getName(), quest.getName()) && zzaa.equal(Long.valueOf(quest2.zzFJ()), Long.valueOf(quest.zzFJ())) && zzaa.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzaa.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzaa.zzv(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzFI()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzFJ())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.zzbes;
    }

    public Uri getBannerImageUri() {
        return this.zzbet;
    }

    public String getBannerImageUrl() {
        return this.zzbeu;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzFI().get(0);
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
    }

    public long getEndTimestamp() {
        return this.zzbev;
    }

    public Game getGame() {
        return this.zzbbQ;
    }

    public Uri getIconImageUri() {
        return this.mIconUri;
    }

    public String getIconImageUrl() {
        return this.zzbew;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaYl;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.mName, charArrayBuffer);
    }

    public String getQuestId() {
        return this.zzber;
    }

    public long getStartTimestamp() {
        return this.zzbey;
    }

    public int getState() {
        return this.mState;
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

    public boolean isDataValid() {
        return true;
    }

    public boolean isEndingSoon() {
        return this.zzbex <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        QuestEntityCreator.zza(this, parcel, i);
    }

    public List<Milestone> zzFI() {
        return new ArrayList(this.zzbez);
    }

    public long zzFJ() {
        return this.zzbex;
    }
}
