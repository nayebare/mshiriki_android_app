package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaun extends IInterface {

    public static abstract class zza extends Binder implements zzaun {

        private static class zza implements zzaun {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void onDisconnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeInt(i);
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzML() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    this.zzrp.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzauj com_google_android_gms_internal_zzauj, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    if (com_google_android_gms_internal_zzauj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzauj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzgl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeString(str);
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzgm(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeString(str);
                    this.zzrp.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzaun zzeu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaun)) ? new zza(iBinder) : (zzaun) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zza(parcel.readInt() != 0 ? (zzauj) zzauj.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    onDisconnected();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    onError(parcel.readInt());
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzgl(parcel.readString());
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzML();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzgm(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDisconnected() throws RemoteException;

    void onError(int i) throws RemoteException;

    void zzML() throws RemoteException;

    void zza(zzauj com_google_android_gms_internal_zzauj, byte[] bArr) throws RemoteException;

    void zzgl(String str) throws RemoteException;

    void zzgm(String str) throws RemoteException;
}
