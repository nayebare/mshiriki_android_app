package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzai.zza {
    private final BleScanCallback zzaUN;

    public static class zza {
        private static final zza zzaUO;
        private final Map<BleScanCallback, zza> zzaUP;

        static {
            zzaUO = new zza();
        }

        private zza() {
            this.zzaUP = new HashMap();
        }

        public static zza zzBW() {
            return zzaUO;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzaUP) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzaUP.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza == null) {
                    com_google_android_gms_fitness_request_zza = new zza(null);
                    this.zzaUP.put(bleScanCallback, com_google_android_gms_fitness_request_zza);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzaUP) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzaUP.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza != null) {
                } else {
                    com_google_android_gms_fitness_request_zza = new zza(null);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaUN = (BleScanCallback) zzac.zzw(bleScanCallback);
    }

    public void onDeviceFound(BleDevice bleDevice) throws RemoteException {
        this.zzaUN.onDeviceFound(bleDevice);
    }

    public void onScanStopped() throws RemoteException {
        this.zzaUN.onScanStopped();
    }
}
