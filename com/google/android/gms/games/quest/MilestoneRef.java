package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class MilestoneRef extends zzc implements Milestone {
    MilestoneRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private long zzFH() {
        return getLong("initial_value");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MilestoneEntity.zza(this, obj);
    }

    public Milestone freeze() {
        return new MilestoneEntity(this);
    }

    public byte[] getCompletionRewardData() {
        return getByteArray("completion_reward_data");
    }

    public long getCurrentProgress() {
        long j;
        long j2 = 0;
        switch (getState()) {
            case MessageApi.FILTER_PREFIX /*1*/:
                j = 0;
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                j = getLong("current_value");
                if (getLong("quest_state") != 6) {
                    j -= zzFH();
                    break;
                }
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
            case Dimension.UNIT_IN /*4*/:
                j = getTargetProgress();
                break;
            default:
                j = 0;
                break;
        }
        if (j < 0) {
            GamesLog.zzF("MilestoneRef", "Current progress should never be negative");
        } else {
            j2 = j;
        }
        if (j2 <= getTargetProgress()) {
            return j2;
        }
        GamesLog.zzF("MilestoneRef", "Current progress should never exceed target progress");
        return getTargetProgress();
    }

    public String getEventId() {
        return getString("external_event_id");
    }

    public String getMilestoneId() {
        return getString("external_milestone_id");
    }

    public int getState() {
        return getInteger("milestone_state");
    }

    public long getTargetProgress() {
        return getLong("target_value");
    }

    public int hashCode() {
        return MilestoneEntity.zza(this);
    }

    public String toString() {
        return MilestoneEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((MilestoneEntity) ((Milestone) freeze())).writeToParcel(parcel, i);
    }
}
