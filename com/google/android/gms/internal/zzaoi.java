package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.zzad;
import com.google.android.gms.fitness.request.zzaf;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzat;
import com.google.android.gms.fitness.request.zzbs;
import com.google.android.gms.fitness.request.zzd;
import com.google.android.gms.fitness.request.zzg;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.fitness.request.zzt;
import com.google.android.gms.fitness.request.zzz;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzaoi extends IInterface {

    public static abstract class zza extends Binder implements zzaoi {

        private static class zza implements zzaoi {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataReadRequest dataReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateListenerRegistrationRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateListenerRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataUpdateRequest dataUpdateRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzad com_google_android_gms_fitness_request_zzad) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzad != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzad.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaf com_google_android_gms_fitness_request_zzaf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzaf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzaf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_fitness_request_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzar != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzat com_google_android_gms_fitness_request_zzat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzat != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzbs com_google_android_gms_fitness_request_zzbs) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzbs != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbs.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_fitness_request_zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzg com_google_android_gms_fitness_request_zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzq com_google_android_gms_fitness_request_zzq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzt com_google_android_gms_fitness_request_zzt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzt != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzt.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzz com_google_android_gms_fitness_request_zzz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzz != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzz.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzg com_google_android_gms_fitness_request_zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaoi zzcz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaoi)) ? new zza(iBinder) : (zzaoi) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzaf com_google_android_gms_fitness_request_zzaf = null;
            zzg com_google_android_gms_fitness_request_zzg;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    DataReadRequest dataReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataReadRequest);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzg = (zzg) zzg.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzg);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    DataDeleteRequest dataDeleteRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataDeleteRequest);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    zzad com_google_android_gms_fitness_request_zzad;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzad = (zzad) zzad.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzad);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    zzat com_google_android_gms_fitness_request_zzat;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzat = (zzat) zzat.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzat);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    zzar com_google_android_gms_fitness_request_zzar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzar = (zzar) zzar.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzar);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    zzd com_google_android_gms_fitness_request_zzd;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzd = (zzd) zzd.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzd);
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzg = (zzg) zzg.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_fitness_request_zzg);
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    DataUpdateRequest dataUpdateRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataUpdateRequest = (DataUpdateRequest) DataUpdateRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataUpdateRequest);
                    parcel2.writeNoException();
                    return true;
                case HTTP.LF /*10*/:
                    DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataUpdateListenerRegistrationRequest = (DataUpdateListenerRegistrationRequest) DataUpdateListenerRegistrationRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataUpdateListenerRegistrationRequest);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    zzq com_google_android_gms_fitness_request_zzq;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzq = (zzq) zzq.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzq);
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    zzz com_google_android_gms_fitness_request_zzz;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzz = (zzz) zzz.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzz);
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    zzt com_google_android_gms_fitness_request_zzt;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzt = (zzt) zzt.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzt);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    zzbs com_google_android_gms_fitness_request_zzbs;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbs = (zzbs) zzbs.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbs);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzaf = (zzaf) zzaf.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzaf);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException;

    void zza(DataReadRequest dataReadRequest) throws RemoteException;

    void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) throws RemoteException;

    void zza(DataUpdateRequest dataUpdateRequest) throws RemoteException;

    void zza(zzad com_google_android_gms_fitness_request_zzad) throws RemoteException;

    void zza(zzaf com_google_android_gms_fitness_request_zzaf) throws RemoteException;

    void zza(zzar com_google_android_gms_fitness_request_zzar) throws RemoteException;

    void zza(zzat com_google_android_gms_fitness_request_zzat) throws RemoteException;

    void zza(zzbs com_google_android_gms_fitness_request_zzbs) throws RemoteException;

    void zza(zzd com_google_android_gms_fitness_request_zzd) throws RemoteException;

    void zza(zzg com_google_android_gms_fitness_request_zzg) throws RemoteException;

    void zza(zzq com_google_android_gms_fitness_request_zzq) throws RemoteException;

    void zza(zzt com_google_android_gms_fitness_request_zzt) throws RemoteException;

    void zza(zzz com_google_android_gms_fitness_request_zzz) throws RemoteException;

    void zzb(zzg com_google_android_gms_fitness_request_zzg) throws RemoteException;
}
