package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Map;

public interface zzadn extends IInterface {

    public static abstract class zza extends Binder implements zzadn {

        private static class zza implements zzadn {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzI(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzadl com_google_android_gms_internal_zzadl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzadl != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzadl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeMap(map);
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.config.internal.IConfigCallbacks");
        }

        public static zzadn zzbD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.config.internal.IConfigCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzadn)) ? new zza(iBinder) : (zzadn) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readHashMap(getClass().getClassLoader()));
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                    zzI(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzadl) zzadl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.config.internal.IConfigCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzI(Status status) throws RemoteException;

    void zza(Status status, zzadl com_google_android_gms_internal_zzadl) throws RemoteException;

    void zza(Status status, Map map) throws RemoteException;

    void zza(Status status, byte[] bArr) throws RemoteException;
}
