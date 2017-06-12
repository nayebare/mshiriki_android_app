package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.wearable.MessageApi;

public interface zzaon extends IInterface {

    public static abstract class zza extends Binder implements zzaon {

        private static class zza implements zzaon {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    if (listSubscriptionsResult != null) {
                        obtain.writeInt(1);
                        listSubscriptionsResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        }

        public static zzaon zzcE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaon)) ? new zza(iBinder) : (zzaon) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    zza(parcel.readInt() != 0 ? (ListSubscriptionsResult) ListSubscriptionsResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException;
}
