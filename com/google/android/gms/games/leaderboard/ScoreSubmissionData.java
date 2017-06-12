package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzbcT;
    private String zzaus;
    private int zzauz;
    private String zzbcV;
    private HashMap<Integer, Result> zzbdz;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long j, String str, String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        public String toString() {
            return zzaa.zzv(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    static {
        zzbcT = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzauz = dataHolder.getStatusCode();
        this.zzbdz = new HashMap();
        int count = dataHolder.getCount();
        zzac.zzas(count == 3);
        for (int i = 0; i < count; i++) {
            int zzcC = dataHolder.zzcC(i);
            if (i == 0) {
                this.zzbcV = dataHolder.zzd("leaderboardId", i, zzcC);
                this.zzaus = dataHolder.zzd("playerId", i, zzcC);
            }
            if (dataHolder.zze("hasResult", i, zzcC)) {
                zza(new Result(dataHolder.zzb("rawScore", i, zzcC), dataHolder.zzd("formattedScore", i, zzcC), dataHolder.zzd("scoreTag", i, zzcC), dataHolder.zze("newBest", i, zzcC)), dataHolder.zzc("timeSpan", i, zzcC));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzbdz.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzbcV;
    }

    public String getPlayerId() {
        return this.zzaus;
    }

    public Result getScoreResult(int i) {
        return (Result) this.zzbdz.get(Integer.valueOf(i));
    }

    public String toString() {
        zza zzg = zzaa.zzv(this).zzg("PlayerId", this.zzaus).zzg("StatusCode", Integer.valueOf(this.zzauz));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzbdz.get(Integer.valueOf(i));
            zzg.zzg("TimesSpan", TimeSpan.zziC(i));
            zzg.zzg("Result", result == null ? "null" : result.toString());
        }
        return zzg.toString();
    }
}
