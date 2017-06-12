package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzalr extends IInterface {

    public static abstract class zza extends Binder implements zzalr {

        private static class zza implements zzalr {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzamf com_google_android_gms_internal_zzamf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (com_google_android_gms_internal_zzamf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzamf.writeToParcel(obtain, 0);
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

            public void zzb(zzamf com_google_android_gms_internal_zzamf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (com_google_android_gms_internal_zzamf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzamf.writeToParcel(obtain, 0);
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

        public static zzalr zzbQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzalr)) ? new zza(iBinder) : (zzalr) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzamf com_google_android_gms_internal_zzamf = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzamf = (zzamf) zzamf.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzamf);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzamf = (zzamf) zzamf.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_internal_zzamf);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzamf com_google_android_gms_internal_zzamf) throws RemoteException;

    void zzb(zzamf com_google_android_gms_internal_zzamf) throws RemoteException;
}
