package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzyu;

public class MiniControllerFragment extends Fragment implements ControlButtonsContainer {
    private static final zzyu zzaoQ;
    private int[] zzatD;
    private ImageView[] zzatE;
    private UIMediaController zzatK;
    private boolean zzatM;
    private int zzatN;
    private int zzatO;
    private int zzatP;
    private int zzatQ;
    private int zzatR;
    @DrawableRes
    private int zzatS;
    @DrawableRes
    private int zzatT;
    @DrawableRes
    private int zzatU;
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

    static {
        zzaoQ = new zzyu("MiniControllerFragment");
    }

    public MiniControllerFragment() {
        this.zzatE = new ImageView[3];
    }

    private void zza(Context context, AttributeSet attributeSet) {
        boolean z = true;
        int i = 0;
        if (this.zzatD == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0473R.styleable.CastMiniController, C0473R.attr.castMiniControllerStyle, C0473R.style.CastMiniController);
            this.zzatM = obtainStyledAttributes.getBoolean(C0473R.styleable.CastMiniController_castShowImageThumbnail, true);
            this.zzatN = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castTitleTextAppearance, 0);
            this.zzatO = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castSubtitleTextAppearance, 0);
            this.zzatP = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castBackground, 0);
            this.zzatQ = obtainStyledAttributes.getColor(C0473R.styleable.CastMiniController_castProgressBarColor, 0);
            this.zzaty = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castButtonColor, 0);
            this.zzatp = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castPlayButtonDrawable, 0);
            this.zzatq = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castPauseButtonDrawable, 0);
            this.zzatr = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castStopButtonDrawable, 0);
            this.zzatS = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castPlayButtonDrawable, 0);
            this.zzatT = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castPauseButtonDrawable, 0);
            this.zzatU = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castStopButtonDrawable, 0);
            this.zzats = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castSkipPreviousButtonDrawable, 0);
            this.zzatt = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castSkipNextButtonDrawable, 0);
            this.zzatu = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castRewind30ButtonDrawable, 0);
            this.zzatv = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castForward30ButtonDrawable, 0);
            this.zzatw = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castMuteToggleButtonDrawable, 0);
            this.zzatx = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castClosedCaptionsButtonDrawable, 0);
            int resourceId = obtainStyledAttributes.getResourceId(C0473R.styleable.CastMiniController_castControlButtons, 0);
            if (resourceId != 0) {
                TypedArray obtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                if (obtainTypedArray.length() != 3) {
                    z = false;
                }
                zzac.zzas(z);
                this.zzatD = new int[obtainTypedArray.length()];
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    this.zzatD[i2] = obtainTypedArray.getResourceId(i2, 0);
                }
                obtainTypedArray.recycle();
                if (this.zzatM) {
                    this.zzatD[0] = C0473R.id.cast_button_type_empty;
                }
                this.zzatR = 0;
                int[] iArr = this.zzatD;
                resourceId = iArr.length;
                while (i < resourceId) {
                    if (iArr[i] != C0473R.id.cast_button_type_empty) {
                        this.zzatR++;
                    }
                    i++;
                }
            } else {
                zzaoQ.zzf("Unable to read attribute castControlButtons.", new Object[0]);
                this.zzatD = new int[]{C0473R.id.cast_button_type_empty, C0473R.id.cast_button_type_empty, C0473R.id.cast_button_type_empty};
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void zza(RelativeLayout relativeLayout, int i, int i2) {
        ImageView imageView = (ImageView) relativeLayout.findViewById(i);
        int i3 = this.zzatD[i2];
        if (i3 == C0473R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
        } else if (i3 == C0473R.id.cast_button_type_custom) {
        } else {
            if (i3 == C0473R.id.cast_button_type_play_pause_toggle) {
                int i4 = this.zzatp;
                int i5 = this.zzatq;
                i3 = this.zzatr;
                int i6;
                if (this.zzatR == 1) {
                    i4 = this.zzatS;
                    i5 = this.zzatT;
                    i3 = this.zzatU;
                    i6 = i5;
                    i5 = i4;
                    i4 = i6;
                } else {
                    i6 = i5;
                    i5 = i4;
                    i4 = i6;
                }
                Drawable zza = zza.zza(getContext(), this.zzaty, i5);
                Drawable zza2 = zza.zza(getContext(), this.zzaty, i4);
                Drawable zza3 = zza.zza(getContext(), this.zzaty, i3);
                imageView.setImageDrawable(zza2);
                View zzcd = zzcd(i);
                relativeLayout.addView(zzcd);
                this.zzatK.bindImageViewToPlayPauseToggle(imageView, zza, zza2, zza3, zzcd, true);
            } else if (i3 == C0473R.id.cast_button_type_skip_previous) {
                imageView.setImageDrawable(zza.zza(getContext(), this.zzaty, this.zzats));
                imageView.setContentDescription(getResources().getString(C0473R.string.cast_skip_prev));
                this.zzatK.bindViewToSkipPrev(imageView, 0);
            } else if (i3 == C0473R.id.cast_button_type_skip_next) {
                imageView.setImageDrawable(zza.zza(getContext(), this.zzaty, this.zzatt));
                imageView.setContentDescription(getResources().getString(C0473R.string.cast_skip_next));
                this.zzatK.bindViewToSkipNext(imageView, 0);
            } else if (i3 == C0473R.id.cast_button_type_rewind_30_seconds) {
                imageView.setImageDrawable(zza.zza(getContext(), this.zzaty, this.zzatu));
                imageView.setContentDescription(getResources().getString(C0473R.string.cast_rewind_30));
                this.zzatK.bindViewToRewind(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
            } else if (i3 == C0473R.id.cast_button_type_forward_30_seconds) {
                imageView.setImageDrawable(zza.zza(getContext(), this.zzaty, this.zzatv));
                imageView.setContentDescription(getResources().getString(C0473R.string.cast_forward_30));
                this.zzatK.bindViewToForward(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
            } else if (i3 == C0473R.id.cast_button_type_mute_toggle) {
                imageView.setImageDrawable(zza.zza(getContext(), this.zzaty, this.zzatw));
                this.zzatK.bindImageViewToMuteToggle(imageView);
            } else if (i3 == C0473R.id.cast_button_type_closed_caption) {
                imageView.setImageDrawable(zza.zza(getContext(), this.zzaty, this.zzatx));
                this.zzatK.bindViewToClosedCaption(imageView);
            }
        }
    }

    private ProgressBar zzcd(int i) {
        ProgressBar progressBar = new ProgressBar(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, i);
        layoutParams.addRule(6, i);
        layoutParams.addRule(5, i);
        layoutParams.addRule(7, i);
        layoutParams.addRule(15);
        progressBar.setLayoutParams(layoutParams);
        progressBar.setVisibility(8);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        if (!(this.zzatQ == 0 || indeterminateDrawable == null)) {
            indeterminateDrawable.setColorFilter(this.zzatQ, Mode.SRC_IN);
        }
        return progressBar;
    }

    public final ImageView getButtonImageViewAt(int i) throws IndexOutOfBoundsException {
        return this.zzatE[i];
    }

    public final int getButtonSlotCount() {
        return 3;
    }

    public final int getButtonTypeAt(int i) throws IndexOutOfBoundsException {
        return this.zzatD[i];
    }

    public UIMediaController getUIMediaController() {
        return this.zzatK;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zzatK = new UIMediaController(getActivity());
        View inflate = layoutInflater.inflate(C0473R.layout.cast_mini_controller, viewGroup);
        inflate.setVisibility(8);
        this.zzatK.bindViewVisibilityToMediaSession(inflate, 8);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(C0473R.id.container_current);
        if (this.zzatP != 0) {
            relativeLayout.setBackgroundResource(this.zzatP);
        }
        ImageView imageView = (ImageView) inflate.findViewById(C0473R.id.icon_view);
        TextView textView = (TextView) inflate.findViewById(C0473R.id.title_view);
        if (this.zzatN != 0) {
            textView.setTextAppearance(getActivity(), this.zzatN);
        }
        TextView textView2 = (TextView) inflate.findViewById(C0473R.id.subtitle_view);
        if (this.zzatO != 0) {
            textView2.setTextAppearance(getActivity(), this.zzatO);
        }
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(C0473R.id.progressBar);
        if (this.zzatQ != 0) {
            ((LayerDrawable) progressBar.getProgressDrawable()).setColorFilter(this.zzatQ, Mode.SRC_IN);
        }
        this.zzatK.bindTextViewToMetadataOfCurrentItem(textView, MediaMetadata.KEY_TITLE);
        this.zzatK.bindTextViewToMetadataOfCurrentItem(textView2, MediaMetadata.KEY_SUBTITLE);
        this.zzatK.bindProgressBar(progressBar);
        this.zzatK.bindViewToLaunchExpandedController(relativeLayout);
        if (this.zzatM) {
            this.zzatK.bindImageViewToImageOfCurrentItem(imageView, new ImageHints(2, getResources().getDimensionPixelSize(C0473R.dimen.cast_mini_controller_icon_width), getResources().getDimensionPixelSize(C0473R.dimen.cast_mini_controller_icon_height)), C0473R.drawable.cast_album_art_placeholder);
        } else {
            imageView.setVisibility(8);
        }
        this.zzatE[0] = (ImageView) relativeLayout.findViewById(C0473R.id.button_0);
        this.zzatE[1] = (ImageView) relativeLayout.findViewById(C0473R.id.button_1);
        this.zzatE[2] = (ImageView) relativeLayout.findViewById(C0473R.id.button_2);
        zza(relativeLayout, C0473R.id.button_0, 0);
        zza(relativeLayout, C0473R.id.button_1, 1);
        zza(relativeLayout, C0473R.id.button_2, 2);
        return inflate;
    }

    public void onDestroy() {
        if (this.zzatK != null) {
            this.zzatK.dispose();
            this.zzatK = null;
        }
        super.onDestroy();
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        zza(context, attributeSet);
    }
}
