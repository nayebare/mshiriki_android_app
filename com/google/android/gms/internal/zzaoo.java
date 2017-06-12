package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.zzp;
import com.google.android.gms.wearable.MessageApi;

public interface zzaoo extends IInterface {

    public static abstract class zza extends Binder implements zzaoo {

        private static class zza implements zzaoo {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzp com_google_android_gms_fitness_result_zzp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IReadRawCallback");
                    if (com_google_android_gms_fitness_result_zzp != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_result_zzp.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzaoo zzcF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IReadRawCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaoo)) ? new zza(iBinder) : (zzaoo) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IReadRawCallback");
                    zza(parcel.readInt() != 0 ? (zzp) zzp.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IReadRawCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzp com_google_android_gms_fitness_result_zzp) throws RemoteException;
}
