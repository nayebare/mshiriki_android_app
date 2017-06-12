package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import java.util.List;

public interface zzado extends IInterface {

    public static abstract class zza extends Binder implements zzado {

        private static class zza implements zzado {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzadn com_google_android_gms_internal_zzadn, zzadj com_google_android_gms_internal_zzadj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzadn != null ? com_google_android_gms_internal_zzadn.asBinder() : null);
                    if (com_google_android_gms_internal_zzadj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzadj.writeToParcel(obtain, 0);
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

            public void zza(zzadn com_google_android_gms_internal_zzadn, String str, zzawa com_google_android_gms_internal_zzawa, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzadn != null ? com_google_android_gms_internal_zzadn.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzawa != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzawa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzadn com_google_android_gms_internal_zzadn, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzadn != null ? com_google_android_gms_internal_zzadn.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzadn com_google_android_gms_internal_zzadn, String str, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzadn != null ? com_google_android_gms_internal_zzadn.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeList(list);
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzadn com_google_android_gms_internal_zzadn, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzadn != null ? com_google_android_gms_internal_zzadn.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzado zzbE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.config.internal.IConfigService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzado)) ? new zza(iBinder) : (zzado) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzadj com_google_android_gms_internal_zzadj = null;
            zzadn zzbD;
            switch (i) {
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zza(com.google.android.gms.internal.zzadn.zza.zzbD(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zzb(com.google.android.gms.internal.zzadn.zza.zzbD(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zza(com.google.android.gms.internal.zzadn.zza.zzbD(parcel.readStrongBinder()), parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    zzawa com_google_android_gms_internal_zzawa;
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zzbD = com.google.android.gms.internal.zzadn.zza.zzbD(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzawa = (zzawa) zzawa.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbD, readString, com_google_android_gms_internal_zzawa, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                    zzbD = com.google.android.gms.internal.zzadn.zza.zzbD(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzadj = (zzadj) zzadj.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbD, com_google_android_gms_internal_zzadj);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.config.internal.IConfigService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzadn com_google_android_gms_internal_zzadn, zzadj com_google_android_gms_internal_zzadj) throws RemoteException;

    void zza(zzadn com_google_android_gms_internal_zzadn, String str, zzawa com_google_android_gms_internal_zzawa, String str2) throws RemoteException;

    void zza(zzadn com_google_android_gms_internal_zzadn, String str, String str2) throws RemoteException;

    void zza(zzadn com_google_android_gms_internal_zzadn, String str, List list) throws RemoteException;

    void zzb(zzadn com_google_android_gms_internal_zzadn, String str, String str2) throws RemoteException;
}
