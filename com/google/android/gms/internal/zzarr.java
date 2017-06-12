package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzf;
import com.google.android.gms.location.zzj;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzv;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public interface zzarr extends IInterface {

    public static abstract class zza extends Binder implements zzarr {

        private static class zza implements zzarr {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public Location zzHA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent, zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarq != null ? com_google_android_gms_internal_zzarq.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzarp com_google_android_gms_internal_zzarp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
                    this.zzrp.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarq != null ? com_google_android_gms_internal_zzarq.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzarv com_google_android_gms_internal_zzarv, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_internal_zzarv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzarv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzarv com_google_android_gms_internal_zzarv, zzm com_google_android_gms_location_zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_internal_zzarv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzarv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_zzm != null ? com_google_android_gms_location_zzm.asBinder() : null);
                    this.zzrp.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzarx com_google_android_gms_internal_zzarx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_internal_zzarx != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzarx.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzarq com_google_android_gms_internal_zzarq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarq != null ? com_google_android_gms_internal_zzarq.asBinder() : null);
                    this.zzrp.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, zzm com_google_android_gms_location_zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_zzm != null ? com_google_android_gms_location_zzm.asBinder() : null);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, zzm com_google_android_gms_location_zzm, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_zzm != null ? com_google_android_gms_location_zzm.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationSettingsRequest locationSettingsRequest, zzars com_google_android_gms_internal_zzars, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationSettingsRequest != null) {
                        obtain.writeInt(1);
                        locationSettingsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzars != null ? com_google_android_gms_internal_zzars.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(com.google.android.gms.location.zza com_google_android_gms_location_zza, PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_location_zza != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_zza.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_location_zzf, PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_location_zzf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_zzf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzj com_google_android_gms_location_zzj, PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_location_zzj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_zzj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzm com_google_android_gms_location_zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_location_zzm != null ? com_google_android_gms_location_zzm.asBinder() : null);
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzv com_google_android_gms_location_zzv, zzarq com_google_android_gms_internal_zzarq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (com_google_android_gms_location_zzv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_zzv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarq != null ? com_google_android_gms_internal_zzarq.asBinder() : null);
                    this.zzrp.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(List<zzarz> list, PendingIntent pendingIntent, zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarq != null ? com_google_android_gms_internal_zzarq.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzarq != null ? com_google_android_gms_internal_zzarq.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaC(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ActivityRecognitionResult zzeU(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzrp.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    ActivityRecognitionResult activityRecognitionResult = obtain2.readInt() != 0 ? (ActivityRecognitionResult) ActivityRecognitionResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return activityRecognitionResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzeV(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzrp.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LocationAvailability zzeW(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzrp.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    LocationAvailability locationAvailability = obtain2.readInt() != 0 ? (LocationAvailability) LocationAvailability.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return locationAvailability;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzaat != null ? com_google_android_gms_internal_zzaat.asBinder() : null);
                    this.zzrp.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzarr zzdi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzarr)) ? new zza(iBinder) : (zzarr) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            Location zzHA;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.createTypedArrayList(zzarz.CREATOR), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzarq.zza.zzdh(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzarq.zza.zzdh(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.createStringArray(), com.google.android.gms.internal.zzarq.zza.zzdh(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(com.google.android.gms.internal.zzarq.zza.zzdh(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzc(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzHA = zzHA();
                    parcel2.writeNoException();
                    if (zzHA != null) {
                        parcel2.writeInt(1);
                        zzHA.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.location.zzm.zza.zzde(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case HTTP.HT /*9*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case HTTP.LF /*10*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(com.google.android.gms.location.zzm.zza.zzde(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzd(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzaC(z);
                    parcel2.writeNoException();
                    return true;
                case HTTP.CR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzd(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.location.zzm.zza.zzde(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzHA = zzeV(parcel.readString());
                    parcel2.writeNoException();
                    if (zzHA != null) {
                        parcel2.writeInt(1);
                        zzHA.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationAvailability zzeW = zzeW(parcel.readString());
                    parcel2.writeNoException();
                    if (zzeW != null) {
                        parcel2.writeInt(1);
                        zzeW.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C0308R.styleable.AppCompatTheme_buttonBarButtonStyle /*52*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (zzarv) zzarv.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.location.zzm.zza.zzde(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_selectableItemBackground /*53*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (zzarv) zzarv.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_dividerHorizontal /*57*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (GeofencingRequest) GeofencingRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzarq.zza.zzdh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (zzarx) zzarx.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*60*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (zzj) zzj.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzd(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPES_ALL /*63*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (LocationSettingsRequest) LocationSettingsRequest.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzars.zza.zzdj(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_editTextBackground /*64*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ActivityRecognitionResult zzeU = zzeU(parcel.readString());
                    parcel2.writeNoException();
                    if (zzeU != null) {
                        parcel2.writeInt(1);
                        zzeU.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C0308R.styleable.AppCompatTheme_imageButtonStyle /*65*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzb(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzc(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*67*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(com.google.android.gms.internal.zzarp.zza.zzdg(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_textColorSearchUrl /*68*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zze(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_searchViewStyle /*69*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzf(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listPreferredItemHeight /*70*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (com.google.android.gms.location.zza) com.google.android.gms.location.zza.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listPreferredItemHeightSmall /*71*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzb(com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (zzf) zzf.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*73*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzaat.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0308R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(parcel.readInt() != 0 ? (zzv) zzv.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzarq.zza.zzdh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Location zzHA() throws RemoteException;

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException;

    void zza(Location location, int i) throws RemoteException;

    void zza(zzarp com_google_android_gms_internal_zzarp) throws RemoteException;

    void zza(zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException;

    void zza(zzarv com_google_android_gms_internal_zzarv, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzarv com_google_android_gms_internal_zzarv, zzm com_google_android_gms_location_zzm) throws RemoteException;

    void zza(zzarx com_google_android_gms_internal_zzarx) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzarq com_google_android_gms_internal_zzarq) throws RemoteException;

    void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequest locationRequest, zzm com_google_android_gms_location_zzm) throws RemoteException;

    void zza(LocationRequest locationRequest, zzm com_google_android_gms_location_zzm, String str) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzars com_google_android_gms_internal_zzars, String str) throws RemoteException;

    void zza(com.google.android.gms.location.zza com_google_android_gms_location_zza, PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zza(zzf com_google_android_gms_location_zzf, PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zza(zzj com_google_android_gms_location_zzj, PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zza(zzm com_google_android_gms_location_zzm) throws RemoteException;

    void zza(zzv com_google_android_gms_location_zzv, zzarq com_google_android_gms_internal_zzarq) throws RemoteException;

    void zza(List<zzarz> list, PendingIntent pendingIntent, zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException;

    void zza(String[] strArr, zzarq com_google_android_gms_internal_zzarq, String str) throws RemoteException;

    void zzaC(boolean z) throws RemoteException;

    void zzb(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zzb(zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zzc(PendingIntent pendingIntent) throws RemoteException;

    void zzc(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zzd(PendingIntent pendingIntent) throws RemoteException;

    void zzd(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    void zzd(Location location) throws RemoteException;

    void zze(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;

    ActivityRecognitionResult zzeU(String str) throws RemoteException;

    Location zzeV(String str) throws RemoteException;

    LocationAvailability zzeW(String str) throws RemoteException;

    void zzf(PendingIntent pendingIntent, zzaat com_google_android_gms_internal_zzaat) throws RemoteException;
}
