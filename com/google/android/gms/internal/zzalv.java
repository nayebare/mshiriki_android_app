package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.MessageApi;

public interface zzalv extends IInterface {

    public static abstract class zza extends Binder implements zzalv {

        private static class zza implements zzalv {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzd(boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzalv zzbU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzalv)) ? new zza(iBinder) : (zzalv) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    boolean z2 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzd(z2, z);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzd(boolean z, boolean z2) throws RemoteException;
}
