package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveFolder;

public class zzj {
    private String zzaNx;

    private zzj(String str) {
        this.zzaNx = str.toLowerCase();
    }

    public static zzj zzdO(String str) {
        boolean z = str == null || !str.isEmpty();
        zzac.zzas(z);
        return str == null ? null : new zzj(str);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return this.zzaNx.equals(((zzj) obj).zzaNx);
    }

    public int hashCode() {
        return this.zzaNx.hashCode();
    }

    public boolean isFolder() {
        return this.zzaNx.equals(DriveFolder.MIME_TYPE);
    }

    public String toString() {
        return this.zzaNx;
    }

    public boolean zzAL() {
        return (zzAM() || isFolder()) ? false : true;
    }

    public boolean zzAM() {
        return this.zzaNx.startsWith("application/vnd.google-apps");
    }
}
