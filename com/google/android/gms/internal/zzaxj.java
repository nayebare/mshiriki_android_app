package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaxj extends IInterface {

    public static abstract class zza extends Binder implements zzaxj {

        private static class zza implements zzaxj {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzaxi com_google_android_gms_internal_zzaxi, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaxi != null ? com_google_android_gms_internal_zzaxi.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaxi com_google_android_gms_internal_zzaxi, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaxi != null ? com_google_android_gms_internal_zzaxi.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaxj zzeV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaxj)) ? new zza(iBinder) : (zzaxj) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
                    zza(com.google.android.gms.internal.zzaxi.zza.zzeU(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
                    zzb(com.google.android.gms.internal.zzaxi.zza.zzeU(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.search.internal.ISearchAuthService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzaxi com_google_android_gms_internal_zzaxi, String str, String str2) throws RemoteException;

    void zzb(zzaxi com_google_android_gms_internal_zzaxi, String str, String str2) throws RemoteException;
}
