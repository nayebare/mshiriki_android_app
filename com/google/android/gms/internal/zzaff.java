package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaff extends IInterface {

    public static abstract class zza extends Binder implements zzaff {

        private static class zza implements zzaff {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(Status status, DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Status status, DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        obtain.writeInt(1);
                        dataHolder2.writeToParcel(obtain, 0);
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

            public void zza(Status status, zzaei com_google_android_gms_internal_zzaei) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzaei != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaei.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzaek com_google_android_gms_internal_zzaek) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzaek != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaek.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzafu com_google_android_gms_internal_zzafu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzafu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzafu.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzwg com_google_android_gms_internal_zzwg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzwg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzwg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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

        public zza() {
            attachInterface(this, "com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
        }

        public static zzaff zzbI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaff)) ? new zza(iBinder) : (zzaff) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zzh(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (DataHolder) DataHolder.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (DataHolder) DataHolder.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzafu) zzafu.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (DataHolder) DataHolder.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzwg) zzwg.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzaek) zzaek.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzaei) zzaei.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.contextmanager.internal.IContextManagerPendingResult");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(Status status, DataHolder dataHolder) throws RemoteException;

    void zza(Status status, DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    void zza(Status status, zzaei com_google_android_gms_internal_zzaei) throws RemoteException;

    void zza(Status status, zzaek com_google_android_gms_internal_zzaek) throws RemoteException;

    void zza(Status status, zzafu com_google_android_gms_internal_zzafu) throws RemoteException;

    void zza(Status status, zzwg com_google_android_gms_internal_zzwg) throws RemoteException;

    void zzh(Status status) throws RemoteException;
}
