package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class HintRequest extends zza implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR;
    final int mVersionCode;
    private final String[] zzair;
    private final CredentialPickerConfig zzaiu;
    private final boolean zzaiv;
    private final boolean zzaiw;

    public static final class Builder {
        private String[] zzair;
        private CredentialPickerConfig zzaiu;
        private boolean zzaiv;
        private boolean zzaiw;

        public Builder() {
            this.zzaiu = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }

        public HintRequest build() {
            if (this.zzair == null) {
                this.zzair = new String[0];
            }
            if (this.zzaiv || this.zzaiw || this.zzair.length != 0) {
                return new HintRequest();
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

        public Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzaiv = z;
            return this;
        }

        public Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zzaiu = (CredentialPickerConfig) zzac.zzw(credentialPickerConfig);
            return this;
        }

        public Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzaiw = z;
            return this;
        }
    }

    static {
        CREATOR = new zzd();
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr) {
        this.mVersionCode = i;
        this.zzaiu = (CredentialPickerConfig) zzac.zzw(credentialPickerConfig);
        this.zzaiv = z;
        this.zzaiw = z2;
        this.zzair = (String[]) zzac.zzw(strArr);
    }

    private HintRequest(Builder builder) {
        this(1, builder.zzaiu, builder.zzaiv, builder.zzaiw, builder.zzair);
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zzair;
    }

    @NonNull
    public CredentialPickerConfig getHintPickerConfig() {
        return this.zzaiu;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.zzaiv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzqx() {
        return this.zzaiw;
    }
}
