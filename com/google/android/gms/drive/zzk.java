package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions.Builder;

public class zzk extends ExecutionOptions {
    private String zzaJI;
    private String zzaJJ;

    public static class zza extends Builder {
        public /* synthetic */ ExecutionOptions build() {
            return zzzL();
        }

        public /* synthetic */ Builder setConflictStrategy(int i) {
            return zzdZ(i);
        }

        public /* synthetic */ Builder setNotifyOnCompletion(boolean z) {
            return zzat(z);
        }

        public /* synthetic */ Builder setTrackingTag(String str) {
            return zzdJ(str);
        }

        public zza zzat(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        public zza zzdJ(String str) {
            super.setTrackingTag(str);
            return this;
        }

        public zza zzdZ(int i) {
            throw new UnsupportedOperationException();
        }

        public zzk zzzL() {
            zzzI();
            return new zzk(this.zzaJG, null, null, this.zzaJH, null);
        }
    }

    private zzk(String str, boolean z, String str2, String str3, int i) {
        super(str, z, i);
        this.zzaJI = str2;
        this.zzaJJ = str3;
    }

    public static zzk zza(ExecutionOptions executionOptions) {
        zza com_google_android_gms_drive_zzk_zza = new zza();
        if (executionOptions != null) {
            if (executionOptions.zzzH() != 0) {
                throw new IllegalStateException("May not set a conflict strategy for new file creation.");
            }
            String zzzF = executionOptions.zzzF();
            if (zzzF != null) {
                com_google_android_gms_drive_zzk_zza.setTrackingTag(zzzF);
            }
            com_google_android_gms_drive_zzk_zza.setNotifyOnCompletion(executionOptions.zzzG());
        }
        return (zzk) com_google_android_gms_drive_zzk_zza.build();
    }

    public String zzzJ() {
        return this.zzaJI;
    }

    public String zzzK() {
        return this.zzaJJ;
    }
}
