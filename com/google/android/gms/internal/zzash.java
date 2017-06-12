package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public interface zzash extends IInterface {

    public static abstract class zza extends Binder implements zzash {

        private static class zza implements zzash {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzasf com_google_android_gms_internal_zzasf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    if (com_google_android_gms_internal_zzasf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzasf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(zzasf com_google_android_gms_internal_zzasf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    if (com_google_android_gms_internal_zzasf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzasf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(zzasf com_google_android_gms_internal_zzasf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    if (com_google_android_gms_internal_zzasf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzasf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzash zzdq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzash)) ? new zza(iBinder) : (zzash) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzasf com_google_android_gms_internal_zzasf = null;
            switch (i) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzasf = (zzasf) zzasf.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzasf);
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzasf = (zzasf) zzasf.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_internal_zzasf);
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzasf = (zzasf) zzasf.CREATOR.createFromParcel(parcel);
                    }
                    zzc(com_google_android_gms_internal_zzasf);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzasf com_google_android_gms_internal_zzasf) throws RemoteException;

    void zzb(zzasf com_google_android_gms_internal_zzasf) throws RemoteException;

    void zzc(zzasf com_google_android_gms_internal_zzasf) throws RemoteException;
}
