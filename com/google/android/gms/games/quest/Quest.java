package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import java.util.List;

public interface Quest extends Parcelable, Freezable<Quest> {
    @KeepName
    public static final int[] QUEST_STATE_ALL;
    @KeepName
    public static final String[] QUEST_STATE_NON_TERMINAL;
    public static final int STATE_ACCEPTED = 3;
    public static final int STATE_COMPLETED = 4;
    public static final int STATE_EXPIRED = 5;
    public static final int STATE_FAILED = 6;
    public static final int STATE_OPEN = 2;
    public static final int STATE_UPCOMING = 1;
    public static final long UNSET_QUEST_TIMESTAMP = -1;

    static {
        QUEST_STATE_ALL = new int[]{STATE_UPCOMING, STATE_OPEN, STATE_ACCEPTED, STATE_COMPLETED, STATE_FAILED, STATE_EXPIRED};
        String[] strArr = new String[STATE_ACCEPTED];
        strArr[0] = Integer.toString(STATE_UPCOMING);
        strArr[STATE_UPCOMING] = Integer.toString(STATE_OPEN);
        strArr[STATE_OPEN] = Integer.toString(STATE_ACCEPTED);
        QUEST_STATE_NON_TERMINAL = strArr;
    }

    long getAcceptedTimestamp();

    Uri getBannerImageUri();

    @KeepName
    @Deprecated
    String getBannerImageUrl();

    Milestone getCurrentMilestone();

    String getDescription();

    void getDescription(CharArrayBuffer charArrayBuffer);

    long getEndTimestamp();

    Game getGame();

    Uri getIconImageUri();

    @KeepName
    @Deprecated
    String getIconImageUrl();

    long getLastUpdatedTimestamp();

    String getName();

    void getName(CharArrayBuffer charArrayBuffer);

    String getQuestId();

    long getStartTimestamp();

    int getState();

    int getType();

    boolean isEndingSoon();

    List<Milestone> zzFI();

    long zzFJ();
}
