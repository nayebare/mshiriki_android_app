package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.instantapps.LaunchSettings;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.util.List;
import org.apache.http.protocol.HTTP;

public interface zzaqm extends IInterface {

    public static abstract class zza extends Binder implements zzaqm {

        private static class zza implements zzaqm {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzrp.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaat com_google_android_gms_internal_zzaat, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
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

            public void zza(zzaql com_google_android_gms_internal_zzaql) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    this.zzrp.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaql com_google_android_gms_internal_zzaql, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
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

            public void zza(zzaql com_google_android_gms_internal_zzaql, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaql com_google_android_gms_internal_zzaql, String str, LaunchSettings launchSettings) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    obtain.writeString(str);
                    if (launchSettings != null) {
                        obtain.writeInt(1);
                        launchSettings.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaql com_google_android_gms_internal_zzaql, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaql com_google_android_gms_internal_zzaql, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zzrp.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaql com_google_android_gms_internal_zzaql, List<String> list, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    obtain.writeStringList(list);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaat com_google_android_gms_internal_zzaat, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzrp.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaql com_google_android_gms_internal_zzaql) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaql != null ? com_google_android_gms_internal_zzaql.asBinder() : null);
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaqm zzdb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaqm)) ? new zza(iBinder) : (zzaqm) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            LaunchSettings launchSettings = null;
            boolean z = false;
            zzaql zzda;
            switch (i) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    Intent intent;
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzda = com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzda, intent);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzb(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzb(com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzaat zzbp = com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(zzbp, z);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzda = com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        launchSettings = (LaunchSettings) LaunchSettings.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzda, readString, launchSettings);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzd(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzaql zzda2 = com.google.android.gms.internal.zzaql.zza.zzda(parcel.readStrongBinder());
                    List createStringArrayList = parcel.createStringArrayList();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(zzda2, createStringArrayList, z);
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzc(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zza(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    zzb(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.instantapps.internal.IInstantAppsService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, int i) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, int i, String str) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, String str, String str2, int i) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, String str, String str2, String str3) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, String str, boolean z) throws RemoteException;

    void zza(zzaat com_google_android_gms_internal_zzaat, boolean z) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql, Intent intent) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql, String str) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql, String str, LaunchSettings launchSettings) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql, String str, String str2) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql, String str, byte[] bArr) throws RemoteException;

    void zza(zzaql com_google_android_gms_internal_zzaql, List<String> list, boolean z) throws RemoteException;

    void zzb(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException;

    void zzb(zzaat com_google_android_gms_internal_zzaat, String str, String str2, String str3) throws RemoteException;

    void zzb(zzaql com_google_android_gms_internal_zzaql) throws RemoteException;

    void zzc(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException;

    void zzd(zzaat com_google_android_gms_internal_zzaat, String str) throws RemoteException;
}
