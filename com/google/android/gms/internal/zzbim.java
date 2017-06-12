package com.google.android.gms.internal;

import com.google.android.gms.cast.TextTrackStyle;

public class zzbim {

    private static class zza {
        private static final zzbip zzbUe;
        private static final zzbip zzbUf;
        private static final zzbip zzbUg;

        static {
            zzbUe = new zzbip(0.0f, 0.0f, 0.2f, TextTrackStyle.DEFAULT_FONT_SCALE);
            zzbUf = new zzbip(0.4f, 0.0f, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE);
            zzbUg = new zzbip(0.4f, 0.0f, 0.2f, TextTrackStyle.DEFAULT_FONT_SCALE);
        }
    }

    public static zzbip zzTk() {
        return zza.zzbUe;
    }

    public static zzbip zzTl() {
        return zza.zzbUf;
    }

    public static zzbip zzTm() {
        return zza.zzbUg;
    }
}
