package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult extends GamesAbstractSafeParcelable {
    public static final Creator<ParticipantResult> CREATOR;
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int mVersionCode;
    private final String zzaZX;
    private final int zzbdK;
    private final int zzbdL;

    static {
        CREATOR = new ParticipantResultCreator();
    }

    public ParticipantResult(int i, String str, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaZX = (String) zzac.zzw(str);
        zzac.zzar(MatchResult.isValid(i2));
        this.zzbdK = i2;
        this.zzbdL = i3;
    }

    public ParticipantResult(String str, int i, int i2) {
        this(MATCH_RESULT_LOSS, str, i, i2);
    }

    public String getParticipantId() {
        return this.zzaZX;
    }

    public int getPlacing() {
        return this.zzbdL;
    }

    public int getResult() {
        return this.zzbdK;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParticipantResultCreator.zza(this, parcel, i);
    }
}
