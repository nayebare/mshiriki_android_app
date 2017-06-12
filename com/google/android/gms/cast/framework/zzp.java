package com.google.android.gms.cast.framework;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzp extends IInterface {

    public static abstract class zza extends Binder implements zzp {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.framework.ISessionProvider");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.cast.framework.ISessionProvider");
                    zzd zzcK = zzcK(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzcK != null ? zzcK.asBinder() : null);
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.cast.framework.ISessionProvider");
                    boolean isSessionRecoverable = isSessionRecoverable();
                    parcel2.writeNoException();
                    parcel2.writeInt(isSessionRecoverable ? 1 : 0);
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.cast.framework.ISessionProvider");
                    String category = getCategory();
                    parcel2.writeNoException();
                    parcel2.writeString(category);
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.cast.framework.ISessionProvider");
                    parcel2.writeNoException();
                    parcel2.writeInt(10084208);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.framework.ISessionProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getCategory() throws RemoteException;

    boolean isSessionRecoverable() throws RemoteException;

    zzd zzcK(String str) throws RemoteException;
}
