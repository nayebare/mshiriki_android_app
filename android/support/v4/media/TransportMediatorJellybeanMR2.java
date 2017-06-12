package android.support.v4.media;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.drive.DriveFile;

@TargetApi(18)
@RequiresApi(18)
class TransportMediatorJellybeanMR2 {
    OnAudioFocusChangeListener mAudioFocusChangeListener;
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final OnGetPlaybackPositionListener mGetPlaybackPositionListener;
    final Intent mIntent;
    final BroadcastReceiver mMediaButtonReceiver;
    PendingIntent mPendingIntent;
    int mPlayState;
    final OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener;
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final OnWindowAttachListener mWindowAttachListener;
    final OnWindowFocusChangeListener mWindowFocusListener;

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.1 */
    class C01531 implements OnWindowAttachListener {
        C01531() {
        }

        public void onWindowAttached() {
            TransportMediatorJellybeanMR2.this.windowAttached();
        }

        public void onWindowDetached() {
            TransportMediatorJellybeanMR2.this.windowDetached();
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.2 */
    class C01542 implements OnWindowFocusChangeListener {
        C01542() {
        }

        public void onWindowFocusChanged(boolean hasFocus) {
            if (hasFocus) {
                TransportMediatorJellybeanMR2.this.gainFocus();
            } else {
                TransportMediatorJellybeanMR2.this.loseFocus();
            }
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.3 */
    class C01553 extends BroadcastReceiver {
        C01553() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                TransportMediatorJellybeanMR2.this.mTransportCallback.handleKey((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.4 */
    class C01564 implements OnAudioFocusChangeListener {
        C01564() {
        }

        public void onAudioFocusChange(int focusChange) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.handleAudioFocusChange(focusChange);
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.5 */
    class C01575 implements OnGetPlaybackPositionListener {
        C01575() {
        }

        public long onGetPlaybackPosition() {
            return TransportMediatorJellybeanMR2.this.mTransportCallback.getPlaybackPosition();
        }
    }

    /* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2.6 */
    class C01586 implements OnPlaybackPositionUpdateListener {
        C01586() {
        }

        public void onPlaybackPositionUpdate(long newPositionMs) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.playbackPositionUpdate(newPositionMs);
        }
    }

    public TransportMediatorJellybeanMR2(Context context, AudioManager audioManager, View view, TransportMediatorCallback transportCallback) {
        this.mWindowAttachListener = new C01531();
        this.mWindowFocusListener = new C01542();
        this.mMediaButtonReceiver = new C01553();
        this.mAudioFocusChangeListener = new C01564();
        this.mGetPlaybackPositionListener = new C01575();
        this.mPlaybackPositionUpdateListener = new C01586();
        this.mPlayState = 0;
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.mTargetView = view;
        this.mTransportCallback = transportCallback;
        this.mReceiverAction = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.mReceiverAction);
        this.mIntent.setPackage(context.getPackageName());
        this.mReceiverFilter = new IntentFilter();
        this.mReceiverFilter.addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    public Object getRemoteControlClient() {
        return this.mRemoteControl;
    }

    public void destroy() {
        windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    void windowAttached() {
        this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, DriveFile.MODE_READ_ONLY);
        this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
        this.mRemoteControl.setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
    }

    void gainFocus() {
        if (!this.mFocused) {
            this.mFocused = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if (this.mPlayState == 3) {
                takeAudioFocus();
            }
        }
    }

    void takeAudioFocus() {
        if (!this.mAudioFocused) {
            this.mAudioFocused = true;
            this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.mPlayState != 3) {
            this.mPlayState = 3;
            this.mRemoteControl.setPlaybackState(3);
        }
        if (this.mFocused) {
            takeAudioFocus();
        }
    }

    public void refreshState(boolean playing, long position, int transportControls) {
        if (this.mRemoteControl != null) {
            this.mRemoteControl.setPlaybackState(playing ? 3 : 1, position, playing ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.0f);
            this.mRemoteControl.setTransportControlFlags(transportControls);
        }
    }

    public void pausePlaying() {
        if (this.mPlayState == 3) {
            this.mPlayState = 2;
            this.mRemoteControl.setPlaybackState(2);
        }
        dropAudioFocus();
    }

    public void stopPlaying() {
        if (this.mPlayState != 1) {
            this.mPlayState = 1;
            this.mRemoteControl.setPlaybackState(1);
        }
        dropAudioFocus();
    }

    void dropAudioFocus() {
        if (this.mAudioFocused) {
            this.mAudioFocused = false;
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
    }

    void loseFocus() {
        dropAudioFocus();
        if (this.mFocused) {
            this.mFocused = false;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
    }

    void windowDetached() {
        loseFocus();
        if (this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = null;
            this.mRemoteControl = null;
        }
    }
}
