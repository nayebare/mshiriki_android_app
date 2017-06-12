package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzalh;
import com.google.android.gms.internal.zzalj;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField<String> MIME_TYPE;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS;
    public static final SearchableMetadataField<Boolean> STARRED;
    public static final SearchableMetadataField<String> TITLE;
    public static final SearchableMetadataField<Boolean> TRASHED;
    public static final SearchableOrderedMetadataField<Date> zzaOH;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzaOI;

    static {
        TITLE = zzalh.zzaOg;
        MIME_TYPE = zzalh.zzaNX;
        TRASHED = zzalh.zzaOh;
        PARENTS = zzalh.zzaOc;
        zzaOH = zzalj.zzaOw;
        STARRED = zzalh.zzaOe;
        MODIFIED_DATE = zzalj.zzaOu;
        LAST_VIEWED_BY_ME = zzalj.zzaOt;
        IS_PINNED = zzalh.zzaNP;
        zzaOI = zzalh.zzaNC;
    }
}
