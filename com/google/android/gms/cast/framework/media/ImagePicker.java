package com.google.android.gms.cast.framework.media;

import android.support.annotation.NonNull;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public class ImagePicker {
    public static final int IMAGE_TYPE_EXPANDED_CONTROLLER_BACKGROUND = 4;
    public static final int IMAGE_TYPE_LOCK_SCREEN_BACKGROUND = 3;
    public static final int IMAGE_TYPE_MEDIA_ROUTE_CONTROLLER_DIALOG_BACKGROUND = 0;
    public static final int IMAGE_TYPE_MINI_CONTROLLER_THUMBNAIL = 2;
    public static final int IMAGE_TYPE_NOTIFICATION_THUMBNAIL = 1;
    public static final int IMAGE_TYPE_UNKNOWN = -1;
    private final zzb zzaqO;

    private class zza extends com.google.android.gms.cast.framework.media.zzb.zza {
        final /* synthetic */ ImagePicker zzaqP;

        private zza(ImagePicker imagePicker) {
            this.zzaqP = imagePicker;
        }

        public WebImage onPickImage(MediaMetadata mediaMetadata, int i) {
            return this.zzaqP.onPickImage(mediaMetadata, i);
        }

        public WebImage zza(MediaMetadata mediaMetadata, ImageHints imageHints) {
            return this.zzaqP.onPickImage(mediaMetadata, imageHints);
        }

        public zzd zzsR() {
            return zze.zzA(this.zzaqP);
        }

        public int zzsd() {
            return 10084208;
        }
    }

    public ImagePicker() {
        this.zzaqO = new zza();
    }

    @Deprecated
    public WebImage onPickImage(MediaMetadata mediaMetadata, int i) {
        return (mediaMetadata == null || !mediaMetadata.hasImages()) ? null : (WebImage) mediaMetadata.getImages().get(IMAGE_TYPE_MEDIA_ROUTE_CONTROLLER_DIALOG_BACKGROUND);
    }

    public WebImage onPickImage(MediaMetadata mediaMetadata, @NonNull ImageHints imageHints) {
        return onPickImage(mediaMetadata, imageHints.getType());
    }

    public zzb zzsS() {
        return this.zzaqO;
    }
}
