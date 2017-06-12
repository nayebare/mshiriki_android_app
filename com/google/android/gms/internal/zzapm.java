package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzapm extends IInterface {

    public static abstract class zza extends Binder implements zzapm {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzapk com_google_android_gms_internal_zzapk = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzapi com_google_android_gms_internal_zzapi;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzapi = (zzapi) zzapi.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzapi, com.google.android.gms.internal.zzaoa.zza.zzcr(parcel.readStrongBinder()));
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(fitnessSensorServiceRequest, com.google.android.gms.internal.zzaos.zza.zzcJ(parcel.readStrongBinder()));
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzapk = (zzapk) zzapk.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzapk, com.google.android.gms.internal.zzaos.zza.zzcJ(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzaos com_google_android_gms_internal_zzaos) throws RemoteException;

    void zza(zzapi com_google_android_gms_internal_zzapi, zzaoa com_google_android_gms_internal_zzaoa) throws RemoteException;

    void zza(zzapk com_google_android_gms_internal_zzapk, zzaos com_google_android_gms_internal_zzaos) throws RemoteException;
}
