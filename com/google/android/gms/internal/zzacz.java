package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface zzacz {

    public static class zza {
        private final long zzaHn;
        private final Map<String, String> zzaHo;
        private final int zzaHp;
        private final List<zzadb> zzaHq;

        public static class zza {
            private long zzaHn;
            private Map<String, String> zzaHo;
            private int zzaHp;

            public zza() {
                this.zzaHn = 43200;
            }

            public zza zzG(String str, String str2) {
                if (this.zzaHo == null) {
                    this.zzaHo = new HashMap();
                }
                this.zzaHo.put(str, str2);
                return this;
            }

            public zza zzJ(long j) {
                this.zzaHn = j;
                return this;
            }

            public zza zzdl(int i) {
                this.zzaHp = i;
                return this;
            }

            public zza zzyT() {
                return new zza();
            }
        }

        private zza(zza com_google_android_gms_internal_zzacz_zza_zza) {
            this.zzaHn = com_google_android_gms_internal_zzacz_zza_zza.zzaHn;
            this.zzaHo = com_google_android_gms_internal_zzacz_zza_zza.zzaHo;
            this.zzaHp = com_google_android_gms_internal_zzacz_zza_zza.zzaHp;
            this.zzaHq = null;
        }

        public long zzyQ() {
            return this.zzaHn;
        }

        public Map<String, String> zzyR() {
            return this.zzaHo == null ? Collections.emptyMap() : this.zzaHo;
        }

        public int zzyS() {
            return this.zzaHp;
        }
    }

    public interface zzb extends Result {
        Status getStatus();

        long getThrottleEndTimeMillis();

        byte[] zza(String str, byte[] bArr, String str2);

        Map<String, Set<String>> zzyU();
    }

    PendingResult<zzb> zza(GoogleApiClient googleApiClient, zza com_google_android_gms_internal_zzacz_zza);
}
