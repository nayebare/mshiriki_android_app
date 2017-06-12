package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NotificationOptions extends zza {
    public static final Creator<NotificationOptions> CREATOR;
    public static final long SKIP_STEP_TEN_SECONDS_IN_MS = 10000;
    public static final long SKIP_STEP_THIRTY_SECONDS_IN_MS = 30000;
    private static final List<String> zzaqR;
    private static final int[] zzaqS;
    private final int mVersionCode;
    private final List<String> zzaqT;
    private final int[] zzaqU;
    private final long zzaqV;
    private final String zzaqW;
    private final int zzaqX;
    private final int zzaqY;
    private final int zzaqZ;
    private final int zzara;
    private final int zzarb;
    private final int zzarc;
    private final int zzard;
    private final int zzare;
    private final int zzarf;
    private final int zzarg;
    private final int zzarh;
    private final int zzari;
    private final int zzarj;
    private final int zzark;
    private final int zzarl;
    private final int zzarm;
    private final int zzarn;
    private final int zzaro;
    private final int zzarp;
    private final int zzarq;
    private final int zzarr;
    private final int zzars;
    private final int zzart;
    private final int zzaru;
    private final int zzarv;
    private final int zzarw;
    private final int zzarx;

    public static final class Builder {
        private List<String> zzaqT;
        private int[] zzaqU;
        private long zzaqV;
        private String zzaqW;
        private int zzaqX;
        private int zzaqY;
        private int zzaqZ;
        private int zzara;
        private int zzarb;
        private int zzarc;
        private int zzard;
        private int zzare;
        private int zzarf;
        private int zzarg;
        private int zzarh;
        private int zzari;
        private int zzarj;

        public Builder() {
            this.zzaqT = NotificationOptions.zzaqR;
            this.zzaqU = NotificationOptions.zzaqS;
            this.zzaqX = C0473R.drawable.cast_ic_notification_small_icon;
            this.zzaqY = C0473R.drawable.cast_ic_notification_stop_live_stream;
            this.zzaqZ = C0473R.drawable.cast_ic_notification_pause;
            this.zzara = C0473R.drawable.cast_ic_notification_play;
            this.zzarb = C0473R.drawable.cast_ic_notification_skip_next;
            this.zzarc = C0473R.drawable.cast_ic_notification_skip_prev;
            this.zzard = C0473R.drawable.cast_ic_notification_forward;
            this.zzare = C0473R.drawable.cast_ic_notification_forward10;
            this.zzarf = C0473R.drawable.cast_ic_notification_forward30;
            this.zzarg = C0473R.drawable.cast_ic_notification_rewind;
            this.zzarh = C0473R.drawable.cast_ic_notification_rewind10;
            this.zzari = C0473R.drawable.cast_ic_notification_rewind30;
            this.zzarj = C0473R.drawable.cast_ic_notification_disconnect;
            this.zzaqV = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        }

        public NotificationOptions build() {
            return new NotificationOptions(1, this.zzaqT, this.zzaqU, this.zzaqV, this.zzaqW, this.zzaqX, this.zzaqY, this.zzaqZ, this.zzara, this.zzarb, this.zzarc, this.zzard, this.zzare, this.zzarf, this.zzarg, this.zzarh, this.zzari, this.zzarj, C0473R.dimen.cast_notification_image_size, C0473R.string.cast_casting_to_device, C0473R.string.cast_stop_live_stream, C0473R.string.cast_pause, C0473R.string.cast_play, C0473R.string.cast_skip_next, C0473R.string.cast_skip_prev, C0473R.string.cast_forward, C0473R.string.cast_forward_10, C0473R.string.cast_forward_30, C0473R.string.cast_rewind, C0473R.string.cast_rewind_10, C0473R.string.cast_rewind_30, C0473R.string.cast_disconnect);
        }

        public Builder setActions(List<String> list, int[] iArr) {
            if (list == null && iArr != null) {
                throw new IllegalArgumentException("When setting actions to null, you must also set compatActionIndices to null.");
            } else if (list == null || iArr != null) {
                if (list == null || iArr == null) {
                    this.zzaqT = NotificationOptions.zzaqR;
                    this.zzaqU = NotificationOptions.zzaqS;
                } else {
                    int size = list.size();
                    if (iArr.length > size) {
                        throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid number of compat actions: %d > %d.", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(size)}));
                    }
                    for (int i : iArr) {
                        if (i < 0 || i >= size) {
                            throw new IllegalArgumentException(String.format(Locale.ROOT, "Index %d in compatActionIndices out of range: [0, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(size - 1)}));
                        }
                    }
                    this.zzaqT = new ArrayList(list);
                    this.zzaqU = Arrays.copyOf(iArr, iArr.length);
                }
                return this;
            } else {
                throw new IllegalArgumentException("When setting compatActionIndices to null, you must also set actions to null.");
            }
        }

        public Builder setDisconnectDrawableResId(int i) {
            this.zzarj = i;
            return this;
        }

        public Builder setForward10DrawableResId(int i) {
            this.zzare = i;
            return this;
        }

        public Builder setForward30DrawableResId(int i) {
            this.zzarf = i;
            return this;
        }

        public Builder setForwardDrawableResId(int i) {
            this.zzard = i;
            return this;
        }

        public Builder setPauseDrawableResId(int i) {
            this.zzaqZ = i;
            return this;
        }

        public Builder setPlayDrawableResId(int i) {
            this.zzara = i;
            return this;
        }

        public Builder setRewind10DrawableResId(int i) {
            this.zzarh = i;
            return this;
        }

        public Builder setRewind30DrawableResId(int i) {
            this.zzari = i;
            return this;
        }

        public Builder setRewindDrawableResId(int i) {
            this.zzarg = i;
            return this;
        }

        public Builder setSkipNextDrawableResId(int i) {
            this.zzarb = i;
            return this;
        }

        public Builder setSkipPrevDrawableResId(int i) {
            this.zzarc = i;
            return this;
        }

        public Builder setSkipStepMs(long j) {
            zzac.zzb(j > 0, (Object) "skipStepMs must be positive.");
            this.zzaqV = j;
            return this;
        }

        public Builder setSmallIconDrawableResId(int i) {
            this.zzaqX = i;
            return this;
        }

        public Builder setStopLiveStreamDrawableResId(int i) {
            this.zzaqY = i;
            return this;
        }

        public Builder setTargetActivityClassName(String str) {
            this.zzaqW = str;
            return this;
        }
    }

    static {
        zzaqR = Arrays.asList(new String[]{MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING});
        zzaqS = new int[]{0, 1};
        CREATOR = new zze();
    }

    public NotificationOptions(int i, List<String> list, int[] iArr, long j, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28) {
        this.mVersionCode = i;
        if (list != null) {
            this.zzaqT = new ArrayList(list);
        } else {
            this.zzaqT = null;
        }
        if (iArr != null) {
            this.zzaqU = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.zzaqU = null;
        }
        this.zzaqV = j;
        this.zzaqW = str;
        this.zzaqX = i2;
        this.zzaqY = i3;
        this.zzaqZ = i4;
        this.zzara = i5;
        this.zzarb = i6;
        this.zzarc = i7;
        this.zzard = i8;
        this.zzare = i9;
        this.zzarf = i10;
        this.zzarg = i11;
        this.zzarh = i12;
        this.zzari = i13;
        this.zzarj = i14;
        this.zzark = i15;
        this.zzarl = i16;
        this.zzarm = i17;
        this.zzarn = i18;
        this.zzaro = i19;
        this.zzarp = i20;
        this.zzarq = i21;
        this.zzarr = i22;
        this.zzars = i23;
        this.zzart = i24;
        this.zzaru = i25;
        this.zzarv = i26;
        this.zzarw = i27;
        this.zzarx = i28;
    }

    public List<String> getActions() {
        return this.zzaqT;
    }

    public int getCastingToDeviceStringResId() {
        return this.zzarl;
    }

    public int[] getCompatActionIndices() {
        return Arrays.copyOf(this.zzaqU, this.zzaqU.length);
    }

    public int getDisconnectDrawableResId() {
        return this.zzarj;
    }

    public int getForward10DrawableResId() {
        return this.zzare;
    }

    public int getForward30DrawableResId() {
        return this.zzarf;
    }

    public int getForwardDrawableResId() {
        return this.zzard;
    }

    public int getPauseDrawableResId() {
        return this.zzaqZ;
    }

    public int getPlayDrawableResId() {
        return this.zzara;
    }

    public int getRewind10DrawableResId() {
        return this.zzarh;
    }

    public int getRewind30DrawableResId() {
        return this.zzari;
    }

    public int getRewindDrawableResId() {
        return this.zzarg;
    }

    public int getSkipNextDrawableResId() {
        return this.zzarb;
    }

    public int getSkipPrevDrawableResId() {
        return this.zzarc;
    }

    public long getSkipStepMs() {
        return this.zzaqV;
    }

    public int getSmallIconDrawableResId() {
        return this.zzaqX;
    }

    public int getStopLiveStreamDrawableResId() {
        return this.zzaqY;
    }

    public int getStopLiveStreamTitleResId() {
        return this.zzarm;
    }

    public String getTargetActivityClassName() {
        return this.zzaqW;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public int zzsT() {
        return this.zzark;
    }

    public int zzsU() {
        return this.zzarn;
    }

    public int zzsV() {
        return this.zzaro;
    }

    public int zzsW() {
        return this.zzarp;
    }

    public int zzsX() {
        return this.zzarq;
    }

    public int zzsY() {
        return this.zzarr;
    }

    public int zzsZ() {
        return this.zzars;
    }

    public int zzta() {
        return this.zzart;
    }

    public int zztb() {
        return this.zzaru;
    }

    public int zztc() {
        return this.zzarv;
    }

    public int zztd() {
        return this.zzarw;
    }

    public int zzte() {
        return this.zzarx;
    }
}
