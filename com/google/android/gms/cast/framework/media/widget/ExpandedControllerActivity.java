package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.C0283R;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzxa;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzxk;
import com.google.android.gms.nearby.connection.Connections;

public abstract class ExpandedControllerActivity extends AppCompatActivity implements ControlButtonsContainer {
    private SessionManager zzaoU;
    private SeekBar zzasI;
    private final Listener zzasr;
    private ImageView zzatA;
    private ImageView zzatB;
    private zzxf zzatC;
    private int[] zzatD;
    private ImageView[] zzatE;
    private View zzatF;
    private ImageView zzatG;
    private TextView zzatH;
    private TextView zzatI;
    private zzxa zzatJ;
    private UIMediaController zzatK;
    private final SessionManagerListener<CastSession> zzatk;
    @DrawableRes
    private int zzatl;
    @ColorRes
    private int zzatm;
    @DrawableRes
    private int zzatn;
    @DrawableRes
    private int zzato;
    @DrawableRes
    private int zzatp;
    @DrawableRes
    private int zzatq;
    @DrawableRes
    private int zzatr;
    @DrawableRes
    private int zzats;
    @DrawableRes
    private int zzatt;
    @DrawableRes
    private int zzatu;
    @DrawableRes
    private int zzatv;
    @DrawableRes
    private int zzatw;
    @DrawableRes
    private int zzatx;
    private int zzaty;
    private TextView zzatz;

    /* renamed from: com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity.1 */
    class C06261 implements com.google.android.gms.internal.zzxa.zza {
        final /* synthetic */ ExpandedControllerActivity zzatL;

        C06261(ExpandedControllerActivity expandedControllerActivity) {
            this.zzatL = expandedControllerActivity;
        }

        public void zzc(Bitmap bitmap) {
            if (bitmap != null) {
                if (this.zzatL.zzatH != null) {
                    this.zzatL.zzatH.setVisibility(8);
                }
                if (this.zzatL.zzatG != null) {
                    this.zzatL.zzatG.setVisibility(0);
                    this.zzatL.zzatG.setImageBitmap(bitmap);
                }
            }
        }
    }

    private class zza implements Listener {
        final /* synthetic */ ExpandedControllerActivity zzatL;

        private zza(ExpandedControllerActivity expandedControllerActivity) {
            this.zzatL = expandedControllerActivity;
        }

        public void onAdBreakStatusUpdated() {
            this.zzatL.zztL();
        }

        public void onMetadataUpdated() {
            this.zzatL.zztJ();
        }

        public void onPreloadStatusUpdated() {
        }

        public void onQueueStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
            this.zzatL.zzatz.setText(this.zzatL.getResources().getString(C0473R.string.cast_expanded_controller_loading));
        }

        public void onStatusUpdated() {
            RemoteMediaClient zzc = this.zzatL.getRemoteMediaClient();
            if (zzc == null || !zzc.hasMediaSession()) {
                this.zzatL.finish();
                return;
            }
            this.zzatL.zztK();
            this.zzatL.zztL();
        }
    }

    private class zzb implements SessionManagerListener<CastSession> {
        final /* synthetic */ ExpandedControllerActivity zzatL;

        private zzb(ExpandedControllerActivity expandedControllerActivity) {
            this.zzatL = expandedControllerActivity;
        }

        public void onSessionEnded(CastSession castSession, int i) {
            this.zzatL.finish();
        }

        public /* bridge */ /* synthetic */ void onSessionEnding(Session session) {
        }

        public /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i) {
        }

        public /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z) {
        }

        public /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        }

        public /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i) {
        }

        public /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        }

        public /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        }

        public /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i) {
        }
    }

    public ExpandedControllerActivity() {
        this.zzatk = new zzb();
        this.zzasr = new zza();
        this.zzatE = new ImageView[4];
    }

    private RemoteMediaClient getRemoteMediaClient() {
        CastSession currentCastSession = this.zzaoU.getCurrentCastSession();
        return (currentCastSession == null || !currentCastSession.isConnected()) ? null : currentCastSession.getRemoteMediaClient();
    }

    private zzxf zza(RelativeLayout relativeLayout) {
        zzxf com_google_android_gms_internal_zzxf = new zzxf(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(0, C0473R.id.end_text);
        layoutParams.addRule(1, C0473R.id.start_text);
        layoutParams.addRule(6, C0473R.id.seek_bar);
        layoutParams.addRule(7, C0473R.id.seek_bar);
        layoutParams.addRule(5, C0473R.id.seek_bar);
        layoutParams.addRule(8, C0473R.id.seek_bar);
        com_google_android_gms_internal_zzxf.setLayoutParams(layoutParams);
        com_google_android_gms_internal_zzxf.setPadding(this.zzasI.getPaddingLeft(), this.zzasI.getPaddingTop(), this.zzasI.getPaddingRight(), this.zzasI.getPaddingBottom());
        com_google_android_gms_internal_zzxf.setContentDescription(getResources().getString(C0473R.string.cast_seek_bar));
        com_google_android_gms_internal_zzxf.setBackgroundColor(0);
        relativeLayout.addView(com_google_android_gms_internal_zzxf);
        return com_google_android_gms_internal_zzxf;
    }

    private void zza(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(C0473R.drawable.quantum_ic_keyboard_arrow_down_white_36);
        }
    }

    private void zza(View view, int i, int i2, UIMediaController uIMediaController) {
        ImageView imageView = (ImageView) view.findViewById(i);
        if (i2 == C0473R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
        } else if (i2 == C0473R.id.cast_button_type_custom) {
        } else {
            if (i2 == C0473R.id.cast_button_type_play_pause_toggle) {
                zza(imageView, uIMediaController);
            } else if (i2 == C0473R.id.cast_button_type_skip_previous) {
                zzb(imageView, uIMediaController);
            } else if (i2 == C0473R.id.cast_button_type_skip_next) {
                zzc(imageView, uIMediaController);
            } else if (i2 == C0473R.id.cast_button_type_rewind_30_seconds) {
                zzd(imageView, uIMediaController);
            } else if (i2 == C0473R.id.cast_button_type_forward_30_seconds) {
                zze(imageView, uIMediaController);
            } else if (i2 == C0473R.id.cast_button_type_mute_toggle) {
                zzf(imageView, uIMediaController);
            } else if (i2 == C0473R.id.cast_button_type_closed_caption) {
                zzg(imageView, uIMediaController);
            }
        }
    }

    private void zza(View view, UIMediaController uIMediaController) {
        this.zzatA = (ImageView) view.findViewById(C0473R.id.background_image_view);
        this.zzatB = (ImageView) view.findViewById(C0473R.id.blurred_background_image_view);
        View findViewById = view.findViewById(C0473R.id.background_place_holder_image_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        uIMediaController.bindImageViewToImageOfCurrentItem(this.zzatA, new ImageHints(4, displayMetrics.widthPixels, displayMetrics.heightPixels), findViewById);
        this.zzatz = (TextView) view.findViewById(C0473R.id.status_text);
        uIMediaController.bindViewToLoadingIndicator((ProgressBar) view.findViewById(C0473R.id.loading_indicator));
        TextView textView = (TextView) view.findViewById(C0473R.id.start_text);
        TextView textView2 = (TextView) view.findViewById(C0473R.id.end_text);
        ImageView imageView = (ImageView) view.findViewById(C0473R.id.live_stream_indicator);
        this.zzasI = (SeekBar) view.findViewById(C0473R.id.seek_bar);
        zztF();
        zztH();
        SeekBar seekBar = (SeekBar) view.findViewById(C0473R.id.live_stream_seek_bar);
        uIMediaController.bindTextViewToStreamPosition(textView, true);
        uIMediaController.bindTextViewToStreamDuration(textView2, imageView);
        uIMediaController.bindSeekBar(this.zzasI);
        uIMediaController.bindViewToUIController(seekBar, new zzxk(seekBar, this.zzasI));
        this.zzatE[0] = (ImageView) view.findViewById(C0473R.id.button_0);
        this.zzatE[1] = (ImageView) view.findViewById(C0473R.id.button_1);
        this.zzatE[2] = (ImageView) view.findViewById(C0473R.id.button_2);
        this.zzatE[3] = (ImageView) view.findViewById(C0473R.id.button_3);
        zza(view, C0473R.id.button_0, this.zzatD[0], uIMediaController);
        zza(view, C0473R.id.button_1, this.zzatD[1], uIMediaController);
        zza(view, C0473R.id.button_play_pause_toggle, C0473R.id.cast_button_type_play_pause_toggle, uIMediaController);
        zza(view, C0473R.id.button_2, this.zzatD[2], uIMediaController);
        zza(view, C0473R.id.button_3, this.zzatD[3], uIMediaController);
        this.zzatF = findViewById(C0473R.id.ad_container);
        this.zzatG = (ImageView) this.zzatF.findViewById(C0473R.id.ad_image_view);
        this.zzatI = (TextView) this.zzatF.findViewById(C0473R.id.ad_label);
        this.zzatH = (TextView) this.zzatF.findViewById(C0473R.id.ad_in_progress_label);
        this.zzatC = zza((RelativeLayout) view.findViewById(C0473R.id.seek_bar_controls));
    }

    private void zza(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        Drawable zzb = zza.zzb(this, this.zzaty, this.zzatq);
        Drawable zzb2 = zza.zzb(this, this.zzaty, this.zzatp);
        Drawable zzb3 = zza.zzb(this, this.zzaty, this.zzatr);
        imageView.setImageDrawable(zzb2);
        uIMediaController.bindImageViewToPlayPauseToggle(imageView, zzb2, zzb, zzb3, null, false);
    }

    private void zzb(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        imageView.setImageDrawable(zza.zzb(this, this.zzaty, this.zzats));
        imageView.setContentDescription(getResources().getString(C0473R.string.cast_skip_prev));
        uIMediaController.bindViewToSkipPrev(imageView, 0);
    }

    private void zzc(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        imageView.setImageDrawable(zza.zzb(this, this.zzaty, this.zzatt));
        imageView.setContentDescription(getResources().getString(C0473R.string.cast_skip_next));
        uIMediaController.bindViewToSkipNext(imageView, 0);
    }

    private void zzd(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        imageView.setImageDrawable(zza.zzb(this, this.zzaty, this.zzatu));
        imageView.setContentDescription(getResources().getString(C0473R.string.cast_rewind_30));
        uIMediaController.bindViewToRewind(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
    }

    private void zze(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        imageView.setImageDrawable(zza.zzb(this, this.zzaty, this.zzatv));
        imageView.setContentDescription(getResources().getString(C0473R.string.cast_forward_30));
        uIMediaController.bindViewToForward(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
    }

    private void zzf(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        imageView.setImageDrawable(zza.zzb(this, this.zzaty, this.zzatw));
        uIMediaController.bindImageViewToMuteToggle(imageView);
    }

    private void zzg(ImageView imageView, UIMediaController uIMediaController) {
        imageView.setBackgroundResource(this.zzatl);
        imageView.setImageDrawable(zza.zzb(this, this.zzaty, this.zzatx));
        uIMediaController.bindViewToClosedCaption(imageView);
    }

    private void zztD() {
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{C0283R.attr.selectableItemBackgroundBorderless, C0283R.attr.colorControlActivated});
        this.zzatl = obtainStyledAttributes.getResourceId(0, 0);
        this.zzatm = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
    }

    private void zztE() {
        boolean z = true;
        TypedArray obtainStyledAttributes = obtainStyledAttributes(null, C0473R.styleable.CastExpandedController, C0473R.attr.castExpandedControllerStyle, C0473R.style.CastExpandedController);
        this.zzaty = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castButtonColor, 0);
        this.zzatn = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castSeekBarProgressDrawable, 0);
        this.zzato = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castSeekBarThumbDrawable, 0);
        this.zzatp = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castPlayButtonDrawable, 0);
        this.zzatq = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castPauseButtonDrawable, 0);
        this.zzatr = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castStopButtonDrawable, 0);
        this.zzats = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castSkipPreviousButtonDrawable, 0);
        this.zzatt = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castSkipNextButtonDrawable, 0);
        this.zzatu = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castRewind30ButtonDrawable, 0);
        this.zzatv = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castForward30ButtonDrawable, 0);
        this.zzatw = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castMuteToggleButtonDrawable, 0);
        this.zzatx = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castClosedCaptionsButtonDrawable, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C0473R.styleable.CastExpandedController_castControlButtons, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            if (obtainTypedArray.length() != 4) {
                z = false;
            }
            zzac.zzas(z);
            this.zzatD = new int[obtainTypedArray.length()];
            for (int i = 0; i < obtainTypedArray.length(); i++) {
                this.zzatD[i] = obtainTypedArray.getResourceId(i, 0);
            }
            obtainTypedArray.recycle();
        } else {
            this.zzatD = new int[]{C0473R.id.cast_button_type_empty, C0473R.id.cast_button_type_empty, C0473R.id.cast_button_type_empty, C0473R.id.cast_button_type_empty};
        }
        obtainStyledAttributes.recycle();
    }

    private void zztF() {
        Drawable drawable = getResources().getDrawable(this.zzatn);
        ColorStateList colorStateList = null;
        if (drawable != null) {
            if (this.zzatn == C0473R.drawable.cast_expanded_controller_seekbar_track) {
                ColorStateList zztG = zztG();
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable wrap = DrawableCompat.wrap(layerDrawable.findDrawableByLayerId(16908301));
                DrawableCompat.setTintList(wrap, zztG);
                layerDrawable.setDrawableByLayerId(16908301, wrap);
                layerDrawable.findDrawableByLayerId(16908288).setColorFilter(getResources().getColor(C0473R.color.cast_expanded_controller_seek_bar_progress_background_tint_color), Mode.SRC_IN);
                colorStateList = zztG;
            }
            this.zzasI.setProgressDrawable(drawable);
        }
        drawable = getResources().getDrawable(this.zzato);
        if (drawable != null) {
            if (this.zzato == C0473R.drawable.cast_expanded_controller_seekbar_thumb) {
                if (colorStateList == null) {
                    colorStateList = zztG();
                }
                drawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            this.zzasI.setThumb(drawable);
        }
    }

    private ColorStateList zztG() {
        int color = getResources().getColor(this.zzatm);
        TypedValue typedValue = new TypedValue();
        getResources().getValue(C0473R.dimen.cast_expanded_controller_seekbar_disabled_alpha, typedValue, true);
        int argb = Color.argb((int) (typedValue.getFloat() * ((float) Color.alpha(color))), Color.red(color), Color.green(color), Color.blue(color));
        int[] iArr = new int[]{color, argb};
        r0 = new int[2][];
        r0[0] = new int[]{16842910};
        r0[1] = new int[]{-16842910};
        return new ColorStateList(r0, iArr);
    }

    @TargetApi(21)
    private void zztH() {
        if (zzs.zzyI()) {
            this.zzasI.setSplitTrack(false);
        }
    }

    @TargetApi(19)
    private void zztI() {
        if (zzs.zzyx()) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            if (zzs.zzyA()) {
                systemUiVisibility ^= 2;
            }
            if (zzs.zzyC()) {
                systemUiVisibility ^= 4;
            }
            if (zzs.zzyF()) {
                systemUiVisibility ^= Connections.MAX_RELIABLE_MESSAGE_LEN;
            }
            getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
            if (zzs.zzyE()) {
                setImmersive(true);
            }
        }
    }

    private void zztJ() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
            if (mediaInfo != null) {
                MediaMetadata metadata = mediaInfo.getMetadata();
                if (metadata != null) {
                    ActionBar supportActionBar = getSupportActionBar();
                    if (supportActionBar != null) {
                        supportActionBar.setTitle(metadata.getString(MediaMetadata.KEY_TITLE));
                    }
                }
            }
        }
    }

    private void zztK() {
        CastSession currentCastSession = this.zzaoU.getCurrentCastSession();
        if (currentCastSession != null) {
            CastDevice castDevice = currentCastSession.getCastDevice();
            if (castDevice != null) {
                if (!TextUtils.isEmpty(castDevice.getFriendlyName())) {
                    this.zzatz.setText(getResources().getString(C0473R.string.cast_casting_to_device, new Object[]{r0}));
                    return;
                }
            }
        }
        this.zzatz.setText(BuildConfig.FLAVOR);
    }

    private void zztL() {
        CharSequence charSequence = null;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        MediaInfo mediaInfo = remoteMediaClient == null ? null : remoteMediaClient.getMediaInfo();
        MediaStatus mediaStatus = remoteMediaClient == null ? null : remoteMediaClient.getMediaStatus();
        boolean z = mediaStatus != null && mediaStatus.isPlayingAd();
        if (z) {
            Object contentUrl;
            if (zzs.zzyD() && this.zzatB.getVisibility() == 8) {
                Drawable drawable = this.zzatA.getDrawable();
                if (drawable != null && (drawable instanceof BitmapDrawable)) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    if (bitmap != null) {
                        bitmap = zza.zza(this, bitmap, 0.25f, 7.5f);
                        if (bitmap != null) {
                            this.zzatB.setImageBitmap(bitmap);
                            this.zzatB.setVisibility(0);
                        }
                    }
                }
            }
            AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
            if (currentAdBreakClip != null) {
                charSequence = currentAdBreakClip.getTitle();
                contentUrl = currentAdBreakClip.getContentUrl();
            } else {
                contentUrl = null;
            }
            this.zzatH.setVisibility(0);
            if (TextUtils.isEmpty(contentUrl)) {
                this.zzatG.setVisibility(8);
            } else {
                this.zzatJ.zzo(Uri.parse(contentUrl));
            }
            TextView textView = this.zzatI;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = getResources().getString(C0473R.string.cast_ad_label);
            }
            textView.setText(charSequence);
            this.zzasI.setEnabled(false);
            this.zzatF.setVisibility(0);
        } else {
            this.zzasI.setEnabled(true);
            this.zzatF.setVisibility(8);
            if (zzs.zzyD()) {
                this.zzatB.setVisibility(8);
                this.zzatB.setImageBitmap(null);
            }
        }
        if (mediaInfo != null) {
            this.zzatC.zzcc(this.zzasI.getMax());
            this.zzatC.zzb(mediaInfo.getAdBreaks(), -1);
        }
    }

    public final ImageView getButtonImageViewAt(int i) throws IndexOutOfBoundsException {
        return this.zzatE[i];
    }

    public final int getButtonSlotCount() {
        return 4;
    }

    public final int getButtonTypeAt(int i) throws IndexOutOfBoundsException {
        return this.zzatD[i];
    }

    public SeekBar getSeekBar() {
        return this.zzasI;
    }

    public TextView getStatusTextView() {
        return this.zzatz;
    }

    public UIMediaController getUIMediaController() {
        return this.zzatK;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CastContext.getSharedInstance(this).registerLifecycleCallbacksBeforeIceCreamSandwich(this, bundle);
        this.zzaoU = CastContext.getSharedInstance(this).getSessionManager();
        if (this.zzaoU.getCurrentCastSession() == null) {
            finish();
        }
        this.zzatK = new UIMediaController(this);
        this.zzatK.setPostRemoteMediaClientListener(this.zzasr);
        setContentView(C0473R.layout.cast_expanded_controller_activity);
        zztD();
        zztE();
        zza(findViewById(C0473R.id.expanded_controller_layout), this.zzatK);
        zza((Toolbar) findViewById(C0473R.id.toolbar));
        zztK();
        zztJ();
        this.zzatJ = new zzxa(getApplicationContext(), new ImageHints(-1, this.zzatG.getWidth(), this.zzatG.getHeight()));
        this.zzatJ.zza(new C06261(this));
    }

    protected void onDestroy() {
        this.zzatJ.clear();
        if (this.zzatK != null) {
            this.zzatK.setPostRemoteMediaClientListener(null);
            this.zzatK.dispose();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return true;
    }

    protected void onPause() {
        CastContext.getSharedInstance(this).getSessionManager().removeSessionManagerListener(this.zzatk, CastSession.class);
        super.onPause();
    }

    protected void onResume() {
        CastContext.getSharedInstance(this).getSessionManager().addSessionManagerListener(this.zzatk, CastSession.class);
        CastSession currentCastSession = CastContext.getSharedInstance(this).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !(currentCastSession.isConnected() || currentCastSession.isConnecting())) {
            finish();
        }
        zztK();
        zztL();
        super.onResume();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            zztI();
        }
    }
}
