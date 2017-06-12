package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzab;
import com.google.android.gms.fitness.request.zzap;
import com.google.android.gms.fitness.request.zzu;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaoj extends IInterface {

    public static abstract class zza extends Binder implements zzaoj {

        private static class zza implements zzaoj {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzab com_google_android_gms_fitness_request_zzab) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (com_google_android_gms_fitness_request_zzab != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzab.writeToParcel(obtain, 0);
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

            public void zza(zzap com_google_android_gms_fitness_request_zzap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (com_google_android_gms_fitness_request_zzap != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzap.writeToParcel(obtain, 0);
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

            public void zza(zzu com_google_android_gms_fitness_request_zzu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (com_google_android_gms_fitness_request_zzu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzu.writeToParcel(obtain, 0);
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
        }

        public static zzaoj zzcA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaoj)) ? new zza(iBinder) : (zzaoj) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzab com_google_android_gms_fitness_request_zzab = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzu com_google_android_gms_fitness_request_zzu;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzu = (zzu) zzu.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzu);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzap com_google_android_gms_fitness_request_zzap;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzap = (zzap) zzap.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzap);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzab = (zzab) zzab.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzab);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzab com_google_android_gms_fitness_request_zzab) throws RemoteException;

    void zza(zzap com_google_android_gms_fitness_request_zzap) throws RemoteException;

    void zza(zzu com_google_android_gms_fitness_request_zzu) throws RemoteException;
}
