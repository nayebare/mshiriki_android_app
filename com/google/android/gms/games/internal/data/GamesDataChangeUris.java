package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    private static final Uri zzbbF;
    public static final Uri zzbbG;
    public static final Uri zzbbH;

    static {
        zzbbF = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        zzbbG = zzbbF.buildUpon().appendPath("invitations").build();
        zzbbH = zzbbF.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
    }
}
