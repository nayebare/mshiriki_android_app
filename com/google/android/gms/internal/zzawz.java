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

public interface zzawz extends IInterface {

    public static abstract class zza extends Binder implements zzawz {

        private static class zza implements zzawz {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzawy com_google_android_gms_internal_zzawy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzawy com_google_android_gms_internal_zzawy, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzawy com_google_android_gms_internal_zzawy, String str, int[] iArr, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzawy com_google_android_gms_internal_zzawy, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzawy com_google_android_gms_internal_zzawy, byte[] bArr, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzawy com_google_android_gms_internal_zzawy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzawy com_google_android_gms_internal_zzawy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzawy com_google_android_gms_internal_zzawy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzawy != null ? com_google_android_gms_internal_zzawy.asBinder() : null);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzawz zzeS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzawz)) ? new zza(iBinder) : (zzawz) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zzb(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zzc(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()), parcel.createByteArray(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zzd(com.google.android.gms.internal.zzawy.zza.zzeR(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzawy com_google_android_gms_internal_zzawy) throws RemoteException;

    void zza(zzawy com_google_android_gms_internal_zzawy, String str) throws RemoteException;

    void zza(zzawy com_google_android_gms_internal_zzawy, String str, int[] iArr, int i, String str2) throws RemoteException;

    void zza(zzawy com_google_android_gms_internal_zzawy, byte[] bArr) throws RemoteException;

    void zza(zzawy com_google_android_gms_internal_zzawy, byte[] bArr, String str) throws RemoteException;

    void zzb(zzawy com_google_android_gms_internal_zzawy) throws RemoteException;

    void zzc(zzawy com_google_android_gms_internal_zzawy) throws RemoteException;

    void zzd(zzawy com_google_android_gms_internal_zzawy) throws RemoteException;
}
