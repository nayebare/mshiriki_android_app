package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzavx implements PanoramaApi {

    private static abstract class zzc<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzavy> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzahc, googleApiClient);
        }

        protected abstract void zza(Context context, zzavw com_google_android_gms_internal_zzavw) throws RemoteException;

        protected final void zza(zzavy com_google_android_gms_internal_zzavy) throws RemoteException {
            zza(com_google_android_gms_internal_zzavy.getContext(), (zzavw) com_google_android_gms_internal_zzavy.zzwW());
        }
    }

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult zzby(Status status) {
            return new zzavz(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzby(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavx.1 */
    class C10851 extends zza {
        final /* synthetic */ Uri zzbzm;

        C10851(zzavx com_google_android_gms_internal_zzavx, GoogleApiClient googleApiClient, Uri uri) {
            this.zzbzm = uri;
            super(googleApiClient);
        }

        protected void zza(Context context, zzavw com_google_android_gms_internal_zzavw) throws RemoteException {
            com_google_android_gms_internal_zzavw.zza(new zzb(this), this.zzbzm, null, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavx.2 */
    class C10862 extends zza {
        final /* synthetic */ Uri zzbzm;

        C10862(zzavx com_google_android_gms_internal_zzavx, GoogleApiClient googleApiClient, Uri uri) {
            this.zzbzm = uri;
            super(googleApiClient);
        }

        protected void zza(Context context, zzavw com_google_android_gms_internal_zzavw) throws RemoteException {
            zzavx.zza(context, com_google_android_gms_internal_zzavw, new zzb(this), this.zzbzm, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavx.3 */
    class C10873 extends com.google.android.gms.internal.zzavv.zza {
        final /* synthetic */ Uri zzbzm;
        final /* synthetic */ zzavv zzbzn;
        final /* synthetic */ Context zztd;

        C10873(Context context, Uri uri, zzavv com_google_android_gms_internal_zzavv) {
            this.zztd = context;
            this.zzbzm = uri;
            this.zzbzn = com_google_android_gms_internal_zzavv;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
            zzavx.zzb(this.zztd, this.zzbzm);
            this.zzbzn.zza(i, bundle, i2, intent);
        }
    }

    private static final class zzb extends com.google.android.gms.internal.zzavv.zza {
        private final com.google.android.gms.internal.zzzv.zzb<PanoramaResult> zzaFq;

        public zzb(com.google.android.gms.internal.zzzv.zzb<PanoramaResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzaFq.setResult(new zzavz(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static void zza(Context context, zzavw com_google_android_gms_internal_zzavw, zzavv com_google_android_gms_internal_zzavv, Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            com_google_android_gms_internal_zzavw.zza(new C10873(context, uri, com_google_android_gms_internal_zzavv), uri, bundle, true);
        } catch (RemoteException e) {
            zzb(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zzb(context, uri);
            throw e2;
        }
    }

    private static void zzb(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.zza(new C10851(this, googleApiClient, uri));
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.zza(new C10862(this, googleApiClient, uri));
    }
}
