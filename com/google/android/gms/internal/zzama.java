package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.mediarouter.C0308R;
import com.google.ads.AdSize;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public interface zzama extends IInterface {

    public static abstract class zza extends Binder implements zzama {

        private static class zza implements zzama {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzAX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.zzrp.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DriveId driveId, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (driveId != null) {
                        obtain.writeInt(1);
                        driveId.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalm com_google_android_gms_internal_zzalm, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (com_google_android_gms_internal_zzalm != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzalm.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalo com_google_android_gms_internal_zzalo, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (com_google_android_gms_internal_zzalo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzalo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalo com_google_android_gms_internal_zzalo, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (com_google_android_gms_internal_zzalo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzalo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalq com_google_android_gms_internal_zzalq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalq != null ? com_google_android_gms_internal_zzalq.asBinder() : null);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalr com_google_android_gms_internal_zzalr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalr != null ? com_google_android_gms_internal_zzalr.asBinder() : null);
                    this.zzrp.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzals com_google_android_gms_internal_zzals) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzals != null ? com_google_android_gms_internal_zzals.asBinder() : null);
                    this.zzrp.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalv com_google_android_gms_internal_zzalv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalv != null ? com_google_android_gms_internal_zzalv.asBinder() : null);
                    this.zzrp.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalw com_google_android_gms_internal_zzalw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalw != null ? com_google_android_gms_internal_zzalw.asBinder() : null);
                    this.zzrp.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzalz com_google_android_gms_internal_zzalz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalz != null ? com_google_android_gms_internal_zzalz.asBinder() : null);
                    this.zzrp.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzamh com_google_android_gms_internal_zzamh, zzamb com_google_android_gms_internal_zzamb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (com_google_android_gms_internal_zzamh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzamh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamb != null ? com_google_android_gms_internal_zzamb.asBinder() : null);
                    this.zzrp.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzalu com_google_android_gms_internal_zzalu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalu != null ? com_google_android_gms_internal_zzalu.asBinder() : null);
                    this.zzrp.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzalu com_google_android_gms_internal_zzalu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalu != null ? com_google_android_gms_internal_zzalu.asBinder() : null);
                    this.zzrp.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzamb com_google_android_gms_internal_zzamb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamb != null ? com_google_android_gms_internal_zzamb.asBinder() : null);
                    this.zzrp.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, int i2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, DataHolder dataHolder, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzalt com_google_android_gms_internal_zzalt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalt != null ? com_google_android_gms_internal_zzalt.asBinder() : null);
                    this.zzrp.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzaly com_google_android_gms_internal_zzaly) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaly != null ? com_google_android_gms_internal_zzaly.asBinder() : null);
                    this.zzrp.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzalz com_google_android_gms_internal_zzalz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalz != null ? com_google_android_gms_internal_zzalz.asBinder() : null);
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzamb com_google_android_gms_internal_zzamb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamb != null ? com_google_android_gms_internal_zzamb.asBinder() : null);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, DataHolder dataHolder, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzalt com_google_android_gms_internal_zzalt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalt != null ? com_google_android_gms_internal_zzalt.asBinder() : null);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzalu com_google_android_gms_internal_zzalu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalu != null ? com_google_android_gms_internal_zzalu.asBinder() : null);
                    this.zzrp.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(boolean z, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzalq com_google_android_gms_internal_zzalq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalq != null ? com_google_android_gms_internal_zzalq.asBinder() : null);
                    this.zzrp.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzalx com_google_android_gms_internal_zzalx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalx != null ? com_google_android_gms_internal_zzalx.asBinder() : null);
                    this.zzrp.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzalz com_google_android_gms_internal_zzalz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalz != null ? com_google_android_gms_internal_zzalz.asBinder() : null);
                    this.zzrp.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzalt com_google_android_gms_internal_zzalt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalt != null ? com_google_android_gms_internal_zzalt.asBinder() : null);
                    this.zzrp.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzalz com_google_android_gms_internal_zzalz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalz != null ? com_google_android_gms_internal_zzalz.asBinder() : null);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzamb com_google_android_gms_internal_zzamb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamb != null ? com_google_android_gms_internal_zzamb.asBinder() : null);
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzalt com_google_android_gms_internal_zzalt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalt != null ? com_google_android_gms_internal_zzalt.asBinder() : null);
                    this.zzrp.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzalq com_google_android_gms_internal_zzalq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalq != null ? com_google_android_gms_internal_zzalq.asBinder() : null);
                    this.zzrp.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzamc com_google_android_gms_internal_zzamc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzamc != null ? com_google_android_gms_internal_zzamc.asBinder() : null);
                    this.zzrp.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzalz com_google_android_gms_internal_zzalz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalz != null ? com_google_android_gms_internal_zzalz.asBinder() : null);
                    this.zzrp.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzalq com_google_android_gms_internal_zzalq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalq != null ? com_google_android_gms_internal_zzalq.asBinder() : null);
                    this.zzrp.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzamp zze(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzrp.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    zzamp com_google_android_gms_internal_zzamp = obtain2.readInt() != 0 ? (zzamp) zzamp.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzamp;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzalq com_google_android_gms_internal_zzalq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzalq != null ? com_google_android_gms_internal_zzalq.asBinder() : null);
                    this.zzrp.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzama zzbZ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzama)) ? new zza(iBinder) : (zzama) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzalo com_google_android_gms_internal_zzalo = null;
            String readString;
            DataHolder dataHolder;
            int readInt;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzamb.zza.zzca(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzalq.zza.zzbP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzalt.zza.zzbS(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzalz.zza.zzbY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        dataHolder = (DataHolder) DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    zza(readString, dataHolder, com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.internal.zzalz.zza.zzbY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.internal.zzamb.zza.zzca(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readString(), com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt(), com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.internal.zzalt.zza.zzbS(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(parcel.readString(), com.google.android.gms.internal.zzalz.zza.zzbY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        dataHolder = (DataHolder) DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    zza(readString, readInt, dataHolder, com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        dataHolder = (DataHolder) DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    zza(readString, readInt, dataHolder, com.google.android.gms.internal.zzalu.zza.zzbT(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt(), com.google.android.gms.internal.zzalu.zza.zzbT(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    zzalm com_google_android_gms_internal_zzalm;
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzalm = (zzalm) zzalm.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzalm, com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzalo = (zzalo) zzalo.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzalo, com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzalt.zza.zzbS(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzalu.zza.zzbT(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzd(com.google.android.gms.internal.zzalq.zza.zzbP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zze(com.google.android.gms.internal.zzalq.zza.zzbP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    zzamh com_google_android_gms_internal_zzamh;
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzamh = (zzamh) zzamh.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzamh, com.google.android.gms.internal.zzamb.zza.zzca(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzaly.zza.zzbX(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.internal.zzalz.zza.zzbY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt(), com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzals.zza.zzbR(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTP.SP /*32*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzalr.zza.zzbQ(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.internal.zzalq.zza.zzbP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzalw.zza.zzbV(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzalv.zza.zzbU(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.internal.zzalz.zza.zzbY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzalo = (zzalo) zzalo.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzalo, com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzalt.zza.zzbS(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        dataHolder = (DataHolder) DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    zza(readString, readString2, dataHolder, com.google.android.gms.internal.zzalx.zza.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzAX();
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(com.google.android.gms.internal.zzalq.zza.zzbP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), com.google.android.gms.internal.zzamb.zza.zzca(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0, com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                    DriveId driveId;
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        driveId = (DriveId) DriveId.CREATOR.createFromParcel(parcel);
                    }
                    zza(driveId, com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_homeAsUpIndicator /*49*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt(), com.google.android.gms.internal.zzamc.zza.zzcb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_buttonBarStyle /*51*/:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzamp zze = zze(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (zze != null) {
                        parcel2.writeInt(1);
                        zze.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzAX() throws RemoteException;

    void zza(int i, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(int i, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(DriveId driveId, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(zzalm com_google_android_gms_internal_zzalm, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(zzalo com_google_android_gms_internal_zzalo, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(zzalo com_google_android_gms_internal_zzalo, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(zzalq com_google_android_gms_internal_zzalq) throws RemoteException;

    void zza(zzalr com_google_android_gms_internal_zzalr) throws RemoteException;

    void zza(zzals com_google_android_gms_internal_zzals) throws RemoteException;

    void zza(zzalv com_google_android_gms_internal_zzalv) throws RemoteException;

    void zza(zzalw com_google_android_gms_internal_zzalw) throws RemoteException;

    void zza(zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(zzalz com_google_android_gms_internal_zzalz) throws RemoteException;

    void zza(zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(zzamh com_google_android_gms_internal_zzamh, zzamb com_google_android_gms_internal_zzamb) throws RemoteException;

    void zza(String str, int i, int i2, zzalu com_google_android_gms_internal_zzalu) throws RemoteException;

    void zza(String str, int i, int i2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzalu com_google_android_gms_internal_zzalu) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, int i, zzamb com_google_android_gms_internal_zzamb) throws RemoteException;

    void zza(String str, int i, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(String str, int i, String str2, int i2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, int i, String str2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, DataHolder dataHolder, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, zzalt com_google_android_gms_internal_zzalt) throws RemoteException;

    void zza(String str, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, zzaly com_google_android_gms_internal_zzaly) throws RemoteException;

    void zza(String str, zzalz com_google_android_gms_internal_zzalz) throws RemoteException;

    void zza(String str, zzamb com_google_android_gms_internal_zzamb) throws RemoteException;

    void zza(String str, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zza(String str, String str2, DataHolder dataHolder, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(String str, String str2, zzalt com_google_android_gms_internal_zzalt) throws RemoteException;

    void zza(String str, String str2, zzalu com_google_android_gms_internal_zzalu) throws RemoteException;

    void zza(String str, String str2, zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zza(boolean z, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zzb(zzalq com_google_android_gms_internal_zzalq) throws RemoteException;

    void zzb(zzalx com_google_android_gms_internal_zzalx) throws RemoteException;

    void zzb(zzalz com_google_android_gms_internal_zzalz) throws RemoteException;

    void zzb(zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zzb(String str, zzalt com_google_android_gms_internal_zzalt) throws RemoteException;

    void zzb(String str, zzalz com_google_android_gms_internal_zzalz) throws RemoteException;

    void zzb(String str, zzamb com_google_android_gms_internal_zzamb) throws RemoteException;

    void zzb(String str, zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zzb(String str, String str2, zzalt com_google_android_gms_internal_zzalt) throws RemoteException;

    void zzc(zzalq com_google_android_gms_internal_zzalq) throws RemoteException;

    void zzc(zzamc com_google_android_gms_internal_zzamc) throws RemoteException;

    void zzc(String str, zzalz com_google_android_gms_internal_zzalz) throws RemoteException;

    void zzd(zzalq com_google_android_gms_internal_zzalq) throws RemoteException;

    zzamp zze(String str, String str2, String str3) throws RemoteException;

    void zze(zzalq com_google_android_gms_internal_zzalq) throws RemoteException;
}
