package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.nearby.connection.AppMetadata;

public interface zzavm extends IInterface {

    public static abstract class zza extends Binder implements zzavm {

        private static class zza implements zzavm {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzM(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzMU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    this.zzrp.transact(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzavl com_google_android_gms_internal_zzavl, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzavl != null ? com_google_android_gms_internal_zzavl.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_VERTICAL_TEXT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzavl com_google_android_gms_internal_zzavl, String str, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzavl != null ? com_google_android_gms_internal_zzavl.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzrp.transact(PointerIconCompat.TYPE_HELP, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzavl com_google_android_gms_internal_zzavl, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzavl != null ? com_google_android_gms_internal_zzavl.asBinder() : null);
                    obtain.writeString(str);
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzrp.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzavl com_google_android_gms_internal_zzavl, String str, String str2, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzavl != null ? com_google_android_gms_internal_zzavl.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_CROSSHAIR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzavl com_google_android_gms_internal_zzavl, String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzavl != null ? com_google_android_gms_internal_zzavl.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_TEXT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_ALIAS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzar(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzrp.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzas(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_ALL_SCROLL, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzat(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_COPY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_WAIT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzrp.transact(PointerIconCompat.TYPE_NO_DROP, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzavm zzeB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzavm)) ? new zza(iBinder) : (zzavm) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String zzat;
            switch (i) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzavl.zza.zzeA(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzar(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_HELP /*1003*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzavl.zza.zzeA(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_WAIT /*1004*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzk(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_CROSSHAIR /*1007*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzavl.zza.zzeA(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_TEXT /*1008*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzavl.zza.zzeA(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_VERTICAL_TEXT /*1009*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzavl.zza.zzeA(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_ALIAS /*1010*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(parcel.createStringArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_COPY /*1011*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzb(parcel.createStringArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_NO_DROP /*1012*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzl(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_ALL_SCROLL /*1013*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzas(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /*1014*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzM(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /*1015*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzat = zzat(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(zzat);
                    return true;
                case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /*1016*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzat = zzMU();
                    parcel2.writeNoException();
                    parcel2.writeString(zzat);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzM(long j) throws RemoteException;

    String zzMU() throws RemoteException;

    void zza(zzavl com_google_android_gms_internal_zzavl, String str, long j) throws RemoteException;

    void zza(zzavl com_google_android_gms_internal_zzavl, String str, long j, long j2) throws RemoteException;

    void zza(zzavl com_google_android_gms_internal_zzavl, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException;

    void zza(zzavl com_google_android_gms_internal_zzavl, String str, String str2, byte[] bArr, long j) throws RemoteException;

    void zza(zzavl com_google_android_gms_internal_zzavl, String str, byte[] bArr, long j) throws RemoteException;

    void zza(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzar(long j) throws RemoteException;

    void zzas(long j) throws RemoteException;

    String zzat(long j) throws RemoteException;

    void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzk(String str, long j) throws RemoteException;

    void zzl(String str, long j) throws RemoteException;
}
