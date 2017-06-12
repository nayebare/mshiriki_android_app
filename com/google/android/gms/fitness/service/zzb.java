package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzu;
import java.util.List;

class zzb implements SensorEventDispatcher {
    private final zzu zzaVN;

    zzb(zzu com_google_android_gms_fitness_data_zzu) {
        this.zzaVN = (zzu) zzac.zzw(com_google_android_gms_fitness_data_zzu);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        dataPoint.zzBo();
        this.zzaVN.zzf(dataPoint);
    }

    public void publish(List<DataPoint> list) throws RemoteException {
        for (DataPoint publish : list) {
            publish(publish);
        }
    }
}
