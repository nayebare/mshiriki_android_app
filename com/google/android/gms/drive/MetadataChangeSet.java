package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzalh;
import com.google.android.gms.internal.zzalj;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzaJN;
    private final MetadataBundle zzaJO;

    public static class Builder {
        private final MetadataBundle zzaJO;
        private zza zzaJP;

        public Builder() {
            this.zzaJO = MetadataBundle.zzAI();
        }

        private int zzdL(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private void zzk(String str, int i, int i2) {
            zzac.zzb(i2 <= i, zzj(str, i, i2));
        }

        private zza zzzR() {
            if (this.zzaJP == null) {
                this.zzaJP = new zza();
            }
            return this.zzaJP;
        }

        public MetadataChangeSet build() {
            if (this.zzaJP != null) {
                this.zzaJO.zzc(zzalh.zzaNC, this.zzaJP.zzAE());
            }
            return new MetadataChangeSet(this.zzaJO);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            zzac.zzb((Object) customPropertyKey, (Object) "key");
            zzzR().zza(customPropertyKey, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            zzac.zzb((Object) customPropertyKey, (Object) "key");
            zzac.zzb((Object) str, (Object) "value");
            zzk("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzdL(customPropertyKey.getKey()) + zzdL(str));
            zzzR().zza(customPropertyKey, str);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzaJO.zzc(zzalh.zzaND, str);
            return this;
        }

        public Builder setIndexableText(String str) {
            zzk("Indexable text size", MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES, zzdL(str));
            this.zzaJO.zzc(zzalh.zzaNJ, str);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzaJO.zzc(zzalj.zzaOt, date);
            return this;
        }

        public Builder setMimeType(String str) {
            this.zzaJO.zzc(zzalh.zzaNX, str);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.zzaJO.zzc(zzalh.zzaNP, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.zzaJO.zzc(zzalh.zzaOe, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(String str) {
            this.zzaJO.zzc(zzalh.zzaOg, str);
            return this;
        }

        public Builder setViewed(boolean z) {
            this.zzaJO.zzc(zzalh.zzaNW, Boolean.valueOf(z));
            return this;
        }
    }

    static {
        zzaJN = new MetadataChangeSet(MetadataBundle.zzAI());
    }

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.zzaJO = metadataBundle.zzAJ();
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzaJO.zza(zzalh.zzaNC);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzAD();
    }

    public String getDescription() {
        return (String) this.zzaJO.zza(zzalh.zzaND);
    }

    public String getIndexableText() {
        return (String) this.zzaJO.zza(zzalh.zzaNJ);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzaJO.zza(zzalj.zzaOt);
    }

    public String getMimeType() {
        return (String) this.zzaJO.zza(zzalh.zzaNX);
    }

    public String getTitle() {
        return (String) this.zzaJO.zza(zzalh.zzaOg);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzaJO.zza(zzalh.zzaNP);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzaJO.zza(zzalh.zzaOe);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzaJO.zza(zzalh.zzaNW);
    }

    public <T> MetadataChangeSet zza(MetadataField<T> metadataField, T t) {
        MetadataChangeSet zzzQ = zzzQ();
        zzzQ.zzzP().zzc(metadataField, t);
        return zzzQ;
    }

    public MetadataBundle zzzP() {
        return this.zzaJO;
    }

    public MetadataChangeSet zzzQ() {
        return new MetadataChangeSet(zzzP());
    }
}
