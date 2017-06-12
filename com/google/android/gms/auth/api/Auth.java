package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzun;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzuw;
import com.google.android.gms.internal.zzuz;
import com.google.android.gms.internal.zzvn;
import java.util.Collections;
import java.util.List;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
    public static final CredentialsApi CredentialsApi;
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
    public static final GoogleSignInApi GoogleSignInApi;
    public static final Api<zzb> PROXY_API;
    public static final ProxyApi ProxyApi;
    public static final zzf<zzuz> zzahR;
    public static final zzf<zzup> zzahS;
    public static final zzf<zzd> zzahT;
    private static final zza<zzuz, AuthCredentialsOptions> zzahU;
    private static final zza<zzup, NoOptions> zzahV;
    private static final zza<zzd, GoogleSignInOptions> zzahW;
    public static final Api<NoOptions> zzahX;
    public static final zzun zzahY;

    /* renamed from: com.google.android.gms.auth.api.Auth.1 */
    class C05461 extends zza<zzuz, AuthCredentialsOptions> {
        C05461() {
        }

        public zzuz zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzuz(context, looper, com_google_android_gms_common_internal_zzg, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.2 */
    class C05472 extends zza<zzup, NoOptions> {
        C05472() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzd(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzup zzd(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzup(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.3 */
    class C05483 extends zza<zzd, GoogleSignInOptions> {
        C05483() {
        }

        public zzd zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, @Nullable GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, com_google_android_gms_common_internal_zzg, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public List<Scope> zza(@Nullable GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzqJ();
        }

        public /* synthetic */ List zzp(@Nullable Object obj) {
            return zza((GoogleSignInOptions) obj);
        }
    }

    public static final class AuthCredentialsOptions implements Optional {
        private final String zzahZ;
        private final PasswordSpecification zzaia;

        public static class Builder {
            @NonNull
            private PasswordSpecification zzaia;

            public Builder() {
                this.zzaia = PasswordSpecification.zzaiy;
            }
        }

        public Bundle zzql() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzahZ);
            bundle.putParcelable("password_specification", this.zzaia);
            return bundle;
        }

        public PasswordSpecification zzqt() {
            return this.zzaia;
        }
    }

    static {
        zzahR = new zzf();
        zzahS = new zzf();
        zzahT = new zzf();
        zzahU = new C05461();
        zzahV = new C05472();
        zzahW = new C05483();
        PROXY_API = zza.API;
        CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzahU, zzahR);
        GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzahW, zzahT);
        zzahX = new Api("Auth.ACCOUNT_STATUS_API", zzahV, zzahS);
        ProxyApi = new zzvn();
        CredentialsApi = new zzuw();
        zzahY = new zzuo();
        GoogleSignInApi = new zzc();
    }

    private Auth() {
    }
}
