package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzail extends IInterface {

    public static abstract class zza extends Binder implements zzail {

        private static class zza implements zzail {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(com.google.android.gms.drive.zza com_google_android_gms_drive_zza) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_drive_zza != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_drive_zza.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaii com_google_android_gms_internal_zzaii) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaii != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaii.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzais com_google_android_gms_internal_zzais) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzais != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzais.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaiu com_google_android_gms_internal_zzaiu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaiu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaiu.writeToParcel(obtain, 0);
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

            public void zza(zzaiw com_google_android_gms_internal_zzaiw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaiw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaiw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaiy com_google_android_gms_internal_zzaiy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaiy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaiy.writeToParcel(obtain, 0);
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

            public void zza(zzaja com_google_android_gms_internal_zzaja) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaja != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaja.writeToParcel(obtain, 0);
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

            public void zza(zzaje com_google_android_gms_internal_zzaje) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaje != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaje.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzajg com_google_android_gms_internal_zzajg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzajg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzajg.writeToParcel(obtain, 0);
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

            public void zza(zzaji com_google_android_gms_internal_zzaji) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaji != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaji.writeToParcel(obtain, 0);
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

            public void zza(zzajk com_google_android_gms_internal_zzajk, zzama com_google_android_gms_internal_zzama) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzajk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzajk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzama != null ? com_google_android_gms_internal_zzama.asBinder() : null);
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzajl com_google_android_gms_internal_zzajl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzajl != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzajl.writeToParcel(obtain, 0);
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

            public void zza(zzajn com_google_android_gms_internal_zzajn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzajn != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzajn.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzajq com_google_android_gms_internal_zzajq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzajq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzajq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzajs com_google_android_gms_internal_zzajs) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzajs != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzajs.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaju com_google_android_gms_internal_zzaju) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaju != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaju.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaks com_google_android_gms_internal_zzaks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (com_google_android_gms_internal_zzaks != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaks.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzav(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        public static zzail zzbM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzail)) ? new zza(iBinder) : (zzail) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzajs com_google_android_gms_internal_zzajs = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzaiy com_google_android_gms_internal_zzaiy;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaiy = (zzaiy) zzaiy.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaiy);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzajg com_google_android_gms_internal_zzajg;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzajg = (zzajg) zzajg.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzajg);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzaja com_google_android_gms_internal_zzaja;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaja = (zzaja) zzaja.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaja);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    zzajl com_google_android_gms_internal_zzajl;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzajl = (zzajl) zzajl.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzajl);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    zzaiu com_google_android_gms_internal_zzaiu;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaiu = (zzaiu) zzaiu.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaiu);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    Status status;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(parcel);
                    }
                    onError(status);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    onSuccess();
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    zzaji com_google_android_gms_internal_zzaji;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaji = (zzaji) zzaji.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaji);
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    zzaju com_google_android_gms_internal_zzaju;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaju = (zzaju) zzaju.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaju);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    zzajk com_google_android_gms_internal_zzajk;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzajk = (zzajk) zzajk.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzajk, com.google.android.gms.internal.zzama.zza.zzbZ(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    zzajq com_google_android_gms_internal_zzajq;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzajq = (zzajq) zzajq.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzajq);
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    zzajn com_google_android_gms_internal_zzajn;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzajn = (zzajn) zzajn.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzajn);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    zzaiw com_google_android_gms_internal_zzaiw;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaiw = (zzaiw) zzaiw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaiw);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    zzav(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    zzaje com_google_android_gms_internal_zzaje;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaje = (zzaje) zzaje.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaje);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    com.google.android.gms.drive.zza com_google_android_gms_drive_zza;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_drive_zza = (com.google.android.gms.drive.zza) com.google.android.gms.drive.zza.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_drive_zza);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    zzais com_google_android_gms_internal_zzais;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzais = (zzais) zzais.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzais);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    zzaii com_google_android_gms_internal_zzaii;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaii = (zzaii) zzaii.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaii);
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    zzaks com_google_android_gms_internal_zzaks;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaks = (zzaks) zzaks.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzaks);
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzajs = (zzajs) zzajs.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzajs);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onError(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;

    void zza(com.google.android.gms.drive.zza com_google_android_gms_drive_zza) throws RemoteException;

    void zza(zzaii com_google_android_gms_internal_zzaii) throws RemoteException;

    void zza(zzais com_google_android_gms_internal_zzais) throws RemoteException;

    void zza(zzaiu com_google_android_gms_internal_zzaiu) throws RemoteException;

    void zza(zzaiw com_google_android_gms_internal_zzaiw) throws RemoteException;

    void zza(zzaiy com_google_android_gms_internal_zzaiy) throws RemoteException;

    void zza(zzaja com_google_android_gms_internal_zzaja) throws RemoteException;

    void zza(zzaje com_google_android_gms_internal_zzaje) throws RemoteException;

    void zza(zzajg com_google_android_gms_internal_zzajg) throws RemoteException;

    void zza(zzaji com_google_android_gms_internal_zzaji) throws RemoteException;

    void zza(zzajk com_google_android_gms_internal_zzajk, zzama com_google_android_gms_internal_zzama) throws RemoteException;

    void zza(zzajl com_google_android_gms_internal_zzajl) throws RemoteException;

    void zza(zzajn com_google_android_gms_internal_zzajn) throws RemoteException;

    void zza(zzajq com_google_android_gms_internal_zzajq) throws RemoteException;

    void zza(zzajs com_google_android_gms_internal_zzajs) throws RemoteException;

    void zza(zzaju com_google_android_gms_internal_zzaju) throws RemoteException;

    void zza(zzaks com_google_android_gms_internal_zzaks) throws RemoteException;

    void zzav(boolean z) throws RemoteException;
}
