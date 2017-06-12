package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest extends zza implements ReflectedParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR;
    private final int mVersionCode;
    String zzUe;
    String zzbNR;
    String zzbNY;
    boolean zzbOV;
    boolean zzbOW;
    boolean zzbOX;
    String zzbOY;
    String zzbOZ;
    Cart zzbOi;
    boolean zzbPa;
    boolean zzbPb;
    CountrySpecification[] zzbPc;
    boolean zzbPd;
    boolean zzbPe;
    ArrayList<CountrySpecification> zzbPf;
    PaymentMethodTokenizationParameters zzbPg;
    ArrayList<Integer> zzbPh;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest zzbPi;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.zzbPi = maskedWalletRequest;
        }

        public Builder addAllowedCardNetwork(int i) {
            if (this.zzbPi.zzbPh == null) {
                this.zzbPi.zzbPh = new ArrayList();
            }
            this.zzbPi.zzbPh.add(Integer.valueOf(i));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> collection) {
            if (collection != null) {
                if (this.zzbPi.zzbPh == null) {
                    this.zzbPi.zzbPh = new ArrayList();
                }
                this.zzbPi.zzbPh.addAll(collection);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.zzbPi.zzbPf == null) {
                this.zzbPi.zzbPf = new ArrayList();
            }
            this.zzbPi.zzbPf.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> collection) {
            if (collection != null) {
                if (this.zzbPi.zzbPf == null) {
                    this.zzbPi.zzbPf = new ArrayList();
                }
                this.zzbPi.zzbPf.addAll(collection);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.zzbPi;
        }

        public Builder setAllowDebitCard(boolean z) {
            this.zzbPi.zzbPe = z;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean z) {
            this.zzbPi.zzbPd = z;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.zzbPi.zzbOi = cart;
            return this;
        }

        public Builder setCountryCode(String str) {
            this.zzbPi.zzUe = str;
            return this;
        }

        public Builder setCurrencyCode(String str) {
            this.zzbPi.zzbNR = str;
            return this;
        }

        public Builder setEstimatedTotalPrice(String str) {
            this.zzbPi.zzbOY = str;
            return this;
        }

        @Deprecated
        public Builder setIsBillingAgreement(boolean z) {
            this.zzbPi.zzbPb = z;
            return this;
        }

        public Builder setMerchantName(String str) {
            this.zzbPi.zzbOZ = str;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            this.zzbPi.zzbNY = str;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            this.zzbPi.zzbPg = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean z) {
            this.zzbPi.zzbOV = z;
            return this;
        }

        public Builder setShippingAddressRequired(boolean z) {
            this.zzbPi.zzbOW = z;
            return this;
        }

        @Deprecated
        public Builder setUseMinimalBillingAddress(boolean z) {
            this.zzbPi.zzbOX = z;
            return this;
        }
    }

    static {
        CREATOR = new zzo();
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzbPd = true;
        this.zzbPe = true;
    }

    MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<CountrySpecification> arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> arrayList2, String str5) {
        this.mVersionCode = i;
        this.zzbNY = str;
        this.zzbOV = z;
        this.zzbOW = z2;
        this.zzbOX = z3;
        this.zzbOY = str2;
        this.zzbNR = str3;
        this.zzbOZ = str4;
        this.zzbOi = cart;
        this.zzbPa = z4;
        this.zzbPb = z5;
        this.zzbPc = countrySpecificationArr;
        this.zzbPd = z6;
        this.zzbPe = z7;
        this.zzbPf = arrayList;
        this.zzbPg = paymentMethodTokenizationParameters;
        this.zzbPh = arrayList2;
        this.zzUe = str5;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder(null);
    }

    public boolean allowDebitCard() {
        return this.zzbPe;
    }

    public boolean allowPrepaidCard() {
        return this.zzbPd;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzbPh;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzbPf;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbPc;
    }

    public Cart getCart() {
        return this.zzbOi;
    }

    public String getCountryCode() {
        return this.zzUe;
    }

    public String getCurrencyCode() {
        return this.zzbNR;
    }

    public String getEstimatedTotalPrice() {
        return this.zzbOY;
    }

    public String getMerchantName() {
        return this.zzbOZ;
    }

    public String getMerchantTransactionId() {
        return this.zzbNY;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbPg;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Deprecated
    public boolean isBillingAgreement() {
        return this.zzbPb;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzbOV;
    }

    public boolean isShippingAddressRequired() {
        return this.zzbOW;
    }

    @Deprecated
    public boolean useMinimalBillingAddress() {
        return this.zzbOX;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
