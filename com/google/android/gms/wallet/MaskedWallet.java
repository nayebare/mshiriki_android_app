package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet extends zza implements ReflectedParcelable {
    public static final Creator<MaskedWallet> CREATOR;
    private final int mVersionCode;
    String zzbNX;
    String zzbNY;
    LoyaltyWalletObject[] zzbOS;
    OfferWalletObject[] zzbOT;
    String zzbOa;
    zza zzbOb;
    zza zzbOc;
    String[] zzbOd;
    UserAddress zzbOe;
    UserAddress zzbOf;
    InstrumentInfo[] zzbOg;

    public final class Builder {
        final /* synthetic */ MaskedWallet zzbOU;

        private Builder(MaskedWallet maskedWallet) {
            this.zzbOU = maskedWallet;
        }

        public MaskedWallet build() {
            return this.zzbOU;
        }

        public Builder setBuyerBillingAddress(UserAddress userAddress) {
            this.zzbOU.zzbOe = userAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress userAddress) {
            this.zzbOU.zzbOf = userAddress;
            return this;
        }

        public Builder setEmail(String str) {
            this.zzbOU.zzbOa = str;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            this.zzbOU.zzbNX = str;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfoArr) {
            this.zzbOU.zzbOg = instrumentInfoArr;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            this.zzbOU.zzbNY = str;
            return this;
        }

        public Builder setPaymentDescriptions(String[] strArr) {
            this.zzbOU.zzbOd = strArr;
            return this;
        }

        @Deprecated
        public Builder zza(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            this.zzbOU.zzbOS = loyaltyWalletObjectArr;
            return this;
        }

        @Deprecated
        public Builder zza(OfferWalletObject[] offerWalletObjectArr) {
            this.zzbOU.zzbOT = offerWalletObjectArr;
            return this;
        }
    }

    static {
        CREATOR = new zzn();
    }

    private MaskedWallet() {
        this.mVersionCode = 2;
    }

    MaskedWallet(int i, String str, String str2, String[] strArr, String str3, zza com_google_android_gms_wallet_zza, zza com_google_android_gms_wallet_zza2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.mVersionCode = i;
        this.zzbNX = str;
        this.zzbNY = str2;
        this.zzbOd = strArr;
        this.zzbOa = str3;
        this.zzbOb = com_google_android_gms_wallet_zza;
        this.zzbOc = com_google_android_gms_wallet_zza2;
        this.zzbOS = loyaltyWalletObjectArr;
        this.zzbOT = offerWalletObjectArr;
        this.zzbOe = userAddress;
        this.zzbOf = userAddress2;
        this.zzbOg = instrumentInfoArr;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzac.zzw(maskedWallet);
        return zzSv().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).zza(maskedWallet.zzSw()).zza(maskedWallet.zzSx()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzSv() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder(null);
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzbOe;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzbOf;
    }

    public String getEmail() {
        return this.zzbOa;
    }

    public String getGoogleTransactionId() {
        return this.zzbNX;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzbOg;
    }

    public String getMerchantTransactionId() {
        return this.zzbNY;
    }

    public String[] getPaymentDescriptions() {
        return this.zzbOd;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    @Deprecated
    public LoyaltyWalletObject[] zzSw() {
        return this.zzbOS;
    }

    @Deprecated
    public OfferWalletObject[] zzSx() {
        return this.zzbOT;
    }
}
