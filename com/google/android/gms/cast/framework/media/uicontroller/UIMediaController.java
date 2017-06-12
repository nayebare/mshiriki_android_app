package com.google.android.gms.cast.framework.media.uicontroller;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzxg;
import com.google.android.gms.internal.zzxh;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzxm;
import com.google.android.gms.internal.zzxn;
import com.google.android.gms.internal.zzxo;
import com.google.android.gms.internal.zzxp;
import com.google.android.gms.internal.zzxq;
import com.google.android.gms.internal.zzxr;
import com.google.android.gms.internal.zzxs;
import com.google.android.gms.internal.zzxt;
import com.google.android.gms.internal.zzxu;
import com.google.android.gms.internal.zzxv;
import com.google.android.gms.internal.zzxw;
import com.google.android.gms.internal.zzxx;
import com.google.android.gms.internal.zzxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UIMediaController implements SessionManagerListener<CastSession>, Listener {
    private final Activity mActivity;
    private final SessionManager zzaoU;
    private RemoteMediaClient zzapk;
    private final Map<View, List<UIController>> zzasp;
    private final Set<zzxw> zzasq;
    private Listener zzasr;

    /* renamed from: com.google.android.gms.cast.framework.media.uicontroller.UIMediaController.1 */
    class C06251 implements OnSeekBarChangeListener {
        final /* synthetic */ UIMediaController zzass;

        C06251(UIMediaController uIMediaController) {
            this.zzass = uIMediaController;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                for (zzxw zzD : this.zzass.zzasq) {
                    zzD.zzD((long) i);
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            for (zzxw zzan : this.zzass.zzasq) {
                zzan.zzan(false);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            for (zzxw zzan : this.zzass.zzasq) {
                zzan.zzan(true);
            }
        }
    }

    public UIMediaController(Activity activity) {
        this.zzasp = new HashMap();
        this.zzasq = new HashSet();
        this.mActivity = activity;
        this.zzaoU = CastContext.getSharedInstance(activity).getSessionManager();
        this.zzaoU.addSessionManagerListener(this, CastSession.class);
        zza(this.zzaoU.getCurrentCastSession());
    }

    private void zza(View view, UIController uIController) {
        List list = (List) this.zzasp.get(view);
        if (list == null) {
            list = new ArrayList();
            this.zzasp.put(view, list);
        }
        list.add(uIController);
        if (isActive()) {
            uIController.onSessionConnected(this.zzaoU.getCurrentCastSession());
            zztw();
        }
    }

    private void zza(Session session) {
        if (!isActive() && (session instanceof CastSession) && session.isConnected()) {
            CastSession castSession = (CastSession) session;
            this.zzapk = castSession.getRemoteMediaClient();
            if (this.zzapk != null) {
                this.zzapk.addListener(this);
                for (List<UIController> it : this.zzasp.values()) {
                    for (UIController onSessionConnected : it) {
                        onSessionConnected.onSessionConnected(castSession);
                    }
                }
                zztw();
            }
        }
    }

    private void zztv() {
        if (isActive()) {
            for (List<UIController> it : this.zzasp.values()) {
                for (UIController onSessionEnded : it) {
                    onSessionEnded.onSessionEnded();
                }
            }
            this.zzapk.removeListener(this);
            this.zzapk = null;
        }
    }

    private void zztw() {
        for (List<UIController> it : this.zzasp.values()) {
            for (UIController onMediaStatusUpdated : it) {
                onMediaStatusUpdated.onMediaStatusUpdated();
            }
        }
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView, int i, @DrawableRes int i2) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxi(imageView, this.mActivity, new ImageHints(i, 0, 0), i2, null));
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView, int i, View view) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxi(imageView, this.mActivity, new ImageHints(i, 0, 0), 0, view));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, @NonNull ImageHints imageHints, @DrawableRes int i) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxi(imageView, this.mActivity, imageHints, i, null));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, @NonNull ImageHints imageHints, View view) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxi(imageView, this.mActivity, imageHints, 0, view));
    }

    @Deprecated
    public void bindImageViewToImageOfPreloadedItem(ImageView imageView, int i, @DrawableRes int i2) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxh(imageView, this.mActivity, new ImageHints(i, 0, 0), i2));
    }

    public void bindImageViewToImageOfPreloadedItem(ImageView imageView, @NonNull ImageHints imageHints, @DrawableRes int i) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxh(imageView, this.mActivity, imageHints, i));
    }

    public void bindImageViewToMuteToggle(ImageView imageView) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxo(imageView, this.mActivity));
    }

    public void bindImageViewToPlayPauseToggle(@NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, Drawable drawable3, View view, boolean z) {
        zzac.zzdn("Must be called from the main thread.");
        zza(imageView, new zzxp(imageView, this.mActivity, drawable, drawable2, drawable3, view, z));
    }

    public void bindProgressBar(ProgressBar progressBar) {
        bindProgressBar(progressBar, 1000);
    }

    public void bindProgressBar(ProgressBar progressBar, long j) {
        zzac.zzdn("Must be called from the main thread.");
        zza(progressBar, new zzxq(progressBar, j));
    }

    public void bindSeekBar(SeekBar seekBar) {
        bindSeekBar(seekBar, 1000);
    }

    public void bindSeekBar(SeekBar seekBar, long j) {
        zzac.zzdn("Must be called from the main thread.");
        zza(seekBar, new zzxr(seekBar, j, new C06251(this)));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, String str) {
        zzac.zzdn("Must be called from the main thread.");
        bindTextViewToMetadataOfCurrentItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, List<String> list) {
        zzac.zzdn("Must be called from the main thread.");
        zza(textView, new zzxn(textView, list));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView, String str) {
        zzac.zzdn("Must be called from the main thread.");
        bindTextViewToMetadataOfPreloadedItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView, List<String> list) {
        zzac.zzdn("Must be called from the main thread.");
        zza(textView, new zzxm(textView, list));
    }

    public void bindTextViewToStreamDuration(TextView textView) {
        zzac.zzdn("Must be called from the main thread.");
        zza(textView, new zzxv(textView, this.mActivity.getString(C0473R.string.cast_invalid_stream_duration_text), null));
    }

    public void bindTextViewToStreamDuration(TextView textView, View view) {
        zzac.zzdn("Must be called from the main thread.");
        zza(textView, new zzxv(textView, this.mActivity.getString(C0473R.string.cast_invalid_stream_duration_text), view));
    }

    public void bindTextViewToStreamPosition(TextView textView, boolean z) {
        bindTextViewToStreamPosition(textView, z, 1000);
    }

    public void bindTextViewToStreamPosition(TextView textView, boolean z, long j) {
        zzac.zzdn("Must be called from the main thread.");
        zzxw com_google_android_gms_internal_zzxw = new zzxw(textView, j, this.mActivity.getString(C0473R.string.cast_invalid_stream_position_text));
        if (z) {
            this.zzasq.add(com_google_android_gms_internal_zzxw);
        }
        zza(textView, com_google_android_gms_internal_zzxw);
    }

    public void bindViewToClosedCaption(View view) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxg(view, this.mActivity));
    }

    public void bindViewToForward(View view, long j) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxs(view, j));
    }

    public void bindViewToLaunchExpandedController(View view) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxj(view, this.mActivity));
    }

    public void bindViewToLoadingIndicator(View view) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxl(view));
    }

    public void bindViewToRewind(View view, long j) {
        zzac.zzdn("Must be called from the main thread.");
        bindViewToForward(view, -j);
    }

    public void bindViewToSkipNext(View view, int i) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxt(view, i));
    }

    public void bindViewToSkipPrev(View view, int i) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxu(view, i));
    }

    public void bindViewToUIController(View view, UIController uIController) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, uIController);
    }

    public void bindViewVisibilityToMediaSession(View view, int i) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxy(view, i));
    }

    public void bindViewVisibilityToPreloadingEvent(View view, int i) {
        zzac.zzdn("Must be called from the main thread.");
        zza(view, new zzxx(view, i));
    }

    public void dispose() {
        zzac.zzdn("Must be called from the main thread.");
        zztv();
        this.zzasp.clear();
        this.zzaoU.removeSessionManagerListener(this, CastSession.class);
        this.zzasr = null;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        zzac.zzdn("Must be called from the main thread.");
        return this.zzapk;
    }

    public boolean isActive() {
        zzac.zzdn("Must be called from the main thread.");
        return this.zzapk != null;
    }

    public void onAdBreakStatusUpdated() {
        zztw();
        if (this.zzasr != null) {
            this.zzasr.onAdBreakStatusUpdated();
        }
    }

    public void onMetadataUpdated() {
        zztw();
        if (this.zzasr != null) {
            this.zzasr.onMetadataUpdated();
        }
    }

    public void onPreloadStatusUpdated() {
        zztw();
        if (this.zzasr != null) {
            this.zzasr.onPreloadStatusUpdated();
        }
    }

    public void onQueueStatusUpdated() {
        zztw();
        if (this.zzasr != null) {
            this.zzasr.onQueueStatusUpdated();
        }
    }

    public void onSendingRemoteMediaRequest() {
        for (List<UIController> it : this.zzasp.values()) {
            for (UIController onSendingRemoteMediaRequest : it) {
                onSendingRemoteMediaRequest.onSendingRemoteMediaRequest();
            }
        }
        if (this.zzasr != null) {
            this.zzasr.onSendingRemoteMediaRequest();
        }
    }

    public void onSessionEnded(CastSession castSession, int i) {
        zztv();
    }

    public void onSessionEnding(CastSession castSession) {
    }

    public void onSessionResumeFailed(CastSession castSession, int i) {
        zztv();
    }

    public void onSessionResumed(CastSession castSession, boolean z) {
        zza((Session) castSession);
    }

    public void onSessionResuming(CastSession castSession, String str) {
    }

    public void onSessionStartFailed(CastSession castSession, int i) {
        zztv();
    }

    public void onSessionStarted(CastSession castSession, String str) {
        zza((Session) castSession);
    }

    public void onSessionStarting(CastSession castSession) {
    }

    public void onSessionSuspended(CastSession castSession, int i) {
    }

    public void onStatusUpdated() {
        zztw();
        if (this.zzasr != null) {
            this.zzasr.onStatusUpdated();
        }
    }

    public void setPostRemoteMediaClientListener(Listener listener) {
        zzac.zzdn("Must be called from the main thread.");
        this.zzasr = listener;
    }
}
