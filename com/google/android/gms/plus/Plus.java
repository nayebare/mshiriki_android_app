package com.google.android.gms.plus;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzawg;
import com.google.android.gms.internal.zzawh;
import com.google.android.gms.internal.zzawi;
import com.google.android.gms.internal.zzawj;
import com.google.android.gms.plus.internal.zze;

@Deprecated
public final class Plus {
    @Deprecated
    public static final Api<PlusOptions> API;
    @Deprecated
    public static final Account AccountApi;
    @Deprecated
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final zzf<zze> zzahc;
    static final zza<zze, PlusOptions> zzahd;
    @Deprecated
    public static final zzb zzbzG;
    public static final zza zzbzH;

    static {
        zzahc = new zzf();
        zzahd = new 1();
        API = new Api("Plus.API", zzahd, zzahc);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        PeopleApi = new zzawj();
        AccountApi = new zzawg();
        zzbzG = new zzawi();
        zzbzH = new zzawh();
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzac.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzac.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzac.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zze) googleApiClient.zza(zzahc) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
