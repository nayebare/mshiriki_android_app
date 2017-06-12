package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest extends zza implements ReflectedParcelable {
    public static final Creator<UserAddressRequest> CREATOR;
    private final int mVersionCode;
    List<CountrySpecification> zzbgL;

    public final class Builder {
        final /* synthetic */ UserAddressRequest zzbgM;

        private Builder(UserAddressRequest userAddressRequest) {
            this.zzbgM = userAddressRequest;
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.zzbgM.zzbgL == null) {
                this.zzbgM.zzbgL = new ArrayList();
            }
            this.zzbgM.zzbgL.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> collection) {
            if (this.zzbgM.zzbgL == null) {
                this.zzbgM.zzbgL = new ArrayList();
            }
            this.zzbgM.zzbgL.addAll(collection);
            return this;
        }

        public UserAddressRequest build() {
            if (this.zzbgM.zzbgL != null) {
                this.zzbgM.zzbgL = Collections.unmodifiableList(this.zzbgM.zzbgL);
            }
            return this.zzbgM;
        }
    }

    static {
        CREATOR = new zza();
    }

    UserAddressRequest() {
        this.mVersionCode = 1;
    }

    UserAddressRequest(int i, List<CountrySpecification> list) {
        this.mVersionCode = i;
        this.zzbgL = list;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder(null);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
