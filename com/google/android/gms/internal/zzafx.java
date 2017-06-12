package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.drive.events.zzj;

public class zzafx {
    private final zzj zzaKE;
    private final long zzaKF;
    private final long zzaKG;

    public zzafx(zzafz com_google_android_gms_internal_zzafz) {
        this.zzaKE = new zzafy(com_google_android_gms_internal_zzafz);
        this.zzaKF = com_google_android_gms_internal_zzafz.getBytesTransferred();
        this.zzaKG = com_google_android_gms_internal_zzafz.getTotalBytes();
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzafx com_google_android_gms_internal_zzafx = (zzafx) obj;
        return zzaa.equal(this.zzaKE, com_google_android_gms_internal_zzafx.zzaKE) && this.zzaKF == com_google_android_gms_internal_zzafx.zzaKF && this.zzaKG == com_google_android_gms_internal_zzafx.zzaKG;
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaKG), Long.valueOf(this.zzaKF), Long.valueOf(this.zzaKG));
    }

    public String toString() {
        return String.format("FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", new Object[]{this.zzaKE.toString(), Long.valueOf(this.zzaKF), Long.valueOf(this.zzaKG)});
    }
}
