package com.google.android.gms.internal;

import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;

public class zzbip implements Interpolator {
    private float[] zzbUh;
    private float[] zzbUi;

    public zzbip(float f, float f2, float f3, float f4) {
        zzbiq com_google_android_gms_internal_zzbiq = new zzbiq();
        com_google_android_gms_internal_zzbiq.moveTo(0.0f, 0.0f);
        com_google_android_gms_internal_zzbiq.cubicTo(f, f2, f3, f4, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE);
        zza(com_google_android_gms_internal_zzbiq);
    }

    private void zza(zzbiq com_google_android_gms_internal_zzbiq) {
        int i = 0;
        float[] zzj = com_google_android_gms_internal_zzbiq.zzj(0.002f);
        int length = zzj.length / 3;
        if (zzj[1] == 0.0f && zzj[2] == 0.0f && zzj[zzj.length - 2] == TextTrackStyle.DEFAULT_FONT_SCALE && zzj[zzj.length - 1] == TextTrackStyle.DEFAULT_FONT_SCALE) {
            this.zzbUh = new float[length];
            this.zzbUi = new float[length];
            float f = 0.0f;
            float f2 = 0.0f;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                float f3 = zzj[i2];
                int i4 = i3 + 1;
                float f4 = zzj[i3];
                i2 = i4 + 1;
                float f5 = zzj[i4];
                if (f3 == f && f4 != f2) {
                    throw new IllegalArgumentException("The Path cannot have discontinuity in the X axis.");
                } else if (f4 < f2) {
                    throw new IllegalArgumentException("The Path cannot loop back on itself.");
                } else {
                    this.zzbUh[i] = f4;
                    this.zzbUi[i] = f5;
                    i++;
                    f = f3;
                    f2 = f4;
                }
            }
            return;
        }
        throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1)");
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= TextTrackStyle.DEFAULT_FONT_SCALE) {
            return TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        int i = 0;
        int length = this.zzbUh.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.zzbUh[i2]) {
                length = i;
            } else {
                int i3 = length;
                length = i2;
                i2 = i3;
            }
            i = length;
            length = i2;
        }
        float f2 = this.zzbUh[length] - this.zzbUh[i];
        if (f2 == 0.0f) {
            return this.zzbUi[i];
        }
        f2 = (f - this.zzbUh[i]) / f2;
        float f3 = this.zzbUi[i];
        return (f2 * (this.zzbUi[length] - f3)) + f3;
    }
}
