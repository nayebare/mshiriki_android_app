package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbhf {
    public static Bitmap zzb(Bitmap bitmap, zzbhd com_google_android_gms_internal_zzbhd) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (com_google_android_gms_internal_zzbhd.rotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) zznB(com_google_android_gms_internal_zzbhd.rotation));
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        if (com_google_android_gms_internal_zzbhd.rotation == 1 || com_google_android_gms_internal_zzbhd.rotation == 3) {
            com_google_android_gms_internal_zzbhd.width = height;
            com_google_android_gms_internal_zzbhd.height = width;
        }
        return bitmap;
    }

    private static int zznB(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return 0;
            case MessageApi.FILTER_PREFIX /*1*/:
                return 90;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return 180;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return 270;
            default:
                throw new IllegalArgumentException("Unsupported rotation degree.");
        }
    }
}
