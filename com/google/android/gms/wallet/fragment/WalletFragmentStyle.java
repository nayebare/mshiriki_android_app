package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class WalletFragmentStyle extends zza {
    public static final Creator<WalletFragmentStyle> CREATOR;
    final int mVersionCode;
    Bundle zzbPN;
    int zzbQn;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonAppearance {
        public static final int ANDROID_PAY_DARK = 4;
        public static final int ANDROID_PAY_LIGHT = 5;
        public static final int ANDROID_PAY_LIGHT_WITH_BORDER = 6;
        @Deprecated
        public static final int GOOGLE_WALLET_CLASSIC = 1;
        @Deprecated
        public static final int GOOGLE_WALLET_GRAYSCALE = 2;
        @Deprecated
        public static final int GOOGLE_WALLET_MONOCHROME = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonText {
        public static final int BUY_WITH = 5;
        public static final int DONATE_WITH = 7;
        public static final int LOGO_ONLY = 6;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Dimension {
        public static final int MATCH_PARENT = -1;
        public static final int UNIT_DIP = 1;
        public static final int UNIT_IN = 4;
        public static final int UNIT_MM = 5;
        public static final int UNIT_PT = 3;
        public static final int UNIT_PX = 0;
        public static final int UNIT_SP = 2;
        public static final int WRAP_CONTENT = -2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogoImageType {
        public static final int ANDROID_PAY = 3;
        @Deprecated
        public static final int GOOGLE_WALLET_CLASSIC = 1;
        @Deprecated
        public static final int GOOGLE_WALLET_MONOCHROME = 2;
    }

    static {
        CREATOR = new zzc();
    }

    public WalletFragmentStyle() {
        this.mVersionCode = 1;
        this.zzbPN = new Bundle();
        this.zzbPN.putInt("buyButtonAppearanceDefault", 4);
        this.zzbPN.putInt("maskedWalletDetailsLogoImageTypeDefault", 3);
    }

    WalletFragmentStyle(int i, Bundle bundle, int i2) {
        this.mVersionCode = i;
        this.zzbPN = bundle;
        this.zzbQn = i2;
    }

    private static int zza(long j, DisplayMetrics displayMetrics) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                i = 0;
                break;
            case MessageApi.FILTER_PREFIX /*1*/:
                i = 1;
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                i = 2;
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                i = 3;
                break;
            case Dimension.UNIT_IN /*4*/:
                i = 4;
                break;
            case Dimension.UNIT_MM /*5*/:
                i = 5;
                break;
            case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                return TypedValue.complexToDimensionPixelSize(i2, displayMetrics);
            case 129:
                return i2;
            default:
                throw new IllegalStateException("Unexpected unit or type: " + i);
        }
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(i2), displayMetrics));
    }

    private static long zza(TypedValue typedValue) {
        switch (typedValue.type) {
            case Dimension.UNIT_MM /*5*/:
                return zzx(Cast.MAX_NAMESPACE_LENGTH, typedValue.data);
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return zzol(typedValue.data);
            default:
                throw new IllegalArgumentException("Unexpected dimension type: " + typedValue.type);
        }
    }

    private void zza(TypedArray typedArray, int i, String str) {
        if (!this.zzbPN.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.zzbPN.putLong(str, zza(peekValue));
            }
        }
    }

    private void zza(TypedArray typedArray, int i, String str, String str2) {
        if (!this.zzbPN.containsKey(str) && !this.zzbPN.containsKey(str2)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.zzbPN.putInt(str2, peekValue.resourceId);
            } else {
                this.zzbPN.putInt(str, peekValue.data);
            }
        }
    }

    private static long zzb(int i, float f) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
                return zzx(i, Float.floatToIntBits(f));
            default:
                throw new IllegalArgumentException("Unrecognized unit: " + i);
        }
    }

    private void zzb(TypedArray typedArray, int i, String str) {
        if (!this.zzbPN.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.zzbPN.putInt(str, peekValue.data);
            }
        }
    }

    private static long zzol(int i) {
        if (i >= 0) {
            return zzb(0, (float) i);
        }
        if (i == -1 || i == -2) {
            return zzx(129, i);
        }
        throw new IllegalArgumentException("Unexpected dimension value: " + i);
    }

    private static long zzx(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }

    public WalletFragmentStyle setBuyButtonAppearance(int i) {
        this.zzbPN.putInt("buyButtonAppearance", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i) {
        this.zzbPN.putLong("buyButtonHeight", zzol(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i, float f) {
        this.zzbPN.putLong("buyButtonHeight", zzb(i, f));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int i) {
        this.zzbPN.putInt("buyButtonText", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i) {
        this.zzbPN.putLong("buyButtonWidth", zzol(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i, float f) {
        this.zzbPN.putLong("buyButtonWidth", zzb(i, f));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int i) {
        this.zzbPN.remove("maskedWalletDetailsBackgroundResource");
        this.zzbPN.putInt("maskedWalletDetailsBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int i) {
        this.zzbPN.remove("maskedWalletDetailsBackgroundColor");
        this.zzbPN.putInt("maskedWalletDetailsBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int i) {
        this.zzbPN.remove("maskedWalletDetailsButtonBackgroundResource");
        this.zzbPN.putInt("maskedWalletDetailsButtonBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int i) {
        this.zzbPN.remove("maskedWalletDetailsButtonBackgroundColor");
        this.zzbPN.putInt("maskedWalletDetailsButtonBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int i) {
        this.zzbPN.putInt("maskedWalletDetailsButtonTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int i) {
        this.zzbPN.putInt("maskedWalletDetailsHeaderTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int i) {
        this.zzbPN.putInt("maskedWalletDetailsLogoImageType", i);
        return this;
    }

    @Deprecated
    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int i) {
        this.zzbPN.putInt("maskedWalletDetailsLogoTextColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int i) {
        this.zzbPN.putInt("maskedWalletDetailsTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int i) {
        this.zzbQn = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public int zza(String str, DisplayMetrics displayMetrics, int i) {
        return this.zzbPN.containsKey(str) ? zza(this.zzbPN.getLong(str), displayMetrics) : i;
    }

    public void zzbO(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.zzbQn <= 0 ? C0473R.style.WalletFragmentDefaultStyle : this.zzbQn, C0473R.styleable.WalletFragmentStyle);
        zza(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(obtainStyledAttributes, C0473R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }
}
