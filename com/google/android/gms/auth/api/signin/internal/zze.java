package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabc;
import com.google.android.gms.internal.zzace;
import java.util.HashSet;

public final class zze {
    private static zzace zzajs;

    private static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzd> {
        public zza(GoogleApiClient googleApiClient) {
            super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zze.1 */
    class C05571 extends zza<GoogleSignInResult> {
        final /* synthetic */ zzl zzajt;
        final /* synthetic */ GoogleSignInOptions zzaju;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zze.1.1 */
        class C05561 extends zza {
            final /* synthetic */ C05571 zzajv;

            C05561(C05571 c05571) {
                this.zzajv = c05571;
            }

            public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                if (googleSignInAccount != null) {
                    this.zzajv.zzajt.zzb(googleSignInAccount, this.zzajv.zzaju);
                }
                this.zzajv.zzb(new GoogleSignInResult(googleSignInAccount, status));
            }
        }

        C05571(GoogleApiClient googleApiClient, zzl com_google_android_gms_auth_api_signin_internal_zzl, GoogleSignInOptions googleSignInOptions) {
            this.zzajt = com_google_android_gms_auth_api_signin_internal_zzl;
            this.zzaju = googleSignInOptions;
            super(googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzi) com_google_android_gms_auth_api_signin_internal_zzd.zzwW()).zza(new C05561(this), this.zzaju);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzn(status);
        }

        protected GoogleSignInResult zzn(Status status) {
            return new GoogleSignInResult(null, status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zze.2 */
    class C05592 extends zza<Status> {

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zze.2.1 */
        class C05581 extends zza {
            final /* synthetic */ C05592 zzajw;

            C05581(C05592 c05592) {
                this.zzajw = c05592;
            }

            public void zzl(Status status) throws RemoteException {
                this.zzajw.zzb(status);
            }
        }

        C05592(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzi) com_google_android_gms_auth_api_signin_internal_zzd.zzwW()).zzb(new C05581(this), com_google_android_gms_auth_api_signin_internal_zzd.zzqU());
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zze.3 */
    class C05613 extends zza<Status> {

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zze.3.1 */
        class C05601 extends zza {
            final /* synthetic */ C05613 zzajx;

            C05601(C05613 c05613) {
                this.zzajx = c05613;
            }

            public void zzm(Status status) throws RemoteException {
                this.zzajx.zzb(status);
            }
        }

        C05613(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzi) com_google_android_gms_auth_api_signin_internal_zzd.zzwW()).zzc(new C05601(this), com_google_android_gms_auth_api_signin_internal_zzd.zzqU());
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static {
        zzajs = new zzace("GoogleSignInCommon", new String[0]);
    }

    public static GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzayh;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public static Intent zza(Context context, GoogleSignInOptions googleSignInOptions) {
        zzajs.zzb("GoogleSignInCommon", "getSignInIntent()");
        Parcelable signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(context, SignInHubActivity.class);
        intent.putExtra("config", signInConfiguration);
        return intent;
    }

    static GoogleSignInResult zza(zzl com_google_android_gms_auth_api_signin_internal_zzl, GoogleSignInOptions googleSignInOptions) {
        zzajs.zzb("GoogleSignInCommon", "getEligibleSavedSignInResult()");
        zzac.zzw(googleSignInOptions);
        GoogleSignInOptions zzrd = com_google_android_gms_auth_api_signin_internal_zzl.zzrd();
        if (zzrd == null || !zza(zzrd.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzqL()) {
            return null;
        }
        if ((googleSignInOptions.zzqK() && (!zzrd.zzqK() || !googleSignInOptions.zzqN().equals(zzrd.zzqN()))) || !new HashSet(zzrd.zzqJ()).containsAll(new HashSet(googleSignInOptions.zzqJ()))) {
            return null;
        }
        GoogleSignInAccount zzrc = com_google_android_gms_auth_api_signin_internal_zzl.zzrc();
        return (zzrc == null || zzrc.zza()) ? null : new GoogleSignInResult(zzrc, Status.zzayh);
    }

    public static OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        zzl zzaa = zzl.zzaa(context);
        Result zza = zza(zzaa, googleSignInOptions);
        if (zza == null) {
            return zza(googleApiClient, zzaa, googleSignInOptions);
        }
        zzajs.zzb("GoogleSignInCommon", "Eligible saved sign in result found");
        return PendingResults.zzb(zza, googleApiClient);
    }

    private static OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, zzl com_google_android_gms_auth_api_signin_internal_zzl, GoogleSignInOptions googleSignInOptions) {
        zzajs.zzb("GoogleSignInCommon", "trySilentSignIn()");
        return new zzabc(googleApiClient.zza(new C05571(googleApiClient, com_google_android_gms_auth_api_signin_internal_zzl, googleSignInOptions)));
    }

    public static PendingResult<Status> zza(GoogleApiClient googleApiClient, Context context) {
        zzl.zzaa(context).zzre();
        for (GoogleApiClient zzuN : GoogleApiClient.zzuM()) {
            zzuN.zzuN();
        }
        return googleApiClient.zzb(new C05592(googleApiClient));
    }

    private static boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    public static PendingResult<Status> zzb(GoogleApiClient googleApiClient, Context context) {
        zzl.zzaa(context).zzre();
        zzajs.zzb("GoogleSignInCommon", "Revoking access");
        for (GoogleApiClient zzuN : GoogleApiClient.zzuM()) {
            zzuN.zzuN();
        }
        return googleApiClient.zzb(new C05613(googleApiClient));
    }
}
