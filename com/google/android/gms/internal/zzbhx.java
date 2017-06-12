package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.InitializeBuyFlowRequest;
import com.google.android.gms.wallet.firstparty.zzd;
import com.google.android.gms.wallet.firstparty.zzh;
import com.google.android.gms.wallet.firstparty.zzl;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wallet.zze;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzbhx extends IInterface {

    public static abstract class zza extends Binder implements zzbhx {

        private static class zza implements zzbhx {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzQ(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzR(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (isReadyToPayRequest != null) {
                        obtain.writeInt(1);
                        isReadyToPayRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzbhz com_google_android_gms_internal_zzbhz) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbhz != null) {
                        iBinder = com_google_android_gms_internal_zzbhz.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (initializeBuyFlowRequest != null) {
                        obtain.writeInt(1);
                        initializeBuyFlowRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(com.google.android.gms.wallet.firstparty.zza com_google_android_gms_wallet_firstparty_zza, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (com_google_android_gms_wallet_firstparty_zza != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wallet_firstparty_zza.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_wallet_firstparty_zzd, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (com_google_android_gms_wallet_firstparty_zzd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wallet_firstparty_zzd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_wallet_firstparty_zzh, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (com_google_android_gms_wallet_firstparty_zzh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wallet_firstparty_zzh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzl com_google_android_gms_wallet_firstparty_zzl, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (com_google_android_gms_wallet_firstparty_zzl != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wallet_firstparty_zzl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zze com_google_android_gms_wallet_zze, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (com_google_android_gms_wallet_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wallet_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbia != null) {
                        iBinder = com_google_android_gms_internal_zzbia.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzbhx zzfo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzbhx)) ? new zza(iBinder) : (zzbhx) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (zze) zze.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbhz.zza.zzfq(parcel.readStrongBinder()));
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (zzl) zzl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzQ(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzR(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzb(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (zzd) zzd.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (InitializeBuyFlowRequest) InitializeBuyFlowRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (IsReadyToPayRequest) IsReadyToPayRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (zzh) zzh.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (com.google.android.gms.wallet.firstparty.zza) com.google.android.gms.wallet.firstparty.zza.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbia.zza.zzfr(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzQ(Bundle bundle) throws RemoteException;

    void zzR(Bundle bundle) throws RemoteException;

    void zza(Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzbhz com_google_android_gms_internal_zzbhz) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(com.google.android.gms.wallet.firstparty.zza com_google_android_gms_wallet_firstparty_zza, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(zzd com_google_android_gms_wallet_firstparty_zzd, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(zzh com_google_android_gms_wallet_firstparty_zzh, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(zzl com_google_android_gms_wallet_firstparty_zzl, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(zze com_google_android_gms_wallet_zze, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;

    void zzb(Bundle bundle, zzbia com_google_android_gms_internal_zzbia) throws RemoteException;
}
