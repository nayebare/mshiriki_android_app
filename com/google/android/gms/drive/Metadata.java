package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzalh;
import com.google.android.gms.internal.zzalj;
import com.google.android.gms.internal.zzall;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public String getAlternateLink() {
        return (String) zza(zzalh.zzaNB);
    }

    public int getContentAvailability() {
        Integer num = (Integer) zza(zzall.zzaOz);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) zza(zzalj.zzaOs);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zzalh.zzaNC);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzAD();
    }

    public String getDescription() {
        return (String) zza(zzalh.zzaND);
    }

    public DriveId getDriveId() {
        return (DriveId) zza(zzalh.zzaNA);
    }

    public String getEmbedLink() {
        return (String) zza(zzalh.zzaNE);
    }

    public String getFileExtension() {
        return (String) zza(zzalh.zzaNF);
    }

    public long getFileSize() {
        return ((Long) zza(zzalh.zzaNG)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) zza(zzalj.zzaOt);
    }

    public String getMimeType() {
        return (String) zza(zzalh.zzaNX);
    }

    public Date getModifiedByMeDate() {
        return (Date) zza(zzalj.zzaOv);
    }

    public Date getModifiedDate() {
        return (Date) zza(zzalj.zzaOu);
    }

    public String getOriginalFilename() {
        return (String) zza(zzalh.zzaNY);
    }

    public long getQuotaBytesUsed() {
        return ((Long) zza(zzalh.zzaOd)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) zza(zzalj.zzaOw);
    }

    public String getTitle() {
        return (String) zza(zzalh.zzaOg);
    }

    public String getWebContentLink() {
        return (String) zza(zzalh.zzaOi);
    }

    public String getWebViewLink() {
        return (String) zza(zzalh.zzaOj);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zzalh.zzaNM);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zzalh.zzaNN);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zzalh.zzaNK);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zzall.zzaOA);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zzalh.zzaNP);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zzalh.zzaNR);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) zza(zzalh.zzaNS);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zzalh.zzaOe);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zzalh.zzaNV);
        return bool == null ? true : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zzalh.zzaOh);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zzalh.zzaNW);
        return bool == null ? false : bool.booleanValue();
    }

    public abstract <T> T zza(MetadataField<T> metadataField);
}
