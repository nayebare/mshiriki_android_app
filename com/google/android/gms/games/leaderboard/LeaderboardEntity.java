package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final Uri zzaWW;
    private final String zzaXh;
    private final String zzaiX;
    private final String zzbcV;
    private final int zzbcW;
    private final ArrayList<LeaderboardVariantEntity> zzbcX;
    private final Game zzbcY;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzbcV = leaderboard.getLeaderboardId();
        this.zzaiX = leaderboard.getDisplayName();
        this.zzaWW = leaderboard.getIconImageUri();
        this.zzaXh = leaderboard.getIconImageUrl();
        this.zzbcW = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzbcY = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzbcX = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzbcX.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzaa.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzaa.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzaa.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzaa.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzaa.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzaa.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzaa.zzv(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFz();
    }

    public String getDisplayName() {
        return this.zzaiX;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzaiX, charArrayBuffer);
    }

    public Game getGame() {
        return this.zzbcY;
    }

    public Uri getIconImageUri() {
        return this.zzaWW;
    }

    public String getIconImageUrl() {
        return this.zzaXh;
    }

    public String getLeaderboardId() {
        return this.zzbcV;
    }

    public int getScoreOrder() {
        return this.zzbcW;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.zzbcX);
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

    public Leaderboard zzFz() {
        return this;
    }
}
