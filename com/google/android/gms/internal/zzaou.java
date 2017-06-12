package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.zzv;
import com.google.android.gms.wearable.MessageApi;

public interface zzaou extends IInterface {

    public static abstract class zza extends Binder implements zzaou {

        private static class zza implements zzaou {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzv com_google_android_gms_fitness_result_zzv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IWearableSyncInfoCallback");
                    if (com_google_android_gms_fitness_result_zzv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_result_zzv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzaou zzcL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IWearableSyncInfoCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaou)) ? new zza(iBinder) : (zzaou) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IWearableSyncInfoCallback");
                    zza(parcel.readInt() != 0 ? (zzv) zzv.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IWearableSyncInfoCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzv com_google_android_gms_fitness_result_zzv) throws RemoteException;
}
