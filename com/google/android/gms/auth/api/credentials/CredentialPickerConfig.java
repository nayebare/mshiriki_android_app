package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CredentialPickerConfig extends zza implements ReflectedParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR;
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzaim;
    @Deprecated
    private final boolean zzain;
    private final int zzaio;

    public static class Builder {
        private boolean mShowCancelButton;
        private boolean zzaim;
        private int zzaip;

        public Builder() {
            this.zzaim = false;
            this.mShowCancelButton = true;
            this.zzaip = 1;
        }

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig();
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzaip = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i) {
            this.zzaip = i;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzaim = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    static {
        CREATOR = new zzb();
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        int i3 = 3;
        boolean z4 = true;
        this.mVersionCode = i;
        this.zzaim = z;
        this.mShowCancelButton = z2;
        if (i < 2) {
            this.zzain = z3;
            if (!z3) {
                i3 = 1;
            }
            this.zzaio = i3;
            return;
        }
        if (i2 != 3) {
            z4 = false;
        }
        this.zzain = z4;
        this.zzaio = i2;
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.zzaim, builder.mShowCancelButton, false, builder.zzaip);
    }

    @Deprecated
    public boolean isForNewAccount() {
        return this.zzaio == 3;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zzaim;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    int zzqw() {
        return this.zzaio;
    }
}
