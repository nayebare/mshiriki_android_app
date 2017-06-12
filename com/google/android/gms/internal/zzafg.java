package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzafg extends IInterface {

    public static abstract class zza extends Binder implements zzafg {

        private static class zza implements zzafg {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaee com_google_android_gms_internal_zzaee) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaee != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaee.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaeg com_google_android_gms_internal_zzaeg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaeg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaeg.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaeo com_google_android_gms_internal_zzaeo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaeo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaeo.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaex != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaex.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex, zzafq com_google_android_gms_internal_zzafq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaex != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaex.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzafq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzafq.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex, zzafq com_google_android_gms_internal_zzafq, zzafe com_google_android_gms_internal_zzafe) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaex != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaex.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzafq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzafq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzafe != null) {
                        iBinder = com_google_android_gms_internal_zzafe.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex, zzafq com_google_android_gms_internal_zzafq, zzafe com_google_android_gms_internal_zzafe, PendingIntent pendingIntent) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzaex != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaex.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzafq != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzafq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzafe != null) {
                        iBinder = com_google_android_gms_internal_zzafe.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafe com_google_android_gms_internal_zzafe) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzafe != null) {
                        iBinder = com_google_android_gms_internal_zzafe.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafe com_google_android_gms_internal_zzafe, PendingIntent pendingIntent) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzafe != null) {
                        iBinder = com_google_android_gms_internal_zzafe.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafh com_google_android_gms_internal_zzafh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzafh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzafh.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafu com_google_android_gms_internal_zzafu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzafu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzafu.writeToParcel(obtain, 0);
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

            public void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzwj com_google_android_gms_internal_zzwj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaff != null ? com_google_android_gms_internal_zzaff.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (com_google_android_gms_internal_zzwj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzwj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzafg zzbJ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzafg)) ? new zza(iBinder) : (zzafg) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            PendingIntent pendingIntent = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzafu) zzafu.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzaex) zzaex.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzafq) zzafq.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzaex) zzaex.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzafq) zzafq.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzafe.zza.zzbH(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafe.zza.zzbH(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zzaff zzbI = com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    zzaex com_google_android_gms_internal_zzaex = parcel.readInt() != 0 ? (zzaex) zzaex.CREATOR.createFromParcel(parcel) : null;
                    zzafq com_google_android_gms_internal_zzafq = parcel.readInt() != 0 ? (zzafq) zzafq.CREATOR.createFromParcel(parcel) : null;
                    zzafe zzbH = com.google.android.gms.internal.zzafe.zza.zzbH(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbI, readString, readString2, readString3, com_google_android_gms_internal_zzaex, com_google_android_gms_internal_zzafq, zzbH, pendingIntent);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzafe.zza.zzbH(parcel.readStrongBinder()), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzafh) zzafh.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzaeo) zzaeo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzaex) zzaex.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzwj) zzwj.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzaeg) zzaeg.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    parcel.enforceInterface("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    zza(com.google.android.gms.internal.zzaff.zza.zzbI(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (zzaee) zzaee.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.contextmanager.internal.IContextManagerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaee com_google_android_gms_internal_zzaee) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaeg com_google_android_gms_internal_zzaeg) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaeo com_google_android_gms_internal_zzaeo) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex, zzafq com_google_android_gms_internal_zzafq) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex, zzafq com_google_android_gms_internal_zzafq, zzafe com_google_android_gms_internal_zzafe) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzaex com_google_android_gms_internal_zzaex, zzafq com_google_android_gms_internal_zzafq, zzafe com_google_android_gms_internal_zzafe, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafe com_google_android_gms_internal_zzafe) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafe com_google_android_gms_internal_zzafe, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafh com_google_android_gms_internal_zzafh) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzafu com_google_android_gms_internal_zzafu) throws RemoteException;

    void zza(zzaff com_google_android_gms_internal_zzaff, String str, String str2, String str3, zzwj com_google_android_gms_internal_zzwj) throws RemoteException;
}
