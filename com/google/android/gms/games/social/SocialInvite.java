package com.google.android.gms.games.social;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface SocialInvite extends Parcelable, Freezable<SocialInvite> {
    int getDirection();

    long getLastModifiedTimestamp();

    Player getPlayer();

    int getType();

    String zzFM();
}
