package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzbb;
import com.google.android.gms.fitness.request.zzbd;
import com.google.android.gms.fitness.request.zzbf;
import com.google.android.gms.fitness.request.zzbh;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaom extends IInterface {

    public static abstract class zza extends Binder implements zzaom {

        private static class zza implements zzaom {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
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

            public void zza(SessionReadRequest sessionReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
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

            public void zza(zzbb com_google_android_gms_fitness_request_zzbb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzbb != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbb.writeToParcel(obtain, 0);
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

            public void zza(zzbd com_google_android_gms_fitness_request_zzbd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzbd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbd.writeToParcel(obtain, 0);
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

            public void zza(zzbf com_google_android_gms_fitness_request_zzbf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzbf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbf.writeToParcel(obtain, 0);
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

            public void zza(zzbh com_google_android_gms_fitness_request_zzbh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzbh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbh.writeToParcel(obtain, 0);
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
        }

        public static zzaom zzcD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaom)) ? new zza(iBinder) : (zzaom) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzbh com_google_android_gms_fitness_request_zzbh = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzbd com_google_android_gms_fitness_request_zzbd;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbd = (zzbd) zzbd.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbd);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzbf com_google_android_gms_fitness_request_zzbf;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbf = (zzbf) zzbf.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbf);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    SessionInsertRequest sessionInsertRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(sessionInsertRequest);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    SessionReadRequest sessionReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(sessionReadRequest);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    zzbb com_google_android_gms_fitness_request_zzbb;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbb = (zzbb) zzbb.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbb);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbh = (zzbh) zzbh.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbh);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException;

    void zza(SessionReadRequest sessionReadRequest) throws RemoteException;

    void zza(zzbb com_google_android_gms_fitness_request_zzbb) throws RemoteException;

    void zza(zzbd com_google_android_gms_fitness_request_zzbd) throws RemoteException;

    void zza(zzbf com_google_android_gms_fitness_request_zzbf) throws RemoteException;

    void zza(zzbh com_google_android_gms_fitness_request_zzbh) throws RemoteException;
}
