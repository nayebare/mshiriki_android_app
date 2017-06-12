package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzbib;
import com.google.android.gms.internal.zzbic;
import com.google.android.gms.internal.zzbie;
import com.google.android.gms.internal.zzbif;
import com.google.android.gms.wallet.firstparty.zzc;
import com.google.android.gms.wallet.wobs.zzr;

public final class Wallet {
    public static final Api<WalletOptions> API;
    public static final Payments Payments;
    private static final zzf<zzbic> zzahc;
    private static final zza<zzbic, WalletOptions> zzahd;
    public static final zzr zzbPt;
    public static final zzc zzbPu;

    static {
        zzahc = new zzf();
        zzahd = new 1();
        API = new Api("Wallet.API", zzahd, zzahc);
        Payments = new zzbib();
        zzbPt = new zzbif();
        zzbPu = new zzbie();
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        Payments.changeMaskedWallet(googleApiClient, str, str2, i);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        Payments.checkForPreAuthorization(googleApiClient, i);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        Payments.loadFullWallet(googleApiClient, fullWalletRequest, i);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        Payments.loadMaskedWallet(googleApiClient, maskedWalletRequest, i);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Payments.notifyTransactionStatus(googleApiClient, notifyTransactionStatusRequest);
    }
}
