package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class CredentialRequest extends zza {
    public static final Creator<CredentialRequest> CREATOR;
    final int mVersionCode;
    private final boolean zzaiq;
    private final String[] zzair;
    private final CredentialPickerConfig zzais;
    private final CredentialPickerConfig zzait;

    public static final class Builder {
        private boolean zzaiq;
        private String[] zzair;
        private CredentialPickerConfig zzais;
        private CredentialPickerConfig zzait;

        public CredentialRequest build() {
            if (this.zzair == null) {
                this.zzair = new String[0];
            }
            if (this.zzaiq || this.zzair.length != 0) {
                return new CredentialRequest();
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzair = strArr;
            return this;
        }

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzait = credentialPickerConfig;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzais = credentialPickerConfig;
            return this;
        }

        public Builder setPasswordLoginSupported(boolean z) {
            this.zzaiq = z;
            return this;
        }

        @Deprecated
        public Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    static {
        CREATOR = new zzc();
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.zzaiq = z;
        this.zzair = (String[]) zzac.zzw(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzais = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzait = credentialPickerConfig2;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzaiq, builder.zzair, builder.zzais, builder.zzait);
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zzair;
    }

    @NonNull
    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzait;
    }

    @NonNull
    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzais;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isPasswordLoginSupported() {
        return this.zzaiq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
