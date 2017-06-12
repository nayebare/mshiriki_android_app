package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class AchievementRef extends zzc implements Achievement {
    AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public Achievement freeze() {
        return new AchievementEntity(this);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzc.zzar(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzc.zzar(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzc.zzar(z);
        zza("formatted_current_steps", charArrayBuffer);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzc.zzar(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzc.zzar(z);
        zza("formatted_total_steps", charArrayBuffer);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zza("name", charArrayBuffer);
    }

    public Player getPlayer() {
        return new PlayerRef(this.zzazI, this.zzaCm);
    }

    public Uri getRevealedImageUri() {
        return zzdk("revealed_icon_image_uri");
    }

    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzc.zzar(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger("type");
    }

    public Uri getUnlockedImageUri() {
        return zzdk("unlocked_icon_image_uri");
    }

    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public long getXpValue() {
        return (!zzdj("instance_xp_value") || zzdl("instance_xp_value")) ? getLong("definition_xp_value") : getLong("instance_xp_value");
    }

    public String toString() {
        return AchievementEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AchievementEntity) ((Achievement) freeze())).writeToParcel(parcel, i);
    }
}
