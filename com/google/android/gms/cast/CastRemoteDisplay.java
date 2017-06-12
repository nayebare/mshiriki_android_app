package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzyp;
import com.google.android.gms.internal.zzyt;
import com.google.android.gms.internal.zzza;
import com.google.android.gms.internal.zzzb;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API;
    public static final int CONFIGURATION_INTERACTIVE_NONREALTIME = 2;
    public static final int CONFIGURATION_INTERACTIVE_REALTIME = 1;
    public static final int CONFIGURATION_NONINTERACTIVE = 3;
    public static final CastRemoteDisplayApi CastRemoteDisplayApi;
    private static final zza<zzzb, CastRemoteDisplayOptions> zzahd;

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplay.1 */
    class C05771 extends zza<zzzb, CastRemoteDisplayOptions> {
        C05771() {
        }

        public zzzb zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, CastRemoteDisplayOptions castRemoteDisplayOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            Bundle bundle = new Bundle();
            bundle.putInt("configuration", castRemoteDisplayOptions.zzamr);
            return new zzzb(context, looper, com_google_android_gms_common_internal_zzg, castRemoteDisplayOptions.zzalZ, bundle, castRemoteDisplayOptions.zzamq, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class CastRemoteDisplayOptions implements HasOptions {
        final CastDevice zzalZ;
        final CastRemoteDisplaySessionCallbacks zzamq;
        final int zzamr;

        public static final class Builder {
            CastDevice zzamc;
            CastRemoteDisplaySessionCallbacks zzams;
            int zzamt;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks) {
                zzac.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzamc = castDevice;
                this.zzams = castRemoteDisplaySessionCallbacks;
                this.zzamt = CastRemoteDisplay.CONFIGURATION_INTERACTIVE_NONREALTIME;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions();
            }

            public Builder setConfigPreset(@Configuration int i) {
                this.zzamt = i;
                return this;
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzalZ = builder.zzamc;
            this.zzamq = builder.zzams;
            this.zzamr = builder.zzamt;
        }
    }

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    public @interface Configuration {
    }

    static {
        zzahd = new C05771();
        API = new Api("CastRemoteDisplay.API", zzahd, zzyt.zzavv);
        CastRemoteDisplayApi = new zzza(API);
    }

    private CastRemoteDisplay() {
    }

    public static final boolean isRemoteDisplaySdkSupported(Context context) {
        zzyp.initialize(context);
        return ((Boolean) zzyp.zzavt.get()).booleanValue();
    }
}
