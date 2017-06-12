package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wearable.MessageApi;

public interface zzbhy extends IInterface {

    public static abstract class zza extends Binder implements zzbhy {

        private static class zza implements zzbhy {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public zzbhv zza(zzd com_google_android_gms_dynamic_zzd, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzbhw com_google_android_gms_internal_zzbhw) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzc != null ? com_google_android_gms_dynamic_zzc.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzbhw != null) {
                        iBinder = com_google_android_gms_internal_zzbhw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzbhv zzfm = com.google.android.gms.internal.zzbhv.zza.zzfm(obtain2.readStrongBinder());
                    return zzfm;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzbhy zzfp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzbhy)) ? new zza(iBinder) : (zzbhy) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzbhv zza = zza(com.google.android.gms.dynamic.zzd.zza.zzcd(parcel.readStrongBinder()), com.google.android.gms.dynamic.zzc.zza.zzcc(parcel.readStrongBinder()), parcel.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzbhw.zza.zzfn(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzbhv zza(zzd com_google_android_gms_dynamic_zzd, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzbhw com_google_android_gms_internal_zzbhw) throws RemoteException;
}
