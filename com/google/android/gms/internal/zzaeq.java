package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.MessageApi;

public interface zzaeq extends IInterface {

    public static abstract class zza extends Binder implements zzaeq {

        private static class zza implements zzaeq {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzaem com_google_android_gms_internal_zzaem) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.fence.internal.IContextFenceListener");
                    if (com_google_android_gms_internal_zzaem != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaem.writeToParcel(obtain, 0);
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

        public zza() {
            attachInterface(this, "com.google.android.gms.contextmanager.fence.internal.IContextFenceListener");
        }

        public static zzaeq zzbF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.contextmanager.fence.internal.IContextFenceListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaeq)) ? new zza(iBinder) : (zzaeq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.fence.internal.IContextFenceListener");
                    zza(parcel.readInt() != 0 ? (zzaem) zzaem.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.contextmanager.fence.internal.IContextFenceListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzaem com_google_android_gms_internal_zzaem) throws RemoteException;
}
