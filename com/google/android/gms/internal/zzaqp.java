package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.instantapps.InstantApps;
import com.google.android.gms.instantapps.InstantAppsApi;
import com.google.android.gms.instantapps.InstantAppsApi.LaunchDataResult;
import com.google.android.gms.instantapps.LaunchData;
import com.google.android.gms.instantapps.LaunchSettings;
import java.util.List;

public class zzaqp implements InstantAppsApi {

    static class zza extends com.google.android.gms.internal.zzaql.zza {
        zza() {
        }

        public void zza(Status status, int i) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, PackageInfo packageInfo) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, LaunchData launchData) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, zzaqn com_google_android_gms_internal_zzaqn) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, zzaqu com_google_android_gms_internal_zzaqu) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, zzaqy com_google_android_gms_internal_zzaqy) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, List<zzarf> list) {
            throw new UnsupportedOperationException();
        }

        public void zzjH(int i) {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class zzb<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzaqq> {
        zzb(GoogleApiClient googleApiClient) {
            super(InstantApps.API, googleApiClient);
        }

        protected abstract void zza(Context context, zzaqm com_google_android_gms_internal_zzaqm) throws RemoteException;

        protected final void zza(zzaqq com_google_android_gms_internal_zzaqq) throws RemoteException {
            zza(com_google_android_gms_internal_zzaqq.getContext(), (zzaqm) com_google_android_gms_internal_zzaqq.zzwW());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaqp.1 */
    class C09981 extends zzb<LaunchDataResult> {
        final /* synthetic */ LaunchSettings zzbic;
        final /* synthetic */ String zzsk;

        /* renamed from: com.google.android.gms.internal.zzaqp.1.1 */
        class C09971 extends zza {
            final /* synthetic */ C09981 zzbid;

            C09971(C09981 c09981) {
                this.zzbid = c09981;
            }

            public void zza(Status status, LaunchData launchData) {
                this.zzbid.zzb(new zzc(status, launchData));
            }
        }

        C09981(zzaqp com_google_android_gms_internal_zzaqp, GoogleApiClient googleApiClient, String str, LaunchSettings launchSettings) {
            this.zzsk = str;
            this.zzbic = launchSettings;
            super(googleApiClient);
        }

        protected void zza(Context context, zzaqm com_google_android_gms_internal_zzaqm) throws RemoteException {
            com_google_android_gms_internal_zzaqm.zza(new C09971(this), this.zzsk, this.zzbic);
        }

        protected LaunchDataResult zzbn(Status status) {
            return new zzc(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbn(status);
        }
    }

    static class zzc implements LaunchDataResult {
        private final Status zzagv;
        private final LaunchData zzbie;

        zzc(Status status, LaunchData launchData) {
            this.zzagv = status;
            this.zzbie = launchData;
        }

        public LaunchData getLaunchData() {
            return this.zzbie;
        }

        public Status getStatus() {
            return this.zzagv;
        }
    }

    public Intent getInstantAppIntent(Context context, String str, Intent intent) {
        return zzaqr.getInstantAppIntent(context, str, intent);
    }

    public PendingResult<LaunchDataResult> getInstantAppLaunchData(GoogleApiClient googleApiClient, String str) {
        return getInstantAppLaunchData(googleApiClient, str, new LaunchSettings());
    }

    public PendingResult<LaunchDataResult> getInstantAppLaunchData(GoogleApiClient googleApiClient, String str, LaunchSettings launchSettings) {
        zzac.zzw(googleApiClient);
        zzac.zzw(str);
        return googleApiClient.zza(new C09981(this, googleApiClient, str, launchSettings));
    }

    public boolean initializeIntentClient(Context context) {
        return zzaqr.zzbl(context);
    }
}
