package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzbk;
import com.google.android.gms.fitness.request.zzbo;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaof extends IInterface {

    public static abstract class zza extends Binder implements zzaof {

        private static class zza implements zzaof {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
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

            public void zza(zzak com_google_android_gms_fitness_request_zzak) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzak != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzak.writeToParcel(obtain, 0);
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

            public void zza(zzb com_google_android_gms_fitness_request_zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzb != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzb.writeToParcel(obtain, 0);
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

            public void zza(zzbk com_google_android_gms_fitness_request_zzbk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzbk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbk.writeToParcel(obtain, 0);
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

            public void zza(zzbo com_google_android_gms_fitness_request_zzbo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzbo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbo.writeToParcel(obtain, 0);
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
        }

        public static zzaof zzcw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaof)) ? new zza(iBinder) : (zzaof) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzak com_google_android_gms_fitness_request_zzak = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    StartBleScanRequest startBleScanRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(startBleScanRequest);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzbk com_google_android_gms_fitness_request_zzbk;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbk = (zzbk) zzbk.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbk);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzb com_google_android_gms_fitness_request_zzb;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzb = (zzb) zzb.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzb);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    zzbo com_google_android_gms_fitness_request_zzbo;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbo = (zzbo) zzbo.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbo);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzak = (zzak) zzak.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzak);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(zzak com_google_android_gms_fitness_request_zzak) throws RemoteException;

    void zza(zzb com_google_android_gms_fitness_request_zzb) throws RemoteException;

    void zza(zzbk com_google_android_gms_fitness_request_zzbk) throws RemoteException;

    void zza(zzbo com_google_android_gms_fitness_request_zzbo) throws RemoteException;
}
