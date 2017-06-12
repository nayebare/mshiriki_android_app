package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzauq extends IInterface {

    public static abstract class zza extends Binder implements zzauq {

        private static class zza implements zzauq {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public String getToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaup com_google_android_gms_internal_zzaup) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaup != null ? com_google_android_gms_internal_zzaup.asBinder() : null);
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaus com_google_android_gms_internal_zzaus) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzaus != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaus.writeToParcel(obtain, 0);
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

            public void zza(zzauu com_google_android_gms_internal_zzauu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzauu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzauu.writeToParcel(obtain, 0);
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

            public void zza(zzauw com_google_android_gms_internal_zzauw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzauw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzauw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzauy com_google_android_gms_internal_zzauy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzauy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzauy.writeToParcel(obtain, 0);
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

            public void zza(zzava com_google_android_gms_internal_zzava) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzava != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzava.writeToParcel(obtain, 0);
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

            public void zza(zzavc com_google_android_gms_internal_zzavc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzavc != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzavc.writeToParcel(obtain, 0);
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

            public void zza(zzave com_google_android_gms_internal_zzave) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzave != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzave.writeToParcel(obtain, 0);
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

            public void zza(zzavg com_google_android_gms_internal_zzavg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (com_google_android_gms_internal_zzavg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzavg.writeToParcel(obtain, 0);
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

        public static zzauq zzex(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzauq)) ? new zza(iBinder) : (zzauq) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzauu com_google_android_gms_internal_zzauu = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzave com_google_android_gms_internal_zzave;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzave = (zzave) zzave.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzave);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzavg com_google_android_gms_internal_zzavg;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzavg = (zzavg) zzavg.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzavg);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzava com_google_android_gms_internal_zzava;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzava = (zzava) zzava.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzava);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    zzauw com_google_android_gms_internal_zzauw;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzauw = (zzauw) zzauw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzauw);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    zzaus com_google_android_gms_internal_zzaus;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaus = (zzaus) zzaus.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaus);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    zzauy com_google_android_gms_internal_zzauy;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzauy = (zzauy) zzauy.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzauy);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    zzavc com_google_android_gms_internal_zzavc;
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzavc = (zzavc) zzavc.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzavc);
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzauu = (zzauu) zzauu.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzauu);
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    String token = getToken();
                    parcel2.writeNoException();
                    parcel2.writeString(token);
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(com.google.android.gms.internal.zzaup.zza.zzew(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getToken() throws RemoteException;

    void zza(zzaup com_google_android_gms_internal_zzaup) throws RemoteException;

    void zza(zzaus com_google_android_gms_internal_zzaus) throws RemoteException;

    void zza(zzauu com_google_android_gms_internal_zzauu) throws RemoteException;

    void zza(zzauw com_google_android_gms_internal_zzauw) throws RemoteException;

    void zza(zzauy com_google_android_gms_internal_zzauy) throws RemoteException;

    void zza(zzava com_google_android_gms_internal_zzava) throws RemoteException;

    void zza(zzavc com_google_android_gms_internal_zzavc) throws RemoteException;

    void zza(zzave com_google_android_gms_internal_zzave) throws RemoteException;

    void zza(zzavg com_google_android_gms_internal_zzavg) throws RemoteException;
}
