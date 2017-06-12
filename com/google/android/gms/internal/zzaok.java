package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzbm;
import com.google.android.gms.fitness.request.zzbq;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaok extends IInterface {

    public static abstract class zza extends Binder implements zzaok {

        private static class zza implements zzaok {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzam com_google_android_gms_fitness_request_zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (com_google_android_gms_fitness_request_zzam != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzam.writeToParcel(obtain, 0);
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

            public void zza(zzbm com_google_android_gms_fitness_request_zzbm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (com_google_android_gms_fitness_request_zzbm != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbm.writeToParcel(obtain, 0);
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

            public void zza(zzbq com_google_android_gms_fitness_request_zzbq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (com_google_android_gms_fitness_request_zzbq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzbq.writeToParcel(obtain, 0);
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
        }

        public static zzaok zzcB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaok)) ? new zza(iBinder) : (zzaok) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzam com_google_android_gms_fitness_request_zzam = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzbm com_google_android_gms_fitness_request_zzbm;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbm = (zzbm) zzbm.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbm);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzbq com_google_android_gms_fitness_request_zzbq;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzbq = (zzbq) zzbq.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzbq);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzam = (zzam) zzam.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzam);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzam com_google_android_gms_fitness_request_zzam) throws RemoteException;

    void zza(zzbm com_google_android_gms_fitness_request_zzbm) throws RemoteException;

    void zza(zzbq com_google_android_gms_fitness_request_zzbq) throws RemoteException;
}
