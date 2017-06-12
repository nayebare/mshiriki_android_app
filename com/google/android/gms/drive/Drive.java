package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzahi;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzahq;
import com.google.android.gms.internal.zzahs;

public final class Drive {
    public static final Api<NoOptions> API;
    public static final DriveApi DriveApi;
    public static final DrivePreferencesApi DrivePreferencesApi;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    public static final Scope zzaJo;
    public static final Scope zzaJp;
    public static final Api<zzb> zzaJq;
    public static final zzg zzaJr;
    public static final zzi zzaJs;
    public static final zzf<zzahk> zzahc;

    public static abstract class zza<O extends ApiOptions> extends com.google.android.gms.common.api.Api.zza<zzahk, O> {
        protected abstract Bundle zza(O o);

        public zzahk zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzahk(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    class C06441 extends zza<NoOptions> {
        C06441() {
        }

        protected Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.2 */
    class C06452 extends zza<zzb> {
        C06452() {
        }

        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzzA();
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzahb;

        public Bundle zzzA() {
            return this.zzahb;
        }
    }

    static {
        zzahc = new zzf();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        zzaJo = new Scope("https://www.googleapis.com/auth/drive");
        zzaJp = new Scope("https://www.googleapis.com/auth/drive.apps");
        API = new Api("Drive.API", new C06441(), zzahc);
        zzaJq = new Api("Drive.INTERNAL_API", new C06452(), zzahc);
        DriveApi = new zzahi();
        zzaJr = new zzahn();
        zzaJs = new zzahs();
        DrivePreferencesApi = new zzahq();
    }

    private Drive() {
    }
}
