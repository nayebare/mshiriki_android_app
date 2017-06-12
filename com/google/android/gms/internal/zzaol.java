package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaol extends IInterface {

    public static abstract class zza extends Binder implements zzaol {

        private static class zza implements zzaol {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
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

            public void zza(zzav com_google_android_gms_fitness_request_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (com_google_android_gms_fitness_request_zzav != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzav.writeToParcel(obtain, 0);
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

            public void zza(zzax com_google_android_gms_fitness_request_zzax) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (com_google_android_gms_fitness_request_zzax != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzax.writeToParcel(obtain, 0);
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
        }

        public static zzaol zzcC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaol)) ? new zza(iBinder) : (zzaol) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzax com_google_android_gms_fitness_request_zzax = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    DataSourcesRequest dataSourcesRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataSourcesRequest);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzav com_google_android_gms_fitness_request_zzav;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzav = (zzav) zzav.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzav);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzax = (zzax) zzax.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzax);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException;

    void zza(zzav com_google_android_gms_fitness_request_zzav) throws RemoteException;

    void zza(zzax com_google_android_gms_fitness_request_zzax) throws RemoteException;
}
