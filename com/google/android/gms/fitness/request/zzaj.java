package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.zzag;
import com.google.android.gms.wearable.MessageApi;

public interface zzaj extends IInterface {

    public static abstract class zza extends Binder implements zzaj {

        private static class zza implements zzaj {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzb(zzag com_google_android_gms_fitness_data_zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IWearableSyncStatusListener");
                    if (com_google_android_gms_fitness_data_zzag != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_data_zzag.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzaj zzcO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IWearableSyncStatusListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaj)) ? new zza(iBinder) : (zzaj) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.request.IWearableSyncStatusListener");
                    zzb(parcel.readInt() != 0 ? (zzag) zzag.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.request.IWearableSyncStatusListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzb(zzag com_google_android_gms_fitness_data_zzag) throws RemoteException;
}
