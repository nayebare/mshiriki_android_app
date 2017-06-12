package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationStatusCodes;

public interface IGamesClient extends IInterface {

    public static abstract class Stub extends Binder implements IGamesClient {

        private static class Proxy implements IGamesClient {
            private IBinder zzrp;

            Proxy(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public PopupLocationInfoParcelable zzDX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
                    this.zzrp.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, obtain2, 0);
                    obtain2.readException();
                    PopupLocationInfoParcelable popupLocationInfoParcelable = obtain2.readInt() != 0 ? (PopupLocationInfoParcelable) PopupLocationInfoParcelable.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return popupLocationInfoParcelable;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
        }

        public static IGamesClient zzcR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesClient)) ? new Proxy(iBinder) : (IGamesClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
                    PopupLocationInfoParcelable zzDX = zzDX();
                    parcel2.writeNoException();
                    if (zzDX != null) {
                        parcel2.writeInt(1);
                        zzDX.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IGamesClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    PopupLocationInfoParcelable zzDX() throws RemoteException;
}
