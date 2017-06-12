package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        private static class zza implements zzb {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zza com_google_android_gms_auth_account_zza, Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.account.IWorkAccountService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_account_zza != null ? com_google_android_gms_auth_account_zza.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
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

            public void zza(zza com_google_android_gms_auth_account_zza, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.account.IWorkAccountService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_account_zza != null ? com_google_android_gms_auth_account_zza.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzac(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.account.IWorkAccountService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzb zzaz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new zza(iBinder) : (zzb) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.auth.account.IWorkAccountService");
                    zzac(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.auth.account.IWorkAccountService");
                    zza(com.google.android.gms.auth.account.zza.zza.zzay(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.auth.account.IWorkAccountService");
                    zza(com.google.android.gms.auth.account.zza.zza.zzay(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.account.IWorkAccountService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zza com_google_android_gms_auth_account_zza, Account account) throws RemoteException;

    void zza(zza com_google_android_gms_auth_account_zza, String str) throws RemoteException;

    void zzac(boolean z) throws RemoteException;
}
