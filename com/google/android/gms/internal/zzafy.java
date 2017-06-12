package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzj;

public class zzafy implements zzj {
    private final int zzJh;
    private final DriveId zzaJj;
    private final int zzaKC;

    public zzafy(zzafz com_google_android_gms_internal_zzafz) {
        this.zzaJj = com_google_android_gms_internal_zzafz.getDriveId();
        this.zzaKC = com_google_android_gms_internal_zzafz.zzAf();
        this.zzJh = com_google_android_gms_internal_zzafz.getStatus();
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzafy com_google_android_gms_internal_zzafy = (zzafy) obj;
        return zzaa.equal(this.zzaJj, com_google_android_gms_internal_zzafy.zzaJj) && this.zzaKC == com_google_android_gms_internal_zzafy.zzaKC && this.zzJh == com_google_android_gms_internal_zzafy.zzJh;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaJj, Integer.valueOf(this.zzaKC), Integer.valueOf(this.zzJh));
    }

    public String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", new Object[]{Integer.valueOf(this.zzaKC), this.zzaJj, Integer.valueOf(this.zzJh)});
    }
}
