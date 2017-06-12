package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.zzg;
import com.google.android.gms.wearable.MessageApi;

public interface zzaop extends IInterface {

    public static abstract class zza extends Binder implements zzaop {

        private static class zza implements zzaop {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzg com_google_android_gms_fitness_result_zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    if (com_google_android_gms_fitness_result_zzg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_result_zzg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzaop zzcG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IReadStatsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaop)) ? new zza(iBinder) : (zzaop) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    zza(parcel.readInt() != 0 ? (zzg) zzg.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzg com_google_android_gms_fitness_result_zzg) throws RemoteException;
}
