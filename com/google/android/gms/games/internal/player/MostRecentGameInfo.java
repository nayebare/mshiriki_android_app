package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo extends Parcelable, Freezable<MostRecentGameInfo> {
    String zzFo();

    String zzFp();

    long zzFq();

    Uri zzFr();

    Uri zzFs();

    Uri zzFt();
}
