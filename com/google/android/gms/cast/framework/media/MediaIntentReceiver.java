package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";

    private void zza(CastSession castSession, long j) {
        if (j != 0) {
            RemoteMediaClient zzh = zzh(castSession);
            if (zzh != null && !zzh.isLiveStream() && !zzh.isPlayingAd()) {
                zzh.seek(zzh.getApproximateStreamPosition() + j);
            }
        }
    }

    private void zzg(CastSession castSession) {
        RemoteMediaClient zzh = zzh(castSession);
        if (zzh != null) {
            zzh.togglePlayback();
        }
    }

    private RemoteMediaClient zzh(CastSession castSession) {
        return (castSession == null || !castSession.isConnected()) ? null : castSession.getRemoteMediaClient();
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            SessionManager sessionManager = CastContext.getSharedInstance(context).getSessionManager();
            boolean z = true;
            switch (action.hashCode()) {
                case -1699820260:
                    if (action.equals(ACTION_REWIND)) {
                        z = true;
                        break;
                    }
                    break;
                case -945151566:
                    if (action.equals(ACTION_SKIP_NEXT)) {
                        z = true;
                        break;
                    }
                    break;
                case -945080078:
                    if (action.equals(ACTION_SKIP_PREV)) {
                        z = true;
                        break;
                    }
                    break;
                case -668151673:
                    if (action.equals(ACTION_STOP_CASTING)) {
                        z = true;
                        break;
                    }
                    break;
                case -124479363:
                    if (action.equals(ACTION_DISCONNECT)) {
                        z = true;
                        break;
                    }
                    break;
                case 235550565:
                    if (action.equals(ACTION_TOGGLE_PLAYBACK)) {
                        z = false;
                        break;
                    }
                    break;
                case 1362116196:
                    if (action.equals(ACTION_FORWARD)) {
                        z = true;
                        break;
                    }
                    break;
                case 1997055314:
                    if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    onReceiveActionTogglePlayback(sessionManager.getCurrentSession());
                case MessageApi.FILTER_PREFIX /*1*/:
                    onReceiveActionSkipNext(sessionManager.getCurrentSession());
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    onReceiveActionSkipPrev(sessionManager.getCurrentSession());
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    onReceiveActionForward(sessionManager.getCurrentSession(), intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0));
                case Dimension.UNIT_IN /*4*/:
                    onReceiveActionRewind(sessionManager.getCurrentSession(), intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0));
                case Dimension.UNIT_MM /*5*/:
                    sessionManager.endCurrentSession(true);
                case BuyButtonText.LOGO_ONLY /*6*/:
                    sessionManager.endCurrentSession(false);
                case BuyButtonText.DONATE_WITH /*7*/:
                    onReceiveActionMediaButton(sessionManager.getCurrentSession(), intent);
                default:
                    onReceiveOtherAction(action, intent);
            }
        }
    }

    protected void onReceiveActionForward(Session session, long j) {
        if (session instanceof CastSession) {
            zza((CastSession) session, j);
        }
    }

    protected void onReceiveActionMediaButton(Session session, Intent intent) {
        if ((session instanceof CastSession) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            KeyEvent keyEvent = (KeyEvent) intent.getExtras().get("android.intent.extra.KEY_EVENT");
            if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
                zzg((CastSession) session);
            }
        }
    }

    protected void onReceiveActionRewind(Session session, long j) {
        if (session instanceof CastSession) {
            zza((CastSession) session, -j);
        }
    }

    protected void onReceiveActionSkipNext(Session session) {
        if (session instanceof CastSession) {
            RemoteMediaClient zzh = zzh((CastSession) session);
            if (zzh != null && !zzh.isPlayingAd()) {
                zzh.queueNext(null);
            }
        }
    }

    protected void onReceiveActionSkipPrev(Session session) {
        if (session instanceof CastSession) {
            RemoteMediaClient zzh = zzh((CastSession) session);
            if (zzh != null && !zzh.isPlayingAd()) {
                zzh.queuePrev(null);
            }
        }
    }

    protected void onReceiveActionTogglePlayback(Session session) {
        if (session instanceof CastSession) {
            zzg((CastSession) session);
        }
    }

    protected void onReceiveOtherAction(String str, Intent intent) {
    }
}
