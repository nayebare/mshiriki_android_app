package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zza;
import com.google.android.gms.wallet.Wallet.zzb;

@SuppressLint({"MissingRemoteException"})
public class zzbib implements Payments {

    /* renamed from: com.google.android.gms.internal.zzbib.1 */
    class C11601 extends zzb {
        final /* synthetic */ int val$requestCode;

        C11601(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, int i) {
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zzon(this.val$requestCode);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.2 */
    class C11612 extends zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ MaskedWalletRequest zzbQo;

        C11612(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
            this.zzbQo = maskedWalletRequest;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zza(this.zzbQo, this.val$requestCode);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.3 */
    class C11623 extends zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ FullWalletRequest zzbQp;

        C11623(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
            this.zzbQp = fullWalletRequest;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zza(this.zzbQp, this.val$requestCode);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.4 */
    class C11634 extends zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ String zzbQq;
        final /* synthetic */ String zzbQr;

        C11634(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, String str, String str2, int i) {
            this.zzbQq = str;
            this.zzbQr = str2;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zzf(this.zzbQq, this.zzbQr, this.val$requestCode);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.5 */
    class C11645 extends zzb {
        final /* synthetic */ NotifyTransactionStatusRequest zzbQs;

        C11645(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzbQs = notifyTransactionStatusRequest;
            super(googleApiClient);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zza(this.zzbQs);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.6 */
    class C11656 extends zzb {
        final /* synthetic */ int val$requestCode;

        C11656(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, int i) {
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zzoo(this.val$requestCode);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.7 */
    class C11667 extends zza<BooleanResult> {
        C11667(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected BooleanResult zzL(Status status) {
            return new BooleanResult(status, false);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zza(IsReadyToPayRequest.newBuilder().build(), (zzzv.zzb) this);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzL(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbib.8 */
    class C11678 extends zza<BooleanResult> {
        final /* synthetic */ IsReadyToPayRequest zzbQt;

        C11678(zzbib com_google_android_gms_internal_zzbib, GoogleApiClient googleApiClient, IsReadyToPayRequest isReadyToPayRequest) {
            this.zzbQt = isReadyToPayRequest;
            super(googleApiClient);
        }

        protected BooleanResult zzL(Status status) {
            return new BooleanResult(status, false);
        }

        protected void zza(zzbic com_google_android_gms_internal_zzbic) {
            com_google_android_gms_internal_zzbic.zza(this.zzbQt, (zzzv.zzb) this);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzL(status);
        }
    }

    public void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        googleApiClient.zza(new C11634(this, googleApiClient, str, str2, i));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        googleApiClient.zza(new C11601(this, googleApiClient, i));
    }

    public void isNewUser(GoogleApiClient googleApiClient, int i) {
        googleApiClient.zza(new C11656(this, googleApiClient, i));
    }

    public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C11667(this, googleApiClient));
    }

    public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient, IsReadyToPayRequest isReadyToPayRequest) {
        return googleApiClient.zza(new C11678(this, googleApiClient, isReadyToPayRequest));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        googleApiClient.zza(new C11623(this, googleApiClient, fullWalletRequest, i));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        googleApiClient.zza(new C11612(this, googleApiClient, maskedWalletRequest, i));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.zza(new C11645(this, googleApiClient, notifyTransactionStatusRequest));
    }
}
