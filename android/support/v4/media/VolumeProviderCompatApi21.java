package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.VolumeProvider;
import android.support.annotation.RequiresApi;

@TargetApi(21)
@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    /* renamed from: android.support.v4.media.VolumeProviderCompatApi21.1 */
    static class C01601 extends VolumeProvider {
        final /* synthetic */ Delegate val$delegate;

        C01601(int x0, int x1, int x2, Delegate delegate) {
            this.val$delegate = delegate;
            super(x0, x1, x2);
        }

        public void onSetVolumeTo(int volume) {
            this.val$delegate.onSetVolumeTo(volume);
        }

        public void onAdjustVolume(int direction) {
            this.val$delegate.onAdjustVolume(direction);
        }
    }

    VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int volumeControl, int maxVolume, int currentVolume, Delegate delegate) {
        return new C01601(volumeControl, maxVolume, currentVolume, delegate);
    }

    public static void setCurrentVolume(Object volumeProviderObj, int currentVolume) {
        ((VolumeProvider) volumeProviderObj).setCurrentVolume(currentVolume);
    }
}
