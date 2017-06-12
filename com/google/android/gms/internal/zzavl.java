package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.location.LocationStatusCodes;

public interface zzavl extends IInterface {

    public static abstract class zza extends Binder implements zzavl {

        private static class zza implements zzavl {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    this.zzrp.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDisconnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    this.zzrp.transact(PointerIconCompat.TYPE_TEXT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.zzrp.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onEndpointLost(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    this.zzrp.transact(PointerIconCompat.TYPE_HELP, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(PointerIconCompat.TYPE_CROSSHAIR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zzrp.transact(PointerIconCompat.TYPE_CELL, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzlF(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzrp.transact(PointerIconCompat.TYPE_ALIAS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzlG(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzrp.transact(PointerIconCompat.TYPE_NO_DROP, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzlH(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzrp.transact(PointerIconCompat.TYPE_ALL_SCROLL, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzlI(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    this.zzrp.transact(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzrp.transact(PointerIconCompat.TYPE_VERTICAL_TEXT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        }

        public static zzavl zzeA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzavl)) ? new zza(iBinder) : (zzavl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onConnectionRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointFound(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_HELP /*1003*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointLost(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_CELL /*1006*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_CROSSHAIR /*1007*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onMessageReceived(parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_TEXT /*1008*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onDisconnected(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_VERTICAL_TEXT /*1009*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzo(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_ALIAS /*1010*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzlF(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_NO_DROP /*1012*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzlG(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_ALL_SCROLL /*1013*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzlH(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /*1014*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzlI(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void onDisconnected(String str) throws RemoteException;

    void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException;

    void onEndpointLost(String str) throws RemoteException;

    void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException;

    void zza(String str, int i, byte[] bArr) throws RemoteException;

    void zzlF(int i) throws RemoteException;

    void zzlG(int i) throws RemoteException;

    void zzlH(int i) throws RemoteException;

    void zzlI(int i) throws RemoteException;

    void zzo(int i, String str) throws RemoteException;
}
