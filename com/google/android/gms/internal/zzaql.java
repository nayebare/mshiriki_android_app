package com.google.android.gms.internal;

import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.LaunchData;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.util.List;
import org.apache.http.protocol.HTTP;

public interface zzaql extends IInterface {

    public static abstract class zza extends Binder implements zzaql {

        private static class zza implements zzaql {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(Status status, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, PackageInfo packageInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (packageInfo != null) {
                        obtain.writeInt(1);
                        packageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, LaunchData launchData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (launchData != null) {
                        obtain.writeInt(1);
                        launchData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(19, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzaqn com_google_android_gms_internal_zzaqn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzaqn != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaqn.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzaqu com_google_android_gms_internal_zzaqu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzaqu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaqu.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, zzaqy com_google_android_gms_internal_zzaqy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzaqy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaqy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, List<zzarf> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zzrp.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzjH(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    obtain.writeInt(i);
                    this.zzrp.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
        }

        public static zzaql zzda(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaql)) ? new zza(iBinder) : (zzaql) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzaqn) zzaqn.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzaqy) zzaqy.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zzjH(parcel.readInt());
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzaqu) zzaqu.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (LaunchData) LaunchData.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    parcel.enforceInterface("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    zza(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(zzarf.CREATOR));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(Status status, int i) throws RemoteException;

    void zza(Status status, PackageInfo packageInfo) throws RemoteException;

    void zza(Status status, LaunchData launchData) throws RemoteException;

    void zza(Status status, zzaqn com_google_android_gms_internal_zzaqn) throws RemoteException;

    void zza(Status status, zzaqu com_google_android_gms_internal_zzaqu) throws RemoteException;

    void zza(Status status, zzaqy com_google_android_gms_internal_zzaqy) throws RemoteException;

    void zza(Status status, List<zzarf> list) throws RemoteException;

    void zzjH(int i) throws RemoteException;
}
