package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzv extends IInterface {

    public static abstract class zza extends Binder implements zzv {

        private static class zza implements zzv {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzu com_google_android_gms_common_internal_zzu, zzan com_google_android_gms_common_internal_zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(com_google_android_gms_common_internal_zzu != null ? com_google_android_gms_common_internal_zzu.asBinder() : null);
                    if (com_google_android_gms_common_internal_zzan != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzan.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzu com_google_android_gms_common_internal_zzu, zzj com_google_android_gms_common_internal_zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(com_google_android_gms_common_internal_zzu != null ? com_google_android_gms_common_internal_zzu.asBinder() : null);
                    if (com_google_android_gms_common_internal_zzj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzv zzbu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzv)) ? new zza(iBinder) : (zzv) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzan com_google_android_gms_common_internal_zzan = null;
            zzu zzbt;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    parcel.readStrongBinder();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readStrongBinder();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    parcel2.writeNoException();
                    return true;
                case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case HTTP.SP /*32*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    zzj com_google_android_gms_common_internal_zzj;
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzbt = com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzj = (zzj) zzj.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbt, com_google_android_gms_common_internal_zzj);
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzbt = com.google.android.gms.common.internal.zzu.zza.zzbt(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzan = (zzan) zzan.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbt, com_google_android_gms_common_internal_zzan);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzu com_google_android_gms_common_internal_zzu, zzan com_google_android_gms_common_internal_zzan) throws RemoteException;

    void zza(zzu com_google_android_gms_common_internal_zzu, zzj com_google_android_gms_common_internal_zzj) throws RemoteException;
}
