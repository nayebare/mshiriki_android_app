package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zze;
import com.google.android.gms.safetynet.zzg;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzawy extends IInterface {

    public static abstract class zza extends Binder implements zzawy {

        private static class zza implements zzawy {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (safeBrowsingData != null) {
                        obtain.writeInt(1);
                        safeBrowsingData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, com.google.android.gms.safetynet.zza com_google_android_gms_safetynet_zza) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_safetynet_zza != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_safetynet_zza.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, zze com_google_android_gms_safetynet_zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_safetynet_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_safetynet_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzg com_google_android_gms_safetynet_zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_safetynet_zzg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_safetynet_zzg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(Status status, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(Status status, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzgw(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    obtain.writeString(str);
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        }

        public static zzawy zzeR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzawy)) ? new zza(iBinder) : (zzawy) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            Status status;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (com.google.android.gms.safetynet.zza) com.google.android.gms.safetynet.zza.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zzgw(parcel.readString());
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (SafeBrowsingData) SafeBrowsingData.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    status = parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzc(status, z);
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzg) zzg.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    status = parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzb(status, z);
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zze) zze.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException;

    void zza(Status status, com.google.android.gms.safetynet.zza com_google_android_gms_safetynet_zza) throws RemoteException;

    void zza(Status status, zze com_google_android_gms_safetynet_zze) throws RemoteException;

    void zza(Status status, zzg com_google_android_gms_safetynet_zzg) throws RemoteException;

    void zzb(Status status, boolean z) throws RemoteException;

    void zzc(Status status, boolean z) throws RemoteException;

    void zzgw(String str) throws RemoteException;
}
