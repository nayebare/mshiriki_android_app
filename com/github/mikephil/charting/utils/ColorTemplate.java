package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.quest.Quests;
import java.util.ArrayList;
import java.util.List;

public class ColorTemplate {
    public static final int[] COLORFUL_COLORS;
    public static final int COLOR_NONE = -1;
    public static final int COLOR_SKIP = -2;
    public static final int[] JOYFUL_COLORS;
    public static final int[] LIBERTY_COLORS;
    public static final int[] PASTEL_COLORS;
    public static final int[] VORDIPLOM_COLORS;

    static {
        LIBERTY_COLORS = new int[]{Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, C0308R.styleable.AppCompatTheme_ratingBarStyleIndicator, TransportMediator.KEYCODE_MEDIA_RECORD)};
        JOYFUL_COLORS = new int[]{Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(C0308R.styleable.AppCompatTheme_editTextStyle, 167, 134), Color.rgb(53, 194, 209)};
        PASTEL_COLORS = new int[]{Color.rgb(64, 89, Cast.MAX_NAMESPACE_LENGTH), Color.rgb(149, 165, MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};
        COLORFUL_COLORS = new int[]{Color.rgb(193, 37, 82), Color.rgb(MotionEventCompat.ACTION_MASK, Quests.SELECT_ENDING_SOON, 0), Color.rgb(245, 199, 0), Color.rgb(C0308R.styleable.AppCompatTheme_editTextStyle, 150, 31), Color.rgb(179, 100, 53)};
        VORDIPLOM_COLORS = new int[]{Color.rgb(192, MotionEventCompat.ACTION_MASK, 140), Color.rgb(MotionEventCompat.ACTION_MASK, 247, 140), Color.rgb(MotionEventCompat.ACTION_MASK, 208, 140), Color.rgb(140, 234, MotionEventCompat.ACTION_MASK), Color.rgb(MotionEventCompat.ACTION_MASK, 140, 157)};
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, 229);
    }

    public static List<Integer> createColors(Resources r, int[] colors) {
        List<Integer> result = new ArrayList();
        for (int i : colors) {
            result.add(Integer.valueOf(r.getColor(i)));
        }
        return result;
    }

    public static List<Integer> createColors(int[] colors) {
        List<Integer> result = new ArrayList();
        for (int i : colors) {
            result.add(Integer.valueOf(i));
        }
        return result;
    }
}
