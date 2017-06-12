package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaly extends IInterface {

    public static abstract class zza extends Binder implements zzaly {

        private static class zza implements zzaly {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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

            public void zza(zzamh com_google_android_gms_internal_zzamh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (com_google_android_gms_internal_zzamh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzamh.writeToParcel(obtain, 0);
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

        public static zzaly zzbX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaly)) ? new zza(iBinder) : (zzaly) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Status status = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzamh com_google_android_gms_internal_zzamh;
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzamh = (zzamh) zzamh.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzamh);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (parcel.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(parcel);
                    }
                    onError(status);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onError(Status status) throws RemoteException;

    void zza(zzamh com_google_android_gms_internal_zzamh) throws RemoteException;
}
