package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zzalh;
import com.google.android.gms.internal.zzalj;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
    public static final SortableMetadataField<Date> MODIFIED_DATE;
    public static final SortableMetadataField<Long> QUOTA_USED;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
    public static final SortableMetadataField<String> TITLE;
    public static final SortableMetadataField<Date> zzaOL;

    static {
        TITLE = zzalh.zzaOg;
        CREATED_DATE = zzalj.zzaOs;
        MODIFIED_DATE = zzalj.zzaOu;
        MODIFIED_BY_ME_DATE = zzalj.zzaOv;
        LAST_VIEWED_BY_ME = zzalj.zzaOt;
        SHARED_WITH_ME_DATE = zzalj.zzaOw;
        QUOTA_USED = zzalh.zzaOd;
        zzaOL = zzalj.zzaOx;
    }
}
