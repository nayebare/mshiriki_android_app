package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zzf;
import com.google.android.gms.internal.zzahd;
import com.google.android.gms.internal.zzalh;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzaJL;

    private static class zza extends Metadata {
        private final int zzaCn;
        private final int zzaJM;
        private final DataHolder zzazI;

        public zza(DataHolder dataHolder, int i) {
            this.zzazI = dataHolder;
            this.zzaJM = i;
            this.zzaCn = dataHolder.zzcC(i);
        }

        public /* synthetic */ Object freeze() {
            return zzzO();
        }

        public boolean isDataValid() {
            return !this.zzazI.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzazI, this.zzaJM, this.zzaCn);
        }

        public Metadata zzzO() {
            MetadataBundle zzAI = MetadataBundle.zzAI();
            for (MetadataField metadataField : zzf.zzAG()) {
                if (metadataField != zzalh.zzaOf) {
                    metadataField.zza(this.zzazI, zzAI, this.zzaJM, this.zzaCn);
                }
            }
            return new zzahd(zzAI);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zzwy().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int i) {
        zza com_google_android_gms_drive_MetadataBuffer_zza = this.zzaJL;
        if (com_google_android_gms_drive_MetadataBuffer_zza != null && com_google_android_gms_drive_MetadataBuffer_zza.zzaJM == i) {
            return com_google_android_gms_drive_MetadataBuffer_zza;
        }
        Metadata com_google_android_gms_drive_MetadataBuffer_zza2 = new zza(this.zzazI, i);
        this.zzaJL = com_google_android_gms_drive_MetadataBuffer_zza2;
        return com_google_android_gms_drive_MetadataBuffer_zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzazI != null) {
            zzf.zza(this.zzazI);
        }
        super.release();
    }
}
