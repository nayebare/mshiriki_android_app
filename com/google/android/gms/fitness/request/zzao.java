package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataPoint;
import java.util.HashMap;
import java.util.Map;

public class zzao extends com.google.android.gms.fitness.data.zzu.zza {
    private final OnDataPointListener zzaVD;

    public static class zza {
        private static final zza zzaVE;
        private final Map<OnDataPointListener, zzao> zzaVF;

        static {
            zzaVE = new zza();
        }

        private zza() {
            this.zzaVF = new HashMap();
        }

        public static zza zzCm() {
            return zzaVE;
        }

        public zzao zza(OnDataPointListener onDataPointListener) {
            zzao com_google_android_gms_fitness_request_zzao;
            synchronized (this.zzaVF) {
                com_google_android_gms_fitness_request_zzao = (zzao) this.zzaVF.get(onDataPointListener);
                if (com_google_android_gms_fitness_request_zzao == null) {
                    com_google_android_gms_fitness_request_zzao = new zzao(null);
                    this.zzaVF.put(onDataPointListener, com_google_android_gms_fitness_request_zzao);
                }
            }
            return com_google_android_gms_fitness_request_zzao;
        }

        public zzao zzb(OnDataPointListener onDataPointListener) {
            zzao com_google_android_gms_fitness_request_zzao;
            synchronized (this.zzaVF) {
                com_google_android_gms_fitness_request_zzao = (zzao) this.zzaVF.get(onDataPointListener);
            }
            return com_google_android_gms_fitness_request_zzao;
        }

        public zzao zzc(OnDataPointListener onDataPointListener) {
            zzao com_google_android_gms_fitness_request_zzao;
            synchronized (this.zzaVF) {
                com_google_android_gms_fitness_request_zzao = (zzao) this.zzaVF.remove(onDataPointListener);
                if (com_google_android_gms_fitness_request_zzao != null) {
                } else {
                    com_google_android_gms_fitness_request_zzao = new zzao(null);
                }
            }
            return com_google_android_gms_fitness_request_zzao;
        }
    }

    private zzao(OnDataPointListener onDataPointListener) {
        this.zzaVD = (OnDataPointListener) zzac.zzw(onDataPointListener);
    }

    public void zzf(DataPoint dataPoint) throws RemoteException {
        this.zzaVD.onDataPoint(dataPoint);
    }
}
