package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzaqb;

public final class Address {
    public static final Api<AddressOptions> API;
    static final zzf<zzaqb> zzahc;
    private static final com.google.android.gms.common.api.Api.zza<zzaqb, AddressOptions> zzahd;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    class C08681 extends com.google.android.gms.common.api.Api.zza<zzaqb, AddressOptions> {
        C08681() {
        }

        public zzaqb zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzac.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzaqb((Activity) context, looper, com_google_android_gms_common_internal_zzg, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private static abstract class zza extends com.google.android.gms.internal.zzzv.zza<Status, zzaqb> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.API, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    class C08692 extends zza {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ UserAddressRequest zzbgK;

        C08692(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
            this.zzbgK = userAddressRequest;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzaqb com_google_android_gms_internal_zzaqb) throws RemoteException {
            com_google_android_gms_internal_zzaqb.zza(this.zzbgK, this.val$requestCode);
            zzb(Status.zzayh);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int i) {
            this.theme = i;
        }
    }

    static {
        zzahc = new zzf();
        zzahd = new C08681();
        API = new Api("Address.API", zzahd, zzahc);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
        googleApiClient.zza(new C08692(googleApiClient, userAddressRequest, i));
    }
}
