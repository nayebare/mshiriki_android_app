package com.google.android.gms.fitness.service;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzaoa;
import com.google.android.gms.internal.zzaos;
import com.google.android.gms.internal.zzapi;
import com.google.android.gms.internal.zzapk;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzaWE;

    private static class zza extends com.google.android.gms.internal.zzapm.zza {
        private final FitnessSensorService zzaWF;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzaWF = fitnessSensorService;
        }

        public void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzaos com_google_android_gms_internal_zzaos) throws RemoteException {
            this.zzaWF.zzCN();
            if (this.zzaWF.onRegister(fitnessSensorServiceRequest)) {
                com_google_android_gms_internal_zzaos.zzp(Status.zzayh);
            } else {
                com_google_android_gms_internal_zzaos.zzp(new Status(13));
            }
        }

        public void zza(zzapi com_google_android_gms_internal_zzapi, zzaoa com_google_android_gms_internal_zzaoa) throws RemoteException {
            this.zzaWF.zzCN();
            com_google_android_gms_internal_zzaoa.zza(new DataSourcesResult(this.zzaWF.onFindDataSources(com_google_android_gms_internal_zzapi.getDataTypes()), Status.zzayh));
        }

        public void zza(zzapk com_google_android_gms_internal_zzapk, zzaos com_google_android_gms_internal_zzaos) throws RemoteException {
            this.zzaWF.zzCN();
            if (this.zzaWF.onUnregister(com_google_android_gms_internal_zzapk.getDataSource())) {
                com_google_android_gms_internal_zzaos.zzp(Status.zzayh);
            } else {
                com_google_android_gms_internal_zzaos.zzp(new Status(13));
            }
        }
    }

    @CallSuper
    public IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            String valueOf = String.valueOf(intent);
            String valueOf2 = String.valueOf(getClass().getName());
            Log.d("FitnessSensorService", new StringBuilder((String.valueOf(valueOf).length() + 20) + String.valueOf(valueOf2).length()).append("Intent ").append(valueOf).append(" received by ").append(valueOf2).toString());
        }
        return this.zzaWE.asBinder();
    }

    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.zzaWE = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    @TargetApi(19)
    protected void zzCN() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (zzs.zzyF()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            int length = packagesForUid.length;
            int i = 0;
            while (i < length) {
                if (!packagesForUid[i].equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
