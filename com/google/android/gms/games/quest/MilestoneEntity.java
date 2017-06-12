package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class MilestoneEntity extends GamesAbstractSafeParcelable implements Milestone {
    public static final Creator<MilestoneEntity> CREATOR;
    private final int mState;
    private final int mVersionCode;
    private final String zzaYL;
    private final String zzbaa;
    private final long zzbeo;
    private final long zzbep;
    private final byte[] zzbeq;

    static {
        CREATOR = new MilestoneEntityCreator();
    }

    MilestoneEntity(int i, String str, long j, long j2, byte[] bArr, int i2, String str2) {
        this.mVersionCode = i;
        this.zzbaa = str;
        this.zzbeo = j;
        this.zzbep = j2;
        this.zzbeq = bArr;
        this.mState = i2;
        this.zzaYL = str2;
    }

    public MilestoneEntity(Milestone milestone) {
        this.mVersionCode = 4;
        this.zzbaa = milestone.getMilestoneId();
        this.zzbeo = milestone.getCurrentProgress();
        this.zzbep = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzaYL = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzbeq = null;
            return;
        }
        this.zzbeq = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.zzbeq, 0, completionRewardData.length);
    }

    static int zza(Milestone milestone) {
        return zzaa.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzaa.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzaa.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzaa.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzaa.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzaa.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzaa.zzv(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.zzbeq;
    }

    public long getCurrentProgress() {
        return this.zzbeo;
    }

    public String getEventId() {
        return this.zzaYL;
    }

    public String getMilestoneId() {
        return this.zzbaa;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.zzbep;
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
        MilestoneEntityCreator.zza(this, parcel, i);
    }
}
