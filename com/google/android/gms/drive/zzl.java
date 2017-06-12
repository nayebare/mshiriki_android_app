package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions.Builder;

public class zzl extends ExecutionOptions {
    private boolean zzaJK;

    public static class zza extends Builder {
        private boolean zzaJK;

        public zza() {
            this.zzaJK = true;
        }

        public /* synthetic */ ExecutionOptions build() {
            return zzzN();
        }

        public /* synthetic */ Builder setConflictStrategy(int i) {
            return zzea(i);
        }

        public /* synthetic */ Builder setNotifyOnCompletion(boolean z) {
            return zzau(z);
        }

        public /* synthetic */ Builder setTrackingTag(String str) {
            return zzdK(str);
        }

        public zza zzau(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        public zza zzdK(String str) {
            super.setTrackingTag(str);
            return this;
        }

        public zza zzea(int i) {
            super.setConflictStrategy(i);
            return this;
        }

        public zzl zzzN() {
            zzzI();
            return new zzl(this.zzaJG, this.zzaJH, this.zzaJK, null);
        }
    }

    private zzl(String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.zzaJK = z2;
    }

    public static zzl zzb(ExecutionOptions executionOptions) {
        zza com_google_android_gms_drive_zzl_zza = new zza();
        if (executionOptions != null) {
            com_google_android_gms_drive_zzl_zza.setConflictStrategy(executionOptions.zzzH());
            com_google_android_gms_drive_zzl_zza.setNotifyOnCompletion(executionOptions.zzzG());
            String zzzF = executionOptions.zzzF();
            if (zzzF != null) {
                com_google_android_gms_drive_zzl_zza.setTrackingTag(zzzF);
            }
        }
        return (zzl) com_google_android_gms_drive_zzl_zza.build();
    }

    public boolean zzzM() {
        return this.zzaJK;
    }
}
