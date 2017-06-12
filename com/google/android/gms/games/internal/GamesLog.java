package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzabs;

public final class GamesLog {
    private static final zzq zzbaC;
    private static final zzabs<Boolean> zzbaD;

    static {
        zzbaC = new zzq("Games");
        zzbaD = zzabs.zzj("games.play_games_dogfood", false);
    }

    private GamesLog() {
    }

    public static void zzE(String str, String str2) {
        zzbaC.zzE(str, str2);
    }

    public static void zzF(String str, String str2) {
        zzbaC.zzF(str, str2);
    }

    public static void zzb(String str, String str2, Throwable th) {
        zzbaC.zzb(str, str2, th);
    }

    public static void zzc(String str, String str2, Throwable th) {
        zzbaC.zzc(str, str2, th);
    }
}
