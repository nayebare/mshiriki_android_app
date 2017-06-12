package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzarq extends IInterface {

    public static abstract class zza extends Binder implements zzarq {

        private static class zza implements zzarq {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(int i, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
        }

        public static zzarq zzdh(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzarq)) ? new zza(iBinder) : (zzarq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    zza(parcel.readInt(), parcel.createStringArray());
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    zzb(parcel.readInt(), parcel.createStringArray());
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    zza(parcel.readInt(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(int i, PendingIntent pendingIntent) throws RemoteException;

    void zza(int i, String[] strArr) throws RemoteException;

    void zzb(int i, String[] strArr) throws RemoteException;
}
