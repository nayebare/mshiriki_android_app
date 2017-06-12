package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends zzc implements Leaderboard {
    private final int zzaYG;
    private final Game zzbcY;

    LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaYG = i2;
        this.zzbcY = new GameRef(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return LeaderboardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFz();
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zza("name", charArrayBuffer);
    }

    public Game getGame() {
        return this.zzbcY;
    }

    public Uri getIconImageUri() {
        return zzdk("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.zzaYG);
        for (int i = 0; i < this.zzaYG; i++) {
            arrayList.add(new LeaderboardVariantRef(this.zzazI, this.zzaCm + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return LeaderboardEntity.zza(this);
    }

    public String toString() {
        return LeaderboardEntity.zzb(this);
    }

    public Leaderboard zzFz() {
        return new LeaderboardEntity(this);
    }
}
